package net.alberdrocs.darkaethercorruptionmod.entity;

import net.alberdrocs.darkaethercorruptionmod.DarkAetherCorruptionMod;
import net.alberdrocs.darkaethercorruptionmod.entity.custom.DarkAetherZombieEntity;
import net.alberdrocs.darkaethercorruptionmod.entity.custom.ScreamerEntity;
import net.alberdrocs.darkaethercorruptionmod.entity.custom.TempestEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, DarkAetherCorruptionMod.MOD_ID);

    public static final RegistryObject<EntityType<DarkAetherZombieEntity>> DARK_AETHER_ZOMBIE =
            ENTITY_TYPES.register("dark_aether_zombie", () -> EntityType.Builder.of(DarkAetherZombieEntity::new, MobCategory.MONSTER)
                            .sized(1.0f, 2.0f).build("dark_aether_zombie"));

    public static final RegistryObject<EntityType<ScreamerEntity>> SCREAMER =
            ENTITY_TYPES.register("screamer", () -> EntityType.Builder.of(ScreamerEntity::new, MobCategory.MONSTER)
                            .sized(1.0f, 2.0f).build("screamer"));

    public static final RegistryObject<EntityType<TempestEntity>> TEMPEST =
            ENTITY_TYPES.register("tempest", () -> EntityType.Builder.of(TempestEntity::new, MobCategory.MONSTER)
                    .sized(1.0f, 2.0f).build("tempest"));

    public static void register(IEventBus eventBus){
        ENTITY_TYPES.register(eventBus);
    }
}
