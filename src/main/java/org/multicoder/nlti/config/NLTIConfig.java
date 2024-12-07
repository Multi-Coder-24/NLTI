package org.multicoder.nlti.config;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.apache.commons.lang.ArrayUtils;
import org.multicoder.nlti.NLTI;
import org.multicoder.nlti.commands.CommandInstance;
import org.multicoder.nlti.twitch.MessageListener;

import java.util.ArrayList;
import java.util.List;

public class NLTIConfig
{
    private final String Token;
    private final String ClientID;
    private final String Redirect;
    protected final String Version;
    //  Properties
    public boolean ChaosMode;
    public String[] Users;

    public NLTIConfig(JsonObject Main, JsonObject Cooldowns)
    {

        //  Main Config
        Token = Main.get("Token").getAsString();
        ClientID = Main.get("clientID").getAsString();
        Redirect = Main.get("redirectURL").getAsString();
        Version = Main.get("Version").getAsString();
        ChaosMode = Main.get("ChaosMode").getAsBoolean();

        JsonArray Arr = Main.getAsJsonArray("Usernames");
        List<String> UsersL = new ArrayList<>();
        Arr.forEach(e -> UsersL.add(e.getAsString()));
        Users = UsersL.toArray(new String[0]);

        //  Commands
        JsonArray CommandsList = Cooldowns.getAsJsonArray("Commands");
        CommandsList.forEach(object ->
        {
            JsonObject command = object.getAsJsonObject();
            String CommandID = command.get("CommandID").getAsString().split("\\|")[0];
            String Trigger = command.get("Trigger").getAsString();
            int NormalCooldown = command.get("NormalCooldown").getAsInt();
            int ChaosCooldown = command.get("ChaosCooldown").getAsInt();
            try
            {
                MessageListener.Commands.add(new CommandInstance(Trigger,new int[] {NormalCooldown,ChaosCooldown},CommandID));
            }
            catch(Exception e){
                NLTI.LOGGER.error("Error Adding Command",e);
            }
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
