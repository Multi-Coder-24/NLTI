package org.multicoder.nlti.cooldowns;

import java.time.LocalDateTime;

public class CooldownManager
{
    //  Mob Commands
    public static LocalDateTime CREEPER;
    public static LocalDateTime SKELETON;
    public static LocalDateTime ZOMBIE;
    public static LocalDateTime ENDERMAN;
    public static LocalDateTime SPIDER;
    public static LocalDateTime WITCH;
    public static LocalDateTime VINDICATOR;
    public static LocalDateTime HUSK;
    public static LocalDateTime PILLAGER;
    public static LocalDateTime PIGLIN;
    public static LocalDateTime STRAY;
    //  Potion Commands
    public static LocalDateTime POISON;
    public static LocalDateTime HUNGER;
    public static LocalDateTime WEAKNESS;
    public static LocalDateTime BLIND;
    public static LocalDateTime SLOW;
    public static LocalDateTime REGEN;
    public static LocalDateTime STRENGTH;
    public static LocalDateTime SPEED;
    public static LocalDateTime HASTE;
    public static LocalDateTime RESISTANCE;
    public static LocalDateTime NIGHTVISION;
    //  Player Commands
    public static LocalDateTime STEAL;
    public static LocalDateTime SNATCH;
    public static LocalDateTime FOOD;
    public static LocalDateTime HEALTH_D;
    public static LocalDateTime HEALTH_P;
    public static LocalDateTime SPEED25;
    public static LocalDateTime SPEED50;
    public static LocalDateTime SPEED100;
    public static LocalDateTime SPEED150;
    public static LocalDateTime SPEED200;
    public static LocalDateTime HUNGRY;
    public static LocalDateTime DEATH;
    public static LocalDateTime AXED;
    public static LocalDateTime PICKAXED;
    public static LocalDateTime SHOVELED;
    public static LocalDateTime SWORDED;
    public static LocalDateTime HOED;
    public static LocalDateTime CAKE;
    //  World Commands
    public static LocalDateTime NIGHT_TIME;
    public static LocalDateTime DAY_TIME;
    public static LocalDateTime THUNDER;
    public static LocalDateTime RAIN;
    public static LocalDateTime CLEAR;


    public static void Init()
    {
        LocalDateTime Now = LocalDateTime.now();
        CREEPER = Now;
        SKELETON = Now;
        ZOMBIE = Now;
        ENDERMAN = Now;
        SPIDER = Now;
        WITCH = Now;
        VINDICATOR = Now;
        HUSK = Now;
        PILLAGER = Now;
        PIGLIN = Now;
        STRAY = Now;
        POISON = Now;
        HUNGER = Now;
        WEAKNESS = Now;
        BLIND = Now;
        SLOW = Now;
        REGEN = Now;
        STRENGTH = Now;
        SPEED = Now;
        HASTE = Now;
        RESISTANCE = Now;
        NIGHTVISION = Now;
        STEAL = Now;
        SNATCH = Now;
        FOOD = Now;
        NIGHT_TIME = Now;
        DAY_TIME = Now;
        HEALTH_D = Now;
        HEALTH_P = Now;
        SPEED25 = Now;
        SPEED50 = Now;
        SPEED100 = Now;
        SPEED150 = Now;
        SPEED200 = Now;
        HUNGRY = Now;
        THUNDER = Now;
        RAIN = Now;
        CLEAR = Now;
        DEATH = Now;
        AXED = Now;
        PICKAXED = Now;
        HOED = Now;
        SHOVELED = Now;
        SWORDED = Now;
        CAKE = Now;
    }
}
