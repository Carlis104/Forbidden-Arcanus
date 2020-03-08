package com.stal111.forbidden_arcanus.event;

import com.stal111.forbidden_arcanus.init.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class HarvestDropsEvent {
	
	@SubscribeEvent
	public static void onBlockDestroyed(BlockEvent.HarvestDropsEvent event) {
		Block block = event.getState().getBlock();
		Item item = ModItems.INFERNUM_PICKAXE.get();
		if (event.getHarvester() != null && event.getHarvester().getHeldItemMainhand().getItem() == item) {
			if (block == Blocks.IRON_ORE) {
				event.getDrops().clear();
				event.getDrops().add(new ItemStack(Items.IRON_INGOT));
			} else if (block == Blocks.GOLD_ORE) {
				event.getDrops().clear();
				event.getDrops().add(new ItemStack(Items.GOLD_INGOT));
			} else if (block == Blocks.WET_SPONGE) {
				event.getDrops().clear();
				event.getDrops().add(new ItemStack(Blocks.SPONGE));
			}
		}
	}
}
