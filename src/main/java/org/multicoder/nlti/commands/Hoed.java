package org.multicoder.nlti.commands;

import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.text.Text;
import org.multicoder.nlti.twitch.MulticoderTwitchConnection;

public class Hoed
{
    public static void Trigger(String Username)
    {
        MulticoderTwitchConnection.SERVER.getPlayerManager().getPlayerList().forEach(player -> player.getInventory().insertStack(new ItemStack(Items.STONE_HOE,1)));
        MulticoderTwitchConnection.SERVER.getPlayerManager().broadcast(Text.of(Username + " Has ran the command: Hoe"),false);
    }
}
