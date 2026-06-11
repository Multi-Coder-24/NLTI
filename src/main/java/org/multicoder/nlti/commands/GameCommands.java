package org.multicoder.nlti.commands;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.ChatFormatting;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import org.multicoder.nlti.commands.secure.SecureCommand;
import org.multicoder.nlti.config.ModConfig;
import org.multicoder.nlti.twitch.TwitchThread;

import static net.minecraft.commands.Commands.literal;

public class GameCommands {

    public static void register(CommandDispatcher<CommandSourceStack> dispatcher) {
        dispatcher.register(literal(Component.translatable("text.nlti.name").getString()).then(literal(Component.translatable("text.nlti.link").getString()).executes(SecureCommand::Link))).createBuilder().build();
        dispatcher.register(literal(Component.translatable("text.nlti.name").getString()).then(literal(Component.translatable("text.nlti.unlink").getString()).executes(GameCommands::UnLink))).createBuilder().build();
        dispatcher.register(literal(Component.translatable("text.nlti.name").getString()).then(literal(Component.translatable("text.nlti.start").getString()).executes(GameCommands::Start))).createBuilder().build();
        dispatcher.register(literal(Component.translatable("text.nlti.name").getString()).then(literal(Component.translatable("text.nlti.stop").getString()).executes(GameCommands::Stop))).createBuilder().build();
        dispatcher.register(literal(Component.translatable("text.nlti.name").getString()).then(literal(Component.translatable("text.nlti.reset").getString()).executes(GameCommands::Reset))).createBuilder().build();
    }

    private static int UnLink(CommandContext<CommandSourceStack> context) throws CommandSyntaxException {
        ModConfig.Token="***";
        ModConfig.SaveUpdateToken();
        context.getSource().getPlayerOrException().sendSystemMessage(Component.translatable("text.nlti.unlink_complete").withStyle(ChatFormatting.DARK_RED).withStyle(ChatFormatting.BOLD));
        return 0;
    }

    private static int Reset(CommandContext<CommandSourceStack> context) throws CommandSyntaxException  {
        ServerPlayer player = context.getSource().getPlayerOrException();
        TwitchThread.Reset();
        player.sendSystemMessage(Component.translatable("text.nlti.reset_complete").withStyle(ChatFormatting.YELLOW).withStyle(ChatFormatting.BOLD));
        return 0;
    }

    private static int Stop(CommandContext<CommandSourceStack> context) throws CommandSyntaxException  {
        ServerPlayer player = context.getSource().getPlayerOrException();
        TwitchThread.Disable();
        player.sendSystemMessage(Component.translatable("text.nlti.stop_complete").withStyle(ChatFormatting.DARK_RED).withStyle(ChatFormatting.BOLD));
        return 0;
    }

    private static int Start(CommandContext<CommandSourceStack> context) throws CommandSyntaxException  {
        ServerPlayer player = context.getSource().getPlayerOrException();
        TwitchThread.Enable();
        player.sendSystemMessage(Component.translatable("text.nlti.start_complete").withStyle(ChatFormatting.DARK_GREEN).withStyle(ChatFormatting.BOLD));
        return 0;
    }



}
