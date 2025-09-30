package org.multicoder.nlti.commands;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.context.CommandContext;
import net.minecraft.command.CommandRegistryAccess;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.Text;
import org.multicoder.nlti.NLTI;

public class NLTIGameCommands
{
    public static void RegisterCommands(CommandDispatcher<ServerCommandSource> dispatcher, CommandRegistryAccess ignored, CommandManager.RegistrationEnvironment registrationEnvironment)
    {
        if(!registrationEnvironment.dedicated){
            dispatcher.register(CommandManager.literal("NLTI").then(CommandManager.literal("LinkSP").executes(TwitchLinker::LinkAccountSP))).createBuilder().build();
        }else{
            dispatcher.register(CommandManager.literal("NLTI").then(CommandManager.literal("LinkSMP").executes(TwitchLinker::LinkAccountSMP))).createBuilder().build();
            dispatcher.register(CommandManager.literal("NLTI").then(CommandManager.literal("Response").then(CommandManager.argument("reply",StringArgumentType.string()).executes(TwitchLinker::LinkAccountResponse)))).createBuilder().build();
        }
        dispatcher.register(CommandManager.literal("NLTI").then(CommandManager.literal("Test").then(CommandManager.argument("CMD", StringArgumentType.string()).executes(TestCommand::run)))).createBuilder().build();
        dispatcher.register(CommandManager.literal("NLTI").then(CommandManager.literal("List").executes(NLTIGameCommands::ListAll))).createBuilder().build();
    }

    private static int ListAll(CommandContext<ServerCommandSource> context)
    {
        NLTI.commands.forEach(x ->{
            context.getSource().sendMessage(Text.literal("Registered Command: " + x.TRIGGER));
            NLTI.LOG.debug("Registered Command: {}", x.TRIGGER);
        });
        return 0;
    }
}
