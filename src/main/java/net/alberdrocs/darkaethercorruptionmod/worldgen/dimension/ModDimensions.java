package net.alberdrocs.darkaethercorruptionmod.worldgen.dimension;

import net.alberdrocs.darkaethercorruptionmod.DarkAetherCorruptionMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.dimension.BuiltinDimensionTypes;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.world.level.dimension.LevelStem;

import java.util.OptionalLong;

public class ModDimensions {
    public static final ResourceKey<LevelStem> DARK_AETHER_DIMENSION_KEY = ResourceKey.create(Registries.LEVEL_STEM,
            new ResourceLocation(DarkAetherCorruptionMod.MOD_ID, "dark_aether_dimension"));
    public static final ResourceKey<Level> DARK_AETHER_DIMENSION_LEVEL_KEY = ResourceKey.create(Registries.DIMENSION,
            new ResourceLocation(DarkAetherCorruptionMod.MOD_ID, "dark_aether_dimension"));
    public static final ResourceKey<DimensionType> DARK_AETHER_DIMENSION_DIM_TYPE = ResourceKey.create(Registries.DIMENSION_TYPE,
            new ResourceLocation(DarkAetherCorruptionMod.MOD_ID, "dark_aether_dimension_type"));

    public static void bootstrapType(BootstapContext<DimensionType> context) {
        context.register(DARK_AETHER_DIMENSION_DIM_TYPE, new DimensionType(
                OptionalLong.of(18000), // fixedTime
                false, // hasSkylight
                false, // hasCeiling
                false, // ultraWarm
                false, // natural
                1.0, // coordinateScale
                false, // bedWorks
                false, // respawnAnchorWorks
                -64, // minY
                384, // height
                384, // logicalHeight
                BlockTags.INFINIBURN_OVERWORLD, // infiniburn
                BuiltinDimensionTypes.END_EFFECTS, // effectsLocation
                1.0f, // ambientLight
                new DimensionType.MonsterSettings(false, false, UniformInt.of(0,10), 0)));
    }
}
