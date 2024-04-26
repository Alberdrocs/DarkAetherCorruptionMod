package net.alberdrocs.darkaethercorruptionmod.entity.ai.mimic;

import net.alberdrocs.darkaethercorruptionmod.entity.custom.MimicEntity;
import net.alberdrocs.darkaethercorruptionmod.sound.ModSounds;
import net.minecraft.world.entity.ai.goal.*;

public class MimicHideGoal extends Goal {
    private final MimicEntity entity;

    public MimicHideGoal(MimicEntity pMimic) {
        this.entity = pMimic;
    }

    @Override
    public void start() {
        this.entity.setHiding(true);
    }

    @Override
    public boolean canUse() {
        return !this.entity.isChasing();
    }


    @Override
    public void stop() {
        this.entity.setHiding(false);
        this.entity.playSound(ModSounds.MIMIC_SPAWN.get());
    }
}
