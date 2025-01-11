package com.github.Debris.GAHigher.trans.item;

import com.github.Debris.GAHigher.api.GAItem;
import net.minecraft.Item;
import net.minecraft.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Mixin({Item.class})
public abstract class ItemTrans implements GAItem {
    @Unique
    private Map<Integer, Double> soldPriceArray = new HashMap<>();

    @Unique
    private Map<Integer, Double> buyPriceArray = new HashMap<>();

    @Override
    public double getSoldPrice(int subtype) {
        return this.soldPriceArray.get(subtype);
    }

    @Override
    public double getBuyPrice(int subtype) {
        return this.buyPriceArray.get(subtype);
    }

    @Override
    public void registerSoldPrice(int subtype, double soldPrice) {
        this.soldPriceArray.put(subtype, soldPrice);
    }

    @Override
    public void registerBuyPrice(int subtype, double buyPrice) {
        this.buyPriceArray.put(subtype, buyPrice);
    }

    @Override
    public GAItem setBuyPrice(double price) {
        if (getHasSubtypes()) {
            List<ItemStack> subs = getSubItems();
            for (int i = 0; i < subs.size(); i++) {
                ItemStack itemStack = subs.get(i);
                int sub = itemStack.getItemSubtype();
                this.buyPriceArray.put(Integer.valueOf(sub), Double.valueOf(price));
            }
        } else {
            this.buyPriceArray.put(Integer.valueOf(0), Double.valueOf(price));
        }
        return this;
    }

    @Override
    public GAItem setSoldPrice(double price) {
        if (this.getHasSubtypes()) {
            List<ItemStack> subs = getSubItems();
            for (int i = 0; i < subs.size(); i++) {
                ItemStack itemStack = subs.get(i);
                int sub = itemStack.getItemSubtype();
                this.soldPriceArray.put(Integer.valueOf(sub), Double.valueOf(price));
            }
        } else {
            this.soldPriceArray.put(Integer.valueOf(0), Double.valueOf(price));
        }
        return this;
    }

    @Shadow
    public Item setMaxStackSize(int maxStackSize) {
        return null;
    }

    @Shadow
    public abstract boolean getHasSubtypes();

    @Shadow
    public abstract List getSubItems();

    @Inject(method = "<clinit>", at = @At("RETURN"))
    private static void onClinit(CallbackInfo ci) {
        Item.ghastTear.setCraftingDifficultyAsComponent(200.0F);
    }
}
