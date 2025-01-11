package com.github.Debris.GAHigher.enums;

import com.github.Debris.GAHigher.block.Blocks;
import com.github.Debris.GAHigher.compat.ITECompat;
import com.github.Debris.GAHigher.item.ITECompatImpl;
import net.minecraft.Achievement;
import net.minecraft.AchievementList;
import net.minecraft.Item;
import net.minecraft.ItemStack;
import net.xiaoyu233.fml.reload.utils.IdUtil;

public class Achievements {
    public static Achievement openShop;

    public static Achievement killZombieBoss;

    public static void registerAchievements() {
        openShop = (new Achievement(getNextAchievementID(), "openShop", -4, 2, new ItemStack(Blocks.blockColorful, 1, 1), AchievementList.openInventory)).setIndependent().registerAchievement();
        Item item;
        if (ITECompat.HAS_ITE) {
            item = ITECompatImpl.getIconForKillZombieBoss();
        } else {
            item = Item.warHammerAdamantium;
        }
        killZombieBoss = (new Achievement(getNextAchievementID(), "killZombieBoss", 0, 11, item, AchievementList.portal)).registerAchievement();
    }

    private static int getNextAchievementID() {
        return IdUtil.getNextAchievementID();
    }
}
