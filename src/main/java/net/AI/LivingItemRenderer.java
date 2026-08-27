package net.AI;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.DiggerItem;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.client.model.SeparateTransformsModel;

public class LivingItemRenderer extends EntityRenderer<LivingItemEntity> {
	private static final ResourceLocation TEXTURE = ResourceLocation.parse("minecraft:textures/block/stone.png");

	public LivingItemRenderer(EntityRendererProvider.Context context) {
		super(context);
		this.shadowRadius = 0.4F;
	}

	@Override
	public ResourceLocation getTextureLocation(LivingItemEntity entity) {
		return TEXTURE;
	}

	@Override
	public void render(LivingItemEntity entity, float entityYaw, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight) {
		ItemStack stack = entity.getCarriedStack();
		if (stack.isEmpty()) {
			return;
		}
		poseStack.pushPose();
		BakedModel model = Minecraft.getInstance().getItemRenderer().getItemModelShaper().getItemModel(stack);
		if (model instanceof SeparateTransformsModel.Baked) {
			poseStack.translate(0.0, 0.35, 0.0);
			poseStack.mulPose(Axis.YP.rotationDegrees(-entity.getYRot() + 180.0F));
			applySwingPose(entity, stack, poseStack);
			Minecraft.getInstance().getItemRenderer().renderStatic(stack, ItemDisplayContext.THIRD_PERSON_RIGHT_HAND, packedLight, OverlayTexture.NO_OVERLAY, poseStack, bufferSource, entity.level(), entity.getId());
			poseStack.popPose();
			super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
			return;
		}
		float bob = (float) Math.sin((entity.tickCount + partialTick) * 0.12) * 0.1F;
		poseStack.translate(0.0, 0.35 + bob, 0.0);
		poseStack.scale(1.6F, 1.6F, 1.6F);
		poseStack.mulPose(Axis.YP.rotationDegrees(-entity.getYRot() + 180.0F));
		applySwingPose(entity, stack, poseStack);
		int rotate = entity.getRotateTicks();
		if (rotate > 0) {
			float progress = 1.0F - rotate / 10.0F;
			poseStack.mulPose(Axis.YP.rotationDegrees(360.0F * progress));
		}
		Minecraft.getInstance().getItemRenderer().renderStatic(stack, ItemDisplayContext.FIXED, packedLight, OverlayTexture.NO_OVERLAY, poseStack, bufferSource, entity.level(), entity.getId());
		poseStack.popPose();
		super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
	}

	private void applySwingPose(LivingItemEntity entity, ItemStack stack, PoseStack poseStack) {
		int swing = entity.getSwingTicks();
		if (swing <= 0) {
			return;
		}
		float progress = 1.0F - swing / 5.0F;
		if (stack.getItem() instanceof DiggerItem) {
			// 工具类：向前刺出（沿朝向平移捅出去）
			poseStack.translate(0.0, 0.0, progress * 0.5F);
		} else {
			// 其他物品：正面摆动（绕物品平面法线轴）
			poseStack.mulPose(Axis.ZP.rotationDegrees(-45.0F * progress));
		}
	}
}
