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

                        pOutput.accept(ModBlocks.DARK_AETHER_CRYSTAL_BLOCK.get());
                    })
                    .build()
            );

    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
