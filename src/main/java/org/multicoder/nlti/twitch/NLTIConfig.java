package org.multicoder.nlti.twitch;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import org.apache.commons.lang.ArrayUtils;

import java.util.ArrayList;
import java.util.List;

public class NLTIConfig
{
    private final String Token;
    private final String ClientID;
    private final String Redirect;
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
    //  World Commands
    public int[] Thunder;
    public int[] Rain;
    public int[] Clear;
    public int[] Night;
    public int[] Day;
    //  Properties
    public boolean ChaosMode;
    public String[] Users;

    public NLTIConfig(JsonReader reader)
    {
        //  Loading JsonReader Data into JsonObject
        Gson G = new Gson();
        JsonObject Object = G.fromJson(reader, TypeToken.get(JsonObject.class));

        //  Read Token
        Token = Object.get("Token").getAsString();
        ClientID = Object.get("clientID").getAsString();
        Redirect = Object.get("redirectURL").getAsString();

        //  Saving Config Vars
        JsonArray Arr = Object.getAsJsonArray("Usernames");
        List<String> UsersL = new ArrayList<>();
        Arr.forEach(e -> UsersL.add(e.getAsString()));
        Users = UsersL.toArray(new String[0]);
        ChaosMode = Object.get("ChaosMode").getAsBoolean();

        //  Retrieving Cooldowns
        Arr = Object.getAsJsonArray("CreeperCooldown");
        List<Integer> L = new ArrayList<>();
        Arr.forEach(e -> L.add(e.getAsInt()));
        Creeper = ArrayUtils.toPrimitive(L.toArray(new Integer[0]));
        L.clear();

        Arr = Object.getAsJsonArray("SkeletonCooldown");
        Arr.forEach(e ->L.add(e.getAsInt()));
        Skeleton = ArrayUtils.toPrimitive(L.toArray(new Integer[0]));
        L.clear();

        Arr = Object.getAsJsonArray("ZombieCooldown");
        Arr.forEach(e ->L.add(e.getAsInt()));
        Zombie = ArrayUtils.toPrimitive(L.toArray(new Integer[0]));
        L.clear();

        Arr = Object.getAsJsonArray("EndermanCooldown");
        Arr.forEach(e ->L.add(e.getAsInt()));
        Enderman = ArrayUtils.toPrimitive(L.toArray(new Integer[0]));
        L.clear();

        Arr = Object.getAsJsonArray("SpiderCooldown");
        Arr.forEach(e ->L.add(e.getAsInt()));
        Spider = ArrayUtils.toPrimitive(L.toArray(new Integer[0]));
        L.clear();

        Arr = Object.getAsJsonArray("WitchCooldown");
        Arr.forEach(e ->L.add(e.getAsInt()));
        Witch = ArrayUtils.toPrimitive(L.toArray(new Integer[0]));
        L.clear();

        Arr = Object.getAsJsonArray("VindicatorCooldown");
        Arr.forEach(e ->L.add(e.getAsInt()));
        Vindicator = ArrayUtils.toPrimitive(L.toArray(new Integer[0]));
        L.clear();

        Arr = Object.getAsJsonArray("HuskCooldown");
        Arr.forEach(e ->L.add(e.getAsInt()));
        Husk = ArrayUtils.toPrimitive(L.toArray(new Integer[0]));
        L.clear();

        Arr = Object.getAsJsonArray("PillagerCooldown");
        Arr.forEach(e ->L.add(e.getAsInt()));
        Pillager = ArrayUtils.toPrimitive(L.toArray(new Integer[0]));
        L.clear();

        Arr = Object.getAsJsonArray("PiglinCooldown");
        Arr.forEach(e ->L.add(e.getAsInt()));
        Piglin = ArrayUtils.toPrimitive(L.toArray(new Integer[0]));
        L.clear();

        Arr = Object.getAsJsonArray("StrayCooldown");
        Arr.forEach(e ->L.add(e.getAsInt()));
        Stray = ArrayUtils.toPrimitive(L.toArray(new Integer[0]));
        L.clear();

        Arr = Object.getAsJsonArray("PoisonCooldown");
        Arr.forEach(e ->L.add(e.getAsInt()));
        Poison = ArrayUtils.toPrimitive(L.toArray(new Integer[0]));
        L.clear();

        Arr = Object.getAsJsonArray("HungerCooldown");
        Arr.forEach(e ->L.add(e.getAsInt()));
        Hunger = ArrayUtils.toPrimitive(L.toArray(new Integer[0]));
        L.clear();

        Arr = Object.getAsJsonArray("WeaknessCooldown");
        Arr.forEach(e ->L.add(e.getAsInt()));
        Weakness = ArrayUtils.toPrimitive(L.toArray(new Integer[0]));
        L.clear();

        Arr = Object.getAsJsonArray("BlindCooldown");
        Arr.forEach(e ->L.add(e.getAsInt()));
        Blindness = ArrayUtils.toPrimitive(L.toArray(new Integer[0]));
        L.clear();

        Arr = Object.getAsJsonArray("SlowCooldown");
        Arr.forEach(e ->L.add(e.getAsInt()));
        Slowness = ArrayUtils.toPrimitive(L.toArray(new Integer[0]));
        L.clear();

        Arr = Object.getAsJsonArray("RegenCooldown");
        Arr.forEach(e ->L.add(e.getAsInt()));
        Regeneration = ArrayUtils.toPrimitive(L.toArray(new Integer[0]));
        L.clear();

        Arr = Object.getAsJsonArray("StrengthCooldown");
        Arr.forEach(e ->L.add(e.getAsInt()));
        Strength = ArrayUtils.toPrimitive(L.toArray(new Integer[0]));
        L.clear();

        Arr = Object.getAsJsonArray("SpeedCooldown");
        Arr.forEach(e ->L.add(e.getAsInt()));
        Speed = ArrayUtils.toPrimitive(L.toArray(new Integer[0]));
        L.clear();

        Arr = Object.getAsJsonArray("HasteCooldown");
        Arr.forEach(e ->L.add(e.getAsInt()));
        Haste = ArrayUtils.toPrimitive(L.toArray(new Integer[0]));
        L.clear();

        Arr = Object.getAsJsonArray("ResistanceCooldown");
        Arr.forEach(e ->L.add(e.getAsInt()));
        Resistance = ArrayUtils.toPrimitive(L.toArray(new Integer[0]));
        L.clear();

        Arr = Object.getAsJsonArray("NightVisionCooldown");
        Arr.forEach(e ->L.add(e.getAsInt()));
        NightVision = ArrayUtils.toPrimitive(L.toArray(new Integer[0]));
        L.clear();

        Arr = Object.getAsJsonArray("StealCooldown");
        Arr.forEach(e ->L.add(e.getAsInt()));
        Steal = ArrayUtils.toPrimitive(L.toArray(new Integer[0]));
        L.clear();

        Arr = Object.getAsJsonArray("SnatchCooldown");
        Arr.forEach(e ->L.add(e.getAsInt()));
        Snatch = ArrayUtils.toPrimitive(L.toArray(new Integer[0]));
        L.clear();

        Arr = Object.getAsJsonArray("FoodCooldown");
        Arr.forEach(e ->L.add(e.getAsInt()));
        Food = ArrayUtils.toPrimitive(L.toArray(new Integer[0]));
        L.clear();

        Arr = Object.getAsJsonArray("NightCooldown");
        Arr.forEach(e ->L.add(e.getAsInt()));
        Night = ArrayUtils.toPrimitive(L.toArray(new Integer[0]));
        L.clear();

        Arr = Object.getAsJsonArray("DayCooldown");
        Arr.forEach(e ->L.add(e.getAsInt()));
        Day = ArrayUtils.toPrimitive(L.toArray(new Integer[0]));
        L.clear();

        Arr = Object.getAsJsonArray("HealthD");
        Arr.forEach(e ->L.add(e.getAsInt()));
        HealthD = ArrayUtils.toPrimitive(L.toArray(new Integer[0]));
        L.clear();

        Arr = Object.getAsJsonArray("HealthP");
        Arr.forEach(e ->L.add(e.getAsInt()));
        HealthP = ArrayUtils.toPrimitive(L.toArray(new Integer[0]));
        L.clear();

        Arr = Object.getAsJsonArray("Speed25");
        Arr.forEach(e ->L.add(e.getAsInt()));
        Speed25 = ArrayUtils.toPrimitive(L.toArray(new Integer[0]));
        L.clear();

        Arr = Object.getAsJsonArray("Speed50");
        Arr.forEach(e ->L.add(e.getAsInt()));
        Speed50 = ArrayUtils.toPrimitive(L.toArray(new Integer[0]));
        L.clear();

        Arr = Object.getAsJsonArray("Speed100");
        Arr.forEach(e ->L.add(e.getAsInt()));
        Speed100 = ArrayUtils.toPrimitive(L.toArray(new Integer[0]));
        L.clear();

        Arr = Object.getAsJsonArray("Speed150");
        Arr.forEach(e ->L.add(e.getAsInt()));
        Speed150 = ArrayUtils.toPrimitive(L.toArray(new Integer[0]));
        L.clear();

        Arr = Object.getAsJsonArray("Speed200");
        Arr.forEach(e ->L.add(e.getAsInt()));
        Speed200 = ArrayUtils.toPrimitive(L.toArray(new Integer[0]));
        L.clear();

        Arr = Object.getAsJsonArray("Hungry");
        Arr.forEach(e ->L.add(e.getAsInt()));
        Hungry = ArrayUtils.toPrimitive(L.toArray(new Integer[0]));
        L.clear();

        Arr = Object.getAsJsonArray("Thunder");
        Arr.forEach(e ->L.add(e.getAsInt()));
        Thunder = ArrayUtils.toPrimitive(L.toArray(new Integer[0]));
        L.clear();

        Arr = Object.getAsJsonArray("Rain");
        Arr.forEach(e ->L.add(e.getAsInt()));
        Rain = ArrayUtils.toPrimitive(L.toArray(new Integer[0]));
        L.clear();

        Arr = Object.getAsJsonArray("Clear");
        Arr.forEach(e ->L.add(e.getAsInt()));
        Clear = ArrayUtils.toPrimitive(L.toArray(new Integer[0]));
        L.clear();

        Arr = Object.getAsJsonArray("Death");
        Arr.forEach(e ->L.add(e.getAsInt()));
        Death = ArrayUtils.toPrimitive(L.toArray(new Integer[0]));
        L.clear();

        Arr = Object.getAsJsonArray("Axed");
        Arr.forEach(e ->L.add(e.getAsInt()));
        Axed = ArrayUtils.toPrimitive(L.toArray(new Integer[0]));
        L.clear();

        Arr = Object.getAsJsonArray("Pickaxed");
        Arr.forEach(e ->L.add(e.getAsInt()));
        Pickaxed = ArrayUtils.toPrimitive(L.toArray(new Integer[0]));
        L.clear();

        Arr = Object.getAsJsonArray("Shoveled");
        Arr.forEach(e ->L.add(e.getAsInt()));
        Shoveled = ArrayUtils.toPrimitive(L.toArray(new Integer[0]));
        L.clear();

        Arr = Object.getAsJsonArray("Sworded");
        Arr.forEach(e ->L.add(e.getAsInt()));
        Sworded = ArrayUtils.toPrimitive(L.toArray(new Integer[0]));
        L.clear();

        Arr = Object.getAsJsonArray("Hoed");
        Arr.forEach(e ->L.add(e.getAsInt()));
        Hoed = ArrayUtils.toPrimitive(L.toArray(new Integer[0]));
        L.clear();

        Arr = Object.getAsJsonArray("Cake");
        Arr.forEach(e ->L.add(e.getAsInt()));
        Cake = ArrayUtils.toPrimitive(L.toArray(new Integer[0]));
        L.clear();

        Arr = Object.getAsJsonArray("Sleepful");
        Arr.forEach(e ->L.add(e.getAsInt()));
        Sleepful = ArrayUtils.toPrimitive(L.toArray(new Integer[0]));
        L.clear();

        Arr = Object.getAsJsonArray("Sleepless");
        Arr.forEach(e ->L.add(e.getAsInt()));
        Sleepless = ArrayUtils.toPrimitive(L.toArray(new Integer[0]));
        L.clear();
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
