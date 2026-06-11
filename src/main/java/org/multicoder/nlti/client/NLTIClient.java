package org.multicoder.nlti.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import org.multicoder.nlti.network.LinkPacketS2C;

public class NLTIClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        ClientPlayNetworking.registerGlobalReceiver(LinkPacketS2C.TYPE,LinkPacketS2C::receive);
    }
}
