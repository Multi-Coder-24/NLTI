package org.multicoder.nlti.twitch.commands;

import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import org.multicoder.nlti.config.ModConfig;
import org.multicoder.nlti.twitch.TwitchThread;

import java.time.LocalDateTime;

@SuppressWarnings("all")
public class EffectCommand {
    public static LocalDateTime COOLDOWN;
    public static void Handle(String name, String user){
        if(LocalDateTime.now().isAfter(COOLDOWN)){
            if(BuiltInRegistries.MOB_EFFECT.get(Identifier.fromNamespaceAndPath("minecraft",name.toLowerCase())).isPresent()){
                MobEffect effect = BuiltInRegistries.MOB_EFFECT.getValue(Identifier.fromNamespaceAndPath("minecraft",name.toLowerCase()));
                TwitchThread.server.getPlayerList().getPlayers().forEach(serverPlayer -> {
                    MobEffectInstance instance = new MobEffectInstance(Holder.direct(effect),200,0,false,false);
                    serverPlayer.addEffect(instance);
                });
                COOLDOWN = LocalDateTime.now().plusSeconds(ModConfig.BaseCooldown);
                TwitchThread.server.getPlayerList().broadcastSystemMessage(Component.translatable("text.nlti.potion",user,name.toLowerCase()),false);
            }
        }
    }
}
