package net.mcreator.ceshi;

import net.hackermdch.genshincraft.api.AddTrounceBlossomLootEvent;
import net.hackermdch.genshincraft.api.RegisterEffectRenderEvent;
import net.hackermdch.genshincraft.block.TrounceBlossom;
import net.hackermdch.genshincraft.data.GenshinComponents;
import net.hackermdch.genshincraft.data.PermanentInfusion;
import net.hackermdch.genshincraft.element.Element;
import net.hackermdch.genshincraft.render.EffectRender;
import net.mcreator.ceshi.init.PrimogemcraftModMobEffects;
import net.minecraft.core.component.DataComponentPatch;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.ModifyDefaultComponentsEvent;

import java.util.function.Consumer;

import static net.hackermdch.genshincraft.element.Element.Type.*;
import static net.mcreator.ceshi.init.PrimogemcraftModItems.*;

public class GenshinCraftLinkage {
    @SubscribeEvent
    private static void on(RegisterEffectRenderEvent event) {
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

    @SubscribeEvent
    private static void on(AddTrounceBlossomLootEvent event) {
        TrounceBlossom.addLoot(ZUISHENGSUIXIE.toStack(4), 0.8);
        TrounceBlossom.addLoot(ZUISHENGDUANPIAN.toStack(2), 0.4);
        TrounceBlossom.addLoot(ZUISHENGKUAI.toStack(1), 0.1);
        TrounceBlossom.addLoot(WQZHG.toStack(), 0.01);
    }

    @SubscribeEvent
    private static void on(ModifyDefaultComponentsEvent event) {
        event.modify(RYG, elemental(Pyro));
        event.modify(RYF, elemental(Pyro));
        event.modify(RYQ, elemental(Pyro));
        event.modify(RYC, elemental(Pyro));
        event.modify(DJC, elemental(Hydro));
        event.modify(DJF, elemental(Hydro));
        event.modify(ZFG, elemental(Hydro));
        event.modify(DJQ, elemental(Hydro));
        event.modify(DJG, elemental(Hydro));
        event.modify(ZSF, elemental(Electro));
        event.modify(ZSG, elemental(Electro));
        event.modify(ZSC, elemental(Electro));
        event.modify(ZSQ, elemental(Electro));
        event.modify(AXG, elemental(Cryo));
        event.modify(AXF, elemental(Cryo));
        event.modify(AXQ, elemental(Cryo));
        event.modify(AXC, elemental(Cryo));
        event.modify(YXAXG, elemental(Cryo));
        event.modify(SZF, elemental(Dendro));
        event.modify(SZG, elemental(Dendro));
        event.modify(SZC, elemental(Dendro));
        event.modify(SZQ, elemental(Dendro));
        event.modify(ZIZAIQIAO, elemental(Anemo));
        event.modify(ZIZAICHU, elemental(Anemo));
        event.modify(ZIZGAO, elemental(Anemo));
        event.modify(ZIZAIFU, elemental(Anemo));
        event.modify(JLQ, elemental(Geo));
        event.modify(JLG, elemental(Geo));
        event.modify(JLC, elemental(Geo));
        event.modify(JLF, elemental(Geo));
    }

    private static Consumer<DataComponentPatch.Builder> elemental(Element.Type type) {
        return builder -> builder.set(GenshinComponents.PERMANENT_INFUSION, new PermanentInfusion(type, false, false));
    }
}
