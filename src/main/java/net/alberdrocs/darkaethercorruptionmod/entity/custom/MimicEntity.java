package net.alberdrocs.darkaethercorruptionmod.entity.custom;

import net.alberdrocs.darkaethercorruptionmod.entity.ai.mimic.MimicAttackGoal;
import net.alberdrocs.darkaethercorruptionmod.entity.ai.mimic.MimicHideGoal;
import net.alberdrocs.darkaethercorruptionmod.entity.ai.mimic.MimicRangedAttackGoal;
import net.alberdrocs.darkaethercorruptionmod.worldgen.dimension.ModDimensions;
import net.minecraft.core.BlockPos;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Difficulty;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ServerLevelAccessor;

public class MimicEntity extends Monster {
    private static final EntityDataAccessor<Boolean> ATTACKING =
            SynchedEntityData.defineId(MimicEntity.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Boolean> SHOOTING =
            SynchedEntityData.defineId(MimicEntity.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Boolean> CHASING =
            SynchedEntityData.defineId(MimicEntity.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Boolean> HIDING =
            SynchedEntityData.defineId(MimicEntity.class, EntityDataSerializers.BOOLEAN);
    private WaterAvoidingRandomStrollGoal waterAvoidStrollGoal;
    private LookAtPlayerGoal lookAtPlayerGoal;
    private RandomLookAroundGoal lookAroundGoal;

    public MimicEntity(EntityType<? extends Monster> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);

    }

    public final AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;
    public final AnimationState attackAnimationState = new AnimationState();
    public int attackAnimationTimeout = 0;
    public final AnimationState shootingAnimationState = new AnimationState();
    public int shootingAnimationTimeout = 0;
    public int shootingDelay = 5;

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

        if (this.isAttacking() && this.attackAnimationTimeout <= 0){
            attackAnimationTimeout = 5; //Length in ticks of animation
            attackAnimationState.start(tickCount);
        } else {
            --this.attackAnimationTimeout;
        }

        if (!this.isAttacking()){
            attackAnimationState.stop();
        }

        if (this.isShooting() && this.shootingAnimationTimeout <= 0){
            shootingAnimationTimeout = 8; //Length in ticks of animation
            shootingAnimationState.start(tickCount);
        } else {
            --this.shootingAnimationTimeout;
        }

        if (!this.isShooting()){
            shootingAnimationState.stop();
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

    public void setAttacking(boolean attacking){
        this.entityData.set(ATTACKING, attacking);
    }

    public boolean isAttacking(){
        return this.entityData.get(ATTACKING);
    }

    public void setShooting(boolean shooting){
        this.entityData.set(SHOOTING, shooting);
    }

    public boolean isShooting(){
        return this.entityData.get(SHOOTING);
    }

    public void setChasing(boolean chasing){
        this.entityData.set(CHASING, chasing);
    }

    public boolean isChasing(){
        return this.entityData.get(CHASING);
    }

    public void setHiding(boolean hiding){
        this.entityData.set(HIDING, hiding);
    }

    public boolean isHiding(){
        return this.entityData.get(HIDING);
    }

    public void hideMimic(boolean isHiding){
        setHiding(isHiding);
        /*if (isHiding){
            this.goalSelector.removeGoal(waterAvoidStrollGoal);
            this.goalSelector.removeGoal(lookAtPlayerGoal);
            this.goalSelector.removeGoal(lookAroundGoal);
        } else {
            this.goalSelector.removeAllGoals(new Predicate<net.minecraft.world.entity.ai.goal.Goal>() {
                @Override
                public boolean test(net.minecraft.world.entity.ai.goal.Goal goal) {
                    return true;
                }
            });

            this.goalSelector.addGoal(1, new MimicAttackGoal(this, 1.0D, true));
            this.goalSelector.addGoal(2, new MimicHideGoal(this));
            this.goalSelector.addGoal(3, waterAvoidStrollGoal);
            this.goalSelector.addGoal(4, lookAtPlayerGoal);
            this.goalSelector.addGoal(5, lookAroundGoal);

            this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Player.class, true));

        }*/
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(ATTACKING, false);
        this.entityData.define(SHOOTING, false);
        this.entityData.define(CHASING, false);
        this.entityData.define(HIDING, false);
    }

    @Override
    protected void registerGoals() {
        //waterAvoidStrollGoal = new WaterAvoidingRandomStrollGoal(this, 1.0D);
        //lookAtPlayerGoal = new LookAtPlayerGoal(this, Player.class, 15.0f);
        //lookAroundGoal = new RandomLookAroundGoal(this);
        this.goalSelector.addGoal(0, new MimicRangedAttackGoal(this));
        this.goalSelector.addGoal(1, new MimicAttackGoal(this, 1.0D, true));
        this.goalSelector.addGoal(2, new MimicHideGoal(this));

        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Player.class, true));
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Monster.createMonsterAttributes()
                .add(Attributes.MAX_HEALTH, 70)
                .add(Attributes.MOVEMENT_SPEED, 0.33f)
                .add(Attributes.ARMOR_TOUGHNESS, 0.4f)
                .add(Attributes.ATTACK_KNOCKBACK, 0.5f)
                .add(Attributes.ATTACK_DAMAGE, 6.0f)
                .add(Attributes.ATTACK_SPEED, 2.0f)
                .add(Attributes.KNOCKBACK_RESISTANCE, 0.8f);
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


}
