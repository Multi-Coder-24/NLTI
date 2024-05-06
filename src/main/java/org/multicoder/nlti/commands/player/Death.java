package org.multicoder.nlti.commands.player;

import net.minecraft.entity.LivingEntity;
import net.minecraft.text.Text;
import org.multicoder.nlti.cooldowns.CooldownManager;
import org.multicoder.nlti.twitch.MulticoderTwitchConnection;

import java.time.LocalDateTime;

public class Death
{
    public static void Trigger(String User, String Channel)
    {
        LocalDateTime Now = LocalDateTime.now();
        if(!Now.isAfter(CooldownManager.DEATH))
        {
            MulticoderTwitchConnection.CHAT.sendMessage(Channel,"@" + User + " This command is still on cooldown");
        }
        else
        {
            int Append = 0;
            if(MulticoderTwitchConnection.Config.ChaosMode)
            {
                Append = MulticoderTwitchConnection.Config.Death[1];
            }
            else{
                Append = MulticoderTwitchConnection.Config.Death[0];
            }
            Now = Now.plusSeconds(Append);
            CooldownManager.DEATH = Now;
            MulticoderTwitchConnection.SERVER.getPlayerManager().getPlayerList().forEach(LivingEntity::kill);
            MulticoderTwitchConnection.SERVER.getPlayerManager().broadcast(Text.of(User + " Has ran the command: Death"),false);
        }
    }
    public static void Trigger()
    {
        MulticoderTwitchConnection.SERVER.getPlayerManager().getPlayerList().forEach(LivingEntity::kill);
    }
}
