package net.alberdrocs.darkaethercorruptionmod.entity.client;

import net.alberdrocs.darkaethercorruptionmod.DarkAetherCorruptionMod;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;

public class ModModelLayers {
    public static final ModelLayerLocation DARK_AETHER_ZOMBIE_LAYER = new ModelLayerLocation(
            new ResourceLocation(DarkAetherCorruptionMod.MOD_ID, "dark_aether_zombie_layer"), "main");

    public static final ModelLayerLocation SCREAMER_LAYER = new ModelLayerLocation(
            new ResourceLocation(DarkAetherCorruptionMod.MOD_ID, "screamer_layer"), "main");

    public static final ModelLayerLocation TEMPEST_LAYER = new ModelLayerLocation(
            new ResourceLocation(DarkAetherCorruptionMod.MOD_ID, "tempest_layer"), "main");

    public static final ModelLayerLocation MIMIC_LAYER = new ModelLayerLocation(
            new ResourceLocation(DarkAetherCorruptionMod.MOD_ID, "mimic_layer"), "main");

    public static final ModelLayerLocation MIMIC_HIDING_LAYER = new ModelLayerLocation(
            new ResourceLocation(DarkAetherCorruptionMod.MOD_ID, "mimic_hiding_layer"), "main");
}
