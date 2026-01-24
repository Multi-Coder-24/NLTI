package org.multicoder.nlti;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.StringArgumentType;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.minecraft.command.CommandRegistryAccess;
import net.minecraft.server.command.*;
import org.multicoder.nlti.server.GameCommands;

import static net.minecraft.server.command.CommandManager.*;

public class Nlti implements ModInitializer {

    @Override
    public void onInitialize() {
        CommandRegistrationCallback.EVENT.register(this::CommandRegister);
    }

    private void CommandRegister(CommandDispatcher<ServerCommandSource> dispatcher, CommandRegistryAccess commandRegistryAccess, CommandManager.RegistrationEnvironment registrationEnvironment) {
        dispatcher.register(literal("NLTI").then(literal("Test").then(argument("name",StringArgumentType.greedyString()).executes(GameCommands::TestCommand)))).createBuilder().build();
    }

}
