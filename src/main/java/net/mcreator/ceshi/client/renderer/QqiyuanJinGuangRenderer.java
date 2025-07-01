package net.mcreator.ceshi.client.renderer;

import net.minecraft.world.level.Level;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.Minecraft;

import net.mcreator.ceshi.procedures.ScmjSxProcedure;
import net.mcreator.ceshi.procedures.BhmgsxProcedure;
import net.mcreator.ceshi.entity.QqiyuanJinGuangEntity;
import net.mcreator.ceshi.client.model.Modeljinguangshiti01_Converted_Converted;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class QqiyuanJinGuangRenderer extends MobRenderer<QqiyuanJinGuangEntity, Modeljinguangshiti01_Converted_Converted<QqiyuanJinGuangEntity>> {
	public QqiyuanJinGuangRenderer(EntityRendererProvider.Context context) {
		super(context, new Modeljinguangshiti01_Converted_Converted<QqiyuanJinGuangEntity>(context.bakeLayer(Modeljinguangshiti01_Converted_Converted.LAYER_LOCATION)), 0.3f);
		this.addLayer(new RenderLayer<QqiyuanJinGuangEntity, Modeljinguangshiti01_Converted_Converted<QqiyuanJinGuangEntity>>(this) {
			final ResourceLocation LAYER_TEXTURE = ResourceLocation.parse("primogemcraft:textures/entities/buhuomingguang.png");

			@Override
			public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, QqiyuanJinGuangEntity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
				Level world = entity.level();
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();
				if (BhmgsxProcedure.execute(entity)) {
					VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.entityCutoutNoCull(LAYER_TEXTURE));
					EntityModel model = new Modeljinguangshiti01_Converted_Converted(Minecraft.getInstance().getEntityModels().bakeLayer(Modeljinguangshiti01_Converted_Converted.LAYER_LOCATION));
					this.getParentModel().copyPropertiesTo(model);
					model.prepareMobModel(entity, limbSwing, limbSwingAmount, partialTicks);
					model.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
					model.renderToBuffer(poseStack, vertexConsumer, light, LivingEntityRenderer.getOverlayCoords(entity, 0));
				}
			}
		});
		this.addLayer(new RenderLayer<QqiyuanJinGuangEntity, Modeljinguangshiti01_Converted_Converted<QqiyuanJinGuangEntity>>(this) {
			final ResourceLocation LAYER_TEXTURE = ResourceLocation.parse("primogemcraft:textures/entities/qq_caise.png");

			@Override
			public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, QqiyuanJinGuangEntity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
				Level world = entity.level();
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();
				if (ScmjSxProcedure.execute(entity)) {
					VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.entityCutoutNoCull(LAYER_TEXTURE));
					EntityModel model = new Modeljinguangshiti01_Converted_Converted(Minecraft.getInstance().getEntityModels().bakeLayer(Modeljinguangshiti01_Converted_Converted.LAYER_LOCATION));
					this.getParentModel().copyPropertiesTo(model);
					model.prepareMobModel(entity, limbSwing, limbSwingAmount, partialTicks);
					model.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
					model.renderToBuffer(poseStack, vertexConsumer, light, LivingEntityRenderer.getOverlayCoords(entity, 0));
				}
			}
		});
	}

	@Override
	public ResourceLocation getTextureLocation(QqiyuanJinGuangEntity entity) {
		return ResourceLocation.parse("primogemcraft:textures/entities/texture.png");
	}
}