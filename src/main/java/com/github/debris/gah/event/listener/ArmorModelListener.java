package com.github.debris.gah.event.listener;

import com.github.debris.gah.client.render.armor.ModelSkirtArmor;
import com.github.debris.gah.item.ItemArmorSkirt;
import moddedmite.rustedironcore.api.event.listener.IArmorModelListener;
import net.minecraft.ItemArmor;
import net.minecraft.ModelBiped;

import java.util.function.Consumer;

public class ArmorModelListener implements IArmorModelListener {
    private ModelBiped modelSkirt;

    @Override
    public void onArmorModelRegister(Consumer<ModelBiped> registry) {
        this.modelSkirt = new ModelSkirtArmor();
        registry.accept(modelSkirt);
    }

    @Override
    public ModelBiped getArmorModel(ItemArmor itemArmor, int slotIndex) {
        if (itemArmor instanceof ItemArmorSkirt && slotIndex == 2) return this.modelSkirt;
        return null;
    }
}
