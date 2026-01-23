package org.multicoder.nlti.server;

import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.context.CommandContext;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.command.ServerCommandSource;
import org.multicoder.nlti.twitch.commands.CommandReader;

public class GameCommands
{
    public static int TestCommand(CommandContext<ServerCommandSource> context) {
        MinecraftServer server = context.getSource().getServer();
        String Username = "Server";
        String Name = StringArgumentType.getString(context,"name");
        CommandReader.TryRunCommand(Name,Username,server);
        return 0;
    }
}
