package org.multicoder.nlti.util;

import com.google.gson.JsonObject;
import org.multicoder.nlti.NLTI;

import java.lang.reflect.Method;
import java.time.LocalDateTime;

public class CommandNodeBuilder
{
    public static JsonObject CreateNode(String Command,String Alias,String Description, int NormalCooldown,int ChaosCooldown)
    {
        JsonObject Node = new JsonObject();
        Node.addProperty("description",Description);
        Node.addProperty("command",Alias);
        Node.addProperty("command_id",Command);
        Node.addProperty("normal_cooldown",NormalCooldown);
        Node.addProperty("chaos_cooldown",ChaosCooldown);
        return Node;
    }
    public static Method FetchFromID(String ID)
    {
        try
        {
            ClassLoader CL = CommandNodeBuilder.class.getClassLoader();
            Class<?> Command = CL.loadClass("org.multicoder.nlti.commands." + ID);
            return Command.getDeclaredMethod("Trigger", String.class);
        }
        catch (Exception ex)
        {
            NLTI.LOGGER.error("Failed To Fetch Invoker For Command: {}", ID);
            NLTI.LOGGER.error("Caused By",ex);
        }
        return null;
    }

    public static class CommandNode
    {
        public String Name;
        public String ID;
        public int Normal;
        public int Chaos;
        public LocalDateTime Cooldown;
        public Method Invoker;

        public CommandNode(JsonObject input)
        {
            Name = input.get("command").getAsString();
            ID = input.get("command_id").getAsString();
            Normal = input.get("normal_cooldown").getAsInt();
            Chaos = input.get("chaos_cooldown").getAsInt();
            Cooldown = LocalDateTime.now();
            Invoker = CommandNodeBuilder.FetchFromID(ID);
        }
    }
}
