package net.alberdrocs.darkaethercorruptionmod.entity.custom;

import net.alberdrocs.darkaethercorruptionmod.entity.ai.tempest.TempestFloatAroundGoal;
import net.alberdrocs.darkaethercorruptionmod.entity.ai.tempest.TempestLookGoal;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.FlyingMob;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class TempestEntity extends FlyingMob {
    private static final EntityDataAccessor<Boolean> ATTACKING =
            SynchedEntityData.defineId(TempestEntity.class, EntityDataSerializers.BOOLEAN);

    public TempestEntity(EntityType<? extends FlyingMob> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
        this.moveControl = new TempestEntity.TempestMoveControl(this);
    }

    public final AnimationState hoverAnimationState = new AnimationState();
    private int hoverAnimationTimeout = 0;
    public int teleportCooldown = 50;

    @Override
    public void tick() {
        super.tick();

        if (this.level().isClientSide()){
            setUpAnimationStates();
        }
    }

    private void setUpAnimationStates() {
        if (this.hoverAnimationTimeout <= 0){
            this.hoverAnimationTimeout = this.random.nextInt(30) + 60;
            this.hoverAnimationState.start(this.tickCount);
        } else {
            --this.hoverAnimationTimeout;
        }
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new TempestFloatAroundGoal(this));
        this.goalSelector.addGoal(1, new TempestLookGoal(this));

        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(
                this, Player.class, 10, true, false,
                (p_289460_) -> Math.abs(p_289460_.getY() - this.getY()) <= 4.0D));
    }

    public static AttributeSupplier.Builder createAttributes(){
        return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 10.0D).add(Attributes.FOLLOW_RANGE, 100.0D);
    }

    public void setAttacking(boolean attacking){
        this.entityData.set(ATTACKING, attacking);
    }

    public boolean isAttacking(){
        return this.entityData.get(ATTACKING);
    }

    static class TempestMoveControl extends MoveControl{
        private final TempestEntity tempest;
        private int floatDuration;

        public TempestMoveControl(Mob pMob) {
            super(pMob);
            this.tempest = (TempestEntity) pMob;
        }

        public void tick() {
            if (this.operation == MoveControl.Operation.MOVE_TO) {
                if (this.floatDuration-- <= 0) {
                    this.floatDuration += this.tempest.getRandom().nextInt(5) + 2;
                    Vec3 vec3 = new Vec3(this.wantedX - this.tempest.getX(), this.wantedY - this.tempest.getY(), this.wantedZ - this.tempest.getZ());
                    double d0 = vec3.length();
                    vec3 = vec3.normalize();
                    if (this.canReach(vec3, Mth.ceil(d0))) {
                        this.tempest.setDeltaMovement(this.tempest.getDeltaMovement().add(vec3.scale(0.1D)));
                    } else {
                        this.operation = MoveControl.Operation.WAIT;
                    }
                }

            }
        }

        private boolean canReach(Vec3 pPos, int pLength) {
            AABB aabb = this.tempest.getBoundingBox();

            for(int i = 1; i < pLength; ++i) {
                aabb = aabb.move(pPos);
                if (!this.tempest.level().noCollision(this.tempest, aabb)) {
                    return false;
                }
            }

            return true;
        }

    }
}
