package net.alberdrocs.darkaethercorruptionmod.worldgen.biome;

import net.alberdrocs.darkaethercorruptionmod.DarkAetherCorruptionMod;
import net.alberdrocs.darkaethercorruptionmod.entity.ModEntities;
import net.alberdrocs.darkaethercorruptionmod.sound.ModSounds;
import net.alberdrocs.darkaethercorruptionmod.worldgen.ModPlacedFeatures;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.biome.OverworldBiomes;
import net.minecraft.data.worldgen.placement.AquaticPlacements;
import net.minecraft.data.worldgen.placement.MiscOverworldPlacements;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.Music;
import net.minecraft.sounds.Musics;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.*;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.carver.ConfiguredWorldCarver;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import org.jetbrains.annotations.NotNull;

public class ModBiomes {
    public static final ResourceKey<Biome> DA_PLAINS = ResourceKey.create(Registries.BIOME,
            new ResourceLocation(DarkAetherCorruptionMod.MOD_ID, "da_plains"));
    public static final ResourceKey<Biome> DA_SUNFLOWER_PLAINS = ResourceKey.create(Registries.BIOME,
            new ResourceLocation(DarkAetherCorruptionMod.MOD_ID, "da_sunflower_plains"));
    public static final ResourceKey<Biome> DA_SNOWY_PLAINS = ResourceKey.create(Registries.BIOME,
            new ResourceLocation(DarkAetherCorruptionMod.MOD_ID, "da_snowy_plains"));
    public static final ResourceKey<Biome> DA_ICE_SPIKES = ResourceKey.create(Registries.BIOME,
            new ResourceLocation(DarkAetherCorruptionMod.MOD_ID, "da_ice_spikes"));
    public static final ResourceKey<Biome> DA_DESERT = ResourceKey.create(Registries.BIOME,
            new ResourceLocation(DarkAetherCorruptionMod.MOD_ID, "da_desert"));
    public static final ResourceKey<Biome> DA_SWAMP = ResourceKey.create(Registries.BIOME,
            new ResourceLocation(DarkAetherCorruptionMod.MOD_ID, "da_swamp"));
    public static final ResourceKey<Biome> DA_MANGROVE_SWAMP = ResourceKey.create(Registries.BIOME,
            new ResourceLocation(DarkAetherCorruptionMod.MOD_ID, "da_mangrove_swamp"));
    public static final ResourceKey<Biome> DA_FOREST = ResourceKey.create(Registries.BIOME,
            new ResourceLocation(DarkAetherCorruptionMod.MOD_ID, "da_forest"));
    public static final ResourceKey<Biome> DA_FLOWER_FOREST = ResourceKey.create(Registries.BIOME,
            new ResourceLocation(DarkAetherCorruptionMod.MOD_ID, "da_flower_forest"));
    public static final ResourceKey<Biome> DA_BIRCH_FOREST = ResourceKey.create(Registries.BIOME,
            new ResourceLocation(DarkAetherCorruptionMod.MOD_ID, "da_birch_forest"));
    public static final ResourceKey<Biome> DA_DARK_FOREST = ResourceKey.create(Registries.BIOME,
            new ResourceLocation(DarkAetherCorruptionMod.MOD_ID, "da_dark_forest"));
    public static final ResourceKey<Biome> DA_OLD_GROWTH_BIRCH_FOREST = ResourceKey.create(Registries.BIOME,
            new ResourceLocation(DarkAetherCorruptionMod.MOD_ID, "da_old_growth_birch_forest"));
    public static final ResourceKey<Biome> DA_OLD_GROWTH_PINE_TAIGA = ResourceKey.create(Registries.BIOME,
            new ResourceLocation(DarkAetherCorruptionMod.MOD_ID, "da_old_growth_pine_taiga"));
    public static final ResourceKey<Biome> DA_OLD_GROWTH_SPRUCE_TAIGA = ResourceKey.create(Registries.BIOME,
            new ResourceLocation(DarkAetherCorruptionMod.MOD_ID, "da_old_growth_spruce_taiga"));
    public static final ResourceKey<Biome> DA_TAIGA = ResourceKey.create(Registries.BIOME,
            new ResourceLocation(DarkAetherCorruptionMod.MOD_ID, "da_taiga"));
    public static final ResourceKey<Biome> DA_SNOWY_TAIGA = ResourceKey.create(Registries.BIOME,
            new ResourceLocation(DarkAetherCorruptionMod.MOD_ID, "da_snowy_taiga"));
    public static final ResourceKey<Biome> DA_SAVANNA = ResourceKey.create(Registries.BIOME,
            new ResourceLocation(DarkAetherCorruptionMod.MOD_ID, "savanna"));
    public static final ResourceKey<Biome> DA_SAVANNA_PLATEAU = ResourceKey.create(Registries.BIOME,
            new ResourceLocation(DarkAetherCorruptionMod.MOD_ID, "savanna_plateau"));
    public static final ResourceKey<Biome> DA_WINDSWEPT_HILLS = ResourceKey.create(Registries.BIOME,
            new ResourceLocation(DarkAetherCorruptionMod.MOD_ID, "windswept_hills"));
    public static final ResourceKey<Biome> DA_WINDSWEPT_GRAVELLY_HILLS = ResourceKey.create(Registries.BIOME,
            new ResourceLocation(DarkAetherCorruptionMod.MOD_ID, "windswept_gravelly_hills"));
    public static final ResourceKey<Biome> DA_WINDSWEPT_FOREST = ResourceKey.create(Registries.BIOME,
            new ResourceLocation(DarkAetherCorruptionMod.MOD_ID, "windswept_forest"));
    public static final ResourceKey<Biome> DA_WINDSWEPT_SAVANNA = ResourceKey.create(Registries.BIOME,
            new ResourceLocation(DarkAetherCorruptionMod.MOD_ID, "windswept_savanna"));

