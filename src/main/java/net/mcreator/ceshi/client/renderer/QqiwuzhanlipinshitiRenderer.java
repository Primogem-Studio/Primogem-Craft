package net.mcreator.ceshi.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.HumanoidModel;

import net.mcreator.ceshi.entity.QqiwuzhanlipinshitiEntity;

public class QqiwuzhanlipinshitiRenderer extends HumanoidMobRenderer<QqiwuzhanlipinshitiEntity, HumanoidModel<QqiwuzhanlipinshitiEntity>> {
	public QqiwuzhanlipinshitiRenderer(EntityRendererProvider.Context context) {
		super(context, new HumanoidModel<QqiwuzhanlipinshitiEntity>(context.bakeLayer(ModelLayers.PLAYER)), 0.1f);
		this.addLayer(new HumanoidArmorLayer(this, new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_INNER_ARMOR)), new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_OUTER_ARMOR)), context.getModelManager()));
	}

	@Override
	public ResourceLocation getTextureLocation(QqiwuzhanlipinshitiEntity entity) {
		return ResourceLocation.parse("primogemcraft:textures/entities/toumingshiti.png");
	}
}