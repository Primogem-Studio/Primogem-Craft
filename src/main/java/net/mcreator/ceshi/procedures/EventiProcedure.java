package net.mcreator.ceshi.procedures;

import net.hackermdch.pgc.Timer;
import net.mcreator.ceshi.init.PrimogemcraftModGameRules;
import net.mcreator.ceshi.init.PrimogemcraftModItems;
import net.mcreator.ceshi.network.PrimogemcraftModVariables;
import net.minecraft.core.component.DataComponents;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.level.LevelAccessor;

import java.util.Collections;
import java.util.List;

public class EventiProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, double zhi,boolean count) {
        if (entity == null)
            return;
        if (y == -128 && entity.getY() != -128) {
            x = entity.getX();
            y = entity.getY();
            z = entity.getZ();
        }
        if (!world.isClientSide()) {
            if (Timer.isDone(entity, "event_cd") && count ? updateEventQuota(world, entity) : count) {
                Timer.set(entity, "event_cd", 20);
                ItemStack a = ItemStack.EMPTY;
                a = new ItemStack(PrimogemcraftModItems.SH_JWUPIN.get());
                CustomData.update(DataComponents.CUSTOM_DATA, a, tag -> tag.putDouble("event_zu_i", zhi));
                if (world instanceof ServerLevel _level) {
                    ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, a);
                    entityToSpawn.setPickUpDelay(40);
                    _level.addFreshEntity(entityToSpawn);
                }
            }
        }
    }

    public static boolean updateEventQuota(LevelAccessor world, Entity entity) {
        PrimogemcraftModVariables.PlayerVariables _ie = entity.getData(PrimogemcraftModVariables.PLAYER_VARIABLES);
        var _iw = PrimogemcraftModVariables.MapVariables.get(world);
        var gz = world.getLevelData().getGameRules().getInt(PrimogemcraftModGameRules.GUIZESHIJIANXIANZHI);
        boolean add = false;
        boolean con = false;
        if (_iw.shijian_xianzhi > gz) for (double fo = _iw.shijian_xianzhi; fo > gz; fo--) {
            _iw.shijian_xianzhi = fo;
            _iw.markSyncDirty();};
        if (Timer.isDone(entity, "Event_it")) {
            add = true;
            if (_ie.Event_entity <= 0) _ie.Event_entity++;
            else if (_iw.shijian_xianzhi > 0) {_iw.shijian_xianzhi--;
                if (_iw.shijian_xianzhi > gz) for (double fo = _iw.shijian_xianzhi; fo > gz; fo--) _iw.shijian_xianzhi --;
            } else add = false;
        }
        if (Math.random() < ((world.getLevelData().getGameRules().getInt(PrimogemcraftModGameRules.GUIZESUIJISHIJIAN)) * 0.01) / 100) {
            if (_iw.shijian_xianzhi < gz) {_iw.shijian_xianzhi++;
                con = true;
            } else if (_ie.Event_entity > 0) {_ie.Event_entity--;
                con = true;
            }
        }
        if (add) Timer.set(entity, "Event_it", 200);
        _ie.markSyncDirty();
        _iw.markSyncDirty();
        return con;
    }
}