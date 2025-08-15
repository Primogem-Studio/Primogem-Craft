/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.ceshi.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.event.entity.living.MobEffectEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.core.registries.Registries;

import net.mcreator.ceshi.procedures.Yimuguo_shuxingProcedure;
import net.mcreator.ceshi.procedures.YdggzxgsxProcedure;
import net.mcreator.ceshi.procedures.Xgjssx0Procedure;
import net.mcreator.ceshi.procedures.XGsmcwsx0Procedure;
import net.mcreator.ceshi.procedures.WxntdmjxgsxProcedure;
import net.mcreator.ceshi.procedures.Tldhy_sxProcedure;
import net.mcreator.ceshi.procedures.Smcl_zf_sx_0Procedure;
import net.mcreator.ceshi.procedures.QylqsxProcedure;
import net.mcreator.ceshi.procedures.LtcgxgsxProcedure;
import net.mcreator.ceshi.procedures.Hslggz_xiaoguo_sx_2Procedure;
import net.mcreator.ceshi.procedures.Heisenlin_ggz_xiaoguo_sx_1Procedure;
import net.mcreator.ceshi.procedures.Guoqu_jieshuProcedure;
import net.mcreator.ceshi.procedures.Gongjixiangzengyi_shuxingProcedure;
import net.mcreator.ceshi.procedures.Flggzxgsx2Procedure;
import net.mcreator.ceshi.procedures.Flggzxgsx1Procedure;
import net.mcreator.ceshi.procedures.Fengrao_shuxing_4Procedure;
import net.mcreator.ceshi.procedures.DjpppolieProcedure;
import net.mcreator.ceshi.potion.ZhuoshaoMobEffect;
import net.mcreator.ceshi.potion.ZhongguizhongjuxiaoguoMobEffect;
import net.mcreator.ceshi.potion.ZhengchangdaimaMobEffect;
import net.mcreator.ceshi.potion.ZhandouzhuangtaiMobEffect;
import net.mcreator.ceshi.potion.YydggzxgMobEffect;
import net.mcreator.ceshi.potion.YsrzxgMobEffect;
import net.mcreator.ceshi.potion.YijiMobEffect;
import net.mcreator.ceshi.potion.XishoulengqueMobEffect;
import net.mcreator.ceshi.potion.XGsmcwMobEffect;
import net.mcreator.ceshi.potion.WxntdmjMobEffect;
import net.mcreator.ceshi.potion.TldhyMobEffect;
import net.mcreator.ceshi.potion.SztsxcwdpMobEffect;
import net.mcreator.ceshi.potion.SyzfMobEffect;
import net.mcreator.ceshi.potion.SmclzfMobEffect;
import net.mcreator.ceshi.potion.SmclxgMobEffect;
import net.mcreator.ceshi.potion.SkljxgMobEffect;
import net.mcreator.ceshi.potion.ShijianbuchufaMobEffect;
import net.mcreator.ceshi.potion.RykjxglqMobEffect;
import net.mcreator.ceshi.potion.RykjxgMobEffect;
import net.mcreator.ceshi.potion.RyfxgsxMobEffect;
import net.mcreator.ceshi.potion.QwymgsMobEffect;
import net.mcreator.ceshi.potion.Qwjlbbgsx2MobEffect;
import net.mcreator.ceshi.potion.QuezhushixiaoguoMobEffect;
import net.mcreator.ceshi.potion.QskxjxtxgMobEffect;
import net.mcreator.ceshi.potion.QiqiaodaimaxiufuMobEffect;
import net.mcreator.ceshi.potion.QianyelengqueMobEffect;
import net.mcreator.ceshi.potion.QianyeMobEffect;
import net.mcreator.ceshi.potion.LjtdwqMobEffect;
import net.mcreator.ceshi.potion.LinzhongMobEffect;
import net.mcreator.ceshi.potion.LetoudechengfaMobEffect;
import net.mcreator.ceshi.potion.JqyydmMobEffect;
import net.mcreator.ceshi.potion.JishengMobEffect;
import net.mcreator.ceshi.potion.JinguMobEffect;
import net.mcreator.ceshi.potion.JingquedaimaMobEffect;
import net.mcreator.ceshi.potion.JiazuxianzhiMobEffect;
import net.mcreator.ceshi.potion.Jdsbcf2xgMobEffect;
import net.mcreator.ceshi.potion.Jdsbcf1xgMobEffect;
import net.mcreator.ceshi.potion.Jdsbcf0xgMobEffect;
import net.mcreator.ceshi.potion.HtdzMobEffect;
import net.mcreator.ceshi.potion.HslggzfuzhipinMobEffect;
import net.mcreator.ceshi.potion.HeisenlinggzMobEffect;
import net.mcreator.ceshi.potion.GuoquMobEffect;
import net.mcreator.ceshi.potion.GouyuMobEffect;
import net.mcreator.ceshi.potion.GongjitishengMobEffect;
import net.mcreator.ceshi.potion.Fzggzxg1MobEffect;
import net.mcreator.ceshi.potion.Fzggzxg0MobEffect;
import net.mcreator.ceshi.potion.FengraoMobEffect;
import net.mcreator.ceshi.potion.FeixingMobEffect;
import net.mcreator.ceshi.potion.DjqjkjxgxianzhiMobEffect;
import net.mcreator.ceshi.potion.DjppxianzhiMobEffect;
import net.mcreator.ceshi.potion.DjppMobEffect;
import net.mcreator.ceshi.potion.DiguixiaoguoMobEffect;
import net.mcreator.ceshi.potion.ChunmeipaoxianzhixiaoguoMobEffect;
import net.mcreator.ceshi.potion.ChicunbMobEffect;
import net.mcreator.ceshi.potion.ChicunaMobEffect;
import net.mcreator.ceshi.PrimogemcraftMod;

