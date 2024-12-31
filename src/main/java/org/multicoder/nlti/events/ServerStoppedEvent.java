package org.multicoder.nlti.events;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.minecraft.server.MinecraftServer;
import org.multicoder.nlti.NLTI;
import org.multicoder.nlti.twitch.MulticoderTwitchConnection;

public class ServerStoppedEvent implements ServerLifecycleEvents.ServerStopped
{

    @Override
    public void onServerStopped(MinecraftServer server)
    {
        if(!NLTI.FIRSTRUN)
        {
            for(String U : MulticoderTwitchConnection.Config.Users)
            {
                MulticoderTwitchConnection.CHAT.sendMessage(U,"NLTI Disconnected");
            }
            try
            {
                Thread.sleep(2000);
                MulticoderTwitchConnection.CHAT.close();
                MulticoderTwitchConnection.CLIENT.close();
            }
            catch (Exception e)
            {
                NLTI.LOGGER.error("Error At Shutdown",e);
            }
        }
    }
}
