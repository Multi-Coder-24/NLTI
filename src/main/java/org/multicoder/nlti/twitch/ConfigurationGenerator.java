package org.multicoder.nlti.twitch;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.stream.JsonWriter;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.OutputStream;
import java.util.Properties;

public class ConfigurationGenerator
{
    public static void CreateConfig(String Path) throws Exception
    {
        Properties Prop = new Properties();
        Prop.put("token","**");
        Prop.put("username","***");
        OutputStream Stream = new FileOutputStream(Path);
        Prop.store(Stream,"NLTI Configuration");
    }
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
        JsonWriter WriterJ = new JsonWriter(new FileWriter(Path));
        Gson Obj = new Gson();
        Obj.toJson(Data,WriterJ);
        WriterJ.close();
    }
}
