package org.multicoder.nlti.twitch.commands.mobs.hostile;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.mob.SkeletonEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.server.MinecraftServer;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.multicoder.nlti.NLTI;

import java.time.LocalDateTime;

public class Skeleton
{
    public static final int COOLDOWN = 0;
    public static final String TRIGGER = "!MC-Skeleton";
    public static LocalDateTime COOLDOWN_COUNTER = LocalDateTime.now().minusSeconds(300);

    public static boolean Trigger(MinecraftServer server,String Username){
        try{
            if(LocalDateTime.now().isAfter(COOLDOWN_COUNTER)){
                server.getPlayerManager().getPlayerList().forEach(player -> {
                    World world = player.getEntityWorld();
                    BlockPos position = player.getBlockPos();
                    SkeletonEntity skeleton = new SkeletonEntity(EntityType.SKELETON,world);
                    skeleton.equipStack(EquipmentSlot.MAINHAND,new ItemStack(Items.BOW));
                    skeleton.setFrozenTicks(80);
                    skeleton.setPosition(position.getX(),position.getY(),position.getZ());
                    skeleton.setCustomName(Text.literal(Username));
                    skeleton.setCustomNameVisible(true);
                    world.spawnEntity(skeleton);
                });
                return true;
            }
            else{
                return false;
            }
        }
        catch(Exception e){
            NLTI.LOG.error("[NLTI Twitch] Error When Attempting To Run Command: Cow, ",e);
            return false;
        }
    }
}
