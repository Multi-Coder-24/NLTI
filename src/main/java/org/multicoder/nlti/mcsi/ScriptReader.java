package org.multicoder.nlti.mcsi;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.stream.JsonReader;
import org.multicoder.nlti.NLTI;
import org.multicoder.nlti.twitch.MulticoderTwitchConnection;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class ScriptReader
{
    public static List<MCIS> Scripts = new ArrayList<>();
    public static void ReadAllScripts(String Folder)
    {
        File F = new File(Folder);
        Arrays.stream(Objects.requireNonNull(F.listFiles())).toList().forEach(Script ->
        {
            Gson G = new Gson();
            try
            {
                JsonReader JSON = new JsonReader(new FileReader(Script));
                JsonObject Contents = G.fromJson(JSON,JsonObject.class);
                Scripts.add(new MCIS(Contents));
            } catch (Exception e)
            {
                NLTI.LOGGER.error("Error Reading Script: {}",e.getMessage());
                NLTI.LOGGER.error("Caused By: ",e);
            }
        });
    }
    public static void ExecuteScript(String Name)
    {
        NLTI.LOGGER.info("Finding Script With Name {}",Name);
        MCIS Script = (MCIS) Scripts.stream().filter(s -> s.Name.equals(Name)).toArray()[0];
        NLTI.LOGGER.info("Script: {}",Script);
        Script.Run(MulticoderTwitchConnection.SERVER);
    }
}
