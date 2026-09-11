package net.hackermdch.pgc.export;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.stream.JsonWriter;
import com.mojang.brigadier.arguments.StringArgumentType;
import net.minecraft.ChatFormatting;
import net.minecraft.Util;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.commands.SharedSuggestionProvider;
import net.minecraft.commands.arguments.ResourceArgument;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.RegisterCommandsEvent;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;
import static net.mcreator.ceshi.PrimogemcraftMod.MODID;

@EventBusSubscriber
public class ItemExporter {
    private static final String destDirRoot = "F:/Else Language/Java/PrimogemCraftNeo";
    private static final String registerFile = destDirRoot + "/src/main/java/net/per/primogemcraft/registry/PGCItems.java";
    private static final String SOURCE_ID = MODID;
    private static final String DEST_ID = MODID;

    private static String getName(String path, Holder<Item> item) {
        try (var in = new FileInputStream(path)) {
            var json = new Gson().fromJson(new InputStreamReader(in), JsonObject.class);
            return json.get(item.value().getDescriptionId()).getAsString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @SuppressWarnings("unchecked")
    static void process(String path, String name, String prefix, ResourceLocation rename) {
        try (var raf = new RandomAccessFile(path, "rw")) {
            var json = (LinkedMap<String, String>) new Gson().fromJson(new InputStreamReader(new FileInputStream(raf.getFD())), LinkedMap.class);
            var it = json.iterator();
            var flag = false;
            var flag2 = false;
            var id = Util.makeDescriptionId(prefix, rename);
            while (it.hasNext()) {
                var e = it.next();
                if (e.getKey().equals(id)) break;
                if (e.getKey().startsWith(prefix + ".")) flag = true;
                else if (flag) {
                    it.insert(id, name);
                    flag2 = true;
                    break;
                }
            }
            if (!flag2) json.put(id, name);
            try (var out = new FileOutputStream(raf.getFD())) {
                raf.setLength(0);
                raf.seek(0);
                var w = new JsonWriter(new OutputStreamWriter(out, StandardCharsets.UTF_8));
                w.setIndent("  ");
                new GsonBuilder().disableHtmlEscaping().create().toJson(json, LinkedMap.class, w);
                w.flush();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    static void copyTexture(Holder<Item> item, CommandSourceStack source, ResourceLocation rename) {
        try (var in = new FileInputStream("../src/main/resources/assets/" + SOURCE_ID + "/models/item/" + item.unwrapKey().orElseThrow().location().getPath() + ".json")) {
            var json = new Gson().fromJson(new InputStreamReader(in), JsonObject.class);
            if (!json.get("parent").getAsString().equals("item/generated")) {
                if (json.get("parent").getAsString().startsWith(SOURCE_ID + ":block/")) {
                    json.addProperty("parent", DEST_ID + ":block/" + rename.getPath());
                } else {
                    source.sendSystemMessage(Component.literal("特殊模型").withStyle(ChatFormatting.RED));
                    return;
                }
            } else {
                var tex = ResourceLocation.parse(json.get("textures").getAsJsonObject().get("layer0").getAsString());
                var tp = Path.of("../src/main/resources/assets/" + SOURCE_ID + "/textures/", tex.getPath() + ".png");
                var dtp = Path.of(destDirRoot + "/src/main/resources/assets/" + DEST_ID + "/textures/item/", rename.getPath() + ".png");
                Files.copy(tp, dtp, REPLACE_EXISTING);
                var meta = Path.of(tp + ".mcmeta");
                if (Files.exists(meta)) Files.copy(meta, Path.of(dtp + ".mcmeta"), REPLACE_EXISTING);
                json.get("textures").getAsJsonObject().addProperty("layer0", rename.withPath("item/" + rename.getPath()).toString());
            }
            try (var out = new FileOutputStream(destDirRoot + "/src/main/resources/assets/" + DEST_ID + "/models/item/" + rename.getPath() + ".json")) {
                var w = new JsonWriter(new OutputStreamWriter(out, StandardCharsets.UTF_8));
                w.setIndent("  ");
                new GsonBuilder().disableHtmlEscaping().create().toJson(json, w);
                w.flush();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static void appendRegister(String name) {
        try (var in = new FileInputStream(registerFile)) {
            var br = new BufferedReader(new InputStreamReader(in));
            var sb = new StringBuilder();
            br.lines().forEach(line -> {
                if (line.trim().equals("}")) {
                    sb.append("public static final DeferredItem<Item> ");
                    sb.append(name);
                    sb.append("= REGISTRY.register(\"");
                    sb.append(name);
                    sb.append("\", () -> new Item(new Item.Properties()));\n");
                }
                sb.append(line);
                sb.append('\n');
            });
            in.close();
            try (var out = new FileOutputStream(registerFile)) {
                var ow = new OutputStreamWriter(out);
                ow.write(sb.toString());
                ow.flush();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @SubscribeEvent
    private static void on(RegisterCommandsEvent event) {
        event.getDispatcher().register(Commands.literal("exportItem").then(Commands.argument("id", ResourceArgument.resource(event.getBuildContext(), Registries.ITEM)).suggests((c, b) -> SharedSuggestionProvider.suggestResource(BuiltInRegistries.ITEM.stream().filter(i -> BuiltInRegistries.ITEM.getKey(i).getNamespace().equals(SOURCE_ID)), b, BuiltInRegistries.ITEM::getKey, Item::getDescription)).then(Commands.argument("rename", StringArgumentType.string()).suggests((c, b) -> b.suggest(ResourceArgument.getResource(c, "id", Registries.ITEM).key().location().getPath()).buildFuture()).executes(c -> {
            var item = ResourceArgument.getResource(c, "id", Registries.ITEM);
            var rename = ResourceLocation.fromNamespaceAndPath(DEST_ID, StringArgumentType.getString(c, "rename"));
            var en_name = getName("../src/main/resources/assets/" + SOURCE_ID + "/lang/en_us.json", item);
            var zh_name = getName("../src/main/resources/assets/" + SOURCE_ID + "/lang/zh_cn.json", item);
            c.getSource().sendSystemMessage(Component.literal(en_name));
            c.getSource().sendSystemMessage(Component.literal(zh_name));
            process(destDirRoot + "/src/main/resources/assets/" + DEST_ID + "/lang/en_us.json", en_name, "item", rename);
            process(destDirRoot + "/src/main/resources/assets/" + DEST_ID + "/lang/zh_cn.json", zh_name, "item", rename);
            copyTexture(item, c.getSource(), rename);
            appendRegister(rename.getPath());
            return 0;
        }))));
    }
}
