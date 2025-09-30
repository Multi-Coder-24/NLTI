package org.multicoder.nlti.twitch.commands.world;

import net.minecraft.server.MinecraftServer;
import org.multicoder.nlti.NLTI;
import org.multicoder.nlti.twitch.CommandBase;

import java.time.LocalDateTime;

public class Rain extends CommandBase {
    public Rain() {
        COOLDOWN = 0;
        TRIGGER = "!MC-Rain";
        COOLDOWN_COUNTER = LocalDateTime.now().minusSeconds(300);
    }

    @Override
    public boolean Trigger(MinecraftServer server, String Username)
    {
        try {
            if (LocalDateTime.now().isAfter(COOLDOWN_COUNTER)) {
                server.getOverworld().setWeather(0,-1,true,false);
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