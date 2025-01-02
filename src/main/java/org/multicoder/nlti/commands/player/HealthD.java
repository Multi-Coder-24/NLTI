package org.multicoder.nlti.commands.player;

import net.minecraft.entity.attribute.EntityAttributes;
import org.multicoder.nlti.commands.CommandInstance;
import org.multicoder.nlti.twitch.MulticoderTwitchConnection;
import org.multicoder.nlti.util.PostCommandLogic;

import java.time.LocalDateTime;
import java.util.Objects;

public class HealthD
{
    public static void Trigger(String Username,String Channel, CommandInstance instance)
    {
        if(LocalDateTime.now().isAfter(instance.Cooldown)) {
            MulticoderTwitchConnection.SERVER.getPlayerManager().getPlayerList().forEach(player ->
            {
                double MaxHealth = player.getAttributeBaseValue(EntityAttributes.GENERIC_MAX_HEALTH);
                if(MaxHealth != 2)
                {
                    Objects.requireNonNull(player.getAttributes().getCustomInstance(EntityAttributes.GENERIC_MAX_HEALTH),"player.getAttributes().getCustomInstance(EntityAttributes.GENERIC_MAX_HEALTH) returned null").setBaseValue(MaxHealth - 2);
                }
            });
            PostCommandLogic.Post(instance,Username);
        }
        else {
            MulticoderTwitchConnection.CHAT.sendMessage(Channel,"@" + Username + " This command is still on cooldown");
        }
    }
}
