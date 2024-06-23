package org.multicoder.nlti.config;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.multicoder.nlti.util.CommandNodeBuilder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class NLTIConfig
{
    private final String Token;
    private final String ClientID;
    private final String Redirect;
    protected final String Version;
    public boolean ChaosMode;
    public String[] Users;
    //  Mob Commands
    public HashMap<String, CommandNodeBuilder.CommandNode> Commands_Dict;


    public NLTIConfig(JsonObject Main, JsonObject Commands)
    {

        //  Read Token
        Token = Main.get("Token").getAsString();
        ClientID = Main.get("clientID").getAsString();
        Redirect = Main.get("redirectURL").getAsString();
        Version = Main.get("Version").getAsString();
        ChaosMode = Main.get("ChaosMode").getAsBoolean();

        JsonArray Arr = Main.getAsJsonArray("Usernames");
        List<String> UsersL = new ArrayList<>();
        Arr.forEach(e -> UsersL.add(e.getAsString()));
        Users = UsersL.toArray(new String[0]);

        Commands_Dict = new HashMap<>();
        JsonArray CommandsArray = Commands.get("Commands").getAsJsonArray();
        CommandsArray.forEach(jsonElement ->
        {
            JsonObject Object = (JsonObject) jsonElement;
            Commands_Dict.put(Object.get("command").getAsString(),new CommandNodeBuilder.CommandNode(Object));
        });
    }

    public String getToken(Class<?> invoker)
    {
        if(invoker.getPackageName().startsWith("org.multicoder.nlti"))
        {
            return Token;
        }
        else{
            return null;
        }
    }
    public String getClientID(Class<?> invoker)
    {
        if(invoker.getPackageName().startsWith("org.multicoder.nlti"))
        {
            return ClientID;
        }
        else{
            return null;
        }
    }

    public String getRedirect(Class<?> invoker)
    {
        if(invoker.getPackageName().startsWith("org.multicoder.nlti"))
        {
            return Redirect;
        }
        else{
            return null;
        }
    }
}
