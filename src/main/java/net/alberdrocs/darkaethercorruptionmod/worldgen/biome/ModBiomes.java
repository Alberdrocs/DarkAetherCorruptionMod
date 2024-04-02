package net.alberdrocs.darkaethercorruptionmod.worldgen.biome;

import net.alberdrocs.darkaethercorruptionmod.DarkAetherCorruptionMod;
import net.alberdrocs.darkaethercorruptionmod.worldgen.ModPlacedFeatures;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.Carvers;
import net.minecraft.data.worldgen.biome.OverworldBiomes;
import net.minecraft.data.worldgen.placement.AquaticPlacements;
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
            new ResourceLocation(DarkAetherCorruptionMod.MOD_ID, "da_savanna"));
    public static final ResourceKey<Biome> DA_SAVANNA_PLATEAU = ResourceKey.create(Registries.BIOME,
            new ResourceLocation(DarkAetherCorruptionMod.MOD_ID, "da_savanna_plateau"));
    public static final ResourceKey<Biome> DA_WINDSWEPT_HILLS = ResourceKey.create(Registries.BIOME,
            new ResourceLocation(DarkAetherCorruptionMod.MOD_ID, "da_windswept_hills"));
    public static final ResourceKey<Biome> DA_WINDSWEPT_GRAVELLY_HILLS = ResourceKey.create(Registries.BIOME,
            new ResourceLocation(DarkAetherCorruptionMod.MOD_ID, "da_windswept_gravelly_hills"));
    public static final ResourceKey<Biome> DA_WINDSWEPT_FOREST = ResourceKey.create(Registries.BIOME,
            new ResourceLocation(DarkAetherCorruptionMod.MOD_ID, "da_windswept_forest"));
    public static final ResourceKey<Biome> DA_WINDSWEPT_SAVANNA = ResourceKey.create(Registries.BIOME,
            new ResourceLocation(DarkAetherCorruptionMod.MOD_ID, "da_windswept_savanna"));
    public static final ResourceKey<Biome> DA_JUNGLE = ResourceKey.create(Registries.BIOME,
            new ResourceLocation(DarkAetherCorruptionMod.MOD_ID, "da_jungle"));
    public static final ResourceKey<Biome> DA_SPARSE_JUNGLE = ResourceKey.create(Registries.BIOME,
            new ResourceLocation(DarkAetherCorruptionMod.MOD_ID, "da_sparse_jungle"));
    public static final ResourceKey<Biome> DA_BAMBOO_JUNGLE = ResourceKey.create(Registries.BIOME,
            new ResourceLocation(DarkAetherCorruptionMod.MOD_ID, "da_bamboo_jungle"));
    public static final ResourceKey<Biome> DA_BADLANDS = ResourceKey.create(Registries.BIOME,
            new ResourceLocation(DarkAetherCorruptionMod.MOD_ID, "da_badlands"));
    public static final ResourceKey<Biome> DA_ERODED_BADLANDS = ResourceKey.create(Registries.BIOME,
            new ResourceLocation(DarkAetherCorruptionMod.MOD_ID, "da_eroded_badlands"));
    public static final ResourceKey<Biome> DA_WOODED_BADLANDS = ResourceKey.create(Registries.BIOME,
            new ResourceLocation(DarkAetherCorruptionMod.MOD_ID, "da_wooded_badlands"));
    public static final ResourceKey<Biome> DA_MEADOW = ResourceKey.create(Registries.BIOME,
            new ResourceLocation(DarkAetherCorruptionMod.MOD_ID, "da_meadow"));
    public static final ResourceKey<Biome> DA_CHERRY_GROVE = ResourceKey.create(Registries.BIOME,
            new ResourceLocation(DarkAetherCorruptionMod.MOD_ID, "da_cherry_grove"));
    public static final ResourceKey<Biome> DA_GROVE = ResourceKey.create(Registries.BIOME,
            new ResourceLocation(DarkAetherCorruptionMod.MOD_ID, "da_grove"));
    public static final ResourceKey<Biome> DA_SNOWY_SLOPES = ResourceKey.create(Registries.BIOME,
            new ResourceLocation(DarkAetherCorruptionMod.MOD_ID,"da_snowy_slopes"));
    public static final ResourceKey<Biome> DA_FROZEN_PEAKS = ResourceKey.create(Registries.BIOME,
            new ResourceLocation(DarkAetherCorruptionMod.MOD_ID,"da_frozen_peaks"));
    public static final ResourceKey<Biome> DA_JAGGED_PEAKS = ResourceKey.create(Registries.BIOME,
            new ResourceLocation(DarkAetherCorruptionMod.MOD_ID,"da_jagged_peaks"));
    public static final ResourceKey<Biome> DA_STONY_PEAKS = ResourceKey.create(Registries.BIOME,
            new ResourceLocation(DarkAetherCorruptionMod.MOD_ID,"da_stony_peaks"));
    public static final ResourceKey<Biome> DA_RIVER = ResourceKey.create(Registries.BIOME,
            new ResourceLocation(DarkAetherCorruptionMod.MOD_ID,"da_river"));
    public static final ResourceKey<Biome> DA_FROZEN_RIVER = ResourceKey.create(Registries.BIOME,
            new ResourceLocation(DarkAetherCorruptionMod.MOD_ID,"da_frozen_river"));
    public static final ResourceKey<Biome> DA_BEACH = ResourceKey.create(Registries.BIOME,
            new ResourceLocation(DarkAetherCorruptionMod.MOD_ID,"da_beach"));
    public static final ResourceKey<Biome> DA_SNOWY_BEACH = ResourceKey.create(Registries.BIOME,
            new ResourceLocation(DarkAetherCorruptionMod.MOD_ID,"da_snowy_beach"));
    public static final ResourceKey<Biome> DA_STONY_SHORE = ResourceKey.create(Registries.BIOME,
            new ResourceLocation(DarkAetherCorruptionMod.MOD_ID,"da_stony_shore"));
    public static final ResourceKey<Biome> DA_WARM_OCEAN = ResourceKey.create(Registries.BIOME,
            new ResourceLocation(DarkAetherCorruptionMod.MOD_ID,"da_warm_ocean"));
    public static final ResourceKey<Biome> DA_LUKEWARM_OCEAN = ResourceKey.create(Registries.BIOME,
            new ResourceLocation(DarkAetherCorruptionMod.MOD_ID,"da_lukewarm_ocean"));
    public static final ResourceKey<Biome> DA_DEEP_LUKEWARM_OCEAN = ResourceKey.create(Registries.BIOME,
            new ResourceLocation(DarkAetherCorruptionMod.MOD_ID,"da_deep_lukewarm_ocean"));
    public static final ResourceKey<Biome> DA_OCEAN = ResourceKey.create(Registries.BIOME,
            new ResourceLocation(DarkAetherCorruptionMod.MOD_ID,"da_ocean"));
    public static final ResourceKey<Biome> DA_DEEP_OCEAN = ResourceKey.create(Registries.BIOME,
            new ResourceLocation(DarkAetherCorruptionMod.MOD_ID,"da_deep_ocean"));
    public static final ResourceKey<Biome> DA_COLD_OCEAN = ResourceKey.create(Registries.BIOME,
            new ResourceLocation(DarkAetherCorruptionMod.MOD_ID,"da_cold_ocean"));
    public static final ResourceKey<Biome> DA_DEEP_COLD_OCEAN = ResourceKey.create(Registries.BIOME,
            new ResourceLocation(DarkAetherCorruptionMod.MOD_ID,"da_deep_cold_ocean"));
    public static final ResourceKey<Biome> DA_FROZEN_OCEAN = ResourceKey.create(Registries.BIOME,
            new ResourceLocation(DarkAetherCorruptionMod.MOD_ID,"da_frozen_ocean"));
    public static final ResourceKey<Biome> DA_DEEP_FROZEN_OCEAN = ResourceKey.create(Registries.BIOME,
            new ResourceLocation(DarkAetherCorruptionMod.MOD_ID,"da_deep_frozen_ocean"));
    public static final ResourceKey<Biome> DA_MUSHROOM_FIELDS = ResourceKey.create(Registries.BIOME,
            new ResourceLocation(DarkAetherCorruptionMod.MOD_ID,"da_mushroom_fields"));
    public static final ResourceKey<Biome> DA_DRIPSTONE_CAVES = ResourceKey.create(Registries.BIOME,
            new ResourceLocation(DarkAetherCorruptionMod.MOD_ID,"da_dripstone_caves"));
    public static final ResourceKey<Biome> DA_LUSH_CAVES = ResourceKey.create(Registries.BIOME,
            new ResourceLocation(DarkAetherCorruptionMod.MOD_ID,"da_lush_caves"));
    public static final ResourceKey<Biome> DA_DEEP_DARK = ResourceKey.create(Registries.BIOME,
            new ResourceLocation(DarkAetherCorruptionMod.MOD_ID,"da_deep_dark"));

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
        context.register(DA_JUNGLE, daJungle(context));
        context.register(DA_SPARSE_JUNGLE, daSparseJungle(context));
        context.register(DA_BAMBOO_JUNGLE, daBambooJungle(context));
        context.register(DA_BADLANDS, daBadlands(context, false));
        context.register(DA_ERODED_BADLANDS, daBadlands(context, false));
        context.register(DA_WOODED_BADLANDS, daBadlands(context, true));
        context.register(DA_MEADOW, daMeadowOrCherryGrove(context, false));
        context.register(DA_CHERRY_GROVE, daMeadowOrCherryGrove(context, true));
        context.register(DA_GROVE, daGrove(context));
        context.register(DA_SNOWY_SLOPES, daSnowySlopes(context));
        context.register(DA_FROZEN_PEAKS, daFrozenPeaks(context));
        context.register(DA_JAGGED_PEAKS, daJaggedPeaks(context));
        context.register(DA_STONY_PEAKS, daStonyPeaks(context));
        context.register(DA_RIVER, daRiver(context));
        context.register(DA_FROZEN_RIVER, daRiver(context));
        context.register(DA_BEACH, daBeach(context));
        context.register(DA_SNOWY_BEACH, daBeach(context));
        context.register(DA_STONY_SHORE, daBeach(context));
        context.register(DA_WARM_OCEAN, daWarmOcean(context));
        context.register(DA_LUKEWARM_OCEAN, daLukeWarmOcean(context, false));
        context.register(DA_DEEP_LUKEWARM_OCEAN, daLukeWarmOcean(context, true));
        context.register(DA_OCEAN, daOcean(context, false));
        context.register(DA_DEEP_OCEAN, daOcean(context, true));
        context.register(DA_COLD_OCEAN, daColdOcean(context, false));
        context.register(DA_DEEP_COLD_OCEAN, daColdOcean(context, true));
        context.register(DA_FROZEN_OCEAN, daFrozenOcean(context, false));
        context.register(DA_DEEP_FROZEN_OCEAN, daFrozenOcean(context, true));
        context.register(DA_MUSHROOM_FIELDS, daMushroomFields(context));
        context.register(DA_DRIPSTONE_CAVES, daDripstoneCaves(context));
        context.register(DA_LUSH_CAVES, daLushCaves(context));
        context.register(DA_DEEP_DARK, daDeepDark(context));
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
                .hasPrecipitation(false)
                .downfall(0.8f)
                .temperature(0.7f)
                .generationSettings(biomegenerationsettings$builder.build())
                .mobSpawnSettings(mobspawnsettings$builder.build())
                .specialEffects((new BiomeSpecialEffects.Builder())
                        .waterColor(0x36074d)
                        .waterFogColor(0x5c0985)
                        .skyColor(0x2f0847)
                        .grassColorOverride(0x7f03fc)
                        .foliageColorOverride(0xd203fc)
                        .fogColor(0x2d053b)
                        .ambientParticle(new AmbientParticleSettings(ParticleTypes.PORTAL, 0.5f))
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

        //ModBiomeDefaultFeatures.addDefaultMushrooms(biomegenerationsettings$builder);

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

    public static Biome daSparseJungle(BootstapContext<Biome> context) {
        MobSpawnSettings.Builder mobspawnsettings$builder = new MobSpawnSettings.Builder();
        ModBiomeDefaultFeatures.darkAetherSpawns(mobspawnsettings$builder);
        return daBaseJungle(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER), 0.8F, false, true, false, mobspawnsettings$builder, Musics.createGameMusic(SoundEvents.MUSIC_BIOME_SPARSE_JUNGLE));
    }

    public static Biome daJungle(BootstapContext<Biome> context) {
        MobSpawnSettings.Builder mobspawnsettings$builder = new MobSpawnSettings.Builder();
        ModBiomeDefaultFeatures.darkAetherSpawns(mobspawnsettings$builder);
        return daBaseJungle(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER), 0.9F, false, false, true, mobspawnsettings$builder, Musics.createGameMusic(SoundEvents.MUSIC_BIOME_JUNGLE));
    }

    public static Biome daBambooJungle(BootstapContext<Biome> context) {
        MobSpawnSettings.Builder mobspawnsettings$builder = new MobSpawnSettings.Builder();
        ModBiomeDefaultFeatures.darkAetherSpawns(mobspawnsettings$builder);
        return daBaseJungle(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER), 0.9F, true, false, true, mobspawnsettings$builder, Musics.createGameMusic(SoundEvents.MUSIC_BIOME_BAMBOO_JUNGLE));
    }

    private static Biome daBaseJungle(HolderGetter<PlacedFeature> pPlacedFeatures, HolderGetter<ConfiguredWorldCarver<?>> pWorldCarvers, float pDownfall, boolean pIsBambooJungle, boolean pIsSparse, boolean pAddBamboo, MobSpawnSettings.Builder pMobSpawnSettings, Music pBackgroudMusic) {
        BiomeGenerationSettings.Builder biomegenerationsettings$builder = new BiomeGenerationSettings.Builder(pPlacedFeatures, pWorldCarvers);
        globalOverworldGeneration(biomegenerationsettings$builder);
        ModBiomeDefaultFeatures.addDefaultOres(biomegenerationsettings$builder);
        ModBiomeDefaultFeatures.addDefaultSoftDisks(biomegenerationsettings$builder);
        if (pIsBambooJungle) {
            ModBiomeDefaultFeatures.addBambooVegetation(biomegenerationsettings$builder);
        } else {
            if (pIsSparse) {
                ModBiomeDefaultFeatures.addSparseJungleTrees(biomegenerationsettings$builder);
            } else {
                ModBiomeDefaultFeatures.addJungleTrees(biomegenerationsettings$builder);
            }
        }

        //BiomeDefaultFeatures.addWarmFlowers(biomegenerationsettings$builder);
        ModBiomeDefaultFeatures.addJungleGrass(biomegenerationsettings$builder);
        //BiomeDefaultFeatures.addDefaultMushrooms(biomegenerationsettings$builder);
        //BiomeDefaultFeatures.addDefaultExtraVegetation(biomegenerationsettings$builder);
        //BiomeDefaultFeatures.addJungleVines(biomegenerationsettings$builder);


        return getBiomeBuild(biomegenerationsettings$builder, pMobSpawnSettings, pBackgroudMusic);
    }

    public static Biome daBadlands(BootstapContext<Biome> context, boolean pTrees) {
        MobSpawnSettings.Builder mobspawnsettings$builder = new MobSpawnSettings.Builder();
        ModBiomeDefaultFeatures.darkAetherSpawns(mobspawnsettings$builder);
        BiomeGenerationSettings.Builder biomegenerationsettings$builder =
                new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));
        globalOverworldGeneration(biomegenerationsettings$builder);
        ModBiomeDefaultFeatures.addDefaultOres(biomegenerationsettings$builder);
        //BiomeDefaultFeatures.addExtraGold(biomegenerationsettings$builder);
        ModBiomeDefaultFeatures.addDefaultSoftDisks(biomegenerationsettings$builder);
        if (pTrees) {
            ModBiomeDefaultFeatures.addBadlandsTrees(biomegenerationsettings$builder);
        }

        ModBiomeDefaultFeatures.addBadlandGrass(biomegenerationsettings$builder);
        //BiomeDefaultFeatures.addDefaultMushrooms(biomegenerationsettings$builder);
        //BiomeDefaultFeatures.addBadlandExtraVegetation(biomegenerationsettings$builder);
        Music music = Musics.createGameMusic(SoundEvents.MUSIC_BIOME_OLD_GROWTH_TAIGA);
        return getBiomeBuild(biomegenerationsettings$builder, mobspawnsettings$builder, music);
    }

    public static Biome daMeadowOrCherryGrove(BootstapContext<Biome> context, boolean pIsCherryGrove) {
        BiomeGenerationSettings.Builder biomegenerationsettings$builder =
                new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));
        MobSpawnSettings.Builder mobspawnsettings$builder = new MobSpawnSettings.Builder();
        ModBiomeDefaultFeatures.darkAetherSpawns(mobspawnsettings$builder);
        globalOverworldGeneration(biomegenerationsettings$builder);
        ModBiomeDefaultFeatures.addPlainGrass(biomegenerationsettings$builder);
        ModBiomeDefaultFeatures.addDefaultOres(biomegenerationsettings$builder);
        ModBiomeDefaultFeatures.addDefaultSoftDisks(biomegenerationsettings$builder);
        if (pIsCherryGrove) {
            ModBiomeDefaultFeatures.addCherryGroveVegetation(biomegenerationsettings$builder);
        } else {
            ModBiomeDefaultFeatures.addMeadowVegetation(biomegenerationsettings$builder);
        }

        //BiomeDefaultFeatures.addExtraEmeralds(biomegenerationsettings$builder);
        //BiomeDefaultFeatures.addInfestedStone(biomegenerationsettings$builder);
        Music music = Musics.createGameMusic(pIsCherryGrove ? SoundEvents.MUSIC_BIOME_CHERRY_GROVE : SoundEvents.MUSIC_BIOME_MEADOW);
        return getBiomeBuild(biomegenerationsettings$builder, mobspawnsettings$builder, music);
    }

    public static Biome daGrove(BootstapContext<Biome> context) {
        BiomeGenerationSettings.Builder biomegenerationsettings$builder =
                new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));
        MobSpawnSettings.Builder mobspawnsettings$builder = new MobSpawnSettings.Builder();
        ModBiomeDefaultFeatures.darkAetherSpawns(mobspawnsettings$builder);
        globalOverworldGeneration(biomegenerationsettings$builder);
        BiomeDefaultFeatures.addFrozenSprings(biomegenerationsettings$builder);
        ModBiomeDefaultFeatures.addDefaultOres(biomegenerationsettings$builder);
        ModBiomeDefaultFeatures.addDefaultSoftDisks(biomegenerationsettings$builder);
        ModBiomeDefaultFeatures.addGroveTrees(biomegenerationsettings$builder);
        //BiomeDefaultFeatures.addDefaultExtraVegetation(biomegenerationsettings$builder);
        //BiomeDefaultFeatures.addExtraEmeralds(biomegenerationsettings$builder);
        //BiomeDefaultFeatures.addInfestedStone(biomegenerationsettings$builder);
        Music music = Musics.createGameMusic(SoundEvents.MUSIC_BIOME_GROVE);
        return getBiomeBuild(biomegenerationsettings$builder, mobspawnsettings$builder, music);
    }

    public static Biome daFrozenPeaks(BootstapContext<Biome> context) {
        BiomeGenerationSettings.Builder biomegenerationsettings$builder =
                new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));
        MobSpawnSettings.Builder mobspawnsettings$builder = new MobSpawnSettings.Builder();
        ModBiomeDefaultFeatures.darkAetherSpawns(mobspawnsettings$builder);
        globalOverworldGeneration(biomegenerationsettings$builder);
        BiomeDefaultFeatures.addFrozenSprings(biomegenerationsettings$builder);
        ModBiomeDefaultFeatures.addDefaultOres(biomegenerationsettings$builder);
        ModBiomeDefaultFeatures.addDefaultSoftDisks(biomegenerationsettings$builder);
        //BiomeDefaultFeatures.addExtraEmeralds(biomegenerationsettings$builder);
        //BiomeDefaultFeatures.addInfestedStone(biomegenerationsettings$builder);
        Music music = Musics.createGameMusic(SoundEvents.MUSIC_BIOME_FROZEN_PEAKS);
        return getBiomeBuild(biomegenerationsettings$builder, mobspawnsettings$builder, music);
    }

    public static Biome daJaggedPeaks(BootstapContext<Biome> context) {
        BiomeGenerationSettings.Builder biomegenerationsettings$builder =
                new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));
        MobSpawnSettings.Builder mobspawnsettings$builder = new MobSpawnSettings.Builder();
        ModBiomeDefaultFeatures.darkAetherSpawns(mobspawnsettings$builder);
        globalOverworldGeneration(biomegenerationsettings$builder);
        BiomeDefaultFeatures.addFrozenSprings(biomegenerationsettings$builder);
        ModBiomeDefaultFeatures.addDefaultOres(biomegenerationsettings$builder);
        ModBiomeDefaultFeatures.addDefaultSoftDisks(biomegenerationsettings$builder);
        //BiomeDefaultFeatures.addExtraEmeralds(biomegenerationsettings$builder);
        //BiomeDefaultFeatures.addInfestedStone(biomegenerationsettings$builder);
        Music music = Musics.createGameMusic(SoundEvents.MUSIC_BIOME_JAGGED_PEAKS);
        return getBiomeBuild(biomegenerationsettings$builder, mobspawnsettings$builder, music);
    }

    public static Biome daStonyPeaks(BootstapContext<Biome> context) {
        BiomeGenerationSettings.Builder biomegenerationsettings$builder =
                new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));
        MobSpawnSettings.Builder mobspawnsettings$builder = new MobSpawnSettings.Builder();
        ModBiomeDefaultFeatures.darkAetherSpawns(mobspawnsettings$builder);
        globalOverworldGeneration(biomegenerationsettings$builder);
        ModBiomeDefaultFeatures.addDefaultOres(biomegenerationsettings$builder);
        ModBiomeDefaultFeatures.addDefaultSoftDisks(biomegenerationsettings$builder);
        //BiomeDefaultFeatures.addExtraEmeralds(biomegenerationsettings$builder);
        //BiomeDefaultFeatures.addInfestedStone(biomegenerationsettings$builder);
        Music music = Musics.createGameMusic(SoundEvents.MUSIC_BIOME_STONY_PEAKS);
        return getBiomeBuild(biomegenerationsettings$builder, mobspawnsettings$builder, music);
    }

    public static Biome daSnowySlopes(BootstapContext<Biome> context) {
        BiomeGenerationSettings.Builder biomegenerationsettings$builder =
                new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));
        MobSpawnSettings.Builder mobspawnsettings$builder = new MobSpawnSettings.Builder();
        ModBiomeDefaultFeatures.darkAetherSpawns(mobspawnsettings$builder);
        globalOverworldGeneration(biomegenerationsettings$builder);
        BiomeDefaultFeatures.addFrozenSprings(biomegenerationsettings$builder);
        ModBiomeDefaultFeatures.addDefaultOres(biomegenerationsettings$builder);
        ModBiomeDefaultFeatures.addDefaultSoftDisks(biomegenerationsettings$builder);
        //BiomeDefaultFeatures.addDefaultExtraVegetation(biomegenerationsettings$builder);
        //BiomeDefaultFeatures.addExtraEmeralds(biomegenerationsettings$builder);
        //BiomeDefaultFeatures.addInfestedStone(biomegenerationsettings$builder);
        Music music = Musics.createGameMusic(SoundEvents.MUSIC_BIOME_SNOWY_SLOPES);
        return getBiomeBuild(biomegenerationsettings$builder, mobspawnsettings$builder, music);
    }

    public static Biome daRiver(BootstapContext<Biome> context) {
        MobSpawnSettings.Builder mobspawnsettings$builder = (new MobSpawnSettings.Builder()).addSpawn(MobCategory.WATER_CREATURE, new MobSpawnSettings.SpawnerData(EntityType.SQUID, 2, 1, 4)).addSpawn(MobCategory.WATER_AMBIENT, new MobSpawnSettings.SpawnerData(EntityType.SALMON, 5, 1, 5));
        ModBiomeDefaultFeatures.darkAetherSpawns(mobspawnsettings$builder);
        BiomeGenerationSettings.Builder biomegenerationsettings$builder =
                new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));
        globalOverworldGeneration(biomegenerationsettings$builder);
        ModBiomeDefaultFeatures.addDefaultOres(biomegenerationsettings$builder);
        ModBiomeDefaultFeatures.addDefaultSoftDisks(biomegenerationsettings$builder);
        ModBiomeDefaultFeatures.addWaterTrees(biomegenerationsettings$builder);
        //BiomeDefaultFeatures.addDefaultFlowers(biomegenerationsettings$builder);
        ModBiomeDefaultFeatures.addDefaultGrass(biomegenerationsettings$builder);
        //BiomeDefaultFeatures.addDefaultMushrooms(biomegenerationsettings$builder);
        //BiomeDefaultFeatures.addDefaultExtraVegetation(biomegenerationsettings$builder);
        Music music = Musics.createGameMusic(SoundEvents.MUSIC_BIOME_SNOWY_SLOPES);
        return getBiomeBuild(biomegenerationsettings$builder, mobspawnsettings$builder, music);
    }

    public static Biome daBeach(BootstapContext<Biome> context) {
        MobSpawnSettings.Builder mobspawnsettings$builder = new MobSpawnSettings.Builder();
        ModBiomeDefaultFeatures.darkAetherSpawns(mobspawnsettings$builder);
        BiomeGenerationSettings.Builder biomegenerationsettings$builder =
                new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));
        globalOverworldGeneration(biomegenerationsettings$builder);
        ModBiomeDefaultFeatures.addDefaultOres(biomegenerationsettings$builder);
        ModBiomeDefaultFeatures.addDefaultSoftDisks(biomegenerationsettings$builder);
        //BiomeDefaultFeatures.addDefaultFlowers(biomegenerationsettings$builder);
        ModBiomeDefaultFeatures.addDefaultGrass(biomegenerationsettings$builder);
        //BiomeDefaultFeatures.addDefaultMushrooms(biomegenerationsettings$builder);
        //BiomeDefaultFeatures.addDefaultExtraVegetation(biomegenerationsettings$builder);
        Music music = Musics.createGameMusic(SoundEvents.MUSIC_BIOME_SNOWY_SLOPES);
        return getBiomeBuild(biomegenerationsettings$builder, mobspawnsettings$builder, music);
    }

    private static Biome baseOcean(MobSpawnSettings.Builder pMobSpawnSettings, int pWaterColor, int pWaterFogColor, BiomeGenerationSettings.Builder pGenerationSettings) {
        Music music = Musics.createGameMusic(SoundEvents.MUSIC_BIOME_SNOWY_SLOPES);
        return getBiomeBuild(pGenerationSettings, pMobSpawnSettings, music);
    }

    private static BiomeGenerationSettings.Builder baseOceanGeneration(HolderGetter<PlacedFeature> pPlacedFeatures, HolderGetter<ConfiguredWorldCarver<?>> pWorldCarvers) {
        BiomeGenerationSettings.Builder biomegenerationsettings$builder = new BiomeGenerationSettings.Builder(pPlacedFeatures, pWorldCarvers);
        globalOverworldGeneration(biomegenerationsettings$builder);
        ModBiomeDefaultFeatures.addDefaultOres(biomegenerationsettings$builder);
        ModBiomeDefaultFeatures.addDefaultSoftDisks(biomegenerationsettings$builder);
        ModBiomeDefaultFeatures.addWaterTrees(biomegenerationsettings$builder);
        //BiomeDefaultFeatures.addDefaultFlowers(biomegenerationsettings$builder);
        ModBiomeDefaultFeatures.addDefaultGrass(biomegenerationsettings$builder);
        //BiomeDefaultFeatures.addDefaultMushrooms(biomegenerationsettings$builder);
        //BiomeDefaultFeatures.addDefaultExtraVegetation(biomegenerationsettings$builder);
        return biomegenerationsettings$builder;
    }

    public static Biome daColdOcean(BootstapContext<Biome> context, boolean pIsDeep) {
        MobSpawnSettings.Builder mobspawnsettings$builder = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder biomegenerationsettings$builder = baseOceanGeneration(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));
        biomegenerationsettings$builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, pIsDeep ? AquaticPlacements.SEAGRASS_DEEP_COLD : AquaticPlacements.SEAGRASS_COLD);
        //BiomeDefaultFeatures.addDefaultSeagrass(biomegenerationsettings$builder);
        //BiomeDefaultFeatures.addColdOceanExtraVegetation(biomegenerationsettings$builder);
        return baseOcean(mobspawnsettings$builder, 4020182, 329011, biomegenerationsettings$builder);
    }

    public static Biome daOcean(BootstapContext<Biome> context, boolean pIsDeep) {
        MobSpawnSettings.Builder mobspawnsettings$builder = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder biomegenerationsettings$builder = baseOceanGeneration(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));
        biomegenerationsettings$builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, pIsDeep ? AquaticPlacements.SEAGRASS_DEEP : AquaticPlacements.SEAGRASS_NORMAL);
        //BiomeDefaultFeatures.addDefaultSeagrass(biomegenerationsettings$builder);
        //BiomeDefaultFeatures.addColdOceanExtraVegetation(biomegenerationsettings$builder);
        return baseOcean(mobspawnsettings$builder, 4159204, 329011, biomegenerationsettings$builder);
    }

    public static Biome daLukeWarmOcean(BootstapContext<Biome> context, boolean pIsDeep) {
        MobSpawnSettings.Builder mobspawnsettings$builder = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder biomegenerationsettings$builder = baseOceanGeneration(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));
        biomegenerationsettings$builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, pIsDeep ? AquaticPlacements.SEAGRASS_DEEP_WARM : AquaticPlacements.SEAGRASS_WARM);
        //BiomeDefaultFeatures.addLukeWarmKelp(biomegenerationsettings$builder);
        return baseOcean(mobspawnsettings$builder, 4566514, 267827, biomegenerationsettings$builder);
    }

    public static Biome daWarmOcean(BootstapContext<Biome> context) {
        MobSpawnSettings.Builder mobspawnsettings$builder = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder biomegenerationsettings$builder = baseOceanGeneration(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER)).addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, AquaticPlacements.WARM_OCEAN_VEGETATION).addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, AquaticPlacements.SEAGRASS_WARM).addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, AquaticPlacements.SEA_PICKLE);
        return baseOcean(mobspawnsettings$builder, 4445678, 270131, biomegenerationsettings$builder);
    }

    public static Biome daFrozenOcean(BootstapContext<Biome> context, boolean pIsDeep) {
        MobSpawnSettings.Builder mobspawnsettings$builder = (new MobSpawnSettings.Builder()).addSpawn(MobCategory.WATER_CREATURE, new MobSpawnSettings.SpawnerData(EntityType.SQUID, 1, 1, 4)).addSpawn(MobCategory.WATER_AMBIENT, new MobSpawnSettings.SpawnerData(EntityType.SALMON, 15, 1, 5)).addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.POLAR_BEAR, 1, 1, 2));
        float f = pIsDeep ? 0.5F : 0.0F;
        BiomeGenerationSettings.Builder biomegenerationsettings$builder = new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));
        BiomeDefaultFeatures.addIcebergs(biomegenerationsettings$builder);
        globalOverworldGeneration(biomegenerationsettings$builder);
        BiomeDefaultFeatures.addBlueIce(biomegenerationsettings$builder);
        ModBiomeDefaultFeatures.addDefaultOres(biomegenerationsettings$builder);
        ModBiomeDefaultFeatures.addDefaultSoftDisks(biomegenerationsettings$builder);
        ModBiomeDefaultFeatures.addWaterTrees(biomegenerationsettings$builder);
        //BiomeDefaultFeatures.addDefaultFlowers(biomegenerationsettings$builder);
        ModBiomeDefaultFeatures.addDefaultGrass(biomegenerationsettings$builder);
        //BiomeDefaultFeatures.addDefaultMushrooms(biomegenerationsettings$builder);
        //BiomeDefaultFeatures.addDefaultExtraVegetation(biomegenerationsettings$builder);
        return getBiomeBuild(biomegenerationsettings$builder, mobspawnsettings$builder, Musics.createGameMusic(SoundEvents.MUSIC_BIOME_SWAMP));
    }

    public static Biome daMushroomFields(BootstapContext<Biome> context) {
        MobSpawnSettings.Builder mobspawnsettings$builder = new MobSpawnSettings.Builder();
        ModBiomeDefaultFeatures.darkAetherSpawns(mobspawnsettings$builder);
        BiomeGenerationSettings.Builder biomegenerationsettings$builder =
                new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));
        globalOverworldGeneration(biomegenerationsettings$builder);
        ModBiomeDefaultFeatures.addDefaultOres(biomegenerationsettings$builder);
        ModBiomeDefaultFeatures.addDefaultSoftDisks(biomegenerationsettings$builder);
        //BiomeDefaultFeatures.addMushroomFieldVegetation(biomegenerationsettings$builder);
        //BiomeDefaultFeatures.addDefaultExtraVegetation(biomegenerationsettings$builder);
        return getBiomeBuild(biomegenerationsettings$builder, mobspawnsettings$builder, Musics.createGameMusic(SoundEvents.MUSIC_BIOME_MEADOW));
    }

    public static Biome daDripstoneCaves(BootstapContext<Biome> context) {
        MobSpawnSettings.Builder mobspawnsettings$builder = new MobSpawnSettings.Builder();
        ModBiomeDefaultFeatures.darkAetherSpawns(mobspawnsettings$builder);
        BiomeGenerationSettings.Builder biomegenerationsettings$builder =
                new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));
        globalOverworldGeneration(biomegenerationsettings$builder);
        ModBiomeDefaultFeatures.addPlainGrass(biomegenerationsettings$builder);
        ModBiomeDefaultFeatures.addDefaultOres(biomegenerationsettings$builder, true);
        ModBiomeDefaultFeatures.addDefaultSoftDisks(biomegenerationsettings$builder);
        ModBiomeDefaultFeatures.addPlainVegetation(biomegenerationsettings$builder);
        //BiomeDefaultFeatures.addDefaultMushrooms(biomegenerationsettings$builder);
        //BiomeDefaultFeatures.addDefaultExtraVegetation(biomegenerationsettings$builder);
        BiomeDefaultFeatures.addDripstone(biomegenerationsettings$builder);
        Music music = Musics.createGameMusic(SoundEvents.MUSIC_BIOME_DRIPSTONE_CAVES);
        return getBiomeBuild(biomegenerationsettings$builder, mobspawnsettings$builder, music);
    }

    public static Biome daLushCaves(BootstapContext<Biome> context) {
        MobSpawnSettings.Builder mobspawnsettings$builder = new MobSpawnSettings.Builder();
        ModBiomeDefaultFeatures.darkAetherSpawns(mobspawnsettings$builder);
        BiomeGenerationSettings.Builder biomegenerationsettings$builder =
                new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));
        globalOverworldGeneration(biomegenerationsettings$builder);
        ModBiomeDefaultFeatures.addPlainGrass(biomegenerationsettings$builder);
        ModBiomeDefaultFeatures.addDefaultOres(biomegenerationsettings$builder);
        //BiomeDefaultFeatures.addLushCavesSpecialOres(biomegenerationsettings$builder);
        ModBiomeDefaultFeatures.addDefaultSoftDisks(biomegenerationsettings$builder);
        //BiomeDefaultFeatures.addLushCavesVegetationFeatures(biomegenerationsettings$builder);
        Music music = Musics.createGameMusic(SoundEvents.MUSIC_BIOME_LUSH_CAVES);
        return getBiomeBuild(biomegenerationsettings$builder, mobspawnsettings$builder, music);
    }

    public static Biome daDeepDark(BootstapContext<Biome> context) {
        MobSpawnSettings.Builder mobspawnsettings$builder = new MobSpawnSettings.Builder();
        ModBiomeDefaultFeatures.darkAetherSpawns(mobspawnsettings$builder);
        BiomeGenerationSettings.Builder biomegenerationsettings$builder =
                new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));
        biomegenerationsettings$builder.addCarver(GenerationStep.Carving.AIR, Carvers.CAVE);
        biomegenerationsettings$builder.addCarver(GenerationStep.Carving.AIR, Carvers.CAVE_EXTRA_UNDERGROUND);
        biomegenerationsettings$builder.addCarver(GenerationStep.Carving.AIR, Carvers.CANYON);
        //BiomeDefaultFeatures.addDefaultCrystalFormations(biomegenerationsettings$builder);
        //BiomeDefaultFeatures.addDefaultMonsterRoom(biomegenerationsettings$builder);
        //BiomeDefaultFeatures.addDefaultUndergroundVariety(biomegenerationsettings$builder);
        //BiomeDefaultFeatures.addSurfaceFreezing(biomegenerationsettings$builder);
        ModBiomeDefaultFeatures.addPlainGrass(biomegenerationsettings$builder);
        ModBiomeDefaultFeatures.addDefaultOres(biomegenerationsettings$builder);
        ModBiomeDefaultFeatures.addDefaultSoftDisks(biomegenerationsettings$builder);
        ModBiomeDefaultFeatures.addPlainVegetation(biomegenerationsettings$builder);
        //BiomeDefaultFeatures.addDefaultMushrooms(biomegenerationsettings$builder);
        //BiomeDefaultFeatures.addDefaultExtraVegetation(biomegenerationsettings$builder);
        BiomeDefaultFeatures.addSculk(biomegenerationsettings$builder);
        Music music = Musics.createGameMusic(SoundEvents.MUSIC_BIOME_DEEP_DARK);
        return getBiomeBuild(biomegenerationsettings$builder, mobspawnsettings$builder, music);
    }
}