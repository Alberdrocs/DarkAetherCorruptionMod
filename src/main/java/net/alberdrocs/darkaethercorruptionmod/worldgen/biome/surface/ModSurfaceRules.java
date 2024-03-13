package net.alberdrocs.darkaethercorruptionmod.worldgen.biome.surface;

import net.alberdrocs.darkaethercorruptionmod.block.ModBlocks;
import net.alberdrocs.darkaethercorruptionmod.worldgen.biome.ModBiomes;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.SurfaceRules;

public class ModSurfaceRules {
    private static final SurfaceRules.RuleSource CORRUPTED_DIRT = makeStateRule(ModBlocks.CORRUPTED_DIRT.get());
    private static final SurfaceRules.RuleSource CORRUPTED_GRASS_BLOCK = makeStateRule(ModBlocks.CORRUPTED_GRASS_BLOCK.get());

    public static SurfaceRules.RuleSource makeRules()
    {
        SurfaceRules.ConditionSource isAtOrAboveWaterLevel = SurfaceRules.waterBlockCheck(-1, 0);
        SurfaceRules.RuleSource grassSurface = SurfaceRules.sequence(SurfaceRules.ifTrue(isAtOrAboveWaterLevel, CORRUPTED_GRASS_BLOCK), CORRUPTED_DIRT);

        return SurfaceRules.sequence(
                // Default to a grass and dirt surface
                SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, grassSurface)
        );
    }

    private static SurfaceRules.RuleSource makeStateRule(Block block)
    {
        return SurfaceRules.state(block.defaultBlockState());
    }
}