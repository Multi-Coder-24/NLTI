package org.multicoder.nlti.commands;

import net.minecraft.text.Text;
import org.multicoder.nlti.NLTI;
import org.multicoder.nlti.twitch.MulticoderTwitchConnection;

public class NoChests
{
    public static void Trigger(String User)
    {
        NLTI.Vars.UpdateChests(false);
        MulticoderTwitchConnection.SERVER.getPlayerManager().broadcast(Text.of(User + " Has ran the command: No Chests"),false);
    }
}
