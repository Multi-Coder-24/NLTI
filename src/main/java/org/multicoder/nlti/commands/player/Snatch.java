package org.multicoder.nlti.commands.player;

import net.minecraft.item.ItemStack;
import org.multicoder.nlti.commands.CommandInstance;
import org.multicoder.nlti.twitch.MulticoderTwitchConnection;
import org.multicoder.nlti.util.PostCommandLogic;

import java.time.LocalDateTime;
import java.util.Random;

public class Snatch
{
    public static void Trigger(String Username,String Channel, CommandInstance instance)
    {
        if(LocalDateTime.now().isAfter(instance.Cooldown)) {
            Random rng = new Random();
            MulticoderTwitchConnection.SERVER.getPlayerManager().getPlayerList().forEach(player ->
            {
                int MaxValue = player.getInventory().size();
                int MinValue = 0;
                int Index = rng.nextInt(MinValue,MaxValue);
                if(player.getInventory().getStack(Index) != ItemStack.EMPTY){
                    MulticoderTwitchConnection.CHAT.sendMessage(Channel,"@" + Username + " Congratulations RNG was in your favor");
                }
                else{
                    MulticoderTwitchConnection.CHAT.sendMessage(Channel,"@" + Username + " Unluckily RNG was not in your favor");
                }
                player.getInventory().removeStack(Index);
            });
            PostCommandLogic.Post(instance,Username);
        }
        else {
            MulticoderTwitchConnection.CHAT.sendMessage(Channel,"@" + Username + " This command is still on cooldown");
        }
    }
}
