package net.alberdrocs.darkaethercorruptionmod.entity.ai.tempest;

import net.alberdrocs.darkaethercorruptionmod.entity.custom.TempestEntity;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.ai.goal.Goal;

import java.util.EnumSet;

public class TempestFloatAroundGoal extends Goal {
    private final TempestEntity tempest;

    public TempestFloatAroundGoal(TempestEntity pTempest){
        this.tempest = pTempest;
        this.setFlags(EnumSet.of(Goal.Flag.MOVE));
    }

    @Override
    public boolean canUse() {
        MoveControl movecontrol = this.tempest.getMoveControl();
        if (!movecontrol.hasWanted()) {
            return true;
        } else {
            double d0 = movecontrol.getWantedX() - this.tempest.getX();
            double d1 = movecontrol.getWantedY() - this.tempest.getY();
            double d2 = movecontrol.getWantedZ() - this.tempest.getZ();
            double d3 = d0 * d0 + d1 * d1 + d2 * d2;
            return d3 < 1.0D || d3 > 3600.0D;
        }
    }

    @Override
    public boolean canContinueToUse() {
        return false;
    }

    @Override
    public void start() {
        RandomSource randomsource = this.tempest.getRandom();
        double d0 = this.tempest.getX() + (double)((randomsource.nextFloat() * 2.0F - 1.0F) * 4.0F);
        double d1 = this.tempest.getY() + (double)((randomsource.nextFloat() * 2.0F - 1.0F) * 2.0F);
        double d2 = this.tempest.getZ() + (double)((randomsource.nextFloat() * 2.0F - 1.0F) * 4.0F);
        this.tempest.getMoveControl().setWantedPosition(d0, d1, d2, 1.0D);

    }
}
