package net.alberdrocs.darkaethercorruptionmod.incursion;

import net.alberdrocs.darkaethercorruptionmod.block.ModBlocks;
import net.alberdrocs.darkaethercorruptionmod.entity.ModEntities;
import net.alberdrocs.darkaethercorruptionmod.entity.custom.DarkAetherZombieEntity;
import net.alberdrocs.darkaethercorruptionmod.entity.custom.MimicEntity;
import net.alberdrocs.darkaethercorruptionmod.entity.custom.ScreamerEntity;
import net.alberdrocs.darkaethercorruptionmod.sound.ModSounds;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.SectionPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.game.ClientboundSoundPacket;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.LevelChunk;
import net.minecraft.world.level.chunk.LevelChunkSection;

import java.util.HashMap;

public class OverworldIncursion {
    public enum ENEMY_TYPES {
        ZOMBIE, SCREAMER, MIMIC
    }
    private static final String[] CORRUPTION_LEVELS = {"SMALL", "ADVANCED", "CRITICAL", "APOCALYPTIC"};
    private static final int[] ZOMBIES_THRESHOLD_SPAWN_LIMIT = {5, 15, 25, 35};
    private static final int[] SCREAMER_THRESHOLD_SPAWN_LIMIT = {2, 4, 7, 13};
    private static final int[] MIMIC_THRESHOLD_SPAWN_LIMIT = {0, 1, 3, 6};
    private int currentZombiesAmount = 0;
    private int currentScreamersAmount = 0;
    private int currentMimicAmount = 0;
    private static final int TICKS_FOR_NEXT_SPAWN = 1250;
    private static final int TICKS_FOR_CONTAINMENT = 2000;
    private int spawningTimeout = 0;
    private int containmentTimer = 0;
    private final BlockPos center;
    private final ServerLevel level;
    private boolean ended = false;
    private boolean containmentStarted = false;
    private final int id;
    private int currentLevel = 0;
    private int blocksSpread = 0;
    private final RandomSource random = RandomSource.create();
    private static final HashMap<Block, Block> BLOCKS_COUNTERPARTS = new HashMap<>() {{
        put(Blocks.DIRT, ModBlocks.CORRUPTED_DIRT.get());
        put(Blocks.GRASS_BLOCK, ModBlocks.CORRUPTED_GRASS_BLOCK.get());
        put(Blocks.GRASS, ModBlocks.CORRUPTED_GRASS.get());
        put(Blocks.FERN, ModBlocks.CORRUPTED_FERN.get());
        put(Blocks.DEAD_BUSH, ModBlocks.CORRUPTED_DEAD_BUSH.get());
        put(Blocks.TALL_GRASS, ModBlocks.CORRUPTED_TALL_GRASS.get());
        put(Blocks.LARGE_FERN, ModBlocks.CORRUPTED_LARGE_FERN.get());
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

    public OverworldIncursion(ServerLevel pLevel, CompoundTag tag){
        this.level = pLevel;
        this.currentZombiesAmount = tag.getInt("currentZombiesAmount");
        this.currentScreamersAmount = tag.getInt("currentScreamersAmount");
        this.currentMimicAmount = tag.getInt("currentMimicAmount");
        this.center = new BlockPos(tag.getInt("pos_x"), tag.getInt("pos_y"), tag.getInt("pos_z"));
        this.id = tag.getInt("id");
        this.currentLevel = tag.getInt("currentLevel");
        this.blocksSpread = tag.getInt("blocksSpread");
    }

    public void startIncursion(){
        startCorruption();
        spawnPortal();
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

    public boolean isNeutralizerAtCorrectPos(BlockPos pos){
        System.out.println("Checking position:");
        System.out.println("\tNeutralizer: " + pos.getCenter().x + ", " + pos.getCenter().y + ", " + pos.getCenter().z);
        System.out.println("\tCenter: " + center.getCenter().x + ", " + center.getCenter().y + ", " + center.getCenter().z);
        return pos.getCenter().distanceToSqr(center.getCenter()) <= 100.0D;
    }

    public void beginContainment(){
        containmentStarted = true;
        System.out.println("Containment Started");
        for (ServerPlayer serverplayer : this.level.players()){
            if (serverplayer.position().distanceToSqr(center.getCenter()) < 90000.0D){
                serverplayer.connection.send(new ClientboundSoundPacket(ModSounds.INCURSION_CONTAINMENT_MUSIC.getHolder().get(),
                        SoundSource.MUSIC, serverplayer.getX(), serverplayer.getY(), serverplayer.getZ(), 64.0F, 1.0F, this.random.nextLong()));
                //level.playSound(serverplayer, serverplayer.blockPosition(), ModSounds.INCURSION_CONTAINMENT_MUSIC.get(), SoundSource.MUSIC);
            }
        }
    }

    public void endIncursion(){
        ended = true;
    }

    private void killAllEnemies(){

    }

    public int getId() {
        return id;
    }

    public int getBlocksSpread(){
        return blocksSpread;
    }

    public boolean isEnded(){
        return ended;
    }

    public void tick(){
        if (isEnded())
            return;

        if (containmentStarted){
            if (containmentTimer < TICKS_FOR_CONTAINMENT){
                containmentTimer++;
            } else {
                ended = true;
            }
        }

        for (int x = level.getChunk(center).getPos().x - 2; x <= level.getChunk(center).getPos().x + 2; x++) {
            for (int z = level.getChunk(center).getPos().z - 2; z <= level.getChunk(center).getPos().z + 2; z++) {
                tickChunk(level.getChunk(x, z), level.getGameRules().getInt(GameRules.RULE_RANDOMTICKING));
            }
        }

        if (currentLevel < 3){
            if (blocksSpread > (currentLevel + 1) * 500){
                currentLevel++;
            }
        }

        if (spawningTimeout < ((containmentStarted) ? TICKS_FOR_NEXT_SPAWN / 2 : TICKS_FOR_NEXT_SPAWN)){
            spawningTimeout++;
        } else {
            checkAndSpawnEnemy();
            spawningTimeout = 0;
        }
    }

    public void tickChunk(LevelChunk pChunk, int pRandomTickSpeed){
        int i = pChunk.getPos().getMinBlockX();
        int j = pChunk.getPos().getMinBlockZ();

        LevelChunkSection[] alevelchunksection = pChunk.getSections();

        for(int l = 0; l < alevelchunksection.length; ++l) {
            LevelChunkSection levelchunksection = alevelchunksection[l];
            if (levelchunksection.isRandomlyTicking()) {
                int k = SectionPos.sectionToBlockCoord(pChunk.getSectionYFromSectionIndex(l));
                for (int c = 0; c < pRandomTickSpeed; ++c) {
                    BlockPos blockpos = level.getBlockRandomPos(i, k, j, 15);
                    BlockState blockstate = levelchunksection.getBlockState(blockpos.getX() - i, blockpos.getY() - k, blockpos.getZ() - j);
                    if (blockstate.isRandomlyTicking()){
                        randomTick(blockpos, level.random);
                    }
                }
            }
        }
    }

    public void randomTick(BlockPos pPos, RandomSource pRandom){
        if (canBeCorrupted(pPos)){
            for(int i = 0; i < 4; ++i) {
                BlockPos blockpos = pPos.offset(pRandom.nextInt(3) - 1, pRandom.nextInt(5) - 3, pRandom.nextInt(3) - 1);
                spreadToBlock(blockpos);
            }
        }
    }

    private void checkAndSpawnEnemy(){
        if (currentZombiesAmount < ZOMBIES_THRESHOLD_SPAWN_LIMIT[currentLevel])
            spawnEnemy(ENEMY_TYPES.ZOMBIE);
        if (currentScreamersAmount < SCREAMER_THRESHOLD_SPAWN_LIMIT[currentLevel])
            spawnEnemy(ENEMY_TYPES.SCREAMER);
        if (currentMimicAmount < MIMIC_THRESHOLD_SPAWN_LIMIT[currentLevel])
            spawnEnemy(ENEMY_TYPES.MIMIC);
    }

    private void spawnEnemy(ENEMY_TYPES type){
        Entity entity;
        switch (type) {
            case SCREAMER -> {
                entity = new ScreamerEntity(ModEntities.SCREAMER.get(), level);
                entity.addTag("screamer_incursion_" + id);
                entity.addTag("overworld_incursion_spawned");
                currentScreamersAmount++;
            } case MIMIC -> {
                entity = new MimicEntity(ModEntities.MIMIC.get(), level);
                entity.addTag("mimic_incursion_" + id);
                entity.addTag("overworld_incursion_spawned");
                currentMimicAmount++;
            }
            default -> {
                entity = new DarkAetherZombieEntity(ModEntities.DARK_AETHER_ZOMBIE.get(), level);
                entity.addTag("zombie_incursion_" + id);
                entity.addTag("overworld_incursion_spawned");
                currentZombiesAmount++;
            }
        }
        entity.setPos(center.getCenter());
        level.addFreshEntity(entity);
        System.out.println("Spawned enemy");
    }

    public void updateKilledEnemy(ENEMY_TYPES type){
        switch (type){
            case SCREAMER -> currentScreamersAmount--;
            case MIMIC -> currentMimicAmount--;
            default -> currentZombiesAmount--;
        }
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

    public CompoundTag deserializer(){
        CompoundTag tag = new CompoundTag();
        tag.putInt("currentZombiesAmount", currentZombiesAmount);
        tag.putInt("currentScreamersAmount", currentScreamersAmount);
        tag.putInt("currentMimicAmount", currentMimicAmount);
        tag.putInt("currentLevel", currentLevel);
        tag.putInt("blocksSpread", blocksSpread);
        tag.putInt("id", id);
        tag.putInt("pos_x", center.getX());
        tag.putInt("pos_y", center.getY());
        tag.putInt("pos_z", center.getZ());
        return tag;
    }

}
