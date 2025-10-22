package net.mcreator.ceshi;

import net.hacker.genshincraft.block.TrounceBlossom;
import net.hacker.genshincraft.render.EffectRender;
import net.mcreator.ceshi.init.PrimogemcraftModItems;
import net.mcreator.ceshi.init.PrimogemcraftModMobEffects;

public class GenshinCraftLinkage {
    private static boolean flag1, flag2;

    public static void effects() {
        if (flag1) return;
        flag1 = true;
        EffectRender.registerRenderEffect(PrimogemcraftModMobEffects.JISHENG, 255);
        EffectRender.registerRenderEffect(PrimogemcraftModMobEffects.GONGJITISHENG, 10);
        EffectRender.registerRenderEffect(PrimogemcraftModMobEffects.X_GSMCW, 255);
        EffectRender.registerRenderEffect(PrimogemcraftModMobEffects.ZHANDOUZHUANGTAI, 255);
        EffectRender.registerRenderEffect(PrimogemcraftModMobEffects.FENGRAO, 255);
        EffectRender.registerRenderEffect(PrimogemcraftModMobEffects.RYKJXG, 255);
        EffectRender.registerRenderEffect(PrimogemcraftModMobEffects.JDSBCF_0XG, 255);
        EffectRender.registerRenderEffect(PrimogemcraftModMobEffects.JDSBCF_1XG, 255);
        EffectRender.registerRenderEffect(PrimogemcraftModMobEffects.JDSBCF_2XG, 255);
        EffectRender.registerRenderEffect(PrimogemcraftModMobEffects.QWYMGS, 255);
        EffectRender.registerRenderEffect(PrimogemcraftModMobEffects.LINZHONG, 255);
        EffectRender.registerRenderEffect(PrimogemcraftModMobEffects.GUOQU, 255);
        EffectRender.registerRenderEffect(PrimogemcraftModMobEffects.HSLGGZFUZHIPIN, 255);
        EffectRender.registerRenderEffect(PrimogemcraftModMobEffects.FZGGZXG_0, 255);
        EffectRender.registerRenderEffect(PrimogemcraftModMobEffects.FZGGZXG_1, 255);
        EffectRender.registerRenderEffect(PrimogemcraftModMobEffects.HEISENLINGGZ, 255);
        EffectRender.registerRenderEffect(PrimogemcraftModMobEffects.YYDGGZXG, 255);
        EffectRender.registerRenderEffect(PrimogemcraftModMobEffects.CXBD, 255);
        EffectRender.registerRenderEffect(PrimogemcraftModMobEffects.ZHUOSHAO, 255);
    }

    public static void items() {
        if (flag2) return;
        flag2 = true;
        TrounceBlossom.addLoot(PrimogemcraftModItems.ZUISHENGSUIXIE.toStack(4), 0.8);
		TrounceBlossom.addLoot(PrimogemcraftModItems.ZUISHENGDUANPIAN.toStack(2), 0.4);
		TrounceBlossom.addLoot(PrimogemcraftModItems.ZUISHENGKUAI.toStack(1), 0.1);
		TrounceBlossom.addLoot(PrimogemcraftModItems.WQZHG.toStack(), 0.01);
    }
}
