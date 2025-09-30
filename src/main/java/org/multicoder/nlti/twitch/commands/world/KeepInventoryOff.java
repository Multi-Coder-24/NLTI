package org.multicoder.nlti.twitch.commands.world;

import net.minecraft.server.MinecraftServer;
import net.minecraft.world.GameRules;
import org.multicoder.nlti.NLTI;
import org.multicoder.nlti.twitch.CommandBase;

import java.time.LocalDateTime;

public class KeepInventoryOff extends CommandBase
{
    public KeepInventoryOff() {
        COOLDOWN = 0;
        TRIGGER = "!MC-KeepInventoryOff";
        COOLDOWN_COUNTER = LocalDateTime.now().minusSeconds(300);
    }
    @Override
    public boolean Trigger(MinecraftServer server, String Username)
    {
        try {
            if (LocalDateTime.now().isAfter(COOLDOWN_COUNTER)) {
                server.getOverworld().getGameRules().get(GameRules.KEEP_INVENTORY).set(false,server);
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