package org.multicoder.nlti.commands;

import org.multicoder.nlti.commands.mob.*;
import org.multicoder.nlti.commands.player.*;
import org.multicoder.nlti.commands.potion.*;
import org.multicoder.nlti.commands.world.*;

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
        Cooldown = LocalDateTime.now().minusSeconds(1);
        CommandID = ID;
    }

    public void Trigger(String Username,String Channel)
    {
        switch (CommandID)
        {
            case "creeper" -> Creeper.Trigger(Username, Channel,this);
            case "enderman" -> Enderman.Trigger(Username, Channel,this);
            case "husk" -> Husk.Trigger(Username, Channel,this);
            case "piglin" -> Piglin.Trigger(Username, Channel,this);
            case "pillager" -> Pillager.Trigger(Username, Channel,this);
            case "skeleton" -> Skeleton.Trigger(Username, Channel,this);
            case "spider" -> Spider.Trigger(Username, Channel,this);
            case "stray" -> Stray.Trigger(Username, Channel,this);
            case "vindicator" -> Vindicator.Trigger(Username, Channel,this);
            case "witch" -> Witch.Trigger(Username, Channel,this);
            case "cow" -> Cow.Trigger(Username, Channel,this);
            case "chicken" -> Chicken.Trigger(Username, Channel,this);
            case "pig" -> Pig.Trigger(Username, Channel,this);
            case "sheep" -> Sheep.Trigger(Username, Channel,this);
            case "blaze" -> Blaze.Trigger(Username, Channel,this);
            case "evoker" -> Evoker.Trigger(Username, Channel,this);
            case "ravager" -> Ravager.Trigger(Username, Channel,this);
            case "slime" -> Slime.Trigger(Username, Channel,this);
            case "vex" -> Vex.Trigger(Username, Channel,this);
            case "zombie" -> Zombie.Trigger(Username, Channel,this);
            case "witherskeleton" -> WitherSkeleton.Trigger(Username, Channel,this);

            case "axe" -> Axed.Trigger(Username, Channel,this);
            case "sword" -> Sworded.Trigger(Username, Channel,this);
            case "chests" -> Chests.Trigger(Username, Channel,this);
            case "death" -> Death.Trigger(Username, Channel,this);
            case "food" -> Food.Trigger(Username, Channel,this);
            case "healthd" -> HealthD.Trigger(Username, Channel,this);
            case "healthp" -> HealthP.Trigger(Username, Channel,this);
            case "hoe" -> Hoed.Trigger(Username, Channel,this);
            case "hungry" -> Hungry.Trigger(Username, Channel,this);
            case "nochests" -> NoChests.Trigger(Username, Channel,this);
            case "pickaxe" -> Pickaxed.Trigger(Username, Channel,this);
            case "shovel" -> Shoveled.Trigger(Username, Channel,this);
            case "sleepful" -> Sleepful.Trigger(Username, Channel,this);
            case "sleepless" -> Sleepless.Trigger(Username, Channel,this);
            case "snatch" -> Snatch.Trigger(Username, Channel,this);
            case "speed25" -> Speed25.Trigger(Username, Channel,this);
            case "speed50" -> Speed50.Trigger(Username, Channel,this);
            case "speed100" -> Speed100.Trigger(Username, Channel,this);
            case "speed150" -> Speed150.Trigger(Username, Channel,this);
            case "speed200" -> Speed200.Trigger(Username, Channel,this);
            case "steal" -> Steal.Trigger(Username, Channel,this);
            case "scare" -> JumpScare.Trigger(Username, Channel,this);

            case "blind" -> Blind.Trigger(Username, Channel,this);
            case "haste" -> Haste.Trigger(Username, Channel,this);
            case "hunger" -> Hunger.Trigger(Username, Channel,this);
            case "nightvision" ->NightVision.Trigger(Username, Channel,this);
            case "poison" -> Poison.Trigger(Username, Channel,this);
            case "regen" -> Regen.Trigger(Username, Channel,this);
            case "speed" -> Speed.Trigger(Username, Channel,this);
            case "resistance" -> Resistance.Trigger(Username, Channel,this);
            case "slow" -> Slow.Trigger(Username, Channel,this);
            case "strength" -> Strength.Trigger(Username, Channel,this);
            case "weakness" -> Weakness.Trigger(Username, Channel,this);

            case "day" -> DayTime.Trigger(Username, Channel,this);
            case "night" -> NightTime.Trigger(Username, Channel,this);
            case "rain" -> Rain.Trigger(Username, Channel,this);
            case "thunder" -> Thunder.Trigger(Username, Channel,this);
            case "clear" -> Clear.Trigger(Username, Channel,this);

            case "door" -> Door.Trigger(Username, Channel,this);
            case "nodoor" -> NoDoor.Trigger(Username, Channel,this);
            case "crouch" -> Crouch.Trigger(Username,Channel,this);
        }
    }
}
