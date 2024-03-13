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
        Holder<ConfiguredFeature<?, ?>> holder2 = holdergetter.getOrThrow(ModTreeFeatures.CORRUPTED_OAK_KEY);
        Holder<ConfiguredFeature<?, ?>> holder3 = holdergetter.getOrThrow(ModTreeFeatures.CORRUPTED_DARK_OAK_KEY);
        Holder<ConfiguredFeature<?, ?>> holder4 = holdergetter.getOrThrow(ModTreeFeatures.CORRUPTED_BIRCH_KEY);
        Holder<ConfiguredFeature<?, ?>> holder5 = holdergetter.getOrThrow(ModTreeFeatures.CORRUPTED_ACACIA_KEY);
        Holder<ConfiguredFeature<?, ?>> holder6 = holdergetter.getOrThrow(ModTreeFeatures.CORRUPTED_SPRUCE_KEY);
        Holder<ConfiguredFeature<?, ?>> holder7 = holdergetter.getOrThrow(ModTreeFeatures.CORRUPTED_MANGROVE_KEY);
        Holder<ConfiguredFeature<?, ?>> holder8 = holdergetter.getOrThrow(ModTreeFeatures.CORRUPTED_CHERRY_KEY);
        Holder<ConfiguredFeature<?, ?>> holder9 = holdergetter.getOrThrow(ModTreeFeatures.CORRUPTED_PINE_KEY);
        Holder<ConfiguredFeature<?, ?>> holder10 = holdergetter.getOrThrow(ModTreeFeatures.CORRUPTED_JUNGLE_TREE_KEY);
        Holder<ConfiguredFeature<?, ?>> holder11 = holdergetter.getOrThrow(ModTreeFeatures.CORRUPTED_FANCY_OAK_KEY);
        Holder<ConfiguredFeature<?, ?>> holder12 = holdergetter.getOrThrow(ModTreeFeatures.CORRUPTED_MEGA_JUNGLE_TREE_KEY);
        Holder<ConfiguredFeature<?, ?>> holder13 = holdergetter.getOrThrow(ModTreeFeatures.CORRUPTED_MEGA_SPRUCE_KEY);
        Holder<ConfiguredFeature<?, ?>> holder14 = holdergetter.getOrThrow(ModTreeFeatures.CORRUPTED_MEGA_PINE_KEY);
        Holder<ConfiguredFeature<?, ?>> holder15 = holdergetter.getOrThrow(ModTreeFeatures.CORRUPTED_TALL_MANGROVE_KEY);
        Holder<ConfiguredFeature<?, ?>> holder16 = holdergetter.getOrThrow(ModTreeFeatures.CORRUPTED_JUNGLE_BUSH_KEY);

        register(context, CORRUPTED_OAK_CHECKED, holder2, PlacementUtils.filteredByBlockSurvival(ModBlocks.CORRUPTED_OAK_SAPLING.get()));
        register(context, CORRUPTED_DARK_OAK_CHECKED, holder3, PlacementUtils.filteredByBlockSurvival(ModBlocks.CORRUPTED_DARK_OAK_SAPLING.get()));
        register(context, CORRUPTED_BIRCH_CHECKED, holder4, PlacementUtils.filteredByBlockSurvival(ModBlocks.CORRUPTED_BIRCH_SAPLING.get()));
        register(context, CORRUPTED_ACACIA_CHECKED, holder5, PlacementUtils.filteredByBlockSurvival(ModBlocks.CORRUPTED_ACACIA_SAPLING.get()));
        register(context, CORRUPTED_SPRUCE_CHECKED, holder6, PlacementUtils.filteredByBlockSurvival(ModBlocks.CORRUPTED_SPRUCE_SAPLING.get()));
        register(context, CORRUPTED_MANGROVE_CHECKED, holder7, PlacementUtils.filteredByBlockSurvival(ModBlocks.CORRUPTED_MANGROVE_PROPAGULE.get()));
        register(context, CORRUPTED_CHERRY_CHECKED, holder8, PlacementUtils.filteredByBlockSurvival(ModBlocks.CORRUPTED_CHERRY_SAPLING.get()));
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
