package com.plr.hmyukari;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

@Mod(modid = HarmlessYukari.MODID, useMetadata = true, clientSideOnly = true)
public class HarmlessYukari {
    public static final String MODID = "hmyukari";
    public static boolean nameHadBeenUsed = false;
    private static boolean nameWillBeUsed = false;


    @Mod.EventHandler
    public void init(FMLInitializationEvent e) {
        nameWillBeUsed = true;
    }

    public static boolean shouldModify() {
        return nameHadBeenUsed && !nameWillBeUsed;
    }
}
