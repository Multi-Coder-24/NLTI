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
                if(Objects.equals(UID, BID))
                {
                    //  User is broadcaster
                    Command = Command.split("-")[1];
                    CommandParser.ParseCommand(Command,User,Channel,false);
                }
                else
                {
                    //  User is not broadcaster
                    List<OutboundFollow> FollowCheck = MulticoderTwitchConnection.FetchFollow(UID,BID);
                    if(FollowCheck.stream().anyMatch(X -> Objects.equals(X.getBroadcasterName(), BID)))
                    {
                        //  User follows broadcaster
                        Command = Command.split("-")[1];
                        CommandParser.ParseCommand(Command,User,Channel,false);
                    }
                }
            }
        }
    }
}
