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

import net.mcreator.ceshi.world.inventory.GUIqiwuxuanzeMenu;
import net.mcreator.ceshi.network.GUIqiwuxuanzeButtonMessage;
import net.mcreator.ceshi.init.PrimogemcraftModScreens;

import com.mojang.blaze3d.systems.RenderSystem;

public class GUIqiwuxuanzeScreen extends AbstractContainerScreen<GUIqiwuxuanzeMenu> implements PrimogemcraftModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	ImageButton imagebutton_xuanze0;
	ImageButton imagebutton_xuanze01;
	ImageButton imagebutton_xuanze02;

	public GUIqiwuxuanzeScreen(GUIqiwuxuanzeMenu container, Inventory inventory, Component text) {
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

	private static final ResourceLocation texture = ResourceLocation.parse("primogemcraft:textures/screens/gu_iqiwuxuanze.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		boolean customTooltipShown = false;
		if (mouseX > leftPos + 32 && mouseX < leftPos + 48 && mouseY > topPos + 52 && mouseY < topPos + 68) {
			guiGraphics.renderTooltip(font, Component.translatable("gui.primogemcraft.gu_iqiwuxuanze.tooltip_sseque_ren_xuan_ze"), mouseX, mouseY);
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 79 && mouseX < leftPos + 95 && mouseY > topPos + 53 && mouseY < topPos + 69) {
			guiGraphics.renderTooltip(font, Component.translatable("gui.primogemcraft.gu_iqiwuxuanze.tooltip_sseque_ren_xuan_ze1"), mouseX, mouseY);
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 124 && mouseX < leftPos + 140 && mouseY > topPos + 53 && mouseY < topPos + 69) {
			guiGraphics.renderTooltip(font, Component.translatable("gui.primogemcraft.gu_iqiwuxuanze.tooltip_sseque_ren_xuan_ze2"), mouseX, mouseY);
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 5 && mouseX < leftPos + 53 && mouseY > topPos + 6 && mouseY < topPos + 14) {
			guiGraphics.renderTooltip(font, Component.translatable("gui.primogemcraft.gu_iqiwuxuanze.tooltip_sscqiang_zhi_tui_chu_jie_mian_hui_sui_ji_xuan_ze_ge_qi_wu"), mouseX, mouseY);
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
		guiGraphics.drawString(this.font, Component.translatable("gui.primogemcraft.gu_iqiwuxuanze.label_xuan_ze_ge_qi_wu"), 5, 5, -1, false);
	}

	@Override
	public void init() {
		super.init();
		imagebutton_xuanze0 = new ImageButton(this.leftPos + 35, this.topPos + 53, 16, 16, new WidgetSprites(ResourceLocation.parse("primogemcraft:textures/screens/xuanze0.png"), ResourceLocation.parse("primogemcraft:textures/screens/xuanze1.png")),
				e -> {
					int x = GUIqiwuxuanzeScreen.this.x;
					int y = GUIqiwuxuanzeScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new GUIqiwuxuanzeButtonMessage(0, x, y, z));
						GUIqiwuxuanzeButtonMessage.handleButtonAction(entity, 0, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_xuanze0);
		imagebutton_xuanze01 = new ImageButton(this.leftPos + 79, this.topPos + 53, 16, 16, new WidgetSprites(ResourceLocation.parse("primogemcraft:textures/screens/xuanze0.png"), ResourceLocation.parse("primogemcraft:textures/screens/xuanze1.png")),
				e -> {
					int x = GUIqiwuxuanzeScreen.this.x;
					int y = GUIqiwuxuanzeScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new GUIqiwuxuanzeButtonMessage(1, x, y, z));
						GUIqiwuxuanzeButtonMessage.handleButtonAction(entity, 1, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_xuanze01);
		imagebutton_xuanze02 = new ImageButton(this.leftPos + 124, this.topPos + 53, 16, 16,
				new WidgetSprites(ResourceLocation.parse("primogemcraft:textures/screens/xuanze0.png"), ResourceLocation.parse("primogemcraft:textures/screens/xuanze1.png")), e -> {
					int x = GUIqiwuxuanzeScreen.this.x;
					int y = GUIqiwuxuanzeScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new GUIqiwuxuanzeButtonMessage(2, x, y, z));
						GUIqiwuxuanzeButtonMessage.handleButtonAction(entity, 2, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_xuanze02);
	}
}