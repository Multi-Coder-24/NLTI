package org.multicoder.nlti.commands.player;

import org.multicoder.nlti.cooldowns.CooldownManager;
import org.multicoder.nlti.twitch.MulticoderTwitchConnection;

import java.time.LocalDateTime;

public class Hungry
{
    public static void Trigger(String Username,String Channel)
    {
        LocalDateTime Now = LocalDateTime.now();
        if(!Now.isAfter(CooldownManager.HUNGRY))
        {
            MulticoderTwitchConnection.CHAT.sendMessage(Channel,"@" + Username + " This command is still on cooldown");
        }
        else {
            int Append;
            if (MulticoderTwitchConnection.Config.ChaosMode) {
                Append = MulticoderTwitchConnection.Config.Hungry[1];
            } else {
                Append = MulticoderTwitchConnection.Config.Hungry[0];
            }
            Now = Now.plusSeconds(Append);
            CooldownManager.HUNGRY = Now;
            MulticoderTwitchConnection.SERVER.getPlayerManager().getPlayerList().forEach(player -> {
                player.getHungerManager().setFoodLevel(2);
                player.getHungerManager().setSaturationLevel(0f);
            });
        }
    }
    public static void Trigger()
    {
        MulticoderTwitchConnection.SERVER.getPlayerManager().getPlayerList().forEach(player ->{
            player.getHungerManager().setFoodLevel(2);
            player.getHungerManager().setSaturationLevel(0f);
        });
    }
}
