package org.multicoder.nlti.commands.player;

import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import org.multicoder.nlti.commands.CommandInstance;
import org.multicoder.nlti.twitch.MulticoderTwitchConnection;
import org.multicoder.nlti.util.PostCommandLogic;

import java.time.LocalDateTime;

public class Hoed
{
    public static void Trigger(String Username,String Channel, CommandInstance instance) {
        if (LocalDateTime.now().isAfter(instance.Cooldown)) {
            MulticoderTwitchConnection.SERVER.getPlayerManager().getPlayerList().forEach(player -> player.getInventory().insertStack(new ItemStack(Items.STONE_HOE, 1)));
            PostCommandLogic.Post(instance,Username);
        } else {
            MulticoderTwitchConnection.CHAT.sendMessage(Channel, "@" + Username + " This command is still on cooldown");
        }
    }
}
