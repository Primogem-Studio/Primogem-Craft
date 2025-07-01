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
public class Modelheitaxiaoren_Converted_Converted<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath("primogemcraft", "modelheitaxiaoren_converted_converted"), "main");
	public final ModelPart bone;

	public Modelheitaxiaoren_Converted_Converted(ModelPart root) {
		this.bone = root.getChild("bone");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition bone = partdefinition.addOrReplaceChild("bone",
				CubeListBuilder.create().texOffs(0, 17).addBox(-4.0F, -2.0F, -4.0F, 9.0F, 2.0F, 9.0F, new CubeDeformation(0.0F)).texOffs(0, 0).addBox(-5.0F, -8.0F, -5.0F, 10.0F, 6.0F, 11.0F, new CubeDeformation(0.0F)).texOffs(27, 19)
						.addBox(-4.0F, -11.0F, -4.0F, 8.0F, 3.0F, 9.0F, new CubeDeformation(0.0F)).texOffs(26, 31).addBox(0.0F, -10.0F, -3.0F, 6.0F, 4.0F, 7.0F, new CubeDeformation(0.0F)).texOffs(19, 31)
						.addBox(-1.0F, -12.0F, 0.0F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(0, 4).addBox(6.0F, -8.0F, -5.0F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 24.0F, 0.0F, 0.0F, -1.5708F, 0.0F));
		PartDefinition cube_r1 = bone.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -14.0F, 1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.3054F, -0.0873F));
		PartDefinition bone2hua = bone.addOrReplaceChild("bone2hua", CubeListBuilder.create(), PartPose.offsetAndRotation(-1.0F, 0.0F, -1.0F, -0.088F, 0.1304F, 0.0322F));
		PartDefinition cube_r2 = bone2hua.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(31, 0).addBox(2.0F, -13.0F, -2.0F, 5.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.3927F, 0.0F, 0.0F));
		PartDefinition bone2 = bone2hua.addOrReplaceChild("bone2",
				CubeListBuilder.create().texOffs(0, 17).addBox(-2.0F, -17.0F, 1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(27, 17).addBox(1.0F, -17.0F, 1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(31, 6)
						.addBox(-1.0F, -16.0F, -1.0F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(0, 23).addBox(1.0F, -17.0F, -2.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 20)
						.addBox(-2.0F, -17.0F, -2.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(4.0F, 2.0F, -1.0F, -0.3927F, 0.0F, 0.0F));
		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int rgb) {
		bone.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
	}
}