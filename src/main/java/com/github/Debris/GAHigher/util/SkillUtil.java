package com.github.Debris.GAHigher.util;

import net.minecraft.Skill;

import java.lang.reflect.Field;

public class SkillUtil {
    private static Field ID;

    static {
        try {
            ID = Skill.class.getDeclaredField("id");
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    public static int getSkillID(Skill skill) {
        try {
            return ((Integer) ID.get(skill));
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return -1;
        }
    }
}
