package org.multicoder.nlti.commands;

import net.minecraft.text.Text;
import org.multicoder.nlti.twitch.MulticoderTwitchConnection;

public class Hungry
{
    public static void Trigger(String Username)
    {
        MulticoderTwitchConnection.SERVER.getPlayerManager().getPlayerList().forEach(player -> {
            player.getHungerManager().setFoodLevel(2);
            player.getHungerManager().setSaturationLevel(0f);
        });
        MulticoderTwitchConnection.SERVER.getPlayerManager().broadcast(Text.of(Username + " Has ran the command: Hungry"),false);
    }
}
