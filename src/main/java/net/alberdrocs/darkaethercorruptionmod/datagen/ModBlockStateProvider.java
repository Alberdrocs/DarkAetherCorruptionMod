package net.alberdrocs.darkaethercorruptionmod.datagen;

import net.alberdrocs.darkaethercorruptionmod.DarkAetherCorruptionMod;
import net.alberdrocs.darkaethercorruptionmod.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
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
        blockWithItem(ModBlocks.CORRUPTED_DIRT);

        //TODO: add grass block

        logBlock((RotatedPillarBlock) ModBlocks.CORRUPTED_DARK_OAK_LOG.get());
        blockItem(ModBlocks.CORRUPTED_DARK_OAK_LOG);
    }

    private void blockItem(RegistryObject<Block> blockRegistryObject){
        simpleBlockItem(blockRegistryObject.get(), new ModelFile.UncheckedModelFile(
                DarkAetherCorruptionMod.MOD_ID + ":block/" + ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath()));
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject){
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }

}
