package net.alberdrocs.darkaethercorruptionmod.worldgen;

import net.alberdrocs.darkaethercorruptionmod.DarkAetherCorruptionMod;
import net.alberdrocs.darkaethercorruptionmod.block.ModBlocks;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;

import java.util.List;

public class ModTreePlacements {

    public static final ResourceKey<PlacedFeature> CORRUPTED_OAK_CHECKED = PlacementUtils.createKey("corrupted_oak_checked");
    public static final ResourceKey<PlacedFeature> CORRUPTED_DARK_OAK_CHECKED = PlacementUtils.createKey("corrupted_dark_oak_checked");
    public static final ResourceKey<PlacedFeature> CORRUPTED_BIRCH_CHECKED = PlacementUtils.createKey("corrupted_birch_checked");
    public static final ResourceKey<PlacedFeature> CORRUPTED_ACACIA_CHECKED = PlacementUtils.createKey("corrupted_acacia_checked");
    public static final ResourceKey<PlacedFeature> CORRUPTED_SPRUCE_CHECKED = PlacementUtils.createKey("corrupted_spruce_checked");
    public static final ResourceKey<PlacedFeature> CORRUPTED_MANGROVE_CHECKED = PlacementUtils.createKey("corrupted_mangrove_checked");
    public static final ResourceKey<PlacedFeature> CORRUPTED_CHERRY_CHECKED = PlacementUtils.createKey("corrupted_cherry_checked");
    public static final ResourceKey<PlacedFeature> CORRUPTED_PINE_CHECKED = PlacementUtils.createKey("corrupted_pine_checked");
    public static final ResourceKey<PlacedFeature> CORRUPTED_JUNGLE_TREE_CHECKED = PlacementUtils.createKey("corrupted_jungle_tree");
    public static final ResourceKey<PlacedFeature> CORRUPTED_FANCY_OAK_CHECKED = PlacementUtils.createKey("corrupted_fancy_oak_checked");
    public static final ResourceKey<PlacedFeature> CORRUPTED_MEGA_JUNGLE_TREE_CHECKED = PlacementUtils.createKey("corrupted_mega_jungle_tree_checked");
    public static final ResourceKey<PlacedFeature> CORRUPTED_MEGA_SPRUCE_CHECKED = PlacementUtils.createKey("corrupted_mega_spruce_checked");
    public static final ResourceKey<PlacedFeature> CORRUPTED_MEGA_PINE_CHECKED = PlacementUtils.createKey("corrupted_mega_pine_checked");
    public static final ResourceKey<PlacedFeature> CORRUPTED_TALL_MANGROVE_CHECKED = PlacementUtils.createKey("corrupted_tall_mangrove_checked");
    public static final ResourceKey<PlacedFeature> CORRUPTED_JUNGLE_BUSH = PlacementUtils.createKey("corrupted_jungle_bush");


    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> holdergetter = context.lookup(Registries.CONFIGURED_FEATURE);
        //************************
        // TREE PLACEMENTS
        //************************
        Holder<ConfiguredFeature<?, ?>> treePlcmntHolder2 = holdergetter.getOrThrow(ModTreeFeatures.CORRUPTED_OAK_KEY);
        Holder<ConfiguredFeature<?, ?>> treePlcmntHolder3 = holdergetter.getOrThrow(ModTreeFeatures.CORRUPTED_DARK_OAK_KEY);
        Holder<ConfiguredFeature<?, ?>> treePlcmntHolder4 = holdergetter.getOrThrow(ModTreeFeatures.CORRUPTED_BIRCH_KEY);
        Holder<ConfiguredFeature<?, ?>> treePlcmntHolder5 = holdergetter.getOrThrow(ModTreeFeatures.CORRUPTED_ACACIA_KEY);
        Holder<ConfiguredFeature<?, ?>> treePlcmntHolder6 = holdergetter.getOrThrow(ModTreeFeatures.CORRUPTED_SPRUCE_KEY);
        Holder<ConfiguredFeature<?, ?>> treePlcmntHolder7 = holdergetter.getOrThrow(ModTreeFeatures.CORRUPTED_MANGROVE_KEY);
        Holder<ConfiguredFeature<?, ?>> treePlcmntHolder8 = holdergetter.getOrThrow(ModTreeFeatures.CORRUPTED_CHERRY_KEY);
        Holder<ConfiguredFeature<?, ?>> treePlcmntHolder9 = holdergetter.getOrThrow(ModTreeFeatures.CORRUPTED_PINE_KEY);
        Holder<ConfiguredFeature<?, ?>> treePlcmntHolder10 = holdergetter.getOrThrow(ModTreeFeatures.CORRUPTED_JUNGLE_TREE_KEY);
        Holder<ConfiguredFeature<?, ?>> treePlcmntHolder11 = holdergetter.getOrThrow(ModTreeFeatures.CORRUPTED_FANCY_OAK_KEY);
        Holder<ConfiguredFeature<?, ?>> treePlcmntHolder12 = holdergetter.getOrThrow(ModTreeFeatures.CORRUPTED_MEGA_JUNGLE_TREE_KEY);
        Holder<ConfiguredFeature<?, ?>> treePlcmntHolder13 = holdergetter.getOrThrow(ModTreeFeatures.CORRUPTED_MEGA_SPRUCE_KEY);
        Holder<ConfiguredFeature<?, ?>> treePlcmntHolder14 = holdergetter.getOrThrow(ModTreeFeatures.CORRUPTED_MEGA_PINE_KEY);
        Holder<ConfiguredFeature<?, ?>> treePlcmntHolder15 = holdergetter.getOrThrow(ModTreeFeatures.CORRUPTED_TALL_MANGROVE_KEY);
        Holder<ConfiguredFeature<?, ?>> treePlcmntHolder16 = holdergetter.getOrThrow(ModTreeFeatures.CORRUPTED_JUNGLE_BUSH_KEY);

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
