package org.multicoder.nlti.twitch.commands.mobs.hostile;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.SlimeEntity;
import net.minecraft.server.MinecraftServer;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.multicoder.nlti.NLTI;

import java.time.LocalDateTime;

public class Slime
{
    public static final int COOLDOWN = 0;
    public static final String TRIGGER = "!MC-Slime";
    public static LocalDateTime COOLDOWN_COUNTER = LocalDateTime.now().minusSeconds(300);

    public static boolean Trigger(MinecraftServer server,String Username){
        try{
            if(LocalDateTime.now().isAfter(COOLDOWN_COUNTER)){
                server.getPlayerManager().getPlayerList().forEach(player -> {
                    World world = player.getEntityWorld();
                    BlockPos position = player.getBlockPos();
                    SlimeEntity slime = new SlimeEntity(EntityType.SLIME,world);
                    slime.setFrozenTicks(80);
                    slime.setPosition(position.getX(),position.getY(),position.getZ());
                    slime.setCustomName(Text.literal(Username));
                    slime.setCustomNameVisible(true);
                    world.spawnEntity(slime);
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
