package net.mcreator.ceshi;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import net.neoforged.neoforge.network.registration.PayloadRegistrar;
import net.neoforged.neoforge.network.handling.IPayloadHandler;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;
import net.neoforged.neoforge.event.tick.ServerTickEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.fml.util.thread.SidedThreadGroups;
import net.neoforged.fml.common.Mod;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.IEventBus;

import net.minecraft.util.Tuple;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.FriendlyByteBuf;

import net.mcreator.ceshi.world.features.StructureFeature;
import net.mcreator.ceshi.network.PrimogemcraftModVariables;
import net.mcreator.ceshi.init.PrimogemcraftModVillagerProfessions;
import net.mcreator.ceshi.init.PrimogemcraftModTabs;
import net.mcreator.ceshi.init.PrimogemcraftModSounds;
import net.mcreator.ceshi.init.PrimogemcraftModPotions;
import net.mcreator.ceshi.init.PrimogemcraftModParticleTypes;
import net.mcreator.ceshi.init.PrimogemcraftModPaintings;
import net.mcreator.ceshi.init.PrimogemcraftModMobEffects;
import net.mcreator.ceshi.init.PrimogemcraftModMenus;
import net.mcreator.ceshi.init.PrimogemcraftModItems;
import net.mcreator.ceshi.init.PrimogemcraftModFeatures;
import net.mcreator.ceshi.init.PrimogemcraftModEntities;
import net.mcreator.ceshi.init.PrimogemcraftModEnchantments;
import net.mcreator.ceshi.init.PrimogemcraftModBlocks;
import net.mcreator.ceshi.init.PrimogemcraftModBlockEntities;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.Collection;
import java.util.ArrayList;

@Mod("primogemcraft")
public class PrimogemcraftMod {
	public static final Logger LOGGER = LogManager.getLogger(PrimogemcraftMod.class);
	public static final String MODID = "primogemcraft";

	public PrimogemcraftMod(IEventBus modEventBus) {
		// Start of user code block mod constructor
		// End of user code block mod constructor
		NeoForge.EVENT_BUS.register(this);
		modEventBus.addListener(this::registerNetworking);
		PrimogemcraftModSounds.REGISTRY.register(modEventBus);
		PrimogemcraftModBlocks.REGISTRY.register(modEventBus);
		PrimogemcraftModBlockEntities.REGISTRY.register(modEventBus);
		PrimogemcraftModItems.REGISTRY.register(modEventBus);
		PrimogemcraftModEntities.REGISTRY.register(modEventBus);
		PrimogemcraftModTabs.REGISTRY.register(modEventBus);
		PrimogemcraftModVariables.ATTACHMENT_TYPES.register(modEventBus);
		PrimogemcraftModFeatures.REGISTRY.register(modEventBus);
		StructureFeature.REGISTRY.register(modEventBus);
		PrimogemcraftModPaintings.REGISTRY.register(modEventBus);
		PrimogemcraftModPotions.REGISTRY.register(modEventBus);
		PrimogemcraftModMobEffects.REGISTRY.register(modEventBus);
		PrimogemcraftModEnchantments.REGISTRY.register(modEventBus);
		PrimogemcraftModMenus.REGISTRY.register(modEventBus);
		PrimogemcraftModParticleTypes.REGISTRY.register(modEventBus);
		PrimogemcraftModVillagerProfessions.PROFESSIONS.register(modEventBus);
		// Start of user code block mod init
		// End of user code block mod init
	}

	// Start of user code block mod methods
	// End of user code block mod methods
	private static boolean networkingRegistered = false;
	private static final Map<CustomPacketPayload.Type<?>, NetworkMessage<?>> MESSAGES = new HashMap<>();

	private record NetworkMessage<T extends CustomPacketPayload>(StreamCodec<? extends FriendlyByteBuf, T> reader, IPayloadHandler<T> handler) {
	}

	public static <T extends CustomPacketPayload> void addNetworkMessage(CustomPacketPayload.Type<T> id, StreamCodec<? extends FriendlyByteBuf, T> reader, IPayloadHandler<T> handler) {
		if (networkingRegistered)
			throw new IllegalStateException("Cannot register new network messages after networking has been registered");
		MESSAGES.put(id, new NetworkMessage<>(reader, handler));
	}

	@SuppressWarnings({"rawtypes", "unchecked"})
	private void registerNetworking(final RegisterPayloadHandlersEvent event) {
		final PayloadRegistrar registrar = event.registrar(MODID);
		MESSAGES.forEach((id, networkMessage) -> registrar.playBidirectional(id, ((NetworkMessage) networkMessage).reader(), ((NetworkMessage) networkMessage).handler()));
		networkingRegistered = true;
	}

	private static final Collection<Tuple<Runnable, Integer>> workQueue = new ConcurrentLinkedQueue<>();

	public static void queueServerWork(int tick, Runnable action) {
		if (Thread.currentThread().getThreadGroup() == SidedThreadGroups.SERVER)
			workQueue.add(new Tuple<>(action, tick));
	}

	@SubscribeEvent
	public void tick(ServerTickEvent.Post event) {
		List<Tuple<Runnable, Integer>> actions = new ArrayList<>();
		workQueue.forEach(work -> {
			work.setB(work.getB() - 1);
			if (work.getB() == 0)
				actions.add(work);
		});
		actions.forEach(e -> e.getA().run());
		workQueue.removeAll(actions);
	}
}
