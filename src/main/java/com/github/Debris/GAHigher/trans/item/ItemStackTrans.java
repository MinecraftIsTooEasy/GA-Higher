package com.github.Debris.GAHigher.trans.item;

import com.github.Debris.GAHigher.api.GAItemStack;
import com.github.Debris.GAHigher.config.GAConfigManyLib;
import com.github.Debris.GAHigher.screen.slot.SlotShop;
import com.github.Debris.GAHigher.util.PriceItem;
import com.github.Debris.GAHigher.util.PriceStacks;
import net.minecraft.*;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.ArrayList;
import java.util.List;

@Mixin({ItemStack.class})
public abstract class ItemStackTrans implements GAItemStack {
    @Shadow
    public abstract ItemStack setTagCompound(NBTTagCompound par1NBTTagCompound);

    @Shadow
    public int itemID;

    @Shadow
    public NBTTagCompound stackTagCompound;

    @SuppressWarnings("unchecked")
    @Inject(method = {"getTooltip"}, at = {@At(value = "RETURN")})
    public void onTooltip(EntityPlayer par1EntityPlayer, boolean detailed, Slot slot, CallbackInfoReturnable<ArrayList> callbackInfoReturnable) {
        List<String> list = callbackInfoReturnable.getReturnValue();

        if (slot instanceof SlotShop && slot.getHasStack()) {
            addPriceTooltip(slot.getStack(), list);
            return;
        }

        if (detailed && GAConfigManyLib.PriceOnTooltip.getBooleanValue()) {
            PriceStacks.matchItemStack((ItemStack) (Object) this).ifPresent(x -> addPriceTooltip(x, list));
        }
    }

    @Unique
    private static void addPriceTooltip(ItemStack itemStack, List<String> list) {
        list.add(EnumChatFormatting.AQUA + "售出价格:" + EnumChatFormatting.WHITE + ((GAItemStack) itemStack).getPrice().soldPrice());
        list.add(EnumChatFormatting.AQUA + "购买价格:" + EnumChatFormatting.WHITE + ((GAItemStack) itemStack).getPrice().buyPrice());
    }

    @Override
    public PriceItem getPrice() {
        if (this.stackTagCompound != null && this.stackTagCompound.hasKey("price")) {
            NBTTagCompound nbtTagCompound = (NBTTagCompound) this.stackTagCompound.getTag("price");
            return new PriceItem(nbtTagCompound.getDouble("soldPrice"), nbtTagCompound.getDouble("buyPrice"));
        }
        return new PriceItem(0.0D, 0.0D);
    }

    @Override
    public void setPrice(double soldPrice, double buyPrice) {
        if (this.stackTagCompound == null)
            this.setTagCompound(new NBTTagCompound());
        if (!this.stackTagCompound.hasKey("price")) {
            NBTTagCompound nbtTagCompound = new NBTTagCompound();
            nbtTagCompound.setDouble("soldPrice", soldPrice);
            nbtTagCompound.setDouble("buyPrice", buyPrice);
            this.stackTagCompound.setTag("price", nbtTagCompound);
        } else {
            NBTTagCompound nbtTagCompound = (NBTTagCompound) this.stackTagCompound.getTag("price");
            nbtTagCompound.setDouble("soldPrice", soldPrice);
            nbtTagCompound.setDouble("buyPrice", buyPrice);
        }
    }

}
