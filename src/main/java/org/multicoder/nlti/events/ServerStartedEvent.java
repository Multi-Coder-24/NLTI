package org.multicoder.nlti.events;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.minecraft.server.MinecraftServer;
import org.multicoder.nlti.NLTI;
import org.multicoder.nlti.cooldowns.CooldownManager;
import org.multicoder.nlti.twitch.MulticoderTwitchConnection;

public class ServerStartedEvent implements ServerLifecycleEvents.ServerStarted
{
    @Override
    public void onServerStarted(MinecraftServer server)
    {
        NLTI.LOGGER.info("Server Started");
        NLTI.LOGGER.info("Creating Cooldown Managers");
        CooldownManager.Init();
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
