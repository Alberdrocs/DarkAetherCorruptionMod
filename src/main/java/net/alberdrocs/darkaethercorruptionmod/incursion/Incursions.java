package net.alberdrocs.darkaethercorruptionmod.incursion;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.saveddata.SavedData;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Incursions extends SavedData {
    private final Map<Integer, OverworldIncursion> incursionMap = new HashMap<>();
    private final ServerLevel level;
    private int nextAvailableID;
    private int tick;

    public Incursions(ServerLevel level) {
        this.level = level;
        this.nextAvailableID = 1;
        this.setDirty();
    }

    public OverworldIncursion get(int id){
        return incursionMap.get(id);
    }

    public List<OverworldIncursion> getAll(){
        return incursionMap.values().stream().toList();
    }

    public void tick() {
        ++this.tick;
        Iterator<OverworldIncursion> iterator = this.incursionMap.values().iterator();

        while(iterator.hasNext()) {
            OverworldIncursion incursion = iterator.next();

            if (incursion.isEnded()) {
                iterator.remove();
                this.setDirty();
            } else {
                incursion.tick();
            }
        }

        if (this.tick % 200 == 0) {
            this.setDirty();
        }
    }

    public OverworldIncursion createIncursion(ServerLevel pLevel, BlockPos pCenter){
        OverworldIncursion incursion = new OverworldIncursion(getUniqueId(), pLevel, pCenter);
        incursion.startIncursion();
        incursionMap.put(incursion.getId(), incursion);
        return incursion;
    }

    public void checkAndStartIncursionContainment(BlockPos pos){
        for (OverworldIncursion incursion:this.incursionMap.values()) {
            if (incursion.isNeutralizerAtCorrectPos(pos))
                incursion.beginContainment();
        }
    }

    public static Incursions load(ServerLevel pLevel, CompoundTag pTag) {
        Incursions incursions = new Incursions(pLevel);
        incursions.nextAvailableID = pTag.getInt("NextAvailableID");
        incursions.tick = pTag.getInt("Tick");
        ListTag listtag = pTag.getList("Incursions", 10);

        for(int i = 0; i < listtag.size(); ++i) {
            CompoundTag compoundtag = listtag.getCompound(i);
            OverworldIncursion incursion = new OverworldIncursion(pLevel, compoundtag);
            incursions.incursionMap.put(incursion.getId(), incursion);
        }

        return incursions;
    }

    @Override
    public CompoundTag save(CompoundTag pCompoundTag) {
        pCompoundTag.putInt("NextAvailableID", this.nextAvailableID);
        pCompoundTag.putInt("Tick", this.tick);
        ListTag listtag = new ListTag();

        for(OverworldIncursion incursion : this.incursionMap.values()) {
            CompoundTag compoundtag = incursion.deserializer();
            listtag.add(compoundtag);
        }

        pCompoundTag.put("Incursions", listtag);
        return pCompoundTag;
    }

    public static String getFileId() {
        return "incursions";
    }

    private int getUniqueId() {
        return ++this.nextAvailableID;
    }
}
