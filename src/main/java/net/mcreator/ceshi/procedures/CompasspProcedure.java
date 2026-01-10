package net.mcreator.ceshi.procedures;

import net.minecraft.core.BlockPos;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.state.BlockState;

import java.util.Objects;

public class CompasspProcedure {
    public static void execute(LevelAccessor world, Player player, ItemStack itemstack, String tag, int radius) {
        if (world.isClientSide()) return;
        if (player.isShiftKeyDown()) {
            blockTag(world, player, itemstack, tag);
        } else {
            player.getCooldowns().addCooldown(itemstack.getItem(), 20);
            traverseBlock(world, player, radius, BuiltInRegistries.BLOCK.get(ResourceLocation.parse(((itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("fnagkuai"))).toLowerCase(java.util.Locale.ENGLISH))).defaultBlockState());
        }
    }

    private static void blockTag(LevelAccessor world, Player player, ItemStack itemstack, String tags) {
        BlockState b = (world.getBlockState(BlockPos.containing(player.getX(), player.getY() - 1, player.getZ())));
        if (Objects.equals(tags, "")) {block(player, b, itemstack);return;}
        if (b.is(BlockTags.create(ResourceLocation.parse(tags)))) {
            block(player, b, itemstack);
        } else {
            player.displayClientMessage(Component.literal("§c只能探测特定方块！"), false);
        }
    }

    public static void traverseBlock(LevelAccessor world, Player player, int radius, BlockState b) {
        if (world.isClientSide()) return;
        double playerX = player.getX();
        double playerY = player.getY();
        double playerZ = player.getZ();
        player.displayClientMessage(Component.literal("正在搜索指定范围方块..."), true);
        for (int dx = -radius; dx <= radius; dx++) {
            for (int dz = -radius; dz <= radius; dz++) {
                for (int y = (int) playerY; y >= -64; y--) {
                    int currentX = (int) playerX + dx;
                    int currentZ = (int) playerZ + dz;
                    if ((world.getBlockState(BlockPos.containing(currentX, y, currentZ))).getBlock() == b.getBlock()) {
                        player.displayClientMessage(Component.literal(("在" + "§bX§f" + currentX + " " + "§bY§f" + y + " " + "§bZ§f" + currentZ + "找到一个§d" + ((new ItemStack(b.getBlock())).getDisplayName().getString()))), false);
                    }
                }
            }
        }
    }

    private static void block(Player player, BlockState b, ItemStack itemstack) {
        {
            final String _tagName = "fnagkuai";
            final String _tagValue = (BuiltInRegistries.ITEM.getKey((new ItemStack(b.getBlock())).getItem()).toString());
            CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putString(_tagName, _tagValue));
        }

        player.displayClientMessage(Component.literal(("§d已将§f" + (new ItemStack(BuiltInRegistries.BLOCK.get(ResourceLocation.parse(((itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("fnagkuai"))).toLowerCase(java.util.Locale.ENGLISH))))).getDisplayName().getString() + "§d设置为寻找目标")), true);
    }
}