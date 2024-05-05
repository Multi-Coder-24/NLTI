package org.multicoder.nlti.commands.player;

import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.text.Text;
import org.multicoder.nlti.cooldowns.CooldownManager;
import org.multicoder.nlti.twitch.MulticoderTwitchConnection;

import java.time.LocalDateTime;

public class Speed150
{
    public static void Trigger(String Username,String Channel)
    {
        LocalDateTime Now = LocalDateTime.now();
        if(!Now.isAfter(CooldownManager.SPEED150))
        {
            MulticoderTwitchConnection.CHAT.sendMessage(Channel,"@" + Username + " This command is still on cooldown");
        }
        else {
            int Append = 0;
            if (MulticoderTwitchConnection.Config.ChaosMode) {
                Append = MulticoderTwitchConnection.Config.Speed150[1];
            } else {
                Append = MulticoderTwitchConnection.Config.Speed150[0];
            }
            Now = Now.plusSeconds(Append);
            CooldownManager.SPEED150 = Now;
            MulticoderTwitchConnection.SERVER.getPlayerManager().getPlayerList().forEach(player -> {
                player.getAttributes().getCustomInstance(EntityAttributes.GENERIC_MOVEMENT_SPEED).setBaseValue(0.15f);
            });
            MulticoderTwitchConnection.SERVER.getPlayerManager().broadcast(Text.of(Username + " Has ran the command: Speed 150"),false);

        }
    }
    public static void Trigger()
    {
        MulticoderTwitchConnection.SERVER.getPlayerManager().getPlayerList().forEach(player ->{
            player.getAttributes().getCustomInstance(EntityAttributes.GENERIC_MOVEMENT_SPEED).setBaseValue(0.15f);
        });
    }
}
