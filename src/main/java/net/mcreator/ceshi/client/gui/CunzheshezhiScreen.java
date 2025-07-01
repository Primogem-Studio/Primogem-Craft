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
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.Minecraft;

import net.mcreator.ceshi.world.inventory.CunzheshezhiMenu;
import net.mcreator.ceshi.network.CunzheshezhiButtonMessage;
import net.mcreator.ceshi.init.PrimogemcraftModScreens;

import com.mojang.blaze3d.systems.RenderSystem;

public class CunzheshezhiScreen extends AbstractContainerScreen<CunzheshezhiMenu> implements PrimogemcraftModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	EditBox cunzhe_shuliang;
	Button button_10;
	Button button_100;
	Button button_1000;
	Button button_11;
	Button button_101;
	Button button_1001;
	ImageButton imagebutton_dui;
	ImageButton imagebutton_cuo;

	public CunzheshezhiScreen(CunzheshezhiMenu container, Inventory inventory, Component text) {
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
		if (elementType == 0 && elementState instanceof String stringState) {
			if (name.equals("cunzhe_shuliang"))
				cunzhe_shuliang.setValue(stringState);
		}
		menuStateUpdateActive = false;
	}

	private static final ResourceLocation texture = ResourceLocation.parse("primogemcraft:textures/screens/cunzheshezhi.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		cunzhe_shuliang.render(guiGraphics, mouseX, mouseY, partialTicks);
		boolean customTooltipShown = false;
		if (mouseX > leftPos + 66 && mouseX < leftPos + 111 && mouseY > topPos + 14 && mouseY < topPos + 32) {
			guiGraphics.renderTooltip(font, Component.translatable("gui.primogemcraft.cunzheshezhi.tooltip_cong_xia_fang_an_niu_shu_ru"), mouseX, mouseY);
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 62 && mouseX < leftPos + 86 && mouseY > topPos + 57 && mouseY < topPos + 81) {
			guiGraphics.renderTooltip(font, Component.translatable("gui.primogemcraft.cunzheshezhi.tooltip_dian_ci_huo_qu_bu_wen_ding_ban_ben"), mouseX, mouseY);
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 96 && mouseX < leftPos + 120 && mouseY > topPos + 57 && mouseY < topPos + 81) {
			guiGraphics.renderTooltip(font, Component.translatable("gui.primogemcraft.cunzheshezhi.tooltip_huo_qu"), mouseX, mouseY);
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
		if (cunzhe_shuliang.isFocused())
			return cunzhe_shuliang.keyPressed(key, b, c);
		return super.keyPressed(key, b, c);
	}

	@Override
	public void resize(Minecraft minecraft, int width, int height) {
		String cunzhe_shuliangValue = cunzhe_shuliang.getValue();
		super.resize(minecraft, width, height);
		cunzhe_shuliang.setValue(cunzhe_shuliangValue);
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		guiGraphics.drawString(this.font, Component.translatable("gui.primogemcraft.cunzheshezhi.label_empty"), 89, 41, -10066330, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.primogemcraft.cunzheshezhi.label_empty1"), 80, 41, -10066330, false);
	}

	@Override
	public void init() {
		super.init();
		cunzhe_shuliang = new EditBox(this.font, this.leftPos + 65, this.topPos + 14, 45, 18, Component.translatable("gui.primogemcraft.cunzheshezhi.cunzhe_shuliang"));
		cunzhe_shuliang.setMaxLength(8192);
		cunzhe_shuliang.setResponder(content -> {
			if (!menuStateUpdateActive)
				menu.sendMenuStateUpdate(entity, 0, "cunzhe_shuliang", content, false);
		});
		cunzhe_shuliang.setHint(Component.translatable("gui.primogemcraft.cunzheshezhi.cunzhe_shuliang"));
		this.addWidget(this.cunzhe_shuliang);
		button_10 = Button.builder(Component.translatable("gui.primogemcraft.cunzheshezhi.button_10"), e -> {
			if (true) {
				PacketDistributor.sendToServer(new CunzheshezhiButtonMessage(0, x, y, z));
				CunzheshezhiButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 97, this.topPos + 35, 14, 20).build();
		this.addRenderableWidget(button_10);
		button_100 = Button.builder(Component.translatable("gui.primogemcraft.cunzheshezhi.button_100"), e -> {
			if (true) {
				PacketDistributor.sendToServer(new CunzheshezhiButtonMessage(1, x, y, z));
				CunzheshezhiButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}).bounds(this.leftPos + 113, this.topPos + 35, 17, 20).build();
		this.addRenderableWidget(button_100);
		button_1000 = Button.builder(Component.translatable("gui.primogemcraft.cunzheshezhi.button_1000"), e -> {
			if (true) {
				PacketDistributor.sendToServer(new CunzheshezhiButtonMessage(2, x, y, z));
				CunzheshezhiButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		}).bounds(this.leftPos + 132, this.topPos + 35, 23, 20).build();
		this.addRenderableWidget(button_1000);
		button_11 = Button.builder(Component.translatable("gui.primogemcraft.cunzheshezhi.button_11"), e -> {
			if (true) {
				PacketDistributor.sendToServer(new CunzheshezhiButtonMessage(3, x, y, z));
				CunzheshezhiButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		}).bounds(this.leftPos + 66, this.topPos + 35, 13, 20).build();
		this.addRenderableWidget(button_11);
		button_101 = Button.builder(Component.translatable("gui.primogemcraft.cunzheshezhi.button_101"), e -> {
			if (true) {
				PacketDistributor.sendToServer(new CunzheshezhiButtonMessage(4, x, y, z));
				CunzheshezhiButtonMessage.handleButtonAction(entity, 4, x, y, z);
			}
		}).bounds(this.leftPos + 47, this.topPos + 35, 16, 20).build();
		this.addRenderableWidget(button_101);
		button_1001 = Button.builder(Component.translatable("gui.primogemcraft.cunzheshezhi.button_1001"), e -> {
			if (true) {
				PacketDistributor.sendToServer(new CunzheshezhiButtonMessage(5, x, y, z));
				CunzheshezhiButtonMessage.handleButtonAction(entity, 5, x, y, z);
			}
		}).bounds(this.leftPos + 21, this.topPos + 35, 23, 20).build();
		this.addRenderableWidget(button_1001);
		imagebutton_dui = new ImageButton(this.leftPos + 96, this.topPos + 57, 21, 21, new WidgetSprites(ResourceLocation.parse("primogemcraft:textures/screens/duia1.png"), ResourceLocation.parse("primogemcraft:textures/screens/duia2.png")), e -> {
			if (true) {
				PacketDistributor.sendToServer(new CunzheshezhiButtonMessage(6, x, y, z));
				CunzheshezhiButtonMessage.handleButtonAction(entity, 6, x, y, z);
			}
		}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_dui);
		imagebutton_cuo = new ImageButton(this.leftPos + 62, this.topPos + 57, 21, 21, new WidgetSprites(ResourceLocation.parse("primogemcraft:textures/screens/cuoa1.png"), ResourceLocation.parse("primogemcraft:textures/screens/cuoa2.png")), e -> {
			if (true) {
				PacketDistributor.sendToServer(new CunzheshezhiButtonMessage(7, x, y, z));
				CunzheshezhiButtonMessage.handleButtonAction(entity, 7, x, y, z);
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