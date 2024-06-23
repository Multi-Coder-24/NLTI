package org.multicoder.nlti.commands;

import net.minecraft.entity.ItemEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.math.BlockPos;
import org.multicoder.nlti.twitch.MulticoderTwitchConnection;

public class Cake
{
    public static void Trigger(String User)
    {
        MulticoderTwitchConnection.SERVER.getPlayerManager().getPlayerList().forEach(player ->
        {
            BlockPos AboveHead = player.getBlockPos().up(3);
            ItemStack Cake = new ItemStack(Items.CAKE,1).setCustomName(Text.literal("Gift From Spoonie").formatted(Formatting.BOLD));
            ItemEntity StackE1 = new ItemEntity(player.getWorld(),AboveHead.getX(),AboveHead.getY(),AboveHead.getZ(),Cake);
            player.getWorld().spawnEntity(StackE1);
            StackE1.setPos(AboveHead.getX() + 0.5,AboveHead.getY(), AboveHead.getZ() - 0.5);
            player.getWorld().spawnEntity(StackE1.copy());
            StackE1.setPos(AboveHead.getX() - 0.5,AboveHead.getY(), AboveHead.getZ() + 0.5);
            player.getWorld().spawnEntity(StackE1.copy());
        });
        MulticoderTwitchConnection.SERVER.getPlayerManager().broadcast(Text.of(User + " Has ran the command: Spoonie"),false);
    }
}
