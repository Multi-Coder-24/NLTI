package org.multicoder.nlti.twitch.commands.mobs.hostile;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.EquipmentTable;
import net.minecraft.entity.mob.StrayEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKey;
import net.minecraft.server.MinecraftServer;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.multicoder.nlti.NLTI;

import java.time.LocalDateTime;

public class Stray
{
    public static final int COOLDOWN = 0;
    public static final String TRIGGER = "!MC-Spider";
    public static LocalDateTime COOLDOWN_COUNTER = LocalDateTime.now().minusSeconds(300);

    public static boolean Trigger(MinecraftServer server,String Username){
        try{
            if(LocalDateTime.now().isAfter(COOLDOWN_COUNTER)){
                server.getPlayerManager().getPlayerList().forEach(player -> {
                    World world = player.getEntityWorld();
                    BlockPos position = player.getBlockPos();
                    StrayEntity stray = new StrayEntity(EntityType.STRAY,world);
                    stray.setFrozenTicks(80);
                    stray.equipStack(EquipmentSlot.MAINHAND,new ItemStack(Items.BOW));
                    stray.setPosition(position.getX(),position.getY(),position.getZ());
                    stray.setCustomName(Text.literal(Username));
                    stray.setCustomNameVisible(true);
                    world.spawnEntity(stray);
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
