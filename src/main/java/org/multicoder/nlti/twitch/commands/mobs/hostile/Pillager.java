package org.multicoder.nlti.twitch.commands.mobs.hostile;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.mob.PillagerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.server.MinecraftServer;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.multicoder.nlti.NLTI;
import org.multicoder.nlti.twitch.CommandBase;

import java.time.LocalDateTime;

public class Pillager extends CommandBase {

    public Pillager(){
        COOLDOWN = 0;
        TRIGGER = "!MC-Creeper";
        COOLDOWN_COUNTER = LocalDateTime.now().minusSeconds(300);
    }

    @Override
    public boolean Trigger(MinecraftServer server,String Username){
        try{
            if(LocalDateTime.now().isAfter(COOLDOWN_COUNTER)){
                server.getPlayerManager().getPlayerList().forEach(player -> {
                    World world = player.getEntityWorld();
                    BlockPos position = player.getBlockPos();
                    PillagerEntity pillager = new PillagerEntity(EntityType.PILLAGER,world);
                    pillager.equipStack(EquipmentSlot.MAINHAND,new ItemStack(Items.CROSSBOW));
                    pillager.setFrozenTicks(80);
                    pillager.setPosition(position.getX(),position.getY(),position.getZ());
                    pillager.setCustomName(Text.literal(Username));
                    pillager.setCustomNameVisible(true);
                    world.spawnEntity(pillager);
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
