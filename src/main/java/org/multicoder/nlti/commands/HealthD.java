package org.multicoder.nlti.commands;

import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.text.Text;
import org.multicoder.nlti.twitch.MulticoderTwitchConnection;

import java.util.Objects;

public class HealthD
{
    public static void Trigger(String Username)
    {
        MulticoderTwitchConnection.SERVER.getPlayerManager().getPlayerList().forEach(player ->
        {
            double MaxHealth = player.getAttributeBaseValue(EntityAttributes.GENERIC_MAX_HEALTH);
            if(MaxHealth != 2)
            {
                Objects.requireNonNull(player.getAttributes().getCustomInstance(EntityAttributes.GENERIC_MAX_HEALTH),"player.getAttributes().getCustomInstance(EntityAttributes.GENERIC_MAX_HEALTH) returned null").setBaseValue(MaxHealth - 2);
            }
        });
        MulticoderTwitchConnection.SERVER.getPlayerManager().broadcast(Text.of(Username + " Has ran the command: Health Minus"),false);
    }
}
