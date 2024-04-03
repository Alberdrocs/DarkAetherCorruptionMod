package net.alberdrocs.darkaethercorruptionmod.entity.ai.tempest;

import net.alberdrocs.darkaethercorruptionmod.entity.custom.TempestEntity;
import net.alberdrocs.darkaethercorruptionmod.sound.ModSounds;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class TempestTeleportGoal extends Goal {
    private final TempestEntity entity;
    private int ticksUntilNextTeleport = 50;
    private int teleportDelay = 5;
    private boolean teleportActionStarted = false;

    public TempestTeleportGoal(TempestEntity pTempest) {
        this.entity = pTempest;
        ticksUntilNextTeleport = this.entity.teleportCooldown;
    }

    @Override
    public boolean canUse() {
        return true;
    }

    @Override
    public void start() {

    }

    @Override
    public void tick() {
        if (!this.entity.isAttacking()){
            this.ticksUntilNextTeleport = Math.max(this.ticksUntilNextTeleport - 1, 0);
        }
        this.checkAndPerformTeleport();
    }

    private void checkAndPerformTeleport() {
        if (ticksUntilNextTeleport <= teleportDelay){

            //Get a 50/50 chance to start a teleport
            if (entity.getRandom().nextBoolean() && !entity.isTeleporting()){
                resetTeleportCooldown();
                return;
            }

            entity.setTeleporting(true);

            if (isTimeToTeleport()){
                performTeleport();
                this.entity.playSound(ModSounds.TEMPEST_TELEPORT.get());
            }
        } else {
            this.entity.setTeleporting(false);
            entity.teleportAnimationTimeout = 0;
        }
    }

    private void resetTeleportCooldown(){
        ticksUntilNextTeleport = this.adjustedTickDelay(this.entity.teleportCooldown * 2);
    }

    private boolean isTimeToTeleport() {
        return this.ticksUntilNextTeleport <= 0;
    }

    private void performTeleport() {
        resetTeleportCooldown();
        double d0 = this.entity.getMoveControl().getWantedX();
        double d1 = this.entity.getMoveControl().getWantedY();
        double d2 = this.entity.getMoveControl().getWantedZ();

        d0 += this.entity.getRandom().nextInt(-12,12);
        d2 += this.entity.getRandom().nextInt(-12,12);

        Vec3 vec3 = new Vec3(d0 - this.entity.getX(), d1 - this.entity.getY(), d2 - this.entity.getZ());
        double d3 = vec3.length();
        vec3 = vec3.normalize();
        if (this.canReach(vec3, Mth.ceil(d3))) {
            this.entity.teleportTo(d0, d1, d2);
            this.entity.getMoveControl().setWantedPosition(d0, d1, d2, 1.0D);
        }
    }

    private boolean canReach(Vec3 pPos, int pLength) {
        AABB aabb = this.entity.getBoundingBox();

        for(int i = 1; i < pLength; ++i) {
            aabb = aabb.move(pPos);
            if (!this.entity.level().noCollision(this.entity, aabb)) {
                return false;
            }
        }

        return true;
    }

}
