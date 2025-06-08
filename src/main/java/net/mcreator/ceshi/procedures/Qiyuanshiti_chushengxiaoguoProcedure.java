package net.mcreator.ceshi.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.AdvancementHolder;

import net.mcreator.ceshi.network.PrimogemcraftModVariables;
import net.mcreator.ceshi.init.PrimogemcraftModMobEffects;
import net.mcreator.ceshi.init.PrimogemcraftModGameRules;
import net.mcreator.ceshi.init.PrimogemcraftModEntities;
import net.mcreator.ceshi.entity.QqiyuanJinGuangEntity;
import net.mcreator.ceshi.entity.QQyuanchuzi01Entity;
import net.mcreator.ceshi.entity.QQQyuanchulan01Entity;
import net.mcreator.ceshi.PrimogemcraftMod;

import java.util.Comparator;

public class Qiyuanshiti_chushengxiaoguoProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		boolean o1 = false;
		double a = 0;
		double b = 0;
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(PrimogemcraftModMobEffects.DJQJKJXGXIANZHI, (int) (entity instanceof QQQyuanchulan01Entity ? 40 : 20), 0, false, false));
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 1200, 5, false, false));
		if (!world.isClientSide()) {
			if (entity instanceof QQQyuanchulan01Entity) {
				{
					final Vec3 _center = new Vec3(x, (y - 10), z);
					for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(40 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
						if (entityiterator.getPersistentData().getDouble("chouka") > 0) {
							PrimogemcraftModVariables.PlayerVariables _vars = entityiterator.getData(PrimogemcraftModVariables.PLAYER_VARIABLES);
							a = QyYoHuaProcedure.execute(entityiterator, 0.01, 0.03, 10);
							b = QyYoHuaProcedure.execute(entityiterator, 0.1, 0.2, 5);
							if (Math.random() < a || _vars.jin_baodi >= 49) {
								_vars.jin_baodi = 0;
								if (!entity.level().isClientSide())
									entity.discard();
								if (world instanceof ServerLevel _level) {
									Entity entityToSpawn = PrimogemcraftModEntities.QQIYUAN_JIN_GUANG.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
									if (entityToSpawn != null) {
										entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
									}
								}
								_vars.wj_ck_jin++;
								_vars.zi_baodi++;
								entityiterator.getPersistentData().putBoolean("xiangyu", false);
							} else if (Math.random() < b || _vars.zi_baodi >= 9) {
								if (!entity.level().isClientSide())
									entity.discard();
								if (world instanceof ServerLevel _level) {
									Entity entityToSpawn = PrimogemcraftModEntities.Q_QYUANCHUZI_01.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
									if (entityToSpawn != null) {
										entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
									}
								}
								_vars.wj_ck_zi++;
								if (!entityiterator.getPersistentData().getBoolean("xiangyu")) {
									_vars.jin_baodi++;
								}
								_vars.zi_baodi = 0;
								entityiterator.getPersistentData().putBoolean("xiangyu", false);
							} else {
								_vars.wj_ck_lan++;
								if (!entityiterator.getPersistentData().getBoolean("xiangyu")) {
									_vars.jin_baodi++;
								}
								_vars.zi_baodi++;
								QyNBTProcedure.execute(entityiterator, entity, true, "0");
								entityiterator.getPersistentData().putBoolean("xiangyu", false);
							}
							_vars.syncPlayerVariables(entityiterator);
						} else {
							entityiterator.getPersistentData().putBoolean("chouka", false);
						}
					}
				}
			}
			if (entity instanceof QQyuanchuzi01Entity) {
				{
					final Vec3 _center = new Vec3(x, (y - 10), z);
					for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(40 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
						if (entityiterator.getPersistentData().getBoolean("chouka")) {
							QyNBTProcedure.execute(entityiterator, entity, true, "1");
							Scmjsx0Procedure.execute(entityiterator, entity);
						}
					}
				}
			}
			if (entity instanceof QqiyuanJinGuangEntity) {
				{
					final Vec3 _center = new Vec3(x, (y - 10), z);
					for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(40 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
						var n1 = entityiterator.getPersistentData();
						var n2 = n1.getBoolean("baodi_shoudong");
						if (n1.getBoolean("chouka") || n2) {
							if (n2) {
								n1.putBoolean("baodi_shoudong", false);
								QyNBTProcedure.execute(entityiterator, entity, false, "2");
							} else {
								QyNBTProcedure.execute(entityiterator, entity, true, "2");
							}
							Scmjsx0Procedure.execute(entityiterator, entity);
						}
					}
				}
			}
			if (entity instanceof QqiyuanJinGuangEntity) {
				if (Math.random() < (world.getLevelData().getGameRules().getInt(PrimogemcraftModGameRules.GUIZEBUHUOMINGGUANGZHI)) * 0.01) {
					o1 = true;
					PrimogemcraftMod.queueServerWork(20, () -> {
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("primogemcraft:bhmg_y")), SoundSource.NEUTRAL, 4, 1);
							} else {
								_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("primogemcraft:bhmg_y")), SoundSource.NEUTRAL, 4, 1, false);
							}
						}
					});
				}
			}
		}
		if (o1) {
			PrimogemcraftMod.queueServerWork(40, () -> {
				if (entity instanceof QqiyuanJinGuangEntity _datEntSetL)
					_datEntSetL.getEntityData().set(QqiyuanJinGuangEntity.DATA_bhmg, true);
				entity.getPersistentData().putBoolean("lizi", true);
				{
					final Vec3 _center = new Vec3(x, (y - 10), z);
					for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(40 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
						if ((entity.getPersistentData().getString("qiyuan_guishu")).equals(entityiterator.getDisplayName().getString()) && !(entityiterator instanceof ServerPlayer _plr30 && _plr30.level() instanceof ServerLevel
								&& _plr30.getAdvancements().getOrStartProgress(_plr30.server.getAdvancements().get(ResourceLocation.parse("primogemcraft:bhmg"))).isDone())) {
							if (entityiterator instanceof ServerPlayer _player) {
								AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("primogemcraft:bhmg"));
								if (_adv != null) {
									AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
									if (!_ap.isDone()) {
										for (String criteria : _ap.getRemainingCriteria())
											_player.getAdvancements().award(_adv, criteria);
									}
								}
							}
						}
					}
				}
			});
		}
	}
}
