package org.multicoder.nlti.commands.potion;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import org.multicoder.nlti.commands.CommandInstance;
import org.multicoder.nlti.twitch.MulticoderTwitchConnection;
import org.multicoder.nlti.util.PostCommandLogic;

import java.time.LocalDateTime;

public class Poison
{
    public static void Trigger(String Username,String Channel, CommandInstance instance)
    {
        if(LocalDateTime.now().isAfter(instance.Cooldown)) {
            MulticoderTwitchConnection.SERVER.getPlayerManager().getPlayerList().forEach(player -> player.addStatusEffect(new StatusEffectInstance(StatusEffects.POISON,400)));
            PostCommandLogic.Post(instance,Username);
        }
        else {
            MulticoderTwitchConnection.CHAT.sendMessage(Channel,"@" + Username + " This command is still on cooldown");
        }
    }
}
