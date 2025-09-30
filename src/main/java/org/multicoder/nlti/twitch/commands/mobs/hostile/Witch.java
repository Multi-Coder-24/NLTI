package org.multicoder.nlti.twitch.commands.mobs.hostile;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.WitchEntity;
import net.minecraft.server.MinecraftServer;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.multicoder.nlti.NLTI;
import org.multicoder.nlti.twitch.CommandBase;

import java.time.LocalDateTime;

public class Witch extends CommandBase {

    public Witch(){
        COOLDOWN = 0;
        TRIGGER = "!MC-Witch";
        COOLDOWN_COUNTER = LocalDateTime.now().minusSeconds(300);
    }

    @Override
    public boolean Trigger(MinecraftServer server,String Username){
        try{
            if(LocalDateTime.now().isAfter(COOLDOWN_COUNTER)){
                server.getPlayerManager().getPlayerList().forEach(player -> {
                    World world = player.getEntityWorld();
                        BlockPos position = player.getBlockPos();
                        WitchEntity witch = new WitchEntity(EntityType.WITCH,world);
                        witch.setFrozenTicks(80);
                        witch.setPosition(position.getX(),position.getY(),position.getZ());
                        witch.setCustomName(Text.literal(Username));
                        witch.setCustomNameVisible(true);
                        world.spawnEntity(witch);
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
