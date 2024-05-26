package net.alberdrocs.darkaethercorruptionmod.block.custom;

import net.alberdrocs.darkaethercorruptionmod.DarkAetherCorruptionMod;
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

    private boolean placedByPlayer = false;

    public AetherNeutralizerBlock(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public void onPlace(BlockState pState, Level pLevel, BlockPos pPos, BlockState pOldState, boolean pIsMoving) {
        System.out.println("Aether Neutralizer placed");
        placedByPlayer = true;
        DarkAetherCorruptionMod.incursions.checkAndStartIncursionContainment(pPos);
    }

    @Override
    public boolean onDestroyedByPlayer(BlockState state, Level level, BlockPos pos, Player player, boolean willHarvest, FluidState fluid) {
        System.out.println("Aether Neutralizer broken");

        if (!level.isClientSide && !placedByPlayer) {
            DarkAetherCorruptionMod.incursions.createEFIncursion((ServerLevel) level, pos);
        }
        //changeBlock(level, pos, ModBlocks.INACTIVE_DARK_AETHER_PORTAL.get(), ModBlocks.ACTIVE_DARK_AETHER_PORTAL.get());
        return super.onDestroyedByPlayer(state, level, pos, player, willHarvest, fluid);
    }

}
