package org.multicoder.nlti.config;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import org.jetbrains.annotations.NotNull;
import org.multicoder.nlti.NLTI;
import org.multicoder.nlti.twitch.MulticoderTwitchConnection;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class ConfigurationManager
{
    public static void LoadOrCreateConfig(String MainConfig, String CooldownConfig) throws Exception
    {
        Gson G = new Gson();
        File Main = new File(MainConfig);
        File Cooldown = new File(CooldownConfig);
        if(!Main.exists())
        {
            NLTI.LOGGER.info("First Run");
            //  First Run
            GenerateMainConfig(new JsonObject(),Main,G);
            GenerateCooldownConfig(new JsonObject(),Cooldown,G);
            NLTI.FIRSTRUN = true;
        }
        else
        {
            //  Version Check
            JsonReader JSON = new JsonReader(new FileReader(MainConfig));
            JsonObject Contents = G.fromJson(JSON,JsonObject.class);
            if(!Contents.has("Version"))
            {
                NLTI.LOGGER.info("Legacy");
                //  Legacy Version
                GenerateCooldownConfig(new JsonObject(),Cooldown,G);
                UpdateMainConfig(Contents,new JsonObject(),Main,G);
            }
            //  Reload Config
            JSON = new JsonReader(new FileReader(MainConfig));
            Contents = G.fromJson(JSON,JsonObject.class);
            String Version = Contents.get("Version").getAsString();
            if(!Version.equals(NLTI.Version))
            {
                NLTI.LOGGER.info("Older Run");
                JsonObject Cooldowns = G.fromJson(new JsonReader(new FileReader(Cooldown)),JsonObject.class);
                //  Previous Version
                UpdateMainConfig(Contents,new JsonObject(),Main,G);
                UpdateCooldownConfig(Cooldowns,new JsonObject(),Cooldown,G);
            }
        }
        if(!NLTI.FIRSTRUN)
        {
            NLTI.LOGGER.info("Initializing Config");
            JsonReader MainReader = new JsonReader(new FileReader(Main));
            JsonReader CooldownReader = new JsonReader(new FileReader(Cooldown));
            JsonObject MainConfigJSON = G.fromJson(MainReader,JsonObject.class);
            JsonObject CooldownConfigJSON = G.fromJson(CooldownReader,JsonObject.class);
            MulticoderTwitchConnection.Config = new NLTIConfig(MainConfigJSON,CooldownConfigJSON);
        }
    }
    public static void UpdateMainConfig(@NotNull JsonObject Original, @NotNull JsonObject NewObject, @NotNull File Location, @NotNull Gson G) throws Exception
    {
        String Token = Original.get("Token").getAsString();
        String ClientID = Original.get("clientID").getAsString();
        String Redirect = Original.get("redirectURL").getAsString();
        JsonArray Users = Original.get("Usernames").getAsJsonArray();
        NewObject.addProperty("Token",Token);
        NewObject.addProperty("clientID",ClientID);
        NewObject.addProperty("redirectURL",Redirect);
        NewObject.addProperty("Version",NLTI.Version);
        NewObject.add("Usernames",Users);
        JsonWriter WriterJ = new JsonWriter(new FileWriter(Location));
        G.toJson(NewObject,WriterJ);
        WriterJ.close();
    }
    public static void UpdateCooldownConfig(@NotNull JsonObject Original, @NotNull JsonObject NewObject, @NotNull File Location, @NotNull Gson G) throws Exception
    {
        JsonArray Creeper = Original.getAsJsonArray("CreeperCooldown");
        JsonArray Skeleton = Original.getAsJsonArray("SkeletonCooldown");
        JsonArray Zombie = Original.getAsJsonArray("ZombieCooldown");
        JsonArray Enderman = Original.getAsJsonArray("EndermanCooldown");
        JsonArray Spider = Original.getAsJsonArray("SpiderCooldown");
        JsonArray Witch = Original.getAsJsonArray("WitchCooldown");
        JsonArray Vindicator = Original.getAsJsonArray("VindicatorCooldown");
        JsonArray Husk = Original.getAsJsonArray("HuskCooldown");
        JsonArray Pillager = Original.getAsJsonArray("PillagerCooldown");
        JsonArray Piglin = Original.getAsJsonArray("PiglinCooldown");
        JsonArray Stray = Original.getAsJsonArray("StrayCooldown");

        JsonArray Poison = Original.getAsJsonArray("PoisonCooldown");
        JsonArray Hunger = Original.getAsJsonArray("HungerCooldown");
        JsonArray Weakness = Original.getAsJsonArray("WeaknessCooldown");
        JsonArray Blind = Original.getAsJsonArray("BlindCooldown");
        JsonArray Slow = Original.getAsJsonArray("SlowCooldown");
        JsonArray Regen = Original.getAsJsonArray("RegenCooldown");
        JsonArray Strength = Original.getAsJsonArray("StrengthCooldown");
        JsonArray Speed = Original.getAsJsonArray("SpeedCooldown");
        JsonArray Haste = Original.getAsJsonArray("HasteCooldown");
        JsonArray Resistance = Original.getAsJsonArray("ResistanceCooldown");
        JsonArray NightVis = Original.getAsJsonArray("NightVisionCooldown");

        JsonArray Night = Original.getAsJsonArray("NightCooldown");
        JsonArray Day = Original.getAsJsonArray("DayCooldown");
        JsonArray Thunder = Original.getAsJsonArray("Thunder");
        JsonArray Rain = Original.getAsJsonArray("Rain");
        JsonArray Clear = Original.getAsJsonArray("Clear");

        JsonArray HealthD = Original.getAsJsonArray("HealthD");
        JsonArray HealthP = Original.getAsJsonArray("HealthP");
        JsonArray Speed25 = Original.getAsJsonArray("Speed25");
        JsonArray Speed50 = Original.getAsJsonArray("Speed50");
        JsonArray Speed100 = Original.getAsJsonArray("Speed100");
        JsonArray Speed150 = Original.getAsJsonArray("Speed150");
        JsonArray Speed200 = Original.getAsJsonArray("Speed200");
        JsonArray Axed = Original.getAsJsonArray("Axed");
        JsonArray Pickaxed = Original.getAsJsonArray("Pickaxed");
        JsonArray Sworded = Original.getAsJsonArray("Sworded");
        JsonArray Shoveled = Original.getAsJsonArray("Shoveled");
        JsonArray Hoed = Original.getAsJsonArray("Hoed");
        JsonArray Death = Original.getAsJsonArray("Death");
        JsonArray Hungry = Original.getAsJsonArray("Hungry");
        JsonArray Cake = Original.getAsJsonArray("Cake");
        JsonArray Steal = Original.getAsJsonArray("StealCooldown");
        JsonArray Snatch = Original.getAsJsonArray("SnatchCooldown");
        JsonArray Food = Original.getAsJsonArray("FoodCooldown");
        JsonArray Sleepful = Original.getAsJsonArray("Sleepful");
        JsonArray Sleepless = Original.getAsJsonArray("Sleepless");
        JsonArray Chests = Original.getAsJsonArray("Chests");
        JsonArray NoChests = Original.getAsJsonArray("NoChests");

        NewObject.add("CreeperCooldown",Creeper);
        NewObject.add("SkeletonCooldown",Skeleton);
        NewObject.add("ZombieCooldown",Zombie);
        NewObject.add("EndermanCooldown",Enderman);
        NewObject.add("SpiderCooldown",Spider);
        NewObject.add("WitchCooldown",Witch);
        NewObject.add("VindicatorCooldown",Vindicator);
        NewObject.add("HuskCooldown",Husk);
        NewObject.add("PillagerCooldown",Pillager);
        NewObject.add("PiglinCooldown",Piglin);
        NewObject.add("StrayCooldown",Stray);

        NewObject.add("PoisonCooldown",Poison);
        NewObject.add("HungerCooldown",Hunger);
        NewObject.add("WeaknessCooldown",Weakness);
        NewObject.add("BlindCooldown",Blind);
        NewObject.add("SlowCooldown",Slow);
        NewObject.add("RegenCooldown",Regen);
        NewObject.add("StrengthCooldown",Strength);
        NewObject.add("SpeedCooldown",Speed);
        NewObject.add("HasteCooldown",Haste);
        NewObject.add("ResistanceCooldown",Resistance);
        NewObject.add("NightVisionCooldown",NightVis);

        NewObject.add("NightCooldown",Night);
        NewObject.add("DayCooldown",Day);
        NewObject.add("Thunder",Thunder);
        NewObject.add("Rain",Rain);
        NewObject.add("Clear",Clear);

        NewObject.add("HealthD",HealthD);
        NewObject.add("HealthP",HealthP);
        NewObject.add("Speed25",Speed25);
        NewObject.add("Speed50",Speed50);
        NewObject.add("Speed100",Speed100);
        NewObject.add("Speed150",Speed150);
        NewObject.add("Speed200",Speed200);
        NewObject.add("Axed",Axed);
        NewObject.add("Pickaxed",Pickaxed);
        NewObject.add("Sworded",Sworded);
        NewObject.add("Shoveled",Shoveled);
        NewObject.add("Hoed",Hoed);
        NewObject.add("Death",Death);
        NewObject.add("Hungry",Hungry);
        NewObject.add("Cake",Cake);
        NewObject.add("StealCooldown",Steal);
        NewObject.add("SnatchCooldown",Snatch);
        NewObject.add("FoodCooldown",Food);
        NewObject.add("Sleepful",Sleepful);
        NewObject.add("Sleepless",Sleepless);
        NewObject.add("Chests",Chests);
        NewObject.add("NoChests",NoChests);

        JsonWriter WriterJ = new JsonWriter(new FileWriter(Location));
        G.toJson(NewObject,WriterJ);
        WriterJ.flush();
        WriterJ.close();
    }
    public static void GenerateMainConfig(@NotNull JsonObject Object, @NotNull File Location, @NotNull Gson G) throws Exception
    {
        Object.addProperty("Token","**");
        Object.addProperty("clientID","**");
        Object.addProperty("redirectURL","**");
        Object.addProperty("Version",NLTI.Version);
        Object.addProperty("ChaosMode",false);
        JsonArray Usernames = new JsonArray();
        Usernames.add("examplename");
        Usernames.add("collaborator");
        Object.add("Usernames",Usernames);
        JsonWriter WriterJ = new JsonWriter(new FileWriter(Location));
        G.toJson(Object,WriterJ);
        WriterJ.flush();
        WriterJ.close();
    }
    public static void GenerateCooldownConfig(@NotNull JsonObject Object,@NotNull File Location,@NotNull Gson G) throws Exception
    {
        JsonArray SpawnCooldown = new JsonArray();
        JsonArray EffectCooldown = new JsonArray();
        JsonArray WorldCooldown = new JsonArray();
        JsonArray UtilCooldown = new JsonArray();
        SpawnCooldown.add(60);
        SpawnCooldown.add(20);
        EffectCooldown.add(120);
        EffectCooldown.add(30);
        WorldCooldown.add(100);
        WorldCooldown.add(25);
        UtilCooldown.add(180);
        UtilCooldown.add(40);
        Object.add("CreeperCooldown",SpawnCooldown);
        Object.add("SkeletonCooldown",SpawnCooldown);
        Object.add("ZombieCooldown",SpawnCooldown);
        Object.add("EndermanCooldown",SpawnCooldown);
        Object.add("SpiderCooldown",SpawnCooldown);
        Object.add("WitchCooldown",SpawnCooldown);
        Object.add("VindicatorCooldown",SpawnCooldown);
        Object.add("HuskCooldown",SpawnCooldown);
        Object.add("PillagerCooldown",SpawnCooldown);
        Object.add("PiglinCooldown",SpawnCooldown);
        Object.add("StrayCooldown",SpawnCooldown);

        Object.add("PoisonCooldown",EffectCooldown);
        Object.add("HungerCooldown",EffectCooldown);
        Object.add("WeaknessCooldown",EffectCooldown);
        Object.add("BlindCooldown",EffectCooldown);
        Object.add("SlowCooldown",EffectCooldown);
        Object.add("RegenCooldown",EffectCooldown);
        Object.add("StrengthCooldown",EffectCooldown);
        Object.add("SpeedCooldown",EffectCooldown);
        Object.add("HasteCooldown",EffectCooldown);
        Object.add("ResistanceCooldown",EffectCooldown);
        Object.add("NightVisionCooldown",EffectCooldown);

        Object.add("NightCooldown",WorldCooldown);
        Object.add("DayCooldown",WorldCooldown);
        Object.add("Thunder",WorldCooldown);
        Object.add("Rain",WorldCooldown);
        Object.add("Clear",WorldCooldown);

        Object.add("HealthD",UtilCooldown);
        Object.add("HealthP",UtilCooldown);
        Object.add("Speed25",UtilCooldown);
        Object.add("Speed50",UtilCooldown);
        Object.add("Speed100",UtilCooldown);
        Object.add("Speed150",UtilCooldown);
        Object.add("Speed200",UtilCooldown);
        Object.add("Hungry",UtilCooldown);
        Object.add("Axed",UtilCooldown);
        Object.add("Shoveled",UtilCooldown);
        Object.add("Pickaxed",UtilCooldown);
        Object.add("Sworded",UtilCooldown);
        Object.add("Hoed",UtilCooldown);
        Object.add("Death",UtilCooldown);
        Object.add("Cake",UtilCooldown);
        Object.add("Sleepful",UtilCooldown);
        Object.add("Sleepless",UtilCooldown);
        Object.add("Chests",UtilCooldown);
        Object.add("NoChests",UtilCooldown);
        Object.add("StealCooldown",UtilCooldown);
        Object.add("SnatchCooldown",UtilCooldown);
        Object.add("FoodCooldown",UtilCooldown);

        JsonWriter WriterJ = new JsonWriter(new FileWriter(Location));
        G.toJson(Object,WriterJ);
        WriterJ.flush();
        WriterJ.close();
    }
}
