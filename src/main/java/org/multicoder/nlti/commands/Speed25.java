package org.multicoder.nlti.commands;

import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.text.Text;
import org.multicoder.nlti.twitch.MulticoderTwitchConnection;

import java.util.Objects;

public class Speed25
{
    public static void Trigger(String Username)
    {
        MulticoderTwitchConnection.SERVER.getPlayerManager().getPlayerList().forEach(player -> Objects.requireNonNull(player.getAttributes().getCustomInstance(EntityAttributes.GENERIC_MOVEMENT_SPEED),"player.getAttributes().getCustomInstance(EntityAttributes.GENERIC_MOVEMENT_SPEED) returned null").setBaseValue(0.025f));
        MulticoderTwitchConnection.SERVER.getPlayerManager().broadcast(Text.of(Username + " Has ran the command: Speed 25"),false);
    }
}
