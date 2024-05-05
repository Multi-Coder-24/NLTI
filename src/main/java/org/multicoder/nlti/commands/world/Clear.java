package org.multicoder.nlti.commands.world;

import net.minecraft.text.Text;
import net.minecraft.world.World;
import org.multicoder.nlti.cooldowns.CooldownManager;
import org.multicoder.nlti.twitch.MulticoderTwitchConnection;

import java.time.LocalDateTime;

public class Clear
{
    public static void Trigger(String Username,String Channel)
    {
        LocalDateTime Now = LocalDateTime.now();
        if(!Now.isAfter(CooldownManager.BLIND))
        {
            MulticoderTwitchConnection.CHAT.sendMessage(Channel,"@" + Username + " This command is still on cooldown");
        }
        else {
            int Append = 0;
            if (MulticoderTwitchConnection.Config.ChaosMode) {
                Append = MulticoderTwitchConnection.Config.Blindness[1];
            } else {
                Append = MulticoderTwitchConnection.Config.Blindness[0];
            }
            Now = Now.plusSeconds(Append);
            CooldownManager.BLIND = Now;
            MulticoderTwitchConnection.SERVER.getWorld(World.OVERWORLD).setWeather(-1, 0, false, false);
            MulticoderTwitchConnection.SERVER.getPlayerManager().broadcast(Text.of(Username + " Has ran the command: Weather Clear"),false);
        }
    }
    public static void Trigger()
    {
        MulticoderTwitchConnection.SERVER.getWorld(World.OVERWORLD).setWeather(-1,0,false,false);
    }
}
