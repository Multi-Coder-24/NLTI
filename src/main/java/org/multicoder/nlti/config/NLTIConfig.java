package org.multicoder.nlti.config;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.apache.commons.lang.ArrayUtils;

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

        Arr = Cooldowns.getAsJsonArray("CreeperCooldown");
        List<Integer> L = new ArrayList<>();
        Arr.forEach(e -> L.add(e.getAsInt()));
        Creeper = ArrayUtils.toPrimitive(L.toArray(new Integer[0]));
        L.clear();

        Arr = Cooldowns.getAsJsonArray("SkeletonCooldown");
        Arr.forEach(e ->L.add(e.getAsInt()));
        Skeleton = ArrayUtils.toPrimitive(L.toArray(new Integer[0]));
        L.clear();

        Arr = Cooldowns.getAsJsonArray("ZombieCooldown");
        Arr.forEach(e ->L.add(e.getAsInt()));
        Zombie = ArrayUtils.toPrimitive(L.toArray(new Integer[0]));
        L.clear();

        Arr = Cooldowns.getAsJsonArray("EndermanCooldown");
        Arr.forEach(e ->L.add(e.getAsInt()));
        Enderman = ArrayUtils.toPrimitive(L.toArray(new Integer[0]));
        L.clear();

        Arr = Cooldowns.getAsJsonArray("SpiderCooldown");
        Arr.forEach(e ->L.add(e.getAsInt()));
        Spider = ArrayUtils.toPrimitive(L.toArray(new Integer[0]));
        L.clear();

        Arr = Cooldowns.getAsJsonArray("WitchCooldown");
        Arr.forEach(e ->L.add(e.getAsInt()));
        Witch = ArrayUtils.toPrimitive(L.toArray(new Integer[0]));
        L.clear();

        Arr = Cooldowns.getAsJsonArray("VindicatorCooldown");
        Arr.forEach(e ->L.add(e.getAsInt()));
        Vindicator = ArrayUtils.toPrimitive(L.toArray(new Integer[0]));
        L.clear();

        Arr = Cooldowns.getAsJsonArray("HuskCooldown");
        Arr.forEach(e ->L.add(e.getAsInt()));
        Husk = ArrayUtils.toPrimitive(L.toArray(new Integer[0]));
        L.clear();

        Arr = Cooldowns.getAsJsonArray("PillagerCooldown");
        Arr.forEach(e ->L.add(e.getAsInt()));
        Pillager = ArrayUtils.toPrimitive(L.toArray(new Integer[0]));
        L.clear();

        Arr = Cooldowns.getAsJsonArray("PiglinCooldown");
        Arr.forEach(e ->L.add(e.getAsInt()));
        Piglin = ArrayUtils.toPrimitive(L.toArray(new Integer[0]));
        L.clear();

        Arr = Cooldowns.getAsJsonArray("StrayCooldown");
        Arr.forEach(e ->L.add(e.getAsInt()));
        Stray = ArrayUtils.toPrimitive(L.toArray(new Integer[0]));
        L.clear();

        Arr = Cooldowns.getAsJsonArray("PoisonCooldown");
        Arr.forEach(e ->L.add(e.getAsInt()));
        Poison = ArrayUtils.toPrimitive(L.toArray(new Integer[0]));
        L.clear();

        Arr = Cooldowns.getAsJsonArray("HungerCooldown");
        Arr.forEach(e ->L.add(e.getAsInt()));
        Hunger = ArrayUtils.toPrimitive(L.toArray(new Integer[0]));
        L.clear();

        Arr = Cooldowns.getAsJsonArray("WeaknessCooldown");
        Arr.forEach(e ->L.add(e.getAsInt()));
        Weakness = ArrayUtils.toPrimitive(L.toArray(new Integer[0]));
        L.clear();

        Arr = Cooldowns.getAsJsonArray("BlindCooldown");
        Arr.forEach(e ->L.add(e.getAsInt()));
        Blindness = ArrayUtils.toPrimitive(L.toArray(new Integer[0]));
        L.clear();

        Arr = Cooldowns.getAsJsonArray("SlowCooldown");
        Arr.forEach(e ->L.add(e.getAsInt()));
        Slowness = ArrayUtils.toPrimitive(L.toArray(new Integer[0]));
        L.clear();

        Arr = Cooldowns.getAsJsonArray("RegenCooldown");
        Arr.forEach(e ->L.add(e.getAsInt()));
        Regeneration = ArrayUtils.toPrimitive(L.toArray(new Integer[0]));
        L.clear();

        Arr = Cooldowns.getAsJsonArray("StrengthCooldown");
        Arr.forEach(e ->L.add(e.getAsInt()));
        Strength = ArrayUtils.toPrimitive(L.toArray(new Integer[0]));
        L.clear();

        Arr = Cooldowns.getAsJsonArray("SpeedCooldown");
        Arr.forEach(e ->L.add(e.getAsInt()));
        Speed = ArrayUtils.toPrimitive(L.toArray(new Integer[0]));
        L.clear();

        Arr = Cooldowns.getAsJsonArray("HasteCooldown");
        Arr.forEach(e ->L.add(e.getAsInt()));
        Haste = ArrayUtils.toPrimitive(L.toArray(new Integer[0]));
        L.clear();

        Arr = Cooldowns.getAsJsonArray("ResistanceCooldown");
        Arr.forEach(e ->L.add(e.getAsInt()));
        Resistance = ArrayUtils.toPrimitive(L.toArray(new Integer[0]));
        L.clear();

        Arr = Cooldowns.getAsJsonArray("NightVisionCooldown");
        Arr.forEach(e ->L.add(e.getAsInt()));
        NightVision = ArrayUtils.toPrimitive(L.toArray(new Integer[0]));
        L.clear();

        Arr = Cooldowns.getAsJsonArray("StealCooldown");
        Arr.forEach(e ->L.add(e.getAsInt()));
        Steal = ArrayUtils.toPrimitive(L.toArray(new Integer[0]));
        L.clear();

        Arr = Cooldowns.getAsJsonArray("SnatchCooldown");
        Arr.forEach(e ->L.add(e.getAsInt()));
        Snatch = ArrayUtils.toPrimitive(L.toArray(new Integer[0]));
        L.clear();

        Arr = Cooldowns.getAsJsonArray("FoodCooldown");
        Arr.forEach(e ->L.add(e.getAsInt()));
        Food = ArrayUtils.toPrimitive(L.toArray(new Integer[0]));
        L.clear();

        Arr = Cooldowns.getAsJsonArray("NightCooldown");
        Arr.forEach(e ->L.add(e.getAsInt()));
        Night = ArrayUtils.toPrimitive(L.toArray(new Integer[0]));
        L.clear();

        Arr = Cooldowns.getAsJsonArray("DayCooldown");
        Arr.forEach(e ->L.add(e.getAsInt()));
        Day = ArrayUtils.toPrimitive(L.toArray(new Integer[0]));
        L.clear();

        Arr = Cooldowns.getAsJsonArray("HealthD");
        Arr.forEach(e ->L.add(e.getAsInt()));
        HealthD = ArrayUtils.toPrimitive(L.toArray(new Integer[0]));
        L.clear();

        Arr = Cooldowns.getAsJsonArray("HealthP");
        Arr.forEach(e ->L.add(e.getAsInt()));
        HealthP = ArrayUtils.toPrimitive(L.toArray(new Integer[0]));
        L.clear();

        Arr = Cooldowns.getAsJsonArray("Speed25");
        Arr.forEach(e ->L.add(e.getAsInt()));
        Speed25 = ArrayUtils.toPrimitive(L.toArray(new Integer[0]));
        L.clear();

        Arr = Cooldowns.getAsJsonArray("Speed50");
        Arr.forEach(e ->L.add(e.getAsInt()));
        Speed50 = ArrayUtils.toPrimitive(L.toArray(new Integer[0]));
        L.clear();

        Arr = Cooldowns.getAsJsonArray("Speed100");
        Arr.forEach(e ->L.add(e.getAsInt()));
        Speed100 = ArrayUtils.toPrimitive(L.toArray(new Integer[0]));
        L.clear();

        Arr = Cooldowns.getAsJsonArray("Speed150");
        Arr.forEach(e ->L.add(e.getAsInt()));
        Speed150 = ArrayUtils.toPrimitive(L.toArray(new Integer[0]));
        L.clear();

        Arr = Cooldowns.getAsJsonArray("Speed200");
        Arr.forEach(e ->L.add(e.getAsInt()));
        Speed200 = ArrayUtils.toPrimitive(L.toArray(new Integer[0]));
        L.clear();

        Arr = Cooldowns.getAsJsonArray("Hungry");
        Arr.forEach(e ->L.add(e.getAsInt()));
        Hungry = ArrayUtils.toPrimitive(L.toArray(new Integer[0]));
        L.clear();

        Arr = Cooldowns.getAsJsonArray("Thunder");
        Arr.forEach(e ->L.add(e.getAsInt()));
        Thunder = ArrayUtils.toPrimitive(L.toArray(new Integer[0]));
        L.clear();

        Arr = Cooldowns.getAsJsonArray("Rain");
        Arr.forEach(e ->L.add(e.getAsInt()));
        Rain = ArrayUtils.toPrimitive(L.toArray(new Integer[0]));
        L.clear();

        Arr = Cooldowns.getAsJsonArray("Clear");
        Arr.forEach(e ->L.add(e.getAsInt()));
        Clear = ArrayUtils.toPrimitive(L.toArray(new Integer[0]));
        L.clear();

        Arr = Cooldowns.getAsJsonArray("Death");
        Arr.forEach(e ->L.add(e.getAsInt()));
        Death = ArrayUtils.toPrimitive(L.toArray(new Integer[0]));
        L.clear();

        Arr = Cooldowns.getAsJsonArray("Axed");
        Arr.forEach(e ->L.add(e.getAsInt()));
        Axed = ArrayUtils.toPrimitive(L.toArray(new Integer[0]));
        L.clear();

        Arr = Cooldowns.getAsJsonArray("Pickaxed");
        Arr.forEach(e ->L.add(e.getAsInt()));
        Pickaxed = ArrayUtils.toPrimitive(L.toArray(new Integer[0]));
        L.clear();

        Arr = Cooldowns.getAsJsonArray("Shoveled");
        Arr.forEach(e ->L.add(e.getAsInt()));
        Shoveled = ArrayUtils.toPrimitive(L.toArray(new Integer[0]));
        L.clear();

        Arr = Cooldowns.getAsJsonArray("Sworded");
        Arr.forEach(e ->L.add(e.getAsInt()));
        Sworded = ArrayUtils.toPrimitive(L.toArray(new Integer[0]));
        L.clear();

        Arr = Cooldowns.getAsJsonArray("Hoed");
        Arr.forEach(e ->L.add(e.getAsInt()));
        Hoed = ArrayUtils.toPrimitive(L.toArray(new Integer[0]));
        L.clear();

        Arr = Cooldowns.getAsJsonArray("Cake");
        Arr.forEach(e ->L.add(e.getAsInt()));
        Cake = ArrayUtils.toPrimitive(L.toArray(new Integer[0]));
        L.clear();

        Arr = Cooldowns.getAsJsonArray("Sleepful");
        Arr.forEach(e ->L.add(e.getAsInt()));
        Sleepful = ArrayUtils.toPrimitive(L.toArray(new Integer[0]));
        L.clear();

        Arr = Cooldowns.getAsJsonArray("Sleepless");
        Arr.forEach(e ->L.add(e.getAsInt()));
        Sleepless = ArrayUtils.toPrimitive(L.toArray(new Integer[0]));
        L.clear();

        Arr = Cooldowns.getAsJsonArray("NoChests");
        Arr.forEach(e ->L.add(e.getAsInt()));
        NoChests = ArrayUtils.toPrimitive(L.toArray(new Integer[0]));
        L.clear();

        Arr = Cooldowns.getAsJsonArray("Chests");
        Arr.forEach(e ->L.add(e.getAsInt()));
        Chests = ArrayUtils.toPrimitive(L.toArray(new Integer[0]));
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
