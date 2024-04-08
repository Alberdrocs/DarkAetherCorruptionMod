package net.alberdrocs.darkaethercorruptionmod.block.custom;

import net.alberdrocs.darkaethercorruptionmod.block.ModBlocks;
import net.alberdrocs.darkaethercorruptionmod.incursion.EFIncursion;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.phys.BlockHitResult;

public class AetherNeutralizerBlock extends Block {

    public AetherNeutralizerBlock(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public void onPlace(BlockState pState, Level pLevel, BlockPos pPos, BlockState pOldState, boolean pIsMoving) {
        System.out.println("Aether Neutralizer placed");
        changeBlock(pLevel, pPos, ModBlocks.ACTIVE_DARK_AETHER_PORTAL.get(), ModBlocks.INACTIVE_DARK_AETHER_PORTAL.get());
    }

    @Override
    public boolean onDestroyedByPlayer(BlockState state, Level level, BlockPos pos, Player player, boolean willHarvest, FluidState fluid) {
        System.out.println("Aether Neutralizer broken");

        if (!level.isClientSide) {
            EFIncursion.createIncursion((ServerLevel) level, pos);
        }
        //changeBlock(level, pos, ModBlocks.INACTIVE_DARK_AETHER_PORTAL.get(), ModBlocks.ACTIVE_DARK_AETHER_PORTAL.get());
        return super.onDestroyedByPlayer(state, level, pos, player, willHarvest, fluid);
    }


    private void changeBlock(Level level, BlockPos pos, Block targetBlock, Block replacedBlock) {
        BlockPos checkPos;
        for (int x = pos.getX()-10; x < pos.getX()+10; x++)
        {
            for (int y = pos.getY()-10; y < pos.getY()+10; y++)
            {
                for (int z = pos.getZ()-10; z < pos.getZ()+10; z++)
                {
                    checkPos = new BlockPos(x, y, z);
                    if (level.getBlockState(checkPos).getBlock() == targetBlock)
                    {
                        level.setBlockAndUpdate(checkPos, replacedBlock.defaultBlockState());
                    }
                }
            }
        }
    }

    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        //TODO: Implement functionality
        return InteractionResult.SUCCESS;
    }
}
