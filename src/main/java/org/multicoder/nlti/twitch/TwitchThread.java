package org.multicoder.nlti.twitch;

import com.github.philippheuer.credentialmanager.domain.OAuth2Credential;
import com.github.philippheuer.events4j.simple.SimpleEventHandler;
import com.github.twitch4j.TwitchClientBuilder;
import com.github.twitch4j.eventsub.events.ChannelChatMessageEvent;
import com.github.twitch4j.eventsub.subscriptions.SubscriptionTypes;
import net.minecraft.server.MinecraftServer;
import org.multicoder.nlti.NLTI;
import org.multicoder.nlti.commands.secure.Constants;
import org.multicoder.nlti.config.ModConfig;
import org.multicoder.nlti.twitch.commands.*;
import java.time.LocalDateTime;

import static org.multicoder.nlti.twitch.APIObjects.*;

public class TwitchThread extends Thread{
    public TwitchThread(MinecraftServer Server) {
        server = Server;
        this.start();
    }
    public static MinecraftServer server;
    @Override
    public void run() {
        super.run();
        try{
            APIObjects.client = TwitchClientBuilder.builder().withEnableEventSocket(true).withDefaultEventHandler(SimpleEventHandler.class).withClientId(Constants.ClientID).withChatAccount(new OAuth2Credential("twitch",ModConfig.Token)).withEnableChat(true).withEnableHelix(true).build();
            APIObjects.helix = APIObjects.client.getHelix();
            APIObjects.socket = APIObjects.client.getEventSocket();
            APIObjects.userID = APIObjects.helix.getUsers(ModConfig.Token,null,null).execute().getUsers().getFirst().getId();
            chat = APIObjects.client.getChat();
            APIObjects.channelName = chat.getChannels().toArray()[0].toString();
            APIObjects.inputEnabled = false;
            APIObjects.socket.register(new OAuth2Credential("twitch",ModConfig.Token),SubscriptionTypes.CHANNEL_CHAT_MESSAGE.prepareSubscription(f ->f.userId(APIObjects.userID).broadcasterUserId(APIObjects.userID).build(),null));
            APIObjects.socket.getEventManager().onEvent(ChannelChatMessageEvent.class,Events::OnChatMessage);
            MobSpawnerCommand.COOLDOWN = LocalDateTime.now();
            EffectCommand.COOLDOWN = LocalDateTime.now();
            WeatherCommand.COOLDOWN = LocalDateTime.now();
            TimeCommand.COOLDOWN = LocalDateTime.now();
            chat.sendMessage(APIObjects.channelName,"NLTI Connected");
        } catch (Exception e) {
            NLTI.LOG.fatal("Twitch Thread Failure",e);
            interrupt();
        }
    }

    public static void Enable(){
        inputEnabled = true;
        chat.sendMessage(channelName,"NLTI Enabled");
    }
    public static void Disable(){
        inputEnabled = false;
        chat.sendMessage(channelName,"NLTI Disabled");
    }
    public static void Reset(){
        chat.sendMessage(channelName,"NLTI Reset");
        MobSpawnerCommand.COOLDOWN = LocalDateTime.now();
        EffectCommand.COOLDOWN = LocalDateTime.now();
        WeatherCommand.COOLDOWN = LocalDateTime.now();
        TimeCommand.COOLDOWN = LocalDateTime.now();
    }

}
