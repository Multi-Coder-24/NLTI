package org.multicoder.nlti.commands;

import net.minecraft.text.Text;
import org.multicoder.nlti.cooldowns.CooldownManager;
import org.multicoder.nlti.twitch.MulticoderTwitchConnection;

import java.time.LocalDateTime;
import java.util.Random;

public class Snatch
{
    public static void Trigger(String Username,String Channel)
    {
        LocalDateTime Now = LocalDateTime.now();
        if(!Now.isAfter(CooldownManager.SNATCH))
        {
            MulticoderTwitchConnection.CHAT.sendMessage(Channel,"@" + Username + " This command is still on cooldown");
        }
        else
        {
            int Append = 0;
            if(MulticoderTwitchConnection.Config.ChaosMode)
            {
                Append = MulticoderTwitchConnection.Config.Snatch[1];
            }
            else{
                Append = MulticoderTwitchConnection.Config.Snatch[0];
            }
            Now = Now.plusSeconds(Append);
            CooldownManager.SNATCH = Now;
            Random rng = new Random();
            MulticoderTwitchConnection.SERVER.getPlayerManager().getPlayerList().forEach(player -> {
                int MaxValue = player.getInventory().size();
                int MinValue = 0;
                int Index = rng.nextInt(MinValue,MaxValue);
                player.getInventory().removeStack(Index);
            });
            MulticoderTwitchConnection.SERVER.getPlayerManager().broadcast(Text.of(Username + " Has ran the command: Snatch"),false);
        }
    }
}
