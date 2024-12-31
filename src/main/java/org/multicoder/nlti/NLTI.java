package org.multicoder.nlti;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.fabricmc.fabric.api.entity.event.v1.ServerPlayerEvents;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.fabricmc.fabric.api.networking.v1.ServerPlayConnectionEvents;
import org.multicoder.nlti.data.GlobalVars;
import org.multicoder.nlti.events.*;
import org.multicoder.nlti.gamecommands.NLTICommands;
import org.slf4j.*;

public class NLTI implements ModInitializer
{
    public static final String Version = "4.1.0";
    public static final Logger LOGGER = LoggerFactory.getLogger(NLTI.class);
    public static boolean FIRSTRUN = false;
    public static GlobalVars Vars;
    @Override
    public void onInitialize()
    {
        ServerLifecycleEvents.SERVER_STARTED.register(new ServerStartedEvent());
        ServerLifecycleEvents.SERVER_STOPPED.register(new ServerStoppedEvent());
        ServerPlayConnectionEvents.JOIN.register(new PlayerJoinedEvent());
        ServerPlayerEvents.AFTER_RESPAWN.register(new PlayerCloneEvent());
        CommandRegistrationCallback.EVENT.register(NLTICommands::RegisterCommands);
    }
}
