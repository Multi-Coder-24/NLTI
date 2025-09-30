package org.multicoder.nlti.twitch.commands.player;

import net.minecraft.server.MinecraftServer;
import org.multicoder.nlti.NLTI;
import org.multicoder.nlti.twitch.CommandBase;

import java.time.LocalDateTime;

public class Hungry extends CommandBase
{
    public Hungry(){
        COOLDOWN = 0;
        TRIGGER = "!MC-Hungry";
        COOLDOWN_COUNTER = LocalDateTime.now().minusSeconds(300);
    }
    @Override
    public boolean Trigger(MinecraftServer server, String Username)
    {
        try {
            if (LocalDateTime.now().isAfter(COOLDOWN_COUNTER)) {
                server.getPlayerManager().getPlayerList().forEach(player -> {
                    player.getHungerManager().setFoodLevel(2);
                    player.getHungerManager().setSaturationLevel(0.0f);
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