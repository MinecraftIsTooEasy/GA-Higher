package com.github.Debris.GAHigher.util;

import com.github.Debris.GAHigher.config.GAConfigManyLib;
import com.github.Debris.GAHigher.item.Items;
import net.minecraft.EntityLivingBase;

import java.util.Random;

public class RandomUtil {

    public static <T extends EntityLivingBase> void dropRandomJewelry(T entity) {
        if (entity.rand.nextInt(GAConfigManyLib.DropJewelryRate.getIntegerValue()) == 0) {
            entity.dropItem(getRamdom(Items.baubles, entity.rand));
        }
    }

    public static <T> T getRamdom(T[] array, Random random) {
        return array[random.nextInt(array.length)];
    }
}
