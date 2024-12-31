package org.multicoder.nlti.gamecommands;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.context.CommandContext;
import net.minecraft.command.CommandRegistryAccess;
import net.minecraft.server.command.ServerCommandSource;
import org.multicoder.nlti.NLTI;
import org.multicoder.nlti.commands.CommandInstance;
import org.multicoder.nlti.twitch.MulticoderTwitchConnection;

import static net.minecraft.server.command.CommandManager.*;


public class NLTICommands
{
    public static void RegisterCommands(CommandDispatcher<ServerCommandSource> dispatcher, CommandRegistryAccess ignored, RegistrationEnvironment ignoredEnv)
    {
        dispatcher.register(literal("NLTI").then(literal("Start").executes(NLTICommands::Start))).createBuilder().build();
        dispatcher.register(literal("NLTI").then(literal("Stop").executes(NLTICommands::Stop))).createBuilder().build();
        dispatcher.register(literal("NLTI").then(literal("Reset").executes(NLTICommands::Reset))).createBuilder().build();
        dispatcher.register(literal("NLTI").then(literal("Test").then(argument("name", StringArgumentType.string()).executes(NLTICommands::Test)))).createBuilder().build();
    }

    private static int Test(CommandContext<ServerCommandSource> context)
    {
        try
        {
            new CommandInstance("trigger",new int[] {0,0},StringArgumentType.getString(context,"name")).Trigger("NLTI","NLTI");
            return 1;
        }
        catch (Exception e){
            NLTI.LOGGER.error("Error When Running Test Command", e);
            return -1;
        }
    }

    private static int Reset(CommandContext<ServerCommandSource> context)
    {
        for(String U : MulticoderTwitchConnection.Config.Users){
            MulticoderTwitchConnection.CHAT.sendMessage(U,"Next Level Twitch Integration Cooldowns Reset");
        }
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
