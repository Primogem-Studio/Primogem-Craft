package net.mcreator.ceshi.item;

import net.neoforged.neoforge.registries.RegisterEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.Holder;
import net.minecraft.Util;

import net.mcreator.ceshi.procedures.Axtsx4Procedure;
import net.mcreator.ceshi.procedures.Axtsx3Procedure;
import net.mcreator.ceshi.procedures.Axtsx2Procedure;
import net.mcreator.ceshi.procedures.Axtsx1Procedure;
import net.mcreator.ceshi.init.PrimogemcraftModItems;

import java.util.List;
import java.util.EnumMap;

import com.google.common.collect.Iterables;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public abstract class AxhjtItem extends ArmorItem {
	public static Holder<ArmorMaterial> ARMOR_MATERIAL = null;

	@SubscribeEvent
	public static void registerArmorMaterial(RegisterEvent event) {
		event.register(Registries.ARMOR_MATERIAL, registerHelper -> {
			ArmorMaterial armorMaterial = new ArmorMaterial(Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
				map.put(ArmorItem.Type.BOOTS, 4);
				map.put(ArmorItem.Type.LEGGINGS, 7);
				map.put(ArmorItem.Type.CHESTPLATE, 8);
				map.put(ArmorItem.Type.HELMET, 4);
				map.put(ArmorItem.Type.BODY, 8);
			}), 15, DeferredHolder.create(Registries.SOUND_EVENT, ResourceLocation.parse("item.armor.equip_netherite")), () -> Ingredient.of(new ItemStack(PrimogemcraftModItems.AAIXUBINGYUDUANPIAN.get()), new ItemStack(Items.DIAMOND)),
					List.of(new ArmorMaterial.Layer(ResourceLocation.parse("primogemcraft:axhjt_"))), 2f, 0.2f);
			registerHelper.register(ResourceLocation.parse("primogemcraft:axhjt"), armorMaterial);
			ARMOR_MATERIAL = BuiltInRegistries.ARMOR_MATERIAL.wrapAsHolder(armorMaterial);
		});
	}

	public AxhjtItem(ArmorItem.Type type, Item.Properties properties) {
		super(ARMOR_MATERIAL, type, properties);
	}

	public static class Helmet extends AxhjtItem {
		public Helmet() {
			super(ArmorItem.Type.HELMET, new Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(200)).fireResistant());
		}

		@Override
		@OnlyIn(Dist.CLIENT)
		public void appendHoverText(ItemStack itemstack, Item.TooltipContext context, List<Component> list, TooltipFlag flag) {
			super.appendHoverText(itemstack, context, list, flag);
			list.add(Component.translatable("item.primogemcraft.axhjt_helmet.description_0"));
			list.add(Component.translatable("item.primogemcraft.axhjt_helmet.description_1"));
			list.add(Component.translatable("item.primogemcraft.axhjt_helmet.description_2"));
			list.add(Component.translatable("item.primogemcraft.axhjt_helmet.description_3"));
			list.add(Component.translatable("item.primogemcraft.axhjt_helmet.description_4"));
			list.add(Component.translatable("item.primogemcraft.axhjt_helmet.description_5"));
			list.add(Component.translatable("item.primogemcraft.axhjt_helmet.description_6"));
		}

		@Override
		public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
			super.inventoryTick(itemstack, world, entity, slot, selected);
			if (entity instanceof Player player && Iterables.contains(player.getArmorSlots(), itemstack)) {
				Axtsx1Procedure.execute(entity, itemstack);
			}
		}
	}

	public static class Chestplate extends AxhjtItem {
		public Chestplate() {
			super(ArmorItem.Type.CHESTPLATE, new Item.Properties().durability(ArmorItem.Type.CHESTPLATE.getDurability(200)).fireResistant());
		}

		@Override
		@OnlyIn(Dist.CLIENT)
		public void appendHoverText(ItemStack itemstack, Item.TooltipContext context, List<Component> list, TooltipFlag flag) {
			super.appendHoverText(itemstack, context, list, flag);
			list.add(Component.translatable("item.primogemcraft.axhjt_chestplate.description_0"));
			list.add(Component.translatable("item.primogemcraft.axhjt_chestplate.description_1"));
			list.add(Component.translatable("item.primogemcraft.axhjt_chestplate.description_2"));
			list.add(Component.translatable("item.primogemcraft.axhjt_chestplate.description_3"));
			list.add(Component.translatable("item.primogemcraft.axhjt_chestplate.description_4"));
			list.add(Component.translatable("item.primogemcraft.axhjt_chestplate.description_5"));
			list.add(Component.translatable("item.primogemcraft.axhjt_chestplate.description_6"));
		}

		@Override
		public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
			super.inventoryTick(itemstack, world, entity, slot, selected);
			if (entity instanceof Player player && Iterables.contains(player.getArmorSlots(), itemstack)) {
				Axtsx2Procedure.execute(entity, itemstack);
			}
		}
	}

	public static class Leggings extends AxhjtItem {
		public Leggings() {
			super(ArmorItem.Type.LEGGINGS, new Item.Properties().durability(ArmorItem.Type.LEGGINGS.getDurability(200)).fireResistant());
		}

		@Override
		@OnlyIn(Dist.CLIENT)
		public void appendHoverText(ItemStack itemstack, Item.TooltipContext context, List<Component> list, TooltipFlag flag) {
			super.appendHoverText(itemstack, context, list, flag);
			list.add(Component.translatable("item.primogemcraft.axhjt_leggings.description_0"));
			list.add(Component.translatable("item.primogemcraft.axhjt_leggings.description_1"));
			list.add(Component.translatable("item.primogemcraft.axhjt_leggings.description_2"));
			list.add(Component.translatable("item.primogemcraft.axhjt_leggings.description_3"));
			list.add(Component.translatable("item.primogemcraft.axhjt_leggings.description_4"));
			list.add(Component.translatable("item.primogemcraft.axhjt_leggings.description_5"));
			list.add(Component.translatable("item.primogemcraft.axhjt_leggings.description_6"));
		}

		@Override
		public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
			super.inventoryTick(itemstack, world, entity, slot, selected);
			if (entity instanceof Player player && Iterables.contains(player.getArmorSlots(), itemstack)) {
				Axtsx3Procedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), entity, itemstack);
			}
		}
	}

	public static class Boots extends AxhjtItem {
		public Boots() {
			super(ArmorItem.Type.BOOTS, new Item.Properties().durability(ArmorItem.Type.BOOTS.getDurability(200)).fireResistant());
		}

		@Override
		@OnlyIn(Dist.CLIENT)
		public void appendHoverText(ItemStack itemstack, Item.TooltipContext context, List<Component> list, TooltipFlag flag) {
			super.appendHoverText(itemstack, context, list, flag);
			list.add(Component.translatable("item.primogemcraft.axhjt_boots.description_0"));
			list.add(Component.translatable("item.primogemcraft.axhjt_boots.description_1"));
			list.add(Component.translatable("item.primogemcraft.axhjt_boots.description_2"));
			list.add(Component.translatable("item.primogemcraft.axhjt_boots.description_3"));
			list.add(Component.translatable("item.primogemcraft.axhjt_boots.description_4"));
			list.add(Component.translatable("item.primogemcraft.axhjt_boots.description_5"));
			list.add(Component.translatable("item.primogemcraft.axhjt_boots.description_6"));
		}

		@Override
		public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
			super.inventoryTick(itemstack, world, entity, slot, selected);
			if (entity instanceof Player player && Iterables.contains(player.getArmorSlots(), itemstack)) {
				Axtsx4Procedure.execute(entity, itemstack);
			}
		}
	}
}