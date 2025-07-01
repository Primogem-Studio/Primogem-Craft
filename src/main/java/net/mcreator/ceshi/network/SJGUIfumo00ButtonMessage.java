package net.mcreator.ceshi.network;

import net.neoforged.neoforge.network.handling.IPayloadContext;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.network.protocol.PacketFlow;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.chat.Component;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.core.BlockPos;

import net.mcreator.ceshi.procedures.Sjguifumo00sx2Procedure;
import net.mcreator.ceshi.procedures.Sjguifumo00sx1Procedure;
import net.mcreator.ceshi.procedures.Sjguifumo00sx0Procedure;
import net.mcreator.ceshi.PrimogemcraftMod;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public record SJGUIfumo00ButtonMessage(int buttonID, int x, int y, int z) implements CustomPacketPayload {

	public static final Type<SJGUIfumo00ButtonMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(PrimogemcraftMod.MODID, "sjgu_ifumo_00_buttons"));
	public static final StreamCodec<RegistryFriendlyByteBuf, SJGUIfumo00ButtonMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, SJGUIfumo00ButtonMessage message) -> {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}, (RegistryFriendlyByteBuf buffer) -> new SJGUIfumo00ButtonMessage(buffer.readInt(), buffer.readInt(), buffer.readInt(), buffer.readInt()));
	@Override
	public Type<SJGUIfumo00ButtonMessage> type() {
		return TYPE;
	}

	public static void handleData(final SJGUIfumo00ButtonMessage message, final IPayloadContext context) {
		if (context.flow() == PacketFlow.SERVERBOUND) {
			context.enqueueWork(() -> handleButtonAction(context.player(), message.buttonID, message.x, message.y, message.z)).exceptionally(e -> {
				context.connection().disconnect(Component.literal(e.getMessage()));
				return null;
			});
		}
	}

	public static void handleButtonAction(Player entity, int buttonID, int x, int y, int z) {
		Level world = entity.level();
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {

			Sjguifumo00sx0Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 1) {

			Sjguifumo00sx1Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 2) {

			Sjguifumo00sx2Procedure.execute(world, x, y, z, entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		PrimogemcraftMod.addNetworkMessage(SJGUIfumo00ButtonMessage.TYPE, SJGUIfumo00ButtonMessage.STREAM_CODEC, SJGUIfumo00ButtonMessage::handleData);
	}
}