package org.multicoder.nlti.twitch;

import com.github.twitch4j.TwitchClient;
import com.github.twitch4j.chat.TwitchChat;
import com.github.twitch4j.eventsub.socket.IEventSubSocket;
import com.github.twitch4j.helix.TwitchHelix;

public class APIObjects {
    public static TwitchClient client;
    public static TwitchChat chat;
    public static TwitchHelix helix;
    public static IEventSubSocket socket;
    public static String channelName;
    public static String userID;
    public static boolean inputEnabled;
}
