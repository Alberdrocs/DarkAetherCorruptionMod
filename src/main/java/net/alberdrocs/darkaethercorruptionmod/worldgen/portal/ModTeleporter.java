package net.alberdrocs.darkaethercorruptionmod.worldgen.portal;

import net.alberdrocs.darkaethercorruptionmod.block.ModBlocks;
import net.alberdrocs.darkaethercorruptionmod.block.custom.ActiveDarkAetherPortalBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.material.Fluids;
import net.minecraftforge.common.util.ITeleporter;

import java.util.function.Function;

public class ModTeleporter implements ITeleporter {

    public static BlockPos thisPos = BlockPos.ZERO;
    public static boolean insideDimension = true;

    public ModTeleporter(BlockPos pos, boolean insideDim) {
        thisPos = pos;
        insideDimension = insideDim;
    }

    @Override
    public Entity placeEntity(Entity entity, ServerLevel currentWorld, ServerLevel destinationWorld,
                              float yaw, Function<Boolean, Entity> repositionEntity) {
        entity = repositionEntity.apply(false);
        int y = thisPos.getY();

        if (!insideDimension) {
            y = thisPos.getY();
        }

        BlockPos destinationPos = new BlockPos(thisPos.getX(), y, thisPos.getZ());

        /*int tries = 0;
        while ((destinationWorld.getBlockState(destinationPos).getBlock() != Blocks.AIR) &&
                !destinationWorld.getBlockState(destinationPos).canBeReplaced(Fluids.WATER) &&
                (destinationWorld.getBlockState(destinationPos.above()).getBlock()  != Blocks.AIR) &&
                !destinationWorld.getBlockState(destinationPos.above()).canBeReplaced(Fluids.WATER) && (tries < 25)) {
            destinationPos = destinationPos.above(2);
            tries++;
        }*/

        entity.setPos(destinationPos.getX(), destinationPos.getY(), destinationPos.getZ());

        if (insideDimension) {
            /*boolean doSetBlock = true;
            for (BlockPos checkPos : BlockPos.betweenClosed(destinationPos.below(10).west(10),
                    destinationPos.above(10).east(10))) {
                if (destinationWorld.getBlockState(checkPos).getBlock() instanceof ActiveDarkAetherPortalBlock) {
                    doSetBlock = false;
                    break;
                }
            }
            if (doSetBlock) {
                destinationWorld.setBlock(destinationPos, ModBlocks.ACTIVE_DARK_AETHER_PORTAL.get().defaultBlockState(), 3);
            }
            for (int x = destinationPos.getX()-3; x < destinationPos.getX()+3; x++) {
                for (int y2 = destinationPos.getY()-3; y2 < destinationPos.getY() + 3; y2++) {
                    for (int z = destinationPos.getZ() - 3; z < destinationPos.getZ() + 3; z++) {
                        destinationWorld.setBlockAndUpdate(new BlockPos(x , y2, z), Blocks.AIR.defaultBlockState());
                    }
                }
            }
            for (int x = destinationPos.getX()-2; x < destinationPos.getX()+2; x++) {
                for (int y2 = destinationPos.getY(); y2 < destinationPos.getY() + 4; y2++) {
                    destinationWorld.setBlockAndUpdate(new BlockPos(x , y2, destinationPos.getZ()), ModBlocks.ACTIVE_DARK_AETHER_PORTAL.get().defaultBlockState());
                }
            }*/
            //destinationWorld.setBlockAndUpdate(destinationPos, ModBlocks.ACTIVE_DARK_AETHER_PORTAL.get().defaultBlockState());
        }

        return entity;
    }
}
