package net.alberdrocs.darkaethercorruptionmod.worldgen;

import com.google.common.collect.ImmutableList;
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

import net.minecraft.util.valueproviders.ClampedInt;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Block;
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
    public static final ResourceKey<PlacedFeature> CORRUPTED_OAK_CHECKED = registerKey("corrupted_oak_checked");
    public static final ResourceKey<PlacedFeature> CORRUPTED_DARK_OAK_CHECKED = registerKey("corrupted_dark_oak_checked");
    public static final ResourceKey<PlacedFeature> CORRUPTED_BIRCH_CHECKED = registerKey("corrupted_birch_checked");
    public static final ResourceKey<PlacedFeature> CORRUPTED_ACACIA_CHECKED = registerKey("corrupted_acacia_checked");
    public static final ResourceKey<PlacedFeature> CORRUPTED_SPRUCE_CHECKED = registerKey("corrupted_spruce_checked");
    public static final ResourceKey<PlacedFeature> CORRUPTED_MANGROVE_CHECKED = registerKey("corrupted_mangrove_checked");
    public static final ResourceKey<PlacedFeature> CORRUPTED_CHERRY_CHECKED = registerKey("corrupted_cherry_checked");
    public static final ResourceKey<PlacedFeature> CORRUPTED_PINE_CHECKED = registerKey("corrupted_pine_checked");
    public static final ResourceKey<PlacedFeature> CORRUPTED_JUNGLE_TREE_CHECKED = registerKey("corrupted_jungle_tree");
    public static final ResourceKey<PlacedFeature> CORRUPTED_FANCY_OAK_CHECKED = registerKey("corrupted_fancy_oak_checked");
    public static final ResourceKey<PlacedFeature> CORRUPTED_MEGA_JUNGLE_TREE_CHECKED = registerKey("corrupted_mega_jungle_tree_checked");
    public static final ResourceKey<PlacedFeature> CORRUPTED_MEGA_SPRUCE_CHECKED = registerKey("corrupted_mega_spruce_checked");
    public static final ResourceKey<PlacedFeature> CORRUPTED_MEGA_PINE_CHECKED = registerKey("corrupted_mega_pine_checked");
    public static final ResourceKey<PlacedFeature> CORRUPTED_TALL_MANGROVE_CHECKED = registerKey("corrupted_tall_mangrove_checked");
    public static final ResourceKey<PlacedFeature> CORRUPTED_JUNGLE_BUSH = registerKey("corrupted_jungle_bush");

    //************************
    // VEGETATION PLACEMENTS
    //************************
    public static final ResourceKey<PlacedFeature> CORRUPTED_PATCH_GRASS_PLAIN = registerKey("corrupted_patch_grass_plain");
    public static final ResourceKey<PlacedFeature> CORRUPTED_PATCH_GRASS_FOREST = registerKey("corrupted_patch_grass_forest");
    public static final ResourceKey<PlacedFeature> CORRUPTED_PATCH_GRASS_BADLANDS = registerKey("corrupted_patch_grass_badlands");
    public static final ResourceKey<PlacedFeature> CORRUPTED_PATCH_GRASS_SAVANNA = registerKey("corrupted_patch_grass_savanna");
    public static final ResourceKey<PlacedFeature> CORRUPTED_PATCH_GRASS_NORMAL = registerKey("corrupted_patch_grass_normal");
    public static final ResourceKey<PlacedFeature> CORRUPTED_PATCH_GRASS_TAIGA_2 = registerKey("corrupted_patch_grass_taiga_2");
    public static final ResourceKey<PlacedFeature> CORRUPTED_PATCH_GRASS_TAIGA = registerKey("corrupted_patch_grass_taiga");
    public static final ResourceKey<PlacedFeature> CORRUPTED_PATCH_GRASS_JUNGLE = registerKey("corrupted_patch_grass_jungle");
    public static final ResourceKey<PlacedFeature> CORRUPTED_GRASS_BONEMEAL = registerKey("corrupted_grass_bonemeal");
    public static final ResourceKey<PlacedFeature> CORRUPTED_PATCH_DEAD_BUSH_2 = registerKey("corrupted_patch_dead_bush_2");
    public static final ResourceKey<PlacedFeature> CORRUPTED_PATCH_DEAD_BUSH = registerKey("corrupted_patch_dead_bush");
    public static final ResourceKey<PlacedFeature> CORRUPTED_PATCH_DEAD_BUSH_BADLANDS = registerKey("corrupted_patch_dead_bush_badlands");
    public static final ResourceKey<PlacedFeature> CORRUPTED_PATCH_TALL_GRASS_2 = registerKey("corrupted_patch_tall_grass_2");
    public static final ResourceKey<PlacedFeature> CORRUPTED_PATCH_TALL_GRASS = registerKey("corrupted_patch_tall_grass");
    public static final ResourceKey<PlacedFeature> CORRUPTED_PATCH_LARGE_FERN = registerKey("corrupted_patch_large_fern");
    public static final ResourceKey<PlacedFeature> CORRUPTED_TREES_PLAINS = registerKey("corrupted_trees_plains");
    public static final ResourceKey<PlacedFeature> CORRUPTED_DARK_FOREST_VEGETATION = registerKey("corrupted_dark_forest_vegetation");
    public static final ResourceKey<PlacedFeature> CORRUPTED_TREES_MEADOW = registerKey("corrupted_trees_meadow");
    public static final ResourceKey<PlacedFeature> CORRUPTED_TREES_CHERRY = registerKey("corrupted_trees_cherry");
    public static final ResourceKey<PlacedFeature> CORRUPTED_TREES_TAIGA = registerKey("corrupted_trees_taiga");
    public static final ResourceKey<PlacedFeature> CORRUPTED_TREES_GROVE = registerKey("corrupted_trees_grove");
    public static final ResourceKey<PlacedFeature> CORRUPTED_TREES_BADLANDS = registerKey("corrupted_trees_badlands");
    public static final ResourceKey<PlacedFeature> CORRUPTED_TREES_SNOWY = registerKey("corrupted_trees_snowy");
    public static final ResourceKey<PlacedFeature> CORRUPTED_TREES_SWAMP = registerKey("corrupted_trees_swamp");
    public static final ResourceKey<PlacedFeature> CORRUPTED_TREES_WINDSWEPT_SAVANNA = registerKey("corrupted_trees_windswept_savanna");
    public static final ResourceKey<PlacedFeature> CORRUPTED_TREES_SAVANNA = registerKey("corrupted_trees_savanna");
    public static final ResourceKey<PlacedFeature> CORRUPTED_BIRCH_TALL = registerKey("corrupted_birch_tall");
    public static final ResourceKey<PlacedFeature> CORRUPTED_TREES_BIRCH = registerKey("corrupted_trees_birch");
    public static final ResourceKey<PlacedFeature> CORRUPTED_TREES_WINDSWEPT_FOREST = registerKey("corrupted_trees_windswept_forest");
    public static final ResourceKey<PlacedFeature> CORRUPTED_TREES_WINDSWEPT_HILLS = registerKey("corrupted_trees_windswept_hills");
    public static final ResourceKey<PlacedFeature> CORRUPTED_TREES_WATER = registerKey("corrupted_trees_water");
    public static final ResourceKey<PlacedFeature> CORRUPTED_TREES_BIRCH_AND_OAK = registerKey("corrupted_trees_birch_and_oak");
    public static final ResourceKey<PlacedFeature> CORRUPTED_TREES_SPARSE_JUNGLE = registerKey("corrupted_trees_sparse_jungle");
    public static final ResourceKey<PlacedFeature> CORRUPTED_TREES_OLD_GROWTH_SPRUCE_TAIGA = registerKey("corrupted_trees_old_growth_spruce_taiga");
    public static final ResourceKey<PlacedFeature> CORRUPTED_TREES_OLD_GROWTH_PINE_TAIGA = registerKey("corrupted_trees_old_growth_pine_taiga");
    public static final ResourceKey<PlacedFeature> CORRUPTED_TREES_JUNGLE = registerKey("corrupted_trees_jungle");
    public static final ResourceKey<PlacedFeature> CORRUPTED_TREES_MANGROVE = registerKey("corrupted_trees_mangrove");
    public static final ResourceKey<PlacedFeature> CORRUPTED_BAMBOO_VEGETATION = registerKey("corrupted_bamboo_vegetation");
    public static final ResourceKey<PlacedFeature> CORRUPTED_MUSHROOM_ISLAND_VEGETATION = registerKey("corrupted_mushroom_island_vegetation");
    private static final PlacementModifier TREE_THRESHOLD = SurfaceWaterDepthFilter.forMaxDepth(0);


    public static final ResourceKey<PlacedFeature> PATCH_SMALL_DARK_AETHER_CRYSTAL_ORE = registerKey("patch_small_dark_aether_crystal_ore");
    public static final ResourceKey<PlacedFeature> PATCH_BIG_DARK_AETHER_CRYSTAL_ORE = registerKey("patch_big_dark_aether_crystal_ore");

    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> holdergetter = context.lookup(Registries.CONFIGURED_FEATURE);
        //************************
        // TREE PLACEMENTS
        //************************
        Holder<ConfiguredFeature<?, ?>> treePlcmntHolder2 = holdergetter.getOrThrow(ModConfiguredFeatures.CORRUPTED_OAK_KEY);
        Holder<ConfiguredFeature<?, ?>> treePlcmntHolder3 = holdergetter.getOrThrow(ModConfiguredFeatures.CORRUPTED_DARK_OAK_KEY);
        Holder<ConfiguredFeature<?, ?>> treePlcmntHolder4 = holdergetter.getOrThrow(ModConfiguredFeatures.CORRUPTED_BIRCH_KEY);
        Holder<ConfiguredFeature<?, ?>> treePlcmntHolder5 = holdergetter.getOrThrow(ModConfiguredFeatures.CORRUPTED_ACACIA_KEY);
        Holder<ConfiguredFeature<?, ?>> treePlcmntHolder6 = holdergetter.getOrThrow(ModConfiguredFeatures.CORRUPTED_SPRUCE_KEY);
        Holder<ConfiguredFeature<?, ?>> treePlcmntHolder7 = holdergetter.getOrThrow(ModConfiguredFeatures.CORRUPTED_MANGROVE_KEY);
        Holder<ConfiguredFeature<?, ?>> treePlcmntHolder8 = holdergetter.getOrThrow(ModConfiguredFeatures.CORRUPTED_CHERRY_KEY);
        Holder<ConfiguredFeature<?, ?>> treePlcmntHolder9 = holdergetter.getOrThrow(ModConfiguredFeatures.CORRUPTED_PINE_KEY);
        Holder<ConfiguredFeature<?, ?>> treePlcmntHolder10 = holdergetter.getOrThrow(ModConfiguredFeatures.CORRUPTED_JUNGLE_TREE_KEY);
        Holder<ConfiguredFeature<?, ?>> treePlcmntHolder11 = holdergetter.getOrThrow(ModConfiguredFeatures.CORRUPTED_FANCY_OAK_KEY);
        Holder<ConfiguredFeature<?, ?>> treePlcmntHolder12 = holdergetter.getOrThrow(ModConfiguredFeatures.CORRUPTED_MEGA_JUNGLE_TREE_KEY);
        Holder<ConfiguredFeature<?, ?>> treePlcmntHolder13 = holdergetter.getOrThrow(ModConfiguredFeatures.CORRUPTED_MEGA_SPRUCE_KEY);
        Holder<ConfiguredFeature<?, ?>> treePlcmntHolder14 = holdergetter.getOrThrow(ModConfiguredFeatures.CORRUPTED_MEGA_PINE_KEY);
        Holder<ConfiguredFeature<?, ?>> treePlcmntHolder15 = holdergetter.getOrThrow(ModConfiguredFeatures.CORRUPTED_TALL_MANGROVE_KEY);
        Holder<ConfiguredFeature<?, ?>> treePlcmntHolder16 = holdergetter.getOrThrow(ModConfiguredFeatures.CORRUPTED_JUNGLE_BUSH_KEY);

        register(context, CORRUPTED_OAK_CHECKED, treePlcmntHolder2, PlacementUtils.filteredByBlockSurvival(ModBlocks.CORRUPTED_OAK_SAPLING.get()));
        register(context, CORRUPTED_DARK_OAK_CHECKED, treePlcmntHolder3, PlacementUtils.filteredByBlockSurvival(ModBlocks.CORRUPTED_DARK_OAK_SAPLING.get()));
        register(context, CORRUPTED_BIRCH_CHECKED, treePlcmntHolder4, PlacementUtils.filteredByBlockSurvival(ModBlocks.CORRUPTED_BIRCH_SAPLING.get()));
        register(context, CORRUPTED_ACACIA_CHECKED, treePlcmntHolder5, PlacementUtils.filteredByBlockSurvival(ModBlocks.CORRUPTED_ACACIA_SAPLING.get()));
        register(context, CORRUPTED_SPRUCE_CHECKED, treePlcmntHolder6, PlacementUtils.filteredByBlockSurvival(ModBlocks.CORRUPTED_SPRUCE_SAPLING.get()));
        register(context, CORRUPTED_MANGROVE_CHECKED, treePlcmntHolder7, PlacementUtils.filteredByBlockSurvival(ModBlocks.CORRUPTED_MANGROVE_PROPAGULE.get()));
        register(context, CORRUPTED_CHERRY_CHECKED, treePlcmntHolder8, PlacementUtils.filteredByBlockSurvival(ModBlocks.CORRUPTED_CHERRY_SAPLING.get()));
        register(context, CORRUPTED_PINE_CHECKED, treePlcmntHolder9, PlacementUtils.filteredByBlockSurvival(Blocks.SPRUCE_SAPLING));
        register(context, CORRUPTED_JUNGLE_TREE_CHECKED, treePlcmntHolder10, PlacementUtils.filteredByBlockSurvival(Blocks.JUNGLE_SAPLING));
        register(context, CORRUPTED_FANCY_OAK_CHECKED, treePlcmntHolder11, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));
        register(context, CORRUPTED_MEGA_JUNGLE_TREE_CHECKED, treePlcmntHolder12, PlacementUtils.filteredByBlockSurvival(Blocks.JUNGLE_SAPLING));
        register(context, CORRUPTED_MEGA_SPRUCE_CHECKED, treePlcmntHolder13, PlacementUtils.filteredByBlockSurvival(Blocks.SPRUCE_SAPLING));
        register(context, CORRUPTED_MEGA_PINE_CHECKED, treePlcmntHolder14, PlacementUtils.filteredByBlockSurvival(Blocks.SPRUCE_SAPLING));
        register(context, CORRUPTED_TALL_MANGROVE_CHECKED, treePlcmntHolder15, PlacementUtils.filteredByBlockSurvival(Blocks.MANGROVE_PROPAGULE));
        register(context, CORRUPTED_JUNGLE_BUSH, treePlcmntHolder16, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));

        //************************
        // VEGETATION PLACEMENTS
        //************************
        Holder<ConfiguredFeature<?, ?>> holder5 = holdergetter.getOrThrow(ModConfiguredFeatures.CORRUPTED_PATCH_GRASS);
        Holder<ConfiguredFeature<?, ?>> holder6 = holdergetter.getOrThrow(ModConfiguredFeatures.CORRUPTED_PATCH_TAIGA_GRASS);
        Holder<ConfiguredFeature<?, ?>> holder7 = holdergetter.getOrThrow(ModConfiguredFeatures.CORRUPTED_PATCH_GRASS_JUNGLE);
        Holder<ConfiguredFeature<?, ?>> holder8 = holdergetter.getOrThrow(ModConfiguredFeatures.CORRUPTED_SINGLE_PIECE_OF_GRASS);
        Holder<ConfiguredFeature<?, ?>> holder9 = holdergetter.getOrThrow(ModConfiguredFeatures.CORRUPTED_PATCH_DEAD_BUSH);
        Holder<ConfiguredFeature<?, ?>> holder13 = holdergetter.getOrThrow(ModConfiguredFeatures.CORRUPTED_PATCH_TALL_GRASS);
        Holder<ConfiguredFeature<?, ?>> holder14 = holdergetter.getOrThrow(ModConfiguredFeatures.CORRUPTED_PATCH_LARGE_FERN);
        Holder<ConfiguredFeature<?, ?>> holder25 = holdergetter.getOrThrow(ModConfiguredFeatures.CORRUPTED_TREES_PLAINS);
        Holder<ConfiguredFeature<?, ?>> holder26 = holdergetter.getOrThrow(ModConfiguredFeatures.CORRUPTED_DARK_FOREST_VEGETATION);
        Holder<ConfiguredFeature<?, ?>> holder29 = holdergetter.getOrThrow(ModConfiguredFeatures.CORRUPTED_MEADOW_TREES);
        Holder<ConfiguredFeature<?, ?>> holder30 = holdergetter.getOrThrow(ModConfiguredFeatures.CORRUPTED_TREES_TAIGA);
        Holder<ConfiguredFeature<?, ?>> holder31 = holdergetter.getOrThrow(ModConfiguredFeatures.CORRUPTED_TREES_GROVE);
        Holder<ConfiguredFeature<?, ?>> holder32 = holdergetter.getOrThrow(ModConfiguredFeatures.CORRUPTED_OAK_KEY);
        Holder<ConfiguredFeature<?, ?>> holder33 = holdergetter.getOrThrow(ModConfiguredFeatures.CORRUPTED_SPRUCE_KEY);
        Holder<ConfiguredFeature<?, ?>> holder34 = holdergetter.getOrThrow(ModConfiguredFeatures.CORRUPTED_CHERRY_KEY);
        Holder<ConfiguredFeature<?, ?>> holder35 = holdergetter.getOrThrow(ModConfiguredFeatures.CORRUPTED_SWAMP_OAK_KEY);
        Holder<ConfiguredFeature<?, ?>> holder36 = holdergetter.getOrThrow(ModConfiguredFeatures.CORRUPTED_TREES_SAVANNA);
        Holder<ConfiguredFeature<?, ?>> holder37 = holdergetter.getOrThrow(ModConfiguredFeatures.CORRUPTED_BIRCH_TALL);
        Holder<ConfiguredFeature<?, ?>> holder39 = holdergetter.getOrThrow(ModConfiguredFeatures.CORRUPTED_TREES_WINDSWEPT_HILLS);
        Holder<ConfiguredFeature<?, ?>> holder40 = holdergetter.getOrThrow(ModConfiguredFeatures.CORRUPTED_TREES_WATER);
        Holder<ConfiguredFeature<?, ?>> holder41 = holdergetter.getOrThrow(ModConfiguredFeatures.CORRUPTED_TREES_BIRCH_AND_OAK);
        Holder<ConfiguredFeature<?, ?>> holder42 = holdergetter.getOrThrow(ModConfiguredFeatures.CORRUPTED_TREES_SPARSE_JUNGLE);
        Holder<ConfiguredFeature<?, ?>> holder43 = holdergetter.getOrThrow(ModConfiguredFeatures.CORRUPTED_TREES_OLD_GROWTH_SPRUCE_TAIGA);
        Holder<ConfiguredFeature<?, ?>> holder44 = holdergetter.getOrThrow(ModConfiguredFeatures.CORRUPTED_TREES_OLD_GROWTH_PINE_TAIGA);
        Holder<ConfiguredFeature<?, ?>> holder45 = holdergetter.getOrThrow(ModConfiguredFeatures.CORRUPTED_TREES_JUNGLE);
        Holder<ConfiguredFeature<?, ?>> holder46 = holdergetter.getOrThrow(ModConfiguredFeatures.CORRUPTED_BAMBOO_VEGETATION);
        Holder<ConfiguredFeature<?, ?>> holder47 = holdergetter.getOrThrow(ModConfiguredFeatures.CORRUPTED_MUSHROOM_ISLAND_VEGETATION);
        Holder<ConfiguredFeature<?, ?>> holder48 = holdergetter.getOrThrow(ModConfiguredFeatures.CORRUPTED_MANGROVE_VEGETATION);

       register(context, CORRUPTED_PATCH_GRASS_PLAIN, holder5, NoiseThresholdCountPlacement.of(-0.8D, 5, 10), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome());
       register(context, CORRUPTED_PATCH_GRASS_FOREST, holder5, worldSurfaceSquaredWithCount(2));
       register(context, CORRUPTED_PATCH_GRASS_BADLANDS, holder5, InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome());
       register(context, CORRUPTED_PATCH_GRASS_SAVANNA, holder5, worldSurfaceSquaredWithCount(20));
       register(context, CORRUPTED_PATCH_GRASS_NORMAL, holder5, worldSurfaceSquaredWithCount(5));
       register(context, CORRUPTED_PATCH_GRASS_TAIGA_2, holder6, InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome());
       register(context, CORRUPTED_PATCH_GRASS_TAIGA, holder6, worldSurfaceSquaredWithCount(7));
       register(context, CORRUPTED_PATCH_GRASS_JUNGLE, holder7, worldSurfaceSquaredWithCount(25));
       register(context, CORRUPTED_GRASS_BONEMEAL, holder8, PlacementUtils.isEmpty());
       register(context, CORRUPTED_PATCH_DEAD_BUSH_2, holder9, worldSurfaceSquaredWithCount(2));
       register(context, CORRUPTED_PATCH_DEAD_BUSH, holder9, InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome());
       register(context, CORRUPTED_PATCH_DEAD_BUSH_BADLANDS, holder9, worldSurfaceSquaredWithCount(20));
       register(context, CORRUPTED_PATCH_TALL_GRASS_2, holder13, NoiseThresholdCountPlacement.of(-0.8D, 0, 7), RarityFilter.onAverageOnceEvery(32), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());
       register(context, CORRUPTED_PATCH_TALL_GRASS, holder13, RarityFilter.onAverageOnceEvery(5), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());
       register(context, CORRUPTED_PATCH_LARGE_FERN, holder14, RarityFilter.onAverageOnceEvery(5), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());
        PlacementModifier placementmodifier = SurfaceWaterDepthFilter.forMaxDepth(0);
       register(context, CORRUPTED_TREES_PLAINS, holder25, PlacementUtils.countExtra(0, 0.05F, 1), InSquarePlacement.spread(), placementmodifier, PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, BlockPredicateFilter.forPredicate(BlockPredicate.wouldSurvive(ModBlocks.CORRUPTED_OAK_SAPLING.get().defaultBlockState(), BlockPos.ZERO)), BiomeFilter.biome());
       register(context, CORRUPTED_DARK_FOREST_VEGETATION, holder26, CountPlacement.of(16), InSquarePlacement.spread(), placementmodifier, PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, BiomeFilter.biome());
       register(context, CORRUPTED_TREES_MEADOW, holder29, treePlacement(RarityFilter.onAverageOnceEvery(100)));
       register(context, CORRUPTED_TREES_CHERRY, holder34, treePlacement(PlacementUtils.countExtra(10, 0.1F, 1), ModBlocks.CORRUPTED_CHERRY_SAPLING.get()));
       register(context, CORRUPTED_TREES_TAIGA, holder30, treePlacement(PlacementUtils.countExtra(10, 0.1F, 1)));
       register(context, CORRUPTED_TREES_GROVE, holder31, treePlacement(PlacementUtils.countExtra(10, 0.1F, 1)));
       register(context, CORRUPTED_TREES_BADLANDS, holder32, treePlacement(PlacementUtils.countExtra(5, 0.1F, 1), ModBlocks.CORRUPTED_OAK_SAPLING.get()));
       register(context, CORRUPTED_TREES_SNOWY, holder33, treePlacement(PlacementUtils.countExtra(0, 0.1F, 1), ModBlocks.CORRUPTED_SPRUCE_SAPLING.get()));
       register(context, CORRUPTED_TREES_SWAMP, holder35, PlacementUtils.countExtra(2, 0.1F, 1), InSquarePlacement.spread(), SurfaceWaterDepthFilter.forMaxDepth(2), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, BiomeFilter.biome(), BlockPredicateFilter.forPredicate(BlockPredicate.wouldSurvive(ModBlocks.CORRUPTED_OAK_SAPLING.get().defaultBlockState(), BlockPos.ZERO)));
       register(context, CORRUPTED_TREES_WINDSWEPT_SAVANNA, holder36, treePlacement(PlacementUtils.countExtra(2, 0.1F, 1)));
       register(context, CORRUPTED_TREES_SAVANNA, holder36, treePlacement(PlacementUtils.countExtra(1, 0.1F, 1)));
       register(context, CORRUPTED_BIRCH_TALL, holder37, treePlacement(PlacementUtils.countExtra(10, 0.1F, 1)));
       register(context, CORRUPTED_TREES_BIRCH, holder41, treePlacement(PlacementUtils.countExtra(10, 0.1F, 1), ModBlocks.CORRUPTED_BIRCH_SAPLING.get()));
       register(context, CORRUPTED_TREES_WINDSWEPT_FOREST, holder39, treePlacement(PlacementUtils.countExtra(3, 0.1F, 1)));
       register(context, CORRUPTED_TREES_WINDSWEPT_HILLS, holder39, treePlacement(PlacementUtils.countExtra(0, 0.1F, 1)));
       register(context, CORRUPTED_TREES_WATER, holder40, treePlacement(PlacementUtils.countExtra(0, 0.1F, 1)));
       register(context, CORRUPTED_TREES_BIRCH_AND_OAK, holder41, treePlacement(PlacementUtils.countExtra(10, 0.1F, 1)));
       register(context, CORRUPTED_TREES_SPARSE_JUNGLE, holder42, treePlacement(PlacementUtils.countExtra(2, 0.1F, 1)));
       register(context, CORRUPTED_TREES_OLD_GROWTH_SPRUCE_TAIGA, holder43, treePlacement(PlacementUtils.countExtra(10, 0.1F, 1)));
       register(context, CORRUPTED_TREES_OLD_GROWTH_PINE_TAIGA, holder44, treePlacement(PlacementUtils.countExtra(10, 0.1F, 1)));
       register(context, CORRUPTED_TREES_JUNGLE, holder45, treePlacement(PlacementUtils.countExtra(50, 0.1F, 1)));
       register(context, CORRUPTED_TREES_MANGROVE, holder48, CountPlacement.of(25), InSquarePlacement.spread(), SurfaceWaterDepthFilter.forMaxDepth(5), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, BiomeFilter.biome(), BlockPredicateFilter.forPredicate(BlockPredicate.wouldSurvive(ModBlocks.CORRUPTED_MANGROVE_PROPAGULE.get().defaultBlockState(), BlockPos.ZERO)));
       register(context, CORRUPTED_BAMBOO_VEGETATION, holder46, treePlacement(PlacementUtils.countExtra(30, 0.1F, 1)));
       register(context, CORRUPTED_MUSHROOM_ISLAND_VEGETATION, holder47, InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());

        Holder<ConfiguredFeature<?, ?>> holder50 = holdergetter.getOrThrow(ModConfiguredFeatures.PATCH_DARK_AETHER_CRYSTAL_ORE_SMALL);
        Holder<ConfiguredFeature<?, ?>> holder51 = holdergetter.getOrThrow(ModConfiguredFeatures.PATCH_DARK_AETHER_CRYSTAL_ORE_BIG);
        register(context, PATCH_SMALL_DARK_AETHER_CRYSTAL_ORE, holder50, NoiseThresholdCountPlacement.of(-0.8D, 2, 5), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome());
        register(context, PATCH_BIG_DARK_AETHER_CRYSTAL_ORE, holder51, NoiseThresholdCountPlacement.of(-0.8D, 0, 3), RarityFilter.onAverageOnceEvery(300), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());

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

    private static ImmutableList.Builder<PlacementModifier> treePlacementBase(PlacementModifier pPlacement) {
        return ImmutableList.<PlacementModifier>builder().add(pPlacement).add(InSquarePlacement.spread()).add(TREE_THRESHOLD).add(PlacementUtils.HEIGHTMAP_OCEAN_FLOOR).add(BiomeFilter.biome());
    }

    public static List<PlacementModifier> treePlacement(PlacementModifier pPlacement) {
        return treePlacementBase(pPlacement).build();
    }

    public static List<PlacementModifier> treePlacement(PlacementModifier pPlacement, Block p_195483_) {
        return treePlacementBase(pPlacement).add(BlockPredicateFilter.forPredicate(BlockPredicate.wouldSurvive(p_195483_.defaultBlockState(), BlockPos.ZERO))).build();
    }

    public static List<PlacementModifier> worldSurfaceSquaredWithCount(int pCount) {
        return List.of(CountPlacement.of(pCount), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome());
    }
}
