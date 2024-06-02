package org.multicoder.nlti.events;

import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.fabricmc.fabric.api.networking.v1.ServerPlayConnectionEvents;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayNetworkHandler;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import org.multicoder.nlti.NLTI;

public class PlayerJoinedEvent implements ServerPlayConnectionEvents.Join
{
    @Override
    public void onPlayReady(ServerPlayNetworkHandler handler, PacketSender sender, MinecraftServer server)
    {
        if(NLTI.FIRSTRUN)
        {
            handler.getPlayer().sendMessage(Text.literal("NLTI Has detected this as your first run. Please exit, shutdown the server and edit both config files."));
        }
        handler.getPlayer().sendMessage(Text.literal("Welcome To NLTI by Multicoder, We are running at version ").append(NLTI.Version).formatted(Formatting.DARK_BLUE));
    }
}
