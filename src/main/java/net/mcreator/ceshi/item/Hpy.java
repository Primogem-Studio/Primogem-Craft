package net.mcreator.ceshi.item;

import net.hackermdch.pgc.interfaces.UseAlways;
import net.mcreator.ceshi.procedures.HpymsProcedure;
import net.mcreator.ceshi.procedures.Hpysx0Procedure;
import net.mcreator.ceshi.procedures.JlqhewaiProcedure;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.MaceItem;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.level.Level;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

import java.util.List;

import static net.mcreator.ceshi.PrimogemcraftMod.MODID;
import static net.minecraft.world.entity.ai.attributes.AttributeModifier.Operation.ADD_VALUE;

public class Hpy extends MaceItem implements UseAlways {
    public Hpy() {
        super(new Properties().attributes(createCustomAttributes()).stacksTo(1).durability(2048).fireResistant());
    }

    private static ItemAttributeModifiers createCustomAttributes() {
        return ItemAttributeModifiers.builder()
                .add(
                        Attributes.ATTACK_DAMAGE,
                        new AttributeModifier(BASE_ATTACK_DAMAGE_ID, 9, ADD_VALUE),
                        EquipmentSlotGroup.MAINHAND
                )
                .add(
                        Attributes.ATTACK_SPEED,
                        new AttributeModifier(BASE_ATTACK_SPEED_ID, -2, ADD_VALUE),
                        EquipmentSlotGroup.MAINHAND
                ).add(
                        Attributes.ENTITY_INTERACTION_RANGE,
                        new AttributeModifier(ResourceLocation.fromNamespaceAndPath(MODID, "hmzz"), 3, ADD_VALUE),
                        EquipmentSlotGroup.MAINHAND
                )
                .build();
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
        var ar = super.use(world, entity, hand);
        HpymsProcedure.execute(entity, ar.getObject());
        return ar;
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void appendHoverText(ItemStack itemstack, Item.TooltipContext context, List<Component> list, TooltipFlag flag) {
        var entity = itemstack.getEntityRepresentation() != null ? itemstack.getEntityRepresentation() : Minecraft.getInstance().player;
        var hoverText = HpymsProcedure.execute(entity, itemstack);
        for (var line : hoverText.split("\n")) list.add(Component.literal(line));
    }

    @Override
    public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
        if (selected) Hpysx0Procedure.execute(entity, itemstack);
        JlqhewaiProcedure.execute(entity, itemstack);
    }
}
