package org.multicoder.nlti.util;

import net.minecraft.text.Text;
import org.multicoder.nlti.commands.mob.*;
import org.multicoder.nlti.commands.player.*;
import org.multicoder.nlti.commands.potion.*;
import org.multicoder.nlti.commands.world.*;
import org.multicoder.nlti.twitch.MulticoderTwitchConnection;

public class CommandParser
{
    public static void ParseCommand(String Command,String User,String Channel,boolean Bypass)
    {
        if(!Bypass)
        {
            switch (Command)
            {
                case "creeper" -> Creeper.Trigger(User,Channel);
                case "skeleton" -> Skeleton.Trigger(User,Channel);
                case "zombie" -> Zombie.Trigger(User,Channel);
                case "enderman" -> Enderman.Trigger(User,Channel);
                case "spider" -> Spider.Trigger(User,Channel);
                case "witch" -> Witch.Trigger(User,Channel);
                case "vindicator" -> Vindicator.Trigger(User,Channel);
                case "husk" -> Husk.Trigger(User,Channel);
                case "pillager" -> Pillager.Trigger(User,Channel);
                case "piglin" -> Piglin.Trigger(User,Channel);
                case "stray" -> Stray.Trigger(User,Channel);
                case "poison" -> Poison.Trigger(User,Channel);
                case "hunger" -> Hunger.Trigger(User,Channel);
                case "weakness" -> Weakness.Trigger(User,Channel);
                case "blind" -> Blind.Trigger(User,Channel);
                case "slow" -> Slow.Trigger(User,Channel);
                case "regen" -> Regen.Trigger(User,Channel);
                case "strength" -> Strength.Trigger(User,Channel);
                case "speed" -> Speed.Trigger(User,Channel);
                case "haste" -> Haste.Trigger(User,Channel);
                case "resistance" ->Resistance.Trigger(User,Channel);
                case "nightvision" -> NightVision.Trigger(User,Channel);
                case "steal" ->Steal.Trigger(User,Channel);
                case "snatch" -> Snatch.Trigger(User,Channel);
                case "food" -> Food.Trigger(User,Channel);
                case "night" -> NightTime.Trigger(User,Channel);
                case "day" -> DayTime.Trigger(User,Channel);
                case "healthminus" -> HealthD.Trigger(User,Channel);
                case "healthplus" -> HealthP.Trigger(User,Channel);
                case "speed50" -> Speed50.Trigger(User,Channel);
                case "speed25" -> Speed25.Trigger(User,Channel);
                case "speed100" -> Speed100.Trigger(User,Channel);
                case "speed150" -> Speed150.Trigger(User,Channel);
                case "speed200" -> Speed200.Trigger(User,Channel);
                case "hungry" -> Hungry.Trigger(User,Channel);
                case "weatherrain" -> Rain.Trigger(User,Channel);
                case "weatherthunder" -> Thunder.Trigger(User,Channel);
                case "weatherclear" -> Clear.Trigger(User,Channel);
                case "spoonie" -> Cake.Trigger(User,Channel);
                case "death" -> Death.Trigger(User,Channel);
                case "axe" -> Axed.Trigger(User,Channel);
                case "pickaxe" -> Pickaxed.Trigger(User,Channel);
                case "sword" -> Sworded.Trigger(User,Channel);
                case "shovel" -> Shoveled.Trigger(User,Channel);
                case "hoe" -> Hoed.Trigger(User,Channel);
                case "sleepless" -> Sleepless.Trigger(User,Channel);
                case "sleepful" -> Sleepful.Trigger(User,Channel);
                default -> {
                    MulticoderTwitchConnection.CHAT.sendMessage(Channel,"@" + User + " Sorry but this command does not exist");
                    MulticoderTwitchConnection.CHAT.sendMessage(Channel,"!nlti");
                }
            }
        }
        else{
            switch (Command)
            {
                case "creeper" -> Creeper.Trigger();
                case "skeleton" -> Skeleton.Trigger();
                case "zombie" -> Zombie.Trigger();
                case "enderman" -> Enderman.Trigger();
                case "spider" -> Spider.Trigger();
                case "witch" -> Witch.Trigger();
                case "vindicator" -> Vindicator.Trigger();
                case "husk" -> Husk.Trigger();
                case "pillager" -> Pillager.Trigger();
                case "piglin" -> Piglin.Trigger();
                case "stray" -> Stray.Trigger();
                case "poison" -> Poison.Trigger();
                case "hunger" -> Hunger.Trigger();
                case "weakness" -> Weakness.Trigger();
                case "blind" -> Blind.Trigger();
                case "slow" -> Slow.Trigger();
                case "regen" -> Regen.Trigger();
                case "strength" -> Strength.Trigger();
                case "speed" -> Speed.Trigger();
                case "haste" -> Haste.Trigger();
                case "resistance" ->Resistance.Trigger();
                case "nightvision" ->NightVision.Trigger();
                case "steal" ->Steal.Trigger();
                case "snatch" ->Snatch.Trigger();
                case "food" ->Food.Trigger();
                case "night" ->NightTime.Trigger();
                case "day" ->DayTime.Trigger();
                case "healthminus" -> HealthD.Trigger();
                case "healthplus" -> HealthP.Trigger();
                case "speed50" -> Speed50.Trigger();
                case "speed25" -> Speed25.Trigger();
                case "speed100" -> Speed100.Trigger();
                case "speed150" -> Speed150.Trigger();
                case "speed200" -> Speed200.Trigger();
                case "hungry" -> Hungry.Trigger();
                case "weatherrain" -> Rain.Trigger();
                case "weatherthunder" -> Thunder.Trigger();
                case "weatherclear" -> Clear.Trigger();
                case "spoonie" -> Cake.Trigger();
                case "death" -> Death.Trigger();
                case "axe" -> Axed.Trigger();
                case "pickaxe" -> Pickaxed.Trigger();
                case "sword" -> Sworded.Trigger();
                case "shovel" -> Shoveled.Trigger();
                case "hoe" -> Hoed.Trigger();
                case "sleepless" -> Sleepless.Trigger();
                case "sleepful" -> Sleepful.Trigger();
                default -> MulticoderTwitchConnection.SERVER.getPlayerManager().broadcast(Text.literal("That Command Does Not Exist"),true);
            }
        }
    }
}
