package org.multicoder.nlti.commands;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;

import static net.minecraft.server.command.CommandManager.literal;

public class GameCommands {

    public static void register(CommandDispatcher<ServerCommandSource> dispatcher) {
        dispatcher.register(literal(Text.translatable("text.nlti.name").getString()).then(literal(Text.translatable("text.nlti.link").getString()).executes(SecureCommand::Link))).createBuilder().build();
        dispatcher.register(literal(Text.translatable("text.nlti.name").getString()).then(literal(Text.translatable("text.nlti.start").getString()).executes(GameCommands::Start))).createBuilder().build();
        dispatcher.register(literal(Text.translatable("text.nlti.name").getString()).then(literal(Text.translatable("text.nlti.stop").getString()).executes(GameCommands::Stop))).createBuilder().build();
        dispatcher.register(literal(Text.translatable("text.nlti.name").getString()).then(literal(Text.translatable("text.nlti.reset").getString()).executes(GameCommands::Reset))).createBuilder().build();
    }

    private static int Reset(CommandContext<ServerCommandSource> context) throws CommandSyntaxException  {
        ServerPlayerEntity player = context.getSource().getPlayerOrThrow();
        player.sendMessage(Text.literal("Reset Command"));
        return 0;
    }

    private static int Stop(CommandContext<ServerCommandSource> context) throws CommandSyntaxException  {
        ServerPlayerEntity player = context.getSource().getPlayerOrThrow();
        player.sendMessage(Text.literal("Stop Command"));
        return 0;
    }

    private static int Start(CommandContext<ServerCommandSource> context) throws CommandSyntaxException  {
        ServerPlayerEntity player = context.getSource().getPlayerOrThrow();
        player.sendMessage(Text.literal("Start Command"));
        return 0;
    }



}
