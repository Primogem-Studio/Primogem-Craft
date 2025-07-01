package net.mcreator.ceshi.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.ceshi.entity.XiaodengEntity;
import net.mcreator.ceshi.client.model.Modelceshixiaodeng_Converted;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class XiaodengRenderer extends MobRenderer<XiaodengEntity, Modelceshixiaodeng_Converted<XiaodengEntity>> {
	public XiaodengRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelceshixiaodeng_Converted<XiaodengEntity>(context.bakeLayer(Modelceshixiaodeng_Converted.LAYER_LOCATION)), 0.5f);
		this.addLayer(new RenderLayer<XiaodengEntity, Modelceshixiaodeng_Converted<XiaodengEntity>>(this) {
			final ResourceLocation LAYER_TEXTURE = ResourceLocation.parse("primogemcraft:textures/entities/ceshixiaodeng_tietu.png");

			@Override
			public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, XiaodengEntity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
				VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.eyes(LAYER_TEXTURE));
				this.getParentModel().renderToBuffer(poseStack, vertexConsumer, light, LivingEntityRenderer.getOverlayCoords(entity, 0));
			}
		});
	}

	@Override
	public ResourceLocation getTextureLocation(XiaodengEntity entity) {
		return ResourceLocation.parse("primogemcraft:textures/entities/ceshixiaodeng_tietu.png");
	}
}