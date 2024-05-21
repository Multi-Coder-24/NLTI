package org.multicoder.nlti.events;

import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.fabricmc.fabric.api.networking.v1.ServerPlayConnectionEvents;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayNetworkHandler;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

public class PlayerJoinedEvent implements ServerPlayConnectionEvents.Join
{
    @Override
    public void onPlayReady(ServerPlayNetworkHandler handler, PacketSender sender, MinecraftServer server)
    {
        handler.getPlayer().sendMessage(Text.literal("Welcome To NLTI by Multicoder, We are running at version 2.5.0").formatted(Formatting.DARK_BLUE));
    }
}
