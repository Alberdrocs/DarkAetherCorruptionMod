package net.alberdrocs.darkaethercorruptionmod.worldgen.biome;

import net.alberdrocs.darkaethercorruptionmod.DarkAetherCorruptionMod;
import net.alberdrocs.darkaethercorruptionmod.entity.ModEntities;
import net.alberdrocs.darkaethercorruptionmod.sound.ModSounds;
import net.alberdrocs.darkaethercorruptionmod.worldgen.ModPlacedFeatures;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.MiscOverworldPlacements;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.Musics;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.*;
import net.minecraft.world.level.levelgen.GenerationStep;

public class ModBiomes {
    //Equals PLAINS, SUNFLOWER_PLAINS and SNOWY_PLAINS
    public static final ResourceKey<Biome> DA_PLAINS = ResourceKey.create(Registries.BIOME,
            new ResourceLocation(DarkAetherCorruptionMod.MOD_ID, "da_plains"));
    //Equals DESERT
    public static final ResourceKey<Biome> DA_DESERT = ResourceKey.create(Registries.BIOME,
            new ResourceLocation(DarkAetherCorruptionMod.MOD_ID, "da_desert"));

    public static void boostrap(BootstapContext<Biome> context) {
        context.register(DA_PLAINS, daPlains(context));
    }

    public static void globalOverworldGeneration(BiomeGenerationSettings.Builder builder) {
        BiomeDefaultFeatures.addDefaultCarversAndLakes(builder);
        BiomeDefaultFeatures.addDefaultCrystalFormations(builder);
        BiomeDefaultFeatures.addDefaultMonsterRoom(builder);
        BiomeDefaultFeatures.addDefaultUndergroundVariety(builder);
        BiomeDefaultFeatures.addDefaultSprings(builder);
        BiomeDefaultFeatures.addSurfaceFreezing(builder);
    }

    private static Biome daPlains(BootstapContext<Biome> context) {
        MobSpawnSettings.Builder mobspawnsettings$builder = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder biomegenerationsettings$builder =
                new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));
        globalOverworldGeneration(biomegenerationsettings$builder);

        BiomeDefaultFeatures.plainsSpawns(mobspawnsettings$builder);
        BiomeDefaultFeatures.addPlainGrass(biomegenerationsettings$builder);

        BiomeDefaultFeatures.addDefaultOres(biomegenerationsettings$builder);
        BiomeDefaultFeatures.addDefaultSoftDisks(biomegenerationsettings$builder);

        BiomeDefaultFeatures.addPlainVegetation(biomegenerationsettings$builder);


        BiomeDefaultFeatures.addDefaultMushrooms(biomegenerationsettings$builder);

        BiomeDefaultFeatures.addDefaultExtraVegetation(biomegenerationsettings$builder);

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
                        .backgroundMusic(Musics.createGameMusic(SoundEvents.AMBIENT_CAVE)).build())
                .build();
    }
}