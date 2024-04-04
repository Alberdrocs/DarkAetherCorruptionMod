package net.alberdrocs.darkaethercorruptionmod.entity;

import net.alberdrocs.darkaethercorruptionmod.DarkAetherCorruptionMod;
import net.alberdrocs.darkaethercorruptionmod.block.ModBlocks;
import net.alberdrocs.darkaethercorruptionmod.entity.custom.DarkAetherZombieEntity;
import net.alberdrocs.darkaethercorruptionmod.entity.custom.MimicEntity;
import net.alberdrocs.darkaethercorruptionmod.entity.custom.ScreamerEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;

public class EFIncursion {
    private static final int ZOMBIES_AMOUNT = 10;
    private static final int SCREAMERS_AMOUNT = 5;
    private static final int MIMIC_AMOUNT = 2;
    private static final int AMOUNT_KILLED_FOR_NEXT_WAVE = 7;
    private Entity[] zombieList;
    private Entity[] screamerList;
    private Entity[] mimicList;
    private final BlockPos center;
    private final ServerLevel level;
    private boolean ended = false;
    private final int id;
    private int currentWave = 0;
    private int killedEnemies = 10;

    public EFIncursion(int pId, ServerLevel pLevel, BlockPos pCenter) {
        this.id = pId;
        this.level = pLevel;
        this.center = pCenter;
        //Beware ServerLevel instead of Level
        initializeEnemies(pLevel, pCenter);
        System.out.println("Incursion created");
    }

    public static void createIncursion(ServerLevel pLevel, BlockPos pCenter){
        DarkAetherCorruptionMod.FACILITIES_INCURSIONS.add(new EFIncursion(DarkAetherCorruptionMod.FACILITIES_INCURSIONS.size(), pLevel, pCenter));
    }

    public int getId() {
        return id;
    }

    public void updateKilledEnemies(){
        killedEnemies++;
    }

    private void initializeEnemies(Level level, BlockPos pos) {
        zombieList = new Entity[ZOMBIES_AMOUNT];
        screamerList = new Entity[SCREAMERS_AMOUNT];
        mimicList = new Entity[MIMIC_AMOUNT];
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
                case 0 -> checkAndBeginWave(1, zombieList);
                case 1 -> checkAndBeginWave(2, screamerList);
                case 2 -> checkAndBeginWave(3, mimicList);
                case 3 -> endIncursion(checkIfAllKilled());
            }
        }
    }

    private boolean checkIfAllKilled(){
        return currentWave == 3 && killedEnemies == 2;
    }

    private void checkAndBeginWave(int wave, Entity[] entities) {
        if(killedEnemies >= AMOUNT_KILLED_FOR_NEXT_WAVE){
            for (Entity entity : entities) {
                entity.addTag("incursion_spawned_" + id);
                level.addFreshEntity(entity);
            }
            currentWave = wave;
            killedEnemies = 0;
            System.out.println("Starting wave " + currentWave);
        }
    }
}
