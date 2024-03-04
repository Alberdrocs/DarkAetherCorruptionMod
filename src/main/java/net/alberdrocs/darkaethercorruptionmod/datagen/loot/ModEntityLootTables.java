package net.alberdrocs.darkaethercorruptionmod.datagen.loot;

import net.alberdrocs.darkaethercorruptionmod.entity.ModEntities;
import net.alberdrocs.darkaethercorruptionmod.item.ModItems;
import net.minecraft.data.loot.EntityLootSubProvider;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraft.world.level.storage.loot.providers.number.NumberProvider;
import net.minecraftforge.registries.RegistryObject;

import java.util.stream.Stream;

public class ModEntityLootTables extends EntityLootSubProvider {
    public ModEntityLootTables() {
        super(FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    public void generate() {
        LootPool.Builder poolBuilder = LootPool.lootPool()
                .name("corrupted_heart_drop")
                .add(LootItem.lootTableItem(ModItems.CORRUPTED_HEART.get())
                        .when(LootItemRandomChanceCondition.randomChance(0.35f))
        );
        LootTable.Builder tableBuilder = LootTable.lootTable().withPool(poolBuilder);
        this.add(ModEntities.DARK_AETHER_ZOMBIE.get(), tableBuilder);
        this.add(ModEntities.SCREAMER.get(), tableBuilder);
        this.add(ModEntities.TEMPEST.get(), tableBuilder);
        this.add(ModEntities.MIMIC.get(), tableBuilder);
    }

    @Override
    protected Stream<EntityType<?>> getKnownEntityTypes() {
        return ModEntities.ENTITY_TYPES.getEntries().stream().flatMap(RegistryObject::stream);
    }
}
