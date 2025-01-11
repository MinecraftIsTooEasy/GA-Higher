package com.github.Debris.GAHigher.trans;

import net.minecraft.server.MinecraftServer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MinecraftServer.class)
public class MinecraftServerMixin {
    @Inject(method = "setTreacheryDetected", at = @At("HEAD"), cancellable = true)
    private static void cancel(CallbackInfo ci) {
        ci.cancel();
    }
}
