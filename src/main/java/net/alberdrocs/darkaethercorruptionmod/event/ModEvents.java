package net.alberdrocs.darkaethercorruptionmod.event;

import net.alberdrocs.darkaethercorruptionmod.DarkAetherCorruptionMod;
import net.alberdrocs.darkaethercorruptionmod.incursion.EFIncursion;
import net.alberdrocs.darkaethercorruptionmod.incursion.OverworldIncursion;
import net.minecraftforge.event.TickEvent;
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
        for (OverworldIncursion incursion : DarkAetherCorruptionMod.OVERWORLD_INCURSIONS) {
            incursion.tick();
        }
    }




    @SubscribeEvent
    public static void onEntityKilled(LivingDeathEvent event){
        for (EFIncursion incursion : DarkAetherCorruptionMod.FACILITIES_INCURSIONS) {
            if (event.getEntity().getTags().contains("incursion_spawned_" + incursion.getId())){
                System.out.println("Killed enemies: " + incursion.getKilledEnemies());
                incursion.updateKilledEnemies();
            }
        }

        for (OverworldIncursion incursion: DarkAetherCorruptionMod.OVERWORLD_INCURSIONS){
            if (event.getEntity().getTags().contains("zombie_incursion_" + incursion.getId())){
                incursion.updateKilledEnemy(OverworldIncursion.ENEMY_TYPES.ZOMBIE);
            } else if (event.getEntity().getTags().contains("screamer_incursion_" + incursion.getId())){
                incursion.updateKilledEnemy(OverworldIncursion.ENEMY_TYPES.SCREAMER);
            } else if (event.getEntity().getTags().contains("mimic_incursion_" + incursion.getId())){
                incursion.updateKilledEnemy(OverworldIncursion.ENEMY_TYPES.MIMIC);
            }
        }

    }
}
