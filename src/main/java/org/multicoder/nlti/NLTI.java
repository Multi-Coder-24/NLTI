package org.multicoder.nlti;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.minecraft.entity.attribute.EntityAttributes;
import org.multicoder.nlti.events.ServerStartedEvent;
import org.multicoder.nlti.events.ServerStoppedEvent;
import org.multicoder.nlti.gamecommands.NLTICommands;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NLTI implements ModInitializer
{
    public static final Logger LOGGER = LoggerFactory.getLogger("nlti");
    public static final boolean DEBUG = true;
    @Override
    public void onInitialize()
    {
        ServerLifecycleEvents.SERVER_STARTED.register(new ServerStartedEvent());
        ServerLifecycleEvents.SERVER_STOPPED.register(new ServerStoppedEvent());
        CommandRegistrationCallback.EVENT.register(NLTICommands::RegisterCommands);
    }
}
