package net.mcreator.ceshi.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;

import net.mcreator.ceshi.PrimogemcraftMod;

public class Sshenhudezhufu013Item extends Item {
	public Sshenhudezhufu013Item() {
		super(new Item.Properties().stacksTo(1).rarity(Rarity.RARE).jukeboxPlayable(ResourceKey.create(Registries.JUKEBOX_SONG, ResourceLocation.fromNamespaceAndPath(PrimogemcraftMod.MODID, "sshenhudezhufu_013"))));
	}
}