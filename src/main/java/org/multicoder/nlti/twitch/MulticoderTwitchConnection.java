package org.multicoder.nlti.twitch;

import com.github.philippheuer.credentialmanager.CredentialManager;
import com.github.philippheuer.credentialmanager.CredentialManagerBuilder;
import com.github.philippheuer.credentialmanager.domain.OAuth2Credential;
import com.github.twitch4j.TwitchClient;
import com.github.twitch4j.TwitchClientBuilder;
import com.github.twitch4j.auth.TwitchAuth;
import com.github.twitch4j.chat.TwitchChat;
import com.github.twitch4j.chat.events.channel.ChannelMessageEvent;
import com.github.twitch4j.helix.TwitchHelix;
import com.github.twitch4j.helix.domain.OutboundFollow;
import com.google.gson.stream.JsonReader;
import feign.Logger;
import net.minecraft.server.MinecraftServer;
import org.multicoder.nlti.NLTI;

import java.io.File;
import java.io.FileReader;
import java.util.List;

public class MulticoderTwitchConnection
{
    public static MinecraftServer SERVER;
    public static TwitchClient CLIENT;
    public static TwitchChat CHAT;
    public static TwitchHelix HELIX;
    public static boolean Enabled;
    public static NLTIConfig Config;
    public MulticoderTwitchConnection(MinecraftServer server) throws Exception
    {
        if(NLTI.DEBUG)
        {
            SERVER = server;
        }
        else{
            Enabled = false;
            String ConfigPath = server.getRunDirectory().getAbsolutePath() + "/nlti-config.json";
            File JF = new File(ConfigPath);
            if(!JF.exists())
            {
                ConfigurationGenerator.CreateJSONConfig(ConfigPath);
            }
            else
            {
                SERVER = server;
                JsonReader Reader = new JsonReader(new FileReader(ConfigPath));
                Config = new NLTIConfig(Reader);
                CredentialManager Manager = CredentialManagerBuilder.builder().build();
                TwitchAuth.registerIdentityProvider(Manager,Config.getClientID(this.getClass()),Config.getToken(this.getClass()),Config.getRedirect(this.getClass()));
                CLIENT = TwitchClientBuilder.builder().withFeignLogLevel(Logger.Level.NONE).withCredentialManager(Manager).withEnableHelix(true).withEnableChat(true).withChatAccount(new OAuth2Credential("twitch", Config.getToken(this.getClass()))).build();
                CHAT = CLIENT.getChat();
                HELIX = CLIENT.getHelix();
                CHAT.connect();
                for(String User : Config.Users)
                {
                    CHAT.joinChannel(User);
                    CHAT.getEventManager().onEvent(ChannelMessageEvent.class,MessageListener::Handle);
                    CHAT.sendMessage(User,"NLTI Has Connected");
                }
            }
        }
    }
    public static List<OutboundFollow> FetchFollow(String UserID, String ChannelID)
    {
        return HELIX.getFollowedChannels(Config.getToken(MulticoderTwitchConnection.class),UserID,ChannelID,null,null).execute().getFollows();
    }
}
