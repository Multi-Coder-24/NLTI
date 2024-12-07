package org.multicoder.nlti.commands.player;

import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.text.Text;
import org.multicoder.nlti.cooldowns.CooldownManager;
import org.multicoder.nlti.twitch.MulticoderTwitchConnection;

import java.time.LocalDateTime;
import java.util.Objects;

public class HealthP
{
    public static void Trigger(String Username,String Channel)
    {
        MulticoderTwitchConnection.SERVER.getPlayerManager().getPlayerList().forEach(player ->
        {
            double MaxHealth = player.getAttributeBaseValue(EntityAttributes.GENERIC_MAX_HEALTH);
            if(MaxHealth != 30)
            {
                Objects.requireNonNull(player.getAttributes().getCustomInstance(EntityAttributes.GENERIC_MAX_HEALTH),"player.getAttributes().getCustomInstance(EntityAttributes.GENERIC_MAX_HEALTH) returned null").setBaseValue(MaxHealth + 2);
            }
        });
        MulticoderTwitchConnection.SERVER.getPlayerManager().broadcast(Text.of(Username + " Has ran the command: Health Plus"),false);
    }
    public static void Trigger()
    {
        MulticoderTwitchConnection.SERVER.getPlayerManager().getPlayerList().forEach(player ->
        {
            double MaxHealth = player.getAttributeBaseValue(EntityAttributes.GENERIC_MAX_HEALTH);
            if(MaxHealth != 30)
            {
                Objects.requireNonNull(player.getAttributes().getCustomInstance(EntityAttributes.GENERIC_MAX_HEALTH),"player.getAttributes().getCustomInstance(EntityAttributes.GENERIC_MAX_HEALTH) returned null").setBaseValue(MaxHealth + 2);
            }
        });
    }
}
