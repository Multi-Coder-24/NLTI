package org.multicoder.nlti.commands.world;

import net.minecraft.world.World;
import org.multicoder.nlti.commands.CommandInstance;
import org.multicoder.nlti.twitch.MulticoderTwitchConnection;
import org.multicoder.nlti.util.PostCommandLogic;

import java.time.LocalDateTime;
import java.util.Objects;

public class Clear
{
    public static void Trigger(String Username,String Channel, CommandInstance instance)
    {
        if(LocalDateTime.now().isAfter(instance.Cooldown)) {
            Objects.requireNonNull(MulticoderTwitchConnection.SERVER.getWorld(World.OVERWORLD),"Server.getWorld(World.OVERWORLD) returned null").setWeather(-1, 0, false, false);
            PostCommandLogic.Post(instance,Username);
        }
        else {
            MulticoderTwitchConnection.CHAT.sendMessage(Channel,"@" + Username + " This command is still on cooldown");
        }
    }
}
