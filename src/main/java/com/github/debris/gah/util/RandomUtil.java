package com.github.debris.gah.util;

import com.github.debris.gah.config.GAConfigManyLib;
import com.github.debris.gah.item.Items;
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
