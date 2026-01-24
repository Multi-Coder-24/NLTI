package org.multicoder.nlti.server;

import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.context.CommandContext;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.Text;
import org.multicoder.nlti.twitch.CommandReader;

public class GameCommands
{
    public static int TestCommand(CommandContext<ServerCommandSource> context) {
        MinecraftServer server = context.getSource().getServer();
        String Username = "Server";
        String Name = StringArgumentType.getString(context,"name");
        if(CommandReader.TryRunCommand(Name,Username,server)){
           context.getSource().sendMessage(Text.translatable("text.nlti.test_success"));
        }
        else {
            context.getSource().sendMessage(Text.translatable("text.nlti.test_failed"));
        }
        return 0;
    }
}
