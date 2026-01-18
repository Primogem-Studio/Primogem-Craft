package net.hackermdch.pgc.rei;

import com.google.common.collect.ImmutableList;
import net.minecraft.network.chat.Component;
import net.minecraft.server.packs.resources.ResourceManagerReloadListener;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModList;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterClientReloadListenersEvent;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static net.mcreator.ceshi.PrimogemcraftMod.MODID;

@EventBusSubscriber(modid = MODID)
public record Information(String code, String name, List<String> items, List<Component> lines) {
    @SubscribeEvent
    private static void onRegisterClientReloadListeners(RegisterClientReloadListenersEvent event) {
        if (!ModList.get().isLoaded("roughlyenoughitems")) return;
        event.registerReloadListener((ResourceManagerReloadListener) (resourceManager) -> {
            var infos = resourceManager.listResources("rei_info", id -> id.getPath().endsWith(".txt"));
            var builder = ImmutableList.<Information>builder();
            for (var it : infos.entrySet()) {
                try (var br = it.getValue().openAsReader()) {
                    var lines = br.lines().toList();
                    var items = Arrays.stream(lines.getFirst().split(",")).map(String::trim).toList();
                    var components = ImmutableList.<Component>builder();
                    for (int i = 1; i < lines.size(); i++) components.add(Component.literal(lines.get(i)));
                    var path = it.getKey().getPath();
                    path = path.substring(path.indexOf('/') + 1);
                    var code = path.substring(0, path.indexOf('/'));
                    path = path.substring(path.indexOf('/') + 1);
                    path = path.substring(0, path.lastIndexOf('.'));
                    builder.add(new Information(code, it.getKey().withPath(path).toString(), items, components.build()));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            PGCClientPlugin.updateInfo(builder.build());
        });
    }
}
