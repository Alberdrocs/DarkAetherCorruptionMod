package net.alberdrocs.darkaethercorruptionmod.event;

import net.alberdrocs.darkaethercorruptionmod.DarkAetherCorruptionMod;
import net.alberdrocs.darkaethercorruptionmod.entity.ModEntities;
import net.alberdrocs.darkaethercorruptionmod.entity.custom.DarkAetherZombieEntity;
import net.alberdrocs.darkaethercorruptionmod.entity.custom.MimicEntity;
import net.alberdrocs.darkaethercorruptionmod.entity.custom.ScreamerEntity;
import net.alberdrocs.darkaethercorruptionmod.entity.custom.TempestEntity;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.entity.SpawnPlacementRegisterEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

@Mod.EventBusSubscriber(modid = DarkAetherCorruptionMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event){
        event.put(ModEntities.DARK_AETHER_ZOMBIE.get(), DarkAetherZombieEntity.createAttributes().build());
        event.put(ModEntities.SCREAMER.get(), ScreamerEntity.createAttributes().build());
        event.put(ModEntities.TEMPEST.get(), TempestEntity.createAttributes().build());
        event.put(ModEntities.MIMIC.get(), MimicEntity.createAttributes().build());
    }

    @SubscribeEvent
    public static void commonSetup(FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            SpawnPlacements.register(ModEntities.DARK_AETHER_ZOMBIE.get(), SpawnPlacements.Type.ON_GROUND,
                    Heightmap.Types.WORLD_SURFACE, DarkAetherZombieEntity::checkMonsterSpawnRules);

            SpawnPlacements.register(ModEntities.SCREAMER.get(), SpawnPlacements.Type.ON_GROUND,
                    Heightmap.Types.WORLD_SURFACE, ScreamerEntity::checkMonsterSpawnRules);

            SpawnPlacements.register(ModEntities.MIMIC.get(), SpawnPlacements.Type.ON_GROUND,
                    Heightmap.Types.WORLD_SURFACE, MimicEntity::checkMonsterSpawnRules);
        });
    }

    /*@SubscribeEvent
    public static void registerSpawnPlacement(SpawnPlacementRegisterEvent event) {
        event.register(ModEntities.DARK_AETHER_ZOMBIE.get(), SpawnPlacements.Type.ON_GROUND,
                Heightmap.Types.WORLD_SURFACE, DarkAetherZombieEntity::checkMonsterSpawnRulesDA, SpawnPlacementRegisterEvent.Operation.OR);

        event.register(ModEntities.SCREAMER.get(), SpawnPlacements.Type.ON_GROUND,
                Heightmap.Types.WORLD_SURFACE, DarkAetherZombieEntity::checkMonsterSpawnRules, SpawnPlacementRegisterEvent.Operation.OR);

        event.register(ModEntities.MIMIC.get(), SpawnPlacements.Type.ON_GROUND,
                Heightmap.Types.WORLD_SURFACE, DarkAetherZombieEntity::checkMonsterSpawnRules, SpawnPlacementRegisterEvent.Operation.OR);
    }*/

}
