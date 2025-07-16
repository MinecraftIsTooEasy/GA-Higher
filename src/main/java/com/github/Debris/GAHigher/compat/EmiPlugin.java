package com.github.Debris.GAHigher.compat;

import com.github.Debris.GAHigher.item.Items;
import dev.emi.emi.api.EmiRegistry;
import dev.emi.emi.api.recipe.EmiInfoRecipe;
import dev.emi.emi.api.stack.EmiStack;
import net.minecraft.Item;
import shims.java.net.minecraft.text.Text;

import java.util.List;

public class EmiPlugin implements dev.emi.emi.api.EmiPlugin {
    @Override
    public void register(EmiRegistry registry) {
        registerInfos(registry);
    }

    private void registerInfos(EmiRegistry registry) {
        this.info(registry, Items.Powder_MU, "ga.item.powder_mu.info");
        this.info(registry, Items.Powder_SHUI, "ga.item.powder_shui.info");
        this.info(registry, Items.Powder_HUO, "ga.item.powder_huo.info");
        this.info(registry, Items.Powder_TU, "ga.item.powder_tu.info");
        this.info(registry, Items.Powder_Feng, "ga.item.powder_feng.info");
        this.info(registry, Items.Powder_Lei, "ga.item.powder_lei.info");
        this.info(registry, Items.Powder_Bing, "ga.item.powder_bing.info");
        this.info(registry, Items.Powder_An, "ga.item.powder_an.info");
    }

    private void info(EmiRegistry registry, Item item, String info) {
        registry.addRecipe(new EmiInfoRecipe(List.of(EmiStack.of(item)), List.of(Text.translatable(info)), null));
    }
}
