package org.multicoder.nlti.twitch;

import com.github.twitch4j.chat.events.channel.ChannelMessageEvent;
import com.github.twitch4j.helix.domain.OutboundFollow;
import org.multicoder.nlti.util.CommandParser;

import java.util.List;
import java.util.Objects;

public class MessageListener
{
    public static void Handle(ChannelMessageEvent event)
    {
        if(MulticoderTwitchConnection.Enabled)
        {
            String Channel = event.getChannel().getName();
            String Command = event.getMessage().toLowerCase();
            String User = event.getUser().getName();
            String UID = event.getUser().getId();
            String BID = event.getChannel().getId();
            if(Command.startsWith("!mc-"))
            {
                Command = Command.split("-")[1];
                CommandParser.ParseCommand(Command,User,Channel,false);
            }
        }
    }
}
