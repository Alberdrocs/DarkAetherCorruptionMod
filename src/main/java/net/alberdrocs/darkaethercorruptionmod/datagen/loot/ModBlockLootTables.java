package net.alberdrocs.darkaethercorruptionmod.datagen.loot;

import net.alberdrocs.darkaethercorruptionmod.block.ModBlocks;
import net.alberdrocs.darkaethercorruptionmod.item.ModItems;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.dropSelf(ModBlocks.DARK_AETHER_CRYSTAL_BLOCK.get());
        this.dropSelf(ModBlocks.AETHER_NEUTRALIZER.get());
        this.dropSelf(ModBlocks.AETHER_REFINER.get());
        this.dropSelf(ModBlocks.CORRUPTED_DIRT.get());
        this.dropSelf(ModBlocks.CORRUPTED_SAND.get());
        this.dropSelf(ModBlocks.CORRUPTED_SANDSTONE.get());
        this.dropSelf(ModBlocks.CORRUPTED_TERRACOTA.get());

        //************************
        // OAK BLOCKS
        //************************
        this.dropSelf(ModBlocks.CORRUPTED_DARK_OAK_LOG.get());
        this.dropSelf(ModBlocks.CORRUPTED_ACACIA_LOG.get());
        this.dropSelf(ModBlocks.CORRUPTED_BIRCH_LOG.get());
        this.dropSelf(ModBlocks.CORRUPTED_CHERRY_LOG.get());
        this.dropSelf(ModBlocks.CORRUPTED_JUNGLE_LOG.get());
        this.dropSelf(ModBlocks.CORRUPTED_MANGROVE_LOG.get());
        this.dropSelf(ModBlocks.CORRUPTED_SPRUCE_LOG.get());

        //************************
        // SAPLINGS
        //************************
        this.dropSelf(ModBlocks.CORRUPTED_OAK_SAPLING.get());
        this.dropSelf(ModBlocks.CORRUPTED_DARK_OAK_SAPLING.get());
        this.dropSelf(ModBlocks.CORRUPTED_BIRCH_SAPLING.get());
        this.dropSelf(ModBlocks.CORRUPTED_ACACIA_SAPLING.get());
        this.dropSelf(ModBlocks.CORRUPTED_SPRUCE_SAPLING.get());
        this.dropSelf(ModBlocks.CORRUPTED_CHERRY_SAPLING.get());
        this.dropSelf(ModBlocks.CORRUPTED_MANGROVE_PROPAGULE.get());

        this.dropSelf(ModBlocks.CORRUPTED_STONE.get());
        this.dropSelf(ModBlocks.AETHER_STONE_BRICKS.get());

        this.dropSelf(ModBlocks.AETHER_STONE_WALL.get());
        this.dropSelf(ModBlocks.AETHER_STONE_STAIRS.get());
        this.dropSelf(ModBlocks.AETHER_STONE_FENCE.get());
        this.dropSelf(ModBlocks.AETHER_STONE_FENCE_GATE.get());



        this.add(ModBlocks.AETHER_STONE_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.AETHER_STONE_SLAB.get()));
        this.add(ModBlocks.AETHER_INFUSED_DOOR.get(),
                block -> createDoorTable(ModBlocks.AETHER_INFUSED_DOOR.get()));

        this.add(ModBlocks.CORRUPTED_GRASS_BLOCK.get(),
                block -> createGrassDrops(ModBlocks.CORRUPTED_DIRT.get()));

        this.add(ModBlocks.DARK_AETHER_CRYSTAL_ORE_SMALL.get(),
                block -> createOreDrop(ModBlocks.DARK_AETHER_CRYSTAL_ORE_SMALL.get(), ModItems.DARK_AETHER_CRYSTAL.get()));

        this.add(ModBlocks.DARK_AETHER_CRYSTAL_ORE_BIG.get(),
                block -> createDarkAetherCrystalOreDrop(ModBlocks.DARK_AETHER_CRYSTAL_ORE_BIG.get(), ModItems.DARK_AETHER_CRYSTAL.get(), 2));


    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }

    protected LootTable.Builder createDarkAetherCrystalOreDrop(Block pBlock, Item pItem, int count) {
        return createSilkTouchDispatchTable(pBlock, this.applyExplosionDecay(pBlock, LootItem.lootTableItem(pItem).apply(SetItemCountFunction.setCount(ConstantValue.exactly(count))).apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))));
    }
}
