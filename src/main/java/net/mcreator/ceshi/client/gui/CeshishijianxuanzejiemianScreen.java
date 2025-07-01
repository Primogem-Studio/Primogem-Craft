package net.mcreator.ceshi.client.gui;

import net.neoforged.neoforge.network.PacketDistributor;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.ceshi.world.inventory.CeshishijianxuanzejiemianMenu;
import net.mcreator.ceshi.network.CeshishijianxuanzejiemianButtonMessage;
import net.mcreator.ceshi.init.PrimogemcraftModScreens;

import com.mojang.blaze3d.systems.RenderSystem;

public class CeshishijianxuanzejiemianScreen extends AbstractContainerScreen<CeshishijianxuanzejiemianMenu> implements PrimogemcraftModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	Button button_shua_xin;

	public CeshishijianxuanzejiemianScreen(CeshishijianxuanzejiemianMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 179;
		this.imageHeight = 183;
	}

	@Override
	public void updateMenuState(int elementType, String name, Object elementState) {
		menuStateUpdateActive = true;
		menuStateUpdateActive = false;
	}

	private static final ResourceLocation texture = ResourceLocation.parse("primogemcraft:textures/screens/ceshishijianxuanzejiemian.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
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
		guiGraphics.drawString(this.font, Component.translatable("gui.primogemcraft.ceshishijianxuanzejiemian.label_cuo_wu_dai_ma_zhuan_hua"), 10, 6, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
		button_shua_xin = Button.builder(Component.translatable("gui.primogemcraft.ceshishijianxuanzejiemian.button_shua_xin"), e -> {
			if (true) {
				PacketDistributor.sendToServer(new CeshishijianxuanzejiemianButtonMessage(0, x, y, z));
				CeshishijianxuanzejiemianButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 98, this.topPos + 64, 35, 20).build();
		this.addRenderableWidget(button_shua_xin);
	}
}