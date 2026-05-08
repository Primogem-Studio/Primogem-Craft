package net.per.registry;

import net.mcreator.ceshi.init.PrimogemcraftModItems;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.per.elixir.registry.ElixirRegistries;
import net.per.elixir.util.IElixirAction;
import net.per.wish.SpawnWishiEntity;

import static net.mcreator.ceshi.PrimogemcraftMod.MODID;


public class ElixirPGC {
    public static final DeferredRegister<IElixirAction> ACTIONS = DeferredRegister.create(ElixirRegistries.ACTION, MODID);

    static {
        ACTIONS.register("yuanshi", () -> (pharm, time, stack, level, entity) -> {
            if (!level.isClientSide) {
                if (entity instanceof Player player)
                    new SpawnWishiEntity.Spawn(level, player, pharm, pharm, false).Spawn();
                else
                    level.addFreshEntity(new ItemEntity(level, entity.getX(), entity.getY(), entity.getZ(), new ItemStack(PrimogemcraftModItems.YUANSHI.get(), level.random.nextInt(1, pharm))));
            }
        });
    }
}
