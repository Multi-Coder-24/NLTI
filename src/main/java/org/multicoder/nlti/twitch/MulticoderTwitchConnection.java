package org.multicoder.nlti.twitch;

import com.github.philippheuer.credentialmanager.domain.OAuth2Credential;
import com.github.twitch4j.TwitchClient;
import com.github.twitch4j.TwitchClientBuilder;
import com.github.twitch4j.chat.TwitchChat;
import com.github.twitch4j.chat.events.channel.ChannelMessageEvent;
import com.github.twitch4j.helix.TwitchHelix;
import com.google.gson.stream.JsonReader;
import feign.Logger;
import net.minecraft.server.MinecraftServer;
import org.multicoder.nlti.NLTI;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

public class MulticoderTwitchConnection
{
    public static MinecraftServer SERVER;
    public static TwitchClient CLIENT;
    public static TwitchChat CHAT;
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
                CLIENT = TwitchClientBuilder.builder().withFeignLogLevel(Logger.Level.NONE).withEnableHelix(true).withEnableChat(true).withChatAccount(new OAuth2Credential("twitch", Config.getToken(this.getClass()))).build();
                CHAT = CLIENT.getChat();
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
}
