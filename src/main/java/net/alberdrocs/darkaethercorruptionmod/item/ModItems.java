package net.alberdrocs.darkaethercorruptionmod.item;

import net.alberdrocs.darkaethercorruptionmod.DarkAetherCorruptionMod;
import net.minecraft.world.item.Item;
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

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
