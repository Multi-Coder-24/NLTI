package org.multicoder.nlti.events;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.minecraft.server.MinecraftServer;
import org.multicoder.nlti.NLTI;
import org.multicoder.nlti.data.GlobalVars;
import org.multicoder.nlti.twitch.MulticoderTwitchConnection;

@SuppressWarnings("all")
public class ServerStartedEvent implements ServerLifecycleEvents.ServerStarted
{
    @Override
    public void onServerStarted(MinecraftServer server)
    {
        NLTI.Vars = GlobalVars.getInstance(server);
        NLTI.LOGGER.info("Server Started");
        NLTI.LOGGER.info("Creating Twitch Bot Thread");
        Thread T = new Thread(() ->{
            try{
                new MulticoderTwitchConnection(server);
            }
            catch (Exception e){
                NLTI.LOGGER.error(e.getMessage());
                StackTraceElement[] Elems = e.getStackTrace();
                for(StackTraceElement el : Elems){
                    NLTI.LOGGER.error(el.toString());
                }
            }
        });
        NLTI.LOGGER.info("Running Twitch Bot Thread");
        T.start();
    }
}
