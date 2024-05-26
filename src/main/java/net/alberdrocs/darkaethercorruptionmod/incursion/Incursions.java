package net.alberdrocs.darkaethercorruptionmod.incursion;

import net.alberdrocs.darkaethercorruptionmod.block.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.chunk.LevelChunk;
import net.minecraft.world.level.saveddata.SavedData;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Incursions extends SavedData {
    private int ticksUntilNextIncursion = 2000;
    private boolean accessedDarkAether = false;
    private boolean overworldIncursionInPlace = false;

    private final Map<Integer, OverworldIncursion> overworldIncursionMap = new HashMap<>();
    private final Map<Integer, EFIncursion> efIncursionMap = new HashMap<>();
    private final ServerLevel level;
    private int nextOverworldAvailableID;
    private int nextEFAvailableID;
    private int tick;
    private final RandomSource random = RandomSource.create();

    //EFIncursions
    static final int ZOMBIES_AMOUNT = 10;
    static final int SCREAMERS_AMOUNT = 5;
    static final int MIMIC_AMOUNT = 2;
    static final int[] AMOUNT_KILLED_FOR_NEXT_WAVE = {0, 6, 12, 17};

    //Overworld Incursions
    static final String[] CORRUPTION_LEVELS = {"SMALL", "ADVANCED", "CRITICAL", "APOCALYPTIC"};
    static final int[] ZOMBIES_THRESHOLD_SPAWN_LIMIT = {5, 15, 25, 35};
    static final int[] SCREAMER_THRESHOLD_SPAWN_LIMIT = {2, 4, 7, 13};
    static final int[] MIMIC_THRESHOLD_SPAWN_LIMIT = {0, 1, 3, 6};
    static final int TICKS_FOR_NEXT_SPAWN = 600;
    static final int TICKS_FOR_CONTAINMENT = 3500;
    public static final HashMap<Block, Block> BLOCKS_COUNTERPARTS = new HashMap<>() {{
        put(Blocks.DIRT, ModBlocks.CORRUPTED_DIRT.get());
        put(Blocks.PODZOL, ModBlocks.CORRUPTED_DIRT.get());
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
        put(Blocks.ACACIA_LEAVES, Blocks.AIR);
        put(Blocks.AZALEA_LEAVES, Blocks.AIR);
        put(Blocks.BIRCH_LEAVES, Blocks.AIR);
        put(Blocks.CHERRY_LEAVES, Blocks.AIR);
        put(Blocks.DARK_OAK_LEAVES, Blocks.AIR);
        put(Blocks.FLOWERING_AZALEA_LEAVES, Blocks.AIR);
        put(Blocks.JUNGLE_LEAVES, Blocks.AIR);
        put(Blocks.MANGROVE_LEAVES, Blocks.AIR);
        put(Blocks.OAK_LEAVES, Blocks.AIR);
        put(Blocks.SPRUCE_LEAVES, Blocks.AIR);
        put(Blocks.PINK_PETALS, Blocks.AIR);
        put(Blocks.SWEET_BERRY_BUSH, Blocks.AIR);
        put(Blocks.SNOW, Blocks.AIR);
    }};

    public Incursions(ServerLevel level) {
        this.level = level;
        this.nextOverworldAvailableID = 1;
        this.nextEFAvailableID = 1;
        this.setDirty();
    }

    public OverworldIncursion getOverworldIncursion(int id){
        return overworldIncursionMap.get(id);
    }

    public List<OverworldIncursion> getAllOverworldIncursions(){
        return overworldIncursionMap.values().stream().toList();
    }

    public List<EFIncursion> getAllEFIncursions(){
        return efIncursionMap.values().stream().toList();
    }


    public void tick() {
        //Randomly start an Overworld Incursion if an EFIncursion has been completed
        if (accessedDarkAether && !overworldIncursionInPlace)
            randomOverworldIncursion();

        ++this.tick;
        //Tick EF incursions
        Iterator<EFIncursion> iteratorEF = this.efIncursionMap.values().iterator();
        while(iteratorEF.hasNext()) {
            EFIncursion incursion = iteratorEF.next();

            if (incursion.isEnded()) {
                iteratorEF.remove();
                accessedDarkAether = true;
                this.setDirty();
            } else {
                incursion.tick();
            }
        }

        //Tick overworld incursions
        Iterator<OverworldIncursion> iteratorOverworld = this.overworldIncursionMap.values().iterator();
        while(iteratorOverworld.hasNext()) {
            OverworldIncursion incursion = iteratorOverworld.next();

            if (incursion.isContained()) {
                iteratorOverworld.remove();
                overworldIncursionInPlace = false;
                this.setDirty();
            } else {
                incursion.tick();
            }
        }

        if (this.tick % 200 == 0) {
            this.setDirty();
        }
    }

    private void randomOverworldIncursion() {
        if (ticksUntilNextIncursion > 0){
            this.ticksUntilNextIncursion = Math.max(this.ticksUntilNextIncursion - 1, 0);
        } else {
            System.out.println("Timer at 0.");
            //10% chance of triggering an incursion
            if (random.nextInt(10) == 0){
                //Check if any player is in the Overworld
                for (Player player:level.getServer().getPlayerList().getPlayers()) {
                    if (player.level().dimension() == Level.OVERWORLD){
                        //Get a random chunk surrounding the player in a 10 chunk distance
                        LevelChunk chunk = level.getChunk(player.chunkPosition().x + random.nextInt(10),
                                player.chunkPosition().z + random.nextInt(10));
                        //Create the incursion in a random position of the selected chunk
                        BlockPos randomPos = getRandomSurfaceBlock(chunk);
                        if (randomPos != null)
                            createOverworldIncursion(level, getRandomSurfaceBlock(chunk));
                    }
                }
            }
            ticksUntilNextIncursion = 300;
        }
    }

    public void createOverworldIncursion(ServerLevel pLevel, BlockPos pCenter){
        OverworldIncursion incursion = new OverworldIncursion(getOverworldUniqueId(), pLevel, pCenter);
        incursion.startIncursion();
        overworldIncursionMap.put(incursion.getId(), incursion);
        overworldIncursionInPlace = true;
    }

    public void createEFIncursion(ServerLevel pLevel, BlockPos pCenter){
        EFIncursion incursion = new EFIncursion(getEFUniqueId(), pLevel, pCenter);
        incursion.createIncursion();
        efIncursionMap.put(incursion.getId(), incursion);
    }

    public void checkAndStartIncursionContainment(BlockPos pos){
        for (OverworldIncursion incursion:this.overworldIncursionMap.values()) {
            if (incursion.isNeutralizerAtCorrectPos(pos))
                incursion.beginContainment();
        }
    }

    private BlockPos getRandomSurfaceBlock(LevelChunk chunk) {
        int chunkX = chunk.getPos().getMinBlockX();
        int chunkZ = chunk.getPos().getMinBlockZ();

        // Generate random x and z coordinates within the chunk
        int x = chunkX + random.nextInt(16);
        int z = chunkZ + random.nextInt(16);

        Level world = chunk.getLevel();
        int y = world.getHeight();

        // Find the top non-air and non-tree block at the (x, z) position
        for (; y > 0; y--) {
            BlockPos pos = new BlockPos(x, y, z);
            if (!world.getBlockState(pos).isAir() && !world.getBlockState(pos).is(BlockTags.LEAVES) &&
                    !world.getBlockState(pos).is(BlockTags.LOGS) && !world.getBlockState(pos).is(Blocks.WATER)) {
                return pos;
            }
        }
        return null;
    }

    public static Incursions load(ServerLevel pLevel, CompoundTag pTag) {
        Incursions incursions = new Incursions(pLevel);
        incursions.nextOverworldAvailableID = pTag.getInt("NextAvailableOverworldID");
        incursions.nextEFAvailableID = pTag.getInt("NextAvailableEFID");
        incursions.tick = pTag.getInt("Tick");
        incursions.accessedDarkAether = pTag.getBoolean("AccessedDarkAether");
        incursions.overworldIncursionInPlace = pTag.getBoolean("OverworldIncursionInPlace");
        ListTag listtag = pTag.getList("OverworldIncursions", 10);
        ListTag listtag1 = pTag.getList("EFIncursions", 10);

        for(int i = 0; i < listtag.size(); ++i) {
            CompoundTag compoundtag = listtag.getCompound(i);
            OverworldIncursion incursion = new OverworldIncursion(pLevel, compoundtag);
            incursions.overworldIncursionMap.put(incursion.getId(), incursion);
        }

        for(int i = 0; i < listtag1.size(); ++i) {
            CompoundTag compoundtag = listtag1.getCompound(i);
            EFIncursion incursion = new EFIncursion(pLevel, compoundtag);
            incursions.efIncursionMap.put(incursion.getId(), incursion);
            if (incursion.isEnded())
                incursions.accessedDarkAether = true;
        }

        return incursions;
    }

    @Override
    public CompoundTag save(CompoundTag pCompoundTag) {
        pCompoundTag.putInt("NextAvailableOverworldID", this.nextOverworldAvailableID);
        pCompoundTag.putInt("NextAvailableEFID", this.nextEFAvailableID);
        pCompoundTag.putInt("Tick", this.tick);
        pCompoundTag.putBoolean("AccessedDarkAether", this.accessedDarkAether);
        pCompoundTag.putBoolean("OverworldIncursionInPlace", this.overworldIncursionInPlace);

        ListTag listtag = new ListTag();
        for(OverworldIncursion incursion : this.overworldIncursionMap.values()) {
            CompoundTag compoundtag = incursion.deserializer();
            listtag.add(compoundtag);
        }

        ListTag listtag1 = new ListTag();
        for(EFIncursion incursion : this.efIncursionMap.values()) {
            CompoundTag compoundtag = incursion.deserializer();
            listtag1.add(compoundtag);
        }

        pCompoundTag.put("OverworldIncursions", listtag);
        pCompoundTag.put("EFIncursions", listtag1);
        return pCompoundTag;
    }

    public static String getFileId() {
        return "incursions";
    }

    private int getOverworldUniqueId() {
        return ++this.nextOverworldAvailableID;
    }

    private int getEFUniqueId() {
        return ++this.nextEFAvailableID;
    }

    public enum ENEMY_TYPES {
        ZOMBIE, SCREAMER, MIMIC
    }
}
