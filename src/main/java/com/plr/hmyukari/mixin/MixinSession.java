package com.plr.hmyukari.mixin;

import com.plr.hmyukari.HarmlessYukari;
import net.minecraft.util.Session;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Session.class)
public class MixinSession {
    @Inject(method = "getUsername", at = @At("HEAD"), cancellable = true)
    public void inject$getUserName(CallbackInfoReturnable<String> cir) {
        if (!HarmlessYukari.shouldModify()) return;
        cir.setReturnValue("Notch");
    }
}
