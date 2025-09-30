package org.multicoder.nlti.twitch.commands.player;

import net.minecraft.entity.attribute.EntityAttributeInstance;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.server.MinecraftServer;
import org.multicoder.nlti.NLTI;
import org.multicoder.nlti.twitch.CommandBase;

import java.time.LocalDateTime;

public class Speed150 extends CommandBase
{
    public Speed150(){
        COOLDOWN = 0;
        TRIGGER = "!MC-Speed150";
        COOLDOWN_COUNTER = LocalDateTime.now().minusSeconds(300);
    }
    @Override
    public boolean Trigger(MinecraftServer server, String Username)
    {
        try {
            if (LocalDateTime.now().isAfter(COOLDOWN_COUNTER)) {
                server.getPlayerManager().getPlayerList().forEach(player -> {
                    EntityAttributeInstance EAI = player.getAttributeInstance(EntityAttributes.GENERIC_MOVEMENT_SPEED);
                    if(EAI != null) {
                        EAI.setBaseValue(1.5);
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