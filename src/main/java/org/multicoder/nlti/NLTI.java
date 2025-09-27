package org.multicoder.nlti;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.multicoder.nlti.commands.NLTIGameCommands;
import org.multicoder.nlti.twitch.APIThread;

public class NLTI implements ModInitializer {

    public static final String MOD_ID = "nlti";
    public static final Logger LOG = LogManager.getLogger(MOD_ID);
    protected APIThread thread;
    @Override
    public void onInitialize() {
        LOG.info("[NLTI Minecraft] Initializing");
        ServerLifecycleEvents.SERVER_STARTING.register(server -> {thread = new APIThread();thread.Launcher(server);});
        ServerLifecycleEvents.SERVER_STOPPING.register(server -> {thread.CloseConnection();thread = null;});
        CommandRegistrationCallback.EVENT.register(NLTIGameCommands::RegisterCommands);
    }
}
