package com.github.Debris.GAHigher.event.listener;

import moddedmite.rustedironcore.api.event.events.PlayerLoggedInEvent;
import moddedmite.rustedironcore.api.event.listener.IPlayerEventListener;
import net.minecraft.Potion;
import net.minecraft.PotionEffect;
import net.minecraft.ServerPlayer;

public class PlayerListener implements IPlayerEventListener {
    @Override
    public void onPlayerLoggedIn(PlayerLoggedInEvent event) {
        ServerPlayer serverPlayer = event.player();
        if (event.firstLogin()) {
            serverPlayer.getAsEntityLivingBase().addPotionEffect(new PotionEffect(Potion.field_76443_y.id, 12000, 0));
        }
//        serverPlayer.sendChatToPlayer(ChatMessageComponent.createFromTranslationKey("[Server] ").appendComponent(ChatMessageComponent.createFromTranslationKey("MITE-ITE-GA-P14模组已加载,当前版本:").setColor(EnumChatFormatting.DARK_GREEN)).appendComponent(ChatMessageComponent.createFromText("v0.2.1").setColor(EnumChatFormatting.DARK_RED)));
//        serverPlayer.sendChatToPlayer(ChatMessageComponent.createFromTranslationKey("[MITE-ITE-GA-P14]:").setColor(EnumChatFormatting.WHITE)
//                .appendComponent(ChatMessageComponent.createFromTranslationKey("MITE-ITE-GA-P14由 ")
//                        .appendComponent(ChatMessageComponent.createFromTranslationKey("wensc").setColor(EnumChatFormatting.WHITE)))
//                .addText(" 重写,开放下载地址:").setColor(EnumChatFormatting.DARK_RED)
//                .appendComponent(ChatMessageComponent.createFromTranslationKey("https://www.wensc.cn").setColor(EnumChatFormatting.DARK_GREEN)));
    }
}