@EventBusSubscriber
public class PrimogemcraftModMobEffects {
	public static final DeferredRegister<MobEffect> REGISTRY = DeferredRegister.create(Registries.MOB_EFFECT, PrimogemcraftMod.MODID);
	public static final DeferredHolder<MobEffect, MobEffect> JISHENG = REGISTRY.register("jisheng", () -> new JishengMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> GONGJITISHENG = REGISTRY.register("gongjitisheng", () -> new GongjitishengMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> LETOUDECHENGFA = REGISTRY.register("letoudechengfa", () -> new LetoudechengfaMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> GOUYU = REGISTRY.register("gouyu", () -> new GouyuMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> GUOQU = REGISTRY.register("guoqu", () -> new GuoquMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> ZHANDOUZHUANGTAI = REGISTRY.register("zhandouzhuangtai", () -> new ZhandouzhuangtaiMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> FENGRAO = REGISTRY.register("fengrao", () -> new FengraoMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> ZHENGCHANGDAIMA = REGISTRY.register("zhengchangdaima", () -> new ZhengchangdaimaMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> QIQIAODAIMAXIUFU = REGISTRY.register("qiqiaodaimaxiufu", () -> new QiqiaodaimaxiufuMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> ZHONGGUIZHONGJUXIAOGUO = REGISTRY.register("zhongguizhongjuxiaoguo", () -> new ZhongguizhongjuxiaoguoMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> JINGQUEDAIMA = REGISTRY.register("jingquedaima", () -> new JingquedaimaMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> QUEZHUSHIXIAOGUO = REGISTRY.register("quezhushixiaoguo", () -> new QuezhushixiaoguoMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> DIGUIXIAOGUO = REGISTRY.register("diguixiaoguo", () -> new DiguixiaoguoMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> LINZHONG = REGISTRY.register("linzhong", () -> new LinzhongMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> QIANYE = REGISTRY.register("qianye", () -> new QianyeMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> QIANYELENGQUE = REGISTRY.register("qianyelengque", () -> new QianyelengqueMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> DJPP = REGISTRY.register("djpp", () -> new DjppMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> YIJI = REGISTRY.register("yiji", () -> new YijiMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> ZHUOSHAO = REGISTRY.register("zhuoshao", () -> new ZhuoshaoMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> FEIXING = REGISTRY.register("feixing", () -> new FeixingMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> QWYMGS = REGISTRY.register("qwymgs", () -> new QwymgsMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> TLDHY = REGISTRY.register("tldhy", () -> new TldhyMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> LJTDWQ = REGISTRY.register("ljtdwq", () -> new LjtdwqMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> SYZF = REGISTRY.register("syzf", () -> new SyzfMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> CHUNMEIPAOXIANZHIXIAOGUO = REGISTRY.register("chunmeipaoxianzhixiaoguo", () -> new ChunmeipaoxianzhixiaoguoMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> JIAZUXIANZHI = REGISTRY.register("jiazuxianzhi", () -> new JiazuxianzhiMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> DJPPXIANZHI = REGISTRY.register("djppxianzhi", () -> new DjppxianzhiMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> DJQJKJXGXIANZHI = REGISTRY.register("djqjkjxgxianzhi", () -> new DjqjkjxgxianzhiMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> HEISENLINGGZ = REGISTRY.register("heisenlinggz", () -> new HeisenlinggzMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> HSLGGZFUZHIPIN = REGISTRY.register("hslggzfuzhipin", () -> new HslggzfuzhipinMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> FZGGZXG_0 = REGISTRY.register("fzggzxg_0", () -> new Fzggzxg0MobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> FZGGZXG_1 = REGISTRY.register("fzggzxg_1", () -> new Fzggzxg1MobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> YYDGGZXG = REGISTRY.register("yydggzxg", () -> new YydggzxgMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> QWJLBBGSX_2 = REGISTRY.register("qwjlbbgsx_2", () -> new Qwjlbbgsx2MobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> WXNTDMJ = REGISTRY.register("wxntdmj", () -> new WxntdmjMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> QSKXJXTXG = REGISTRY.register("qskxjxtxg", () -> new QskxjxtxgMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> SMCLXG = REGISTRY.register("smclxg", () -> new SmclxgMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> SMCLZF = REGISTRY.register("smclzf", () -> new SmclzfMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> SHIJIANBUCHUFA = REGISTRY.register("shijianbuchufa", () -> new ShijianbuchufaMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> RYKJXG = REGISTRY.register("rykjxg", () -> new RykjxgMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> RYKJXGLQ = REGISTRY.register("rykjxglq", () -> new RykjxglqMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> RYFXGSX = REGISTRY.register("ryfxgsx", () -> new RyfxgsxMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> SZTSXCWDP = REGISTRY.register("sztsxcwdp", () -> new SztsxcwdpMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> YSRZXG = REGISTRY.register("ysrzxg", () -> new YsrzxgMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> X_GSMCW = REGISTRY.register("x_gsmcw", () -> new XGsmcwMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> HTDZ = REGISTRY.register("htdz", () -> new HtdzMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> XISHOULENGQUE = REGISTRY.register("xishoulengque", () -> new XishoulengqueMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> SKLJXG = REGISTRY.register("skljxg", () -> new SkljxgMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> JDSBCF_0XG = REGISTRY.register("jdsbcf_0xg", () -> new Jdsbcf0xgMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> JDSBCF_1XG = REGISTRY.register("jdsbcf_1xg", () -> new Jdsbcf1xgMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> JDSBCF_2XG = REGISTRY.register("jdsbcf_2xg", () -> new Jdsbcf2xgMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> JQYYDM = REGISTRY.register("jqyydm", () -> new JqyydmMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> CHICUNA = REGISTRY.register("chicuna", () -> new ChicunaMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> CHICUNB = REGISTRY.register("chicunb", () -> new ChicunbMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> JINGU = REGISTRY.register("jingu", () -> new JinguMobEffect());

	@SubscribeEvent
	public static void onEffectRemoved(MobEffectEvent.Remove event) {
		MobEffectInstance effectInstance = event.getEffectInstance();
		if (effectInstance != null) {
			expireEffects(event.getEntity(), effectInstance);
		}
	}

	@SubscribeEvent
	public static void onEffectExpired(MobEffectEvent.Expired event) {
		MobEffectInstance effectInstance = event.getEffectInstance();
		if (effectInstance != null) {
			expireEffects(event.getEntity(), effectInstance);
		}
	}

	private static void expireEffects(Entity entity, MobEffectInstance effectInstance) {
		if (effectInstance.getEffect().is(JISHENG)) {
			Xgjssx0Procedure.execute();
		} else if (effectInstance.getEffect().is(GONGJITISHENG)) {
			Gongjixiangzengyi_shuxingProcedure.execute();
		} else if (effectInstance.getEffect().is(LETOUDECHENGFA)) {
			LtcgxgsxProcedure.execute(entity.level(), entity);
		} else if (effectInstance.getEffect().is(GUOQU)) {
			Guoqu_jieshuProcedure.execute(entity.level(), entity);
		} else if (effectInstance.getEffect().is(FENGRAO)) {
			Fengrao_shuxing_4Procedure.execute(entity);
		} else if (effectInstance.getEffect().is(LINZHONG)) {
			Yimuguo_shuxingProcedure.execute(entity.level(), entity);
		} else if (effectInstance.getEffect().is(QIANYELENGQUE)) {
			QylqsxProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ());
		} else if (effectInstance.getEffect().is(DJPP)) {
			DjpppolieProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity);
		} else if (effectInstance.getEffect().is(TLDHY)) {
			Tldhy_sxProcedure.execute(entity.level(), entity);
		} else if (effectInstance.getEffect().is(HEISENLINGGZ)) {
			Heisenlin_ggz_xiaoguo_sx_1Procedure.execute(entity.level(), entity);
		} else if (effectInstance.getEffect().is(HSLGGZFUZHIPIN)) {
			Hslggz_xiaoguo_sx_2Procedure.execute(entity);
		} else if (effectInstance.getEffect().is(FZGGZXG_0)) {
			Flggzxgsx1Procedure.execute(entity.level(), entity);
		} else if (effectInstance.getEffect().is(FZGGZXG_1)) {
			Flggzxgsx2Procedure.execute(entity.level(), entity);
		} else if (effectInstance.getEffect().is(YYDGGZXG)) {
			YdggzxgsxProcedure.execute(entity.level(), entity);
		} else if (effectInstance.getEffect().is(WXNTDMJ)) {
			WxntdmjxgsxProcedure.execute(entity.level(), entity);
		} else if (effectInstance.getEffect().is(SMCLZF)) {
			Smcl_zf_sx_0Procedure.execute(entity.level(), entity);
		} else if (effectInstance.getEffect().is(X_GSMCW)) {
			XGsmcwsx0Procedure.execute();
		}
	}
}