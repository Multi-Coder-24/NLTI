package org.multicoder.nlti.util;

import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;

import java.util.ArrayList;
import java.util.List;

public class InternalVariables
{
    public static List<SoundEvent> SOUNDS = new ArrayList<>();
    static
    {
       SOUNDS.add(SoundEvents.ENTITY_CREEPER_PRIMED);
       SOUNDS.add(SoundEvents.ENTITY_ENDERMAN_SCREAM);
       SOUNDS.add(SoundEvents.ENTITY_SPIDER_AMBIENT);
       SOUNDS.add(SoundEvents.ENTITY_ZOMBIE_AMBIENT);
       SOUNDS.add(SoundEvents.ENTITY_EVOKER_PREPARE_ATTACK);
       SOUNDS.add(SoundEvents.ENTITY_VEX_CHARGE);
       SOUNDS.add(SoundEvents.ENTITY_SKELETON_AMBIENT);
       SOUNDS.add(SoundEvents.ENTITY_RAVAGER_ROAR);
       SOUNDS.add(SoundEvents.ENTITY_BLAZE_AMBIENT);
    }
}
