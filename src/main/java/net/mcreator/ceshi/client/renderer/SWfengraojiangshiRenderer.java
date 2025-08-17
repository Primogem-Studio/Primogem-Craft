package net.mcreator.ceshi.client.renderer;

import net.mcreator.ceshi.entity.SWfengraojiangshiEntity;
import net.minecraft.client.model.AnimationUtils;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

public class SWfengraojiangshiRenderer extends HumanoidMobRenderer<SWfengraojiangshiEntity, HumanoidModel<SWfengraojiangshiEntity>> {
    public SWfengraojiangshiRenderer(EntityRendererProvider.Context context) {
        super(context, new Model(context.bakeLayer(ModelLayers.PLAYER)), 0.5f);
        this.addLayer(new HumanoidArmorLayer<>(this, new Model(context.bakeLayer(ModelLayers.PLAYER_INNER_ARMOR)), new Model(context.bakeLayer(ModelLayers.PLAYER_OUTER_ARMOR)), context.getModelManager()));
    }

    @Override
    @NotNull
    public ResourceLocation getTextureLocation(@NotNull SWfengraojiangshiEntity entity) {
        return ResourceLocation.parse("primogemcraft:textures/entities/fengraoniewujiangshi.png");
    }

    private static class Model extends HumanoidModel<SWfengraojiangshiEntity> {
        public Model(ModelPart root) {
            super(root);
        }

        public void setupAnim(@NotNull SWfengraojiangshiEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
            super.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
            AnimationUtils.animateZombieArms(leftArm, rightArm, entity.isAggressive(), attackTime, ageInTicks);
        }
    }
}
