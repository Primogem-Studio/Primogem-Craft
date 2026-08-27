package net.AI;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;
import java.util.UUID;

public class LivingItemDrop extends ItemEntity {
	public LivingItemDrop(Level level, double x, double y, double z, ItemStack stack, @Nullable UUID owner) {
		super(level, x, y, z, stack);
		this.setInvulnerable(true);
		this.setUnlimitedLifetime();
		this.setNoPickUpDelay();
		if (owner != null) {
			this.setTarget(owner);
		}
	}

	@Override
	public boolean hurt(DamageSource source, float amount) {
		return false;
	}

	@Override
	public boolean isInvulnerableTo(DamageSource source) {
		return true;
	}

	@Override
	public boolean fireImmune() {
		return true;
	}

	@Override
	public boolean isPickable() {
		return true;
	}
}
