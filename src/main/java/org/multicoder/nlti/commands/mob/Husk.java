package org.multicoder.nlti.commands.mob;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.HuskEntity;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import org.multicoder.nlti.cooldowns.CooldownManager;
import org.multicoder.nlti.twitch.MulticoderTwitchConnection;

import java.time.LocalDateTime;

public class Husk
{
    public static void Trigger(String Username,String Channel)
    {
        LocalDateTime Now = LocalDateTime.now();
        if(!Now.isAfter(CooldownManager.HUSK))
        {
            MulticoderTwitchConnection.CHAT.sendMessage(Channel,"@" + Username + " This command is still on cooldown");
        }
        else
        {
            int Append = 0;
            if(MulticoderTwitchConnection.Config.ChaosMode)
            {
                Append = MulticoderTwitchConnection.Config.Husk[1];
            }
            else{
                Append = MulticoderTwitchConnection.Config.Husk[0];
            }
            Now = Now.plusSeconds(Append);
            CooldownManager.HUSK = Now;
            MulticoderTwitchConnection.SERVER.getPlayerManager().getPlayerList().forEach(player -> {
                BlockPos Position = player.getBlockPos();
                Position.add(2,2,2);
                HuskEntity C = new HuskEntity(EntityType.HUSK,player.getServerWorld());
                C.setPosition(Position.toCenterPos());
                player.getServerWorld().spawnEntity(C);
            });
            MulticoderTwitchConnection.SERVER.getPlayerManager().broadcast(Text.of(Username + " Has ran the command: Husk"),false);
        }
    }
    public static void Trigger()
    {
        MulticoderTwitchConnection.SERVER.getPlayerManager().getPlayerList().forEach(player -> {
            BlockPos Position = player.getBlockPos();
            Position.add(2,2,2);
            HuskEntity C = new HuskEntity(EntityType.HUSK,player.getServerWorld());
            C.setPosition(Position.toCenterPos());
            player.getServerWorld().spawnEntity(C);
        });
    }
}
