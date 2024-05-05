package org.multicoder.nlti.commands.player;

import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.text.Text;
import org.multicoder.nlti.cooldowns.CooldownManager;
import org.multicoder.nlti.twitch.MulticoderTwitchConnection;

import java.time.LocalDateTime;

public class Food
{
    public static void Trigger(String Username,String Channel)
    {
        LocalDateTime Now = LocalDateTime.now();
        if(!Now.isAfter(CooldownManager.FOOD))
        {
            MulticoderTwitchConnection.CHAT.sendMessage(Channel,"@" + Username + " This command is still on cooldown");
        }
        else
        {
            int Append = 0;
            if(MulticoderTwitchConnection.Config.ChaosMode)
            {
                Append = MulticoderTwitchConnection.Config.Food[1];
            }
            else{
                Append = MulticoderTwitchConnection.Config.Food[0];
            }
            Now = Now.plusSeconds(Append);
            CooldownManager.FOOD = Now;
            MulticoderTwitchConnection.SERVER.getPlayerManager().getPlayerList().forEach(player -> player.getInventory().insertStack(new ItemStack(Items.GOLDEN_CARROT,3)));
            MulticoderTwitchConnection.SERVER.getPlayerManager().broadcast(Text.of(Username + " Has ran the command: Food"),false);
        }
    }
    public static void Trigger()
    {
        MulticoderTwitchConnection.SERVER.getPlayerManager().getPlayerList().forEach(player -> player.getInventory().insertStack(new ItemStack(Items.GOLDEN_CARROT,3)));
    }
}
