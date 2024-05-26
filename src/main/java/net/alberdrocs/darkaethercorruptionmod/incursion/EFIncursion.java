package net.alberdrocs.darkaethercorruptionmod.incursion;

import net.alberdrocs.darkaethercorruptionmod.block.ModBlocks;
import net.alberdrocs.darkaethercorruptionmod.entity.ModEntities;
import net.alberdrocs.darkaethercorruptionmod.entity.custom.DarkAetherZombieEntity;
import net.alberdrocs.darkaethercorruptionmod.entity.custom.MimicEntity;
import net.alberdrocs.darkaethercorruptionmod.entity.custom.ScreamerEntity;
import net.alberdrocs.darkaethercorruptionmod.worldgen.dimension.ModDimensions;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

public class EFIncursion {
    private Entity[] zombieList;
    private Entity[] screamerList;
    private Entity[] mimicList;
    private final BlockPos center;
    private final ServerLevel level;
    private boolean ended = false;
    private final int id;
    private int currentWave = 0;
    private int killedEnemies = 0;

    public EFIncursion(int pId, ServerLevel pLevel, BlockPos pCenter) {
        this.id = pId;
        this.level = pLevel;
        this.center = pCenter;
        initializeEnemies(pLevel, pCenter);
        System.out.println("Incursion created");
    }

    public EFIncursion(ServerLevel pLevel, CompoundTag tag) {
        this.level = pLevel;
        this.center = new BlockPos(tag.getInt("pos_x"), tag.getInt("pos_y"), tag.getInt("pos_z"));
        this.id = tag.getInt("id");
        this.currentWave = tag.getInt("currentWave");
        this.killedEnemies = tag.getInt("killedEnemies");
        initializeEnemies(pLevel, center);
    }

    public void createIncursion(){
        if (Minecraft.getInstance().player != null) {
            Minecraft.getInstance().player.sendSystemMessage(Component.literal("Defeat all enemies to activate portal"));
        }
        ServerLevel destinationWorld = level.getServer().getLevel(ModDimensions.DARK_AETHER_DIMENSION_LEVEL_KEY);
        BlockPos destinationPos = center;
        for (int x = destinationPos.getX()-5; x < destinationPos.getX()+5; x++) {
            for (int y2 = destinationPos.getY() - 1; y2 < destinationPos.getY() + 3; y2++) {
                for (int z = destinationPos.getZ() - 5; z < destinationPos.getZ() + 5; z++) {
                    destinationWorld.setBlockAndUpdate(new BlockPos(x , y2, z), (y2 == destinationPos.getY()-1) ?
                            ModBlocks.AETHER_STONE_BRICKS.get().defaultBlockState() : Blocks.AIR.defaultBlockState());
                }
            }
        }
        for (int x = destinationPos.getX()-2; x < destinationPos.getX()+2; x++) {
            for (int y2 = destinationPos.getY(); y2 < destinationPos.getY() + 4; y2++) {
                destinationWorld.setBlockAndUpdate(new BlockPos(x , y2, destinationPos.getZ()), ModBlocks.ACTIVE_DARK_AETHER_PORTAL.get().defaultBlockState());
            }
        }
    }

    public int getId() {
        return id;
    }

    public int getKilledEnemies() {
        return killedEnemies;
    }

    public void updateKilledEnemies(){
        killedEnemies++;
    }

    public boolean isEnded(){
        return ended;
    }

    public BlockPos getCenter() {
        return center;
    }

    private void initializeEnemies(Level level, BlockPos pos) {
        zombieList = new Entity[Incursions.ZOMBIES_AMOUNT];
        screamerList = new Entity[Incursions.SCREAMERS_AMOUNT];
        mimicList = new Entity[Incursions.MIMIC_AMOUNT];
        for (int i = 0; i < zombieList.length; i++) {
            Entity zombie = new DarkAetherZombieEntity(ModEntities.DARK_AETHER_ZOMBIE.get(), level);
            zombie.setPos(pos.getCenter());
            zombieList[i] = zombie;
        }
        for (int i = 0; i < screamerList.length; i++) {
            Entity screamer = new ScreamerEntity(ModEntities.SCREAMER.get(), level);
            screamer.setPos(pos.getCenter());
            screamerList[i] = screamer;
        }
        for (int i = 0; i < mimicList.length; i++) {
            Entity mimic = new MimicEntity(ModEntities.MIMIC.get(), level);
            mimic.setPos(pos.getCenter());
            mimicList[i] = mimic;
        }
    }

    private void endIncursion(boolean endIncursion){
        if (endIncursion){
            changeBlock(level, center, ModBlocks.INACTIVE_DARK_AETHER_PORTAL.get(), ModBlocks.ACTIVE_DARK_AETHER_PORTAL.get());
            ended = true;
        }
    }

    private void changeBlock(Level level, BlockPos pos, Block targetBlock, Block replacedBlock) {
        BlockPos checkPos;
        for (int x = pos.getX()-10; x < pos.getX()+10; x++) {
            for (int y = pos.getY()-10; y < pos.getY()+10; y++) {
                for (int z = pos.getZ()-10; z < pos.getZ()+10; z++) {
                    checkPos = new BlockPos(x, y, z);
                    if (level.getBlockState(checkPos).getBlock() == targetBlock) {
                        level.setBlockAndUpdate(checkPos, replacedBlock.defaultBlockState());
                    }
                }
            }
        }
    }

    public void tick() {
        if (!ended){
            switch (currentWave) {
                case 0 -> checkAndBeginWave(currentWave, zombieList);
                case 1 -> checkAndBeginWave(currentWave, screamerList);
                case 2 -> checkAndBeginWave(currentWave, mimicList);
                case 3 -> endIncursion(checkIfAllKilled());
            }
        }
    }

    private boolean checkIfAllKilled(){
        return currentWave == 3 && killedEnemies >= Incursions.AMOUNT_KILLED_FOR_NEXT_WAVE[3];
    }

    private void checkAndBeginWave(int wave, Entity[] entities) {
        if(killedEnemies >= Incursions.AMOUNT_KILLED_FOR_NEXT_WAVE[wave]){
            for (Entity entity : entities) {
                entity.addTag("incursion_spawned_" + id);
                level.addFreshEntity(entity);
            }
            currentWave++;
            if (Minecraft.getInstance().player != null) {
                Minecraft.getInstance().player.sendSystemMessage(Component.literal("Starting wave " + currentWave));
            }
            System.out.println("Starting wave " + currentWave);
        }
    }

    public CompoundTag deserializer(){
        CompoundTag tag = new CompoundTag();
        tag.putInt("currentWave", currentWave);
        tag.putInt("killedEnemies", killedEnemies);
        tag.putInt("id", id);
        tag.putInt("pos_x", center.getX());
        tag.putInt("pos_y", center.getY());
        tag.putInt("pos_z", center.getZ());
        return tag;
    }
}
