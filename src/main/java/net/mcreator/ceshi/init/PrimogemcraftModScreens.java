/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.ceshi.init;

import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.mcreator.ceshi.client.gui.*;

@EventBusSubscriber(Dist.CLIENT)
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
		event.register(PrimogemcraftModMenus.GU_IHUALIDUANZAOTAI.get(), GUIhualiduanzaotaiScreen::new);
		event.register(PrimogemcraftModMenus.GU_IBHMG.get(), GUIbhmgScreen::new);
		event.register(PrimogemcraftModMenus.GU_IHYZHQ.get(), GUIhyzhqScreen::new);
	}

	public interface ScreenAccessor {
		void updateMenuState(int elementType, String name, Object elementState);
	}
}