package org.multicoder.nlti.twitch.commands.mobs.passive;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.OcelotEntity;
import net.minecraft.server.MinecraftServer;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.multicoder.nlti.NLTI;
import org.multicoder.nlti.twitch.CommandBase;

import java.time.LocalDateTime;

public class Ocelot extends CommandBase {

    public Ocelot(){
        COOLDOWN = 0;
        TRIGGER = "!MC-Ocelot";
        COOLDOWN_COUNTER = LocalDateTime.now().minusSeconds(300);
    }


    @Override
    public boolean Trigger(MinecraftServer server,String Username){
        try{
            if(LocalDateTime.now().isAfter(COOLDOWN_COUNTER)){
                server.getPlayerManager().getPlayerList().forEach(player -> {
                    World world = player.getEntityWorld();
                    if(world == server.getOverworld()){
                        BlockPos position = player.getBlockPos();
                        OcelotEntity ocelot = new OcelotEntity(EntityType.OCELOT,world);
                        ocelot.setPosition(position.getX(),position.getY(),position.getZ());
                        ocelot.setCustomName(Text.literal(Username));
                        ocelot.setCustomNameVisible(true);
                        world.spawnEntity(ocelot);
                    }
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
