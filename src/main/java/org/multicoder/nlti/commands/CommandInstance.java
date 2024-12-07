package org.multicoder.nlti.commands;

import org.multicoder.nlti.NLTI;
import org.multicoder.nlti.commands.mob.*;
import org.multicoder.nlti.commands.player.*;
import org.multicoder.nlti.commands.potion.*;
import org.multicoder.nlti.commands.world.*;
import org.multicoder.nlti.twitch.MulticoderTwitchConnection;
import java.time.LocalDateTime;

public class CommandInstance
{
    public String Trigger;
    public int Normal;
    public int Chaos;
    public LocalDateTime Cooldown;
    public String CommandID;

    public CommandInstance(String trigger, int[] cooldowns,String ID) throws Exception
    {
        Trigger = trigger;
        Normal = cooldowns[0];
        Chaos = cooldowns[1];
        Cooldown = LocalDateTime.now();
        CommandID = ID;
    }

    public void Trigger(String Username,String Channel)
    {
        NLTI.LOGGER.info("CommandID: " + CommandID);
        switch (CommandID)
        {
            case "creeper" -> Creeper.Trigger(Username, Channel);
            case "enderman" -> Enderman.Trigger(Username, Channel);
            case "husk" -> Husk.Trigger(Username, Channel);
            case "piglin" -> Piglin.Trigger(Username, Channel);
            case "pillager" -> Pillager.Trigger(Username, Channel);
            case "skeleton" -> Skeleton.Trigger(Username, Channel);
            case "spider" -> Spider.Trigger(Username, Channel);
            case "stray" -> Stray.Trigger(Username, Channel);
            case "vindicator" -> Vindicator.Trigger(Username, Channel);
            case "witch" -> Witch.Trigger(Username, Channel);
            case "axe" -> Axed.Trigger(Username, Channel);
            case "chests" -> Chests.Trigger(Username, Channel);
            case "death" -> Death.Trigger(Username, Channel);
            case "food" -> Food.Trigger(Username, Channel);
            case "healthd" -> HealthD.Trigger(Username, Channel);
            case "healthp" -> HealthP.Trigger(Username, Channel);
            case "hoe" -> Hoed.Trigger(Username, Channel);
            case "hungry" -> Hungry.Trigger(Username, Channel);
            case "nochests" -> NoChests.Trigger(Username, Channel);
            case "pickaxe" -> Pickaxed.Trigger(Username, Channel);
            case "shovel" -> Shoveled.Trigger(Username, Channel);
            case "sleepful" -> Sleepful.Trigger(Username, Channel);
            case "sleepless" -> Sleepless.Trigger(Username, Channel);
            case "snatch" -> Snatch.Trigger(Username, Channel);
            case "speed25" -> Speed25.Trigger(Username, Channel);
            case "speed50" -> Speed50.Trigger(Username, Channel);
            case "speed100" -> Speed100.Trigger(Username, Channel);
            case "speed150" -> Speed150.Trigger(Username, Channel);
            case "speed200" -> Speed200.Trigger(Username, Channel);
            case "steal" -> Steal.Trigger(Username, Channel);
            case "blind" -> Blind.Trigger(Username, Channel);
            case "haste" -> Haste.Trigger(Username, Channel);
            case "hunger" -> Hunger.Trigger(Username, Channel);
            case "nightvision" ->NightVision.Trigger(Username, Channel);
            case "poison" -> Poison.Trigger(Username, Channel);
            case "regen" -> Regen.Trigger(Username, Channel);
            case "speed" -> Speed.Trigger(Username, Channel);
            case "strength" -> Strength.Trigger(Username, Channel);
            case "day" -> DayTime.Trigger(Username, Channel);
            case "night" -> NightTime.Trigger(Username, Channel);
            case "rain" -> Rain.Trigger(Username, Channel);
            case "thunder" -> Thunder.Trigger(Username, Channel);
            case "clear" -> Clear.Trigger(Username, Channel);
            case "door" -> Door.Trigger(Username, Channel);
            case "nodoor" -> NoDoor.Trigger(Username, Channel);
        }
    }
}
