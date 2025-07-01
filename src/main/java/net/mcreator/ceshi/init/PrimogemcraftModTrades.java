/*
*	MCreator note: This file will be REGENERATED on each build.
*/
package net.mcreator.ceshi.init;

import net.neoforged.neoforge.event.village.WandererTradesEvent;
import net.neoforged.neoforge.event.village.VillagerTradesEvent;
import net.neoforged.neoforge.common.BasicItemListing;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;

@EventBusSubscriber
public class PrimogemcraftModTrades {
	@SubscribeEvent
	public static void registerWanderingTrades(WandererTradesEvent event) {
		event.getGenericTrades().add(new BasicItemListing(new ItemStack(Blocks.DIRT), new ItemStack(PrimogemcraftModBlocks.SHENMIWANOU.get()), 10, 5, 0.05f));
	}

	@SubscribeEvent
	public static void registerTrades(VillagerTradesEvent event) {
		if (event.getType() == PrimogemcraftModVillagerProfessions.CESYSXJ.get()) {
			event.getTrades().get(2)
					.add(new BasicItemListing(new ItemStack(PrimogemcraftModItems.JIJIUCHANZHIYUAN.get(), 10), new ItemStack(PrimogemcraftModItems.XIAODAIMOLA.get()), new ItemStack(PrimogemcraftModItems.SHILIANCHOU.get()), 10, 5, 0f));
			event.getTrades().get(4).add(new BasicItemListing(new ItemStack(PrimogemcraftModBlocks.CESHIXIAODENGFASHEQI.get()), new ItemStack(PrimogemcraftModItems.CCHONGGAODAODEDEZANXU.get(), 3),
					new ItemStack(PrimogemcraftModBlocks.CHUANGZAOXIAODENGFASHEQI.get()), 1, 5, 0.01f));
			event.getTrades().get(4).add(new BasicItemListing(new ItemStack(Items.BOOK), new ItemStack(Items.EXPERIENCE_BOTTLE), new ItemStack(PrimogemcraftModItems.DAYINGXIONGDEJINGYAN.get()), 1, 5, 0.05f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(Items.PAPER), new ItemStack(PrimogemcraftModItems.XIAODAIMOLA.get()), new ItemStack(PrimogemcraftModItems.CUNQUPINGZHENG.get()), 2, 5, 0.05f));
			event.getTrades().get(3).add(new BasicItemListing(new ItemStack(PrimogemcraftModItems.XINGHUI.get(), 5), new ItemStack(PrimogemcraftModItems.JIJIUCHANZHIYUAN.get()), 5, 5, 0f));
			event.getTrades().get(2).add(new BasicItemListing(new ItemStack(PrimogemcraftModItems.XINGHUI.get(), 5), new ItemStack(PrimogemcraftModItems.XIXIANGYUZHIYUAN.get()), 5, 5, 0f));
			event.getTrades().get(3).add(new BasicItemListing(new ItemStack(PrimogemcraftModItems.XINGCHEN.get(), 10), new ItemStack(PrimogemcraftModItems.SHANBIANZHICHEN.get()), 3, 5, 0.03f));
			event.getTrades().get(2).add(new BasicItemListing(new ItemStack(PrimogemcraftModItems.XINGCHEN.get(), 16), new ItemStack(PrimogemcraftModItems.XIXIANGYUZHIYUAN.get()), 5, 5, 0f));
			event.getTrades().get(3).add(new BasicItemListing(new ItemStack(PrimogemcraftModItems.XINGCHEN.get(), 16), new ItemStack(PrimogemcraftModItems.JIJIUCHANZHIYUAN.get()), 5, 5, 0f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(PrimogemcraftModItems.YUANSHI.get(), 5), new ItemStack(Items.EMERALD), 20, 5, 0.03f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(PrimogemcraftModItems.CHUANGSHIJIEJING.get(), 10), new ItemStack(PrimogemcraftModItems.YUANSHI.get(), 16), 20, 5, 0.01f));
			event.getTrades().get(5)
					.add(new BasicItemListing(new ItemStack(PrimogemcraftModItems.DAYINGXIONGDEJINGYAN.get()), new ItemStack(Items.EXPERIENCE_BOTTLE, 8), new ItemStack(PrimogemcraftModItems.JIANGLIDAYINXIONGJINGYAN.get()), 1, 5, 0.02f));
			event.getTrades().get(5).add(new BasicItemListing(new ItemStack(PrimogemcraftModItems.Q_QU_HANG_ZHOULLH.get()), new ItemStack(PrimogemcraftModItems.Q_QU_HANG_ZHOULLH.get()), new ItemStack(PrimogemcraftModItems.QHZLLH_4.get()), 1, 5, 0f));
			event.getTrades().get(4).add(new BasicItemListing(new ItemStack(PrimogemcraftModBlocks.MOLADUI_02.get()), new ItemStack(PrimogemcraftModItems.MMOLA_01.get(), 34), new ItemStack(PrimogemcraftModBlocks.MLXDML_03.get()), 10, 5, 0f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(Items.EMERALD), new ItemStack(PrimogemcraftModItems.YUANSHI.get()), 10, 10, 0.05f));
			event.getTrades().get(2).add(new BasicItemListing(new ItemStack(Blocks.TNT, 9), new ItemStack(PrimogemcraftModItems.YIYINHEDALETOU.get()), new ItemStack(PrimogemcraftModBlocks.SHENMIWANOU.get()), 10, 5, 0.05f));
			event.getTrades().get(5).add(new BasicItemListing(new ItemStack(PrimogemcraftModItems.JINGUANGBAODI_01.get(), 6), new ItemStack(PrimogemcraftModItems.YSRQSP.get()), new ItemStack(PrimogemcraftModItems.YSRQSP.get(), 2), 1, 5, 0f));
		}
	}
}