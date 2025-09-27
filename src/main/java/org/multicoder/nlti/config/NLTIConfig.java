package org.multicoder.nlti.config;

import com.electronwill.nightconfig.core.CommentedConfig;
import com.electronwill.nightconfig.core.file.CommentedFileConfig;
import com.electronwill.nightconfig.toml.TomlParser;
import org.multicoder.nlti.NLTI;

import java.io.File;
import java.io.FileInputStream;

public class NLTIConfig
{
    public static String Token;
    private static String SaveFile;
    public static void CreateOrLoadConfig(String ConfigDirectory) {
        try{
            SaveFile = ConfigDirectory + "/nlti-config.toml";
            File tomlFile = new File(SaveFile);
            if(!tomlFile.exists()) {
                CommentedFileConfig CCFG = CommentedFileConfig.builder(tomlFile).build();
                CCFG.add("token","***");
                CCFG.setComment("token","Please enter your twitch token");
                CCFG.save();
                Token = "***";
            }
            else{
                TomlParser  tomlParser = new TomlParser();
                CommentedConfig CCFG = tomlParser.parse(new FileInputStream(tomlFile));
                Token = CCFG.get("token").toString();
            }
        }
        catch (Exception ex){
            NLTI.LOG.error("[NLTI Twitch] Error When Attempting to Load Config: ", ex);
        }
    }

    public static void SaveUpdate(){
        CommentedFileConfig CCFG = CommentedFileConfig.builder(SaveFile).build();
        CCFG.add("token",Token);
        CCFG.setComment("token","Please enter your twitch token");
        CCFG.save();
    }
}
