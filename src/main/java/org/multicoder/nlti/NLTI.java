package org.multicoder.nlti;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.fabricmc.fabric.api.networking.v1.ServerPlayConnectionEvents;
import org.multicoder.nlti.events.PlayerJoinedEvent;
import org.multicoder.nlti.events.ServerStartedEvent;
import org.multicoder.nlti.events.ServerStoppedEvent;
import org.multicoder.nlti.gamecommands.NLTICommands;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NLTI implements ModInitializer
{
    public static final Logger LOGGER = LoggerFactory.getLogger(NLTI.class);
    public static final boolean DEBUG = false;
    @Override
    public void onInitialize()
    {
        ServerLifecycleEvents.SERVER_STARTED.register(new ServerStartedEvent());
        ServerLifecycleEvents.SERVER_STOPPED.register(new ServerStoppedEvent());
        ServerPlayConnectionEvents.JOIN.register(new PlayerJoinedEvent());
        CommandRegistrationCallback.EVENT.register(NLTICommands::RegisterCommands);
    }
}
