package org.multicoder.nlti;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.multicoder.nlti.commands.GameCommands;
import org.multicoder.nlti.event.GameEvents;
import org.multicoder.nlti.network.LinkPacketS2C;
import org.multicoder.nlti.network.LinkResponseC2SPacket;

public class NLTI implements ModInitializer {
    public static final String MODID = "nlti";
    public static final Logger LOG = LogManager.getLogger(MODID);
    @Override
    public void onInitialize() {
        CommandRegistrationCallback.EVENT.register(((dispatcher, registryAccess, environment) -> GameCommands.register(dispatcher)));
        ServerLifecycleEvents.SERVER_STARTED.register(GameEvents::ServerStarted);
        ServerLifecycleEvents.SERVER_STOPPED.register(GameEvents::ServerStopped);
        PayloadTypeRegistry.playS2C().register(LinkPacketS2C.TYPE,LinkPacketS2C.CODEC);
        PayloadTypeRegistry.playC2S().register(LinkResponseC2SPacket.TYPE,LinkResponseC2SPacket.CODEC);
        ServerPlayNetworking.registerGlobalReceiver(LinkResponseC2SPacket.TYPE,LinkResponseC2SPacket::receive);
    }

}
