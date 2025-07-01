package net.mcreator.ceshi.procedures;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.BlockTags;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.BlockPos;

import net.mcreator.ceshi.init.PrimogemcraftModItems;

public class YskstcqsxProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		double xa = 0;
		double ya = 0;
		double za = 0;
		BlockState a = Blocks.AIR.defaultBlockState();
		if (entity.isShiftKeyDown()) {
			if (itemstack.getItem() == PrimogemcraftModItems.MLLP.get()) {
				if ((world.getBlockState(BlockPos.containing(x, y - 1, z))).is(BlockTags.create(ResourceLocation.parse("pgc:ketance")))) {
					{
						final String _tagName = "fnagkuai";
						final String _tagValue = (BuiltInRegistries.BLOCK.getKey((world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock()).toString());
						CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putString(_tagName, _tagValue));
					}
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal(("\u00A7d\u5DF2\u5C06\u00A7f"
								+ (new ItemStack(BuiltInRegistries.BLOCK.get(ResourceLocation.parse(((itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("fnagkuai"))).toLowerCase(java.util.Locale.ENGLISH)))))
										.getDisplayName().getString()
								+ "\u00A7d\u8BBE\u7F6E\u4E3A\u5BFB\u627E\u76EE\u6807")), false);
				} else {
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("\u00A7c\u53EA\u80FD\u63A2\u6D4B\u5143\u7D20\u6676\u4F53\u77FF\u77F3\uFF01"), false);
				}
			} else {
				if ((world.getBlockState(BlockPos.containing(x, y - 1, z))).is(BlockTags.create(ResourceLocation.parse("pgc:yuanbankuang")))) {
					{
						final String _tagName = "fnagkuai";
						final String _tagValue = (BuiltInRegistries.BLOCK.getKey((world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock()).toString());
						CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putString(_tagName, _tagValue));
					}
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal(("\u00A7d\u5DF2\u5C06\u00A7f"
								+ (new ItemStack(BuiltInRegistries.BLOCK.get(ResourceLocation.parse(((itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("fnagkuai"))).toLowerCase(java.util.Locale.ENGLISH)))))
										.getDisplayName().getString()
								+ "\u00A7d\u8BBE\u7F6E\u4E3A\u5BFB\u627E\u76EE\u6807")), false);
				} else {
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("\u00A7c\u53EA\u80FD\u63A2\u6D4B\u90E8\u5206\u539F\u7248\u77FF\u77F3\uFF01"), false);
				}
			}
		} else {
			if (world instanceof ServerLevel _level) {
				itemstack.hurtAndBreak(1, _level, null, _stkprov -> {
				});
			}
			a = BuiltInRegistries.BLOCK.get(ResourceLocation.parse(((itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("fnagkuai"))).toLowerCase(java.util.Locale.ENGLISH))).defaultBlockState();
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("\u00A77\u6B63\u5728\u641C\u7D22\u9644\u8FD13*y*3\u8303\u56F4\u7684\u6307\u5B9A\u65B9\u5757"), false);
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal((new java.text.DecimalFormat("\u00A77\u5C1D\u8BD5##.\u6B21\uFF01##").format(Math.round(entity.getY() + 64)))), false);
			for (int index0 = 0; index0 < (int) (entity.getY() + 64); index0++) {
				ya = ya + 1;
				if ((world.getBlockState(BlockPos.containing(entity.getX(), entity.getY() - ya, entity.getZ()))).getBlock() == a.getBlock()
						|| (world.getBlockState(BlockPos.containing(entity.getX() + 1, entity.getY() - ya, entity.getZ() + 1))).getBlock() == a.getBlock()
						|| (world.getBlockState(BlockPos.containing(entity.getX() - 1, entity.getY() - ya, entity.getZ() - 1))).getBlock() == a.getBlock()
						|| (world.getBlockState(BlockPos.containing(entity.getX() + 1, entity.getY() - ya, entity.getZ() - 1))).getBlock() == a.getBlock()
						|| (world.getBlockState(BlockPos.containing(entity.getX() - 1, entity.getY() - ya, entity.getZ() + 1))).getBlock() == a.getBlock()
						|| (world.getBlockState(BlockPos.containing(entity.getX() - 1, entity.getY() - ya, entity.getZ()))).getBlock() == a.getBlock()
						|| (world.getBlockState(BlockPos.containing(entity.getX() + 1, entity.getY() - ya, entity.getZ()))).getBlock() == a.getBlock()
						|| (world.getBlockState(BlockPos.containing(entity.getX(), entity.getY() - ya, entity.getZ() + 1))).getBlock() == a.getBlock()
						|| (world.getBlockState(BlockPos.containing(entity.getX(), entity.getY() - ya, entity.getZ() - 1))).getBlock() == a.getBlock()) {
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal(("\u5728" + new java.text.DecimalFormat("## .##").format(Math.round(entity.getX())) + new java.text.DecimalFormat("## .##").format(Math.round(entity.getY() - ya))
								+ new java.text.DecimalFormat("## .##").format(Math.round(entity.getZ())) + "\u9644\u8FD1\u5904\u627E\u5230\u81F3\u5C11\u4E00\u4E2A\u00A7d" + ((new ItemStack(a.getBlock())).getDisplayName().getString() + "\u00A7f"))),
								false);
					break;
				}
			}
		}
	}
}