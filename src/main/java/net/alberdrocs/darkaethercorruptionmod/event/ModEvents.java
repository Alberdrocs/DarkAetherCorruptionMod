package net.alberdrocs.darkaethercorruptionmod.event;

import net.alberdrocs.darkaethercorruptionmod.DarkAetherCorruptionMod;
import net.alberdrocs.darkaethercorruptionmod.entity.EFIncursion;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.EntityEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = DarkAetherCorruptionMod.MOD_ID)
public class ModEvents {

    @SubscribeEvent
    public static void onServerTick(TickEvent.ServerTickEvent event){
        for (EFIncursion incursion : DarkAetherCorruptionMod.FACILITIES_INCURSIONS) {
            incursion.tick();
        }
    }

    @SubscribeEvent
    public static void onEntityKilled(LivingDeathEvent event){
        for (EFIncursion incursion : DarkAetherCorruptionMod.FACILITIES_INCURSIONS) {
            if (event.getEntity().getTags().contains("incursion_spawned_" + incursion.getId())){
                incursion.updateKilledEnemies();
            }
        }

    }
}
