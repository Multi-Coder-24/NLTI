package org.multicoder.nlti.twitch.commands.world;

import net.minecraft.server.MinecraftServer;
import net.minecraft.text.Text;

import java.time.LocalDateTime;

public class WeatherRainCommand {
    public static LocalDateTime COOLDOWN = LocalDateTime.now().minusHours(2);
    public static int DELAY = 10;

    public static void PreTrigger(String Username, MinecraftServer server) {
        if(COOLDOWN.isBefore(LocalDateTime.now())){
            Trigger(Username,server);
        }
    }

    public static void PostTrigger(String Username,MinecraftServer server) {
        server.getPlayerManager().broadcast((Text.translatable("text.nlti.command",Username,"Weather Rain")),false);
        COOLDOWN = LocalDateTime.now().plusSeconds(DELAY);
    }

    public static void Trigger(String Username,MinecraftServer server) {
        server.getOverworld().setWeather(0,-1,true,false);
        PostTrigger(Username,server);
    }
}
