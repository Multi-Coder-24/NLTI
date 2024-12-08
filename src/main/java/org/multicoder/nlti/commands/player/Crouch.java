package org.multicoder.nlti.commands.player;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.Text;
import org.multicoder.nlti.twitch.MulticoderTwitchConnection;

public class Crouch
{
    public static void Trigger(String Username,String Channel)
    {
        MulticoderTwitchConnection.SERVER.getPlayerManager().getPlayerList().forEach(serverPlayerEntity -> serverPlayerEntity.setSneaking(true));
        MulticoderTwitchConnection.SERVER.getPlayerManager().broadcast(Text.of(Username + " Has ran the command: Sneak"),false);
    }
}
