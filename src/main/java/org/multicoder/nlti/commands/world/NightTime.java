package org.multicoder.nlti.commands.world;

import net.minecraft.text.Text;
import net.minecraft.world.World;
import org.multicoder.nlti.cooldowns.CooldownManager;
import org.multicoder.nlti.twitch.MulticoderTwitchConnection;

import java.time.LocalDateTime;

public class NightTime
{
    public static void Trigger(String Username,String Channel)
    {
        LocalDateTime Now = LocalDateTime.now();
        if(!Now.isAfter(CooldownManager.NIGHT_TIME))
        {
            MulticoderTwitchConnection.CHAT.sendMessage(Channel,"@" + Username + " This command is still on cooldown");
        }
        else
        {
            int Append = 0;
            if(MulticoderTwitchConnection.Config.ChaosMode)
            {
                Append = MulticoderTwitchConnection.Config.Night[1];
            }
            else{
                Append = MulticoderTwitchConnection.Config.Night[0];
            }
            Now = Now.plusSeconds(Append);
            CooldownManager.NIGHT_TIME = Now;
            MulticoderTwitchConnection.SERVER.getWorld(World.OVERWORLD).setTimeOfDay(13000L);
            MulticoderTwitchConnection.SERVER.getPlayerManager().broadcast(Text.of(Username + " Has ran the command: Night"),false);
        }
    }
    public static void Trigger()
    {
        MulticoderTwitchConnection.SERVER.getWorld(World.OVERWORLD).setTimeOfDay(13000L);
    }
}
