package net.mcreator.ceshi.client.gui;

import net.neoforged.neoforge.network.PacketDistributor;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.WidgetSprites;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.ceshi.world.inventory.BwdyinhangMenu;
import net.mcreator.ceshi.network.BwdyinhangButtonMessage;
import net.mcreator.ceshi.init.PrimogemcraftModScreens;

import com.mojang.blaze3d.systems.RenderSystem;

public class BwdyinhangScreen extends AbstractContainerScreen<BwdyinhangMenu> implements PrimogemcraftModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	ImageButton imagebutton_dui;
	ImageButton imagebutton_cuo;

	public BwdyinhangScreen(BwdyinhangMenu container, Inventory inventory, Component text) {
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

	private static final ResourceLocation texture = ResourceLocation.parse("primogemcraft:textures/screens/bwdyinhang.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		boolean customTooltipShown = false;
		if (mouseX > leftPos + 126 && mouseX < leftPos + 147 && mouseY > topPos + 27 && mouseY < topPos + 48) {
			guiGraphics.renderTooltip(font, Component.translatable("gui.primogemcraft.bwdyinhang.tooltip_ssecun_ru_hou_huo_de_bu_wen_ding_ping_zheng"), mouseX, mouseY);
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 126 && mouseX < leftPos + 148 && mouseY > topPos + 54 && mouseY < topPos + 75) {
			guiGraphics.renderTooltip(font, Component.translatable("gui.primogemcraft.bwdyinhang.tooltip_sscqing_ni_gun_kai_ss8cui_hui_she_shi"), mouseX, mouseY);
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
		guiGraphics.drawString(this.font, Component.translatable("gui.primogemcraft.bwdyinhang.label_cun_ru_yu_zhou_sui_pian_dang"), 47, 11, -10066330, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.primogemcraft.bwdyinhang.label_50gai_lu_huo_de_sui_ji"), 47, 41, -10066330, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.primogemcraft.bwdyinhang.label_bei_lu_yu_zhou_sui_pian"), 47, 51, -10066330, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.primogemcraft.bwdyinhang.label_yu_dao_lei_si_she_shi_shi"), 47, 21, -10066330, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.primogemcraft.bwdyinhang.label_ke_ti_gong_ping_zheng_bing_you"), 47, 31, -10066330, false);
	}

	@Override
	public void init() {
		super.init();
		imagebutton_dui = new ImageButton(this.leftPos + 127, this.topPos + 27, 21, 21, new WidgetSprites(ResourceLocation.parse("primogemcraft:textures/screens/duia1.png"), ResourceLocation.parse("primogemcraft:textures/screens/duia2.png")), e -> {
			int x = BwdyinhangScreen.this.x;
			int y = BwdyinhangScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new BwdyinhangButtonMessage(0, x, y, z));
				BwdyinhangButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_dui);
		imagebutton_cuo = new ImageButton(this.leftPos + 127, this.topPos + 54, 21, 21, new WidgetSprites(ResourceLocation.parse("primogemcraft:textures/screens/cuoa1.png"), ResourceLocation.parse("primogemcraft:textures/screens/cuoa2.png")), e -> {
			int x = BwdyinhangScreen.this.x;
			int y = BwdyinhangScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new BwdyinhangButtonMessage(1, x, y, z));
				BwdyinhangButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_cuo);
	}
}