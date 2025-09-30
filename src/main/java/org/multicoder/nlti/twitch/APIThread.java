package org.multicoder.nlti.twitch;

import com.github.philippheuer.credentialmanager.domain.OAuth2Credential;
import com.github.twitch4j.chat.TwitchChat;
import com.github.twitch4j.chat.TwitchChatBuilder;
import com.github.twitch4j.helix.domain.ChatMessage;
import net.minecraft.server.MinecraftServer;
import org.multicoder.nlti.NLTI;
import org.multicoder.nlti.config.NLTIConfig;

public class APIThread extends Thread
{
    protected TwitchChat chat;
    protected OAuth2Credential credential;
    protected MinecraftServer game_server;
    protected String Channel;
    public void Launcher(MinecraftServer server){
        game_server = server;
        NLTI.LOG.info("[NLTI Twitch] Initializing");
        NLTIConfig.CreateOrLoadConfig(game_server.getRunDirectory().toAbsolutePath() + "\\config\\");
        start();
    }
    @Override
    public void run() {
        super.run();
        if(!NLTIConfig.Token.equals("***")){
            NLTI.LOG.info("[NLTI Twitch] Token Check: PASSED, Token Provided");
            credential = new OAuth2Credential("twitch",NLTIConfig.Token);
            chat = TwitchChatBuilder.builder().withChatAccount(credential).build();
            Channel = chat.getChannels().toArray()[0].toString();
            chat.sendMessage(Channel,"NLTI Connected");
            chat.getEventManager().onEvent(ChatMessage.class,(Events::OnMessage));
            NLTI.LOG.info("[NLTI Twitch] Thread Running: {}",this.isAlive());
        }
        else{
            NLTI.LOG.info("[NLTI Twitch] Token Check: FAILED, No Token Provided");
        }
    }
    static class Events{
        public static void OnMessage(ChatMessage chatMessage){
            NLTI.LOG.debug("[NLTI Twitch] Chat Message Received: {}",chatMessage.getMessage());
        }
    }
}
