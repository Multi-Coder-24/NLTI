package org.multicoder.nlti.commands.player;

import net.minecraft.entity.attribute.EntityAttributes;
import org.multicoder.nlti.commands.CommandInstance;
import org.multicoder.nlti.twitch.MulticoderTwitchConnection;
import org.multicoder.nlti.util.PostCommandLogic;

import java.time.LocalDateTime;
import java.util.Objects;

public class Speed200
{
    public static void Trigger(String Username,String Channel, CommandInstance instance)
    {
        if(LocalDateTime.now().isAfter(instance.Cooldown)) {
            MulticoderTwitchConnection.SERVER.getPlayerManager().getPlayerList().forEach(player -> Objects.requireNonNull(player.getAttributes().getCustomInstance(EntityAttributes.GENERIC_MOVEMENT_SPEED),"player.getAttributes().getCustomInstance(EntityAttributes.GENERIC_MOVEMENT_SPEED) returned null").setBaseValue(0.2f));
            PostCommandLogic.Post(instance,Username);
        }
        else {
            MulticoderTwitchConnection.CHAT.sendMessage(Channel,"@" + Username + " This command is still on cooldown");
        }
    }
}
