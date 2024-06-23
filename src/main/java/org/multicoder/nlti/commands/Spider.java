package org.multicoder.nlti.commands;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.mob.SpiderEntity;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.math.BlockPos;
import org.multicoder.nlti.twitch.MulticoderTwitchConnection;

public class Spider
{
    public static void Trigger(String Username)
    {
        MulticoderTwitchConnection.SERVER.getPlayerManager().getPlayerList().forEach(player -> {
            BlockPos Position = player.getBlockPos();
            Position.add(2,2,2);
            SpiderEntity C = new SpiderEntity(EntityType.SPIDER,player.getServerWorld());
            C.initialize(player.getServerWorld(),player.getServerWorld().getLocalDifficulty(Position), SpawnReason.COMMAND,null,null);
            C.setCustomName(Text.literal(Username).formatted(Formatting.BOLD));
            C.setPosition(Position.toCenterPos());
            player.getServerWorld().spawnEntity(C);
        });
        MulticoderTwitchConnection.SERVER.getPlayerManager().broadcast(Text.of(Username + " Has ran the command: Spider"),false);
    }
}
