package net.alberdrocs.darkaethercorruptionmod.worldgen;

import com.google.common.collect.ImmutableList;
import net.alberdrocs.darkaethercorruptionmod.DarkAetherCorruptionMod;
import net.alberdrocs.darkaethercorruptionmod.block.ModBlocks;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.features.TreeFeatures;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.TreePlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.util.valueproviders.WeightedListInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.MangrovePropaguleBlock;
import net.minecraft.world.level.block.PinkPetalsBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.WeightedPlacedFeature;
import net.minecraft.world.level.levelgen.feature.configurations.*;
import net.minecraft.world.level.levelgen.feature.featuresize.ThreeLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.*;
import net.minecraft.world.level.levelgen.feature.rootplacers.AboveRootPlacement;
import net.minecraft.world.level.levelgen.feature.rootplacers.MangroveRootPlacement;
import net.minecraft.world.level.levelgen.feature.rootplacers.MangroveRootPlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.RandomizedIntStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.minecraft.world.level.levelgen.feature.treedecorators.AlterGroundDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.AttachedToLeavesDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.LeaveVineDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.TrunkVineDecorator;
import net.minecraft.world.level.levelgen.feature.trunkplacers.*;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;


public class ModConfiguredFeatures {
    //************************
    // TREE FEATURES
    //************************
    public static final ResourceKey<ConfiguredFeature<?, ?>> CORRUPTED_OAK_KEY = registerKey("corrupted_oak");
    public static final ResourceKey<ConfiguredFeature<?, ?>> CORRUPTED_DARK_OAK_KEY = registerKey("corrupted_dark_oak");
    public static final ResourceKey<ConfiguredFeature<?, ?>> CORRUPTED_BIRCH_KEY = registerKey("corrupted_birch");
    public static final ResourceKey<ConfiguredFeature<?, ?>> CORRUPTED_ACACIA_KEY = registerKey("corrupted_acacia");
    public static final ResourceKey<ConfiguredFeature<?, ?>> CORRUPTED_SPRUCE_KEY = registerKey("corrupted_spruce");
    public static final ResourceKey<ConfiguredFeature<?, ?>> CORRUPTED_PINE_KEY = registerKey("corrupted_pine");
    public static final ResourceKey<ConfiguredFeature<?, ?>> CORRUPTED_JUNGLE_TREE_KEY = registerKey("corrupted_jungle_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> CORRUPTED_FANCY_OAK_KEY = registerKey("corrupted_fancy_oak");
    public static final ResourceKey<ConfiguredFeature<?, ?>> CORRUPTED_JUNGLE_TREE_NO_VINE_KEY = registerKey("corrupted_jungle_tree_no_vine");
    public static final ResourceKey<ConfiguredFeature<?, ?>> CORRUPTED_MEGA_JUNGLE_TREE_KEY = registerKey("corrupted_mega_jungle_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> CORRUPTED_MEGA_SPRUCE_KEY = registerKey("corrupted_mega_spruce");
    public static final ResourceKey<ConfiguredFeature<?, ?>> CORRUPTED_MEGA_PINE_KEY = registerKey("corrupted_mega_pine");
    public static final ResourceKey<ConfiguredFeature<?, ?>> CORRUPTED_SWAMP_OAK_KEY = registerKey("corrupted_swamp_oak");
    public static final ResourceKey<ConfiguredFeature<?, ?>> CORRUPTED_JUNGLE_BUSH_KEY = registerKey("corrupted_jungle_bush");
    public static final ResourceKey<ConfiguredFeature<?, ?>> CORRUPTED_AZALEA_TREE_KEY = registerKey("corrupted_azalea_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> CORRUPTED_MANGROVE_KEY = registerKey("corrupted_mangrove");
    public static final ResourceKey<ConfiguredFeature<?, ?>> CORRUPTED_TALL_MANGROVE_KEY = registerKey("corrupted_tall_mangrove");
    public static final ResourceKey<ConfiguredFeature<?, ?>> CORRUPTED_CHERRY_KEY = registerKey("corrupted_cherry");

    //************************
    // VEGETATION FEATURES
    //************************
    public static final ResourceKey<ConfiguredFeature<?, ?>> CORRUPTED_PATCH_TAIGA_GRASS = registerKey("corrupted_patch_taiga_grass");
    public static final ResourceKey<ConfiguredFeature<?, ?>> CORRUPTED_PATCH_GRASS = registerKey("corrupted_patch_grass");
    public static final ResourceKey<ConfiguredFeature<?, ?>> CORRUPTED_PATCH_GRASS_JUNGLE = registerKey("corrupted_patch_grass_jungle");
    public static final ResourceKey<ConfiguredFeature<?, ?>> CORRUPTED_SINGLE_PIECE_OF_GRASS = registerKey("corrupted_single_piece_of_grass");
    public static final ResourceKey<ConfiguredFeature<?, ?>> CORRUPTED_PATCH_DEAD_BUSH = registerKey("corrupted_patch_dead_bush");
    public static final ResourceKey<ConfiguredFeature<?, ?>> CORRUPTED_PATCH_TALL_GRASS = registerKey("corrupted_patch_tall_grass");
    public static final ResourceKey<ConfiguredFeature<?, ?>> CORRUPTED_PATCH_LARGE_FERN = registerKey("corrupted_patch_large_fern");
    public static final ResourceKey<ConfiguredFeature<?, ?>> CORRUPTED_DARK_FOREST_VEGETATION = registerKey("corrupted_dark_forest_vegetation");
    public static final ResourceKey<ConfiguredFeature<?, ?>> CORRUPTED_TREES_FLOWER_FOREST = registerKey("corrupted_trees_flower_forest");
    public static final ResourceKey<ConfiguredFeature<?, ?>> CORRUPTED_MEADOW_TREES = registerKey("corrupted_meadow_trees");
    public static final ResourceKey<ConfiguredFeature<?, ?>> CORRUPTED_TREES_TAIGA = registerKey("corrupted_trees_taiga");
    public static final ResourceKey<ConfiguredFeature<?, ?>> CORRUPTED_TREES_GROVE = registerKey("corrupted_trees_grove");
    public static final ResourceKey<ConfiguredFeature<?, ?>> CORRUPTED_TREES_SAVANNA = registerKey("corrupted_trees_savanna");
    public static final ResourceKey<ConfiguredFeature<?, ?>> CORRUPTED_BIRCH_TALL = registerKey("corrupted_birch_tall");
    public static final ResourceKey<ConfiguredFeature<?, ?>> CORRUPTED_TREES_WINDSWEPT_HILLS = registerKey("corrupted_trees_windswept_hills");
    public static final ResourceKey<ConfiguredFeature<?, ?>> CORRUPTED_TREES_WATER = registerKey("corrupted_trees_water");
    public static final ResourceKey<ConfiguredFeature<?, ?>> CORRUPTED_TREES_BIRCH_AND_OAK = registerKey("corrupted_trees_birch_and_oak");
    public static final ResourceKey<ConfiguredFeature<?, ?>> CORRUPTED_TREES_PLAINS = registerKey("corrupted_trees_plains");
    public static final ResourceKey<ConfiguredFeature<?, ?>> CORRUPTED_TREES_SPARSE_JUNGLE = registerKey("corrupted_trees_sparse_jungle");
    public static final ResourceKey<ConfiguredFeature<?, ?>> CORRUPTED_TREES_OLD_GROWTH_SPRUCE_TAIGA = registerKey("corrupted_trees_old_growth_spruce_taiga");
    public static final ResourceKey<ConfiguredFeature<?, ?>> CORRUPTED_TREES_OLD_GROWTH_PINE_TAIGA = registerKey("corrupted_trees_old_growth_pine_taiga");
    public static final ResourceKey<ConfiguredFeature<?, ?>> CORRUPTED_TREES_JUNGLE = registerKey("corrupted_trees_jungle");
    public static final ResourceKey<ConfiguredFeature<?, ?>> CORRUPTED_MANGROVE_VEGETATION = registerKey("corrupted_mangrove_vegetation");
    public static final ResourceKey<ConfiguredFeature<?, ?>> CORRUPTED_BAMBOO_VEGETATION = registerKey("corrupted_bamboo_vegetation");
    public static final ResourceKey<ConfiguredFeature<?, ?>> CORRUPTED_MUSHROOM_ISLAND_VEGETATION = registerKey("corrupted_mushroom_island_vegetation");


    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
        HolderGetter<Block> treeFreaturesHolderGetter = context.lookup(Registries.BLOCK);
        //************************
        // TREE FEATURES
        //************************
        register(context, CORRUPTED_OAK_KEY, Feature.TREE, createStraightBlobTree(ModBlocks.CORRUPTED_DARK_OAK_LOG.get(), Blocks.AIR,
                4, 2, 0, 2).ignoreVines().decorators(ImmutableList.of(new AlterGroundDecorator(BlockStateProvider.simple(ModBlocks.CORRUPTED_DIRT.get())))).build());
        register(context, CORRUPTED_DARK_OAK_KEY, Feature.TREE, (new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(ModBlocks.CORRUPTED_DARK_OAK_LOG.get()), new DarkOakTrunkPlacer(6, 2, 1), BlockStateProvider.simple(Blocks.AIR), new DarkOakFoliagePlacer(ConstantInt.of(0), ConstantInt.of(0)), new ThreeLayersFeatureSize(1, 1, 0, 1, 2, OptionalInt.empty()))).ignoreVines().decorators(ImmutableList.of(new AlterGroundDecorator(BlockStateProvider.simple(ModBlocks.CORRUPTED_DIRT.get())))).build());
        register(context, CORRUPTED_BIRCH_KEY, Feature.TREE, createBirch().decorators(ImmutableList.of(new AlterGroundDecorator(BlockStateProvider.simple(ModBlocks.CORRUPTED_DIRT.get())))).build());
        register(context, CORRUPTED_ACACIA_KEY, Feature.TREE, (new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(ModBlocks.CORRUPTED_ACACIA_LOG.get()), new ForkingTrunkPlacer(5, 2, 2), BlockStateProvider.simple(Blocks.AIR), new AcaciaFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0)), new TwoLayersFeatureSize(1, 0, 2))).ignoreVines().decorators(ImmutableList.of(new AlterGroundDecorator(BlockStateProvider.simple(ModBlocks.CORRUPTED_DIRT.get())))).build());
        register(context, CORRUPTED_CHERRY_KEY, Feature.TREE, cherry().decorators(ImmutableList.of(new AlterGroundDecorator(BlockStateProvider.simple(ModBlocks.CORRUPTED_DIRT.get())))).build());
        register(context, CORRUPTED_SPRUCE_KEY, Feature.TREE, (new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(ModBlocks.CORRUPTED_SPRUCE_LOG.get()), new StraightTrunkPlacer(5, 2, 1), BlockStateProvider.simple(Blocks.AIR), new SpruceFoliagePlacer(UniformInt.of(2, 3), UniformInt.of(0, 2), UniformInt.of(1, 2)), new TwoLayersFeatureSize(2, 0, 2))).ignoreVines().decorators(ImmutableList.of(new AlterGroundDecorator(BlockStateProvider.simple(ModBlocks.CORRUPTED_DIRT.get())))).build());
        register(context, CORRUPTED_PINE_KEY, Feature.TREE, (new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(ModBlocks.CORRUPTED_SPRUCE_LOG.get()), new StraightTrunkPlacer(6, 4, 0), BlockStateProvider.simple(Blocks.AIR), new PineFoliagePlacer(ConstantInt.of(1), ConstantInt.of(1), UniformInt.of(3, 4)), new TwoLayersFeatureSize(2, 0, 2))).ignoreVines().decorators(ImmutableList.of(new AlterGroundDecorator(BlockStateProvider.simple(ModBlocks.CORRUPTED_DIRT.get())))).build());
        register(context, CORRUPTED_JUNGLE_TREE_KEY, Feature.TREE, createJungleTree().ignoreVines().decorators(ImmutableList.of(new AlterGroundDecorator(BlockStateProvider.simple(ModBlocks.CORRUPTED_DIRT.get())))).build());
        register(context, CORRUPTED_FANCY_OAK_KEY, Feature.TREE, createFancyOak().decorators(ImmutableList.of(new AlterGroundDecorator(BlockStateProvider.simple(ModBlocks.CORRUPTED_DIRT.get())))).build());
        register(context, CORRUPTED_JUNGLE_TREE_NO_VINE_KEY, Feature.TREE, createJungleTree().ignoreVines().decorators(ImmutableList.of(new AlterGroundDecorator(BlockStateProvider.simple(ModBlocks.CORRUPTED_DIRT.get())))).build());
        register(context, CORRUPTED_MEGA_JUNGLE_TREE_KEY, Feature.TREE, (new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(ModBlocks.CORRUPTED_JUNGLE_LOG.get()), new MegaJungleTrunkPlacer(10, 2, 19), BlockStateProvider.simple(Blocks.AIR), new MegaJungleFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 2), new TwoLayersFeatureSize(1, 1, 2))).decorators(ImmutableList.of(TrunkVineDecorator.INSTANCE, new LeaveVineDecorator(0.25F), new AlterGroundDecorator(BlockStateProvider.simple(ModBlocks.CORRUPTED_DIRT.get())))).build());
        register(context, CORRUPTED_MEGA_SPRUCE_KEY, Feature.TREE, (new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(ModBlocks.CORRUPTED_SPRUCE_LOG.get()), new GiantTrunkPlacer(13, 2, 14), BlockStateProvider.simple(Blocks.AIR), new MegaPineFoliagePlacer(ConstantInt.of(0), ConstantInt.of(0), UniformInt.of(13, 17)), new TwoLayersFeatureSize(1, 1, 2))).decorators(ImmutableList.of(new AlterGroundDecorator(BlockStateProvider.simple(ModBlocks.CORRUPTED_DIRT.get())))).build());
        register(context, CORRUPTED_MEGA_PINE_KEY, Feature.TREE, (new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(ModBlocks.CORRUPTED_SPRUCE_LOG.get()), new GiantTrunkPlacer(13, 2, 14), BlockStateProvider.simple(Blocks.AIR), new MegaPineFoliagePlacer(ConstantInt.of(0), ConstantInt.of(0), UniformInt.of(3, 7)), new TwoLayersFeatureSize(1, 1, 2))).decorators(ImmutableList.of(new AlterGroundDecorator(BlockStateProvider.simple(ModBlocks.CORRUPTED_DIRT.get())))).build());
        register(context, CORRUPTED_SWAMP_OAK_KEY, Feature.TREE, createStraightBlobTree(ModBlocks.CORRUPTED_DARK_OAK_LOG.get(), Blocks.AIR, 5, 3, 0, 3).decorators(ImmutableList.of(new AlterGroundDecorator(BlockStateProvider.simple(ModBlocks.CORRUPTED_DIRT.get())))).build());
        register(context, CORRUPTED_JUNGLE_BUSH_KEY, Feature.TREE, (new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(ModBlocks.CORRUPTED_JUNGLE_LOG.get()), new StraightTrunkPlacer(1, 0, 0), BlockStateProvider.simple(Blocks.AIR), new BushFoliagePlacer(ConstantInt.of(2), ConstantInt.of(1), 2), new TwoLayersFeatureSize(0, 0, 0))).decorators(ImmutableList.of(new AlterGroundDecorator(BlockStateProvider.simple(ModBlocks.CORRUPTED_DIRT.get())))).build());
        register(context, CORRUPTED_AZALEA_TREE_KEY, Feature.TREE, (new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(ModBlocks.CORRUPTED_DARK_OAK_LOG.get()), new BendingTrunkPlacer(4, 2, 0, 3, UniformInt.of(1, 2)), new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(Blocks.AIR.defaultBlockState(), 3).add(Blocks.AIR.defaultBlockState(), 1)), new RandomSpreadFoliagePlacer(ConstantInt.of(3), ConstantInt.of(0), ConstantInt.of(2), 50), new TwoLayersFeatureSize(1, 0, 1))).dirt(BlockStateProvider.simple(ModBlocks.CORRUPTED_DIRT.get())).forceDirt().build());
        register(context, CORRUPTED_MANGROVE_KEY, Feature.TREE, (new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(ModBlocks.CORRUPTED_MANGROVE_LOG.get()), new UpwardsBranchingTrunkPlacer(2, 1, 4, UniformInt.of(1, 4), 0.5F, UniformInt.of(0, 1), treeFreaturesHolderGetter.getOrThrow(BlockTags.MANGROVE_LOGS_CAN_GROW_THROUGH)), BlockStateProvider.simple(Blocks.AIR), new RandomSpreadFoliagePlacer(ConstantInt.of(3), ConstantInt.of(0), ConstantInt.of(2), 70), Optional.of(new MangroveRootPlacer(UniformInt.of(1, 3), BlockStateProvider.simple(Blocks.MANGROVE_ROOTS), Optional.of(new AboveRootPlacement(BlockStateProvider.simple(Blocks.MOSS_CARPET), 0.5F)), new MangroveRootPlacement(treeFreaturesHolderGetter.getOrThrow(BlockTags.MANGROVE_ROOTS_CAN_GROW_THROUGH), HolderSet.direct(Block::builtInRegistryHolder, Blocks.MUD, Blocks.MUDDY_MANGROVE_ROOTS), BlockStateProvider.simple(Blocks.MUDDY_MANGROVE_ROOTS), 8, 15, 0.2F))), new TwoLayersFeatureSize(2, 0, 2))).decorators(List.of(new LeaveVineDecorator(0.125F), new AttachedToLeavesDecorator(0.14F, 1, 0, new RandomizedIntStateProvider(BlockStateProvider.simple(Blocks.MANGROVE_PROPAGULE.defaultBlockState().setValue(MangrovePropaguleBlock.HANGING, Boolean.valueOf(true))), MangrovePropaguleBlock.AGE, UniformInt.of(0, 4)), 2, List.of(Direction.DOWN)))).ignoreVines().build());
        register(context, CORRUPTED_TALL_MANGROVE_KEY, Feature.TREE, (new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(ModBlocks.CORRUPTED_MANGROVE_LOG.get()), new UpwardsBranchingTrunkPlacer(4, 1, 9, UniformInt.of(1, 6), 0.5F, UniformInt.of(0, 1), treeFreaturesHolderGetter.getOrThrow(BlockTags.MANGROVE_LOGS_CAN_GROW_THROUGH)), BlockStateProvider.simple(Blocks.AIR), new RandomSpreadFoliagePlacer(ConstantInt.of(3), ConstantInt.of(0), ConstantInt.of(2), 70), Optional.of(new MangroveRootPlacer(UniformInt.of(3, 7), BlockStateProvider.simple(Blocks.MANGROVE_ROOTS), Optional.of(new AboveRootPlacement(BlockStateProvider.simple(Blocks.MOSS_CARPET), 0.5F)), new MangroveRootPlacement(treeFreaturesHolderGetter.getOrThrow(BlockTags.MANGROVE_ROOTS_CAN_GROW_THROUGH), HolderSet.direct(Block::builtInRegistryHolder, Blocks.MUD, Blocks.MUDDY_MANGROVE_ROOTS), BlockStateProvider.simple(Blocks.MUDDY_MANGROVE_ROOTS), 8, 15, 0.2F))), new TwoLayersFeatureSize(3, 0, 2))).decorators(List.of(new LeaveVineDecorator(0.125F), new AttachedToLeavesDecorator(0.14F, 1, 0, new RandomizedIntStateProvider(BlockStateProvider.simple(Blocks.MANGROVE_PROPAGULE.defaultBlockState().setValue(MangrovePropaguleBlock.HANGING, Boolean.valueOf(true))), MangrovePropaguleBlock.AGE, UniformInt.of(0, 4)), 2, List.of(Direction.DOWN)))).ignoreVines().build());

        //************************
        // VEGETATION FEATURES
        //************************
        HolderGetter<ConfiguredFeature<?, ?>> holdergetter = context.lookup(Registries.CONFIGURED_FEATURE);
        Holder<ConfiguredFeature<?, ?>> holder4 = holdergetter.getOrThrow(CORRUPTED_PATCH_GRASS_JUNGLE);
        HolderGetter<PlacedFeature> holdergetter1 = context.lookup(Registries.PLACED_FEATURE);
        Holder<PlacedFeature> holder5 = holdergetter1.getOrThrow(ModPlacedFeatures.CORRUPTED_DARK_OAK_CHECKED);
        Holder<PlacedFeature> holder6 = holdergetter1.getOrThrow(ModPlacedFeatures.CORRUPTED_BIRCH_CHECKED);
        Holder<PlacedFeature> holder7 = holdergetter1.getOrThrow(ModPlacedFeatures.CORRUPTED_FANCY_OAK_CHECKED);
        Holder<PlacedFeature> holder11 = holdergetter1.getOrThrow(ModPlacedFeatures.CORRUPTED_PINE_CHECKED);
        Holder<PlacedFeature> holder12 = holdergetter1.getOrThrow(ModPlacedFeatures.CORRUPTED_SPRUCE_CHECKED);
        Holder<PlacedFeature> holder14 = holdergetter1.getOrThrow(ModPlacedFeatures.CORRUPTED_ACACIA_CHECKED);
        Holder<PlacedFeature> holder18 = holdergetter1.getOrThrow(ModPlacedFeatures.CORRUPTED_JUNGLE_BUSH);
        Holder<PlacedFeature> holder19 = holdergetter1.getOrThrow(ModPlacedFeatures.CORRUPTED_MEGA_SPRUCE_CHECKED);
        Holder<PlacedFeature> holder20 = holdergetter1.getOrThrow(ModPlacedFeatures.CORRUPTED_MEGA_PINE_CHECKED);
        Holder<PlacedFeature> holder21 = holdergetter1.getOrThrow(ModPlacedFeatures.CORRUPTED_MEGA_JUNGLE_TREE_CHECKED);
        Holder<PlacedFeature> holder22 = holdergetter1.getOrThrow(ModPlacedFeatures.CORRUPTED_TALL_MANGROVE_CHECKED);
        Holder<PlacedFeature> holder23 = holdergetter1.getOrThrow(ModPlacedFeatures.CORRUPTED_OAK_CHECKED);
        Holder<PlacedFeature> holder28 = holdergetter1.getOrThrow(ModPlacedFeatures.CORRUPTED_JUNGLE_TREE_CHECKED);
        Holder<PlacedFeature> holder29 = holdergetter1.getOrThrow(ModPlacedFeatures.CORRUPTED_MANGROVE_CHECKED);
        register(context, CORRUPTED_PATCH_TAIGA_GRASS, Feature.RANDOM_PATCH, grassPatch(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(Blocks.GRASS.defaultBlockState(), 1).add(Blocks.FERN.defaultBlockState(), 4)), 32));
        register(context, CORRUPTED_PATCH_GRASS, Feature.RANDOM_PATCH, grassPatch(BlockStateProvider.simple(Blocks.GRASS), 32));
        register(context, CORRUPTED_PATCH_GRASS_JUNGLE, Feature.RANDOM_PATCH, new RandomPatchConfiguration(32, 7, 3, PlacementUtils.filtered(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(Blocks.GRASS.defaultBlockState(), 3).add(Blocks.FERN.defaultBlockState(), 1))), BlockPredicate.allOf(BlockPredicate.ONLY_IN_AIR_PREDICATE, BlockPredicate.not(BlockPredicate.matchesBlocks(Direction.DOWN.getNormal(), Blocks.PODZOL))))));
        register(context, CORRUPTED_SINGLE_PIECE_OF_GRASS, Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(Blocks.GRASS.defaultBlockState())));
        register(context, CORRUPTED_PATCH_DEAD_BUSH, Feature.RANDOM_PATCH, grassPatch(BlockStateProvider.simple(Blocks.DEAD_BUSH), 4));
        register(context, CORRUPTED_PATCH_TALL_GRASS, Feature.RANDOM_PATCH, FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(Blocks.TALL_GRASS))));
        register(context, CORRUPTED_PATCH_LARGE_FERN, Feature.RANDOM_PATCH, FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(Blocks.LARGE_FERN))));
        SimpleWeightedRandomList.Builder<BlockState> builder = SimpleWeightedRandomList.builder();

        for(int i = 1; i <= 4; ++i) {
            for(Direction direction : Direction.Plane.HORIZONTAL) {
                builder.add(Blocks.PINK_PETALS.defaultBlockState().setValue(PinkPetalsBlock.AMOUNT, Integer.valueOf(i)).setValue(PinkPetalsBlock.FACING, direction), 1);
            }
        }

        register(context, CORRUPTED_DARK_FOREST_VEGETATION, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(holder5, 0.6666667F), new WeightedPlacedFeature(holder6, 0.2F), new WeightedPlacedFeature(holder7, 0.1F)), holder23));
        register(context, CORRUPTED_TREES_FLOWER_FOREST, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(Collections.emptyList(), holder23));
        register(context, CORRUPTED_MEADOW_TREES, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(Collections.emptyList(), holder6));
        register(context, CORRUPTED_TREES_TAIGA, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(holder11, 0.33333334F)), holder12));
        register(context, CORRUPTED_TREES_GROVE, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(Collections.emptyList(), holder12));
        register(context, CORRUPTED_TREES_SAVANNA, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(holder14, 0.8F)), holder23));
        register(context, CORRUPTED_BIRCH_TALL, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(Collections.emptyList(), holder6));
        register(context, CORRUPTED_TREES_WINDSWEPT_HILLS, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(holder12, 0.666F), new WeightedPlacedFeature(holder7, 0.1F)), holder23));
        register(context, CORRUPTED_TREES_WATER, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(holder7, 0.1F)), holder23));
        register(context, CORRUPTED_TREES_BIRCH_AND_OAK, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(Collections.emptyList(), holder6));
        register(context, CORRUPTED_TREES_PLAINS, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(Collections.emptyList(), holder23));
        register(context, CORRUPTED_TREES_SPARSE_JUNGLE, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(holder7, 0.1F), new WeightedPlacedFeature(holder18, 0.5F)), holder28));
        register(context, CORRUPTED_TREES_OLD_GROWTH_SPRUCE_TAIGA, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(holder19, 0.33333334F), new WeightedPlacedFeature(holder11, 0.33333334F)), holder12));
        register(context, CORRUPTED_TREES_OLD_GROWTH_PINE_TAIGA, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(holder19, 0.025641026F), new WeightedPlacedFeature(holder20, 0.30769232F), new WeightedPlacedFeature(holder11, 0.33333334F)), holder12));
        register(context, CORRUPTED_TREES_JUNGLE, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(holder7, 0.1F), new WeightedPlacedFeature(holder18, 0.5F), new WeightedPlacedFeature(holder21, 0.33333334F)), holder28));
        register(context, CORRUPTED_MANGROVE_VEGETATION, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(holder22, 0.85F)), holder29));
        register(context, CORRUPTED_BAMBOO_VEGETATION, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(holder7, 0.05F), new WeightedPlacedFeature(holder18, 0.15F), new WeightedPlacedFeature(holder21, 0.7F)), PlacementUtils.inlinePlaced(holder4)));
        register(context, CORRUPTED_MUSHROOM_ISLAND_VEGETATION, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(Collections.emptyList(), holder23));

    }

    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(DarkAetherCorruptionMod.MOD_ID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstapContext<ConfiguredFeature<?, ?>> context,
                                                                                          ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }

    private static TreeConfiguration.TreeConfigurationBuilder createStraightBlobTree(Block p_195147_, Block p_195148_, int pBaseHeight, int pHeightRandA, int pHeightRandB, int p_195152_) {
        return new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(p_195147_), new StraightTrunkPlacer(pBaseHeight, pHeightRandA, pHeightRandB), BlockStateProvider.simple(p_195148_), new BlobFoliagePlacer(ConstantInt.of(p_195152_), ConstantInt.of(0), 3), new TwoLayersFeatureSize(1, 0, 1));
    }

    private static TreeConfiguration.TreeConfigurationBuilder createOak() {
        return createStraightBlobTree(ModBlocks.CORRUPTED_DARK_OAK_LOG.get(), Blocks.AIR, 4, 2, 0, 2).ignoreVines();
    }

    private static TreeConfiguration.TreeConfigurationBuilder createBirch() {
        return createStraightBlobTree(ModBlocks.CORRUPTED_BIRCH_LOG.get(), Blocks.AIR, 5, 2, 0, 2).ignoreVines();
    }

    private static TreeConfiguration.TreeConfigurationBuilder createSuperBirch() {
        return createStraightBlobTree(ModBlocks.CORRUPTED_BIRCH_LOG.get(), Blocks.AIR, 5, 2, 6, 2).ignoreVines();
    }

    private static TreeConfiguration.TreeConfigurationBuilder createJungleTree() {
        return createStraightBlobTree(ModBlocks.CORRUPTED_JUNGLE_LOG.get(), Blocks.AIR, 4, 8, 0, 2);
    }

    private static TreeConfiguration.TreeConfigurationBuilder createFancyOak() {
        return (new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(ModBlocks.CORRUPTED_DARK_OAK_LOG.get()), new FancyTrunkPlacer(3, 11, 0), BlockStateProvider.simple(Blocks.AIR), new FancyFoliagePlacer(ConstantInt.of(2), ConstantInt.of(4), 4), new TwoLayersFeatureSize(0, 0, 0, OptionalInt.of(4)))).ignoreVines();
    }

    private static TreeConfiguration.TreeConfigurationBuilder cherry() {
        return (new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(ModBlocks.CORRUPTED_CHERRY_LOG.get()), new CherryTrunkPlacer(7, 1, 0, new WeightedListInt(SimpleWeightedRandomList.<IntProvider>builder().add(ConstantInt.of(1), 1).add(ConstantInt.of(2), 1).add(ConstantInt.of(3), 1).build()), UniformInt.of(2, 4), UniformInt.of(-4, -3), UniformInt.of(-1, 0)), BlockStateProvider.simple(Blocks.AIR), new CherryFoliagePlacer(ConstantInt.of(4), ConstantInt.of(0), ConstantInt.of(5), 0.25F, 0.5F, 0.16666667F, 0.33333334F), new TwoLayersFeatureSize(1, 0, 2))).ignoreVines();
    }

    private static RandomPatchConfiguration grassPatch(BlockStateProvider p_195203_, int pTries) {
        return FeatureUtils.simpleRandomPatchConfiguration(pTries, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(p_195203_)));
    }

}
