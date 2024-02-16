package net.alberdrocs.darkaethercorruptionmod.entity.ai.tempest;

import net.alberdrocs.darkaethercorruptionmod.entity.custom.TempestEntity;
import net.minecraft.world.entity.ai.goal.Goal;

public class TempestTeleportGoal extends Goal {
    private final TempestEntity tempest;
    private int ticksUntilNextTeleport = 50;

    public TempestTeleportGoal(TempestEntity pTempest) {
        this.tempest = pTempest;
        ticksUntilNextTeleport = this.tempest.teleportCooldown;
    }

    @Override
    public boolean canUse() {
        if (tempest.teleportCooldown <= 0){
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void tick() {
        if (!this.tempest.isAttacking()){
            this.ticksUntilNextTeleport = Math.max(this.ticksUntilNextTeleport - 1, 0);
        }

    }
}
