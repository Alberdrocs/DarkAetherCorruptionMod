package net.alberdrocs.darkaethercorruptionmod.entity.custom;

import net.alberdrocs.darkaethercorruptionmod.entity.ai.screamer.ScreamerChaseGoal;
import net.alberdrocs.darkaethercorruptionmod.sound.ModSounds;
import net.alberdrocs.darkaethercorruptionmod.worldgen.dimension.ModDimensions;
import net.minecraft.core.BlockPos;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Difficulty;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LightLayer;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.dimension.DimensionType;
import org.jetbrains.annotations.Nullable;

public class ScreamerEntity extends Monster {
    private static final EntityDataAccessor<Boolean> IMMOLATION =
            SynchedEntityData.defineId(ScreamerEntity.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Boolean> CHASING =
            SynchedEntityData.defineId(ScreamerEntity.class, EntityDataSerializers.BOOLEAN);

    public ScreamerEntity(EntityType<? extends Monster> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public final AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;
    public final AnimationState explosionAnimationState = new AnimationState();

    @Override
    public void tick() {
        super.tick();

        if (this.level().isClientSide()){
            setUpAnimationStates();
        }
    }

    private void setUpAnimationStates(){
        if (this.idleAnimationTimeout <= 0){
            this.idleAnimationTimeout = this.random.nextInt(10) + 20;
            this.idleAnimationState.start(this.tickCount);
        } else {
            --this.idleAnimationTimeout;
        }

        if (this.isImmolating()){
            explosionAnimationState.start(tickCount);
        }
    }

    @Override
    protected void updateWalkAnimation(float pPartialTick) {
        float f;
        if (this.getPose() == Pose.STANDING){
            f = Math.min(pPartialTick * 6f, 1f);
        } else {
            f = 0f;
        }
        this.walkAnimation.update(f, 0.2f);
    }

    public void setImmolation(boolean attacking){
        this.entityData.set(IMMOLATION, attacking);
    }

    public boolean isImmolating(){
        return this.entityData.get(IMMOLATION);
    }

    public void setChasing(boolean chasing){
        this.entityData.set(CHASING, chasing);
    }

    public boolean isChasing(){
        return this.entityData.get(CHASING);
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(IMMOLATION, false);
        this.entityData.define(CHASING, false);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new ScreamerChaseGoal(this, 1.0D, true));
        this.goalSelector.addGoal(2, new WaterAvoidingRandomStrollGoal(this, 1.0D));
        this.goalSelector.addGoal(3, new LookAtPlayerGoal(this, Player.class, 15.0f));
        this.goalSelector.addGoal(4, new RandomLookAroundGoal(this));

        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Player.class, true));
    }

    public static AttributeSupplier.Builder createAttributes(){
        return Monster.createMonsterAttributes()
                .add(Attributes.MAX_HEALTH, 50)
                .add(Attributes.MOVEMENT_SPEED, 0.27f)
                .add(Attributes.ARMOR_TOUGHNESS, 0.4f)
                .add(Attributes.ATTACK_KNOCKBACK, 0.5f)
                .add(Attributes.ATTACK_DAMAGE, 6.0f)
                .add(Attributes.ATTACK_SPEED, 2.0f);
    }

    public void explodeScreamer(){
        if (!this.level().isClientSide) {
            this.dead = true;
            this.level().explode(this, this.getX(), this.getY(), this.getZ(), 2.0F, true, Level.ExplosionInteraction.NONE);
            this.discard();
            this.spawnAnim(); //Spawns an explosion particle
            this.playSound(ModSounds.SCREAMER_EXPLOSION.get());
        }
    }

    public static boolean isDarkEnoughToSpawn(ServerLevelAccessor pLevel, BlockPos pPos, RandomSource pRandom) {
        if (pLevel.getLevel().dimensionTypeId() == ModDimensions.DARK_AETHER_DIMENSION_DIM_TYPE){
            return true;
        } else {
            return true;
        }
    }

    public static boolean checkMobSpawnRules(EntityType<? extends Mob> pType, LevelAccessor pLevel, MobSpawnType pSpawnType, BlockPos pPos, RandomSource pRandom) {
        return true;
    }

    /**
     * Static predicate for determining whether a monster can spawn at the provided location, incorporating a check of
     * the current light level at the location.
     */

    public static boolean checkMonsterSpawnRules(EntityType<? extends Monster> pType, ServerLevelAccessor pLevel, MobSpawnType pSpawnType, BlockPos pPos, RandomSource pRandom) {
        return pLevel.getDifficulty() != Difficulty.PEACEFUL && isDarkEnoughToSpawn(pLevel, pPos, pRandom) && checkMobSpawnRules(pType, pLevel, pSpawnType, pPos, pRandom);
    }

    /**
     * Static predicate for determining whether a monster can spawn at the provided location.
     */
    public static boolean checkAnyLightMonsterSpawnRules(EntityType<? extends Monster> pType, LevelAccessor pLevel, MobSpawnType pSpawnType, BlockPos pPos, RandomSource pRandom) {
        return pLevel.getDifficulty() != Difficulty.PEACEFUL && checkMobSpawnRules(pType, pLevel, pSpawnType, pPos, pRandom);
    }

    @Override
    public boolean checkSpawnRules(LevelAccessor pLevel, MobSpawnType pSpawnReason) {
        return true;
    }


    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {
        if (isChasing()){
            return ModSounds.SCREAMER_CHASE.get();
        } else {
            return ModSounds.DARK_AETHER_ZOMBIE_AMBIENT.get();
        }

    }

    @Nullable
    @Override
    protected SoundEvent getHurtSound(DamageSource pDamageSource) {
        return ModSounds.DARK_AETHER_ZOMBIE_ATTACK.get();
    }

    @Nullable
    @Override
    protected SoundEvent getDeathSound() {
        return null;
    }
}
