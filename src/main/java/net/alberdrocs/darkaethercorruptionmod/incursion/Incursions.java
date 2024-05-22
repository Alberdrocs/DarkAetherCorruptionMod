package net.alberdrocs.darkaethercorruptionmod.incursion;

import net.alberdrocs.darkaethercorruptionmod.block.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.saveddata.SavedData;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Incursions extends SavedData {
    private final Map<Integer, OverworldIncursion> overworldIncursionMap = new HashMap<>();
    private final Map<Integer, EFIncursion> efIncursionMap = new HashMap<>();
    private final ServerLevel level;
    private int nextOverworldAvailableID;
    private int nextEFAvailableID;
    private int tick;
    public static final HashMap<Block, Block> BLOCKS_COUNTERPARTS = new HashMap<>() {{
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
    }};

    public Incursions(ServerLevel level) {
        this.level = level;
        this.nextOverworldAvailableID = 1;
        this.setDirty();
    }

    public OverworldIncursion getOverworldIncursion(int id){
        return overworldIncursionMap.get(id);
    }

    public List<OverworldIncursion> getAllOverworldIncursions(){
        return overworldIncursionMap.values().stream().toList();
    }

    public void tick() {
        ++this.tick;
        //Tick EF incursions
        Iterator<EFIncursion> iteratorEF = this.efIncursionMap.values().iterator();
        while(iteratorEF.hasNext()) {
            EFIncursion incursion = iteratorEF.next();

            if (incursion.isEnded()) {
                iteratorEF.remove();
                this.setDirty();
            } else {
                incursion.tick();
            }
        }

        //Tick overworld incursions
        Iterator<OverworldIncursion> iteratorOverworld = this.overworldIncursionMap.values().iterator();
        while(iteratorOverworld.hasNext()) {
            OverworldIncursion incursion = iteratorOverworld.next();

            if (incursion.isEnded()) {
                iteratorOverworld.remove();
                this.setDirty();
            } else {
                incursion.tick();
            }
        }

        if (this.tick % 200 == 0) {
            this.setDirty();
        }
    }

    public OverworldIncursion createOverworldIncursion(ServerLevel pLevel, BlockPos pCenter){
        OverworldIncursion incursion = new OverworldIncursion(getUniqueId(), pLevel, pCenter);
        incursion.startIncursion();
        overworldIncursionMap.put(incursion.getId(), incursion);
        return incursion;
    }

    public void checkAndStartIncursionContainment(BlockPos pos){
        for (OverworldIncursion incursion:this.overworldIncursionMap.values()) {
            if (incursion.isNeutralizerAtCorrectPos(pos))
                incursion.beginContainment();
        }
    }

    public static Incursions load(ServerLevel pLevel, CompoundTag pTag) {
        Incursions incursions = new Incursions(pLevel);
        incursions.nextOverworldAvailableID = pTag.getInt("NextAvailableOverworldID");
        incursions.nextEFAvailableID = pTag.getInt("NextAvailableEFID");
        incursions.tick = pTag.getInt("Tick");
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
        }

        return incursions;
    }

    @Override
    public CompoundTag save(CompoundTag pCompoundTag) {
        pCompoundTag.putInt("NextAvailableOverworldID", this.nextOverworldAvailableID);
        pCompoundTag.putInt("NextAvailableEFID", this.nextEFAvailableID);
        pCompoundTag.putInt("Tick", this.tick);

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

    private int getUniqueId() {
        return ++this.nextOverworldAvailableID;
    }
}
