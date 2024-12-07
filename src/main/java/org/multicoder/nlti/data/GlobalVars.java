package org.multicoder.nlti.data;

import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.PersistentState;
import net.minecraft.world.PersistentStateManager;
import net.minecraft.world.World;
import org.multicoder.nlti.NLTI;

import java.util.Objects;

public class GlobalVars extends PersistentState
{
    public boolean CanSleep = true;
    public boolean Chests = false;
    public boolean Doors = false;
    @Override
    public NbtCompound writeNbt(NbtCompound nbt)
    {
        nbt.putBoolean("CanSleep",CanSleep);
        nbt.putBoolean("Chests",Chests);
        nbt.putBoolean("Doors",Doors);
        nbt.putString("version", NLTI.Version);
        return nbt;
    }
    public void UpdateSleepVar(boolean cansleep)
    {
        CanSleep = cansleep;
        this.markDirty();
    }
    public void UpdateDoors(boolean door)
    {
        Doors = door;
        this.markDirty();
    }
    public void UpdateChests(boolean chests)
    {
        Chests = chests;
        this.markDirty();
    }
    public static GlobalVars createFromNBT(NbtCompound tag)
    {
        GlobalVars GV = new GlobalVars();
        if(tag.contains("version"))
        {
            //  Current Update 3.0+
            if(!tag.getString("version").equals(NLTI.Version))
            {
                //  Older Version
                GV.CanSleep = tag.getBoolean("CanSleep");
                GV.Chests = tag.getBoolean("Chests");
                GV.Doors = true;
            }
            else
            {
                //  Current Version
                GV.CanSleep = tag.getBoolean("CanSleep");
                GV.Chests = tag.getBoolean("Chests");
                GV.Doors = tag.getBoolean("Doors");
            }
        }
        return GV;
    }

    private static final Type<GlobalVars> type = new Type<>(
            GlobalVars::new,
            GlobalVars::createFromNBT,
            null
    );
    public static GlobalVars getInstance(MinecraftServer server)
    {
        PersistentStateManager manager = Objects.requireNonNull(server.getWorld(World.OVERWORLD)).getPersistentStateManager();
        GlobalVars GV = manager.getOrCreate(type,"nlti");
        GV.markDirty();
        return GV;
    }
}
