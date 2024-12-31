package org.multicoder.nlti.commands.player;

import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.text.Text;
import org.multicoder.nlti.commands.CommandInstance;
import org.multicoder.nlti.twitch.MulticoderTwitchConnection;
import org.multicoder.nlti.util.InternalVariables;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Random;

public class JumpScare
{
    public static void Trigger(String Username,String Channel, CommandInstance instance)
    {
        if(LocalDateTime.now().isAfter(instance.Cooldown))
        {
            Random rng = new Random();
            MulticoderTwitchConnection.SERVER.getPlayerManager().getPlayerList().forEach(player ->
            {
                int Index = rng.nextInt(0,InternalVariables.SOUNDS.size());
                SoundEvent Queued = InternalVariables.SOUNDS.get(Index);
                player.playSound(Queued, SoundCategory.PLAYERS,1f,1f);
            });
            MulticoderTwitchConnection.SERVER.getPlayerManager().broadcast(Text.of(Username + " Has ran the command: Jumpscare"),false);
            if(Objects.equals(Username, "NLTI")){return;}
            if(MulticoderTwitchConnection.Config.ChaosMode) {
                instance.Cooldown = LocalDateTime.now().plusSeconds(instance.Chaos);
            }
            else {
                instance.Cooldown = LocalDateTime.now().plusSeconds(instance.Normal);
            }
        }
        else
        {
            MulticoderTwitchConnection.CHAT.sendMessage(Channel,"@" + Username + " This command is still on cooldown");
        }
    }
}
