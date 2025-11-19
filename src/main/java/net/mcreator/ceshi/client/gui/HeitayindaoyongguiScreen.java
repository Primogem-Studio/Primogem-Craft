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

import net.mcreator.ceshi.world.inventory.HeitayindaoyongguiMenu;
import net.mcreator.ceshi.network.HeitayindaoyongguiButtonMessage;
import net.mcreator.ceshi.init.PrimogemcraftModScreens;

import com.mojang.blaze3d.systems.RenderSystem;

public class HeitayindaoyongguiScreen extends AbstractContainerScreen<HeitayindaoyongguiMenu> implements PrimogemcraftModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	private ImageButton imagebutton_heitaanniu;
	private ImageButton imagebutton_heitaanniu1;
	private ImageButton imagebutton_heitaanniu2;

	public HeitayindaoyongguiScreen(HeitayindaoyongguiMenu container, Inventory inventory, Component text) {
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

	private static final ResourceLocation texture = ResourceLocation.parse("primogemcraft:textures/screens/heitayindaoyonggui.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
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
		guiGraphics.drawString(this.font, Component.translatable("gui.primogemcraft.heitayindaoyonggui.label_xiao_hao_1_ge_sui_ji_cuo_wu_dai_ma_zhuang_zhi_xuan_ze_1"), 15, 16, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.primogemcraft.heitayindaoyonggui.label_xiao_hao_16_ge_yu_zhou_sui_pian_huo_de_ge_sui_ji_qi_wu"), 15, 61, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.primogemcraft.heitayindaoyonggui.label_xiao_hao_da_liang_yu_zhou_sui_pian_wei_gong_ju_huo_kui_jia_gai_lu_tian"), 15, 106, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.primogemcraft.heitayindaoyonggui.label_ge_cuo_wu_dai_ma"), 15, 25, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.primogemcraft.heitayindaoyonggui.label_jia_bao_cang_fu_mo"), 15, 115, -1, false);
	}

	@Override
	public void init() {
		super.init();
		imagebutton_heitaanniu = new ImageButton(this.leftPos + 96, this.topPos + 34, 56, 20,
				new WidgetSprites(ResourceLocation.parse("primogemcraft:textures/screens/heitaanniu.png"), ResourceLocation.parse("primogemcraft:textures/screens/heitaanniu.png")), e -> {
					int x = HeitayindaoyongguiScreen.this.x;
					int y = HeitayindaoyongguiScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new HeitayindaoyongguiButtonMessage(0, x, y, z));
						HeitayindaoyongguiButtonMessage.handleButtonAction(entity, 0, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_heitaanniu);
		imagebutton_heitaanniu1 = new ImageButton(this.leftPos + 96, this.topPos + 79, 56, 20,
				new WidgetSprites(ResourceLocation.parse("primogemcraft:textures/screens/heitaanniu.png"), ResourceLocation.parse("primogemcraft:textures/screens/heitaanniu.png")), e -> {
					int x = HeitayindaoyongguiScreen.this.x;
					int y = HeitayindaoyongguiScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new HeitayindaoyongguiButtonMessage(1, x, y, z));
						HeitayindaoyongguiButtonMessage.handleButtonAction(entity, 1, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_heitaanniu1);
		imagebutton_heitaanniu2 = new ImageButton(this.leftPos + 96, this.topPos + 124, 56, 20,
				new WidgetSprites(ResourceLocation.parse("primogemcraft:textures/screens/heitaanniu.png"), ResourceLocation.parse("primogemcraft:textures/screens/heitaanniu.png")), e -> {
					int x = HeitayindaoyongguiScreen.this.x;
					int y = HeitayindaoyongguiScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new HeitayindaoyongguiButtonMessage(2, x, y, z));
						HeitayindaoyongguiButtonMessage.handleButtonAction(entity, 2, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_heitaanniu2);
	}
}