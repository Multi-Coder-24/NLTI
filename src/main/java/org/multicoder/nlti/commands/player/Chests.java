package org.multicoder.nlti.commands.player;

import net.minecraft.text.Text;
import org.multicoder.nlti.NLTI;
import org.multicoder.nlti.commands.CommandInstance;
import org.multicoder.nlti.twitch.MulticoderTwitchConnection;

import java.time.LocalDateTime;
import java.util.Objects;

public class Chests
{
    public static void Trigger(String Username, String Channel, CommandInstance instance)
    {
        if(LocalDateTime.now().isAfter(instance.Cooldown)) {
            NLTI.Vars.UpdateChests(true);
            MulticoderTwitchConnection.SERVER.getPlayerManager().broadcast(Text.of(Username + " Has ran the command: Chests"),false);
            if(Objects.equals(Username, "NLTI")){return;}
            if(MulticoderTwitchConnection.Config.ChaosMode) {
                instance.Cooldown = LocalDateTime.now().plusSeconds(instance.Chaos);
            }
            else {
                instance.Cooldown = LocalDateTime.now().plusSeconds(instance.Normal);
            }
        }
        else {
            MulticoderTwitchConnection.CHAT.sendMessage(Channel,"@" + Username + " This command is still on cooldown");
        }
    }
}
