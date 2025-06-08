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
		//////////////////*史完了别看了不想改了头疼@PepperMO///////////////////////
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
							a = QyYoHuaProcedure.execute(entityiterator, 0.01, 0.03, 10);
							b = QyYoHuaProcedure.execute(entityiterator, 0.1, 0.2, 5);
							var QjBl = entityiterator.getData(PrimogemcraftModVariables.PLAYER_VARIABLES);
							PrimogemcraftModVariables.PlayerVariables _vars = entityiterator.getData(PrimogemcraftModVariables.PLAYER_VARIABLES);
							if (Math.random() < a || QjBl.jin_baodi >= 49) {
								_vars.jin_baodi = 0;
								if (!entity.level().isClientSide())
									entity.discard();
								if (world instanceof ServerLevel _level) {
									Entity entityToSpawn = PrimogemcraftModEntities.QQIYUAN_JIN_GUANG.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
									if (entityToSpawn != null) {
										entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
									}
								}
								_vars.wj_ck_jin = QjBl.wj_ck_jin++;
								_vars.zi_baodi = QjBl.zi_baodi++;
								entityiterator.getPersistentData().putBoolean("xiangyu", false);
							} else if (Math.random() < b || QjBl.zi_baodi >= 9) {
								if (!entity.level().isClientSide())
									entity.discard();
								if (world instanceof ServerLevel _level) {
									Entity entityToSpawn = PrimogemcraftModEntities.Q_QYUANCHUZI_01.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
									if (entityToSpawn != null) {
										entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
									}
								}
								_vars.wj_ck_zi = QjBl.wj_ck_zi++;
								if (!entityiterator.getPersistentData().getBoolean("xiangyu")) {
									_vars.jin_baodi = QjBl.jin_baodi++;
								}
								_vars.zi_baodi = QjBl.zi_baodi = 0;
								entityiterator.getPersistentData().putBoolean("xiangyu", false);
							} else {
								entity.getPersistentData().putString("qiyuan_guishu", (entityiterator.getDisplayName().getString()));
								_vars.wj_ck_lan = QjBl.wj_ck_lan++;
								if (!entityiterator.getPersistentData().getBoolean("xiangyu")) {
									_vars.jin_baodi = QjBl.jin_baodi++;
								}
								_vars.zi_baodi = QjBl.zi_baodi++;
								entityiterator.getPersistentData().putDouble("chouka", (entityiterator.getPersistentData().getDouble("chouka") - 1));
								entityiterator.getPersistentData().putDouble("chouka_jiacheng", (entityiterator.getPersistentData().getDouble("chouka_jiacheng") - 1));
								entity.getPersistentData().putBoolean("chouka_jiance_0", true);
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
							entity.getPersistentData().putString("qiyuan_guishu", (entityiterator.getDisplayName().getString()));
							entityiterator.getPersistentData().putDouble("chouka", (entityiterator.getPersistentData().getDouble("chouka") - 1));
							entityiterator.getPersistentData().putDouble("chouka_jiacheng", (entityiterator.getPersistentData().getDouble("chouka_jiacheng") - 1));
							entity.getPersistentData().putBoolean("chouka_jiance_1", true);
							Scmjsx0Procedure.execute(entityiterator, entity);
						}
					}
				}
			}
			if (entity instanceof QqiyuanJinGuangEntity) {
				{
					final Vec3 _center = new Vec3(x, (y - 10), z);
					for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(40 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
						if (entityiterator.getPersistentData().getBoolean("chouka") || entityiterator.getPersistentData().getBoolean("baodi_shoudong")) {
							entity.getPersistentData().putString("qiyuan_guishu", (entityiterator.getDisplayName().getString()));
							if (entityiterator.getPersistentData().getBoolean("baodi_shoudong")) {
								entityiterator.getPersistentData().putBoolean("baodi_shoudong", false);
							} else {
								entityiterator.getPersistentData().putDouble("chouka", (entityiterator.getPersistentData().getDouble("chouka") - 1));
								entityiterator.getPersistentData().putDouble("chouka_jiacheng", (entityiterator.getPersistentData().getDouble("chouka_jiacheng") - 1));
							}
							entity.getPersistentData().putBoolean("chouka_jiance_2", true);
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
						if ((entity.getPersistentData().getString("qiyuan_guishu")).equals(entityiterator.getDisplayName().getString())) {
							if (!(entityiterator instanceof ServerPlayer _plr55 && _plr55.level() instanceof ServerLevel
									&& _plr55.getAdvancements().getOrStartProgress(_plr55.server.getAdvancements().get(ResourceLocation.parse("primogemcraft:bhmg"))).isDone())) {
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
				}
			});
		}
	}
}
