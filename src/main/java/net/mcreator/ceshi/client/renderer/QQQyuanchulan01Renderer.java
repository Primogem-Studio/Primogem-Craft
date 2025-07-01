package net.mcreator.ceshi.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.ceshi.entity.QQQyuanchulan01Entity;
import net.mcreator.ceshi.client.model.Modeljinguangshiti01_Converted_Converted;

public class QQQyuanchulan01Renderer extends MobRenderer<QQQyuanchulan01Entity, Modeljinguangshiti01_Converted_Converted<QQQyuanchulan01Entity>> {
	public QQQyuanchulan01Renderer(EntityRendererProvider.Context context) {
		super(context, new Modeljinguangshiti01_Converted_Converted<QQQyuanchulan01Entity>(context.bakeLayer(Modeljinguangshiti01_Converted_Converted.LAYER_LOCATION)), 0.3f);
	}

	@Override
	public ResourceLocation getTextureLocation(QQQyuanchulan01Entity entity) {
		return ResourceLocation.parse("primogemcraft:textures/entities/languang.png");
	}
}