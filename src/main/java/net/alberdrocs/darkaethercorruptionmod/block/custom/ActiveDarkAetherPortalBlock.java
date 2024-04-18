package net.alberdrocs.darkaethercorruptionmod.block.custom;

import net.alberdrocs.darkaethercorruptionmod.worldgen.dimension.ModDimensions;
import net.alberdrocs.darkaethercorruptionmod.worldgen.portal.ModTeleporter;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

public class ActiveDarkAetherPortalBlock extends Block {
    public ActiveDarkAetherPortalBlock(Properties pProperties) {
        super(pProperties);
    }


    @Override
    public void entityInside(BlockState pState, Level pLevel, BlockPos pPos, Entity pEntity) {
        if (pEntity.getTags().contains("overworld_incursion_spawned"))
            return;
        if (pEntity.canChangeDimensions()) {
            if (pEntity.isOnPortalCooldown()) {
                pEntity.setPortalCooldown();
            } else {
                pEntity.handleInsidePortal(pPos);

                Level entityWorld = pEntity.level();
                MinecraftServer minecraftserver = entityWorld.getServer();
                ResourceKey<Level> destination = pEntity.level().dimension() == ModDimensions.DARK_AETHER_DIMENSION_LEVEL_KEY
                        ? Level.OVERWORLD : ModDimensions.DARK_AETHER_DIMENSION_LEVEL_KEY;
                if(minecraftserver != null) {
                    ServerLevel destinationWorld = minecraftserver.getLevel(destination);
                    if(destinationWorld != null && minecraftserver.isNetherEnabled() && !pEntity.isPassenger()) {
                        pEntity.level().getProfiler().push("dark_aether_portal");
                        pEntity.setPortalCooldown();
                        if(destination == ModDimensions.DARK_AETHER_DIMENSION_LEVEL_KEY) {
                            pEntity.changeDimension(destinationWorld, new ModTeleporter(pPos, true));
                        } else {
                            pEntity.changeDimension(destinationWorld, new ModTeleporter(pPos, false));
                        }
                        pEntity.level().getProfiler().pop();
                    }
                }
            }
        }
    }

    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        if (pPlayer.canChangeDimensions()) {
            //handleDarkAetherPortal(pPlayer, pPos);
            return InteractionResult.SUCCESS;
        } else {
            return InteractionResult.CONSUME;
        }
    }

    private void handleDarkAetherPortal(Entity player, BlockPos pPos) {
        if (player.level() instanceof ServerLevel serverlevel) {
            MinecraftServer minecraftserver = serverlevel.getServer();
            ResourceKey<Level> resourcekey = player.level().dimension() == ModDimensions.DARK_AETHER_DIMENSION_LEVEL_KEY ?
                    Level.OVERWORLD : ModDimensions.DARK_AETHER_DIMENSION_LEVEL_KEY;

            ServerLevel portalDimension = minecraftserver.getLevel(resourcekey);
            if (portalDimension != null && !player.isPassenger()) {
                if(resourcekey == ModDimensions.DARK_AETHER_DIMENSION_LEVEL_KEY) {
                    player.changeDimension(portalDimension, new ModTeleporter(pPos, true));
                } else {
                    player.changeDimension(portalDimension, new ModTeleporter(pPos, false));
                }
            }
        }
    }
}
