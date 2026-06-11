package org.multicoder.nlti.twitch;

import com.github.twitch4j.eventsub.events.ChannelChatMessageEvent;
import org.multicoder.nlti.twitch.commands.EffectCommand;
import org.multicoder.nlti.twitch.commands.MobSpawnerCommand;
import org.multicoder.nlti.twitch.commands.TimeCommand;
import org.multicoder.nlti.twitch.commands.WeatherCommand;

public class Events {
    public static void OnChatMessage(ChannelChatMessageEvent event){
        if(APIObjects.inputEnabled){
            String Message = event.getMessage().getText().toLowerCase();
            String Username = event.getChatterUserName();
            if(Message.startsWith("!mc-mob")) {
                String Name = Message.split(" ")[1];
                MobSpawnerCommand.Handle(Name,Username);
            }else if(Message.startsWith("!mc-effect")){
                String Name = Message.split(" ")[1];
                EffectCommand.Handle(Name,Username);
            }else if(Message.startsWith("!mc-weather")){
                String Weather = Message.split(" ")[1];
                WeatherCommand.Handle(Weather,Username);
            }else if(Message.startsWith("!mc-time")){
                String time = Message.split(" ")[1];
                TimeCommand.Handle(time,Username);
            }
        }
    }
}
