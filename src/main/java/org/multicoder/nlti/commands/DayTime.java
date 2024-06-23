package org.multicoder.nlti.commands;

import net.minecraft.text.Text;
import net.minecraft.world.World;
import org.multicoder.nlti.twitch.MulticoderTwitchConnection;

import java.util.Objects;

public class DayTime
{
    public static void Trigger(String Username)
    {
        Objects.requireNonNull(MulticoderTwitchConnection.SERVER.getWorld(World.OVERWORLD),"Server.getWorld(World.OVERWORLD) returned null").setTimeOfDay(1000L);
        MulticoderTwitchConnection.SERVER.getPlayerManager().broadcast(Text.of(Username + " Has ran the command: Day"),false);
    }
}
