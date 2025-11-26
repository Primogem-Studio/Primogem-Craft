package net.mcreator.ceshi.procedures;

import io.netty.buffer.Unpooled;
import net.mcreator.ceshi.PrimogemcraftMod;
import net.mcreator.ceshi.init.PrimogemcraftModItems;
import net.mcreator.ceshi.world.inventory.GUISJfumoMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.level.LevelAccessor;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.items.IItemHandlerModifiable;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

public class Event_item_sxRProcedure {
    private static final Map<Integer, BiFunction<LevelAccessor, Entity, Boolean>> EVENT_HANDLERS = new HashMap<>();

    static {
        // 注册所有事件处理器
        registerEvent(1, (world, entity) -> shijian_123(entity, 1, new ItemStack(PrimogemcraftModItems.YUZHOUSUIPIAN.get()), 10));
        registerEvent(2, (world, entity) -> shijian_123(entity, suijiint(world, 1, 3), new ItemStack(PrimogemcraftModItems.YUZHOUSUIPIAN.get()), 20));
        registerEvent(3, (world, entity) -> shijian_123(entity, suijiint(world, 2, 4), new ItemStack(PrimogemcraftModItems.YUZHOUSUIPIAN.get()), 40));
        registerEvent(4, (world, entity) -> Hp_jian(entity, world, 0.2) ? fumo(entity, 1) : no(entity));
        registerEvent(5, (world, entity) -> Hp_jian(entity, world, 0.7) ? fumo(entity, 2) : no(entity));
        registerEvent(6, (world, entity) -> Hp_jian(entity, world, 0.95) && item_zhi_1_1(new ItemStack(PrimogemcraftModItems.YUZHOUSUIPIAN.get()), 20, entity) ? fumo(entity, 3) : no(entity));
        registerEvent(7, (world, entity) -> item_zhi(world, entity, true, "c:curio/normal/b"));
        registerEvent(8, (world, entity) -> item_zhi(world, entity, true, "c:curio/normal/a"));
        registerEvent(9, (world, entity) -> item_zhi(world, entity, true, "c:curio/normal/s"));
        registerEvent(10, (world, entity) -> item_zhi(world, entity, true, "c:curio/normal/fusion/b"));
        registerEvent(11, (world, entity) -> item_zhi(world, entity, true, "c:curio/normal/fusion/a"));
        registerEvent(12, (world, entity) -> item_zhi(world, entity, true, "c:curio/normal/fusion/s"));
        registerEvent(13, (world, entity) -> fumo(entity, 1));
        registerEvent(14, (world, entity) -> fumo(entity, 2));
        registerEvent(15, (world, entity) -> fumo(entity, 3));
        registerEvent(16, (world, entity) -> fumo(entity, 4));
        registerEvent(17, (world, entity) -> item_zhi(world, entity, true, "c:curio/negative"));
        registerEvent(18, (world, entity) -> item_zhi(world, entity, true, "c:curio/clock"));
        registerEvent(19, (world, entity) -> item_zhi(world, entity, true, "c:curio/negative/cf"));
    }

    public static void registerEvent(int eventId, BiFunction<LevelAccessor, Entity, Boolean> handler) {
        EVENT_HANDLERS.put(eventId, handler);
    }

    public static void execute(LevelAccessor world, Entity entity, ItemStack itemstack) {
        if (entity == null)
            return;
        double ie = itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("event_");

        BiFunction<LevelAccessor, Entity, Boolean> handler = EVENT_HANDLERS.get((int) ie);
        boolean o1 = handler != null ? handler.apply(world, entity) : false;

        if (o1)
            itemstack.shrink(1);
    }

    public static boolean fumo(Entity entity, int zhi) {
        // 接收对应等级附魔并为实体打开附魔GUI，最大4
        entity.getPersistentData().putDouble("pgc_shijian_fumo_pinzhi", zhi);
        PrimogemcraftMod.queueServerWork(1, () -> {
            if (entity instanceof ServerPlayer _ent) {
                BlockPos _bpos = BlockPos.containing(entity.getX(), entity.getY(), entity.getZ());
                _ent.openMenu(new MenuProvider() {
                    @Override
                    public Component getDisplayName() {
                        return Component.literal("GUISJfumo");
                    }

                    @Override
                    public boolean shouldTriggerClientSideContainerClosingOnOpen() {
                        return false;
                    }

                    @Override
                    public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
                        return new GUISJfumoMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
                    }
                }, _bpos);
            }
        });
        return true;
    }

    public static boolean item_zhi_1_1(ItemStack item, int zhi, Entity entity) {
        //移除特定数量的item
        ItemStack i = item;
        int z = 0;
        if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandlerIter) {
            for (int _idx = 0; _idx < _modHandlerIter.getSlots(); _idx++) {
                ItemStack itemstackiterator = _modHandlerIter.getStackInSlot(_idx).copy();
                if (itemstackiterator.getItem() == i.getItem())
                    z = z + itemstackiterator.getCount();
            }
        }
        if (z >= zhi) {
            if (entity instanceof Player _player) {
                ItemStack _stktoremove = new ItemStack(i.getItem());
                _player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), (int) zhi, _player.inventoryMenu.getCraftSlots());
            }
            return true;
        }
        return false;
    }

    public static boolean shijian_123(Entity entity, int zhi, ItemStack item, int itzhi) {
        //移除 entity 的 itzhi个 item 后打开 zhi 级别的附魔界面
        if (item_zhi_1_1(item, itzhi, entity)) {
            fumo(entity, zhi);
            return true;
        }
        no(entity);
        return false;
    }

    public static int suijiint(LevelAccessor world, int zhi, int zhi0) {
        //服务器随机整数
        int a = 0;
        if (!world.isClientSide())
            a = Mth.nextInt(RandomSource.create(), zhi, zhi0);
        return a;
    }

    public static boolean Hp_jian(Entity entity, LevelAccessor world, double zhi) {
        //造成百分比的 zhi 伤害
        if (entity != null && entity instanceof LivingEntity _livEnt) {
            var mhp = _livEnt.getMaxHealth();//最大生命值
            if (_livEnt.getHealth() >= mhp * zhi) {
                entity.hurt(new DamageSource(world.holderOrThrow(DamageTypes.GENERIC)), (float) (mhp * zhi));
                return true;
            }
        } else return false;
        return false;
    }

    public static boolean no(Entity entity) {
        //播放条件不足
        if (entity instanceof Player _player && !_player.level().isClientSide())
            _player.displayClientMessage(Component.literal("\u00A7c\u6761\u4EF6\u4E0D\u8DB3\uFF01"), false);
        return false;
    }

    public static boolean item_zhi(LevelAccessor world, Entity entity, boolean qd, String tag_) {
        GUIqwxz03Procedure.execute(world, entity, qd, tag_);
        return true;
    }
}