package org.multicoder.nlti.commands.potion;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.text.Text;
import org.multicoder.nlti.cooldowns.CooldownManager;
import org.multicoder.nlti.twitch.MulticoderTwitchConnection;

import java.time.LocalDateTime;

public class Poison
{
    public static void Trigger(String Username,String Channel)
    {
        LocalDateTime Now = LocalDateTime.now();
        if(!Now.isAfter(CooldownManager.POISON))
        {
            MulticoderTwitchConnection.CHAT.sendMessage(Channel,"@" + Username + " This command is still on cooldown");
        }
        else
        {
            int Append = 0;
            if(MulticoderTwitchConnection.Config.ChaosMode)
            {
                Append = MulticoderTwitchConnection.Config.Poison[1];
            }
            else{
                Append = MulticoderTwitchConnection.Config.Poison[0];
            }
            Now = Now.plusSeconds(Append);
            CooldownManager.POISON = Now;
            MulticoderTwitchConnection.SERVER.getPlayerManager().getPlayerList().forEach(player -> player.addStatusEffect(new StatusEffectInstance(StatusEffects.POISON,400)));
            MulticoderTwitchConnection.SERVER.getPlayerManager().broadcast(Text.of(Username + " Has ran the command: Poison"),false);
        }
    }
    public static void Trigger()
    {
        MulticoderTwitchConnection.SERVER.getPlayerManager().getPlayerList().forEach(player -> player.addStatusEffect(new StatusEffectInstance(StatusEffects.POISON,400)));
    }
}
