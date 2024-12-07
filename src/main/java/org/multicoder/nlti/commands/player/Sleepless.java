package org.multicoder.nlti.commands.player;

import net.minecraft.text.Text;
import org.multicoder.nlti.NLTI;
import org.multicoder.nlti.cooldowns.CooldownManager;
import org.multicoder.nlti.twitch.MulticoderTwitchConnection;

import java.time.LocalDateTime;

public class Sleepless
{
    public static void Trigger(String User, String Channel)
    {
        NLTI.Vars.UpdateSleepVar(false);
        MulticoderTwitchConnection.SERVER.getPlayerManager().broadcast(Text.of(User + " Has ran the command: Sleepless"),false);
    }
    public static void Trigger()
    {
        NLTI.Vars.UpdateSleepVar(false);
    }
}
