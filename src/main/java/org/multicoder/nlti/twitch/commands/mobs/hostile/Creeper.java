package org.multicoder.nlti.twitch.commands.mobs.hostile;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.CreeperEntity;
import net.minecraft.server.MinecraftServer;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.multicoder.nlti.NLTI;
import org.multicoder.nlti.twitch.CommandBase;

import java.time.LocalDateTime;

public class Creeper extends CommandBase {

    public Creeper(){
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
                    CreeperEntity creeper = new CreeperEntity(EntityType.CREEPER,world);
                    creeper.setFrozenTicks(80);
                    creeper.setPosition(position.getX(),position.getY(),position.getZ());
                    creeper.setCustomName(Text.literal(Username));
                    creeper.setCustomNameVisible(true);
                    world.spawnEntity(creeper);
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
