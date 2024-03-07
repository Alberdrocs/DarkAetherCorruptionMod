package net.alberdrocs.darkaethercorruptionmod.datagen.loot;

import net.alberdrocs.darkaethercorruptionmod.block.ModBlocks;
import net.alberdrocs.darkaethercorruptionmod.item.ModItems;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
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
        this.dropSelf(ModBlocks.CORRUPTED_DIRT.get());

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
        this.dropSelf(ModBlocks.CORRUPTED_BIRCH_SAPLING.get());

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

        //TODO: implement proper loot drop for grass
        this.dropSelf(ModBlocks.CORRUPTED_GRASS_BLOCK.get());

        this.add(ModBlocks.DARK_AETHER_CRYSTAL_ORE.get(),
                block -> createOreDrop(ModBlocks.DARK_AETHER_CRYSTAL_ORE.get(), ModItems.DARK_AETHER_CRYSTAL.get()));


    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
