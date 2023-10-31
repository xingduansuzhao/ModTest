package com.xdsz.test.events;

import com.xdsz.test.Test;
import com.xdsz.test.key.TestKeybinds;
import net.minecraft.client.Minecraft;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Test.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)

public class TestKeyEvents {

    @SubscribeEvent
    public static void pressKey(InputEvent.KeyInputEvent event){
        Minecraft mc = Minecraft.getInstance();
        if(mc.world == null) return;
        processKeyPress(mc, event.getKey());

    }

    private static void processKeyPress(Minecraft mc, int key){
        if(mc.currentScreen == null && TestKeybinds.testKey.isPressed()){
            String message = "\u53ea\u56e0\u4f60\u592a\u7f8e\u4f60\u5e72\u561b\u54ce\u54df\uff01";
            Minecraft.getInstance().player.sendChatMessage(message);
        }
    }

}
