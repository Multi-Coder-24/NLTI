package org.multicoder.nlti.commands.player;

import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import org.multicoder.nlti.commands.CommandInstance;
import org.multicoder.nlti.twitch.MulticoderTwitchConnection;
import org.multicoder.nlti.util.InternalVariables;
import org.multicoder.nlti.util.PostCommandLogic;

import java.time.LocalDateTime;
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
            PostCommandLogic.Post(instance,Username);
        }
        else
        {
            MulticoderTwitchConnection.CHAT.sendMessage(Channel,"@" + Username + " This command is still on cooldown");
        }
    }
}
