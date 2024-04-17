package net.alberdrocs.darkaethercorruptionmod.incursion;

import net.alberdrocs.darkaethercorruptionmod.DarkAetherCorruptionMod;
import net.alberdrocs.darkaethercorruptionmod.block.ModBlocks;
import net.alberdrocs.darkaethercorruptionmod.entity.ModEntities;
import net.alberdrocs.darkaethercorruptionmod.entity.custom.DarkAetherZombieEntity;
import net.alberdrocs.darkaethercorruptionmod.entity.custom.MimicEntity;
import net.alberdrocs.darkaethercorruptionmod.entity.custom.ScreamerEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.SectionPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkAccess;
import net.minecraft.world.level.chunk.LevelChunkSection;
import net.minecraftforge.registries.RegistryObject;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public class OverworldIncursion {
    public enum ENEMY_TYPES {
        ZOMBIE, SCREAMER, MIMIC
    }
    private static final String[] CORRUPTION_LEVELS = {"SMALL", "ADVANCED", "CRITICAL", "APOCALYPTIC"};
    private static final int[] ZOMBIES_THRESHOLD_SPAWN_LIMIT = {3, 8, 15, 25};
    private static final int[] SCREAMER_THRESHOLD_SPAWN_LIMIT = {1, 3, 7, 13};
    private static final int[] MIMIC_THRESHOLD_SPAWN_LIMIT = {0, 1, 3, 6};
    private int currentZombiesAmount = 0;
    private int currentScreamersAmount = 0;
    private int currentMimicAmounts = 0;
    private static final int TICKS_FOR_NEXT_SPAWN = 120;
    private int spawingTimeout = 0;
    private Entity[] zombieList;
    private Entity[] screamerList;
    private Entity[] mimicList;
    private final BlockPos center;
    private final ServerLevel level;
    private boolean ended = false;
    private final int id;
    private int currentLevel = 0;
    private int blocksSpread = 0;
    private static final HashMap<Block, Block> BLOCKS_COUNTERPARTS = new HashMap<>() {{
        put(Blocks.DIRT, ModBlocks.CORRUPTED_DIRT.get());
        put(Blocks.GRASS_BLOCK, ModBlocks.CORRUPTED_GRASS_BLOCK.get());
        put(Blocks.GRASS, ModBlocks.CORRUPTED_GRASS.get());
        put(Blocks.FERN, ModBlocks.CORRUPTED_FERN.get());
        put(Blocks.DEAD_BUSH, ModBlocks.CORRUPTED_DEAD_BUSH.get());
        put(Blocks.SAND, ModBlocks.CORRUPTED_SAND.get());
        put(Blocks.SANDSTONE, ModBlocks.CORRUPTED_SANDSTONE.get());
        put(Blocks.STONE, ModBlocks.CORRUPTED_STONE.get());
        put(Blocks.TERRACOTTA, ModBlocks.CORRUPTED_TERRACOTA.get());
        put(Blocks.RED_TERRACOTTA, ModBlocks.CORRUPTED_TERRACOTA.get());
        put(Blocks.ORANGE_TERRACOTTA, ModBlocks.CORRUPTED_TERRACOTA.get());
        put(Blocks.BROWN_TERRACOTTA, ModBlocks.CORRUPTED_TERRACOTA.get());
        put(Blocks.YELLOW_TERRACOTTA, ModBlocks.CORRUPTED_TERRACOTA.get());
        put(Blocks.WHITE_TERRACOTTA, ModBlocks.CORRUPTED_TERRACOTA.get());
        put(Blocks.LIGHT_GRAY_TERRACOTTA, ModBlocks.CORRUPTED_TERRACOTA.get());
        put(Blocks.OAK_LOG, ModBlocks.CORRUPTED_DARK_OAK_LOG.get());
        put(Blocks.DARK_OAK_LOG, ModBlocks.CORRUPTED_DARK_OAK_LOG.get());
        put(Blocks.BIRCH_LOG, ModBlocks.CORRUPTED_BIRCH_LOG.get());
        put(Blocks.ACACIA_LOG, ModBlocks.CORRUPTED_ACACIA_LOG.get());
        put(Blocks.CHERRY_LOG, ModBlocks.CORRUPTED_CHERRY_LOG.get());
        put(Blocks.MANGROVE_LOG, ModBlocks.CORRUPTED_MANGROVE_LOG.get());
        put(Blocks.JUNGLE_LOG, ModBlocks.CORRUPTED_JUNGLE_LOG.get());
        put(Blocks.SPRUCE_LOG, ModBlocks.CORRUPTED_SPRUCE_LOG.get());
    }};

    public OverworldIncursion(int pId, ServerLevel pLevel, BlockPos pCenter) {
        this.center = pCenter;
        this.level = pLevel;
        this.id = pId;
    }

    public static void createIncursion(ServerLevel pLevel, BlockPos pCenter){
        OverworldIncursion incursion = new OverworldIncursion(DarkAetherCorruptionMod.OVERWORLD_INCURSIONS.size(), pLevel, pCenter);
        incursion.startCorruption();
        incursion.spawnPortal();
        DarkAetherCorruptionMod.OVERWORLD_INCURSIONS.add(incursion);
    }

    private void startCorruption(){
        for (int x = center.getX() - 3; x < center.getX() + 3; x++) {
            for (int y = center.getY() - 3; y < center.getY() + 3; y++) {
                for (int z = center.getZ() - 3; z < center.getZ() + 3; z++) {
                    spreadToBlock(new BlockPos(x, y, z));
                }
            }
        }
    }


    private void spawnPortal(){
        for (int x = center.getX()-2; x < center.getX()+2; x++) {
            for (int y = center.getY()+1; y < center.getY() + 5; y++) {
                level.setBlockAndUpdate(new BlockPos(x , y, center.getZ()), ModBlocks.ACTIVE_DARK_AETHER_PORTAL.get().defaultBlockState());
            }
        }
    }

    public int getId() {
        return id;
    }

    public int getBlocksSpread(){
        return blocksSpread;
    }

    private void spawnEnemy(ENEMY_TYPES type){
        Entity entity;
        switch (type) {
            case SCREAMER -> {
                entity = new ScreamerEntity(ModEntities.SCREAMER.get(), level);
                entity.addTag("screamer_incursion_" + id);
                currentScreamersAmount++;
            } case MIMIC -> {
                entity = new MimicEntity(ModEntities.MIMIC.get(), level);
                entity.addTag("mimic_incursion_" + id);
                currentMimicAmounts++;
            }
            default -> {
                entity = new DarkAetherZombieEntity(ModEntities.DARK_AETHER_ZOMBIE.get(), level);
                entity.addTag("zombie_incursion_" + id);
                currentZombiesAmount++;
            }
        }
        entity.setPos(center.getCenter());
        level.addFreshEntity(entity);
    }

    public void updateKilledEnemy(ENEMY_TYPES type){
        switch (type){
            case SCREAMER -> currentScreamersAmount--;
            case MIMIC -> currentMimicAmounts--;
            default -> currentZombiesAmount--;
        }
    }

    private void initializeEnemies(Level level, BlockPos pos, int currentLevel) {
        zombieList = new Entity[ZOMBIES_THRESHOLD_SPAWN_LIMIT[currentLevel]];
        screamerList = new Entity[SCREAMER_THRESHOLD_SPAWN_LIMIT[currentLevel]];
        mimicList = new Entity[MIMIC_THRESHOLD_SPAWN_LIMIT[currentLevel]];
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

    public void tick(){
        tickChunk(level.getGameRules().getInt(GameRules.RULE_RANDOMTICKING));

        if (blocksSpread > (currentLevel + 1) * 50){
            currentLevel++;
        }

        if (spawingTimeout < TICKS_FOR_NEXT_SPAWN){
            spawingTimeout++;
        } else {
            checkAndSpawnEnemy();
            spawingTimeout = 0;
        }

    }

    private void checkAndSpawnEnemy(){
        if (currentZombiesAmount < ZOMBIES_THRESHOLD_SPAWN_LIMIT[currentLevel])
            spawnEnemy(ENEMY_TYPES.ZOMBIE);
        if (currentScreamersAmount < SCREAMER_THRESHOLD_SPAWN_LIMIT[currentLevel])
            spawnEnemy(ENEMY_TYPES.SCREAMER);
        if (currentMimicAmounts < MIMIC_THRESHOLD_SPAWN_LIMIT[currentLevel])
            spawnEnemy(ENEMY_TYPES.MIMIC);
    }

    public boolean canBeCorrupted(BlockPos pPos){
        for(Direction direction : Direction.values()) {
            BlockPos blockpos = pPos.relative(direction);
            BlockState blockstate = level.getBlockState(blockpos);
            if (BLOCKS_COUNTERPARTS.containsValue(blockstate.getBlock()))
                return true;
        }
        return false;
    }

    private boolean spreadToBlock(BlockPos pos){
        Block block = level.getBlockState(pos).getBlock();
        if (!BLOCKS_COUNTERPARTS.containsKey(block))
            return false;
        level.setBlockAndUpdate(pos, BLOCKS_COUNTERPARTS.get(block).defaultBlockState());
        blocksSpread++;
        return true;
    }

    public void randomTick(BlockPos pPos, RandomSource pRandom){
        if (canBeCorrupted(pPos)){
            for(int i = 0; i < 4; ++i) {
                BlockPos blockpos = pPos.offset(pRandom.nextInt(3) - 1, pRandom.nextInt(5) - 3, pRandom.nextInt(3) - 1);
                spreadToBlock(blockpos);
            }
        }
    }

    public void tickChunk(int pRandomTickSpeed){
        ChunkAccess chunk = level.getChunk(center);
        int i = chunk.getPos().getMinBlockX();
        int j = chunk.getPos().getMinBlockZ();

        LevelChunkSection[] alevelchunksection = chunk.getSections();

        for(int l = 0; l < alevelchunksection.length; ++l) {
            LevelChunkSection levelchunksection = alevelchunksection[l];
            if (levelchunksection.isRandomlyTicking()) {
                int j1 = chunk.getSectionYFromSectionIndex(l);
                int k1 = SectionPos.sectionToBlockCoord(j1);
                for (int l1 = 0; l1 < pRandomTickSpeed; ++l1) {
                    BlockPos blockpos3 = level.getBlockRandomPos(i, k1, j, 15);
                    //BlockState blockstate2 = levelchunksection.getBlockState(blockpos3.getX() - i, blockpos3.getY() - k1, blockpos3.getZ() - j);
                    randomTick(blockpos3, level.random);
                }
            }
        }
    }


}
