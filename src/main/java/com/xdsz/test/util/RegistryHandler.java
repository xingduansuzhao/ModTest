package com.xdsz.test.util;

import com.xdsz.test.Test;
import com.xdsz.test.armor.ModArmorMaterial;
import com.xdsz.test.blocks.BlockItemBase;
import com.xdsz.test.blocks.SapphireOre;
import com.xdsz.test.fluids.TestFluids;
import com.xdsz.test.items.ItemBase;
import com.xdsz.test.items.PoisonApple;
import com.xdsz.test.blocks.SapphireBlock;

import com.xdsz.test.tools.ModItemTier;
import net.minecraft.block.Block;
import net.minecraft.fluid.Fluid;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class RegistryHandler {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Test.MOD_ID);
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Test.MOD_ID);


    //@
    public static final DeferredRegister<Fluid> FLUIDS = DeferredRegister.create(ForgeRegistries.FLUIDS, Test.MOD_ID);

    public static void init(){
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
        TestFluids.register(FMLJavaModLoadingContext.get().getModEventBus());//@
    }



    //物品
    public static final RegistryObject<Item> SAPPHIRE = ITEMS.register("sapphire",ItemBase::new);



    //方块(手持)
    public static final RegistryObject<Block> SAPPHIRE_BLOCK = BLOCKS.register("sapphire_block",SapphireBlock::new);
    public static final RegistryObject<Block> SAPPHIRE_ORE = BLOCKS.register("sapphire_ore", SapphireOre::new);



    //方块(着地)
    public static final RegistryObject<Item> SAPPHIRE_BLOCK_ITEM = ITEMS.register("sapphire_block",
            () -> new BlockItemBase(SAPPHIRE_BLOCK.get()));

    public static final RegistryObject<Item> SAPPHIRE_ORE_ITEM = ITEMS.register("sapphire_ore",
            () -> new BlockItemBase(SAPPHIRE_ORE.get()));




    //工具
    public static final RegistryObject<SwordItem> SAPPHIRE_SWORD = ITEMS.register("sapphire_sword",
            () -> new SwordItem(ModItemTier.SAPPHIRE, 50, 20.0F, new Item.Properties().group(Test.TAB)));

    public static final RegistryObject<AxeItem> SAPPHIRE_AXE = ITEMS.register("sapphire_axe",
            () -> new AxeItem(ModItemTier.SAPPHIRE, 100,20.0F, new Item.Properties().group(Test.TAB)));

    public static final RegistryObject<ShovelItem> SAPPHIRE_SHOVEL = ITEMS.register("sapphire_shovel",
            () -> new ShovelItem(ModItemTier.SAPPHIRE, 0, 20.0F, new Item.Properties().group(Test.TAB)));

    public static final RegistryObject<HoeItem> SAPPHIRE_HOE = ITEMS.register("sapphire_hoe",
            () -> new HoeItem(ModItemTier.SAPPHIRE, 0, 20.0F, new Item.Properties().group(Test.TAB)));

    public static final RegistryObject<PickaxeItem> SAPPHIRE_PICKAXE = ITEMS.register("sapphire_pickaxe",
            () -> new PickaxeItem(ModItemTier.SAPPHIRE, 0, 20.0F, new Item.Properties().group(Test.TAB)));



    //盔甲
    public static final RegistryObject<ArmorItem> SAPPHIRE_HELMET = ITEMS.register("sapphire_helmet",
            () -> new ArmorItem(ModArmorMaterial.SAPPHIRE, EquipmentSlotType.HEAD, new Item.Properties().group(Test.TAB)));

    public static final RegistryObject<ArmorItem> SAPPHIRE_CHESTPLATE = ITEMS.register("sapphire_chestplate",
            () -> new ArmorItem(ModArmorMaterial.SAPPHIRE, EquipmentSlotType.CHEST, new Item.Properties().group(Test.TAB)));

    public static final RegistryObject<ArmorItem> SAPPHIRE_LEGS = ITEMS.register("sapphire_leggings",
            () -> new ArmorItem(ModArmorMaterial.SAPPHIRE, EquipmentSlotType.LEGS, new Item.Properties().group(Test.TAB)));

    public static final RegistryObject<ArmorItem> SAPPHIRE_BOOTS = ITEMS.register("sapphire_boots",
            () -> new ArmorItem(ModArmorMaterial.SAPPHIRE, EquipmentSlotType.FEET, new Item.Properties().group(Test.TAB)));


    //毒苹果
    public static final RegistryObject<PoisonApple> POISON_APPLE = ITEMS.register("poison_apple", PoisonApple::new);


    //@
    public static final RegistryObject<Item> HONEYTEST_BUCKET = ITEMS.register("honeytest_bucket",
            () -> new BucketItem(()-> TestFluids.HONEYTEST_FLUID.get(), new Item.Properties().maxStackSize(1).group(Test.TAB)));

}
