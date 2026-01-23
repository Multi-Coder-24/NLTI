package org.multicoder.nlti.twitch.commands;

import net.minecraft.component.DataComponentTypes;
import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.server.MinecraftServer;
import net.minecraft.text.Text;
import org.multicoder.nlti.util.MumboLootPool;
import java.time.LocalDateTime;

public class MumboCommand
{
    public static LocalDateTime COOLDOWN = LocalDateTime.now().minusHours(2);
    public static int DELAY = 10;
    public static void PreTrigger(String Username, MinecraftServer server) {
        if(COOLDOWN.isBefore(LocalDateTime.now())){
            Trigger(Username,server);
        }
    }

    public static void PostTrigger(String Username,MinecraftServer server) {
        server.getPlayerManager().broadcast((Text.translatable("text.nlti.command",Username,"Mumbo")),false);
        COOLDOWN = LocalDateTime.now().plusSeconds(DELAY);
    }

    public static void Trigger(String Username,MinecraftServer server) {
        server.getPlayerManager().getPlayerList().forEach(player -> {
            player.giveOrDropStack(MumboLootPool.FetchLoot(player.getEntityWorld().random));
            ZombieEntity zombieEntity = new ZombieEntity(player.getEntityWorld());
            zombieEntity.setCustomName(Text.translatable("text.nlti.mumbo_zombie"));
            zombieEntity.setPos(player.getBlockPos().add(2,1,2).getX(),player.getBlockPos().add(3,3,3).getY(),player.getBlockPos().add(3,3,3).getZ());
            player.getEntityWorld().spawnEntity(zombieEntity);
            ItemStack paper = new ItemStack(Items.PAPER);
            paper.set(DataComponentTypes.CUSTOM_NAME,Text.translatable("text.nlti.mumbo_paper"));
            player.giveOrDropStack(paper);
        });
        PostTrigger(Username,server);
    }
}
