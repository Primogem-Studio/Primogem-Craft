package net.mcreator.ceshi.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.ceshi.init.PrimogemcraftModItems;

public class QwhydltsxProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		ItemStack a = ItemStack.EMPTY;
		if (world instanceof Level _level) {
			if (!_level.isClientSide()) {
				_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("primogemcraft:zhapian")), SoundSource.PLAYERS, 1, 1);
			} else {
				_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("primogemcraft:zhapian")), SoundSource.PLAYERS, 1, 1, false);
			}
		}
		if (world instanceof ServerLevel _level)
			_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
					"/summon minecraft:firework_rocket ~3 ~1 ~ {CustomName:\"[{\\\"text\\\":\\\"\\\",\\\"bold\\\":false,\\\"italic\\\":false,\\\"underlined\\\":false,\\\"strikethrough\\\":false,\\\"obfuscated\\\":false}]\",FireworksItem:{tag:{Fireworks:{Flight:40,Explosions:[{Flicker:1b,Type:1,Colors:[I;15882071],FadeColors:[I;3438841]},{Flicker:1b,Type:2,Colors:[I;16773394],FadeColors:[I;5701425]}]}},id:\"minecraft:firework_rocket\",Count:1},Life:40,LifeTime:60}");
		if (world instanceof ServerLevel _level)
			_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
					"/summon minecraft:firework_rocket ~ ~1 ~5 {CustomName:\"[{\\\"text\\\":\\\"\\\",\\\"bold\\\":false,\\\"italic\\\":false,\\\"underlined\\\":false,\\\"strikethrough\\\":false,\\\"obfuscated\\\":false}]\",FireworksItem:{tag:{Fireworks:{Flight:20,Explosions:[{Trail:1b,Flicker:1b,Type:4,Colors:[I;14873175],FadeColors:[I;3471673]},{Flicker:1b,Type:2,Colors:[I;16730642],FadeColors:[I;16009471]}]}},id:\"minecraft:firework_rocket\",Count:1},Life:30,LifeTime:50}");
		if (world instanceof ServerLevel _level)
			_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
					"/summon minecraft:firework_rocket ~-4 ~1 ~ {CustomName:\"[{\\\"text\\\":\\\"\\\",\\\"bold\\\":false,\\\"italic\\\":false,\\\"underlined\\\":false,\\\"strikethrough\\\":false,\\\"obfuscated\\\":false}]\",FireworksItem:{tag:{Fireworks:{Flight:20,Explosions:[{Trail:1b,Type:1,Colors:[I;15095794],FadeColors:[I;16331918]},{Flicker:1b,Type:3,Colors:[I;2757375],FadeColors:[I;4784112]}]}},id:\"minecraft:firework_rocket\",Count:1},Life:30,LifeTime:50}");
		a = new ItemStack(PrimogemcraftModItems.YHDLTYIDIE.get());
		{
			final String _tagName = "shuliang";
			final double _tagValue = (Mth.nextInt(RandomSource.create(), 5, 9));
			CustomData.update(DataComponents.CUSTOM_DATA, a, tag -> tag.putDouble(_tagName, _tagValue));
		}
		if (world instanceof ServerLevel _level) {
			ItemEntity entityToSpawn = new ItemEntity(_level, (entity.getX()), (entity.getY()), (entity.getZ()), a);
			entityToSpawn.setPickUpDelay(0);
			_level.addFreshEntity(entityToSpawn);
		}
	}
}