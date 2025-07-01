/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.ceshi.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.items.wrapper.SidedInvWrapper;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.Block;
import net.minecraft.core.registries.BuiltInRegistries;

import net.mcreator.ceshi.block.entity.XjhpyhfhBlockEntity;
import net.mcreator.ceshi.block.entity.ShenmiwanouBlockEntity;
import net.mcreator.ceshi.block.entity.QxzhqBlockEntity;
import net.mcreator.ceshi.block.entity.Moladui02BlockEntity;
import net.mcreator.ceshi.block.entity.MmolazhilajitongBlockEntity;
import net.mcreator.ceshi.block.entity.Mlxdml03BlockEntity;
import net.mcreator.ceshi.block.entity.Mlxdml02BlockEntity;
import net.mcreator.ceshi.block.entity.Mlxdml01BlockEntity;
import net.mcreator.ceshi.block.entity.LajitongBlockEntity;
import net.mcreator.ceshi.block.entity.HualiduanzaoBlockEntity;
import net.mcreator.ceshi.block.entity.HhzdbooBlockEntity;
import net.mcreator.ceshi.block.entity.Hhzd1BlockEntity;
import net.mcreator.ceshi.block.entity.Hhzd0BlockEntity;
import net.mcreator.ceshi.block.entity.GanjinglajitongxiangziBlockEntity;
import net.mcreator.ceshi.block.entity.DangaoliyueBlockEntity;
import net.mcreator.ceshi.block.entity.ChuangzaoxiaodengfasheqiBlockEntity;
import net.mcreator.ceshi.block.entity.CeshixiaodengfasheqiBlockEntity;
import net.mcreator.ceshi.block.entity.BwdxjhpyhfhBlockEntity;
import net.mcreator.ceshi.PrimogemcraftMod;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class PrimogemcraftModBlockEntities {
	public static final DeferredRegister<BlockEntityType<?>> REGISTRY = DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, PrimogemcraftMod.MODID);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<Moladui02BlockEntity>> MOLADUI_02 = register("moladui_02", PrimogemcraftModBlocks.MOLADUI_02, Moladui02BlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<LajitongBlockEntity>> LAJITONG = register("lajitong", PrimogemcraftModBlocks.LAJITONG, LajitongBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<GanjinglajitongxiangziBlockEntity>> GANJINGLAJITONGXIANGZI = register("ganjinglajitongxiangzi", PrimogemcraftModBlocks.GANJINGLAJITONGXIANGZI,
			GanjinglajitongxiangziBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<MmolazhilajitongBlockEntity>> MMOLAZHILAJITONG = register("mmolazhilajitong", PrimogemcraftModBlocks.MMOLAZHILAJITONG, MmolazhilajitongBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<CeshixiaodengfasheqiBlockEntity>> CESHIXIAODENGFASHEQI = register("ceshixiaodengfasheqi", PrimogemcraftModBlocks.CESHIXIAODENGFASHEQI, CeshixiaodengfasheqiBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<ChuangzaoxiaodengfasheqiBlockEntity>> CHUANGZAOXIAODENGFASHEQI = register("chuangzaoxiaodengfasheqi", PrimogemcraftModBlocks.CHUANGZAOXIAODENGFASHEQI,
			ChuangzaoxiaodengfasheqiBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<Mlxdml01BlockEntity>> MLXDML_01 = register("mlxdml_01", PrimogemcraftModBlocks.MLXDML_01, Mlxdml01BlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<Mlxdml02BlockEntity>> MLXDML_02 = register("mlxdml_02", PrimogemcraftModBlocks.MLXDML_02, Mlxdml02BlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<Mlxdml03BlockEntity>> MLXDML_03 = register("mlxdml_03", PrimogemcraftModBlocks.MLXDML_03, Mlxdml03BlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<DangaoliyueBlockEntity>> DANGAOLIYUE = register("dangaoliyue", PrimogemcraftModBlocks.DANGAOLIYUE, DangaoliyueBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<XjhpyhfhBlockEntity>> XJHPYHFH = register("xjhpyhfh", PrimogemcraftModBlocks.XJHPYHFH, XjhpyhfhBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<BwdxjhpyhfhBlockEntity>> BWDXJHPYHFH = register("bwdxjhpyhfh", PrimogemcraftModBlocks.BWDXJHPYHFH, BwdxjhpyhfhBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<HualiduanzaoBlockEntity>> HUALIDUANZAO = register("hualiduanzao", PrimogemcraftModBlocks.HUALIDUANZAO, HualiduanzaoBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<Hhzd0BlockEntity>> HHZD_0 = register("hhzd_0", PrimogemcraftModBlocks.HHZD_0, Hhzd0BlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<Hhzd1BlockEntity>> HHZD_1 = register("hhzd_1", PrimogemcraftModBlocks.HHZD_1, Hhzd1BlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<ShenmiwanouBlockEntity>> SHENMIWANOU = register("shenmiwanou", PrimogemcraftModBlocks.SHENMIWANOU, ShenmiwanouBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<HhzdbooBlockEntity>> HHZDBOO = register("hhzdboo", PrimogemcraftModBlocks.HHZDBOO, HhzdbooBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<QxzhqBlockEntity>> QXZHQ = register("qxzhq", PrimogemcraftModBlocks.QXZHQ, QxzhqBlockEntity::new);

	// Start of user code block custom block entities
	// End of user code block custom block entities
	private static <T extends BlockEntity> DeferredHolder<BlockEntityType<?>, BlockEntityType<T>> register(String registryname, DeferredHolder<Block, Block> block, BlockEntityType.BlockEntitySupplier<T> supplier) {
		return REGISTRY.register(registryname, () -> BlockEntityType.Builder.of(supplier, block.get()).build(null));
	}

	@SubscribeEvent
	public static void registerCapabilities(RegisterCapabilitiesEvent event) {
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, MOLADUI_02.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, LAJITONG.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, GANJINGLAJITONGXIANGZI.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, MMOLAZHILAJITONG.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, CESHIXIAODENGFASHEQI.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, CHUANGZAOXIAODENGFASHEQI.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, MLXDML_01.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, MLXDML_02.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, MLXDML_03.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, DANGAOLIYUE.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, XJHPYHFH.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, BWDXJHPYHFH.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, HUALIDUANZAO.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, HHZD_0.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, HHZD_1.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, SHENMIWANOU.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, HHZDBOO.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, QXZHQ.get(), SidedInvWrapper::new);
	}
}