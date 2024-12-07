package org.multicoder.nlti.commands.player;

import net.minecraft.text.Text;
import org.multicoder.nlti.NLTI;
import org.multicoder.nlti.twitch.MulticoderTwitchConnection;

public class Door
{
    public static void Trigger(String User, String Channel)
    {
        NLTI.Vars.UpdateDoors(true);
        MulticoderTwitchConnection.SERVER.getPlayerManager().broadcast(Text.of(User + " Has ran the command: Doors"),false);
    }
    public static void Trigger()
    {
        NLTI.Vars.UpdateChests(true);
    }
}
