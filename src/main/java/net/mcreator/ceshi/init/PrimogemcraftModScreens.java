/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.ceshi.init;

import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.mcreator.ceshi.client.gui.ZhangquanzhezhinangguiScreen;
import net.mcreator.ceshi.client.gui.YinhangScreen;
import net.mcreator.ceshi.client.gui.YibangrenzhinangguiScreen;
import net.mcreator.ceshi.client.gui.TaozhuangchakanScreen;
import net.mcreator.ceshi.client.gui.SuijiqiwuScreen;
import net.mcreator.ceshi.client.gui.SJGUIfumo01Screen;
import net.mcreator.ceshi.client.gui.SJGUIfumo00Screen;
import net.mcreator.ceshi.client.gui.MolalajitongScreen;
import net.mcreator.ceshi.client.gui.MaoxianjiazhinangguiScreen;
import net.mcreator.ceshi.client.gui.LiulangzhezhinangguiScreen;
import net.mcreator.ceshi.client.gui.HeitayindaoyongguiScreen;
import net.mcreator.ceshi.client.gui.GuiheitaxinyindaoScreen;
import net.mcreator.ceshi.client.gui.GanjinglajitongScreen;
import net.mcreator.ceshi.client.gui.GUIqiwuxuanzeScreen;
import net.mcreator.ceshi.client.gui.GUImoladuiScreen;
import net.mcreator.ceshi.client.gui.GUIhyzhqScreen;
import net.mcreator.ceshi.client.gui.GUIhualiduanzaotaiScreen;
import net.mcreator.ceshi.client.gui.GUIbhmgScreen;
import net.mcreator.ceshi.client.gui.GUISJfumoScreen;
import net.mcreator.ceshi.client.gui.CunzheshezhiScreen;
import net.mcreator.ceshi.client.gui.CeshishijianxuanzejiemianScreen;
import net.mcreator.ceshi.client.gui.CeshiguiScreen;
import net.mcreator.ceshi.client.gui.CeshifumoguiScreen;
import net.mcreator.ceshi.client.gui.BwdyinhangScreen;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class PrimogemcraftModScreens {
	@SubscribeEvent
	public static void clientLoad(RegisterMenuScreensEvent event) {
		event.register(PrimogemcraftModMenus.CESHIGUI.get(), CeshiguiScreen::new);
		event.register(PrimogemcraftModMenus.GANJINGLAJITONG.get(), GanjinglajitongScreen::new);
		event.register(PrimogemcraftModMenus.MOLALAJITONG.get(), MolalajitongScreen::new);
		event.register(PrimogemcraftModMenus.LIULANGZHEZHINANGGUI.get(), LiulangzhezhinangguiScreen::new);
		event.register(PrimogemcraftModMenus.MAOXIANJIAZHINANGGUI.get(), MaoxianjiazhinangguiScreen::new);
		event.register(PrimogemcraftModMenus.ZHANGQUANZHEZHINANGGUI.get(), ZhangquanzhezhinangguiScreen::new);
		event.register(PrimogemcraftModMenus.YIBANGRENZHINANGGUI.get(), YibangrenzhinangguiScreen::new);
		event.register(PrimogemcraftModMenus.CESHISHIJIANXUANZEJIEMIAN.get(), CeshishijianxuanzejiemianScreen::new);
		event.register(PrimogemcraftModMenus.SUIJIQIWU.get(), SuijiqiwuScreen::new);
		event.register(PrimogemcraftModMenus.CESHIFUMOGUI.get(), CeshifumoguiScreen::new);
		event.register(PrimogemcraftModMenus.HEITAYINDAOYONGGUI.get(), HeitayindaoyongguiScreen::new);
		event.register(PrimogemcraftModMenus.GU_IMOLADUI.get(), GUImoladuiScreen::new);
		event.register(PrimogemcraftModMenus.YINHANG.get(), YinhangScreen::new);
		event.register(PrimogemcraftModMenus.BWDYINHANG.get(), BwdyinhangScreen::new);
		event.register(PrimogemcraftModMenus.CUNZHESHEZHI.get(), CunzheshezhiScreen::new);
		event.register(PrimogemcraftModMenus.TAOZHUANGCHAKAN.get(), TaozhuangchakanScreen::new);
		event.register(PrimogemcraftModMenus.GU_IQIWUXUANZE.get(), GUIqiwuxuanzeScreen::new);
		event.register(PrimogemcraftModMenus.GUIHEITAXINYINDAO.get(), GuiheitaxinyindaoScreen::new);
		event.register(PrimogemcraftModMenus.GUIS_JFUMO.get(), GUISJfumoScreen::new);
		event.register(PrimogemcraftModMenus.SJGU_IFUMO_00.get(), SJGUIfumo00Screen::new);
		event.register(PrimogemcraftModMenus.SJGU_IFUMO_01.get(), SJGUIfumo01Screen::new);
		event.register(PrimogemcraftModMenus.GU_IHUALIDUANZAOTAI.get(), GUIhualiduanzaotaiScreen::new);
		event.register(PrimogemcraftModMenus.GU_IBHMG.get(), GUIbhmgScreen::new);
		event.register(PrimogemcraftModMenus.GU_IHYZHQ.get(), GUIhyzhqScreen::new);
	}

	public interface ScreenAccessor {
		void updateMenuState(int elementType, String name, Object elementState);
	}
}