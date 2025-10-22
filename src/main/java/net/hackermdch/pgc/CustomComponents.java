package net.hackermdch.pgc;

import net.minecraft.core.component.DataComponentType;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.util.ExtraCodecs;

public class CustomComponents {
    public static final DataComponentType<CustomBar> CUSTOM_BAR = DataComponentType.<CustomBar>builder().persistent(CustomBar.CODEC).networkSynchronized(CustomBar.STREAM_CODEC).build();
    public static final DataComponentType<Integer> ELEMENT_TYPE = DataComponentType.<Integer>builder().persistent(ExtraCodecs.intRange(0, 7)).networkSynchronized(ByteBufCodecs.VAR_INT).build();
    public static final DataComponentType<Integer> YSZUJIAN_JIAN = DataComponentType.<Integer>builder().persistent(ExtraCodecs.intRange(0, 7)).networkSynchronized(ByteBufCodecs.VAR_INT).build();
}
