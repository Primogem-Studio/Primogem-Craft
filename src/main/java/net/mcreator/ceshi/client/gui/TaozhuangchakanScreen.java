package net.mcreator.ceshi.client.gui;

import net.neoforged.neoforge.network.PacketDistributor;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.Minecraft;

import net.mcreator.ceshi.world.inventory.TaozhuangchakanMenu;
import net.mcreator.ceshi.network.TaozhuangchakanButtonMessage;
import net.mcreator.ceshi.init.PrimogemcraftModScreens;

import com.mojang.blaze3d.systems.RenderSystem;

public class TaozhuangchakanScreen extends AbstractContainerScreen<TaozhuangchakanMenu> implements PrimogemcraftModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	EditBox taozhuang_0;
	EditBox taozhuang_1;
	EditBox taozhuang_2;
	EditBox taozhuang_3;
	EditBox taozhuang_4;
	EditBox taozhuang_5;
	EditBox taozhuang_6;
	Button button_shua_xin;

	public TaozhuangchakanScreen(TaozhuangchakanMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 189;
		this.imageHeight = 144;
	}

	@Override
	public void updateMenuState(int elementType, String name, Object elementState) {
		menuStateUpdateActive = true;
		if (elementType == 0 && elementState instanceof String stringState) {
			if (name.equals("taozhuang_0"))
				taozhuang_0.setValue(stringState);
			else if (name.equals("taozhuang_1"))
				taozhuang_1.setValue(stringState);
			else if (name.equals("taozhuang_2"))
				taozhuang_2.setValue(stringState);
			else if (name.equals("taozhuang_3"))
				taozhuang_3.setValue(stringState);
			else if (name.equals("taozhuang_4"))
				taozhuang_4.setValue(stringState);
			else if (name.equals("taozhuang_5"))
				taozhuang_5.setValue(stringState);
			else if (name.equals("taozhuang_6"))
				taozhuang_6.setValue(stringState);
		}
		menuStateUpdateActive = false;
	}

	private static final ResourceLocation texture = ResourceLocation.parse("primogemcraft:textures/screens/taozhuangchakan.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		taozhuang_0.render(guiGraphics, mouseX, mouseY, partialTicks);
		taozhuang_1.render(guiGraphics, mouseX, mouseY, partialTicks);
		taozhuang_2.render(guiGraphics, mouseX, mouseY, partialTicks);
		taozhuang_3.render(guiGraphics, mouseX, mouseY, partialTicks);
		taozhuang_4.render(guiGraphics, mouseX, mouseY, partialTicks);
		taozhuang_5.render(guiGraphics, mouseX, mouseY, partialTicks);
		taozhuang_6.render(guiGraphics, mouseX, mouseY, partialTicks);
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
		if (taozhuang_0.isFocused())
			return taozhuang_0.keyPressed(key, b, c);
		if (taozhuang_1.isFocused())
			return taozhuang_1.keyPressed(key, b, c);
		if (taozhuang_2.isFocused())
			return taozhuang_2.keyPressed(key, b, c);
		if (taozhuang_3.isFocused())
			return taozhuang_3.keyPressed(key, b, c);
		if (taozhuang_4.isFocused())
			return taozhuang_4.keyPressed(key, b, c);
		if (taozhuang_5.isFocused())
			return taozhuang_5.keyPressed(key, b, c);
		if (taozhuang_6.isFocused())
			return taozhuang_6.keyPressed(key, b, c);
		return super.keyPressed(key, b, c);
	}

	@Override
	public void resize(Minecraft minecraft, int width, int height) {
		String taozhuang_0Value = taozhuang_0.getValue();
		String taozhuang_1Value = taozhuang_1.getValue();
		String taozhuang_2Value = taozhuang_2.getValue();
		String taozhuang_3Value = taozhuang_3.getValue();
		String taozhuang_4Value = taozhuang_4.getValue();
		String taozhuang_5Value = taozhuang_5.getValue();
		String taozhuang_6Value = taozhuang_6.getValue();
		super.resize(minecraft, width, height);
		taozhuang_0.setValue(taozhuang_0Value);
		taozhuang_1.setValue(taozhuang_1Value);
		taozhuang_2.setValue(taozhuang_2Value);
		taozhuang_3.setValue(taozhuang_3Value);
		taozhuang_4.setValue(taozhuang_4Value);
		taozhuang_5.setValue(taozhuang_5Value);
		taozhuang_6.setValue(taozhuang_6Value);
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		guiGraphics.drawString(this.font, Component.translatable("gui.primogemcraft.taozhuangchakan.label_feng_01"), 15, 25, -16711834, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.primogemcraft.taozhuangchakan.label_yan_01"), 69, 25, -13312, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.primogemcraft.taozhuangchakan.label_lei_01"), 123, 25, -3407617, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.primogemcraft.taozhuangchakan.label_cao_01"), 15, 52, -6684928, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.primogemcraft.taozhuangchakan.label_shui_01"), 69, 52, -10053121, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.primogemcraft.taozhuangchakan.label_huo_01"), 123, 52, -39373, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.primogemcraft.taozhuangchakan.label_bing_01"), 15, 79, -6684673, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.primogemcraft.taozhuangchakan.label_tao_zhuang_shu_zhi_jian_ce"), 6, 7, -10066330, false);
	}

	@Override
	public void init() {
		super.init();
		taozhuang_0 = new EditBox(this.font, this.leftPos + 25, this.topPos + 26, 25, 18, Component.translatable("gui.primogemcraft.taozhuangchakan.taozhuang_0"));
		taozhuang_0.setMaxLength(8192);
		taozhuang_0.setResponder(content -> {
			if (!menuStateUpdateActive)
				menu.sendMenuStateUpdate(entity, 0, "taozhuang_0", content, false);
		});
		taozhuang_0.setHint(Component.translatable("gui.primogemcraft.taozhuangchakan.taozhuang_0"));
		this.addWidget(this.taozhuang_0);
		taozhuang_1 = new EditBox(this.font, this.leftPos + 79, this.topPos + 26, 25, 18, Component.translatable("gui.primogemcraft.taozhuangchakan.taozhuang_1"));
		taozhuang_1.setMaxLength(8192);
		taozhuang_1.setResponder(content -> {
			if (!menuStateUpdateActive)
				menu.sendMenuStateUpdate(entity, 0, "taozhuang_1", content, false);
		});
		taozhuang_1.setHint(Component.translatable("gui.primogemcraft.taozhuangchakan.taozhuang_1"));
		this.addWidget(this.taozhuang_1);
		taozhuang_2 = new EditBox(this.font, this.leftPos + 133, this.topPos + 26, 25, 18, Component.translatable("gui.primogemcraft.taozhuangchakan.taozhuang_2"));
		taozhuang_2.setMaxLength(8192);
		taozhuang_2.setResponder(content -> {
			if (!menuStateUpdateActive)
				menu.sendMenuStateUpdate(entity, 0, "taozhuang_2", content, false);
		});
		taozhuang_2.setHint(Component.translatable("gui.primogemcraft.taozhuangchakan.taozhuang_2"));
		this.addWidget(this.taozhuang_2);
		taozhuang_3 = new EditBox(this.font, this.leftPos + 25, this.topPos + 53, 25, 18, Component.translatable("gui.primogemcraft.taozhuangchakan.taozhuang_3"));
		taozhuang_3.setMaxLength(8192);
		taozhuang_3.setResponder(content -> {
			if (!menuStateUpdateActive)
				menu.sendMenuStateUpdate(entity, 0, "taozhuang_3", content, false);
		});
		taozhuang_3.setHint(Component.translatable("gui.primogemcraft.taozhuangchakan.taozhuang_3"));
		this.addWidget(this.taozhuang_3);
		taozhuang_4 = new EditBox(this.font, this.leftPos + 79, this.topPos + 53, 25, 18, Component.translatable("gui.primogemcraft.taozhuangchakan.taozhuang_4"));
		taozhuang_4.setMaxLength(8192);
		taozhuang_4.setResponder(content -> {
			if (!menuStateUpdateActive)
				menu.sendMenuStateUpdate(entity, 0, "taozhuang_4", content, false);
		});
		taozhuang_4.setHint(Component.translatable("gui.primogemcraft.taozhuangchakan.taozhuang_4"));
		this.addWidget(this.taozhuang_4);
		taozhuang_5 = new EditBox(this.font, this.leftPos + 133, this.topPos + 53, 25, 18, Component.translatable("gui.primogemcraft.taozhuangchakan.taozhuang_5"));
		taozhuang_5.setMaxLength(8192);
		taozhuang_5.setResponder(content -> {
			if (!menuStateUpdateActive)
				menu.sendMenuStateUpdate(entity, 0, "taozhuang_5", content, false);
		});
		taozhuang_5.setHint(Component.translatable("gui.primogemcraft.taozhuangchakan.taozhuang_5"));
		this.addWidget(this.taozhuang_5);
		taozhuang_6 = new EditBox(this.font, this.leftPos + 25, this.topPos + 80, 25, 18, Component.translatable("gui.primogemcraft.taozhuangchakan.taozhuang_6"));
		taozhuang_6.setMaxLength(8192);
		taozhuang_6.setResponder(content -> {
			if (!menuStateUpdateActive)
				menu.sendMenuStateUpdate(entity, 0, "taozhuang_6", content, false);
		});
		taozhuang_6.setHint(Component.translatable("gui.primogemcraft.taozhuangchakan.taozhuang_6"));
		this.addWidget(this.taozhuang_6);
		button_shua_xin = Button.builder(Component.translatable("gui.primogemcraft.taozhuangchakan.button_shua_xin"), e -> {
			int x = TaozhuangchakanScreen.this.x;
			int y = TaozhuangchakanScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new TaozhuangchakanButtonMessage(0, x, y, z));
				TaozhuangchakanButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 13, this.topPos + 113, 35, 20).build();
		this.addRenderableWidget(button_shua_xin);
	}
}