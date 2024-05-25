package org.multicoder.nlti.data;

import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.PersistentState;
import net.minecraft.world.PersistentStateManager;
import net.minecraft.world.World;

import java.util.Objects;

public class GlobalVars extends PersistentState
{
    public boolean CanSleep = true;
    public boolean Chests = false;
    @Override
    public NbtCompound writeNbt(NbtCompound nbt)
    {
        nbt.putBoolean("CanSleep",CanSleep);
        nbt.putBoolean("Chests",Chests);
        return nbt;
    }
    public void UpdateSleepVar(boolean cansleep)
    {
        CanSleep = cansleep;
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
        GV.CanSleep = tag.getBoolean("CanSleep");
        GV.Chests = tag.getBoolean("Chests");
        return GV;
    }

    private static final Type<GlobalVars> type = new Type<>(
            GlobalVars::new,
            GlobalVars::createFromNBT,
            null
    );
    public static GlobalVars getInstance(MinecraftServer server){
        PersistentStateManager manager = Objects.requireNonNull(server.getWorld(World.OVERWORLD)).getPersistentStateManager();
        GlobalVars GV = manager.getOrCreate(type,"nlti");
        GV.markDirty();
        return GV;
    }
}
