package org.multicoder.nlti.config;

import com.electronwill.nightconfig.core.CommentedConfig;
import com.electronwill.nightconfig.core.file.CommentedFileConfig;
import com.electronwill.nightconfig.toml.TomlParser;
import net.minecraft.server.MinecraftServer;
import org.multicoder.nlti.NLTI;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;

@SuppressWarnings("all")
public class ModConfig {
    public static String Token;
    public static int BaseCooldown;
    public static String[] BlackListedMobs;
    private static String SaveFile;
    private static String TokenFile;
    public static void CreateOrLoadConfig(MinecraftServer server) {
        try{
            String ConfigDirectory = server.getServerDirectory() + "/config/NLTI/";
            File Dir = new File(ConfigDirectory);
            if(!Dir.exists()){
                var ignored = Dir.mkdir();
            }
            SaveFile = ConfigDirectory + "nlti-config.toml";
            TokenFile = ConfigDirectory + "nlti-token.toml";
            File tomlFile = new File(TokenFile);
            if(!tomlFile.exists()) {
                var ignored = tomlFile.createNewFile();
                CommentedFileConfig CCFG = CommentedFileConfig.builder(tomlFile).build();
                CCFG.add("token","***");
                CCFG.setComment("token","DO NOT EDIT THIS");
                CCFG.save();
                Token = "***";
            }
            else{
                TomlParser tomlParser = new TomlParser();
                CommentedConfig CCFG = tomlParser.parse(new FileInputStream(tomlFile));
                Token = CCFG.get("token").toString();
            }
            tomlFile = new File(SaveFile);
            if(!tomlFile.exists()) {
                var ignored = tomlFile.createNewFile();
                CommentedFileConfig CCFG = CommentedFileConfig.builder(tomlFile).build();
                CCFG.add("base-cooldown",90);
                CCFG.setComment("base-cooldown","Cooldown in seconds of all !MC- Commands");
                CCFG.add("blacklisted-mobs",List.of("warden","wither","ender_dragon"));
                CCFG.setComment("blacklisted-mobs","List of Mobs that the !MC-Mob command cannot use");
                CCFG.save();
                BaseCooldown = 90;
                BlackListedMobs = List.of("warden","wither","ender_dragon").toArray(new String[0]);
            }
            else{
                TomlParser tomlParser = new TomlParser();
                CommentedConfig CCFG = tomlParser.parse(new FileInputStream(tomlFile));
                BaseCooldown = CCFG.getInt("base-cooldown");
                BlackListedMobs = ((List<String>) CCFG.get("blacklisted-mobs")).toArray(new String[0]);
            }
        }
        catch (Exception ex){
            NLTI.LOG.error("[NLTI Twitch] Error When Attempting to Load Config: ", ex);
        }
    }

    public static void SaveUpdateToken(){
        CommentedFileConfig CCFG = CommentedFileConfig.builder(TokenFile).build();
        CCFG.add("token",Token);
        CCFG.setComment("token","DO NOT EDIT THIS");
        CCFG.save();
    }
}
