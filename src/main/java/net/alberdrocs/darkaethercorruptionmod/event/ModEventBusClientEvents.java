package net.alberdrocs.darkaethercorruptionmod.event;

import net.alberdrocs.darkaethercorruptionmod.DarkAetherCorruptionMod;
import net.alberdrocs.darkaethercorruptionmod.entity.client.DarkAetherZombieModel;
import net.alberdrocs.darkaethercorruptionmod.entity.client.ModModelLayers;
import net.alberdrocs.darkaethercorruptionmod.entity.client.ScreamerModel;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = DarkAetherCorruptionMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModEventBusClientEvents {

    @SubscribeEvent
    public static void registerLayer(EntityRenderersEvent.RegisterLayerDefinitions event){
        event.registerLayerDefinition(ModModelLayers.DARK_AETHER_ZOMBIE_LAYER, DarkAetherZombieModel::createBodyLayer);
        event.registerLayerDefinition(ModModelLayers.SCREAMER_LAYER, ScreamerModel::createBodyLayer);
    }
}
