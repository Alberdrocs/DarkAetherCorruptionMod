package net.alberdrocs.darkaethercorruptionmod.entity.ai.tempest;

import net.alberdrocs.darkaethercorruptionmod.entity.custom.TempestEntity;
import net.alberdrocs.darkaethercorruptionmod.sound.ModSounds;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Fireball;
import net.minecraft.world.entity.projectile.LargeFireball;
import net.minecraft.world.entity.projectile.SmallFireball;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

public class TempestAttackGoal extends Goal {
    private final TempestEntity entity;
    public int attackCharge;

    public TempestAttackGoal(TempestEntity pTempest) {
        this.entity = pTempest;
    }

    @Override
    public void start() {
        this.attackCharge = 0;
    }

    @Override
    public void stop() {
        this.entity.setAttacking(false);
    }

    @Override
    public boolean requiresUpdateEveryTick() {
        return true;
    }

    @Override
    public boolean canUse() {
        return this.entity.getTarget() != null;
    }

    @Override
    public void tick() {
        LivingEntity livingentity = this.entity.getTarget();
        if (livingentity != null) {
            double d0 = 64.0D;
            if (livingentity.distanceToSqr(this.entity) < 2500.0D && this.entity.hasLineOfSight(livingentity)) {
                this.entity.setAttacking(attackCharge >= 0);
                Level level = this.entity.level();
                ++this.attackCharge;

                if (this.attackCharge == this.entity.attackDelay) {
                    double d1 = 4.0D;
                    Vec3 vec3 = this.entity.getViewVector(1.0F);
                    double d2 = livingentity.getX() - (this.entity.getX() + vec3.x * 4.0D);
                    double d3 = livingentity.getY(0.5D) - (0.5D + this.entity.getY(0.5D));
                    double d4 = livingentity.getZ() - (this.entity.getZ() + vec3.z * 4.0D);

                    //TODO: Create a custom projectile for the Tempest
                    SmallFireball largefireball = new SmallFireball(level, this.entity, d2, d3, d4);
                    largefireball.setPos(this.entity.getX() + vec3.x * 4.0D, this.entity.getY(0.5D) + 0.5D, largefireball.getZ() + vec3.z * 4.0D);
                    level.addFreshEntity(largefireball);
                    this.attackCharge = -100;
                }
            }
            else if (this.attackCharge > 0) {
                --this.attackCharge;
            }
        }
    }
}
