package com.github.Debris.GAHigher.trans.entity.player;

import com.github.Debris.GAHigher.api.GAPlayer;
import com.github.Debris.GAHigher.client.gui.GuiShop;
import net.minecraft.AbstractClientPlayer;
import net.minecraft.ClientPlayer;
import net.minecraft.Minecraft;
import net.minecraft.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin({ClientPlayer.class})
public abstract class ClientPlayerTrans extends AbstractClientPlayer implements GAPlayer {
    @Shadow
    protected Minecraft mc;

    public ClientPlayerTrans(World par1World, String par2Str) {
        super(par1World, par2Str);
    }

    @Override
    public void ga$DisplayGUIShop() {
        this.mc.displayGuiScreen(new GuiShop(this));
    }

}
