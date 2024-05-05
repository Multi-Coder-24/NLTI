package org.multicoder.nlti.commands.player;

import net.minecraft.text.Text;
import org.multicoder.nlti.cooldowns.CooldownManager;
import org.multicoder.nlti.twitch.MulticoderTwitchConnection;

import java.time.LocalDateTime;

public class Steal
{
    public static void Trigger(String Username,String Channel)
    {
        LocalDateTime Now = LocalDateTime.now();
        if(!Now.isAfter(CooldownManager.STEAL))
        {
            MulticoderTwitchConnection.CHAT.sendMessage(Channel,"@" + Username + " This command is still on cooldown");
        }
        else
        {
            int Append = 0;
            if(MulticoderTwitchConnection.Config.ChaosMode)
            {
                Append = MulticoderTwitchConnection.Config.Steal[1];
            }
            else{
                Append = MulticoderTwitchConnection.Config.Steal[0];
            }
            Now = Now.plusSeconds(Append);
            CooldownManager.STEAL = Now;
            MulticoderTwitchConnection.SERVER.getPlayerManager().getPlayerList().forEach(player -> player.getMainHandStack().setCount(0));
            MulticoderTwitchConnection.SERVER.getPlayerManager().broadcast(Text.of(Username + " Has ran the command: Steal"),false);
        }
    }
    public static void Trigger()
    {
        MulticoderTwitchConnection.SERVER.getPlayerManager().getPlayerList().forEach(player -> player.getMainHandStack().setCount(0));
    }
}
