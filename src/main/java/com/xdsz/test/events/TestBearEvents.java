package com.xdsz.test.events;

import com.xdsz.test.Test;
import com.xdsz.test.entities.TestBearRenderer;
import com.xdsz.test.util.RegistryHandler;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = Test.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class TestBearEvents {
    @SubscribeEvent
    public static void testBearEvents(FMLClientSetupEvent event){
        RenderingRegistry.registerEntityRenderingHandler(RegistryHandler.TEST_BEAR.get(), TestBearRenderer::new);
    }
}
