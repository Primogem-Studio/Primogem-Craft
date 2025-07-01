package net.mcreator.ceshi.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.ceshi.entity.XiaoheitaEntity;
import net.mcreator.ceshi.client.model.Modelheitaxiaoren_Converted_Converted;

public class XiaoheitaRenderer extends MobRenderer<XiaoheitaEntity, Modelheitaxiaoren_Converted_Converted<XiaoheitaEntity>> {
	public XiaoheitaRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelheitaxiaoren_Converted_Converted<XiaoheitaEntity>(context.bakeLayer(Modelheitaxiaoren_Converted_Converted.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(XiaoheitaEntity entity) {
		return ResourceLocation.parse("primogemcraft:textures/entities/ht.png");
	}
}