package net.alberdrocs.darkaethercorruptionmod.block.custom;

import net.alberdrocs.darkaethercorruptionmod.block.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class DarkAetherCrystalOreBlock extends BushBlock {
    private final IntProvider xpRange;

    public DarkAetherCrystalOreBlock(Properties pProperties) {
        this(pProperties, ConstantInt.of(0));
    }

    public DarkAetherCrystalOreBlock(BlockBehaviour.Properties pProperties, IntProvider pXpRange) {
        super(pProperties);
        this.xpRange = pXpRange;
    }

    @Override
    protected boolean mayPlaceOn(BlockState pState, BlockGetter pLevel, BlockPos pPos) {
        return pState.is(ModBlocks.CORRUPTED_GRASS_BLOCK.get()) || pState.is(ModBlocks.CORRUPTED_DIRT.get())
                || pState.is(ModBlocks.CORRUPTED_SAND.get()) || pState.is(ModBlocks.CORRUPTED_STONE.get());
    }

    @Override
    public int getExpDrop(BlockState state, LevelReader level, RandomSource randomSource, BlockPos pos, int fortuneLevel, int silkTouchLevel) {
        return silkTouchLevel == 0 ? this.xpRange.sample(randomSource) : 0;
    }
}
