package org.multicoder.nlti.commands;

import net.minecraft.text.Text;
import org.multicoder.nlti.NLTI;
import org.multicoder.nlti.twitch.MulticoderTwitchConnection;

public class Chests
{
    public static void Trigger(String User)
    {
        NLTI.Vars.UpdateChests(true);
        MulticoderTwitchConnection.SERVER.getPlayerManager().broadcast(Text.of(User + " Has ran the command: Chests"),false);
    }
}
