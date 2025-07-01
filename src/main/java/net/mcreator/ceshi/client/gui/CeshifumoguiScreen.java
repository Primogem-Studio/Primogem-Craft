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

import net.mcreator.ceshi.world.inventory.CeshifumoguiMenu;
import net.mcreator.ceshi.network.CeshifumoguiButtonMessage;
import net.mcreator.ceshi.init.PrimogemcraftModScreens;

import com.mojang.blaze3d.systems.RenderSystem;

public class CeshifumoguiScreen extends AbstractContainerScreen<CeshifumoguiMenu> implements PrimogemcraftModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
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

	@Override
	public void updateMenuState(int elementType, String name, Object elementState) {
		menuStateUpdateActive = true;
		menuStateUpdateActive = false;
	}

	private static final ResourceLocation texture = ResourceLocation.parse("primogemcraft:textures/screens/ceshifumogui.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		boolean customTooltipShown = false;
		if (mouseX > leftPos + 87 && mouseX < leftPos + 169 && mouseY > topPos + 5 && mouseY < topPos + 34) {
			guiGraphics.renderTooltip(font, Component.translatable("gui.primogemcraft.ceshifumogui.tooltip_ssesuo_xu_jing_yan_zhi_jiang_bei_yu_zhou_sui_pian_di_xiao"), mouseX, mouseY);
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
		guiGraphics.drawString(this.font, Component.translatable("gui.primogemcraft.ceshifumogui.label_sui_ji_fu_mo"), 5, 3, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
		imagebutton_heitasuijifumo = new ImageButton(this.leftPos + 55, this.topPos + 59, 64, 19,
				new WidgetSprites(ResourceLocation.parse("primogemcraft:textures/screens/heitasuijifumo.png"), ResourceLocation.parse("primogemcraft:textures/screens/heitasuijifumo.png")), e -> {
					if (true) {
						PacketDistributor.sendToServer(new CeshifumoguiButtonMessage(0, x, y, z));
						CeshifumoguiButtonMessage.handleButtonAction(entity, 0, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_heitasuijifumo);
	}
}