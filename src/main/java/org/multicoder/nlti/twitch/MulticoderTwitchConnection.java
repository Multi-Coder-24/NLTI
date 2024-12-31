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
import feign.Logger;
import net.minecraft.server.MinecraftServer;
import org.multicoder.nlti.NLTI;
import org.multicoder.nlti.config.ConfigurationManager;
import org.multicoder.nlti.config.NLTIConfig;

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
        String CommandConfig = server.getRunDirectory().getAbsolutePath() + "/nlti-commands.json";
        String MainConfig = server.getRunDirectory().getAbsolutePath() + "/nlti-config.json";
        ConfigurationManager.LoadOrCreateConfig(MainConfig,CommandConfig);
        Enabled = false;
        SERVER = server;
        if(!NLTI.FIRSTRUN)
        {
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
