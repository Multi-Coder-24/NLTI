package org.multicoder.nlti.commands;

import com.mojang.brigadier.context.CommandContext;
import net.minecraft.entity.mob.RavagerEntity;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.Text;
import org.multicoder.nlti.NLTI;
import org.multicoder.nlti.twitch.commands.mobs.hostile.*;
import org.multicoder.nlti.twitch.commands.mobs.passive.*;

public class TestCommand
{

    public static int run(CommandContext<ServerCommandSource> context)
    {
        try{
            String Command = context.getArgument("CMD", String.class);
            boolean HasTriggered;
            switch (Command){
                case "Sheep":
                    HasTriggered = Sheep.Trigger(context.getSource().getServer(),"NLTI");
                    context.getSource().sendMessage(Text.literal("Triggered Command: " + HasTriggered));
                    break;
                case "Cow":
                    HasTriggered = Cow.Trigger(context.getSource().getServer(),"NLTI");
                    context.getSource().sendMessage(Text.literal("Triggered Command: " + HasTriggered));
                    break;
                case "Pig":
                    HasTriggered = Pig.Trigger(context.getSource().getServer(),"NLTI");
                    context.getSource().sendMessage(Text.literal("Triggered Command: " + HasTriggered));
                    break;
                case "Chicken":
                    HasTriggered = Chicken.Trigger(context.getSource().getServer(),"NLTI");
                    context.getSource().sendMessage(Text.literal("Triggered Command: " + HasTriggered));
                    break;
                case "Bee":
                    HasTriggered = Bee.Trigger(context.getSource().getServer(),"NLTI");
                    context.getSource().sendMessage(Text.literal("Triggered Command: " + HasTriggered));
                    break;
                case "Frog":
                    HasTriggered = Frog.Trigger(context.getSource().getServer(),"NLTI");
                    context.getSource().sendMessage(Text.literal("Triggered Command: " + HasTriggered));
                    break;
                case "Fox":
                    HasTriggered = Fox.Trigger(context.getSource().getServer(),"NLTI");
                    context.getSource().sendMessage(Text.literal("Triggered Command: " + HasTriggered));
                    break;
                case "Goat":
                    HasTriggered = Goat.Trigger(context.getSource().getServer(),"NLTI");
                    context.getSource().sendMessage(Text.literal("Triggered Command: " + HasTriggered));
                    break;
                case "Llama":
                    HasTriggered = Llama.Trigger(context.getSource().getServer(),"NLTI");
                    context.getSource().sendMessage(Text.literal("Triggered Command: " + HasTriggered));
                    break;
                case "Ocelot":
                    HasTriggered = Ocelot.Trigger(context.getSource().getServer(),"NLTI");
                    context.getSource().sendMessage(Text.literal("Triggered Command: " + HasTriggered));
                    break;
                case "Panda":
                    HasTriggered = Panda.Trigger(context.getSource().getServer(),"NLTI");
                    context.getSource().sendMessage(Text.literal("Triggered Command: " + HasTriggered));
                    break;
                case "Rabbit":
                    HasTriggered = Rabbit.Trigger(context.getSource().getServer(),"NLTI");
                    context.getSource().sendMessage(Text.literal("Triggered Command: " + HasTriggered));
                    break;
                case "Wolf":
                    HasTriggered = Wolf.Trigger(context.getSource().getServer(),"NLTI");
                    context.getSource().sendMessage(Text.literal("Triggered Command: " + HasTriggered));
                    break;
                case "Zombie":
                    HasTriggered = Zombie.Trigger(context.getSource().getServer(),"NLTI");
                    context.getSource().sendMessage(Text.literal("Triggered Command: " + HasTriggered));
                    break;
                case "Witch":
                    HasTriggered = Witch.Trigger(context.getSource().getServer(),"NLTI");
                    context.getSource().sendMessage(Text.literal("Triggered Command: " + HasTriggered));
                    break;
                case "Vindicator":
                    HasTriggered = Vindicator.Trigger(context.getSource().getServer(),"NLTI");
                    context.getSource().sendMessage(Text.literal("Triggered Command: " + HasTriggered));
                    break;
                case "Stray":
                    HasTriggered = Stray.Trigger(context.getSource().getServer(),"NLTI");
                    context.getSource().sendMessage(Text.literal("Triggered Command: " + HasTriggered));
                    break;
                case "Spider":
                    HasTriggered = Spider.Trigger(context.getSource().getServer(),"NLTI");
                    context.getSource().sendMessage(Text.literal("Triggered Command: " + HasTriggered));
                    break;
                case "Slime":
                    HasTriggered = Slime.Trigger(context.getSource().getServer(),"NLTI");
                    context.getSource().sendMessage(Text.literal("Triggered Command: " + HasTriggered));
                    break;
                case "Skeleton":
                    HasTriggered = Skeleton.Trigger(context.getSource().getServer(),"NLTI");
                    context.getSource().sendMessage(Text.literal("Triggered Command: " + HasTriggered));
                    break;
                case "Ravager":
                    HasTriggered = Ravager.Trigger(context.getSource().getServer(),"NLTI");
                    context.getSource().sendMessage(Text.literal("Triggered Command: " + HasTriggered));
                    break;
                case "Pillager":
                    HasTriggered = Pillager.Trigger(context.getSource().getServer(),"NLTI");
                    context.getSource().sendMessage(Text.literal("Triggered Command: " + HasTriggered));
                    break;
                case "Evoker":
                    HasTriggered = Evoker.Trigger(context.getSource().getServer(),"NLTI");
                    context.getSource().sendMessage(Text.literal("Triggered Command: " + HasTriggered));
                    break;
                case "Enderman":
                    HasTriggered = Enderman.Trigger(context.getSource().getServer(),"NLTI");
                    context.getSource().sendMessage(Text.literal("Triggered Command: " + HasTriggered));
                    break;
                case "Creeper":
                    HasTriggered = Creeper.Trigger(context.getSource().getServer(),"NLTI");
                    context.getSource().sendMessage(Text.literal("Triggered Command: " + HasTriggered));
                    break;
            }
            return 0;
        }
        catch(Exception ex){
            NLTI.LOG.error("[NLTI] Error when attempting to run command, ",ex);
            return -1;
        }
    }
}
