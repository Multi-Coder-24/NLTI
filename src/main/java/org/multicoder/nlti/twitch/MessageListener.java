package org.multicoder.nlti.twitch;

import com.github.twitch4j.chat.events.channel.ChannelMessageEvent;
import org.multicoder.nlti.NLTI;
import org.multicoder.nlti.util.CommandNodeBuilder;

import java.time.LocalDateTime;

public class MessageListener
{
    public static void Handle(ChannelMessageEvent event)
    {
        if(MulticoderTwitchConnection.Enabled)
        {
            String Command = event.getMessage().toLowerCase();
            String User = event.getUser().getName();
            if(MulticoderTwitchConnection.Config.Commands_Dict.containsKey(Command))
            {
                //  User Ran Command
                CommandNodeBuilder.CommandNode Node = MulticoderTwitchConnection.Config.Commands_Dict.get(Command);
                if(Node.Cooldown.isBefore(LocalDateTime.now()))
                {
                    //  Cooldown Valid
                    if(MulticoderTwitchConnection.Config.ChaosMode)
                    {
                        Node.Cooldown = Node.Cooldown.plusSeconds(Node.Chaos);
                    }
                    else
                    {
                        Node.Cooldown = Node.Cooldown.plusSeconds(Node.Normal);
                    }
                    try
                    {
                        Node.Invoker.invoke(null,User);
                    }
                    catch (Exception ex)
                    {
                        NLTI.LOGGER.error("Failed To Run: {}",Command);
                        NLTI.LOGGER.error("Caused By: ", ex);
                    }
                }
                else
                {
                    event.reply(MulticoderTwitchConnection.CHAT,"This Command is currently on cooldown");
                }
            }
        }
    }
}
