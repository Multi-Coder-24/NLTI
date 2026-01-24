package org.multicoder.nlti.twitch.commands.world;

import net.minecraft.server.MinecraftServer;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;

import java.time.LocalDateTime;
import java.util.HashSet;

public class EndCommand {
    public static LocalDateTime COOLDOWN = LocalDateTime.now().minusHours(2);
    public static int DELAY = 10;

    public static void PreTrigger(String Username, MinecraftServer server) {
        if(COOLDOWN.isBefore(LocalDateTime.now())){
            Trigger(Username,server);
        }
    }

    public static void PostTrigger(String Username,MinecraftServer server) {
        server.getPlayerManager().broadcast((Text.translatable("text.nlti.command",Username,"End")),false);
        COOLDOWN = LocalDateTime.now().plusSeconds(DELAY);
    }

    public static void Trigger(String Username,MinecraftServer server) {
        server.getPlayerManager().getPlayerList().forEach(player -> player.teleport(server.getWorld(ServerWorld.END),0,72,0,new HashSet<>(),player.lastPitch,player.lastYaw,true));
        PostTrigger(Username,server);
    }
}
