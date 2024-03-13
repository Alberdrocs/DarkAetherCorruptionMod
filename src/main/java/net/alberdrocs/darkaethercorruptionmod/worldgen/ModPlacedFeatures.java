package net.alberdrocs.darkaethercorruptionmod.worldgen;

import net.alberdrocs.darkaethercorruptionmod.DarkAetherCorruptionMod;
import net.alberdrocs.darkaethercorruptionmod.block.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.features.TreeFeatures;
import net.minecraft.data.worldgen.features.VegetationFeatures;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

public class ModPlacedFeatures {

    //************************
    // TREE PLACEMENTS
    //************************


    public static final ResourceKey<PlacedFeature> CORRUPTED_TREES_PLAINS_KEY = registerKey("corrupted_trees_plains");
    public static final ResourceKey<PlacedFeature> CORRUPTED_FLOWER_PLAINS_KEY = registerKey("corrupted_flower_plains");
    public static final ResourceKey<PlacedFeature> CORRUPTED_PATCH_GRASS_PLAIN_KEY = registerKey("corrupted_patch_grass_plains");



    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> holdergetter = context.lookup(Registries.CONFIGURED_FEATURE);

        /*Holder<ConfiguredFeature<?, ?>> holder5 = holdergetter.getOrThrow(VegetationFeatures.PATCH_GRASS);
        Holder<ConfiguredFeature<?, ?>> holder22 = holdergetter.getOrThrow(VegetationFeatures.FLOWER_PLAIN);
        register(context, CORRUPTED_PATCH_GRASS_PLAIN_KEY, holder5, NoiseThresholdCountPlacement.of(-0.8D, 5, 10), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome());
        register(context, CORRUPTED_FLOWER_PLAINS_KEY, holder22, NoiseThresholdCountPlacement.of(-0.8D, 15, 4), RarityFilter.onAverageOnceEvery(32), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());
        register(context, CORRUPTED_TREES_PLAINS_KEY, holder25, PlacementUtils.countExtra(0, 0.05F, 1), InSquarePlacement.spread(), placementmodifier, PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, BlockPredicateFilter.forPredicate(BlockPredicate.wouldSurvive(Blocks.OAK_SAPLING.defaultBlockState(), BlockPos.ZERO)), BiomeFilter.biome());
*/
    }


    private static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(DarkAetherCorruptionMod.MOD_ID, name));
    }

    private static void register(BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }

    public static void register(BootstapContext<PlacedFeature> pContext, ResourceKey<PlacedFeature> pKey, Holder<ConfiguredFeature<?, ?>> pConfiguredFeatures, PlacementModifier... pPlacements) {
        register(pContext, pKey, pConfiguredFeatures, List.of(pPlacements));
    }
}
