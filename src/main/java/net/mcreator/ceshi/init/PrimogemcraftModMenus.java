
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.ceshi.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.common.extensions.IMenuTypeExtension;

import net.minecraft.world.inventory.MenuType;
import net.minecraft.core.registries.Registries;

import net.mcreator.ceshi.world.inventory.ZhangquanzhezhinangguiMenu;
import net.mcreator.ceshi.world.inventory.YinhangMenu;
import net.mcreator.ceshi.world.inventory.YibangrenzhinangguiMenu;
import net.mcreator.ceshi.world.inventory.TaozhuangchakanMenu;
import net.mcreator.ceshi.world.inventory.SuijiqiwuMenu;
import net.mcreator.ceshi.world.inventory.SJGUIfumo01Menu;
import net.mcreator.ceshi.world.inventory.SJGUIfumo00Menu;
import net.mcreator.ceshi.world.inventory.MolalajitongMenu;
import net.mcreator.ceshi.world.inventory.MaoxianjiazhinangguiMenu;
import net.mcreator.ceshi.world.inventory.LiulangzhezhinangguiMenu;
import net.mcreator.ceshi.world.inventory.HeitayindaoyongguiMenu;
import net.mcreator.ceshi.world.inventory.GuiheitaxinyindaoMenu;
import net.mcreator.ceshi.world.inventory.GanjinglajitongMenu;
import net.mcreator.ceshi.world.inventory.GUIqiwuxuanzeMenu;
import net.mcreator.ceshi.world.inventory.GUImoladuiMenu;
import net.mcreator.ceshi.world.inventory.GUIhualiduanzaotaiMenu;
import net.mcreator.ceshi.world.inventory.GUIbhmgMenu;
import net.mcreator.ceshi.world.inventory.GUISJfumoMenu;
import net.mcreator.ceshi.world.inventory.CunzheshezhiMenu;
import net.mcreator.ceshi.world.inventory.CeshishijianxuanzejiemianMenu;
import net.mcreator.ceshi.world.inventory.CeshiguiMenu;
import net.mcreator.ceshi.world.inventory.CeshifumoguiMenu;
import net.mcreator.ceshi.world.inventory.BwdyinhangMenu;
import net.mcreator.ceshi.PrimogemcraftMod;

public class PrimogemcraftModMenus {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(Registries.MENU, PrimogemcraftMod.MODID);
	public static final DeferredHolder<MenuType<?>, MenuType<CeshiguiMenu>> CESHIGUI = REGISTRY.register("ceshigui", () -> IMenuTypeExtension.create(CeshiguiMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<GanjinglajitongMenu>> GANJINGLAJITONG = REGISTRY.register("ganjinglajitong", () -> IMenuTypeExtension.create(GanjinglajitongMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<MolalajitongMenu>> MOLALAJITONG = REGISTRY.register("molalajitong", () -> IMenuTypeExtension.create(MolalajitongMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<LiulangzhezhinangguiMenu>> LIULANGZHEZHINANGGUI = REGISTRY.register("liulangzhezhinanggui", () -> IMenuTypeExtension.create(LiulangzhezhinangguiMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<MaoxianjiazhinangguiMenu>> MAOXIANJIAZHINANGGUI = REGISTRY.register("maoxianjiazhinanggui", () -> IMenuTypeExtension.create(MaoxianjiazhinangguiMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<ZhangquanzhezhinangguiMenu>> ZHANGQUANZHEZHINANGGUI = REGISTRY.register("zhangquanzhezhinanggui", () -> IMenuTypeExtension.create(ZhangquanzhezhinangguiMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<YibangrenzhinangguiMenu>> YIBANGRENZHINANGGUI = REGISTRY.register("yibangrenzhinanggui", () -> IMenuTypeExtension.create(YibangrenzhinangguiMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<CeshishijianxuanzejiemianMenu>> CESHISHIJIANXUANZEJIEMIAN = REGISTRY.register("ceshishijianxuanzejiemian", () -> IMenuTypeExtension.create(CeshishijianxuanzejiemianMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<SuijiqiwuMenu>> SUIJIQIWU = REGISTRY.register("suijiqiwu", () -> IMenuTypeExtension.create(SuijiqiwuMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<CeshifumoguiMenu>> CESHIFUMOGUI = REGISTRY.register("ceshifumogui", () -> IMenuTypeExtension.create(CeshifumoguiMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<HeitayindaoyongguiMenu>> HEITAYINDAOYONGGUI = REGISTRY.register("heitayindaoyonggui", () -> IMenuTypeExtension.create(HeitayindaoyongguiMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<GUImoladuiMenu>> GU_IMOLADUI = REGISTRY.register("gu_imoladui", () -> IMenuTypeExtension.create(GUImoladuiMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<YinhangMenu>> YINHANG = REGISTRY.register("yinhang", () -> IMenuTypeExtension.create(YinhangMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<BwdyinhangMenu>> BWDYINHANG = REGISTRY.register("bwdyinhang", () -> IMenuTypeExtension.create(BwdyinhangMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<CunzheshezhiMenu>> CUNZHESHEZHI = REGISTRY.register("cunzheshezhi", () -> IMenuTypeExtension.create(CunzheshezhiMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<TaozhuangchakanMenu>> TAOZHUANGCHAKAN = REGISTRY.register("taozhuangchakan", () -> IMenuTypeExtension.create(TaozhuangchakanMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<GUIqiwuxuanzeMenu>> GU_IQIWUXUANZE = REGISTRY.register("gu_iqiwuxuanze", () -> IMenuTypeExtension.create(GUIqiwuxuanzeMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<GuiheitaxinyindaoMenu>> GUIHEITAXINYINDAO = REGISTRY.register("guiheitaxinyindao", () -> IMenuTypeExtension.create(GuiheitaxinyindaoMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<GUISJfumoMenu>> GUIS_JFUMO = REGISTRY.register("guis_jfumo", () -> IMenuTypeExtension.create(GUISJfumoMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<SJGUIfumo00Menu>> SJGU_IFUMO_00 = REGISTRY.register("sjgu_ifumo_00", () -> IMenuTypeExtension.create(SJGUIfumo00Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<SJGUIfumo01Menu>> SJGU_IFUMO_01 = REGISTRY.register("sjgu_ifumo_01", () -> IMenuTypeExtension.create(SJGUIfumo01Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<GUIhualiduanzaotaiMenu>> GU_IHUALIDUANZAOTAI = REGISTRY.register("gu_ihualiduanzaotai", () -> IMenuTypeExtension.create(GUIhualiduanzaotaiMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<GUIbhmgMenu>> GU_IBHMG = REGISTRY.register("gu_ibhmg", () -> IMenuTypeExtension.create(GUIbhmgMenu::new));
}
