package org.multicoder.nlti.twitch.commands.mobs.hostile;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.mob.VindicatorEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.server.MinecraftServer;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.multicoder.nlti.NLTI;
import org.multicoder.nlti.twitch.CommandBase;

import java.time.LocalDateTime;

public class Vindicator extends CommandBase {

    public Vindicator(){
        COOLDOWN = 0;
        TRIGGER = "!MC-Vindicator";
        COOLDOWN_COUNTER = LocalDateTime.now().minusSeconds(300);
    }

    @Override
    public boolean Trigger(MinecraftServer server,String Username){
        try{
            if(LocalDateTime.now().isAfter(COOLDOWN_COUNTER)){
                server.getPlayerManager().getPlayerList().forEach(player -> {
                    World world = player.getEntityWorld();
                        BlockPos position = player.getBlockPos();
                        VindicatorEntity vindicator = new VindicatorEntity(EntityType.VINDICATOR,world);
                        vindicator.equipStack(EquipmentSlot.MAINHAND,new ItemStack(Items.IRON_AXE));
                        vindicator.setFrozenTicks(80);
                        vindicator.setPosition(position.getX(),position.getY(),position.getZ());
                        vindicator.setCustomName(Text.literal(Username));
                        vindicator.setCustomNameVisible(true);
                        world.spawnEntity(vindicator);
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
