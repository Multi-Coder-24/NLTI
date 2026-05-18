package org.multicoder.nlti;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import org.multicoder.nlti.commands.GameCommands;

public class NLTI implements ModInitializer {

    @Override
    public void onInitialize() {
        CommandRegistrationCallback.EVENT.register(((dispatcher, registryAccess, environment) -> GameCommands.register(dispatcher)));
    }

}
