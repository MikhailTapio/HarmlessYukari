package com.plr.hmyukari.mixin;

import com.plr.hmyukari.HarmlessYukari;
import net.minecraft.init.Bootstrap;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Bootstrap.class)
public class MixinMCBootstrap {
    @Inject(method = "register", at = @At("HEAD"))
    private static void inject$register(CallbackInfo ci) {
        HarmlessYukari.nameHadBeenUsed = true;
    }
}
