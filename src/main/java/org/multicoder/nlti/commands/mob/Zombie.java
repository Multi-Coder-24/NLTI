package org.multicoder.nlti.commands.mob;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.math.BlockPos;
import org.multicoder.nlti.cooldowns.CooldownManager;
import org.multicoder.nlti.twitch.MulticoderTwitchConnection;

import java.time.LocalDateTime;

public class Zombie
{
    public static void Trigger(String Username,String Channel)
    {
        LocalDateTime Now = LocalDateTime.now();
        if(!Now.isAfter(CooldownManager.ZOMBIE))
        {
            MulticoderTwitchConnection.CHAT.sendMessage(Channel,"@" + Username + " This command is still on cooldown");
        }
        else
        {
            int Append;
            if(MulticoderTwitchConnection.Config.ChaosMode)
            {
                Append = MulticoderTwitchConnection.Config.Zombie[1];
            }
            else{
                Append = MulticoderTwitchConnection.Config.Zombie[0];
            }
            Now = Now.plusSeconds(Append);
            CooldownManager.ZOMBIE = Now;
            MulticoderTwitchConnection.SERVER.getPlayerManager().getPlayerList().forEach(player -> {
                BlockPos Position = player.getBlockPos();
                Position.add(2,2,2);
                ZombieEntity C = new ZombieEntity(EntityType.ZOMBIE,player.getServerWorld());
                C.initialize(player.getServerWorld(),player.getServerWorld().getLocalDifficulty(Position), SpawnReason.COMMAND,null,null);
                C.setCustomName(Text.literal(Username).formatted(Formatting.BOLD));
                C.setPosition(Position.toCenterPos());
                player.getServerWorld().spawnEntity(C);
            });
            MulticoderTwitchConnection.SERVER.getPlayerManager().broadcast(Text.of(Username + " Has ran the command: Zombie"),false);
        }
    }
    public static void Trigger()
    {
        MulticoderTwitchConnection.SERVER.getPlayerManager().getPlayerList().forEach(player -> {
            BlockPos Position = player.getBlockPos();
            Position.add(2,2,2);
            ZombieEntity C = new ZombieEntity(EntityType.ZOMBIE,player.getServerWorld());
            C.initialize(player.getServerWorld(),player.getServerWorld().getLocalDifficulty(Position), SpawnReason.COMMAND,null,null);
            C.setPosition(Position.toCenterPos());
            player.getServerWorld().spawnEntity(C);
        });
    }
}
