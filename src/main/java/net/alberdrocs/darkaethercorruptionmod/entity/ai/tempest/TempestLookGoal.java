package net.alberdrocs.darkaethercorruptionmod.entity.ai.tempest;

import net.alberdrocs.darkaethercorruptionmod.entity.custom.TempestEntity;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.phys.Vec3;

import java.util.EnumSet;

public class TempestLookGoal extends Goal {
    private final TempestEntity tempest;

    public TempestLookGoal(TempestEntity pTempest) {
        this.tempest = pTempest;
        this.setFlags(EnumSet.of(Goal.Flag.LOOK));
    }

    @Override
    public void tick() {
        if (this.tempest.getTarget() == null) {
            Vec3 vec3 = this.tempest.getDeltaMovement();
            this.tempest.setYRot(-((float) Mth.atan2(vec3.x, vec3.z)) * (180F / (float)Math.PI));
            this.tempest.yBodyRot = this.tempest.getYRot();
        } else {
            LivingEntity livingentity = this.tempest.getTarget();
            if (livingentity.distanceToSqr(this.tempest) < 4096.0D) {
                double d1 = livingentity.getX() - this.tempest.getX();
                double d2 = livingentity.getZ() - this.tempest.getZ();
                this.tempest.setYRot(-((float)Mth.atan2(d1, d2)) * (180F / (float)Math.PI));
                this.tempest.yBodyRot = this.tempest.getYRot();
            }
        }
    }

    @Override
    public boolean canUse() {
        return true;
    }

    @Override
    public boolean requiresUpdateEveryTick() {
        return true;
    }
}
