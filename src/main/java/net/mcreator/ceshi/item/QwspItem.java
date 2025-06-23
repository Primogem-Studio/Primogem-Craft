
package net.mcreator.ceshi.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class QwspItem extends Item {
	public QwspItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.UNCOMMON));
	}
}