    public static void boostrap(BootstapContext<Biome> context) {
        context.register(DA_PLAINS, daPlains(context));
        context.register(DA_SUNFLOWER_PLAINS, daPlains(context));
        context.register(DA_SNOWY_PLAINS, daPlains(context));
        context.register(DA_ICE_SPIKES, daPlains(context));
        context.register(DA_DESERT, daDesert(context));
        context.register(DA_SWAMP, daSwamp(context));
        context.register(DA_MANGROVE_SWAMP, daMangroveSwamp(context));
        context.register(DA_FOREST, daForest(context, false, false, false));
        context.register(DA_FLOWER_FOREST, daForest(context, false, false, true));
        context.register(DA_BIRCH_FOREST, daForest(context, true, false, false));
        context.register(DA_DARK_FOREST, daDarkForest(context));
        context.register(DA_OLD_GROWTH_BIRCH_FOREST, daForest(context, true, true, false));
        context.register(DA_OLD_GROWTH_PINE_TAIGA, daOldGrowthTaiga(context, false));
        context.register(DA_OLD_GROWTH_SPRUCE_TAIGA, daOldGrowthTaiga(context, true));
        context.register(DA_TAIGA, daTaiga(context));
        context.register(DA_SNOWY_TAIGA, daTaiga(context));
        context.register(DA_SAVANNA, daSavanna(context, false));
        context.register(DA_SAVANNA_PLATEAU, daSavanna(context, false));
        context.register(DA_WINDSWEPT_HILLS, daWindsweptHills(context, false));
        context.register(DA_WINDSWEPT_GRAVELLY_HILLS, daWindsweptHills(context, false));
        context.register(DA_WINDSWEPT_FOREST, daWindsweptHills(context, true));
        context.register(DA_WINDSWEPT_SAVANNA, daSavanna(context, true));
    }

    public static void globalOverworldGeneration(BiomeGenerationSettings.Builder builder) {
        BiomeDefaultFeatures.addDefaultCarversAndLakes(builder);
        BiomeDefaultFeatures.addDefaultCrystalFormations(builder);
        BiomeDefaultFeatures.addDefaultMonsterRoom(builder);
        BiomeDefaultFeatures.addDefaultUndergroundVariety(builder);
        BiomeDefaultFeatures.addDefaultSprings(builder);
        //BiomeDefaultFeatures.addSurfaceFreezing(builder);
    }

