package org.multicoder.nlti.twitch;

import com.github.philippheuer.credentialmanager.domain.OAuth2Credential;
import com.github.twitch4j.TwitchClient;
import com.github.twitch4j.TwitchClientBuilder;
import com.github.twitch4j.chat.TwitchChat;
import com.github.twitch4j.chat.events.channel.ChannelMessageEvent;
import com.github.twitch4j.helix.TwitchHelix;
import com.google.gson.stream.JsonReader;
import net.minecraft.server.MinecraftServer;
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
    protected static String Token;
    public static boolean Enabled;
    public static NLTIConfig Config;
    public MulticoderTwitchConnection(MinecraftServer server) throws Exception
    {
        Enabled = false;
        String Properties = server.getRunDirectory().getAbsolutePath() + "/nlti.properties";
        String ConfigPath = server.getRunDirectory().getAbsolutePath() + "/nlti-config.json";
        File F = new File(Properties);
        File JF = new File(ConfigPath);
        if(!F.exists())
        {
            ConfigurationGenerator.CreateConfig(Properties);
        }
        if(!JF.exists())
        {
            ConfigurationGenerator.CreateJSONConfig(ConfigPath);
        }
        else
        {
            InputStream Stream = new FileInputStream(Properties);
            java.util.Properties P = new Properties();
            P.load(Stream);
            SERVER = server;
            Token = P.getProperty("token");
            JsonReader Reader = new JsonReader(new FileReader(ConfigPath));
            Config = new NLTIConfig(Reader);
            CLIENT = TwitchClientBuilder.builder().withEnableHelix(true).withEnableChat(true).withChatAccount(new OAuth2Credential("twitch", P.getProperty("token"))).build();
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
