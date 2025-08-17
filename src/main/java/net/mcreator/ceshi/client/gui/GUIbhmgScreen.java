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

import net.mcreator.ceshi.world.inventory.GUIbhmgMenu;
import net.mcreator.ceshi.network.GUIbhmgButtonMessage;
import net.mcreator.ceshi.init.PrimogemcraftModScreens;

import com.mojang.blaze3d.systems.RenderSystem;

public class GUIbhmgScreen extends AbstractContainerScreen<GUIbhmgMenu> implements PrimogemcraftModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	ImageButton imagebutton_xuanze0;
	ImageButton imagebutton_xuanze01;
	ImageButton imagebutton_xuanze02;
	ImageButton imagebutton_cuoa1;

	public GUIbhmgScreen(GUIbhmgMenu container, Inventory inventory, Component text) {
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

	private static final ResourceLocation texture = ResourceLocation.parse("primogemcraft:textures/screens/gu_ibhmg.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		boolean customTooltipShown = false;
		if (mouseX > leftPos + 59 && mouseX < leftPos + 75 && mouseY > topPos + 53 && mouseY < topPos + 69) {
			guiGraphics.renderTooltip(font, Component.translatable("gui.primogemcraft.gu_ibhmg.tooltip_sseque_ren_xuan_ze"), mouseX, mouseY);
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 99 && mouseX < leftPos + 115 && mouseY > topPos + 53 && mouseY < topPos + 69) {
			guiGraphics.renderTooltip(font, Component.translatable("gui.primogemcraft.gu_ibhmg.tooltip_sseque_ren_xuan_ze1"), mouseX, mouseY);
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 141 && mouseX < leftPos + 157 && mouseY > topPos + 53 && mouseY < topPos + 69) {
			guiGraphics.renderTooltip(font, Component.translatable("gui.primogemcraft.gu_ibhmg.tooltip_sseque_ren_xuan_ze2"), mouseX, mouseY);
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 3 && mouseX < leftPos + 37 && mouseY > topPos + 6 && mouseY < topPos + 14) {
			guiGraphics.renderTooltip(font, Component.translatable("gui.primogemcraft.gu_ibhmg.tooltip_sscqiang_zhi_tui_chu_jie_mian_hui_sui_ji_xuan_ze_ge_qi_wu"), mouseX, mouseY);
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 13 && mouseX < leftPos + 22 && mouseY > topPos + 20 && mouseY < topPos + 29) {
			guiGraphics.renderTooltip(font, Component.translatable("gui.primogemcraft.gu_ibhmg.tooltip_sscsslbu_huo_ming_guang_jin_ke_xuan_ze_ge_wu_pin_zuo_wei_zi_xuan_dui_xiang"), mouseX, mouseY);
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 13 && mouseX < leftPos + 22 && mouseY > topPos + 31 && mouseY < topPos + 40) {
			guiGraphics.renderTooltip(font, Component.translatable("gui.primogemcraft.gu_ibhmg.tooltip_sscsslfang_qi_bu_huo_ming_guang_wei_ke_xuan_xiang"), mouseX, mouseY);
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 13 && mouseX < leftPos + 34 && mouseY > topPos + 49 && mouseY < topPos + 70) {
			guiGraphics.renderTooltip(font, Component.translatable("gui.primogemcraft.gu_ibhmg.tooltip_fang_qi_bu_huo_ming_guang_li_ji_sheng_cheng_ci_chang_gui_chu_jin_zhan_li_pin"), mouseX, mouseY);
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
		guiGraphics.blit(ResourceLocation.parse("primogemcraft:textures/screens/xuzhi.png"), this.leftPos + 6, this.topPos + 20, 0, 0, 16, 16, 16, 16);
		guiGraphics.blit(ResourceLocation.parse("primogemcraft:textures/screens/xuzhi_hong.png"), this.leftPos + 13, this.topPos + 31, 0, 0, 9, 9, 9, 9);
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
		guiGraphics.drawString(this.font, Component.translatable("gui.primogemcraft.gu_ibhmg.label_xuan_ze_ge_qi_wu"), 5, 5, -1, false);
	}

	@Override
	public void init() {
		super.init();
		imagebutton_xuanze0 = new ImageButton(this.leftPos + 59, this.topPos + 53, 16, 16, new WidgetSprites(ResourceLocation.parse("primogemcraft:textures/screens/xuanze0.png"), ResourceLocation.parse("primogemcraft:textures/screens/xuanze1.png")),
				e -> {
					int x = GUIbhmgScreen.this.x;
					int y = GUIbhmgScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new GUIbhmgButtonMessage(0, x, y, z));
						GUIbhmgButtonMessage.handleButtonAction(entity, 0, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_xuanze0);
		imagebutton_xuanze01 = new ImageButton(this.leftPos + 99, this.topPos + 53, 16, 16, new WidgetSprites(ResourceLocation.parse("primogemcraft:textures/screens/xuanze0.png"), ResourceLocation.parse("primogemcraft:textures/screens/xuanze1.png")),
				e -> {
					int x = GUIbhmgScreen.this.x;
					int y = GUIbhmgScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new GUIbhmgButtonMessage(1, x, y, z));
						GUIbhmgButtonMessage.handleButtonAction(entity, 1, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_xuanze01);
		imagebutton_xuanze02 = new ImageButton(this.leftPos + 141, this.topPos + 53, 16, 16,
				new WidgetSprites(ResourceLocation.parse("primogemcraft:textures/screens/xuanze0.png"), ResourceLocation.parse("primogemcraft:textures/screens/xuanze1.png")), e -> {
					int x = GUIbhmgScreen.this.x;
					int y = GUIbhmgScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new GUIbhmgButtonMessage(2, x, y, z));
						GUIbhmgButtonMessage.handleButtonAction(entity, 2, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_xuanze02);
		imagebutton_cuoa1 = new ImageButton(this.leftPos + 13, this.topPos + 49, 21, 21, new WidgetSprites(ResourceLocation.parse("primogemcraft:textures/screens/cuoa1.png"), ResourceLocation.parse("primogemcraft:textures/screens/cuoa2.png")), e -> {
			int x = GUIbhmgScreen.this.x;
			int y = GUIbhmgScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new GUIbhmgButtonMessage(3, x, y, z));
				GUIbhmgButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_cuoa1);
	}
}