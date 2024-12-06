package org.multicoder.nlti.commands.player;

import net.minecraft.text.Text;
import org.multicoder.nlti.NLTI;
import org.multicoder.nlti.cooldowns.CooldownManager;
import org.multicoder.nlti.twitch.MulticoderTwitchConnection;

import java.time.LocalDateTime;

public class Sleepful
{
    public static void Trigger(String User, String Channel)
    {
        LocalDateTime Now = LocalDateTime.now();
        if(!Now.isAfter(CooldownManager.SLEEPFUL))
        {
            MulticoderTwitchConnection.CHAT.sendMessage(Channel,"@" + User + " This command is still on cooldown");
        }
        else
        {
            int Append;
            if(MulticoderTwitchConnection.Config.ChaosMode)
            {
                Append = MulticoderTwitchConnection.Config.Sleepful[1];
            }
            else{
                Append = MulticoderTwitchConnection.Config.Sleepful[0];
            }
            Now = Now.plusSeconds(Append);
            CooldownManager.SLEEPFUL = Now;
            NLTI.Vars.UpdateSleepVar(true);
            MulticoderTwitchConnection.SERVER.getPlayerManager().broadcast(Text.of(User + " Has ran the command: Sleepful"),false);
        }
    }
    public static void Trigger()
    {
        NLTI.Vars.UpdateSleepVar(true);
    }
}
