package com.github.Debris.GAHigher.compat;

import dev.emi.emi.config.EmiConfig;

public class EmiSettingsCompat {
    private static int columnCache = 12;

    public static void cacheColumn() {
        columnCache = EmiConfig.rightSidebarSize.values.get(0);
    }

    public static void trySetColumn(int column) {
        if (column == 0) return;
        EmiConfig.rightSidebarSize.values.set(0, column);
    }

    public static void restore() {
        if (columnCache == 0) return;
        EmiConfig.rightSidebarSize.values.set(0, columnCache);
    }
}
