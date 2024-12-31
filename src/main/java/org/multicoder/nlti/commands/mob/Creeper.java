package org.multicoder.nlti.commands.mob;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.mob.CreeperEntity;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.math.BlockPos;
import org.multicoder.nlti.commands.CommandInstance;
import org.multicoder.nlti.twitch.MulticoderTwitchConnection;

import java.time.LocalDateTime;
import java.util.Objects;

public class Creeper
{
    public static void Trigger(String Username, String Channel, CommandInstance instance) {
        if(LocalDateTime.now().isAfter(instance.Cooldown)) {
            MulticoderTwitchConnection.SERVER.getPlayerManager().getPlayerList().forEach(player -> {
                BlockPos Position = player.getBlockPos();
                Position.add(2,2,2);
                CreeperEntity C = new CreeperEntity(EntityType.CREEPER,player.getServerWorld());
                C.initialize(player.getServerWorld(),player.getServerWorld().getLocalDifficulty(Position), SpawnReason.COMMAND,null,null);
                C.setCustomName(Text.literal(Username).formatted(Formatting.BOLD));
                C.setPosition(Position.toCenterPos());
                player.getServerWorld().spawnEntity(C);
            });
            MulticoderTwitchConnection.SERVER.getPlayerManager().broadcast(Text.of(Username + " Has ran the command: Creeper"),false);
            if(Objects.equals(Username, "NLTI")){return;}
            if(MulticoderTwitchConnection.Config.ChaosMode) {
                instance.Cooldown = LocalDateTime.now().plusSeconds(instance.Chaos);
            }
            else {
                instance.Cooldown = LocalDateTime.now().plusSeconds(instance.Normal);
            }
        }
        else {
            MulticoderTwitchConnection.CHAT.sendMessage(Channel,"@" + Username + " This command is still on cooldown");
        }
    }
}
