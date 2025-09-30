package org.multicoder.nlti.commands;

import com.mojang.brigadier.context.CommandContext;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.Text;
import org.multicoder.nlti.NLTI;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

public class TestCommand
{

    public static int run(CommandContext<ServerCommandSource> context)
    {
        try{
            String Command = context.getArgument("CMD", String.class);
            AtomicBoolean HasTriggered = new AtomicBoolean(false);
            if(NLTI.commands.stream().anyMatch(x -> Objects.equals(x.TRIGGER,"!MC-" + Command))){
                NLTI.commands.stream().filter(x -> Objects.equals(x.TRIGGER,"!MC-" + Command)).findFirst().ifPresent(x -> HasTriggered.set(x.Trigger(context.getSource().getServer(),"NLTI")));
                context.getSource().sendMessage(Text.literal("Has Command Triggered: " + HasTriggered.get()));
            }
            return 0;
        }
        catch(Exception ex){
            NLTI.LOG.error("[NLTI] Error when attempting to run command, ",ex);
            return -1;
        }
    }
}
