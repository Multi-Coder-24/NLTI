package org.multicoder.nlti.twitch.commands.mobs.passive;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.RabbitEntity;
import net.minecraft.server.MinecraftServer;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.multicoder.nlti.NLTI;

import java.time.LocalDateTime;

public class Rabbit
{
    public static final int COOLDOWN = 0;
    public static final String TRIGGER = "!MC-Rabbit";
    public static LocalDateTime COOLDOWN_COUNTER = LocalDateTime.now().minusSeconds(300);

    public static boolean Trigger(MinecraftServer server,String Username){
        try{
            if(LocalDateTime.now().isAfter(COOLDOWN_COUNTER)){
                server.getPlayerManager().getPlayerList().forEach(player -> {
                    World world = player.getEntityWorld();
                    if(world == server.getOverworld()){
                        BlockPos position = player.getBlockPos();
                        RabbitEntity rabbit = new RabbitEntity(EntityType.RABBIT,world);
                        rabbit.setPosition(position.getX(),position.getY(),position.getZ());
                        rabbit.setCustomName(Text.literal(Username));
                        rabbit.setCustomNameVisible(true);
                        world.spawnEntity(rabbit);
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
