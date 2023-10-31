package com.xdsz.test.events;
import com.xdsz.test.Test;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Test.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class TestClientEvents {
    @SubscribeEvent
    public static void FletcherSupply(LivingEvent.LivingUpdateEvent event){
        LivingEntity entity = event.getEntityLiving();
        World world = entity.getEntityWorld();

        //重点 func_233580_cy_换getPosition
        BlockState state = world.getBlockState(entity.getPosition().down());

        if(state.getBlock() == Blocks.FLETCHING_TABLE.getBlock() && entity instanceof PlayerEntity){
            ItemStack arrowStack = new ItemStack(Items.ARROW, 1);
            ItemEntity arrowEntity = new ItemEntity(world, entity.getPosX(),entity.getPosY(),entity.getPosZ(),arrowStack);
            world.addEntity(arrowEntity);

        }
    }
}
