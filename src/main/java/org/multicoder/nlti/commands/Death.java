package org.multicoder.nlti.commands;

import net.minecraft.entity.LivingEntity;
import net.minecraft.text.Text;
import org.multicoder.nlti.twitch.MulticoderTwitchConnection;

public class Death
{
    public static void Trigger(String User)
    {
        MulticoderTwitchConnection.SERVER.getPlayerManager().getPlayerList().forEach(LivingEntity::kill);
        MulticoderTwitchConnection.SERVER.getPlayerManager().broadcast(Text.of(User + " Has ran the command: Death"),false);
    }
}
