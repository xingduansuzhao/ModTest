package com.xdsz.test;


import com.xdsz.test.entities.TestBearEntity;
import com.xdsz.test.fluids.TestFluids;
import com.xdsz.test.key.TestKeybinds;
import com.xdsz.test.util.RegistryHandler;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;

import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.DeferredWorkQueue;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("test")
public class Test
{
    // Directly reference a log4j logger.
    public static final Logger LOGGER = LogManager.getLogger();//p15的private改为public，控制台能查看调试
    public static final String MOD_ID = "test";

    public Test() {
        // Register the setup method for mod loading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);

        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);

        RegistryHandler.init();

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) {
        DeferredWorkQueue.runLater(() -> {
            GlobalEntityTypeAttributes.put(RegistryHandler.TEST_BEAR.get(), TestBearEntity.testBearAttributes().create());
        });
    }

        private void doClientStuff(final FMLClientSetupEvent event) {
        RenderTypeLookup.setRenderLayer(TestFluids.HONEYTEST_FLUID.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(TestFluids.HONEYTEST_BLOCK.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(TestFluids.HONEYTEST_FLOWING.get(), RenderType.getTranslucent());

        TestKeybinds.register(event);
    }

    public static final ItemGroup TAB = new ItemGroup("testTab") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(RegistryHandler.SAPPHIRE.get());
        }
    };

}
