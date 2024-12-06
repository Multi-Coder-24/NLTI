package org.multicoder.nlti.commands.player;

import net.minecraft.text.Text;
import org.multicoder.nlti.NLTI;
import org.multicoder.nlti.cooldowns.CooldownManager;
import org.multicoder.nlti.twitch.MulticoderTwitchConnection;

import java.time.LocalDateTime;

public class Sleepless
{
    public static void Trigger(String User, String Channel)
    {
        LocalDateTime Now = LocalDateTime.now();
        if(!Now.isAfter(CooldownManager.SLEEPLESS))
        {
            MulticoderTwitchConnection.CHAT.sendMessage(Channel,"@" + User + " This command is still on cooldown");
        }
        else
        {
            int Append;
            if(MulticoderTwitchConnection.Config.ChaosMode)
            {
                Append = MulticoderTwitchConnection.Config.Sleepless[1];
            }
            else{
                Append = MulticoderTwitchConnection.Config.Sleepless[0];
            }
            Now = Now.plusSeconds(Append);
            CooldownManager.SLEEPLESS = Now;
            NLTI.Vars.UpdateSleepVar(false);
            MulticoderTwitchConnection.SERVER.getPlayerManager().broadcast(Text.of(User + " Has ran the command: Sleepless"),false);
        }
    }
    public static void Trigger()
    {
        NLTI.Vars.UpdateSleepVar(false);
    }
}
