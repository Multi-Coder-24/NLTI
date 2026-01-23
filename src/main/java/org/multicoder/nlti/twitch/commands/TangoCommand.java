package org.multicoder.nlti.twitch.commands;

import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.WritableBookContentComponent;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.RavagerEntity;
import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.server.MinecraftServer;
import net.minecraft.text.RawFilteredPair;
import net.minecraft.text.Text;
import org.multicoder.nlti.util.MumboLootPool;

import java.time.LocalDateTime;

public class TangoCommand {
    public static LocalDateTime COOLDOWN = LocalDateTime.now().minusHours(2);
    public static int DELAY = 10;
    public static void PreTrigger(String Username, MinecraftServer server) {
        if(COOLDOWN.isBefore(LocalDateTime.now())){
            Trigger(Username,server);
        }
    }

    public static void PostTrigger(String Username,MinecraftServer server) {
        server.getPlayerManager().broadcast(Text.translatable("text.nlti.command",Username,"Tango"),false);
        COOLDOWN = LocalDateTime.now().plusSeconds(DELAY);
    }

    public static void Trigger(String Username,MinecraftServer server) {
        server.getPlayerManager().getPlayerList().forEach(player -> {
           ItemStack porkchops = new ItemStack(Items.COOKED_PORKCHOP,player.getEntityWorld().random.nextBetween(8,16));
           porkchops.set(DataComponentTypes.CUSTOM_NAME,Text.translatable("text.nlti.tango_porkchops"));
           ItemStack book = new ItemStack(Items.WRITABLE_BOOK);
           book.set(DataComponentTypes.CUSTOM_NAME,Text.translatable("text.nlti.tango_book"));
           ItemStack totem = new ItemStack(Items.TOTEM_OF_UNDYING);
           totem.set(DataComponentTypes.CUSTOM_NAME,Text.translatable("text.nlti.tango_totem"));
           RavagerEntity ravager = new RavagerEntity(EntityType.RAVAGER,player.getEntityWorld());
           ravager.setCustomName(Text.translatable("text.nlti.tango_ravager"));
           ravager.setPos(player.getBlockPos().add(1,2,1).getX(),player.getBlockPos().add(1,2,1).getY(),player.getBlockPos().add(1,2,1).getZ());
           player.giveOrDropStack(porkchops);
           player.giveOrDropStack(totem);
           player.giveOrDropStack(book);
           player.getEntityWorld().spawnEntity(ravager);
        });
        PostTrigger(Username,server);
    }
}
