package net.mcreator.ceshi.client.model;

import net.minecraft.world.entity.Entity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.EntityModel;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

// Made with Blockbench 4.8.3
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports
public class Modelcx_cyhsrmx<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath("primogemcraft", "modelcx_cyhsrmx"), "main");
	public final ModelPart zhongzi;

	public Modelcx_cyhsrmx(ModelPart root) {
		this.zhongzi = root.getChild("zhongzi");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition zhongzi = partdefinition.addOrReplaceChild("zhongzi",
				CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, -4.0F, -3.0F, 6.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(13, 22).addBox(-1.0F, 1.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(18, 0)
						.addBox(-2.0F, 0.0F, -1.0F, 4.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 15).addBox(-1.0F, 0.0F, -2.0F, 2.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(12, 11)
						.addBox(-2.0F, -5.0F, -2.0F, 4.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(5, 21).addBox(-2.0F, -5.0F, 2.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(18, 3)
						.addBox(-2.0F, -5.0F, -3.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(14, 17).addBox(2.0F, -5.0F, -2.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(8, 16)
						.addBox(-3.0F, -5.0F, -2.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(0, 10).addBox(-2.0F, -6.0F, -2.0F, 4.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(22, 8)
						.addBox(-1.0F, -7.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(12, 27).addBox(2.0F, -6.0F, 0.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(12, 12)
						.addBox(-1.0F, -6.0F, 2.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(12, 10).addBox(-1.0F, 0.0F, 2.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 12)
						.addBox(-1.0F, 1.0F, 1.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 10).addBox(-1.0F, 2.0F, -1.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 24)
						.addBox(-3.0F, -2.0F, -4.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(19, 22).addBox(0.0F, -2.0F, 3.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(12, 25)
						.addBox(-3.0F, -2.0F, 3.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(24, 20).addBox(1.0F, -2.0F, -4.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(20, 16)
						.addBox(-4.0F, -2.0F, 0.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(24, 11).addBox(-4.0F, -2.0F, -3.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(24, 5)
						.addBox(3.0F, -2.0F, 1.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 20).addBox(3.0F, -2.0F, -3.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(0, 0)
						.addBox(-1.0F, -5.0F, 3.0F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(14, 18).addBox(0.0F, -6.0F, -3.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(14, 16)
						.addBox(-3.0F, -6.0F, -1.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(8, 15).addBox(-3.0F, 0.0F, -1.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 15)
						.addBox(-2.0F, 1.0F, -1.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(8, 23).addBox(-4.0F, -5.0F, -1.0F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(20, 24)
						.addBox(0.0F, -5.0F, -4.0F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(4, 26).addBox(2.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 26)
						.addBox(1.0F, 1.0F, 0.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(25, 16).addBox(0.0F, 2.0F, 0.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(8, 17)
						.addBox(0.0F, 1.0F, -2.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 17).addBox(0.0F, 0.0F, -3.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(24, 24)
						.addBox(3.0F, -5.0F, 0.0F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 20.0F, 0.0F));
		return LayerDefinition.create(meshdefinition, 32, 32);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int rgb) {
		zhongzi.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.zhongzi.yRot = ageInTicks;
	}
}