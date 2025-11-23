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

import net.mcreator.ceshi.procedures.GUIqwxzanniusx2Procedure;
import net.mcreator.ceshi.procedures.GUIqwxzanniusx1Procedure;
import net.mcreator.ceshi.procedures.GUIqwxzanniusx0Procedure;
import net.mcreator.ceshi.procedures.GUIbhmgfqProcedure;
import net.mcreator.ceshi.PrimogemcraftMod;

@EventBusSubscriber
public record GUIbhmgButtonMessage(int buttonID, int x, int y, int z) implements CustomPacketPayload {

	public static final Type<GUIbhmgButtonMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(PrimogemcraftMod.MODID, "gu_ibhmg_buttons"));
	public static final StreamCodec<RegistryFriendlyByteBuf, GUIbhmgButtonMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, GUIbhmgButtonMessage message) -> {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}, (RegistryFriendlyByteBuf buffer) -> new GUIbhmgButtonMessage(buffer.readInt(), buffer.readInt(), buffer.readInt(), buffer.readInt()));
	@Override
	public Type<GUIbhmgButtonMessage> type() {
		return TYPE;
	}

	public static void handleData(final GUIbhmgButtonMessage message, final IPayloadContext context) {
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

			GUIqwxzanniusx0Procedure.execute(world, entity);
		}
		if (buttonID == 1) {

			GUIqwxzanniusx1Procedure.execute(world, entity);
		}
		if (buttonID == 2) {

			GUIqwxzanniusx2Procedure.execute(world, entity);
		}
		if (buttonID == 3) {

			GUIbhmgfqProcedure.execute(world, x, y, z, entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		PrimogemcraftMod.addNetworkMessage(GUIbhmgButtonMessage.TYPE, GUIbhmgButtonMessage.STREAM_CODEC, GUIbhmgButtonMessage::handleData);
	}
}