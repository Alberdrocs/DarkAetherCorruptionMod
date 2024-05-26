package net.alberdrocs.darkaethercorruptionmod.event;

import net.alberdrocs.darkaethercorruptionmod.DarkAetherCorruptionMod;
import net.alberdrocs.darkaethercorruptionmod.incursion.EFIncursion;
import net.alberdrocs.darkaethercorruptionmod.incursion.Incursions;
import net.alberdrocs.darkaethercorruptionmod.incursion.OverworldIncursion;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = DarkAetherCorruptionMod.MOD_ID)
public class ModEvents {

    @SubscribeEvent
    public static void onServerTick(TickEvent.ServerTickEvent event){
        DarkAetherCorruptionMod.incursions.tick();

    }

    @SubscribeEvent
    public static void onServerStarting(ServerStartingEvent event){
        //DarkAetherCorruptionMod.OVERWORLD_INCURSIONS = null;
        event.getServer().getLevel(Level.OVERWORLD).getDataStorage();
    }


    @SubscribeEvent
    public static void onEntityKilled(LivingDeathEvent event){
        for (EFIncursion incursion : DarkAetherCorruptionMod.incursions.getAllEFIncursions()) {
            if (event.getEntity().getTags().contains("incursion_spawned_" + incursion.getId())){
                System.out.println("Killed enemies: " + incursion.getKilledEnemies());
                incursion.updateKilledEnemies();
            }
        }

        for (OverworldIncursion incursion: DarkAetherCorruptionMod.incursions.getAllOverworldIncursions()){
            if (event.getEntity().getTags().contains("zombie_incursion_" + incursion.getId())){
                incursion.updateKilledEnemy(Incursions.ENEMY_TYPES.ZOMBIE);
            } else if (event.getEntity().getTags().contains("screamer_incursion_" + incursion.getId())){
                incursion.updateKilledEnemy(Incursions.ENEMY_TYPES.SCREAMER);
            } else if (event.getEntity().getTags().contains("mimic_incursion_" + incursion.getId())){
                incursion.updateKilledEnemy(Incursions.ENEMY_TYPES.MIMIC);
            }
        }

    }
}
