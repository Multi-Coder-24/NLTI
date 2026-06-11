package org.multicoder.nlti.twitch.commands;

import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.*;
import org.multicoder.nlti.config.ModConfig;
import org.multicoder.nlti.twitch.TwitchThread;

import java.time.LocalDateTime;
import java.util.Arrays;

@SuppressWarnings("all")
public class MobSpawnerCommand {
    public static LocalDateTime COOLDOWN;
    public static void Handle(String name,String user){
        if(LocalDateTime.now().isAfter(COOLDOWN)){
            if(BuiltInRegistries.ENTITY_TYPE.get(Identifier.fromNamespaceAndPath("minecraft",name.toLowerCase())).isPresent()){
                if(Arrays.stream(ModConfig.BlackListedMobs).noneMatch(s->s.equals(name)) && !name.equals("player")){
                    EntityType<?> selected = BuiltInRegistries.ENTITY_TYPE.get(Identifier.fromNamespaceAndPath("minecraft",name.toLowerCase())).get().value();
                    TwitchThread.server.getPlayerList().getPlayers().forEach(serverPlayer -> {
                        BlockPos position = serverPlayer.blockPosition();
                        position = position.offset(2,0,2);
                        Entity e = selected.create(serverPlayer.level(), EntitySpawnReason.COMMAND);
                        e.setPos(position.getCenter());
                        e.setCustomName(Component.literal(user));
                        serverPlayer.level().addFreshEntity(e);
                    });
                    TwitchThread.server.getPlayerList().broadcastSystemMessage(Component.translatable("text.nlti.mob",user,name.toLowerCase()),false);
                    COOLDOWN = LocalDateTime.now().plusSeconds(ModConfig.BaseCooldown);
                }
            }
        }
    }
}
