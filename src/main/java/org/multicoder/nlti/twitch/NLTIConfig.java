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
    public String Token;
    //  Mob Spawn Cooldowns
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
    //  Effects Cooldowns
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
    //  Util Cooldowns
    public int[] Steal;
    public int[] Snatch;
    public int[] Food;
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

        //  Saving Config Vars
        JsonArray Arr = Object.getAsJsonArray("Usernames");
        List<String> UsersL = new ArrayList<>();
        Arr.forEach(e -> {UsersL.add(e.getAsString());});
        Users = UsersL.toArray(new String[0]);
        ChaosMode = Object.get("ChaosMode").getAsBoolean();

        //  Retrieving Cooldowns
        Arr = Object.getAsJsonArray("CreeperCooldown");
        List<Integer> L0 = new ArrayList<>();
        Arr.forEach(e ->{L0.add(e.getAsInt());});
        Creeper = ArrayUtils.toPrimitive(L0.toArray(new Integer[0]));

        Arr = Object.getAsJsonArray("SkeletonCooldown");
        List<Integer> L1 = new ArrayList<>();
        Arr.forEach(e ->{L1.add(e.getAsInt());});
        Skeleton = ArrayUtils.toPrimitive(L1.toArray(new Integer[0]));

        Arr = Object.getAsJsonArray("ZombieCooldown");
        List<Integer> L2 = new ArrayList<>();
        Arr.forEach(e ->{L2.add(e.getAsInt());});
        Zombie = ArrayUtils.toPrimitive(L2.toArray(new Integer[0]));

        Arr = Object.getAsJsonArray("EndermanCooldown");
        List<Integer> L3 = new ArrayList<>();
        Arr.forEach(e ->{L3.add(e.getAsInt());});
        Enderman = ArrayUtils.toPrimitive(L3.toArray(new Integer[0]));

        Arr = Object.getAsJsonArray("SpiderCooldown");
        List<Integer> L4 = new ArrayList<>();
        Arr.forEach(e ->{L4.add(e.getAsInt());});
        Spider = ArrayUtils.toPrimitive(L4.toArray(new Integer[0]));

        Arr = Object.getAsJsonArray("WitchCooldown");
        List<Integer> L5 = new ArrayList<>();
        Arr.forEach(e ->{L5.add(e.getAsInt());});
        Witch = ArrayUtils.toPrimitive(L5.toArray(new Integer[0]));

        Arr = Object.getAsJsonArray("VindicatorCooldown");
        List<Integer> L6 = new ArrayList<>();
        Arr.forEach(e ->{L6.add(e.getAsInt());});
        Vindicator = ArrayUtils.toPrimitive(L6.toArray(new Integer[0]));

        Arr = Object.getAsJsonArray("HuskCooldown");
        List<Integer> L7 = new ArrayList<>();
        Arr.forEach(e ->{L7.add(e.getAsInt());});
        Husk = ArrayUtils.toPrimitive(L7.toArray(new Integer[0]));

        Arr = Object.getAsJsonArray("PillagerCooldown");
        List<Integer> L8 = new ArrayList<>();
        Arr.forEach(e ->{L8.add(e.getAsInt());});
        Pillager = ArrayUtils.toPrimitive(L8.toArray(new Integer[0]));

        Arr = Object.getAsJsonArray("PiglinCooldown");
        List<Integer> L9 = new ArrayList<>();
        Arr.forEach(e ->{L9.add(e.getAsInt());});
        Piglin = ArrayUtils.toPrimitive(L9.toArray(new Integer[0]));

        Arr = Object.getAsJsonArray("StrayCooldown");
        List<Integer> L10 = new ArrayList<>();
        Arr.forEach(e ->{L10.add(e.getAsInt());});
        Stray = ArrayUtils.toPrimitive(L10.toArray(new Integer[0]));

        Arr = Object.getAsJsonArray("PoisonCooldown");
        List<Integer> L11 = new ArrayList<>();
        Arr.forEach(e ->{L11.add(e.getAsInt());});
        Poison = ArrayUtils.toPrimitive(L11.toArray(new Integer[0]));

        Arr = Object.getAsJsonArray("HungerCooldown");
        List<Integer> L12 = new ArrayList<>();
        Arr.forEach(e ->{L12.add(e.getAsInt());});
        Hunger = ArrayUtils.toPrimitive(L12.toArray(new Integer[0]));

        Arr = Object.getAsJsonArray("WeaknessCooldown");
        List<Integer> L13 = new ArrayList<>();
        Arr.forEach(e ->{L13.add(e.getAsInt());});
        Weakness = ArrayUtils.toPrimitive(L13.toArray(new Integer[0]));

        Arr = Object.getAsJsonArray("BlindCooldown");
        List<Integer> L14 = new ArrayList<>();
        Arr.forEach(e ->{L14.add(e.getAsInt());});
        Blindness = ArrayUtils.toPrimitive(L14.toArray(new Integer[0]));

        Arr = Object.getAsJsonArray("SlowCooldown");
        List<Integer> L15 = new ArrayList<>();
        Arr.forEach(e ->{L15.add(e.getAsInt());});
        Slowness = ArrayUtils.toPrimitive(L15.toArray(new Integer[0]));

        Arr = Object.getAsJsonArray("RegenCooldown");
        List<Integer> L16 = new ArrayList<>();
        Arr.forEach(e ->{L16.add(e.getAsInt());});
        Regeneration = ArrayUtils.toPrimitive(L16.toArray(new Integer[0]));

        Arr = Object.getAsJsonArray("StrengthCooldown");
        List<Integer> L17 = new ArrayList<>();
        Arr.forEach(e ->{L17.add(e.getAsInt());});
        Strength = ArrayUtils.toPrimitive(L17.toArray(new Integer[0]));

        Arr = Object.getAsJsonArray("SpeedCooldown");
        List<Integer> L18 = new ArrayList<>();
        Arr.forEach(e ->{L18.add(e.getAsInt());});
        Speed = ArrayUtils.toPrimitive(L18.toArray(new Integer[0]));

        Arr = Object.getAsJsonArray("HasteCooldown");
        List<Integer> L19 = new ArrayList<>();
        Arr.forEach(e ->{L19.add(e.getAsInt());});
        Haste = ArrayUtils.toPrimitive(L19.toArray(new Integer[0]));

        Arr = Object.getAsJsonArray("ResistanceCooldown");
        List<Integer> L20 = new ArrayList<>();
        Arr.forEach(e ->{L20.add(e.getAsInt());});
        Resistance = ArrayUtils.toPrimitive(L20.toArray(new Integer[0]));

        Arr = Object.getAsJsonArray("NightVisionCooldown");
        List<Integer> L21 = new ArrayList<>();
        Arr.forEach(e ->{L21.add(e.getAsInt());});
        NightVision = ArrayUtils.toPrimitive(L21.toArray(new Integer[0]));

        Arr = Object.getAsJsonArray("StealCooldown");
        List<Integer> L22 = new ArrayList<>();
        Arr.forEach(e ->{L22.add(e.getAsInt());});
        Steal = ArrayUtils.toPrimitive(L22.toArray(new Integer[0]));

        Arr = Object.getAsJsonArray("SnatchCooldown");
        List<Integer> L23 = new ArrayList<>();
        Arr.forEach(e ->{L23.add(e.getAsInt());});
        Snatch = ArrayUtils.toPrimitive(L23.toArray(new Integer[0]));

        Arr = Object.getAsJsonArray("FoodCooldown");
        List<Integer> L24 = new ArrayList<>();
        Arr.forEach(e ->{L24.add(e.getAsInt());});
        Food = ArrayUtils.toPrimitive(L24.toArray(new Integer[0]));

        Arr = Object.getAsJsonArray("NightCooldown");
        List<Integer> L25 = new ArrayList<>();
        Arr.forEach(e ->{L25.add(e.getAsInt());});
        Night = ArrayUtils.toPrimitive(L25.toArray(new Integer[0]));

        Arr = Object.getAsJsonArray("DayCooldown");
        List<Integer> L26 = new ArrayList<>();
        Arr.forEach(e ->{L26.add(e.getAsInt());});
        Day = ArrayUtils.toPrimitive(L26.toArray(new Integer[0]));
    }
}
