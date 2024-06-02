package org.multicoder.nlti.util;

import com.google.gson.JsonObject;

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
}
