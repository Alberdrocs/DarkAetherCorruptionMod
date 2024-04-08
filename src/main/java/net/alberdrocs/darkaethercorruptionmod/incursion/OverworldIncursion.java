package net.alberdrocs.darkaethercorruptionmod.incursion;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;

public class OverworldIncursion {
    private static final String[] CORRUPTION_LEVELS = {"SMALL", "ADVANCED", "CRITICAL", "APOCALYPTIC"};
    private static final int[] ZOMBIES_THRESHOLD_SPAWN_LIMIT = {3, 8, 15, 25};
    private static final int[] SCREAMER_THRESHOLD_SPAWN_LIMIT = {1, 3, 7, 13};
    private static final int[] MIMIC_THRESHOLD_SPAWN_LIMIT = {0, 1, 3, 6};
    private Entity[] zombieList;
    private Entity[] screamerList;
    private Entity[] mimicList;
    private final BlockPos center;
    private final ServerLevel level;
    private boolean ended = false;
    private final int id;

    public OverworldIncursion(BlockPos center, ServerLevel level, int id) {
        this.center = center;
        this.level = level;
        this.id = id;
    }
}
