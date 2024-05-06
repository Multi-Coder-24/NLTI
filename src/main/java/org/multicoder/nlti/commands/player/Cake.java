package org.multicoder.nlti.commands.player;

import net.minecraft.entity.ItemEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.math.BlockPos;
import org.multicoder.nlti.cooldowns.CooldownManager;
import org.multicoder.nlti.twitch.MulticoderTwitchConnection;

import java.time.LocalDateTime;

public class Cake
{
    public static void Trigger(String User, String Channel)
    {
        LocalDateTime Now = LocalDateTime.now();
        if(!Now.isAfter(CooldownManager.CAKE))
        {
            MulticoderTwitchConnection.CHAT.sendMessage(Channel,"@" + User + " This command is still on cooldown");
        }
        else {
            int Append = 0;
            if (MulticoderTwitchConnection.Config.ChaosMode) {
                Append = MulticoderTwitchConnection.Config.Cake[1];
            } else {
                Append = MulticoderTwitchConnection.Config.Cake[0];
            }
            Now = Now.plusSeconds(Append);
            CooldownManager.CAKE = Now;
            MulticoderTwitchConnection.SERVER.getPlayerManager().getPlayerList().forEach(player ->
            {
                BlockPos AboveHead = player.getBlockPos().up(3);
                ItemStack Cake = new ItemStack(Items.CAKE,1);
                Cake.setCustomName(Text.literal("Gift From Spoonie").formatted(Formatting.BOLD));
                ItemEntity StackE1 = new ItemEntity(player.getWorld(),AboveHead.getX(),AboveHead.getY(),AboveHead.getZ(),Cake);
                ItemEntity StackE2 = new ItemEntity(player.getWorld(),AboveHead.getX() + 0.5f,AboveHead.getY(),AboveHead.getZ() - 0.5f,Cake);
                ItemEntity StackE3 = new ItemEntity(player.getWorld(),AboveHead.getX() - 0.5f,AboveHead.getY(),AboveHead.getZ() + 0.5f,Cake);
                player.getWorld().spawnEntity(StackE1);
                player.getWorld().spawnEntity(StackE2);
                player.getWorld().spawnEntity(StackE3);
            });
            MulticoderTwitchConnection.SERVER.getPlayerManager().broadcast(Text.of(User + " Has ran the command: Spoonie"),false);
        }
    }
    public static void Trigger()
    {
        MulticoderTwitchConnection.SERVER.getPlayerManager().getPlayerList().forEach(player ->
        {
            BlockPos AboveHead = player.getBlockPos().up(3);
            ItemStack Cake = new ItemStack(Items.CAKE,1);
            Cake.setCustomName(Text.literal("Gift From Spoonie").formatted(Formatting.BOLD));
            ItemEntity StackE1 = new ItemEntity(player.getWorld(),AboveHead.getX(),AboveHead.getY(),AboveHead.getZ(),Cake);
            ItemEntity StackE2 = new ItemEntity(player.getWorld(),AboveHead.getX() + 0.5f,AboveHead.getY(),AboveHead.getZ() - 0.5f,Cake);
            ItemEntity StackE3 = new ItemEntity(player.getWorld(),AboveHead.getX() - 0.5f,AboveHead.getY(),AboveHead.getZ() + 0.5f,Cake);
            player.getWorld().spawnEntity(StackE1);
            player.getWorld().spawnEntity(StackE2);
            player.getWorld().spawnEntity(StackE3);
        });
    }
}
