package org.multicoder.nlti.cooldowns;

import java.time.LocalDateTime;

public class CooldownManager
{
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
    public static LocalDateTime STEAL;
    public static LocalDateTime SNATCH;
    public static LocalDateTime FOOD;

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
    }
}
