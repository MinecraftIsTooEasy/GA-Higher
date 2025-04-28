package com.github.Debris.GAHigher.enums;

import com.github.Debris.GAHigher.item.Items;
import net.minecraft.Achievement;
import net.minecraft.AchievementList;
import net.xiaoyu233.fml.reload.utils.IdUtil;

public class Achievements {
    public static Achievement Achievement_zhujidan;

    public static Achievement Achievement_x1;

    public static Achievement Achievement_x2;

    public static Achievement Achievement_x3;

    public static Achievement Achievement_x4;

    public static Achievement Achievement_x5;

    public static Achievement Achievement_x6;

    public static Achievement Achievement_x7;

    public static Achievement Achievement_x8;

    public static Achievement Achievement_x9;

    public static Achievement Achievement_x0;

    public static void registerAchievements() {
        Achievement_zhujidan = (new Achievement(getNextAchievementID(), "achievement_zhujidan", -3, -3, Items.Drug_ZJ, AchievementList.seeds)).registerAchievement();
        Achievement_x1 = (new Achievement(getNextAchievementID(), "achievement_x1", -5, -3, Items.Drug_ZJ, Achievement_zhujidan)).registerAchievement();
        Achievement_x2 = (new Achievement(getNextAchievementID(), "achievement_x2", -7, -3, Items.Drug_ZJ, Achievement_x1)).registerAchievement();
        Achievement_x3 = (new Achievement(getNextAchievementID(), "achievement_x3", -9, -3, Items.Drug_ZJ, Achievement_x2)).registerAchievement();
        Achievement_x4 = (new Achievement(getNextAchievementID(), "achievement_x4", -9, -5, Items.Drug_ZJ, Achievement_x3)).registerAchievement();
        Achievement_x5 = (new Achievement(getNextAchievementID(), "achievement_x5", -7, -5, Items.Drug_ZJ, Achievement_x4)).registerAchievement();
        Achievement_x6 = (new Achievement(getNextAchievementID(), "achievement_x6", -5, -5, Items.Drug_ZJ, Achievement_x5)).registerAchievement();
        Achievement_x7 = (new Achievement(getNextAchievementID(), "achievement_x7", -5, -7, Items.Drug_ZJ, Achievement_x6)).registerAchievement();
        Achievement_x8 = (new Achievement(getNextAchievementID(), "achievement_x8", -3, -7, Items.Drug_ZJ, Achievement_x7)).registerAchievement();
        Achievement_x9 = (new Achievement(getNextAchievementID(), "achievement_x9", -1, -7, Items.Drug_ZJ, Achievement_x8)).registerAchievement();
        Achievement_x0 = (new Achievement(getNextAchievementID(), "achievement_x0", 1, -7, Items.Drug_ZJ, Achievement_x9)).setSpecial().registerAchievement();
    }

    private static int getNextAchievementID() {
        return IdUtil.getNextAchievementID();
    }
}
