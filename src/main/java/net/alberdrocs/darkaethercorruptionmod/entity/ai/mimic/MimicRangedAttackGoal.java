package net.alberdrocs.darkaethercorruptionmod.entity.ai.mimic;

import net.alberdrocs.darkaethercorruptionmod.entity.custom.MimicEntity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.projectile.LargeFireball;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

public class MimicRangedAttackGoal extends Goal {
    private final MimicEntity entity;
    private int ticksUntilNextAttack = 100;
    private int shootCharge;

    public MimicRangedAttackGoal(MimicEntity pMimic) {
        this.entity = pMimic;
    }

    @Override
    public void start() {
        this.shootCharge = 0;
    }

    @Override
    public void stop() {
        this.entity.setShooting(false);
    }

    @Override
    public boolean canUse() {
        return (entity.isChasing() && !entity.isAttacking());
    }

    @Override
    public void tick() {
        if (this.ticksUntilNextAttack <= 0){
            this.performRangedAttack();
        } else {
            this.ticksUntilNextAttack = Math.max(this.ticksUntilNextAttack - 1, 0);
        }

    }

    private void performRangedAttack() {
        LivingEntity livingentity = this.entity.getTarget();
        if (livingentity != null) {
            if (livingentity.distanceToSqr(this.entity) < 4096.0D && this.entity.hasLineOfSight(livingentity) && livingentity.distanceToSqr(this.entity) > 64.0D) {
                this.entity.setShooting(shootCharge >= 0);
                Level level = this.entity.level();
                ++this.shootCharge;

                if (this.shootCharge == this.entity.shootingDelay) {
                    Vec3 vec3 = this.entity.getViewVector(1.0F);
                    double d2 = livingentity.getX() - (this.entity.getX() + vec3.x * 4.0D);
                    double d3 = livingentity.getY(0.5D) - (0.5D + this.entity.getY(0.5D));
                    double d4 = livingentity.getZ() - (this.entity.getZ() + vec3.z * 4.0D);

                    //TODO: Create a custom projectile for the Mimic
                    LargeFireball largefireball = new LargeFireball(level, this.entity, d2, d3, d4, 1);
                    largefireball.setPos(this.entity.getX() + vec3.x * 4.0D, this.entity.getY(0.5D) + 0.5D, largefireball.getZ() + vec3.z * 4.0D);
                    level.addFreshEntity(largefireball);
                    this.shootCharge = -100;
                }
            }
            else if (this.shootCharge > 0) {
                --this.shootCharge;
            }
        }
    }
}
