package net.alberdrocs.darkaethercorruptionmod.block.entity;

import net.alberdrocs.darkaethercorruptionmod.DarkAetherCorruptionMod;
import net.alberdrocs.darkaethercorruptionmod.block.ModBlocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, DarkAetherCorruptionMod.MOD_ID);

    /*public static final RegistryObject<BlockEntityType<AetherRefinerBlockEntity>> AETHER_REFINER_BE =
            BLOCK_ENTITIES.register("aether_refiner_be", () ->
                    BlockEntityType.Builder.of(AetherRefinerBlockEntity::new,
                            ModBlocks.AETHER_REFINER.get()).build(null));*/


    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
