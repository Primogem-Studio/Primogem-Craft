package net.mcreator.ceshi.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.ceshi.entity.BaiguangguodushengwuEntity;
import net.mcreator.ceshi.client.model.Modeljinguangshiti01_Converted_Converted;

public class BaiguangguodushengwuRenderer extends MobRenderer<BaiguangguodushengwuEntity, Modeljinguangshiti01_Converted_Converted<BaiguangguodushengwuEntity>> {
	public BaiguangguodushengwuRenderer(EntityRendererProvider.Context context) {
		super(context, new Modeljinguangshiti01_Converted_Converted<BaiguangguodushengwuEntity>(context.bakeLayer(Modeljinguangshiti01_Converted_Converted.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(BaiguangguodushengwuEntity entity) {
		return ResourceLocation.parse("primogemcraft:textures/entities/baiguang.png");
	}
}