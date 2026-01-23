package org.multicoder.nlti.twitch.commands;

import net.minecraft.server.MinecraftServer;

public class CommandReader
{
    public static boolean TryRunCommand(String CommandName, String Username, MinecraftServer server){
        switch (CommandName){
            case "Mumbo":
                MumboCommand.PreTrigger(Username,server);
                return true;
            case "Tango":
                TangoCommand.PreTrigger(Username,server);
                return true;
            case "Scar":
                ScarCommand.PreTrigger(Username,server);
                return true;
        }
        return false;
    }
}
