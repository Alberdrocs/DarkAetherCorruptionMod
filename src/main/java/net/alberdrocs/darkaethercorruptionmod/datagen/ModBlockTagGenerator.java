package net.alberdrocs.darkaethercorruptionmod.datagen;

import net.alberdrocs.darkaethercorruptionmod.DarkAetherCorruptionMod;
import net.alberdrocs.darkaethercorruptionmod.block.ModBlocks;
import net.alberdrocs.darkaethercorruptionmod.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, DarkAetherCorruptionMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(ModTags.Blocks.NEEDS_AETHERIUM_TOOL)
                .add(ModBlocks.AETHER_STONE_BRICKS.get());

        this.tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.DARK_AETHER_CRYSTAL_ORE_SMALL.get(),
                        ModBlocks.DARK_AETHER_CRYSTAL_BLOCK.get())
                .add(ModBlocks.DARK_AETHER_CRYSTAL_ORE_BIG.get(),
                        ModBlocks.DARK_AETHER_CRYSTAL_BLOCK.get())
                .add(ModBlocks.AETHER_NEUTRALIZER.get());

        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.DARK_AETHER_CRYSTAL_ORE_SMALL.get(),
                        ModBlocks.DARK_AETHER_CRYSTAL_BLOCK.get())
                .add(ModBlocks.DARK_AETHER_CRYSTAL_ORE_BIG.get(),
                        ModBlocks.DARK_AETHER_CRYSTAL_BLOCK.get())
                .add(ModBlocks.AETHER_STONE_BRICKS.get());

        this.tag(BlockTags.FENCES)
                .add(ModBlocks.AETHER_STONE_FENCE.get());
        this.tag(BlockTags.FENCE_GATES)
                .add(ModBlocks.AETHER_STONE_FENCE_GATE.get());
        this.tag(BlockTags.WALLS)
                .add(ModBlocks.AETHER_STONE_WALL.get());

    }
}
