package org.multicoder.nlti.twitch;

import com.github.twitch4j.chat.events.channel.ChannelMessageEvent;
import org.multicoder.nlti.util.CommandParser;

import java.util.Arrays;
import java.util.List;

public class MessageListener
{
    public static void Handle(ChannelMessageEvent event)
    {
        if(MulticoderTwitchConnection.Enabled)
        {
            String Channel = event.getChannel().getName();
            String Command = event.getMessage().toLowerCase();
            String User = event.getUser().getName();
            if(Command.startsWith("!mc-"))
            {
                List<String> TH = new java.util.ArrayList<>(List.of(Command.split("-")));
                TH.remove(0);
                Command = Arrays.deepToString(TH.toArray());
                Command = Command.substring(1,Command.length() - 1);
                CommandParser.ParseCommand(Command,User,Channel,false);
            }
        }
    }
}
