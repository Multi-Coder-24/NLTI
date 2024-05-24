package org.multicoder.nlti.events;

import net.fabricmc.fabric.api.entity.event.v1.ServerPlayerEvents;
import net.minecraft.server.network.ServerPlayerEntity;

public class PlayerCloneEvent implements ServerPlayerEvents.AfterRespawn
{

    @Override
    public void afterRespawn(ServerPlayerEntity oldPlayer, ServerPlayerEntity newPlayer, boolean alive)
    {
        newPlayer.getAttributes().setFrom(oldPlayer.getAttributes());
    }
}
