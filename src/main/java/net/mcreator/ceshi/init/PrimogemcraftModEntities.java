/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.ceshi.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.event.entity.RegisterSpawnPlacementsEvent;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.registries.Registries;

import net.mcreator.ceshi.entity.*;
import net.mcreator.ceshi.PrimogemcraftMod;

@EventBusSubscriber
public class PrimogemcraftModEntities {
	public static final DeferredRegister<EntityType<?>> REGISTRY = DeferredRegister.create(Registries.ENTITY_TYPE, PrimogemcraftMod.MODID);
	public static final DeferredHolder<EntityType<?>, EntityType<QqiyuanJinGuangEntity>> QQIYUAN_JIN_GUANG = register("qqiyuan_jin_guang",
			EntityType.Builder.<QqiyuanJinGuangEntity>of(QqiyuanJinGuangEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(1).setUpdateInterval(3).fireImmune()

					.sized(0.3f, 0.3f));
	public static final DeferredHolder<EntityType<?>, EntityType<QQyuanchuzi01Entity>> Q_QYUANCHUZI_01 = register("q_qyuanchuzi_01",
			EntityType.Builder.<QQyuanchuzi01Entity>of(QQyuanchuzi01Entity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(1).setUpdateInterval(3).fireImmune()

					.sized(0.3f, 0.3f));
	public static final DeferredHolder<EntityType<?>, EntityType<QQQyuanchulan01Entity>> QQ_QYUANCHULAN_01 = register("qq_qyuanchulan_01",
			EntityType.Builder.<QQQyuanchulan01Entity>of(QQQyuanchulan01Entity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(1).setUpdateInterval(3).fireImmune()

					.sized(0.3f, 0.3f));
	public static final DeferredHolder<EntityType<?>, EntityType<QqiwuzhanlipinshitiEntity>> QQIWUZHANLIPINSHITI = register("qqiwuzhanlipinshiti",
			EntityType.Builder.<QqiwuzhanlipinshitiEntity>of(QqiwuzhanlipinshitiEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(0).setUpdateInterval(3)

					.ridingOffset(-0.6f).sized(0.1f, 0.1f));
	public static final DeferredHolder<EntityType<?>, EntityType<BaiguangguodushengwuEntity>> BAIGUANGGUODUSHENGWU = register("baiguangguodushengwu",
			EntityType.Builder.<BaiguangguodushengwuEntity>of(BaiguangguodushengwuEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(1).setUpdateInterval(3)

					.sized(0.6f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<CaoyuanheshengwuEntity>> CAOYUANHESHENGWU = register("caoyuanheshengwu",
			EntityType.Builder.<CaoyuanheshengwuEntity>of(CaoyuanheshengwuEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(1).setUpdateInterval(3)

					.sized(0.2f, 0.2f));
	public static final DeferredHolder<EntityType<?>, EntityType<XiaodengEntity>> XIAODENG = register("xiaodeng",
			EntityType.Builder.<XiaodengEntity>of(XiaodengEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(1).setUpdateInterval(3).fireImmune()

					.sized(0.6f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<XiaoheitaEntity>> XIAOHEITA = register("xiaoheita",
			EntityType.Builder.<XiaoheitaEntity>of(XiaoheitaEntity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune()

					.sized(0.6f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<SWfengraojiangshiEntity>> S_WFENGRAOJIANGSHI = register("s_wfengraojiangshi",
			EntityType.Builder.<SWfengraojiangshiEntity>of(SWfengraojiangshiEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune().ridingOffset(-0.6f).sized(0.6f, 1.8f));

	// Start of user code block custom entities
	// End of user code block custom entities
	private static <T extends Entity> DeferredHolder<EntityType<?>, EntityType<T>> register(String registryname, EntityType.Builder<T> entityTypeBuilder) {
		return REGISTRY.register(registryname, () -> (EntityType<T>) entityTypeBuilder.build(registryname));
	}

	@SubscribeEvent
	public static void init(RegisterSpawnPlacementsEvent event) {
		QqiyuanJinGuangEntity.init(event);
		QQyuanchuzi01Entity.init(event);
		QQQyuanchulan01Entity.init(event);
		QqiwuzhanlipinshitiEntity.init(event);
		BaiguangguodushengwuEntity.init(event);
		CaoyuanheshengwuEntity.init(event);
		XiaodengEntity.init(event);
		XiaoheitaEntity.init(event);
		SWfengraojiangshiEntity.init(event);
	}

	@SubscribeEvent
	public static void registerAttributes(EntityAttributeCreationEvent event) {
		event.put(QQIYUAN_JIN_GUANG.get(), QqiyuanJinGuangEntity.createAttributes().build());
		event.put(Q_QYUANCHUZI_01.get(), QQyuanchuzi01Entity.createAttributes().build());
		event.put(QQ_QYUANCHULAN_01.get(), QQQyuanchulan01Entity.createAttributes().build());
		event.put(QQIWUZHANLIPINSHITI.get(), QqiwuzhanlipinshitiEntity.createAttributes().build());
		event.put(BAIGUANGGUODUSHENGWU.get(), BaiguangguodushengwuEntity.createAttributes().build());
		event.put(CAOYUANHESHENGWU.get(), CaoyuanheshengwuEntity.createAttributes().build());
		event.put(XIAODENG.get(), XiaodengEntity.createAttributes().build());
		event.put(XIAOHEITA.get(), XiaoheitaEntity.createAttributes().build());
		event.put(S_WFENGRAOJIANGSHI.get(), SWfengraojiangshiEntity.createAttributes().build());
	}
}