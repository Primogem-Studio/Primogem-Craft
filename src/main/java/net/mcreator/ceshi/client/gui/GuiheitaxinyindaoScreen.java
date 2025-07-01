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

import net.mcreator.ceshi.world.inventory.GuiheitaxinyindaoMenu;
import net.mcreator.ceshi.procedures.GuixinheitayindaocuowufanhuiProcedure;
import net.mcreator.ceshi.procedures.GuigoumaiqiwuwenbenProcedure;
import net.mcreator.ceshi.procedures.GUIxinhtydcuowufanhuiProcedure;
import net.mcreator.ceshi.network.GuiheitaxinyindaoButtonMessage;
import net.mcreator.ceshi.init.PrimogemcraftModScreens;

import com.mojang.blaze3d.systems.RenderSystem;

public class GuiheitaxinyindaoScreen extends AbstractContainerScreen<GuiheitaxinyindaoMenu> implements PrimogemcraftModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	ImageButton imagebutton_heita_xuanzeanniu;
	ImageButton imagebutton_heita_xuanzeanniu1;
	ImageButton imagebutton_heita_xuanzeanniu2;

	public GuiheitaxinyindaoScreen(GuiheitaxinyindaoMenu container, Inventory inventory, Component text) {
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

	private static final ResourceLocation texture = ResourceLocation.parse("primogemcraft:textures/screens/guiheitaxinyindao.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		boolean customTooltipShown = false;
		if (GuixinheitayindaocuowufanhuiProcedure.execute(entity))
			if (mouseX > leftPos + 31 && mouseX < leftPos + 145 && mouseY > topPos + 13 && mouseY < topPos + 56) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.primogemcraft.guiheitaxinyindao.tooltip_sscdang_qian_mei_you_zu_gou_de_sui_ji_cuo_wu_dai_ma_qiu"), mouseX, mouseY);
				customTooltipShown = true;
			}
		if (GUIxinhtydcuowufanhuiProcedure.execute(world, entity))
			if (mouseX > leftPos + 32 && mouseX < leftPos + 145 && mouseY > topPos + 61 && mouseY < topPos + 104) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.primogemcraft.guiheitaxinyindao.tooltip_sscdang_qian_yu_zhou_sui_pian_shu_liang_bu_zu"), mouseX, mouseY);
				customTooltipShown = true;
			}
		if (!customTooltipShown)
			this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
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
		guiGraphics.drawString(this.font, Component.translatable("gui.primogemcraft.guiheitaxinyindao.label_xiao_hao_1ge_sui_ji_cuo_wu_dai_ma"), 34, 27, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.primogemcraft.guiheitaxinyindao.label_xuan_ze_ge_cuo_wu_dai_ma"), 38, 15, -5070724, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.primogemcraft.guiheitaxinyindao.label_gou_mai_ge_qi_wu"), 38, 63, -5070724, false);
		guiGraphics.drawString(this.font, GuigoumaiqiwuwenbenProcedure.execute(entity), 35, 75, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.primogemcraft.guiheitaxinyindao.label_chi_kai"), 37, 111, -5070724, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.primogemcraft.guiheitaxinyindao.label_chi_kai_zhe_li"), 36, 123, -1, false);
	}

	@Override
	public void init() {
		super.init();
		imagebutton_heita_xuanzeanniu = new ImageButton(this.leftPos + 31, this.topPos + 13, 114, 43,
				new WidgetSprites(ResourceLocation.parse("primogemcraft:textures/screens/heita_xuanzeanniu.png"), ResourceLocation.parse("primogemcraft:textures/screens/heita_xuanzeanniu0.png")), e -> {
					if (true) {
						PacketDistributor.sendToServer(new GuiheitaxinyindaoButtonMessage(0, x, y, z));
						GuiheitaxinyindaoButtonMessage.handleButtonAction(entity, 0, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_heita_xuanzeanniu);
		imagebutton_heita_xuanzeanniu1 = new ImageButton(this.leftPos + 31, this.topPos + 61, 114, 43,
				new WidgetSprites(ResourceLocation.parse("primogemcraft:textures/screens/heita_xuanzeanniu.png"), ResourceLocation.parse("primogemcraft:textures/screens/heita_xuanzeanniu0.png")), e -> {
					if (true) {
						PacketDistributor.sendToServer(new GuiheitaxinyindaoButtonMessage(1, x, y, z));
						GuiheitaxinyindaoButtonMessage.handleButtonAction(entity, 1, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_heita_xuanzeanniu1);
		imagebutton_heita_xuanzeanniu2 = new ImageButton(this.leftPos + 31, this.topPos + 109, 114, 43,
				new WidgetSprites(ResourceLocation.parse("primogemcraft:textures/screens/heita_xuanzeanniu.png"), ResourceLocation.parse("primogemcraft:textures/screens/heita_xuanzeanniu0.png")), e -> {
					if (true) {
						PacketDistributor.sendToServer(new GuiheitaxinyindaoButtonMessage(2, x, y, z));
						GuiheitaxinyindaoButtonMessage.handleButtonAction(entity, 2, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_heita_xuanzeanniu2);
	}
}