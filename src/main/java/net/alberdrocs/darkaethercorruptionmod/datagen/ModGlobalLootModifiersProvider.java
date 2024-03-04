package net.alberdrocs.darkaethercorruptionmod.datagen;

import net.alberdrocs.darkaethercorruptionmod.DarkAetherCorruptionMod;
import net.alberdrocs.darkaethercorruptionmod.entity.ModEntities;
import net.alberdrocs.darkaethercorruptionmod.item.ModItems;
import net.alberdrocs.darkaethercorruptionmod.loot.AddItemModifier;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.data.GlobalLootModifierProvider;
import net.minecraftforge.common.loot.LootTableIdCondition;

public class ModGlobalLootModifiersProvider extends GlobalLootModifierProvider {
    public ModGlobalLootModifiersProvider(PackOutput output) {
        super(output, DarkAetherCorruptionMod.MOD_ID);
    }

    @Override
    protected void start() {
        add("corrupted_heart_from_dark_aether_zombie", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(ModEntities.DARK_AETHER_ZOMBIE.getId()).build() },
                ModItems.CORRUPTED_HEART.get()));

    }
}
