package net.alberdrocs.darkaethercorruptionmod.worldgen.tree;

import net.alberdrocs.darkaethercorruptionmod.worldgen.ModConfiguredFeatures;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import org.jetbrains.annotations.Nullable;

public class CorruptedMangroveTreeGrower extends AbstractTreeGrower {
    @Nullable
    @Override
    protected ResourceKey<ConfiguredFeature<?, ?>> getConfiguredFeature(RandomSource pRandom, boolean pHasFlowers) {
        return pRandom.nextFloat() < 0.85F ? ModConfiguredFeatures.CORRUPTED_TALL_MANGROVE_KEY : ModConfiguredFeatures.CORRUPTED_MANGROVE_KEY;
    }
}
