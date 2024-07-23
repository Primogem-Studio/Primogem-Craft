package net.mcreator.ceshi.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.ceshi.world.inventory.CeshifumoguiMenu;
import net.mcreator.ceshi.network.CeshifumoguiButtonMessage;
import net.mcreator.ceshi.PrimogemcraftMod;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class CeshifumoguiScreen extends AbstractContainerScreen<CeshifumoguiMenu> {
	private final static HashMap<String, Object> guistate = CeshifumoguiMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	ImageButton imagebutton_heitasuijifumo;

	public CeshifumoguiScreen(CeshifumoguiMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("primogemcraft:textures/screens/ceshifumogui.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
		if (mouseX > leftPos + 87 && mouseX < leftPos + 169 && mouseY > topPos + 5 && mouseY < topPos + 34)
			guiGraphics.renderTooltip(font, Component.translatable("gui.primogemcraft.ceshifumogui.tooltip_ssesuo_xu_jing_yan_zhi_jiang_bei_yu_zhou_sui_pian_di_xiao"), mouseX, mouseY);
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
		guiGraphics.drawString(this.font, Component.translatable("gui.primogemcraft.ceshifumogui.label_sui_ji_fu_mo"), 5, 3, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
		imagebutton_heitasuijifumo = new ImageButton(this.leftPos + 55, this.topPos + 59, 64, 19, 0, 0, 19, new ResourceLocation("primogemcraft:textures/screens/atlas/imagebutton_heitasuijifumo.png"), 64, 38, e -> {
			if (true) {
				PrimogemcraftMod.PACKET_HANDLER.sendToServer(new CeshifumoguiButtonMessage(0, x, y, z));
				CeshifumoguiButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		});
		guistate.put("button:imagebutton_heitasuijifumo", imagebutton_heitasuijifumo);
		this.addRenderableWidget(imagebutton_heitasuijifumo);
	}
}
