package org.multicoder.nlti.twitch;

import com.github.twitch4j.chat.events.channel.ChannelMessageEvent;
import org.multicoder.nlti.commands.*;

public class MessageListener
{
    public static void Handle(ChannelMessageEvent event)
    {
        if(!MulticoderTwitchConnection.Enabled)
        {
            return;
        }
        else
        {
            String Channel = event.getChannel().getName();
            String Command = event.getMessage();
            String User = event.getUser().getName();
            if(Command.startsWith("!MC-"))
            {
                Command = Command.split("-")[1];
                switch (Command)
                {
                    case "Creeper" -> {Creeper.Trigger(User,Channel);}
                    case "Skeleton" ->{Skeleton.Trigger(User,Channel);}
                    case "Zombie" ->{Zombie.Trigger(User,Channel);}
                    case "Enderman" ->{Enderman.Trigger(User,Channel);}
                    case "Spider" ->{Spider.Trigger(User,Channel);}
                    case "Witch" ->{Witch.Trigger(User,Channel);}
                    case "Vindicator" ->{Vindicator.Trigger(User,Channel);}
                    case "Husk" ->{Husk.Trigger(User,Channel);}
                    case "Pillager" ->{Pillager.Trigger(User,Channel);}
                    case "Piglin" ->{Piglin.Trigger(User,Channel);}
                    case "Stray" ->{Stray.Trigger(User,Channel);}
                    case "Poison" ->{Poison.Trigger(User,Channel);}
                    case "Hunger" ->{Hunger.Trigger(User,Channel);}
                    case "Weakness" ->{Weakness.Trigger(User,Channel);}
                    case "Blind" ->{Blind.Trigger(User,Channel);}
                    case "Slow" ->{Slow.Trigger(User,Channel);}
                    case "Regen" ->{Regen.Trigger(User,Channel);}
                    case "Stength" ->{Strength.Trigger(User,Channel);}
                    case "Speed" ->{Speed.Trigger(User,Channel);}
                    case "Haste" ->{Haste.Trigger(User,Channel);}
                    case "Resistance" ->{Resistance.Trigger(User,Channel);}
                    case "NightVision" ->{NightVision.Trigger(User,Channel);}
                    case "Steal" ->{Steal.Trigger(User,Channel);}
                    case "Snatch" ->{Snatch.Trigger(User,Channel);}
                    case "Food" ->{Food.Trigger(User,Channel);}
                }
            }
        }
    }
}
