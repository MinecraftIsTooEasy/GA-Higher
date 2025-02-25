package com.github.Debris.GAHigher.util;

import java.lang.reflect.Constructor;

public class ReflectHelper {
    public static <T> T dyCast(Object from) {
        return (T) from;
    }

    public static <T> T dyCast(Class<T> to, Object from) {
        return (T) from;
    }

    public static <T> T createInstance(Class<T> tClass, Object... args) {
        Class<?>[] types = new Class[args.length];
        for (int i = 0; i < args.length; i++)
            types[i] = args[i].getClass();
        try {
            Constructor<T> ctor = tClass.getDeclaredConstructor(types);
            ctor.setAccessible(true);
            return ctor.newInstance(args);
        } catch (NoSuchMethodException | IllegalAccessException | InstantiationException |
                 java.lang.reflect.InvocationTargetException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static <T> T createInstance(Class<T> tClass, Class<?>[] types, Object... args) {
        try {
            Constructor<T> ctor = tClass.getDeclaredConstructor(types);
            ctor.setAccessible(true);
            return ctor.newInstance(args);
        } catch (NoSuchMethodException | IllegalAccessException | InstantiationException |
                 java.lang.reflect.InvocationTargetException e) {
            e.printStackTrace();
            return null;
        }
    }
}
