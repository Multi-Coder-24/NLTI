package org.multicoder.nlti.gamecommands;

import com.mojang.authlib.Environment;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.context.CommandContext;
import net.minecraft.command.CommandRegistryAccess;
import net.minecraft.server.command.ServerCommandSource;
import org.multicoder.nlti.cooldowns.CooldownManager;
import org.multicoder.nlti.twitch.MulticoderTwitchConnection;

import static net.minecraft.server.command.CommandManager.*;

public class NLTICommands
{
    public static void RegisterCommands(CommandDispatcher<ServerCommandSource> dispatcher, CommandRegistryAccess access, RegistrationEnvironment env)
    {
        dispatcher.register(literal("NLTI").then(literal("Start").executes(NLTICommands::Start))).createBuilder().build();
        dispatcher.register(literal("NLTI").then(literal("Stop").executes(NLTICommands::Stop))).createBuilder().build();
        dispatcher.register(literal("NLTI").then(literal("Reset").executes(NLTICommands::Reset))).createBuilder().build();
    }

    private static int Reset(CommandContext<ServerCommandSource> context)
    {
        for(String U : MulticoderTwitchConnection.Config.Users){
            MulticoderTwitchConnection.CHAT.sendMessage(U,"Next Level Twitch Integration Cooldowns Reset");
        }
        CooldownManager.Init();
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
