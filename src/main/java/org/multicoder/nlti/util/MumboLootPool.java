package org.multicoder.nlti.util;

import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.math.random.Random;

import java.util.ArrayList;
import java.util.List;

public class MumboLootPool
{
    public static final List<ItemStack> LOOT = new ArrayList<>();

    static
    {
        LOOT.add(new ItemStack(Items.REDSTONE_BLOCK));
        LOOT.add(new ItemStack(Items.REDSTONE_TORCH));
        LOOT.add(new ItemStack(Items.REPEATER));
        LOOT.add(new ItemStack(Items.COMPARATOR));
        LOOT.add(new ItemStack(Items.TARGET));
        LOOT.add(new ItemStack(Items.PISTON));
        LOOT.add(new ItemStack(Items.STICKY_PISTON));
    }

    public static ItemStack FetchLoot(Random rng){
        int Index = rng.nextInt(LOOT.size());
        int Count = rng.nextBetweenExclusive(8,16);
        ItemStack selected = LOOT.get(Index);
        selected.setCount(Count);
        return selected;
    }
}
