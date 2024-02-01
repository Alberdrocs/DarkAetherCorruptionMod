package net.alberdrocs.darkaethercorruptionmod.item;

import net.alberdrocs.darkaethercorruptionmod.DarkAetherCorruptionMod;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, DarkAetherCorruptionMod.MOD_ID);

    public static final RegistryObject<Item> DARK_AETHER_CRYSTAL =
            ITEMS.register("dark_aether_crystal", () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> REFINED_DARK_AETHER_CRYSTAL =
            ITEMS.register("refined_dark_aether_crystal", () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> AETHERIUM_SWORD =
            ITEMS.register("aetherium_sword", () -> new SwordItem(
                    ModToolTiers.AETHERIUM, 4, 2, new Item.Properties()));
    public static final RegistryObject<Item> AETHERIUM_PICKAXE =
            ITEMS.register("aetherium_pickaxe", () -> new PickaxeItem(
                    ModToolTiers.AETHERIUM, 1, 1, new Item.Properties()));
    public static final RegistryObject<Item> AETHERIUM_AXE =
            ITEMS.register("aetherium_axe", () -> new AxeItem(
                    ModToolTiers.AETHERIUM, 6, 3, new Item.Properties()));
    public static final RegistryObject<Item> AETHERIUM_SHOVEL =
            ITEMS.register("aetherium_shovel", () -> new ShovelItem(
                    ModToolTiers.AETHERIUM, 0, 0, new Item.Properties()));
    public static final RegistryObject<Item> AETHERIUM_HOE =
            ITEMS.register("aetherium_hoe", () -> new HoeItem(
                    ModToolTiers.AETHERIUM, 0, 0, new Item.Properties()));

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
