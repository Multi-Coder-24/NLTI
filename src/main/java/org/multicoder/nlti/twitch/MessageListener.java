package org.multicoder.nlti.twitch;

import com.github.twitch4j.chat.events.channel.ChannelMessageEvent;
import org.multicoder.nlti.NLTI;
import org.multicoder.nlti.commands.CommandInstance;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MessageListener
{
    public static List<CommandInstance> Commands = new ArrayList<CommandInstance>();
    public static void Handle(ChannelMessageEvent event)
    {
        if(MulticoderTwitchConnection.Enabled)
        {
            NLTI.LOGGER.info("Message Received And Active");
            String Channel = event.getChannel().getName();
            String Command = event.getMessage().toLowerCase();
            String User = event.getUser().getName();
            NLTI.LOGGER.info("Message: " + Command);
            CommandInstance Command_Instance = Objects.requireNonNull(Commands.stream().filter(commandInstance -> Command.equalsIgnoreCase(commandInstance.Trigger)).findFirst().get());
            Command_Instance.Trigger(User,Channel);
        }
    }
}
