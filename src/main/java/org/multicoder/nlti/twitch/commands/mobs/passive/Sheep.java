package org.multicoder.nlti.twitch.commands.mobs.passive;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.server.MinecraftServer;
import net.minecraft.text.Text;
import net.minecraft.util.DyeColor;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.multicoder.nlti.NLTI;
import org.multicoder.nlti.twitch.CommandBase;

import java.time.LocalDateTime;

public class Sheep extends CommandBase {

    public Sheep(){
        COOLDOWN = 0;
        TRIGGER = "!MC-Sheep";
        COOLDOWN_COUNTER = LocalDateTime.now().minusSeconds(300);
    }


    @Override
    public boolean Trigger(MinecraftServer server,String Username)
    {
        try{
            if(LocalDateTime.now().isAfter(COOLDOWN_COUNTER)){
                server.getPlayerManager().getPlayerList().forEach(player ->
                {
                    World world = player.getEntityWorld();
                    if(world == server.getOverworld())
                    {
                        BlockPos position = player.getBlockPos();
                        SheepEntity sheepEntity = new SheepEntity(EntityType.SHEEP,world);
                        sheepEntity.setPos(position.getX(),position.getY(),position.getZ());
                        sheepEntity.setCustomName(Text.literal(Username));
                        sheepEntity.setCustomNameVisible(true);
                        int Col = world.getRandom().nextBetween(0,DyeColor.values().length - 1);
                        DyeColor dyeColor = DyeColor.values()[Col];
                        sheepEntity.setColor(dyeColor);
                        world.spawnEntity(sheepEntity);
                    }
                });
                COOLDOWN_COUNTER = LocalDateTime.now().plusSeconds(COOLDOWN);
                return true;
            }
            else {
                return false;
            }
        }
        catch (Exception ex){
            NLTI.LOG.error("[NLTI Twitch] Error When Attempting To Run Command: Sheep, ", ex);
            return false;
        }
    }
}
