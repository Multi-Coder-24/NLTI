package org.multicoder.nlti.twitch.commands.player;

import net.minecraft.entity.attribute.EntityAttributeInstance;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.server.MinecraftServer;
import org.multicoder.nlti.NLTI;
import org.multicoder.nlti.twitch.CommandBase;

import java.time.LocalDateTime;

public class HealthPlus extends CommandBase
{
    public HealthPlus(){
        COOLDOWN = 0;
        TRIGGER = "!MC-HealthPlus";
        COOLDOWN_COUNTER = LocalDateTime.now().minusSeconds(300);
    }
    @Override
    public boolean Trigger(MinecraftServer server, String Username)
    {
        try {
            if (LocalDateTime.now().isAfter(COOLDOWN_COUNTER)) {
                server.getPlayerManager().getPlayerList().forEach(player -> {
                    EntityAttributeInstance EAI = player.getAttributeInstance(EntityAttributes.GENERIC_MAX_HEALTH);
                    if(EAI != null && EAI.getValue() < 40.0f){
                        EAI.setBaseValue(EAI.getValue() + 2.0f);
                    }
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