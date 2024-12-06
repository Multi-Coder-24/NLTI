package org.multicoder.nlti.commands.player;

import net.minecraft.text.Text;
import org.multicoder.nlti.NLTI;
import org.multicoder.nlti.cooldowns.CooldownManager;
import org.multicoder.nlti.twitch.MulticoderTwitchConnection;

import java.time.LocalDateTime;

public class NoChests
{
    public static void Trigger(String User, String Channel)
    {
        LocalDateTime Now = LocalDateTime.now();
        if(!Now.isAfter(CooldownManager.NOCHESTS))
        {
            MulticoderTwitchConnection.CHAT.sendMessage(Channel,"@" + User + " This command is still on cooldown");
        }
        else
        {
            int Append;
            if(MulticoderTwitchConnection.Config.ChaosMode)
            {
                Append = MulticoderTwitchConnection.Config.NoChests[1];
            }
            else{
                Append = MulticoderTwitchConnection.Config.NoChests[0];
            }
            Now = Now.plusSeconds(Append);
            CooldownManager.NOCHESTS = Now;
            NLTI.Vars.UpdateChests(false);
            MulticoderTwitchConnection.SERVER.getPlayerManager().broadcast(Text.of(User + " Has ran the command: No Chests"),false);
        }
    }
    public static void Trigger()
    {
        NLTI.Vars.UpdateChests(false);
    }
}
