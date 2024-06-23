package org.multicoder.nlti.gamecommands;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.context.CommandContext;
import net.minecraft.command.CommandRegistryAccess;
import net.minecraft.server.command.ServerCommandSource;
import org.multicoder.nlti.NLTI;
import org.multicoder.nlti.mcsi.ScriptReader;
import org.multicoder.nlti.twitch.MulticoderTwitchConnection;

import java.time.LocalDateTime;

import static net.minecraft.server.command.CommandManager.*;

public class NLTICommands
{
    public static void RegisterCommands(CommandDispatcher<ServerCommandSource> dispatcher, CommandRegistryAccess ignoredAccess, RegistrationEnvironment ignoredEnv)
    {
        dispatcher.register(literal("NLTI").then(literal("Start").executes(NLTICommands::Start))).createBuilder().build();
        dispatcher.register(literal("NLTI").then(literal("Stop").executes(NLTICommands::Stop))).createBuilder().build();
        dispatcher.register(literal("NLTI").then(literal("Reset").executes(NLTICommands::Reset))).createBuilder().build();
        dispatcher.register(literal("NLTI").then(literal("Test").requires(serverCommandSource -> serverCommandSource.hasPermissionLevel(2)).then(argument("name",StringArgumentType.string()).executes(NLTICommands::Test)))).createBuilder().build();
        dispatcher.register(literal("NLTI").then(literal("Test").then(literal("External").requires(serverCommandSource -> serverCommandSource.hasPermissionLevel(2)).then(argument("name",StringArgumentType.string()).executes(NLTICommands::TestExternal))))).createBuilder().build();

    }

    private static int TestExternal(CommandContext<ServerCommandSource> context)
    {
        String Command = "!" + StringArgumentType.getString(context,"name").toLowerCase();
        ScriptReader.ExecuteScript(Command);
        return 0;
    }

    private static int Test(CommandContext<ServerCommandSource> serverCommandSourceCommandContext) {
        String Command = StringArgumentType.getString(serverCommandSourceCommandContext,"name").toLowerCase();
        if(MulticoderTwitchConnection.Config.Commands_Dict.containsKey(Command))
        {
            try
            {
                MulticoderTwitchConnection.Config.Commands_Dict.get(Command).Invoker.invoke(null,"Server");
            }
            catch (Exception ex)
            {
                NLTI.LOGGER.error("Error When Running: {}",Command);
                NLTI.LOGGER.error("Caused By: ",ex);
            }
        }
        return 0;
    }

    private static int Reset(CommandContext<ServerCommandSource> context)
    {
        for(String U : MulticoderTwitchConnection.Config.Users)
        {
            MulticoderTwitchConnection.CHAT.sendMessage(U,"Next Level Twitch Integration Cooldowns Reset");
        }
        MulticoderTwitchConnection.Config.Commands_Dict.forEach((name,node) -> node.Cooldown = LocalDateTime.now());
        return 0;
    }

    private static int Stop(CommandContext<ServerCommandSource> context)
    {
        MulticoderTwitchConnection.Enabled = false;
        for(String U : MulticoderTwitchConnection.Config.Users){
            MulticoderTwitchConnection.CHAT.sendMessage(U,"Next Level Twitch Integration Has Stopped");
        }
        return 0;
    }

    private static int Start(CommandContext<ServerCommandSource> context)
    {
        MulticoderTwitchConnection.Enabled = true;
        for(String U : MulticoderTwitchConnection.Config.Users){
            MulticoderTwitchConnection.CHAT.sendMessage(U,"Next Level Twitch Integration Has Started");
        }
        return 0;
    }

}
