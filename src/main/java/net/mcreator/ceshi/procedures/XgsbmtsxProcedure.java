package net.mcreator.ceshi.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

public class XgsbmtsxProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		HSsbmtsxProcedure.execute(world, x, y, z, entity, itemstack, ItemStack.EMPTY, ItemStack.EMPTY, false, true, true, true, 0.1, 0, 60, "loot spawn ~ ~ ~ loot primogemcraft:entities/qqiwuzhanlipinshiti");
		itemstack.shrink(1);
		if (world instanceof ServerLevel _level)
			_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
					"loot spawn ~ ~ ~ loot primogemcraft:entities/qqiwuzhanlipinshiti");
	}
}