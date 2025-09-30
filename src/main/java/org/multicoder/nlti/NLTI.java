package org.multicoder.nlti;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import org.apache.logging.log4j.*;
import org.multicoder.nlti.commands.NLTIGameCommands;
import org.multicoder.nlti.twitch.APIThread;
import org.multicoder.nlti.twitch.CommandBase;
import org.multicoder.nlti.twitch.commands.mobs.hostile.*;
import org.multicoder.nlti.twitch.commands.mobs.passive.*;
import org.multicoder.nlti.twitch.commands.player.*;
import org.multicoder.nlti.twitch.commands.world.*;
import java.util.*;


public class NLTI implements ModInitializer {

    public static final String MOD_ID = "nlti";
    public static final Logger LOG = LogManager.getLogger(MOD_ID);
    protected APIThread thread;
    public static List<CommandBase> commands = new ArrayList<>();
    @Override
    public void onInitialize() {
        LOG.info("[NLTI Minecraft] Initializing");
        ServerLifecycleEvents.SERVER_STARTING.register(server -> {
            thread = new APIThread();
            thread.Launcher(server);
            NLTI.LOG.info("[NLTI Minecraft] Server Started, Adding Commands");
            CommandHandler.AddWorldCommands(commands);
            CommandHandler.AddPlayerCommands(commands);
            CommandHandler.AddHostileMobCommands(commands);
            CommandHandler.AddPassiveMobCommands(commands);
        });
        CommandRegistrationCallback.EVENT.register(NLTIGameCommands::RegisterCommands);
    }
    public static class CommandHandler
    {
        public static void AddWorldCommands(List<CommandBase> commands) {
            commands.add(new Clear());
            commands.add(new Day());
            commands.add(new Night());
            commands.add(new KeepInventoryOff());
            commands.add(new KeepInventoryOn());
            commands.add(new Rain());
            commands.add(new Thunder());
        }
        public static void AddPlayerCommands(List<CommandBase> commands) {
            commands.add(new Death());
            commands.add(new Food());
            commands.add(new HealthMinus());
            commands.add(new HealthPlus());
            commands.add(new Hungry());
            commands.add(new Snatch());
            commands.add(new Speed50());
            commands.add(new Speed100());
            commands.add(new Speed150());
            commands.add(new Speed200());
            commands.add(new Steal());
        }
        public static void AddHostileMobCommands(List<CommandBase> commands)
        {
            commands.add(new Creeper());
            commands.add(new Evoker());
            commands.add(new Enderman());
            commands.add(new Pillager());
            commands.add(new Creeper());
            commands.add(new Ravager());
            commands.add(new Skeleton());
            commands.add(new Slime());
            commands.add(new Spider());
            commands.add(new Stray());
            commands.add(new Vindicator());
            commands.add(new Witch());
            commands.add(new Zombie());
        }
        public static void AddPassiveMobCommands(List<CommandBase> commands)
        {
            commands.add(new Bee());
            commands.add(new Chicken());
            commands.add(new Cow());
            commands.add(new Wolf());
            commands.add(new Fox());
            commands.add(new Frog());
            commands.add(new Goat());
            commands.add(new Llama());
            commands.add(new Ocelot());
            commands.add(new Panda());
            commands.add(new Pig());
            commands.add(new Rabbit());
            commands.add(new Sheep());
        }
    }
}


