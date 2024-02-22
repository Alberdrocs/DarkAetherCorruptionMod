package net.alberdrocs.darkaethercorruptionmod.event;

import net.alberdrocs.darkaethercorruptionmod.DarkAetherCorruptionMod;
import net.alberdrocs.darkaethercorruptionmod.entity.client.*;
import net.alberdrocs.darkaethercorruptionmod.entity.client.darkaetherzombie.DarkAetherZombieModel;
import net.alberdrocs.darkaethercorruptionmod.entity.client.mimic.MimicHidingModel;
import net.alberdrocs.darkaethercorruptionmod.entity.client.mimic.MimicModel;
import net.alberdrocs.darkaethercorruptionmod.entity.client.screamer.ScreamerModel;
import net.alberdrocs.darkaethercorruptionmod.entity.client.tempest.TempestModel;
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
        event.registerLayerDefinition(ModModelLayers.TEMPEST_LAYER, TempestModel::createBodyLayer);
        event.registerLayerDefinition(ModModelLayers.MIMIC_LAYER, MimicModel::createBodyLayer);
        event.registerLayerDefinition(ModModelLayers.MIMIC_HIDING_LAYER, MimicHidingModel::createBodyLayer);
    }
}
