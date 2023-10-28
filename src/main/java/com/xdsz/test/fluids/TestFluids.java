package com.xdsz.test.fluids;

import com.xdsz.test.util.RegistryHandler;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.block.material.Material;
import net.minecraft.fluid.FlowingFluid;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.FluidAttributes;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.fml.RegistryObject;
import static com.xdsz.test.util.RegistryHandler.FLUIDS;

public class TestFluids {
    public static final ResourceLocation WATER_STILL_RL = new ResourceLocation("block/water_still");
    public static final ResourceLocation WATER_FLOWING_RL = new ResourceLocation("block/water_flow");
    public static final ResourceLocation WATER_OVERLAY_RL = new ResourceLocation("block/water_overlay");


    public static final RegistryObject<FlowingFluid> HONEYTEST_FLUID
            = FLUIDS.register("honeytest_fluid", ()->new ForgeFlowingFluid.Source(TestFluids.HONEYTEST_PROPERTIES));


    public static final RegistryObject<FlowingFluid> HONEYTEST_FLOWING
            = FLUIDS.register("honeytest_flowing", ()->new ForgeFlowingFluid.Flowing(TestFluids.HONEYTEST_PROPERTIES));



    public static final ForgeFlowingFluid.Properties HONEYTEST_PROPERTIES = new ForgeFlowingFluid.Properties(
            () -> HONEYTEST_FLUID.get(), () -> HONEYTEST_FLOWING.get(),
            FluidAttributes.builder(WATER_STILL_RL, WATER_FLOWING_RL)
            .sound(SoundEvents.ITEM_HONEY_BOTTLE_DRINK).overlay(WATER_OVERLAY_RL)
                    .color(0xffffd247)).slopeFindDistance(9).levelDecreasePerBlock(2)
                    .block(() -> TestFluids.HONEYTEST_BLOCK.get()).bucket(() -> RegistryHandler.HONEYTEST_BUCKET.get());




    public static final RegistryObject<FlowingFluidBlock> HONEYTEST_BLOCK = RegistryHandler.BLOCKS.register("honeytest",
            () -> new FlowingFluidBlock(() -> TestFluids.HONEYTEST_FLUID.get(), AbstractBlock.Properties.create(Material.WATER)
                    .hardnessAndResistance(0f)));





    public static void register(IEventBus eventBus){FLUIDS.register(eventBus);}


}
