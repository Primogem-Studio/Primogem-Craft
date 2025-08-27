package net.mcreator.ceshi.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.BlockPos;

import net.mcreator.ceshi.init.PrimogemcraftModMobEffects;
import net.mcreator.ceshi.init.PrimogemcraftModItems;

public class HpysxProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		double a = 0;
		a = HSjinglianupProcedure.execute(entity, itemstack);
		if (entity.isShiftKeyDown()) {
			if (!world.isClientSide()) {
				if (!(entity instanceof LivingEntity _livEnt2 && _livEnt2.hasEffect(MobEffects.JUMP)) && net.hackermdch.pgc.Timer.isDone(entity, "hpy_t")) {
					net.hackermdch.pgc.Timer.set(entity, "hpy_t", 600);
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.JUMP, (int) (200 + 50 * a), (int) (4 + 1 * a), false, false));
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.warden.emerge")), SoundSource.PLAYERS, 1, 3);
						} else {
							_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.warden.emerge")), SoundSource.PLAYERS, 1, 3, false);
						}
					}
				}
			}
		} else {
			if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("hpy_bd_j") > 0) {
				Hpy_xg_sxProcedure.execute(world, x, y, z, entity);
				if (!world.isClientSide()) {
					{
						final String _tagName = "hpy_bd_j";
						final double _tagValue = (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("hpy_bd_j") - 1);
						CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
					}
					boolean xi = (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getItem() == PrimogemcraftModItems.SCMJ_HELMET.get();
					{
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse(xi ? "primogemcraft:xingxingxing" : "item.trident.throw")), SoundSource.PLAYERS, xi ? 5 : 1, 1);
							}
						}
					}
				}
				boolean d = entity.onGround();
				var f = (2 + 0.2 * a) * (d ? 2 : 1);
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(PrimogemcraftModMobEffects.HPYXG, (int) (d ? 10 : 6), 0, false, false));
				Vec3 lookAngle = entity.getLookAngle();
				Vec3 movement = new Vec3(lookAngle.x * f, d ? 0 : 0.2, lookAngle.z * f);
				entity.setDeltaMovement(movement);
			}
		}
	}
}