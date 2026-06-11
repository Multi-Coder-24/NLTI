package org.multicoder.nlti.twitch.commands;

import net.minecraft.network.chat.Component;
import org.multicoder.nlti.config.ModConfig;
import org.multicoder.nlti.twitch.TwitchThread;

import java.time.LocalDateTime;
import java.util.Arrays;

public class WeatherCommand {
    public static LocalDateTime COOLDOWN;
    public static String[] VALID_ARGS = new String[]{"clear","cloudy","raining","thunder"};
    public static void Handle(String Name, String user){
        if(LocalDateTime.now().isAfter(COOLDOWN)){
            if(Arrays.asList(VALID_ARGS).contains(Name)){
                int Requested = Arrays.stream(VALID_ARGS).toList().indexOf(Name);
                switch (Requested){
                    case 0:
                        TwitchThread.server.overworld().setWeatherParameters(1,-1,false,false);
                        break;
                    case 1:
                        TwitchThread.server.overworld().setWeatherParameters(-1,-1,false,false);
                        break;
                    case 2:
                        TwitchThread.server.overworld().setWeatherParameters(-1,1,true,false);
                        break;
                    case 3:
                        TwitchThread.server.overworld().setWeatherParameters(-1,1,true,true);
                }
                COOLDOWN = LocalDateTime.now().plusSeconds(ModConfig.BaseCooldown);
                TwitchThread.server.getPlayerList().broadcastSystemMessage(Component.translatable("text.nlti.weather",user,Name.toLowerCase()),false);
            }
        }
    }

}
