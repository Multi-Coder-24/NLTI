package org.multicoder.nlti.twitch.commands.mobs.hostile;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.SpiderEntity;
import net.minecraft.server.MinecraftServer;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.multicoder.nlti.NLTI;

import java.time.LocalDateTime;

public class Spider
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
                    SpiderEntity spider = new SpiderEntity(EntityType.SPIDER,world);
                    spider.setFrozenTicks(80);
                    spider.setPosition(position.getX(),position.getY(),position.getZ());
                    spider.setCustomName(Text.literal(Username));
                    spider.setCustomNameVisible(true);
                    world.spawnEntity(spider);
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
