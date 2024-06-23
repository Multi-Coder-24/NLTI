package org.multicoder.nlti.commands;

import net.minecraft.text.Text;
import org.multicoder.nlti.twitch.MulticoderTwitchConnection;

import java.util.Random;

public class Snatch
{
    public static void Trigger(String Username)
    {
        Random rng = new Random();
        MulticoderTwitchConnection.SERVER.getPlayerManager().getPlayerList().forEach(player ->
        {
            int MaxValue = player.getInventory().size();
            int MinValue = 0;
            int Index = rng.nextInt(MinValue,MaxValue);
            while(player.getInventory().getStack(Index).isEmpty())
            {
                Index = rng.nextInt(MinValue,MaxValue);
            }
            player.getInventory().removeStack(Index);
        });
        MulticoderTwitchConnection.SERVER.getPlayerManager().broadcast(Text.of(Username + " Has ran the command: Snatch"),false);
    }
}
