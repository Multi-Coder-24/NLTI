package org.multicoder.nlti.commands.player;

import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.text.Text;
import org.multicoder.nlti.cooldowns.CooldownManager;
import org.multicoder.nlti.twitch.MulticoderTwitchConnection;

import java.time.LocalDateTime;
import java.util.Objects;

public class HealthD
{
    public static void Trigger(String Username,String Channel)
    {
        LocalDateTime Now = LocalDateTime.now();
        if(!Now.isAfter(CooldownManager.HEALTH_D))
        {
            MulticoderTwitchConnection.CHAT.sendMessage(Channel,"@" + Username + " This command is still on cooldown");
        }
        else
        {
            int Append;
            if(MulticoderTwitchConnection.Config.ChaosMode)
            {
                Append = MulticoderTwitchConnection.Config.HealthD[1];
            }
            else{
                Append = MulticoderTwitchConnection.Config.HealthD[0];
            }
            Now = Now.plusSeconds(Append);
            CooldownManager.HEALTH_D = Now;
            MulticoderTwitchConnection.SERVER.getPlayerManager().getPlayerList().forEach(player ->
            {
                double MaxHealth = player.getAttributeBaseValue(EntityAttributes.GENERIC_MAX_HEALTH);
                if(MaxHealth != 2)
                {
                    Objects.requireNonNull(player.getAttributes().getCustomInstance(EntityAttributes.GENERIC_MAX_HEALTH),"player.getAttributes().getCustomInstance(EntityAttributes.GENERIC_MAX_HEALTH) returned null").setBaseValue(MaxHealth - 2);
                }
            });
            MulticoderTwitchConnection.SERVER.getPlayerManager().broadcast(Text.of(Username + " Has ran the command: Health Minus"),false);
        }
    }
    public static void Trigger()
    {
        MulticoderTwitchConnection.SERVER.getPlayerManager().getPlayerList().forEach(player ->
        {
            double MaxHealth = player.getAttributeBaseValue(EntityAttributes.GENERIC_MAX_HEALTH);
            if(MaxHealth != 2)
            {
                Objects.requireNonNull(player.getAttributes().getCustomInstance(EntityAttributes.GENERIC_MAX_HEALTH),"player.getAttributes().getCustomInstance(EntityAttributes.GENERIC_MAX_HEALTH) returned null").setBaseValue(MaxHealth - 2);
            }
        });
    }
}
