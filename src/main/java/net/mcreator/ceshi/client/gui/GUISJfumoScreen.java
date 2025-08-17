package net.mcreator.ceshi.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.ceshi.world.inventory.GUISJfumoMenu;
import net.mcreator.ceshi.procedures.GUIfumopinzhixianshi3Procedure;
import net.mcreator.ceshi.procedures.GUIfumopinzhixianshi2Procedure;
import net.mcreator.ceshi.procedures.GUIfumopinzhixianshi1Procedure;
import net.mcreator.ceshi.procedures.GUIfumopinzhixianshi0Procedure;
import net.mcreator.ceshi.procedures.GUIfumobaocuoProcedure;
import net.mcreator.ceshi.init.PrimogemcraftModScreens;

import com.mojang.blaze3d.systems.RenderSystem;

public class GUISJfumoScreen extends AbstractContainerScreen<GUISJfumoMenu> implements PrimogemcraftModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;

	public GUISJfumoScreen(GUISJfumoMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 166;
	}

	@Override
	public void updateMenuState(int elementType, String name, Object elementState) {
		menuStateUpdateActive = true;
		menuStateUpdateActive = false;
	}

	private static final ResourceLocation texture = ResourceLocation.parse("primogemcraft:textures/screens/guis_jfumo.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		boolean customTooltipShown = false;
		if (GUIfumobaocuoProcedure.execute(entity))
			if (mouseX > leftPos + 97 && mouseX < leftPos + 102 && mouseY > topPos + 29 && mouseY < topPos + 57) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.primogemcraft.guis_jfumo.tooltip_sscgai_wu_pin_bu_man_zu_fu_mo_tiao_jian"), mouseX, mouseY);
				customTooltipShown = true;
			}
		if (GUIfumopinzhixianshi0Procedure.execute(world))
			if (mouseX > leftPos + 74 && mouseX < leftPos + 98 && mouseY > topPos + 52 && mouseY < topPos + 57) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.primogemcraft.guis_jfumo.tooltip_sscgai_wu_pin_bu_man_zu_fu_mo_tiao_jian1"), mouseX, mouseY);
				customTooltipShown = true;
			}
		if (GUIfumopinzhixianshi0Procedure.execute(world))
			if (mouseX > leftPos + 74 && mouseX < leftPos + 79 && mouseY > topPos + 29 && mouseY < topPos + 52) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.primogemcraft.guis_jfumo.tooltip_sscgai_wu_pin_bu_man_zu_fu_mo_tiao_jian2"), mouseX, mouseY);
				customTooltipShown = true;
			}
		if (GUIfumopinzhixianshi0Procedure.execute(world))
			if (mouseX > leftPos + 79 && mouseX < leftPos + 97 && mouseY > topPos + 29 && mouseY < topPos + 34) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.primogemcraft.guis_jfumo.tooltip_sscgai_wu_pin_bu_man_zu_fu_mo_tiao_jian3"), mouseX, mouseY);
				customTooltipShown = true;
			}
		if (GUIfumopinzhixianshi0Procedure.execute(world))
			if (mouseX > leftPos + 80 && mouseX < leftPos + 97 && mouseY > topPos + 20 && mouseY < topPos + 28) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.primogemcraft.guis_jfumo.tooltip_ss7di_pin_zhi_fu_mo"), mouseX, mouseY);
				customTooltipShown = true;
			}
		if (GUIfumopinzhixianshi1Procedure.execute(world))
			if (mouseX > leftPos + 80 && mouseX < leftPos + 97 && mouseY > topPos + 20 && mouseY < topPos + 28) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.primogemcraft.guis_jfumo.tooltip_ssbzhong_pin_zhi_fu_mo"), mouseX, mouseY);
				customTooltipShown = true;
			}
		if (GUIfumopinzhixianshi2Procedure.execute(world))
			if (mouseX > leftPos + 80 && mouseX < leftPos + 97 && mouseY > topPos + 20 && mouseY < topPos + 28) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.primogemcraft.guis_jfumo.tooltip_ss6gao_pin_zhi_fu_mo"), mouseX, mouseY);
				customTooltipShown = true;
			}
		if (GUIfumopinzhixianshi3Procedure.execute(world))
			if (mouseX > leftPos + 80 && mouseX < leftPos + 97 && mouseY > topPos + 20 && mouseY < topPos + 28) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.primogemcraft.guis_jfumo.tooltip_sscte_ji_fu_mo"), mouseX, mouseY);
				customTooltipShown = true;
			}
		if (!customTooltipShown)
			this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int mouseX, int mouseY) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
		if (GUIfumobaocuoProcedure.execute(entity)) {
			guiGraphics.blit(ResourceLocation.parse("primogemcraft:textures/screens/gui_baocuo.png"), this.leftPos + 74, this.topPos + 29, 0, 0, 28, 28, 28, 28);
		}
		if (GUIfumopinzhixianshi0Procedure.execute(world)) {
			guiGraphics.blit(ResourceLocation.parse("primogemcraft:textures/screens/guifu_bai.png"), this.leftPos + 80, this.topPos + 20, 0, 0, 17, 8, 17, 8);
		}
		if (GUIfumopinzhixianshi1Procedure.execute(world)) {
			guiGraphics.blit(ResourceLocation.parse("primogemcraft:textures/screens/guifu_lan.png"), this.leftPos + 80, this.topPos + 20, 0, 0, 17, 8, 17, 8);
		}
		if (GUIfumopinzhixianshi2Procedure.execute(world)) {
			guiGraphics.blit(ResourceLocation.parse("primogemcraft:textures/screens/guifu_huang.png"), this.leftPos + 80, this.topPos + 20, 0, 0, 17, 8, 17, 8);
		}
		if (GUIfumopinzhixianshi3Procedure.execute(world)) {
			guiGraphics.blit(ResourceLocation.parse("primogemcraft:textures/screens/guifu_rhong.png"), this.leftPos + 80, this.topPos + 20, 0, 0, 17, 8, 17, 8);
		}
		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		guiGraphics.drawString(this.font, Component.translatable("gui.primogemcraft.guis_jfumo.label_fang_ru_ke_fu_mo_wu_pin"), 6, 5, -5070724, false);
	}

	@Override
	public void init() {
		super.init();
	}
}