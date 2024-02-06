package net.alberdrocs.darkaethercorruptionmod.item;

import net.alberdrocs.darkaethercorruptionmod.DarkAetherCorruptionMod;
import net.alberdrocs.darkaethercorruptionmod.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, DarkAetherCorruptionMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> DARK_AETHER_TAB = CREATIVE_MODE_TABS.register("dark_aether_tab",
                    () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.DARK_AETHER_CRYSTAL.get()))
                    .title(Component.translatable("creativetab.dark_aether_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.DARK_AETHER_CRYSTAL.get());
                        pOutput.accept(ModItems.REFINED_DARK_AETHER_CRYSTAL.get());

                        pOutput.accept(ModItems.AETHERIUM_AXE.get());
                        pOutput.accept(ModItems.AETHERIUM_HOE.get());
                        pOutput.accept(ModItems.AETHERIUM_PICKAXE.get());
                        pOutput.accept(ModItems.AETHERIUM_SHOVEL.get());
                        pOutput.accept(ModItems.AETHERIUM_SWORD.get());

                        pOutput.accept(ModItems.AETHERIUM_HELMET.get());
                        pOutput.accept(ModItems.AETHERIUM_CHESTPLATE.get());
                        pOutput.accept(ModItems.AETHERIUM_LEGGINS.get());
                        pOutput.accept(ModItems.AETHERIUM_BOOTS.get());

                        pOutput.accept(ModBlocks.DARK_AETHER_CRYSTAL_ORE.get());
                        pOutput.accept(ModBlocks.DARK_AETHER_CRYSTAL_BLOCK.get());
                        pOutput.accept(ModBlocks.CORRUPTED_GRASS_BLOCK.get());
                        pOutput.accept(ModBlocks.CORRUPTED_DIRT.get());
                        pOutput.accept(ModBlocks.CORRUPTED_DARK_OAK_LOG.get());
                        pOutput.accept(ModBlocks.CORRUPTED_STONE.get());


                    })
                    .build()
            );

    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
