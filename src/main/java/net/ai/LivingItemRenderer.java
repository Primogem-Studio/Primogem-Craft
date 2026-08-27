package net.ai;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.model.ItemTransform;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.neoforged.neoforge.client.model.SeparateTransformsModel;

public class LivingItemRenderer extends EntityRenderer<LivingItemEntity> {
	private static final ResourceLocation TEXTURE = ResourceLocation.parse("minecraft:textures/block/stone.png");

	private static ItemTransform defaultFlatThirdPerson;
	private static boolean defaultFlatThirdPersonResolved;

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
		if (entity.isInvisible()) {
			return;
		}
		ItemStack stack = entity.getCarriedStack();
		if (stack.isEmpty()) {
			return;
		}
		poseStack.pushPose();
		BakedModel model = Minecraft.getInstance().getItemRenderer().getItemModelShaper().getItemModel(stack);
		int swing = entity.getSwingTicks();
		boolean bowDrawing = LivingItemEntity.isBowLike(stack) && swing > 0;
		ItemDisplayContext displayContext = resolveDisplayContext(model, bowDrawing);
		float bob = (float) Math.sin((entity.tickCount + partialTick) * 0.12) * 0.1F;
		poseStack.translate(0.0, 0.35 + bob, 0.0);
		poseStack.mulPose(Axis.YP.rotationDegrees(-entity.getYRot() + 180.0F));
		if (bowDrawing) {
			applyBowDrawPose(swing, poseStack);
		} else {
			applySwingPose(entity, stack, poseStack);
		}
		if (displayContext != ItemDisplayContext.THIRD_PERSON_RIGHT_HAND || model.getTransforms() == ItemTransforms.NO_TRANSFORMS) {
			poseStack.scale(1.6F, 1.6F, 1.6F);
		}
		int rotate = entity.getRotateTicks();
		if (rotate > 0) {
			float progress = 1.0F - rotate / 10.0F;
			poseStack.mulPose(Axis.YP.rotationDegrees(360.0F * progress));
		}
		Minecraft.getInstance().getItemRenderer().renderStatic(stack, displayContext, packedLight, OverlayTexture.NO_OVERLAY, poseStack, bufferSource, entity.level(), entity.getId());
		poseStack.popPose();
		super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
	}

	private ItemDisplayContext resolveDisplayContext(BakedModel model, boolean bowDrawing) {
		if (bowDrawing || model instanceof SeparateTransformsModel.Baked) {
			return ItemDisplayContext.THIRD_PERSON_RIGHT_HAND;
		}
		ItemTransforms transforms = model.getTransforms();
		if (transforms == ItemTransforms.NO_TRANSFORMS) {
			return ItemDisplayContext.THIRD_PERSON_RIGHT_HAND;
		}
		if (!transforms.thirdPersonRightHand.equals(defaultFlatThirdPerson())) {
			return ItemDisplayContext.THIRD_PERSON_RIGHT_HAND;
		}
		return ItemDisplayContext.FIXED;
	}

	private static ItemTransform defaultFlatThirdPerson() {
		if (!defaultFlatThirdPersonResolved) {
			BakedModel paper = Minecraft.getInstance().getItemRenderer().getItemModelShaper().getItemModel(new ItemStack(Items.PAPER));
			defaultFlatThirdPerson = paper.getTransforms().thirdPersonRightHand;
			defaultFlatThirdPersonResolved = true;
		}
		return defaultFlatThirdPerson;
	}

	/** 弓/弩类：使用其拉弓动作（与原版手持拉弓一致的变换），进度由实体拉弓刻数决定 */
	private void applyBowDrawPose(int swing, PoseStack poseStack) {
		float progress = Mth.clamp(1.0F - swing / (float) LivingItemEntity.BOW_DRAW_TICKS, 0.0F, 1.0F);
		poseStack.translate(-0.2785682F, 0.18344387F, 0.15731531F);
		poseStack.mulPose(Axis.XP.rotationDegrees(-13.935F));
		poseStack.mulPose(Axis.YP.rotationDegrees(35.3F));
		poseStack.mulPose(Axis.ZP.rotationDegrees(-9.785F));
		poseStack.translate(0.0F, 0.0F, progress * 0.04F);
		poseStack.scale(1.0F, 1.0F, 1.0F + progress * 0.2F);
		poseStack.mulPose(Axis.YN.rotationDegrees(45.0F));
	}

	private void applySwingPose(LivingItemEntity entity, ItemStack stack, PoseStack poseStack) {
		int swing = entity.getSwingTicks();
		if (swing <= 0) {
			return;
		}
		float progress = 1.0F - swing / 5.0F;
		if (stack.getItem() instanceof net.minecraft.world.item.DiggerItem) {
			poseStack.mulPose(Axis.XP.rotationDegrees(-90.0F * progress));
		} else {
			poseStack.mulPose(Axis.ZP.rotationDegrees(-45.0F * progress));
		}
	}
}
