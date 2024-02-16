package net.alberdrocs.darkaethercorruptionmod.entity.ai.screamer;

import net.alberdrocs.darkaethercorruptionmod.entity.custom.DarkAetherZombieEntity;
import net.alberdrocs.darkaethercorruptionmod.entity.custom.ScreamerEntity;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;

public class ScreamerChaseGoal extends MeleeAttackGoal {
    private final ScreamerEntity entity;
    private int explosionDelay = 15;
    private boolean immolationStarted = false;

    public ScreamerChaseGoal(PathfinderMob pMob, double pSpeedModifier, boolean pFollowingTargetEvenIfNotSeen) {
        super(pMob, pSpeedModifier, pFollowingTargetEvenIfNotSeen);
        entity = ((ScreamerEntity) pMob);
    }

    @Override
    public void start() {
        super.start();
        explosionDelay = 15;
        immolationStarted = false;
        entity.setChasing(true);
    }

    @Override
    protected void checkAndPerformAttack(LivingEntity pEnemy, double pDistToEnemySqr) {
        if (entity.isImmolating()){
            if(isTimeToAttack()) {
                this.mob.getLookControl().setLookAt(pEnemy.getX(), pEnemy.getEyeY(), pEnemy.getZ());
                performAttack(pEnemy);
            }
        } else if (isEnemyWithinAttackDistance(pEnemy, pDistToEnemySqr)) {
            entity.setImmolation(true);
            immolationStarted = true;
        }
    }

    private boolean isEnemyWithinAttackDistance(LivingEntity pEnemy, double pDistToEnemySqr) {
        return pDistToEnemySqr <= this.getAttackReachSqr(pEnemy);
    }

    protected boolean isTimeToAttack() {
        return this.explosionDelay <= 0;
    }

    protected void performAttack(LivingEntity pEnemy) {
        this.resetAttackCooldown();
        this.entity.explodeScreamer();
    }

    @Override
    public void tick() {
        super.tick();
        if (immolationStarted){
            this.explosionDelay = Math.max(this.explosionDelay - 1, 0);
        }
    }

    @Override
    public void stop() {
        entity.setChasing(false);
        super.stop();
    }
}