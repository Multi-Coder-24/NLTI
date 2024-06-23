package org.multicoder.nlti.mcsi;

import com.google.gson.JsonObject;
import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.command.ServerCommandSource;
import org.multicoder.nlti.NLTI;
import org.multicoder.nlti.config.NLTIConfig;
import org.multicoder.nlti.twitch.MulticoderTwitchConnection;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class MCIS
{
    public String Name;
    public String Description;
    public List<String> Instructions;
    public int NormalCooldown;
    public int ChaosCooldown;
    public LocalDateTime COOLDOWN;

    public MCIS(JsonObject Contents)
    {
        Name = Contents.get("Command").getAsString();
        Description = Contents.get("Description").getAsString();
        NormalCooldown = Contents.get("cooldown").getAsInt();
        ChaosCooldown = Contents.get("chaos_cooldown").getAsInt();
        COOLDOWN = LocalDateTime.now();
        Instructions = new ArrayList<>();
        Contents.get("instructions").getAsJsonArray().forEach(e ->
        {
            Instructions.add(e.getAsString());
        });
    }

    public void Run(MinecraftServer server)
    {
        if(LocalDateTime.now().isAfter(COOLDOWN))
        {
            for(String instruction : Instructions)
            {
                server.getCommandManager().executeWithPrefix(server.getCommandSource(),instruction);
            }
            if(MulticoderTwitchConnection.Config.ChaosMode)
            {
                COOLDOWN = COOLDOWN.plusSeconds(ChaosCooldown);
            }
            else
            {
                COOLDOWN = COOLDOWN.plusSeconds(NormalCooldown);
            }
        }

    }
}
