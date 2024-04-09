package net.alberdrocs.darkaethercorruptionmod.item;

import net.alberdrocs.darkaethercorruptionmod.DarkAetherCorruptionMod;
import net.alberdrocs.darkaethercorruptionmod.util.ModTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.TierSortingRegistry;

import java.util.List;

public class ModToolTiers {

    public static final Tier AETHERIUM = TierSortingRegistry.registerTier(
            new ForgeTier(5, 1500, 25f, 4f, 25,
                    ModTags.Blocks.NEEDS_AETHERIUM_TOOL, () -> Ingredient.of(ModItems.REFINED_DARK_AETHER_CRYSTAL.get())),
            new ResourceLocation(DarkAetherCorruptionMod.MOD_ID, "aetherium"), List.of(Tiers.NETHERITE), List.of());

}
