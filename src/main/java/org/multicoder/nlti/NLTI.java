package org.multicoder.nlti;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.fabricmc.fabric.impl.networking.payload.PayloadHelper;
import org.multicoder.nlti.commands.GameCommands;

public class NLTI implements ModInitializer {
    public static final String MODID = "nlti";
    @Override
    public void onInitialize() {
        CommandRegistrationCallback.EVENT.register(((dispatcher, registryAccess, environment) -> GameCommands.register(dispatcher)));
    }

}
