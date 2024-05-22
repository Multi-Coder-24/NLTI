package org.multicoder.nlti.twitch;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.stream.JsonWriter;

import java.io.FileWriter;

public class ConfigurationGenerator
{
    public static void CreateJSONConfig(String Path) throws Exception
    {
        JsonObject Data = new JsonObject();
        JsonArray Usernames = new JsonArray();
        JsonArray SpawnCooldown = new JsonArray();
        JsonArray EffectCooldown = new JsonArray();
        JsonArray UtilCooldown = new JsonArray();
        SpawnCooldown.add(60);
        EffectCooldown.add(120);
        UtilCooldown.add(180);
        SpawnCooldown.add(20);
        EffectCooldown.add(30);
        UtilCooldown.add(40);
        Usernames.add("examplename");
        Usernames.add("collaborator");
        Data.addProperty("Token","**");
        Data.addProperty("clientID","**");
        Data.addProperty("redirectURL","**");
        Data.add("Usernames",Usernames);
        Data.addProperty("ChaosMode",false);
        Data.add("CreeperCooldown",SpawnCooldown);
        Data.add("SkeletonCooldown",SpawnCooldown);
        Data.add("ZombieCooldown",SpawnCooldown);
        Data.add("EndermanCooldown",SpawnCooldown);
        Data.add("SpiderCooldown",SpawnCooldown);
        Data.add("WitchCooldown",SpawnCooldown);
        Data.add("VindicatorCooldown",SpawnCooldown);
        Data.add("HuskCooldown",SpawnCooldown);
        Data.add("PillagerCooldown",SpawnCooldown);
        Data.add("PiglinCooldown",SpawnCooldown);
        Data.add("StrayCooldown",SpawnCooldown);
        Data.add("PoisonCooldown",EffectCooldown);
        Data.add("HungerCooldown",EffectCooldown);
        Data.add("WeaknessCooldown",EffectCooldown);
        Data.add("BlindCooldown",EffectCooldown);
        Data.add("SlowCooldown",EffectCooldown);
        Data.add("RegenCooldown",EffectCooldown);
        Data.add("StrengthCooldown",EffectCooldown);
        Data.add("SpeedCooldown",EffectCooldown);
        Data.add("HasteCooldown",EffectCooldown);
        Data.add("ResistanceCooldown",EffectCooldown);
        Data.add("NightVisionCooldown",EffectCooldown);
        Data.add("StealCooldown",UtilCooldown);
        Data.add("SnatchCooldown",UtilCooldown);
        Data.add("FoodCooldown",UtilCooldown);
        Data.add("NightCooldown",SpawnCooldown);
        Data.add("DayCooldown",SpawnCooldown);
        Data.add("HealthD",UtilCooldown);
        Data.add("HealthP",UtilCooldown);
        Data.add("Speed25",UtilCooldown);
        Data.add("Speed50",UtilCooldown);
        Data.add("Speed100",UtilCooldown);
        Data.add("Speed150",UtilCooldown);
        Data.add("Speed200",UtilCooldown);
        Data.add("Hungry",UtilCooldown);
        Data.add("Thunder",UtilCooldown);
        Data.add("Rain",UtilCooldown);
        Data.add("Clear",UtilCooldown);
        Data.add("Axed",UtilCooldown);
        Data.add("Shoveled",UtilCooldown);
        Data.add("Pickaxed",UtilCooldown);
        Data.add("Sworded",UtilCooldown);
        Data.add("Hoed",UtilCooldown);
        Data.add("Death",UtilCooldown);
        Data.add("Cake",UtilCooldown);
        JsonWriter WriterJ = new JsonWriter(new FileWriter(Path));
        Gson Obj = new Gson();
        Obj.toJson(Data,WriterJ);
        WriterJ.close();
    }
}
