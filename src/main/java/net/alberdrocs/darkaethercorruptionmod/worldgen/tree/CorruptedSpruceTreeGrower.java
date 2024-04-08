package net.alberdrocs.darkaethercorruptionmod.worldgen.tree;

import net.alberdrocs.darkaethercorruptionmod.worldgen.ModConfiguredFeatures;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.grower.AbstractMegaTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import org.jetbrains.annotations.Nullable;

public class CorruptedSpruceTreeGrower extends AbstractMegaTreeGrower {
    @Nullable
    @Override
    protected ResourceKey<ConfiguredFeature<?, ?>> getConfiguredFeature(RandomSource pRandom, boolean pHasFlowers) {
        return ModConfiguredFeatures.CORRUPTED_SPRUCE_KEY;
    }

    @Nullable
    @Override
    protected ResourceKey<ConfiguredFeature<?, ?>> getConfiguredMegaFeature(RandomSource pRandom) {
        return pRandom.nextBoolean() ? ModConfiguredFeatures.CORRUPTED_MEGA_SPRUCE_KEY : ModConfiguredFeatures.CORRUPTED_MEGA_PINE_KEY;
    }
}
