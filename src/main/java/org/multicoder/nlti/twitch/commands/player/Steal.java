package org.multicoder.nlti.twitch.commands.player;

import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import org.multicoder.nlti.NLTI;
import org.multicoder.nlti.twitch.CommandBase;

import java.time.LocalDateTime;

public class Steal extends CommandBase
{
    public Steal(){
        COOLDOWN = 0;
        TRIGGER = "!MC-Steal";
        COOLDOWN_COUNTER = LocalDateTime.now().minusSeconds(300);
    }
    @Override
    public  boolean Trigger(MinecraftServer server, String Username)
    {
        try {
            if (LocalDateTime.now().isAfter(COOLDOWN_COUNTER)) {
                server.getPlayerManager().getPlayerList().forEach(player -> {
                    World world = player.getEntityWorld();
                    Random random = world.getRandom();
                    player.getInventory().removeStack(random.nextBetween(0,player.getInventory().main.size() -1));
                });
                return true;
            }
            else {
                return false;
            }
        } catch (Exception e) {
            NLTI.LOG.error("[NLTI Twitch] Error When Attempting To Run Command: Steal, ", e);
            return false;
        }
    }
}