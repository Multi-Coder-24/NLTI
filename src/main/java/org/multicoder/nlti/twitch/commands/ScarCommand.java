package org.multicoder.nlti.twitch.commands;

import net.minecraft.block.Oxidizable;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.RavagerEntity;
import net.minecraft.entity.mob.SkeletonEntity;
import net.minecraft.entity.passive.CopperGolemEntity;
import net.minecraft.entity.passive.CopperGolemState;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.server.MinecraftServer;
import net.minecraft.text.Text;

import java.time.LocalDateTime;

public class ScarCommand {
    public static LocalDateTime COOLDOWN = LocalDateTime.now().minusHours(2);
    public static int DELAY = 10;
    public static void PreTrigger(String Username, MinecraftServer server) {
        if(COOLDOWN.isBefore(LocalDateTime.now())){
            Trigger(Username,server);
        }
    }

    public static void PostTrigger(String Username,MinecraftServer server) {
        server.getPlayerManager().broadcast(Text.translatable("text.nlti.command",Username,"Scar"),false);
        COOLDOWN = LocalDateTime.now().plusSeconds(DELAY);
    }

    public static void Trigger(String Username,MinecraftServer server) {
        server.getPlayerManager().getPlayerList().forEach(player -> {
            ItemStack diamond = new ItemStack(Items.DEEPSLATE_DIAMOND_ORE,player.getEntityWorld().random.nextBetween(3,9));
            ItemStack moss = new ItemStack(Items.MOSS_BLOCK,player.getEntityWorld().random.nextBetween(16,32));
            CopperGolemEntity golem = new CopperGolemEntity(EntityType.COPPER_GOLEM,player.getEntityWorld());
            golem.setOxidationLevel(Oxidizable.OxidationLevel.OXIDIZED);
            golem.setState(CopperGolemState.IDLE);
            SkeletonEntity skele = new SkeletonEntity(EntityType.SKELETON,player.getEntityWorld());
            diamond.set(DataComponentTypes.CUSTOM_NAME,Text.translatable("text.nlti.scar_diamond"));
            golem.setCustomName(Text.translatable("text.nlti.scar_golem"));
            skele.setCustomName(Text.translatable("text.nlti.scar_skele"));
            golem.setPos(player.getBlockPos().add(1,2,1).getX(),player.getBlockPos().add(1,2,1).getY(),player.getBlockPos().add(1,2,1).getZ());
            skele.setPos(player.getBlockPos().add(-1,2,-1).getX(),player.getBlockPos().add(-1,2,-1).getY(),player.getBlockPos().add(-1,2,-1).getZ());
            player.giveOrDropStack(diamond);
            player.giveOrDropStack(moss);
            player.getEntityWorld().spawnEntity(golem);
            player.getEntityWorld().spawnEntity(skele);
        });
        PostTrigger(Username,server);
    }
}
