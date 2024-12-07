package org.multicoder.nlti.commands.player;

import net.minecraft.text.Text;
import org.multicoder.nlti.NLTI;
import org.multicoder.nlti.twitch.MulticoderTwitchConnection;

public class NoDoor
{
    public static void Trigger(String User, String Channel)
    {
        NLTI.Vars.UpdateDoors(false);
        MulticoderTwitchConnection.SERVER.getPlayerManager().broadcast(Text.of(User + " Has ran the command: No Doors"),false);
    }
    public static void Trigger()
    {
        NLTI.Vars.UpdateChests(false);
    }
}
