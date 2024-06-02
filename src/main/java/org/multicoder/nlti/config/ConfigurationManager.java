package org.multicoder.nlti.config;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import org.jetbrains.annotations.NotNull;
import org.multicoder.nlti.NLTI;
import org.multicoder.nlti.twitch.MulticoderTwitchConnection;
import org.multicoder.nlti.util.CommandNodeBuilder;

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
            GenerateCommandConfig(new JsonObject(),Cooldown,G);
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
                GenerateCommandConfig(new JsonObject(),Cooldown,G);
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
                UpdateCommandConfig(Cooldowns,new JsonObject(),Cooldown,G);
            }
        }
        if(!NLTI.FIRSTRUN)
        {
            NLTI.LOGGER.info("Initializing Config");
            JsonReader MainReader = new JsonReader(new FileReader(Main));
            JsonReader CooldownReader = new JsonReader(new FileReader(Cooldown));
            JsonObject MainConfigJSON = G.fromJson(MainReader,JsonObject.class);
            JsonObject CooldownConfigJSON = G.fromJson(CooldownReader,JsonObject.class);
            //MulticoderTwitchConnection.Config = new NLTIConfig(MainConfigJSON,CooldownConfigJSON);
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
    public static void UpdateCommandConfig(@NotNull JsonObject Original, @NotNull JsonObject NewObject, @NotNull File Location, @NotNull Gson G) throws Exception
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
        JsonArray Steal = Original.getAsJsonArray("StealCooldown");
        JsonArray Snatch = Original.getAsJsonArray("SnatchCooldown");
        JsonArray Food = Original.getAsJsonArray("FoodCooldown");
        JsonArray Sleepful = Original.getAsJsonArray("Sleepful");
        JsonArray Sleepless = Original.getAsJsonArray("Sleepless");
        JsonArray Chests = Original.getAsJsonArray("Chests");
        JsonArray NoChests = Original.getAsJsonArray("NoChests");

        JsonArray Commands = new JsonArray();
        Commands.add(CommandNodeBuilder.CreateNode("Creeper","!mc-creeper","Spawns a creeper on all players",Creeper.get(0).getAsInt(),Creeper.get(1).getAsInt()));
        Commands.add(CommandNodeBuilder.CreateNode("Skeleton","!mc-skeleton","Spawns a skeleton on all players",Skeleton.get(0).getAsInt(),Skeleton.get(1).getAsInt()));
        Commands.add(CommandNodeBuilder.CreateNode("Zombie","!mc-zombie","Spawns a zombie on all players",Zombie.get(0).getAsInt(),Zombie.get(1).getAsInt()));
        Commands.add(CommandNodeBuilder.CreateNode("Enderman","!mc-enderman","Spawns a enderman on all players",Enderman.get(0).getAsInt(),Enderman.get(1).getAsInt()));
        Commands.add(CommandNodeBuilder.CreateNode("Spider","!mc-spider","Spawns a spider on all players",Spider.get(0).getAsInt(),Spider.get(1).getAsInt()));
        Commands.add(CommandNodeBuilder.CreateNode("Witch","!mc-witch","Spawns a witch on all players",Witch.get(0).getAsInt(),Witch.get(1).getAsInt()));
        Commands.add(CommandNodeBuilder.CreateNode("Vindicator","!mc-vindicator","Spawns a vindicator on all players",Vindicator.get(0).getAsInt(),Vindicator.get(1).getAsInt()));
        Commands.add(CommandNodeBuilder.CreateNode("Husk","!mc-husk","Spawns a husk on all players",Husk.get(0).getAsInt(),Husk.get(1).getAsInt()));
        Commands.add(CommandNodeBuilder.CreateNode("Pillager","!mc-pillager","Spawns a pillager on all players",Pillager.get(0).getAsInt(),Pillager.get(1).getAsInt()));
        Commands.add(CommandNodeBuilder.CreateNode("Piglin","!mc-piglin","Spawns a piglin on all players",Piglin.get(0).getAsInt(),Piglin.get(1).getAsInt()));
        Commands.add(CommandNodeBuilder.CreateNode("Stray","!mc-stray","Spawns a stray on all players",Stray.get(0).getAsInt(),Stray.get(1).getAsInt()));

        Commands.add(CommandNodeBuilder.CreateNode("Poison","!mc-poison","Gives all players Poison for 20 seconds",Poison.get(0).getAsInt(),Poison.get(1).getAsInt()));
        Commands.add(CommandNodeBuilder.CreateNode("Hunger","!mc-hunger","Gives all players Hunger for 20 seconds",Hunger.get(0).getAsInt(),Hunger.get(1).getAsInt()));
        Commands.add(CommandNodeBuilder.CreateNode("Weakness","!mc-weakness","Gives all Weakness Poison for 20 seconds",Weakness.get(0).getAsInt(),Weakness.get(1).getAsInt()));
        Commands.add(CommandNodeBuilder.CreateNode("Blind","!mc-blind","Gives all players Blindness for 20 seconds",Blind.get(0).getAsInt(),Blind.get(1).getAsInt()));
        Commands.add(CommandNodeBuilder.CreateNode("Slow","!mc-slow","Gives all players Slowness for 20 seconds",Slow.get(0).getAsInt(),Slow.get(1).getAsInt()));
        Commands.add(CommandNodeBuilder.CreateNode("Regen","!mc-regen","Gives all players Regeneration for 20 seconds",Regen.get(0).getAsInt(),Regen.get(1).getAsInt()));
        Commands.add(CommandNodeBuilder.CreateNode("Strength","!mc-strength","Gives all players Strength for 20 seconds",Strength.get(0).getAsInt(),Strength.get(1).getAsInt()));
        Commands.add(CommandNodeBuilder.CreateNode("Speed","!mc-speed","Gives all players Speed for 20 seconds",Speed.get(0).getAsInt(),Speed.get(1).getAsInt()));
        Commands.add(CommandNodeBuilder.CreateNode("Haste","!mc-haste","Gives all players Haste for 20 seconds",Haste.get(0).getAsInt(),Haste.get(1).getAsInt()));
        Commands.add(CommandNodeBuilder.CreateNode("Resistance","!mc-resistance","Gives all players Resistance for 20 seconds",Resistance.get(0).getAsInt(),Resistance.get(1).getAsInt()));
        Commands.add(CommandNodeBuilder.CreateNode("NightVision","!mc-nightvision","Gives all players Night Vision for 20 seconds",NightVis.get(0).getAsInt(),NightVis.get(1).getAsInt()));

        Commands.add(CommandNodeBuilder.CreateNode("Night","!mc-night","Sets the game time to night",Night.get(0).getAsInt(),Night.get(1).getAsInt()));
        Commands.add(CommandNodeBuilder.CreateNode("Day","!mc-day","Sets the game time to day",Day.get(0).getAsInt(),Day.get(1).getAsInt()));
        Commands.add(CommandNodeBuilder.CreateNode("Thunder","!mc-weatherthunder","Changes weather to thunder",Thunder.get(0).getAsInt(),Thunder.get(1).getAsInt()));
        Commands.add(CommandNodeBuilder.CreateNode("Rain","!mc-weatherrain","Changes weather to rain",Rain.get(0).getAsInt(),Rain.get(1).getAsInt()));
        Commands.add(CommandNodeBuilder.CreateNode("Clear","!mc-weatherclear","Changes weather to clear",Clear.get(0).getAsInt(),Clear.get(1).getAsInt()));

        Commands.add(CommandNodeBuilder.CreateNode("Steal","!mc-steal","Takes the held item from all players",Steal.get(0).getAsInt(),Steal.get(1).getAsInt()));
        Commands.add(CommandNodeBuilder.CreateNode("Snatch","!mc-snatch","Takes a random item from all players",Snatch.get(0).getAsInt(),Snatch.get(1).getAsInt()));
        Commands.add(CommandNodeBuilder.CreateNode("Food","!mc-food","Gives all players 3 Golden Carrots",Food.get(0).getAsInt(),Food.get(1).getAsInt()));
        Commands.add(CommandNodeBuilder.CreateNode("HealthD","!mc-healthminus","Removes a heart from all players",HealthD.get(0).getAsInt(),HealthD.get(1).getAsInt()));
        Commands.add(CommandNodeBuilder.CreateNode("HealthP","!mc-healthplus","Adds a heart to all players",HealthP.get(0).getAsInt(),HealthP.get(1).getAsInt()));
        Commands.add(CommandNodeBuilder.CreateNode("Speed25","!mc-speed25","Sets all players speed to 25%",Speed25.get(0).getAsInt(),Speed25.get(1).getAsInt()));
        Commands.add(CommandNodeBuilder.CreateNode("Speed50","!mc-speed50","Sets all players speed to 50%",Speed50.get(0).getAsInt(),Speed50.get(1).getAsInt()));
        Commands.add(CommandNodeBuilder.CreateNode("Speed100","!mc-speed100","Sets all players speed to 100%",Speed100.get(0).getAsInt(),Speed100.get(1).getAsInt()));
        Commands.add(CommandNodeBuilder.CreateNode("Speed150","!mc-speed150","Sets all players speed to 150%",Speed150.get(0).getAsInt(),Speed150.get(1).getAsInt()));
        Commands.add(CommandNodeBuilder.CreateNode("Speed200","!mc-speed200","Sets all players speed to 200%",Speed200.get(0).getAsInt(),Speed200.get(1).getAsInt()));
        Commands.add(CommandNodeBuilder.CreateNode("Hungry","!mc-hungry","Sets all players hunger to one bar and no saturation",Hungry.get(0).getAsInt(),Hungry.get(1).getAsInt()));
        Commands.add(CommandNodeBuilder.CreateNode("Sleepless","!mc-sleepless","Prevents players from using beds",Sleepless.get(0).getAsInt(),Sleepless.get(1).getAsInt()));
        Commands.add(CommandNodeBuilder.CreateNode("Sleepful","!mc-sleepful","Allows players to use beds",Sleepful.get(0).getAsInt(),Sleepful.get(1).getAsInt()));
        Commands.add(CommandNodeBuilder.CreateNode("Death","!mc-death","Kills all players",Death.get(0).getAsInt(),Death.get(1).getAsInt()));
        Commands.add(CommandNodeBuilder.CreateNode("NoChests","!mc-nochests","Prevents players from opening chests and barrels",NoChests.get(0).getAsInt(),NoChests.get(1).getAsInt()));
        Commands.add(CommandNodeBuilder.CreateNode("Chests","!mc-chests","Allows players to open chests and barrels",Chests.get(0).getAsInt(),Chests.get(1).getAsInt()));
        Commands.add(CommandNodeBuilder.CreateNode("Axed","!mc-axed","Gives all players a Stone Axe",Axed.get(0).getAsInt(),Axed.get(1).getAsInt()));
        Commands.add(CommandNodeBuilder.CreateNode("Pickaxed","!mc-pickaxed","Gives all players a Stone Pickaxe",Pickaxed.get(0).getAsInt(),Pickaxed.get(1).getAsInt()));
        Commands.add(CommandNodeBuilder.CreateNode("Sworded","!mc-sworded","Gives all players a Stone Sword",Sworded.get(0).getAsInt(),Sworded.get(1).getAsInt()));
        Commands.add(CommandNodeBuilder.CreateNode("Hoed","!mc-hoed","Gives all players a Stone Hoe",Hoed.get(0).getAsInt(),Hoed.get(1).getAsInt()));
        Commands.add(CommandNodeBuilder.CreateNode("Shoveled","!mc-shoveled","Gives all players a Stone Shovel",Shoveled.get(0).getAsInt(),Shoveled.get(1).getAsInt()));

        NewObject.addProperty("Version",NLTI.Version);
        NewObject.add("Commands",Commands);
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
    public static void GenerateCommandConfig(@NotNull JsonObject Object, @NotNull File Location, @NotNull Gson G) throws Exception
    {
        JsonArray Commands = new JsonArray();
        Commands.add(CommandNodeBuilder.CreateNode("Creeper","!mc-creeper","Spawns a creeper on all players",60,20));
        Commands.add(CommandNodeBuilder.CreateNode("Skeleton","!mc-skeleton","Spawns a skeleton on all players",60,20));
        Commands.add(CommandNodeBuilder.CreateNode("Zombie","!mc-zombie","Spawns a zombie on all players",60,20));
        Commands.add(CommandNodeBuilder.CreateNode("Enderman","!mc-enderman","Spawns a enderman on all players",60,20));
        Commands.add(CommandNodeBuilder.CreateNode("Spider","!mc-spider","Spawns a spider on all players",60,20));
        Commands.add(CommandNodeBuilder.CreateNode("Witch","!mc-witch","Spawns a witch on all players",60,20));
        Commands.add(CommandNodeBuilder.CreateNode("Vindicator","!mc-vindicator","Spawns a vindicator on all players",60,20));
        Commands.add(CommandNodeBuilder.CreateNode("Husk","!mc-husk","Spawns a husk on all players",60,20));
        Commands.add(CommandNodeBuilder.CreateNode("Pillager","!mc-pillager","Spawns a pillager on all players",60,20));
        Commands.add(CommandNodeBuilder.CreateNode("Piglin","!mc-piglin","Spawns a piglin on all players",60,20));
        Commands.add(CommandNodeBuilder.CreateNode("Stray","!mc-stray","Spawns a stray on all players",60,20));

        Commands.add(CommandNodeBuilder.CreateNode("Poison","!mc-poison","Gives all players Poison for 20 seconds",120,30));
        Commands.add(CommandNodeBuilder.CreateNode("Hunger","!mc-hunger","Gives all players Hunger for 20 seconds",120,30));
        Commands.add(CommandNodeBuilder.CreateNode("Weakness","!mc-weakness","Gives all Weakness Poison for 20 seconds",120,30));
        Commands.add(CommandNodeBuilder.CreateNode("Bind","!mc-blind","Gives all players Blindness for 20 seconds",120,30));
        Commands.add(CommandNodeBuilder.CreateNode("Slow","!mc-slow","Gives all players Slowness for 20 seconds",120,30));
        Commands.add(CommandNodeBuilder.CreateNode("Regen","!mc-regen","Gives all players Regeneration for 20 seconds",120,30));
        Commands.add(CommandNodeBuilder.CreateNode("Strength","!mc-strength","Gives all players Strength for 20 seconds",120,30));
        Commands.add(CommandNodeBuilder.CreateNode("Speed","!mc-speed","Gives all players Speed for 20 seconds",120,30));
        Commands.add(CommandNodeBuilder.CreateNode("Haste","!mc-haste","Gives all players Haste for 20 seconds",120,30));
        Commands.add(CommandNodeBuilder.CreateNode("Resistance","!mc-resistance","Gives all players Resistance for 20 seconds",120,30));
        Commands.add(CommandNodeBuilder.CreateNode("NightVision","!mc-nightvision","Gives all players Night Vision for 20 seconds",120,30));

        Commands.add(CommandNodeBuilder.CreateNode("Night","!mc-night","Sets the game time to night",60,20));
        Commands.add(CommandNodeBuilder.CreateNode("Day","!mc-day","Sets the game time to day",60,20));
        Commands.add(CommandNodeBuilder.CreateNode("Thunder","!mc-weatherthunder","Changes weather to thunder",60,20));
        Commands.add(CommandNodeBuilder.CreateNode("Rain","!mc-weatherrain","Changes weather to rain",60,20));
        Commands.add(CommandNodeBuilder.CreateNode("Clear","!mc-weatherclear","Changes weather to clear",60,20));

        Commands.add(CommandNodeBuilder.CreateNode("Steal","!mc-steal","Takes the held item from all players",180,40));
        Commands.add(CommandNodeBuilder.CreateNode("Snatch","!mc-snatch","Takes a random item from all players",180,40));
        Commands.add(CommandNodeBuilder.CreateNode("Food","!mc-food","Gives all players 3 Golden Carrots",180,40));
        Commands.add(CommandNodeBuilder.CreateNode("HealthD","!mc-healthminus","Removes a heart from all players",60,20));
        Commands.add(CommandNodeBuilder.CreateNode("HealthP","!mc-healthplus","Adds a heart to all players",60,20));
        Commands.add(CommandNodeBuilder.CreateNode("Speed25","!mc-speed25","Sets all players speed to 25%",60,20));
        Commands.add(CommandNodeBuilder.CreateNode("Speed50","!mc-speed50","Sets all players speed to 50%",60,20));
        Commands.add(CommandNodeBuilder.CreateNode("Speed100","!mc-speed100","Sets all players speed to 100%",60,20));
        Commands.add(CommandNodeBuilder.CreateNode("Speed150","!mc-speed150","Sets all players speed to 150%",60,20));
        Commands.add(CommandNodeBuilder.CreateNode("Speed200","!mc-speed200","Sets all players speed to 200%",60,20));
        Commands.add(CommandNodeBuilder.CreateNode("Hungry","!mc-hungry","Sets all players hunger to one bar and no saturation",60,20));
        Commands.add(CommandNodeBuilder.CreateNode("Sleepless","!mc-sleepless","Prevents players from using beds",180,40));
        Commands.add(CommandNodeBuilder.CreateNode("Sleepful","!mc-sleepful","Allows players to use beds",180,40));
        Commands.add(CommandNodeBuilder.CreateNode("Death","!mc-death","Kills all players",180,40));
        Commands.add(CommandNodeBuilder.CreateNode("NoChests","!mc-nochests","Prevents players from opening chests and barrels",180,40));
        Commands.add(CommandNodeBuilder.CreateNode("Chests","!mc-chests","Allows players to open chests and barrels",180,40));
        Commands.add(CommandNodeBuilder.CreateNode("Axed","!mc-axed","Gives all players a Stone Axe",180,40));
        Commands.add(CommandNodeBuilder.CreateNode("Pickaxed","!mc-pickaxed","Gives all players a Stone Pickaxe",180,40));
        Commands.add(CommandNodeBuilder.CreateNode("Sworded","!mc-sworded","Gives all players a Stone Sword",180,40));
        Commands.add(CommandNodeBuilder.CreateNode("Hoed","!mc-hoed","Gives all players a Stone Hoe",180,40));
        Commands.add(CommandNodeBuilder.CreateNode("Shoveled","!mc-shoveled","Gives all players a Stone Shovel",180,40));
        Object.addProperty("Version",NLTI.Version);
        Object.add("Commands",Commands);
        JsonWriter WriterJ = new JsonWriter(new FileWriter(Location));
        G.toJson(Object,WriterJ);
        WriterJ.flush();
        WriterJ.close();
    }
}
