package net.mcreator.ceshi.client.gui;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.ceshi.world.inventory.GUIhyzhqMenu;
import net.mcreator.ceshi.procedures.GUIhyzhqsxProcedure;
import net.mcreator.ceshi.init.PrimogemcraftModScreens;

import java.util.Objects;
import java.util.stream.Collectors;
import java.util.Arrays;

import com.mojang.blaze3d.systems.RenderSystem;

public class GUIhyzhqScreen extends AbstractContainerScreen<GUIhyzhqMenu> implements PrimogemcraftModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	private double smoothBlockNBT = 0.0;

	public GUIhyzhqScreen(GUIhyzhqMenu container, Inventory inventory, Component text) {
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

	private static final ResourceLocation texture = ResourceLocation.parse("primogemcraft:textures/screens/gu_ihyzhq.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		boolean customTooltipShown = false;
		if (mouseX > leftPos + 7 && mouseX < leftPos + 39 && mouseY > topPos + 9 && mouseY < topPos + 57) {
			String hoverText = GUIhyzhqsxProcedure.execute(world, x, y, z);
			if (hoverText != null) {
				guiGraphics.renderComponentTooltip(font, Arrays.stream(hoverText.split("\n")).map(Component::literal).collect(Collectors.toList()), mouseX, mouseY);
			}
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

		guiGraphics.blit(ResourceLocation.parse("primogemcraft:textures/screens/jindutiao.png"), this.leftPos + 7, this.topPos + 9, 0, 0, 32, 48, 32, 48);
		double blockNBT = Objects.requireNonNull(world.getBlockEntity(BlockPos.containing(x, y, z))).getPersistentData().getDouble("shan_bian");
		if (smoothBlockNBT == 0) smoothBlockNBT = blockNBT;
		smoothBlockNBT = Math.max(0, Math.min(smoothBlockNBT + (blockNBT - smoothBlockNBT) * 0.09, 330));
		guiGraphics.blit(ResourceLocation.parse("primogemcraft:textures/screens/jindutiao2.png"), this.leftPos + 11, this.topPos + 13, 0.0f, 0.0f, 24, (int)Math.round(40 * (1 - smoothBlockNBT / 330)), 24, 1);

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
	}

	@Override
	public void init() {
		super.init();
	}
}