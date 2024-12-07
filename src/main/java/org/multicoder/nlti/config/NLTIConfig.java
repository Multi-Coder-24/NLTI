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
    //  Mob Commands
    public int[] Creeper;
    public int[] Skeleton;
    public int[] Zombie;
    public int[] Enderman;
    public int[] Spider;
    public int[] Witch;
    public int[] Vindicator;
    public int[] Husk;
    public int[] Pillager;
    public int[] Piglin;
    public int[] Stray;
    //  Potion Commands
    public int[] Poison;
    public int[] Hunger;
    public int[] Weakness;
    public int[] Blindness;
    public int[] Slowness;
    public int[] Regeneration;
    public int[] Strength;
    public int[] Speed;
    public int[] Haste;
    public int[] Resistance;
    public int[] NightVision;
    //  Player Commands
    public int[] Steal;
    public int[] Snatch;
    public int[] Food;
    public int[] HealthD;
    public int[] HealthP;
    public int[] Speed25;
    public int[] Speed50;
    public int[] Speed100;
    public int[] Speed150;
    public int[] Speed200;
    public int[] Hungry;
    public int[] Death;
    public int[] Axed;
    public int[] Pickaxed;
    public int[] Sworded;
    public int[] Shoveled;
    public int[] Hoed;
    public int[] Cake;
    public int[] Sleepful;
    public int[] Sleepless;
    public int[] NoChests;
    public int[] Chests;
    //  World Commands
    public int[] Thunder;
    public int[] Rain;
    public int[] Clear;
    public int[] Night;
    public int[] Day;
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
        for(CommandInstance instance : MessageListener.Commands)
        {

        }
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
