package net.alberdrocs.darkaethercorruptionmod.worldgen.biome;

import net.alberdrocs.darkaethercorruptionmod.entity.ModEntities;
import net.alberdrocs.darkaethercorruptionmod.worldgen.ModPlacedFeatures;
import net.minecraft.data.worldgen.placement.CavePlacements;
import net.minecraft.data.worldgen.placement.MiscOverworldPlacements;
import net.minecraft.data.worldgen.placement.OrePlacements;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.levelgen.GenerationStep;

public class ModBiomeDefaultFeatures {
    public static void darkAetherSpawns(MobSpawnSettings.Builder pBuilder) {
        pBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(ModEntities.DARK_AETHER_ZOMBIE.get(), 7, 4, 12));
        pBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(ModEntities.SCREAMER.get(), 5, 3, 10));
        pBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(ModEntities.TEMPEST.get(), 4, 2, 6));
        pBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(ModEntities.MIMIC.get(), 2, 1, 5));
    }

    public static void addPlainGrass(BiomeGenerationSettings.Builder pBuilder) {
        pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.CORRUPTED_PATCH_TALL_GRASS_2);
    }

    public static void addPlainVegetation(BiomeGenerationSettings.Builder pBuilder) {
        pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.CORRUPTED_TREES_PLAINS);
        pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.CORRUPTED_PATCH_GRASS_PLAIN);
    }

    public static void addDefaultGrass(BiomeGenerationSettings.Builder pBuilder) {
        pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.CORRUPTED_PATCH_GRASS_BADLANDS);
    }

    public static void addDesertVegetation(BiomeGenerationSettings.Builder pBuilder) {
        pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.CORRUPTED_PATCH_DEAD_BUSH_2);
    }

    public static void addForestGrass(BiomeGenerationSettings.Builder pBuilder) {
        pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.CORRUPTED_PATCH_GRASS_FOREST);
    }

    public static void addSwampVegetation(BiomeGenerationSettings.Builder pBuilder) {
        pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.CORRUPTED_TREES_SWAMP);
        pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.CORRUPTED_PATCH_GRASS_NORMAL);
        pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.CORRUPTED_PATCH_DEAD_BUSH);
    }

    public static void addTaigaTrees(BiomeGenerationSettings.Builder pBuilder) {
        pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.CORRUPTED_TREES_TAIGA);
    }

    public static void addTaigaGrass(BiomeGenerationSettings.Builder pBuilder) {
        pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.CORRUPTED_PATCH_GRASS_TAIGA_2);
    }

    public static void addMountainTrees(BiomeGenerationSettings.Builder pBuilder) {
        pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.CORRUPTED_TREES_WINDSWEPT_HILLS);
    }

    public static void addMountainForestTrees(BiomeGenerationSettings.Builder pBuilder) {
        pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.CORRUPTED_TREES_WINDSWEPT_FOREST);
    }

    public static void addGroveTrees(BiomeGenerationSettings.Builder pBuilder) {
        pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.CORRUPTED_TREES_GROVE);
    }

    public static void addWaterTrees(BiomeGenerationSettings.Builder pBuilder) {
        pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.CORRUPTED_TREES_WATER);
    }

    public static void addBirchTrees(BiomeGenerationSettings.Builder pBuilder) {
        pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.CORRUPTED_TREES_BIRCH);
    }

    public static void addOtherBirchTrees(BiomeGenerationSettings.Builder pBuilder) {
        pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.CORRUPTED_TREES_BIRCH_AND_OAK);
    }

    public static void addTallBirchTrees(BiomeGenerationSettings.Builder pBuilder) {
        pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.CORRUPTED_BIRCH_TALL);
    }

    public static void addFerns(BiomeGenerationSettings.Builder pBuilder) {
        pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.CORRUPTED_PATCH_LARGE_FERN);
    }

    public static void addSavannaGrass(BiomeGenerationSettings.Builder pBuilder) {
        pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.CORRUPTED_PATCH_TALL_GRASS);
    }

    public static void addShatteredSavannaGrass(BiomeGenerationSettings.Builder pBuilder) {
        pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.CORRUPTED_PATCH_GRASS_NORMAL);
    }

    public static void addSavannaExtraGrass(BiomeGenerationSettings.Builder pBuilder) {
        pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.CORRUPTED_PATCH_GRASS_SAVANNA);
    }

    public static void addSavannaTrees(BiomeGenerationSettings.Builder pBuilder) {
        pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.CORRUPTED_TREES_SAVANNA);
    }

    public static void addShatteredSavannaTrees(BiomeGenerationSettings.Builder pBuilder) {
        pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.CORRUPTED_TREES_WINDSWEPT_SAVANNA);
    }

    public static void addGiantTaigaVegetation(BiomeGenerationSettings.Builder pBuilder) {
        pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.CORRUPTED_PATCH_GRASS_TAIGA);
        pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.CORRUPTED_PATCH_DEAD_BUSH);
    }

    public static void addDefaultSoftDisks(BiomeGenerationSettings.Builder pBuilder) {
        pBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, MiscOverworldPlacements.DISK_SAND);
        pBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, MiscOverworldPlacements.DISK_CLAY);
        pBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, MiscOverworldPlacements.DISK_GRAVEL);
    }

    public static void addDefaultOres(BiomeGenerationSettings.Builder pBuilder) {
        addDefaultOres(pBuilder, false);
    }

    public static void addDefaultOres(BiomeGenerationSettings.Builder pBuilder, boolean pLargeOres) {
        pBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, OrePlacements.ORE_COAL_UPPER);
        pBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, OrePlacements.ORE_COAL_LOWER);
        pBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, OrePlacements.ORE_IRON_UPPER);
        pBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, OrePlacements.ORE_IRON_MIDDLE);
        pBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, OrePlacements.ORE_IRON_SMALL);
        pBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, OrePlacements.ORE_GOLD);
        pBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, OrePlacements.ORE_GOLD_LOWER);
        pBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, OrePlacements.ORE_REDSTONE);
        pBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, OrePlacements.ORE_REDSTONE_LOWER);
        pBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, OrePlacements.ORE_DIAMOND);
        pBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, OrePlacements.ORE_DIAMOND_LARGE);
        pBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, OrePlacements.ORE_DIAMOND_BURIED);
        pBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, OrePlacements.ORE_LAPIS);
        pBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, OrePlacements.ORE_LAPIS_BURIED);
        pBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, pLargeOres ? OrePlacements.ORE_COPPER_LARGE : OrePlacements.ORE_COPPER);
        pBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, CavePlacements.UNDERWATER_MAGMA);
    }
}
