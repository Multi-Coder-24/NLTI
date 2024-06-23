package org.multicoder.nlti.commands;

import net.minecraft.text.Text;
import net.minecraft.world.World;
import org.multicoder.nlti.twitch.MulticoderTwitchConnection;

import java.util.Objects;

public class Rain
{
    public static void Trigger(String Username)
    {
        Objects.requireNonNull(MulticoderTwitchConnection.SERVER.getWorld(World.OVERWORLD),"Server.getWorld(World.OVERWORLD) returned null").setWeather(0, -1, true, false);
        MulticoderTwitchConnection.SERVER.getPlayerManager().broadcast(Text.of(Username + " Has ran the command: Weather Rain"),false);
    }
}
