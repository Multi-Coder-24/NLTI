package org.multicoder.nlti.commands.player;

import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import org.multicoder.nlti.cooldowns.CooldownManager;
import org.multicoder.nlti.twitch.MulticoderTwitchConnection;

import java.time.LocalDateTime;
import java.util.Random;

public class Snatch
{
    public static void Trigger(String Username,String Channel)
    {
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
        MulticoderTwitchConnection.SERVER.getPlayerManager().broadcast(Text.of(Username + " Has ran the command: Snatch"),false);
    }
    public static void Trigger()
    {
        Random rng = new Random();
        MulticoderTwitchConnection.SERVER.getPlayerManager().getPlayerList().forEach(player -> {
            int MaxValue = player.getInventory().size();
            int MinValue = 0;
            int Index = rng.nextInt(MinValue,MaxValue);
            player.getInventory().removeStack(Index);
        });
    }
}
