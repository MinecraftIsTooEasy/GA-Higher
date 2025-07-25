package com.github.debris.gah.item;

import net.minecraft.Item;
import net.minecraft.Material;

public class ItemEnhanceStone extends Item {
    private final Types type;

    public ItemEnhanceStone(Types type) {
        super(Items.getNextItemID(), "enhance_stone/" + type.name());
        setMaterial(type.material);
        this.type = type;
    }

    public int getFailChance() {
        return this.type.failChance;
    }

    public enum Types {
        iron(35, Material.iron),
        mithril(55, Material.mithril),
        adamantium(65, Material.adamantium),
        universal(50, Material.glowstone);

        private final int failChance;
        private final Material material;

        Types(int failChance, Material material) {
            this.failChance = failChance;
            this.material = material;
        }
    }
}
