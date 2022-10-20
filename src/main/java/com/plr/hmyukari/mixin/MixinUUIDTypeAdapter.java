package com.plr.hmyukari.mixin;

import com.mojang.authlib.GameProfile;
import com.mojang.util.UUIDTypeAdapter;
import com.plr.hmyukari.HarmlessYukari;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.Session;
import net.minecraft.util.Util;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.UUID;

@Mixin(UUIDTypeAdapter.class)
public class MixinUUIDTypeAdapter {
    @Inject(method = "fromString", at = @At("RETURN"), cancellable = true, remap = false)
    private static void inject$fromString(String input, CallbackInfoReturnable<UUID> cir) {
        UUID m;
        try {
            m = UUID.fromString(input.replaceFirst("(\\w{8})(\\w{4})(\\w{4})(\\w{4})(\\w{12})", "$1-$2-$3-$4-$5"));
        } catch (Exception e) {
            m = EntityPlayer.getUUID(new GameProfile(null, Minecraft.getMinecraft().getSession().getUsername()));
        }
        cir.setReturnValue(m);
    }
}
