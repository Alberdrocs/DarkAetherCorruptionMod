package net.alberdrocs.darkaethercorruptionmod.entity.ai.mimic;

import net.alberdrocs.darkaethercorruptionmod.entity.custom.MimicEntity;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.player.Player;

public class MimicHideGoal extends Goal {
    private final MimicEntity entity;
    private int timeToChange = 50;

    public MimicHideGoal(MimicEntity pMimic) {
        this.entity = pMimic;
    }

    @Override
    public void start() {
        this.entity.hideMimic(true);
    }

    @Override
    public boolean canUse() {
        return !this.entity.isChasing();
    }

    @Override
    public void tick() {

    }

    @Override
    public void stop() {
        this.entity.hideMimic(false);
    }
}
