package net.ai;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;
import java.util.UUID;

public class LivingItemDrop extends ItemEntity {
	private final UUID ownerUuid;

	public LivingItemDrop(Level level, double x, double y, double z, ItemStack stack, @Nullable UUID owner) {
		super(level, x, y, z, stack);
		this.ownerUuid = owner;
		this.setInvulnerable(true);
		this.setUnlimitedLifetime();
		this.setNoPickUpDelay();
		this.setNoGravity(false);
		if (owner != null) {
			this.setTarget(owner);
		}
	}

	public UUID getOwnerUuid() {
		return this.ownerUuid;
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

	@Override
	public void playerTouch(Player player) {
		if (this.ownerUuid != null && !this.ownerUuid.equals(player.getUUID())) {
			return;
		}
		super.playerTouch(player);
	}

	@Override
	public boolean isPushable() {
		return false;
	}

	@Override
	public void checkBelowWorld() {
	}
}
