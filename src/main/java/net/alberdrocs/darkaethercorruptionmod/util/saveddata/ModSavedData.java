package net.alberdrocs.darkaethercorruptionmod.util.saveddata;

import net.alberdrocs.darkaethercorruptionmod.incursion.OverworldIncursion;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.saveddata.SavedData;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class ModSavedData extends SavedData {

    public static final List<OverworldIncursionStorageObject> OVERWORLD_INCURSIONS = new ArrayList<>();

    @Override
    public CompoundTag save(CompoundTag pCompoundTag) {
        CompoundTag saveData = new CompoundTag();
        for (ListIterator<OverworldIncursionStorageObject> iterator = OVERWORLD_INCURSIONS.listIterator(); iterator.hasNext();){
            saveData.put("data" + iterator.nextIndex(), iterator.next().deserializer());
        }
        pCompoundTag.put("savedata", saveData);
        return pCompoundTag;
    }

    static class OverworldIncursionStorageObject{
        private final int currentZombiesAmount;
        private final int currentScreamersAmount;
        private final int currentMimicAmount;
        private final BlockPos center;
        private final int id;
        private final int currentLevel;
        private final int blocksSpread;

        OverworldIncursionStorageObject(int currentZombiesAmount, int currentScreamersAmount, int currentMimicAmount,
                                        int x, int y, int z, int id, int currentLevel, int blocksSpread) {
            this.currentZombiesAmount = currentZombiesAmount;
            this.currentScreamersAmount = currentScreamersAmount;
            this.currentMimicAmount = currentMimicAmount;
            this.center = new BlockPos(x, y, z);
            this.id = id;
            this.currentLevel = currentLevel;
            this.blocksSpread = blocksSpread;
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

        public static OverworldIncursionStorageObject serialize(CompoundTag tag){
            return new OverworldIncursionStorageObject(tag.getInt("currentZombiesAmount"), tag.getInt("currentScreamersAmount"),
                    tag.getInt("currentZMimicAmount"), tag.getInt("pos_x"), tag.getInt("pos_y"), tag.getInt("pos_z"),
                    tag.getInt("id"), tag.getInt("currentLevel"), tag.getInt("blocksSpread"));
        }
    }
}
