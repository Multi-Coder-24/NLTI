package org.multicoder.nlti.event;

import net.minecraft.server.MinecraftServer;
import org.multicoder.nlti.config.ModConfig;
import org.multicoder.nlti.twitch.TwitchThread;

import java.util.Objects;

public class GameEvents {
    public static Thread twitch;
    public static void ServerStarted(MinecraftServer server) {
        ModConfig.CreateOrLoadConfig(server);
        if(!Objects.equals(ModConfig.Token, "***")){
            twitch = new TwitchThread(server);
        }
    }
    public static void ServerStopped(MinecraftServer ignored){
        if(!(twitch == null)){
            twitch.interrupt();
        }
    }
}
