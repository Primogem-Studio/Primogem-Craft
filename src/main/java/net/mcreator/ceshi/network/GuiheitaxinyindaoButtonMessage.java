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

import net.mcreator.ceshi.procedures.GuixsxinheitayindaocwdmProcedure;
import net.mcreator.ceshi.procedures.GuixinheitaqiwuProcedure;
import net.mcreator.ceshi.procedures.GuixinheitalikaiProcedure;
import net.mcreator.ceshi.PrimogemcraftMod;

@EventBusSubscriber
public record GuiheitaxinyindaoButtonMessage(int buttonID, int x, int y, int z) implements CustomPacketPayload {

	public static final Type<GuiheitaxinyindaoButtonMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(PrimogemcraftMod.MODID, "guiheitaxinyindao_buttons"));
	public static final StreamCodec<RegistryFriendlyByteBuf, GuiheitaxinyindaoButtonMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, GuiheitaxinyindaoButtonMessage message) -> {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}, (RegistryFriendlyByteBuf buffer) -> new GuiheitaxinyindaoButtonMessage(buffer.readInt(), buffer.readInt(), buffer.readInt(), buffer.readInt()));
	@Override
	public Type<GuiheitaxinyindaoButtonMessage> type() {
		return TYPE;
	}

	public static void handleData(final GuiheitaxinyindaoButtonMessage message, final IPayloadContext context) {
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

			GuixsxinheitayindaocwdmProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 1) {

			GuixinheitaqiwuProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 2) {

			GuixinheitalikaiProcedure.execute(entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		PrimogemcraftMod.addNetworkMessage(GuiheitaxinyindaoButtonMessage.TYPE, GuiheitaxinyindaoButtonMessage.STREAM_CODEC, GuiheitaxinyindaoButtonMessage::handleData);
	}
}