package net.alberdrocs.darkaethercorruptionmod.datagen;

import net.alberdrocs.darkaethercorruptionmod.DarkAetherCorruptionMod;
import net.alberdrocs.darkaethercorruptionmod.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.*;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, DarkAetherCorruptionMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.DARK_AETHER_CRYSTAL_BLOCK);
        blockWithItem(ModBlocks.DARK_AETHER_CRYSTAL_ORE);
        blockWithItem(ModBlocks.AETHER_NEUTRALIZER);
        blockWithItem(ModBlocks.CORRUPTED_STONE);
        blockWithItem(ModBlocks.AETHER_STONE_BRICKS);
        blockWithItem(ModBlocks.CORRUPTED_DIRT);
        blockWithItem(ModBlocks.CORRUPTED_SAND);

        blockWithItem(ModBlocks.INACTIVE_DARK_AETHER_PORTAL);



        stairsBlock(((StairBlock) ModBlocks.AETHER_STONE_STAIRS.get()), blockTexture(ModBlocks.AETHER_STONE_BRICKS.get()));
        slabBlock(((SlabBlock) ModBlocks.AETHER_STONE_SLAB.get()), blockTexture(ModBlocks.AETHER_STONE_BRICKS.get()), blockTexture(ModBlocks.AETHER_STONE_BRICKS.get()));

        fenceBlock(((FenceBlock) ModBlocks.AETHER_STONE_FENCE.get()), blockTexture(ModBlocks.AETHER_STONE_BRICKS.get()));
        fenceGateBlock(((FenceGateBlock) ModBlocks.AETHER_STONE_FENCE_GATE.get()), blockTexture(ModBlocks.AETHER_STONE_BRICKS.get()));
        wallBlock(((WallBlock) ModBlocks.AETHER_STONE_WALL.get()), blockTexture(ModBlocks.AETHER_STONE_BRICKS.get()));

        doorBlockWithRenderType(((DoorBlock) ModBlocks.AETHER_INFUSED_DOOR.get()), modLoc("block/aether_door_bottom"), modLoc("block/aether_door_top"), "cutout");


        //TODO: add grass block

        //************************
        // OAK BLOCKS
        //************************
        logBlock((RotatedPillarBlock) ModBlocks.CORRUPTED_DARK_OAK_LOG.get());
        blockItem(ModBlocks.CORRUPTED_DARK_OAK_LOG);
        logBlock((RotatedPillarBlock) ModBlocks.CORRUPTED_ACACIA_LOG.get());
        blockItem(ModBlocks.CORRUPTED_ACACIA_LOG);
        logBlock((RotatedPillarBlock) ModBlocks.CORRUPTED_BIRCH_LOG.get());
        blockItem(ModBlocks.CORRUPTED_BIRCH_LOG);
        logBlock((RotatedPillarBlock) ModBlocks.CORRUPTED_CHERRY_LOG.get());
        blockItem(ModBlocks.CORRUPTED_CHERRY_LOG);
        logBlock((RotatedPillarBlock) ModBlocks.CORRUPTED_JUNGLE_LOG.get());
        blockItem(ModBlocks.CORRUPTED_JUNGLE_LOG);
        logBlock((RotatedPillarBlock) ModBlocks.CORRUPTED_MANGROVE_LOG.get());
        blockItem(ModBlocks.CORRUPTED_MANGROVE_LOG);
        logBlock((RotatedPillarBlock) ModBlocks.CORRUPTED_SPRUCE_LOG.get());
        blockItem(ModBlocks.CORRUPTED_SPRUCE_LOG);

        //************************
        // SAPLINGS
        //************************
        saplingBlock(ModBlocks.CORRUPTED_OAK_SAPLING);
        saplingBlock(ModBlocks.CORRUPTED_DARK_OAK_SAPLING);
        saplingBlock(ModBlocks.CORRUPTED_BIRCH_SAPLING);
        saplingBlock(ModBlocks.CORRUPTED_ACACIA_SAPLING);
        saplingBlock(ModBlocks.CORRUPTED_SPRUCE_SAPLING);
        saplingBlock(ModBlocks.CORRUPTED_CHERRY_SAPLING);
        saplingBlock(ModBlocks.CORRUPTED_MANGROVE_PROPAGULE);

    }

    private void saplingBlock(RegistryObject<Block> blockRegistryObject) {
        simpleBlock(blockRegistryObject.get(),
                models().cross(ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath(), blockTexture(blockRegistryObject.get())).renderType("cutout"));
    }

    private void blockItem(RegistryObject<Block> blockRegistryObject){
        simpleBlockItem(blockRegistryObject.get(), new ModelFile.UncheckedModelFile(
                DarkAetherCorruptionMod.MOD_ID + ":block/" + ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath()));
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject){
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }

}
