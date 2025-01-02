package org.multicoder.nlti.commands.player;

import org.multicoder.nlti.NLTI;
import org.multicoder.nlti.commands.CommandInstance;
import org.multicoder.nlti.twitch.MulticoderTwitchConnection;
import org.multicoder.nlti.util.PostCommandLogic;

import java.time.LocalDateTime;

public class Sleepless
{
    public static void Trigger(String Username, String Channel, CommandInstance instance)
    {
        if(LocalDateTime.now().isAfter(instance.Cooldown)) {
            NLTI.Vars.UpdateSleepVar(false);
            PostCommandLogic.Post(instance,Username);
        }
        else {
            MulticoderTwitchConnection.CHAT.sendMessage(Channel,"@" + Username + " This command is still on cooldown");
        }
    }
}
