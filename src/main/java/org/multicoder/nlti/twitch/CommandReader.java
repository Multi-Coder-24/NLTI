package org.multicoder.nlti.twitch;

import net.minecraft.server.MinecraftServer;
import org.multicoder.nlti.twitch.commands.hermits.*;
import org.multicoder.nlti.twitch.commands.player.*;
import org.multicoder.nlti.twitch.commands.potion.*;
import org.multicoder.nlti.twitch.commands.world.*;

public class CommandReader
{
    public static boolean TryRunCommand(String CommandName, String Username, MinecraftServer server){
        return switch (CommandName) {
            case "Mumbo" -> {
                MumboCommand.PreTrigger(Username, server);
                yield true;
            }
            case "Tango" -> {
                TangoCommand.PreTrigger(Username, server);
                yield true;
            }
            case "Scar" -> {
                ScarCommand.PreTrigger(Username, server);
                yield true;
            }
            case "Poison" -> {
                PoisonCommand.PreTrigger(Username, server);
                yield true;
            }
            case "Hunger" -> {
                HungerCommand.PreTrigger(Username, server);
                yield true;
            }
            case "Weakness" -> {
                WeaknessCommand.PreTrigger(Username, server);
                yield true;
            }
            case "Blindness" -> {
                BlindnessCommand.PreTrigger(Username, server);
                yield true;
            }
            case "Slowness" -> {
                SlownessCommand.PreTrigger(Username, server);
                yield true;
            }
            case "Heal" -> {
                HealCommand.PreTrigger(Username, server);
                yield true;
            }
            case "Strength" -> {
                StrengthCommand.PreTrigger(Username, server);
                yield true;
            }
            case "Speed" -> {
                SpeedCommand.PreTrigger(Username, server);
                yield true;
            }
            case "Haste" -> {
                HasteCommand.PreTrigger(Username, server);
                yield true;
            }
            case "Resistance" -> {
                ResistanceCommand.PreTrigger(Username, server);
                yield true;
            }
            case "NightVision" -> {
                NightVisionCommand.PreTrigger(Username, server);
                yield true;
            }
            case "BadOmen" -> {
                BadOmenCommand.PreTrigger(Username, server);
                yield true;
            }
            case "Absorption" -> {
                AbsorptionCommand.PreTrigger(Username, server);
                yield true;
            }
            case "Darkness" -> {
                DarknessCommand.PreTrigger(Username, server);
                yield true;
            }
            case "FireResistance" -> {
                FireResistanceCommand.PreTrigger(Username, server);
                yield true;
            }
            case "Infested" -> {
                InfestedCommand.PreTrigger(Username, server);
                yield true;
            }
            case "JumpBoost" -> {
                JumpBoostCommand.PreTrigger(Username, server);
                yield true;
            }
            case "Levitation" -> {
                LevitationCommand.PreTrigger(Username, server);
                yield true;
            }
            case "MiningFatigue" -> {
                MiningFatigueCommand.PreTrigger(Username, server);
                yield true;
            }
            case "Nausea" -> {
                NauseaCommand.PreTrigger(Username, server);
                yield true;
            }
            case "Oozing" -> {
                OozingCommand.PreTrigger(Username, server);
                yield true;
            }
            case "Saturation" -> {
                SaturationCommand.PreTrigger(Username, server);
                yield true;
            }
            case "SlowFalling" -> {
                SlowFallingCommand.PreTrigger(Username, server);
                yield true;
            }
            case "WaterBreathing" -> {
                WaterBreathingCommand.PreTrigger(Username, server);
                yield true;
            }
            case "WindCharged" -> {
                WindChargedCommand.PreTrigger(Username, server);
                yield true;
            }
            case "Wither" -> {
                WitherCommand.PreTrigger(Username, server);
                yield true;
            }
            case "Day" -> {
                DayCommand.PreTrigger(Username, server);
                yield true;
            }
            case "Night" -> {
                NightCommand.PreTrigger(Username, server);
                yield true;
            }
            case "WeatherThunder" -> {
                WeatherThunderCommand.PreTrigger(Username, server);
                yield true;
            }
            case "WeatherClear" -> {
                WeatherClearCommand.PreTrigger(Username, server);
                yield true;
            }
            case "WeatherRain" -> {
                WeatherRainCommand.PreTrigger(Username, server);
                yield true;
            }
            case "Nether" -> {
                NetherCommand.PreTrigger(Username, server);
                yield true;
            }
            case "End" -> {
                EndCommand.PreTrigger(Username, server);
                yield true;
            }
            case "Overworld" -> {

                OverworldCommand.PreTrigger(Username, server);
                yield true;
            }
            case "Steal" -> {

                StealCommand.PreTrigger(Username, server);
                yield true;
            }
            case "Snatch" -> {

                SnatchCommand.PreTrigger(Username, server);
                yield true;
            }
            case "Food" -> {

                FoodCommand.PreTrigger(Username, server);
                yield true;
            }
            default -> false;
        };
    }
}
