package org.multicoder.nlti.util;

import net.minecraft.text.Text;
import org.multicoder.nlti.commands.CommandInstance;
import org.multicoder.nlti.twitch.MulticoderTwitchConnection;

import java.time.LocalDateTime;
import java.util.Objects;

public class PostCommandLogic
{
    public static void Post(CommandInstance instance, String Username)
    {
        MulticoderTwitchConnection.SERVER.getPlayerManager().broadcast(Text.of(Username + " Has ran the command: " + instance.CommandID),false);
        if(Objects.equals(Username, "NLTI")){return;}
        if(MulticoderTwitchConnection.Config.ChaosMode) {
            instance.Cooldown = LocalDateTime.now().plusSeconds(instance.Chaos);
        }
        else {
            instance.Cooldown = LocalDateTime.now().plusSeconds(instance.Normal);
        }
    }
}
