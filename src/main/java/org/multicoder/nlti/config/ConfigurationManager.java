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
            NLTI.LOGGER.info("Initializing Config");
            JsonReader MainReader = new JsonReader(new FileReader(Main));
            JsonReader CooldownReader = new JsonReader(new FileReader(Cooldown));
            JsonObject MainConfigJSON = G.fromJson(MainReader,JsonObject.class);
            JsonObject CooldownConfigJSON = G.fromJson(CooldownReader,JsonObject.class);
            MulticoderTwitchConnection.Config = new NLTIConfig(MainConfigJSON,CooldownConfigJSON);
        }
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
        JsonArray CommandsList = new JsonArray();

        //  Mob Spawn Commands
        JsonObject CreeperCommand = new JsonObject();
        JsonObject SkeletonCommand = new JsonObject();
        JsonObject ZombieCommand = new JsonObject();
        JsonObject EndermanCommand = new JsonObject();
        JsonObject SpiderCommand = new JsonObject();
        JsonObject WitchCommand = new JsonObject();
        JsonObject VindicatorCommand = new JsonObject();
        JsonObject HuskCommand = new JsonObject();
        JsonObject PillagerCommand = new JsonObject();
        JsonObject PiglinCommand = new JsonObject();
        JsonObject StrayCommand = new JsonObject();

        CreeperCommand.addProperty("Trigger","!mc-creeper");
        CreeperCommand.addProperty("CommandID","creeper|DO NOT EDIT");
        CreeperCommand.addProperty("NormalCooldown",60);
        CreeperCommand.addProperty("ChaosCooldown",20);

        SkeletonCommand.addProperty("Trigger","!mc-skeleton");
        SkeletonCommand.addProperty("CommandID","skeleton|DO NOT EDIT");
        SkeletonCommand.addProperty("NormalCooldown",60);
        SkeletonCommand.addProperty("ChaosCooldown",20);

        ZombieCommand.addProperty("Trigger","!mc-zombie");
        ZombieCommand.addProperty("CommandID","zombie|DO NOT EDIT");
        ZombieCommand.addProperty("NormalCooldown",60);
        ZombieCommand.addProperty("ChaosCooldown",20);

        EndermanCommand.addProperty("Trigger","!mc-enderman");
        EndermanCommand.addProperty("CommandID","enderman|DO NOT EDIT");
        EndermanCommand.addProperty("NormalCooldown",60);
        EndermanCommand.addProperty("ChaosCooldown",20);

        SpiderCommand.addProperty("Trigger","!mc-spider");
        SpiderCommand.addProperty("CommandID","spider|DO NOT EDIT");
        SpiderCommand.addProperty("NormalCooldown",60);
        SpiderCommand.addProperty("ChaosCooldown",20);

        WitchCommand.addProperty("Trigger","!mc-witch");
        WitchCommand.addProperty("CommandID","witch|DO NOT EDIT");
        WitchCommand.addProperty("NormalCooldown",60);
        WitchCommand.addProperty("ChaosCooldown",20);

        VindicatorCommand.addProperty("Trigger","!mc-vindicator");
        VindicatorCommand.addProperty("CommandID","vindicator|DO NOT EDIT");
        VindicatorCommand.addProperty("NormalCooldown",60);
        VindicatorCommand.addProperty("ChaosCooldown",20);

        HuskCommand.addProperty("Trigger","!mc-husk");
        HuskCommand.addProperty("CommandID","husk|DO NOT EDIT");
        HuskCommand.addProperty("NormalCooldown",60);
        HuskCommand.addProperty("ChaosCooldown",20);

        PillagerCommand.addProperty("Trigger","!mc-pillager");
        PillagerCommand.addProperty("CommandID","pillager|DO NOT EDIT");
        PillagerCommand.addProperty("NormalCooldown",60);
        PillagerCommand.addProperty("ChaosCooldown",20);

        PiglinCommand.addProperty("Trigger","!mc-piglin");
        PiglinCommand.addProperty("CommandID","piglin|DO NOT EDIT");
        PiglinCommand.addProperty("NormalCooldown",60);
        PiglinCommand.addProperty("ChaosCooldown",20);

        StrayCommand.addProperty("Trigger","!mc-stray");
        StrayCommand.addProperty("CommandID","stray|DO NOT EDIT");
        StrayCommand.addProperty("NormalCooldown",60);
        StrayCommand.addProperty("ChaosCooldown",20);

        //  Effect Commands
        JsonObject PoisonCommand = new JsonObject();
        JsonObject HungerCommand = new JsonObject();
        JsonObject WeaknessCommand = new JsonObject();
        JsonObject BlindnessCommand = new JsonObject();
        JsonObject SlowCommand = new JsonObject();
        JsonObject RegenCommand = new JsonObject();
        JsonObject StrengthCommand = new JsonObject();
        JsonObject SpeedCommand = new JsonObject();
        JsonObject HasteCommand = new JsonObject();
        JsonObject ResistanceCommand = new JsonObject();
        JsonObject NightVisionCommand = new JsonObject();

        PoisonCommand.addProperty("Trigger","!mc-poison");
        PoisonCommand.addProperty("CommandID","poison|DO NOT EDIT");
        PoisonCommand.addProperty("NormalCooldown",120);
        PoisonCommand.addProperty("ChaosCooldown",30);

        HungerCommand.addProperty("Trigger","!mc-hunger");
        HungerCommand.addProperty("CommandID","hunger|DO NOT EDIT");
        HungerCommand.addProperty("NormalCooldown",120);
        HungerCommand.addProperty("ChaosCooldown",30);

        WeaknessCommand.addProperty("Trigger","!mc-weakness");
        WeaknessCommand.addProperty("CommandID","weakness|DO NOT EDIT");
        WeaknessCommand.addProperty("NormalCooldown",120);
        WeaknessCommand.addProperty("ChaosCooldown",30);

        BlindnessCommand.addProperty("Trigger","!mc-blind");
        BlindnessCommand.addProperty("CommandID","blind|DO NOT EDIT");
        BlindnessCommand.addProperty("NormalCooldown",120);
        BlindnessCommand.addProperty("ChaosCooldown",30);

        SlowCommand.addProperty("Trigger","!mc-slow");
        SlowCommand.addProperty("CommandID","slow|DO NOT EDIT");
        SlowCommand.addProperty("NormalCooldown",120);
        SlowCommand.addProperty("ChaosCooldown",30);

        RegenCommand.addProperty("Trigger","!mc-regen");
        RegenCommand.addProperty("CommandID","regen|DO NOT EDIT");
        RegenCommand.addProperty("NormalCooldown",120);
        RegenCommand.addProperty("ChaosCooldown",30);

        StrengthCommand.addProperty("Trigger","!mc-strength");
        StrengthCommand.addProperty("CommandID","strength|DO NOT EDIT");
        StrengthCommand.addProperty("NormalCooldown",120);
        StrengthCommand.addProperty("ChaosCooldown",30);

        SpeedCommand.addProperty("Trigger","!mc-speed");
        SpeedCommand.addProperty("CommandID","speed|DO NOT EDIT");
        SpeedCommand.addProperty("NormalCooldown",120);
        SpeedCommand.addProperty("ChaosCooldown",30);

        HasteCommand.addProperty("Trigger","!mc-haste");
        HasteCommand.addProperty("CommandID","haste|DO NOT EDIT");
        HasteCommand.addProperty("NormalCooldown",120);
        HasteCommand.addProperty("ChaosCooldown",30);

        ResistanceCommand.addProperty("Trigger","!mc-resistance");
        ResistanceCommand.addProperty("CommandID","resistance|DO NOT EDIT");
        ResistanceCommand.addProperty("NormalCooldown",120);
        ResistanceCommand.addProperty("ChaosCooldown",30);

        NightVisionCommand.addProperty("Trigger","!mc-nightvision");
        NightVisionCommand.addProperty("CommandID","nightvision|DO NOT EDIT");
        NightVisionCommand.addProperty("NormalCooldown",120);
        NightVisionCommand.addProperty("ChaosCooldown",30);

        //  World Effect Commands
        JsonObject Night = new JsonObject();
        JsonObject Day = new JsonObject();
        JsonObject Thunder = new JsonObject();
        JsonObject Rain = new JsonObject();
        JsonObject Clear = new JsonObject();

        Night.addProperty("Trigger","!mc-night");
        Night.addProperty("CommandID","night|DO NOT EDIT");
        Night.addProperty("NormalCooldown",100);
        Night.addProperty("ChaosCooldown",25);

        Day.addProperty("Trigger","!mc-day");
        Day.addProperty("CommandID","day|DO NOT EDIT");
        Day.addProperty("NormalCooldown",100);
        Day.addProperty("ChaosCooldown",25);

        Thunder.addProperty("Trigger","!mc-thunder");
        Thunder.addProperty("CommandID","thunder|DO NOT EDIT");
        Thunder.addProperty("NormalCooldown",100);
        Thunder.addProperty("ChaosCooldown",25);

        Rain.addProperty("Trigger","!mc-rain");
        Rain.addProperty("CommandID","rain|DO NOT EDIT");
        Rain.addProperty("NormalCooldown",100);
        Rain.addProperty("ChaosCooldown",25);

        Clear.addProperty("Trigger","!mc-clear");
        Clear.addProperty("CommandID","clear|DO NOT EDIT");
        Clear.addProperty("NormalCooldown",100);
        Clear.addProperty("ChaosCooldown",25);

        //  Util Commands
        JsonObject HealthD = new JsonObject();
        JsonObject HealthP = new JsonObject();
        JsonObject Speed25 = new JsonObject();
        JsonObject Speed50 = new JsonObject();
        JsonObject Speed100 = new JsonObject();
        JsonObject Speed150 = new JsonObject();
        JsonObject Speed200 = new JsonObject();
        JsonObject Hungry = new JsonObject();
        JsonObject Axed = new JsonObject();
        JsonObject Shoveled = new JsonObject();
        JsonObject Pickaxed = new JsonObject();
        JsonObject Sworded = new JsonObject();
        JsonObject Hoed = new JsonObject();
        JsonObject Death = new JsonObject();
        JsonObject Sleepful = new JsonObject();
        JsonObject Sleepless = new JsonObject();
        JsonObject Chests = new JsonObject();
        JsonObject NoChests = new JsonObject();
        JsonObject Steal = new JsonObject();
        JsonObject Snatch = new JsonObject();
        JsonObject Food = new JsonObject();

        HealthD.addProperty("Trigger","!mc-healthd");
        HealthD.addProperty("CommandID","healthd|DO NOT EDIT");
        HealthD.addProperty("NormalCooldown",180);
        HealthD.addProperty("ChaosCooldown",40);

        HealthP.addProperty("Trigger","!mc-healthp");
        HealthP.addProperty("CommandID","healthp|DO NOT EDIT");
        HealthP.addProperty("NormalCooldown",180);
        HealthP.addProperty("ChaosCooldown",40);

        Speed25.addProperty("Trigger","!mc-speed25");
        Speed25.addProperty("CommandID","speed25|DO NOT EDIT");
        Speed25.addProperty("NormalCooldown",180);
        Speed25.addProperty("ChaosCooldown",40);

        Speed50.addProperty("Trigger","!mc-speed50");
        Speed50.addProperty("CommandID","speed50|DO NOT EDIT");
        Speed50.addProperty("NormalCooldown",180);
        Speed50.addProperty("ChaosCooldown",40);

        Speed100.addProperty("Trigger","!mc-speed100");
        Speed100.addProperty("CommandID","speed100|DO NOT EDIT");
        Speed100.addProperty("NormalCooldown",180);
        Speed100.addProperty("ChaosCooldown",40);

        Speed150.addProperty("Trigger","!mc-speed150");
        Speed150.addProperty("CommandID","speed150|DO NOT EDIT");
        Speed150.addProperty("NormalCooldown",180);
        Speed150.addProperty("ChaosCooldown",40);

        Speed200.addProperty("Trigger","!mc-speed200");
        Speed200.addProperty("CommandID","speed200|DO NOT EDIT");
        Speed200.addProperty("NormalCooldown",180);
        Speed200.addProperty("ChaosCooldown",40);

        Hungry.addProperty("Trigger","!mc-hungry");
        Hungry.addProperty("CommandID","hungry|DO NOT EDIT");
        Hungry.addProperty("NormalCooldown",180);
        Hungry.addProperty("ChaosCooldown",40);

        Axed.addProperty("Trigger","!mc-axe");
        Axed.addProperty("CommandID","axe|DO NOT EDIT");
        Axed.addProperty("NormalCooldown",180);
        Axed.addProperty("ChaosCooldown",40);

        Shoveled.addProperty("Trigger","!mc-shovel");
        Shoveled.addProperty("CommandID","shovel|DO NOT EDIT");
        Shoveled.addProperty("NormalCooldown",180);
        Shoveled.addProperty("ChaosCooldown",40);

        Pickaxed.addProperty("Trigger","!mc-pickaxe");
        Pickaxed.addProperty("CommandID","pickaxe|DO NOT EDIT");
        Pickaxed.addProperty("NormalCooldown",180);
        Pickaxed.addProperty("ChaosCooldown",40);

        Sworded.addProperty("Trigger","!mc-sword");
        Sworded.addProperty("CommandID","sword|DO NOT EDIT");
        Sworded.addProperty("NormalCooldown",180);
        Sworded.addProperty("ChaosCooldown",40);

        Hoed.addProperty("Trigger","!mc-hoe");
        Hoed.addProperty("CommandID","hoe|DO NOT EDIT");
        Hoed.addProperty("NormalCooldown",180);
        Hoed.addProperty("ChaosCooldown",40);

        Death.addProperty("Trigger","!mc-death");
        Death.addProperty("CommandID","death|DO NOT EDIT");
        Death.addProperty("NormalCooldown",180);
        Death.addProperty("ChaosCooldown",40);

        Sleepful.addProperty("Trigger","!mc-sleepful");
        Sleepful.addProperty("CommandID","sleepful|DO NOT EDIT");
        Sleepful.addProperty("NormalCooldown",180);
        Sleepful.addProperty("ChaosCooldown",40);

        Sleepless.addProperty("Trigger","!mc-sleepless");
        Sleepless.addProperty("CommandID","sleepless|DO NOT EDIT");
        Sleepless.addProperty("NormalCooldown",180);
        Sleepless.addProperty("ChaosCooldown",40);

        Chests.addProperty("Trigger","!mc-chests");
        Chests.addProperty("CommandID","chests|DO NOT EDIT");
        Chests.addProperty("NormalCooldown",180);
        Chests.addProperty("ChaosCooldown",40);

        NoChests.addProperty("Trigger","!mc-nochests");
        NoChests.addProperty("CommandID","nochests|DO NOT EDIT");
        NoChests.addProperty("NormalCooldown",180);
        NoChests.addProperty("ChaosCooldown",40);

        Steal.addProperty("Trigger","!mc-steal");
        Steal.addProperty("CommandID","steal|DO NOT EDIT");
        Steal.addProperty("NormalCooldown",180);
        Steal.addProperty("ChaosCooldown",40);

        Snatch.addProperty("Trigger","!mc-snatch");
        Snatch.addProperty("CommandID","snatch|DO NOT EDIT");
        Snatch.addProperty("NormalCooldown",180);
        Snatch.addProperty("ChaosCooldown",40);

        Food.addProperty("Trigger","!mc-food");
        Food.addProperty("CommandID","food|DO NOT EDIT");
        Food.addProperty("NormalCooldown",180);
        Food.addProperty("ChaosCooldown",40);

        CommandsList.add(CreeperCommand);
        CommandsList.add(SkeletonCommand);
        CommandsList.add(ZombieCommand);
        CommandsList.add(EndermanCommand);
        CommandsList.add(SpiderCommand);
        CommandsList.add(WitchCommand);
        CommandsList.add(VindicatorCommand);
        CommandsList.add(StrayCommand);
        CommandsList.add(PillagerCommand);
        CommandsList.add(PiglinCommand);
        CommandsList.add(HuskCommand);

        CommandsList.add(BlindnessCommand);
        CommandsList.add(HasteCommand);
        CommandsList.add(HungerCommand);
        CommandsList.add(NightVisionCommand);
        CommandsList.add(PoisonCommand);
        CommandsList.add(RegenCommand);
        CommandsList.add(ResistanceCommand);
        CommandsList.add(SlowCommand);
        CommandsList.add(SpeedCommand);
        CommandsList.add(StrengthCommand);
        CommandsList.add(WeaknessCommand);

        CommandsList.add(Clear);
        CommandsList.add(Day);
        CommandsList.add(Night);
        CommandsList.add(Rain);
        CommandsList.add(Thunder);

        CommandsList.add(Axed);
        CommandsList.add(Chests);
        CommandsList.add(Death);
        CommandsList.add(Food);
        CommandsList.add(HealthD);
        CommandsList.add(HealthP);
        CommandsList.add(Hoed);
        CommandsList.add(Hungry);
        CommandsList.add(NoChests);
        CommandsList.add(Pickaxed);
        CommandsList.add(Shoveled);
        CommandsList.add(Sleepful);
        CommandsList.add(Sleepless);
        CommandsList.add(Snatch);
        CommandsList.add(Speed25);
        CommandsList.add(Speed50);
        CommandsList.add(Speed100);
        CommandsList.add(Speed150);
        CommandsList.add(Speed200);
        CommandsList.add(Steal);
        CommandsList.add(Sworded);

        Object.add("Commands",CommandsList);


        JsonWriter WriterJ = new JsonWriter(new FileWriter(Location));
        G.toJson(Object,WriterJ);
        WriterJ.flush();
        WriterJ.close();
    }
}