    @NotNull
    private static Biome getBiomeBuild(BiomeGenerationSettings.Builder biomegenerationsettings$builder, MobSpawnSettings.Builder mobspawnsettings$builder, Music music) {
        return new Biome.BiomeBuilder()
                .hasPrecipitation(true)
                .downfall(0.8f)
                .temperature(0.7f)
                .generationSettings(biomegenerationsettings$builder.build())
                .mobSpawnSettings(mobspawnsettings$builder.build())
                .specialEffects((new BiomeSpecialEffects.Builder())
                        .waterColor(0xe82e3b)
                        .waterFogColor(0xbf1b26)
                        .skyColor(0x30c918)
                        .grassColorOverride(0x7f03fc)
                        .foliageColorOverride(0xd203fc)
                        .fogColor(0x22a1e6)
                        .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)
                        .backgroundMusic(music).build())
                .build();
    }

    private static Biome daPlains(BootstapContext<Biome> context) {
        MobSpawnSettings.Builder mobspawnsettings$builder = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder biomegenerationsettings$builder =
                new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));
        globalOverworldGeneration(biomegenerationsettings$builder);

        ModBiomeDefaultFeatures.darkAetherSpawns(mobspawnsettings$builder);
        ModBiomeDefaultFeatures.addPlainGrass(biomegenerationsettings$builder);

        ModBiomeDefaultFeatures.addDefaultOres(biomegenerationsettings$builder);
        ModBiomeDefaultFeatures.addDefaultSoftDisks(biomegenerationsettings$builder);

        ModBiomeDefaultFeatures.addPlainVegetation(biomegenerationsettings$builder);

        //BiomeDefaultFeatures.addDefaultMushrooms(biomegenerationsettings$builder);

        //BiomeDefaultFeatures.addDefaultExtraVegetation(biomegenerationsettings$builder);

        return getBiomeBuild(biomegenerationsettings$builder, mobspawnsettings$builder, Musics.createGameMusic(SoundEvents.AMBIENT_CAVE));
    }

    private static Biome daDesert(BootstapContext<Biome> context) {
        MobSpawnSettings.Builder mobspawnsettings$builder = new MobSpawnSettings.Builder();
        ModBiomeDefaultFeatures.darkAetherSpawns(mobspawnsettings$builder);
        BiomeGenerationSettings.Builder biomegenerationsettings$builder =
                new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));
        //BiomeDefaultFeatures.addFossilDecoration(biomegenerationsettings$builder);
        globalOverworldGeneration(biomegenerationsettings$builder);
        ModBiomeDefaultFeatures.addDefaultOres(biomegenerationsettings$builder);
        ModBiomeDefaultFeatures.addDefaultSoftDisks(biomegenerationsettings$builder);
        //BiomeDefaultFeatures.addDefaultFlowers(biomegenerationsettings$builder);
        ModBiomeDefaultFeatures.addDefaultGrass(biomegenerationsettings$builder);
        ModBiomeDefaultFeatures.addDesertVegetation(biomegenerationsettings$builder);
        //BiomeDefaultFeatures.addDefaultMushrooms(biomegenerationsettings$builder);
        //BiomeDefaultFeatures.addDesertExtraVegetation(biomegenerationsettings$builder);
        //BiomeDefaultFeatures.addDesertExtraDecoration(biomegenerationsettings$builder);
        return getBiomeBuild(biomegenerationsettings$builder, mobspawnsettings$builder, Musics.createGameMusic(SoundEvents.MUSIC_BIOME_DESERT));
    }

    private static Biome daSwamp(BootstapContext<Biome> context) {
        MobSpawnSettings.Builder mobspawnsettings$builder = new MobSpawnSettings.Builder();
        ModBiomeDefaultFeatures.darkAetherSpawns(mobspawnsettings$builder);
        BiomeGenerationSettings.Builder biomegenerationsettings$builder =
                new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));
        //BiomeDefaultFeatures.addFossilDecoration(biomegenerationsettings$builder);
        globalOverworldGeneration(biomegenerationsettings$builder);
        ModBiomeDefaultFeatures.addDefaultOres(biomegenerationsettings$builder);
        BiomeDefaultFeatures.addSwampClayDisk(biomegenerationsettings$builder);
        ModBiomeDefaultFeatures.addSwampVegetation(biomegenerationsettings$builder);
        //BiomeDefaultFeatures.addDefaultMushrooms(biomegenerationsettings$builder);
        //BiomeDefaultFeatures.addSwampExtraVegetation(biomegenerationsettings$builder);
        //biomegenerationsettings$builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, AquaticPlacements.SEAGRASS_SWAMP);
        Music music = Musics.createGameMusic(SoundEvents.MUSIC_BIOME_SWAMP);
        return getBiomeBuild(biomegenerationsettings$builder, mobspawnsettings$builder, music);
        }

    private static Biome daMangroveSwamp(BootstapContext<Biome> context) {
        MobSpawnSettings.Builder mobspawnsettings$builder = new MobSpawnSettings.Builder();
        ModBiomeDefaultFeatures.darkAetherSpawns(mobspawnsettings$builder);
        BiomeGenerationSettings.Builder biomegenerationsettings$builder =
                new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));
        //BiomeDefaultFeatures.addFossilDecoration(biomegenerationsettings$builder);
        globalOverworldGeneration(biomegenerationsettings$builder);
        ModBiomeDefaultFeatures.addDefaultOres(biomegenerationsettings$builder);
        BiomeDefaultFeatures.addSwampClayDisk(biomegenerationsettings$builder);
        ModBiomeDefaultFeatures.addSwampVegetation(biomegenerationsettings$builder);
        //BiomeDefaultFeatures.addDefaultMushrooms(biomegenerationsettings$builder);
        //BiomeDefaultFeatures.addSwampExtraVegetation(biomegenerationsettings$builder);
        //biomegenerationsettings$builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, AquaticPlacements.SEAGRASS_SWAMP);
        Music music = Musics.createGameMusic(SoundEvents.MUSIC_BIOME_SWAMP);
        return getBiomeBuild(biomegenerationsettings$builder, mobspawnsettings$builder, music);
    }

    private static Biome daForest(BootstapContext<Biome> context, boolean pIsBirchForest, boolean pTallBirchTrees, boolean pIsFlowerForest) {
        BiomeGenerationSettings.Builder biomegenerationsettings$builder =
            new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));
        globalOverworldGeneration(biomegenerationsettings$builder);
        Music music = Musics.createGameMusic(SoundEvents.MUSIC_BIOME_FOREST);

        ModBiomeDefaultFeatures.addDefaultOres(biomegenerationsettings$builder);
        ModBiomeDefaultFeatures.addDefaultSoftDisks(biomegenerationsettings$builder);
        if (pIsFlowerForest) {
            ModBiomeDefaultFeatures.addDefaultGrass(biomegenerationsettings$builder);
        } else {
            if (pIsBirchForest) {
                if (pTallBirchTrees) {
                    ModBiomeDefaultFeatures.addTallBirchTrees(biomegenerationsettings$builder);
                } else {
                    ModBiomeDefaultFeatures.addBirchTrees(biomegenerationsettings$builder);
                }
            } else {
                ModBiomeDefaultFeatures.addOtherBirchTrees(biomegenerationsettings$builder);
            }

            //BiomeDefaultFeatures.addDefaultFlowers(biomegenerationsettings$builder);
            ModBiomeDefaultFeatures.addForestGrass(biomegenerationsettings$builder);
        }

        //BiomeDefaultFeatures.addDefaultMushrooms(biomegenerationsettings$builder);
        //BiomeDefaultFeatures.addDefaultExtraVegetation(biomegenerationsettings$builder);
        MobSpawnSettings.Builder mobspawnsettings$builder = new MobSpawnSettings.Builder();
        ModBiomeDefaultFeatures.darkAetherSpawns(mobspawnsettings$builder);
        return getBiomeBuild(biomegenerationsettings$builder, mobspawnsettings$builder, music);
    }

    public static Biome daTaiga(BootstapContext<Biome> context) {
        MobSpawnSettings.Builder mobspawnsettings$builder = new MobSpawnSettings.Builder();
        ModBiomeDefaultFeatures.darkAetherSpawns(mobspawnsettings$builder);
        BiomeGenerationSettings.Builder biomegenerationsettings$builder =
                new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));
        globalOverworldGeneration(biomegenerationsettings$builder);
        ModBiomeDefaultFeatures.addFerns(biomegenerationsettings$builder);
        ModBiomeDefaultFeatures.addDefaultOres(biomegenerationsettings$builder);
        ModBiomeDefaultFeatures.addDefaultSoftDisks(biomegenerationsettings$builder);
        ModBiomeDefaultFeatures.addTaigaTrees(biomegenerationsettings$builder);
        //BiomeDefaultFeatures.addDefaultFlowers(biomegenerationsettings$builder);
        ModBiomeDefaultFeatures.addTaigaGrass(biomegenerationsettings$builder);
        //BiomeDefaultFeatures.addDefaultExtraVegetation(biomegenerationsettings$builder);
        Music music = Musics.createGameMusic(SoundEvents.MUSIC_BIOME_FOREST);
        return getBiomeBuild(biomegenerationsettings$builder, mobspawnsettings$builder, music);
    }

    public static Biome daDarkForest(BootstapContext<Biome> context) {
        MobSpawnSettings.Builder mobspawnsettings$builder = new MobSpawnSettings.Builder();
        ModBiomeDefaultFeatures.darkAetherSpawns(mobspawnsettings$builder);
        BiomeGenerationSettings.Builder biomegenerationsettings$builder =
                new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));
        globalOverworldGeneration(biomegenerationsettings$builder);
        biomegenerationsettings$builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.CORRUPTED_DARK_FOREST_VEGETATION);
        //BiomeDefaultFeatures.addForestFlowers(biomegenerationsettings$builder);
        ModBiomeDefaultFeatures.addDefaultOres(biomegenerationsettings$builder);
        ModBiomeDefaultFeatures.addDefaultSoftDisks(biomegenerationsettings$builder);
        //BiomeDefaultFeatures.addDefaultFlowers(biomegenerationsettings$builder);
        ModBiomeDefaultFeatures.addForestGrass(biomegenerationsettings$builder);
        //BiomeDefaultFeatures.addDefaultMushrooms(biomegenerationsettings$builder);
        //BiomeDefaultFeatures.addDefaultExtraVegetation(biomegenerationsettings$builder);
        Music music = Musics.createGameMusic(SoundEvents.MUSIC_BIOME_FOREST);
        return getBiomeBuild(biomegenerationsettings$builder, mobspawnsettings$builder, music);
    }

    private static Biome daOldGrowthTaiga(BootstapContext<Biome> context, boolean pIsSpruce) {
        MobSpawnSettings.Builder mobspawnsettings$builder = new MobSpawnSettings.Builder();
        ModBiomeDefaultFeatures.darkAetherSpawns(mobspawnsettings$builder);

        BiomeGenerationSettings.Builder biomegenerationsettings$builder =
                new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));
        globalOverworldGeneration(biomegenerationsettings$builder);
        //BiomeDefaultFeatures.addMossyStoneBlock(biomegenerationsettings$builder);
        ModBiomeDefaultFeatures.addFerns(biomegenerationsettings$builder);
        ModBiomeDefaultFeatures.addDefaultOres(biomegenerationsettings$builder);
        ModBiomeDefaultFeatures.addDefaultSoftDisks(biomegenerationsettings$builder);
        biomegenerationsettings$builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, pIsSpruce ? ModPlacedFeatures.CORRUPTED_TREES_OLD_GROWTH_SPRUCE_TAIGA : ModPlacedFeatures.CORRUPTED_TREES_OLD_GROWTH_PINE_TAIGA);
        //BiomeDefaultFeatures.addDefaultFlowers(biomegenerationsettings$builder);
        ModBiomeDefaultFeatures.addGiantTaigaVegetation(biomegenerationsettings$builder);
        //BiomeDefaultFeatures.addDefaultMushrooms(biomegenerationsettings$builder);
        //BiomeDefaultFeatures.addDefaultExtraVegetation(biomegenerationsettings$builder);
        //BiomeDefaultFeatures.addCommonBerryBushes(biomegenerationsettings$builder);
        Music music = Musics.createGameMusic(SoundEvents.MUSIC_BIOME_OLD_GROWTH_TAIGA);
        return getBiomeBuild(biomegenerationsettings$builder, mobspawnsettings$builder, music);
    }

    public static Biome daSavanna(BootstapContext<Biome> context, boolean pIsShatteredSavanna) {
        BiomeGenerationSettings.Builder biomegenerationsettings$builder =
                new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));
        globalOverworldGeneration(biomegenerationsettings$builder);
        if (!pIsShatteredSavanna) {
            ModBiomeDefaultFeatures.addSavannaGrass(biomegenerationsettings$builder);
        }

        ModBiomeDefaultFeatures.addDefaultOres(biomegenerationsettings$builder);
        ModBiomeDefaultFeatures.addDefaultSoftDisks(biomegenerationsettings$builder);
        if (pIsShatteredSavanna) {
            ModBiomeDefaultFeatures.addShatteredSavannaTrees(biomegenerationsettings$builder);
            //BiomeDefaultFeatures.addDefaultFlowers(biomegenerationsettings$builder);
            ModBiomeDefaultFeatures.addShatteredSavannaGrass(biomegenerationsettings$builder);
        } else {
            ModBiomeDefaultFeatures.addSavannaTrees(biomegenerationsettings$builder);
            //BiomeDefaultFeatures.addWarmFlowers(biomegenerationsettings$builder);
            ModBiomeDefaultFeatures.addSavannaExtraGrass(biomegenerationsettings$builder);
        }

        //BiomeDefaultFeatures.addDefaultMushrooms(biomegenerationsettings$builder);
        //BiomeDefaultFeatures.addDefaultExtraVegetation(biomegenerationsettings$builder);
        MobSpawnSettings.Builder mobspawnsettings$builder = new MobSpawnSettings.Builder();
        ModBiomeDefaultFeatures.darkAetherSpawns(mobspawnsettings$builder);
        Music music = Musics.createGameMusic(SoundEvents.MUSIC_BIOME_OLD_GROWTH_TAIGA);
        return getBiomeBuild(biomegenerationsettings$builder, mobspawnsettings$builder, music);
    }



    public static Biome daWindsweptHills(BootstapContext<Biome> context, boolean pIsForest) {
        MobSpawnSettings.Builder mobspawnsettings$builder = new MobSpawnSettings.Builder();
        ModBiomeDefaultFeatures.darkAetherSpawns(mobspawnsettings$builder);
        BiomeGenerationSettings.Builder biomegenerationsettings$builder =
                new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));
        globalOverworldGeneration(biomegenerationsettings$builder);
        ModBiomeDefaultFeatures.addDefaultOres(biomegenerationsettings$builder);
        ModBiomeDefaultFeatures.addDefaultSoftDisks(biomegenerationsettings$builder);
        if (pIsForest) {
            ModBiomeDefaultFeatures.addMountainForestTrees(biomegenerationsettings$builder);
        } else {
            ModBiomeDefaultFeatures.addMountainTrees(biomegenerationsettings$builder);
        }

        //BiomeDefaultFeatures.addDefaultFlowers(biomegenerationsettings$builder);
        ModBiomeDefaultFeatures.addDefaultGrass(biomegenerationsettings$builder);
        //BiomeDefaultFeatures.addDefaultMushrooms(biomegenerationsettings$builder);
        //BiomeDefaultFeatures.addDefaultExtraVegetation(biomegenerationsettings$builder);
        //BiomeDefaultFeatures.addExtraEmeralds(biomegenerationsettings$builder);
        //BiomeDefaultFeatures.addInfestedStone(biomegenerationsettings$builder);
        Music music = Musics.createGameMusic(SoundEvents.MUSIC_BIOME_OLD_GROWTH_TAIGA);
        return getBiomeBuild(biomegenerationsettings$builder, mobspawnsettings$builder, music);
    }
}