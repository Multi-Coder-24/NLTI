package org.multicoder.nlti.commands;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.StringArgumentType;
import net.minecraft.command.CommandRegistryAccess;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;

public class NLTIGameCommands
{
    public static void RegisterCommands(CommandDispatcher<ServerCommandSource> dispatcher, CommandRegistryAccess commandRegistryAccess, CommandManager.RegistrationEnvironment registrationEnvironment)
    {
        dispatcher.register(CommandManager.literal("NLTI").then(CommandManager.literal("Test").then(CommandManager.argument("CMD", StringArgumentType.string()).executes(TestCommand::run)))).createBuilder().build();
        dispatcher.register(CommandManager.literal("NLTI").then(CommandManager.literal("Link").executes(TwitchLinker::LinkAccount))).createBuilder().build();
    }
}
