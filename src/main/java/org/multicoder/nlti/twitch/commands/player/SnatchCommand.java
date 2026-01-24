package org.multicoder.nlti.twitch.commands.player;

import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.server.MinecraftServer;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.gen.feature.RandomFeatureConfig;

import java.time.LocalDateTime;

public class SnatchCommand {
    public static LocalDateTime COOLDOWN = LocalDateTime.now().minusHours(2);
    public static int DELAY = 10;

    public static void PreTrigger(String Username, MinecraftServer server) {
        if(COOLDOWN.isBefore(LocalDateTime.now())){
            Trigger(Username,server);
        }
    }

    public static void PostTrigger(String Username,MinecraftServer server) {
        server.getPlayerManager().broadcast((Text.translatable("text.nlti.command",Username,"Snatch")),false);
        COOLDOWN = LocalDateTime.now().plusSeconds(DELAY);
    }

    public static void Trigger(String Username,MinecraftServer server) {
        server.getPlayerManager().getPlayerList().forEach(player -> {
            Random rand = player.getEntityWorld().random;
            player.getInventory().setStack(rand.nextBetweenExclusive(0,player.getInventory().size()),new ItemStack(Items.AIR));
        });
        PostTrigger(Username,server);
    }
}
