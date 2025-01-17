package com.github.Debris.GAHigher.client.gui;

import com.github.Debris.GAHigher.api.GAEntityPlayer;
import com.github.Debris.GAHigher.item.Items;
import com.github.Debris.GAHigher.network.GANetwork;
import com.github.Debris.GAHigher.network.packets.C2S.C2SShopIndex;
import com.github.Debris.GAHigher.screen.container.ContainerShop;
import com.github.Debris.GAHigher.screen.inventory.InventoryShop;
import net.minecraft.*;
import org.lwjgl.opengl.GL11;

public class GuiShop extends GuiContainer {
    private GUIPaginationButton left;

    private GUIPaginationButton right;

    private int pageIndex = 0;

    private static final ResourceLocation furnaceGuiTextures = new ResourceLocation("textures/gui/container/gui_shop.png");

    public GuiShop(EntityPlayer player) {
        super(new ContainerShop(player));
        this.xSize = 176;
        this.ySize = 222;
    }

    @Override
    public void initGui() {
        super.initGui();
        this.buttonList.clear();
        this.buttonList.add(this.left = new GUIPaginationButton(1, this.width / 2 - 82, this.height / 2 - 4, false));
        this.buttonList.add(this.right = new GUIPaginationButton(2, this.width / 2 + 69, this.height / 2 - 4, true));
        this.left.enabled = false;
        GANetwork.sendToServer(new C2SShopIndex(this.pageIndex));
    }

    protected void actionPerformed(GuiButton var1) {
        switch (var1.id) {
            case 1 -> {
                this.pageIndex--;
                if (this.pageIndex == 0)
                    var1.enabled = false;
                this.right.enabled = true;
            }
            case 2 -> {
                this.left.enabled = true;
                this.pageIndex++;
                if (this.pageIndex == (double) (Items.shopSize / InventoryShop.pageSize)) {
                    var1.enabled = false;
                }
            }
        }
        GANetwork.sendToServer(new C2SShopIndex(this.pageIndex));
    }

    @Override
    public void drawGuiContainerForegroundLayer(int par1, int par2) {
        String shopContainerName = I18n.getString("container.shop");
        this.fontRenderer.drawString(shopContainerName, this.xSize / 2 - this.fontRenderer.getStringWidth(shopContainerName) / 2, 6, 4210752);
        this.fontRenderer.drawString(I18n.getString("container.inventory"), 8, this.ySize - 96 + 2, 4210752);
        String moneyText = GAEntityPlayer.getMoneyManager(this.inventorySlots.player).getMoneyText();
        this.fontRenderer.drawString(moneyText, this.xSize / 2 - this.fontRenderer.getStringWidth(moneyText) / 2, this.ySize - 110, 4210752);
    }

    @Override
    public void drawGuiContainerBackgroundLayer(float par1, int par2, int par3) {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(furnaceGuiTextures);
        int var4 = (this.width - this.xSize) / 2;
        int var5 = (this.height - this.ySize) / 2;
        drawTexturedModalRect(var4, var5, 0, 0, this.xSize, this.ySize);
    }
}
