package org.multicoder.nlti.commands.mob;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.SpiderEntity;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import org.multicoder.nlti.cooldowns.CooldownManager;
import org.multicoder.nlti.twitch.MulticoderTwitchConnection;

import java.time.LocalDateTime;

public class Spider
{
    public static void Trigger(String Username,String Channel)
    {
        LocalDateTime Now = LocalDateTime.now();
        if(!Now.isAfter(CooldownManager.SPIDER))
        {
            MulticoderTwitchConnection.CHAT.sendMessage(Channel,"@" + Username + " This command is still on cooldown");
        }
        else
        {
            int Append = 0;
            if(MulticoderTwitchConnection.Config.ChaosMode)
            {
                Append = MulticoderTwitchConnection.Config.Spider[1];
            }
            else{
                Append = MulticoderTwitchConnection.Config.Spider[0];
            }
            Now = Now.plusSeconds(Append);
            CooldownManager.SPIDER = Now;
            MulticoderTwitchConnection.SERVER.getPlayerManager().getPlayerList().forEach(player -> {
                BlockPos Position = player.getBlockPos();
                Position.add(2,2,2);
                SpiderEntity C = new SpiderEntity(EntityType.SPIDER,player.getServerWorld());
                C.setPosition(Position.toCenterPos());
                player.getServerWorld().spawnEntity(C);
            });
            MulticoderTwitchConnection.SERVER.getPlayerManager().broadcast(Text.of(Username + " Has ran the command: Spider"),false);
        }
    }
    public static void Trigger()
    {
        MulticoderTwitchConnection.SERVER.getPlayerManager().getPlayerList().forEach(player -> {
            BlockPos Position = player.getBlockPos();
            Position.add(2,2,2);
            SpiderEntity C = new SpiderEntity(EntityType.SPIDER,player.getServerWorld());
            C.setPosition(Position.toCenterPos());
            player.getServerWorld().spawnEntity(C);
        });
    }
}
