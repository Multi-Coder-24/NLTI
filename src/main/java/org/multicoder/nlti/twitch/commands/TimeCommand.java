package org.multicoder.nlti.twitch.commands;

import net.minecraft.network.chat.Component;
import org.multicoder.nlti.config.ModConfig;
import org.multicoder.nlti.twitch.TwitchThread;

import java.time.LocalDateTime;
import java.util.Arrays;

public class TimeCommand {
    public static LocalDateTime COOLDOWN;
    public static String[] VALID_ARGS = new String[]{"day","noon","night","midnight"};
    public static void Handle(String Name,String user){
        if(LocalDateTime.now().isAfter(COOLDOWN)){
            if(Arrays.asList(VALID_ARGS).contains(Name)){
                int Selected = Arrays.stream(VALID_ARGS).toList().indexOf(Name);
                switch(Selected){
                    case 0:
                        TwitchThread.server.overworld().setDayTime(1000L);
                        break;
                    case 1:
                        TwitchThread.server.overworld().setDayTime(6000L);
                        break;
                    case 2:
                        TwitchThread.server.overworld().setDayTime(13000L);
                        break;
                    case 3:
                        TwitchThread.server.overworld().setDayTime(18000L);
                }
                TwitchThread.server.getPlayerList().broadcastSystemMessage(Component.translatable("text.nlti.time",user,Name),false);
                COOLDOWN = LocalDateTime.now().plusSeconds(ModConfig.BaseCooldown);
            }
        }
    }
}
