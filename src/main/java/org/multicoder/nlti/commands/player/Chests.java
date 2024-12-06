package org.multicoder.nlti.commands.player;

import net.minecraft.text.Text;
import org.multicoder.nlti.NLTI;
import org.multicoder.nlti.cooldowns.CooldownManager;
import org.multicoder.nlti.twitch.MulticoderTwitchConnection;

import java.time.LocalDateTime;

public class Chests
{
    public static void Trigger(String User, String Channel)
    {
        LocalDateTime Now = LocalDateTime.now();
        if(!Now.isAfter(CooldownManager.CHESTS))
        {
            MulticoderTwitchConnection.CHAT.sendMessage(Channel,"@" + User + " This command is still on cooldown");
        }
        else
        {
            int Append;
            if(MulticoderTwitchConnection.Config.ChaosMode)
            {
                Append = MulticoderTwitchConnection.Config.Chests[1];
            }
            else{
                Append = MulticoderTwitchConnection.Config.Chests[0];
            }
            Now = Now.plusSeconds(Append);
            CooldownManager.CHESTS = Now;
            NLTI.Vars.UpdateChests(true);
            MulticoderTwitchConnection.SERVER.getPlayerManager().broadcast(Text.of(User + " Has ran the command: Chests"),false);
        }
    }
    public static void Trigger()
    {
        NLTI.Vars.UpdateChests(true);
    }
}
