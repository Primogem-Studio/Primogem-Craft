package net.per.registry;

import net.ai.LivingItemAPI;
import net.ai.LivingItemEntity;
import net.mcreator.ceshi.init.PrimogemcraftModItems;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.per.elixir.registry.ElixirRegistries;
import net.per.elixir.util.IElixirAction;
import net.per.elixir.util.IElixirCalc;
import net.per.wish.SpawnWishiEntity;

import static net.mcreator.ceshi.PrimogemcraftMod.MODID;

public class ElixirPGC {
    public static final DeferredRegister<IElixirAction> ACTIONS = DeferredRegister.create(ElixirRegistries.ACTION, MODID);
    public static final DeferredRegister<IElixirCalc> CALCULATORS = DeferredRegister.create(ElixirRegistries.CALCULATOR, MODID);

    static {
        ACTIONS.register("yuanshi", () -> (pharm, time, stack, level, entity) -> {
            if (!level.isClientSide && pharm > 1) {
                if (entity instanceof Player player) {
                    new SpawnWishiEntity.Spawn(level, player, pharm, pharm, false).Spawn();
                } else
                    level.addFreshEntity(new ItemEntity(level, entity.getX(), entity.getY(), entity.getZ(), new ItemStack(PrimogemcraftModItems.YUANSHI.get(), level.random.nextInt(1, pharm))));
            }
        });
        ACTIONS.register("qwfjjwl", () -> (pharm, time, stack, level, entity) -> {
            if (level.isClientSide || !(entity instanceof Player player)) {
                return;
            }
            for (LivingItemEntity living : LivingItemAPI.collectAll(player)) {
                if (living.isInfinite()) {
                    continue;
                }
                living.setRemainingTicks(Mth.clamp(living.getRemainingTicks() + time / 8, 60, 160));
            }
        });
        ACTIONS.register("jlliang", () -> (pharm, time, stack, level, entity) -> {
            if (level.isClientSide || !(entity instanceof Player player)) {
                return;
            }
            if (pharm > 0) {
                LivingItemAPI.summon(player, time / 8);
            } else if (pharm < 0) {
                for (LivingItemEntity living : LivingItemAPI.collectAll(player)) {
                    if (!living.isInfinite()) {
                        living.setRemainingTicks(0);
                    }
                }
            }
        });
        ACTIONS.register("yuansujingti", () -> (pharm, time, stack, level, entity) -> {
            if (level.isClientSide || !(entity instanceof Player player)) {
                return;
            }
            if (pharm <= 0) {
                return;
            }
            stack.shrink(1);
            LivingItemAPI.summonAllFromInventory(player, Math.min(time/8, 400));
        });
        ACTIONS.register("ysrz_0", () -> (pharm, time, stack, level, entity) -> {
            if (level.isClientSide || !(entity instanceof Player player)) {
                return;
            }
            LivingItemAPI.summonInfinite(player);
        });
        CALCULATORS.register("jianshao", () -> (pharm, base) -> Math.max(0, (int) base - Math.abs(pharm)));
    }

    public static void init(IEventBus bus) {
        ACTIONS.register(bus);
        CALCULATORS.register(bus);
    }
}
