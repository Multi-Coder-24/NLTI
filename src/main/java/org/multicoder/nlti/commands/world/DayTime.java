package org.multicoder.nlti.commands.world;

import net.minecraft.text.Text;
import net.minecraft.world.World;
import org.multicoder.nlti.cooldowns.CooldownManager;
import org.multicoder.nlti.twitch.MulticoderTwitchConnection;

import java.time.LocalDateTime;
import java.util.Objects;

public class DayTime
{
    public static void Trigger(String Username,String Channel)
    {
        LocalDateTime Now = LocalDateTime.now();
        if(!Now.isAfter(CooldownManager.DAY_TIME))
        {
            MulticoderTwitchConnection.CHAT.sendMessage(Channel,"@" + Username + " This command is still on cooldown");
        }
        else
        {
            int Append;
            if(MulticoderTwitchConnection.Config.ChaosMode)
            {
                Append = MulticoderTwitchConnection.Config.Day[1];
            }
            else{
                Append = MulticoderTwitchConnection.Config.Day[0];
            }
            Now = Now.plusSeconds(Append);
            CooldownManager.DAY_TIME = Now;
            Objects.requireNonNull(MulticoderTwitchConnection.SERVER.getWorld(World.OVERWORLD),"Server.getWorld(World.OVERWORLD) returned null").setTimeOfDay(1000L);
            MulticoderTwitchConnection.SERVER.getPlayerManager().broadcast(Text.of(Username + " Has ran the command: Day"),false);
        }
    }
    public static void Trigger()
    {
        Objects.requireNonNull(MulticoderTwitchConnection.SERVER.getWorld(World.OVERWORLD),"Server.getWorld(World.OVERWORLD) returned null").setTimeOfDay(1000L);
    }
}
