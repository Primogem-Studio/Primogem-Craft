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

// Made with Blockbench 4.7.4
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports
public class Modelceshixiaodeng_Converted<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath("primogemcraft", "modelceshixiaodeng_converted"), "main");
	public final ModelPart xiaodeng;

	public Modelceshixiaodeng_Converted(ModelPart root) {
		this.xiaodeng = root.getChild("xiaodeng");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition xiaodeng = partdefinition.addOrReplaceChild("xiaodeng", CubeListBuilder.create(), PartPose.offset(1.0F, 24.0F, -2.0F));
		PartDefinition zhuti = xiaodeng.addOrReplaceChild("zhuti",
				CubeListBuilder.create().texOffs(60, 51).addBox(-1.0F, -18.0F, -16.0F, 18.0F, 1.0F, 18.0F, new CubeDeformation(0.0F)).texOffs(20, 73).addBox(2.0F, -19.0F, -13.0F, 12.0F, 1.0F, 12.0F, new CubeDeformation(0.0F)).texOffs(82, 70)
						.addBox(3.0F, -21.0F, -12.0F, 10.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)).texOffs(56, 73).addBox(5.0F, -23.0F, -10.0F, 6.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(0, 0)
						.addBox(7.0F, -27.0F, -8.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 51).addBox(-2.0F, -8.0F, -17.0F, 20.0F, 2.0F, 20.0F, new CubeDeformation(0.0F)).texOffs(0, 29)
						.addBox(-2.0F, -17.0F, -17.0F, 20.0F, 2.0F, 20.0F, new CubeDeformation(0.0F)).texOffs(60, 29).addBox(-1.0F, -6.0F, -16.0F, 18.0F, 2.0F, 18.0F, new CubeDeformation(0.0F)).texOffs(0, 0)
						.addBox(-3.0F, -15.0F, -18.0F, 22.0F, 7.0F, 22.0F, new CubeDeformation(0.0F)).texOffs(66, 0).addBox(0.0F, -4.0F, -15.0F, 16.0F, 1.0F, 16.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition bian = zhuti.addOrReplaceChild("bian",
				CubeListBuilder.create().texOffs(0, 12).addBox(7.0F, -25.0F, -4.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(8, 6).addBox(7.0F, -25.0F, -12.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(8, 0)
						.addBox(3.0F, -25.0F, -8.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 6).addBox(11.0F, -25.0F, -8.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition bone = bian.addOrReplaceChild("bone",
				CubeListBuilder.create().texOffs(16, 8).addBox(2.0F, -23.0F, -8.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(16, 0).addBox(13.0F, -23.0F, -7.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(15, 11)
						.addBox(7.0F, -23.0F, -2.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(15, 5).addBox(8.0F, -23.0F, -13.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition dizuo = xiaodeng.addOrReplaceChild("dizuo",
				CubeListBuilder.create().texOffs(0, 39).addBox(5.0F, -3.0F, -3.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(8, 34).addBox(2.0F, -3.0F, -6.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 34)
						.addBox(2.0F, -3.0F, -10.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(8, 29).addBox(5.0F, -3.0F, -13.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 29)
						.addBox(9.0F, -3.0F, -13.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(6, 17).addBox(12.0F, -3.0F, -6.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(14, 15)
						.addBox(12.0F, -3.0F, -10.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(8, 12).addBox(9.0F, -3.0F, -3.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 98)
						.addBox(4.0F, -2.0F, -11.0F, 8.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition bianyuan = xiaodeng
				.addOrReplaceChild(
						"bianyuan", CubeListBuilder.create().texOffs(72, 98).addBox(-1.0F, -16.0F, -19.0F, 18.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(88, 17).addBox(-1.0F, -16.0F, 4.0F, 18.0F, 7.0F, 1.0F, new CubeDeformation(0.0F))
								.texOffs(0, 73).addBox(19.0F, -16.0F, -16.0F, 1.0F, 7.0F, 18.0F, new CubeDeformation(0.0F)).texOffs(62, 70).addBox(-4.0F, -16.0F, -16.0F, 1.0F, 7.0F, 18.0F, new CubeDeformation(0.0F)),
						PartPose.offset(0.0F, 1.0F, 0.0F));
		PartDefinition bianyuan2 = bianyuan
				.addOrReplaceChild(
						"bianyuan2", CubeListBuilder.create().texOffs(102, 88).addBox(1.0F, -11.0F, -18.0F, 14.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(102, 85).addBox(1.0F, -11.0F, 3.0F, 14.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
								.texOffs(56, 95).addBox(18.0F, -11.0F, -14.0F, 1.0F, 2.0F, 14.0F, new CubeDeformation(0.0F)).texOffs(40, 88).addBox(-3.0F, -11.0F, -14.0F, 1.0F, 2.0F, 14.0F, new CubeDeformation(0.0F)),
						PartPose.offset(0.0F, 2.0F, 0.0F));
		PartDefinition bianyuan3 = bianyuan2
				.addOrReplaceChild(
						"bianyuan3", CubeListBuilder.create().texOffs(102, 82).addBox(1.0F, -11.0F, -18.0F, 14.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(88, 25).addBox(1.0F, -11.0F, 3.0F, 14.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
								.texOffs(86, 82).addBox(18.0F, -11.0F, -14.0F, 1.0F, 2.0F, 14.0F, new CubeDeformation(0.0F)).texOffs(24, 86).addBox(-3.0F, -11.0F, -14.0F, 1.0F, 2.0F, 14.0F, new CubeDeformation(0.0F)),
						PartPose.offset(0.0F, -9.0F, 0.0F));
		return LayerDefinition.create(meshdefinition, 256, 256);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int rgb) {
		xiaodeng.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	}
}