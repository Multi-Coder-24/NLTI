package org.multicoder.nlti.commands.player;

import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.text.Text;
import org.multicoder.nlti.cooldowns.CooldownManager;
import org.multicoder.nlti.twitch.MulticoderTwitchConnection;

import java.time.LocalDateTime;
import java.util.Objects;

public class Speed25
{
    public static void Trigger(String Username,String Channel)
    {
        LocalDateTime Now = LocalDateTime.now();
        if(!Now.isAfter(CooldownManager.SPEED25))
        {
            MulticoderTwitchConnection.CHAT.sendMessage(Channel,"@" + Username + " This command is still on cooldown");
        }
        else {
            int Append;
            if (MulticoderTwitchConnection.Config.ChaosMode) {
                Append = MulticoderTwitchConnection.Config.Speed25[1];
            } else {
                Append = MulticoderTwitchConnection.Config.Speed25[0];
            }
            Now = Now.plusSeconds(Append);
            CooldownManager.SPEED25 = Now;
            MulticoderTwitchConnection.SERVER.getPlayerManager().getPlayerList().forEach(player -> Objects.requireNonNull(player.getAttributes().getCustomInstance(EntityAttributes.GENERIC_MOVEMENT_SPEED),"player.getAttributes().getCustomInstance(EntityAttributes.GENERIC_MOVEMENT_SPEED) returned null").setBaseValue(0.025f));
            MulticoderTwitchConnection.SERVER.getPlayerManager().broadcast(Text.of(Username + " Has ran the command: Speed 25"),false);
        }
    }
    public static void Trigger()
    {
        MulticoderTwitchConnection.SERVER.getPlayerManager().getPlayerList().forEach(player -> Objects.requireNonNull(player.getAttributes().getCustomInstance(EntityAttributes.GENERIC_MOVEMENT_SPEED),"player.getAttributes().getCustomInstance(EntityAttributes.GENERIC_MOVEMENT_SPEED) returned null").setBaseValue(0.025f));
    }
}
