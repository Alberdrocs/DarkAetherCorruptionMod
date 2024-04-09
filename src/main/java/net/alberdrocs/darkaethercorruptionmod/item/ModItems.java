package net.alberdrocs.darkaethercorruptionmod.item;

import net.alberdrocs.darkaethercorruptionmod.DarkAetherCorruptionMod;
import net.alberdrocs.darkaethercorruptionmod.entity.ModEntities;
import net.minecraft.world.item.*;
import net.minecraftforge.common.ForgeSpawnEggItem;
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
    public static final RegistryObject<Item> CORRUPTED_HEART =
            ITEMS.register("corrupted_heart", () -> new Item(new Item.Properties()));

    //************************
    // TOOLS
    //************************
    public static final RegistryObject<Item> AETHERIUM_SWORD =
            ITEMS.register("aetherium_sword", () -> new SwordItem(
                    ModToolTiers.AETHERIUM, 5, 2, new Item.Properties()));
    public static final RegistryObject<Item> AETHERIUM_PICKAXE =
            ITEMS.register("aetherium_pickaxe", () -> new PickaxeItem(
                    ModToolTiers.AETHERIUM, 1, 1, new Item.Properties()));
    public static final RegistryObject<Item> AETHERIUM_AXE =
            ITEMS.register("aetherium_axe", () -> new AxeItem(
                    ModToolTiers.AETHERIUM, 7, 3, new Item.Properties()));
    public static final RegistryObject<Item> AETHERIUM_SHOVEL =
            ITEMS.register("aetherium_shovel", () -> new ShovelItem(
                    ModToolTiers.AETHERIUM, 0, 0, new Item.Properties()));
    public static final RegistryObject<Item> AETHERIUM_HOE =
            ITEMS.register("aetherium_hoe", () -> new HoeItem(
                    ModToolTiers.AETHERIUM, 0, 0, new Item.Properties()));

    //************************
    // ARMOR
    //************************
    public static final RegistryObject<Item> AETHERIUM_HELMET =
            ITEMS.register("aetherium_helmet", () -> new ArmorItem(
                    ModArmorMaterials.AETHERIUM, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> AETHERIUM_CHESTPLATE =
            ITEMS.register("aetherium_chestplate", () -> new ArmorItem(
                    ModArmorMaterials.AETHERIUM, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> AETHERIUM_LEGGINS =
            ITEMS.register("aetherium_leggings", () -> new ArmorItem(
                    ModArmorMaterials.AETHERIUM, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> AETHERIUM_BOOTS =
            ITEMS.register("aetherium_boots", () -> new ArmorItem(
                    ModArmorMaterials.AETHERIUM, ArmorItem.Type.BOOTS, new Item.Properties()));

    //************************
    // EGGS
    //************************
    public static final RegistryObject<Item> DARK_AETHER_ZOMBIE_SPAWN_EGG =
            ITEMS.register("dark_aether_zombie_spawn_egg",
                    () -> new ForgeSpawnEggItem(ModEntities.DARK_AETHER_ZOMBIE, 0x7e9680, 0xc5d1c5, new Item.Properties()));
    public static final RegistryObject<Item> SCREAMER_SPAWN_EGG =
            ITEMS.register("screamer_spawn_egg",
                    () -> new ForgeSpawnEggItem(ModEntities.SCREAMER, 0x7e9680, 0xc5d1c5, new Item.Properties()));
    public static final RegistryObject<Item> TEMPEST_SPAWN_EGG =
            ITEMS.register("tempest_spawn_egg",
                    () -> new ForgeSpawnEggItem(ModEntities.TEMPEST, 0x7e9680, 0xc5d1c5, new Item.Properties()));
    public static final RegistryObject<Item> MIMIC_SPAWN_EGG =
            ITEMS.register("mimic_spawn_egg",
                    () -> new ForgeSpawnEggItem(ModEntities.MIMIC, 0x7e9680, 0xc5d1c5, new Item.Properties()));


    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
