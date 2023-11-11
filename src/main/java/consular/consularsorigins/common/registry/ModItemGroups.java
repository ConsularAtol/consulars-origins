package consular.consularsorigins.common.registry;

import consular.consularsorigins.common.ConsularsOrigins;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {

    private static final RegistryKey<ItemGroup> ORIGINS = RegistryKey.of(RegistryKeys.ITEM_GROUP, new Identifier(ConsularsOrigins.MODID, "origins"));
    
    public static void registerItemGroups(){
        Registry.register(Registries.ITEM_GROUP, ORIGINS, FabricItemGroup.builder()
            .icon(() -> new ItemStack(ModItems.GOLEMTOTEM))
            .displayName(Text.translatable("itemGroup.consularsorigins.origins"))
            .build());

        ItemGroupEvents.modifyEntriesEvent(ORIGINS).register(content -> {
            content.add(ModItems.GOLEMTOTEM_BOTTOM);
            content.add(ModItems.GOLEMTOTEM_TOPSHELL);
            content.add(ModItems.GOLEMTOTEM_TOP);
            content.add(ModItems.GOLEMTOTEM);
            content.add(ModItems.COFFIN);
            content.add(ModItems.RED_UMBRELLA);
            content.add(ModItems.BLUE_UMBRELLA);
            content.add(ModItems.LIGHT_BLUE_UMBRELLA);
            content.add(ModItems.CYAN_UMBRELLA);
            content.add(ModItems.LIME_UMBRELLA);
            content.add(ModItems.PINK_UMBRELLA);
            content.add(ModItems.BLACK_UMBRELLA);
            content.add(ModItems.GRAY_UMBRELLA);
            content.add(ModItems.LIGHT_GRAY_UMBRELLA);
            content.add(ModItems.WHITE_UMBRELLA);
            content.add(ModItems.BROWN_UMBRELLA);
            content.add(ModItems.GREEN_UMBRELLA);
            content.add(ModItems.ORANGE_UMBRELLA);
            content.add(ModItems.PURPLE_UMBRELLA);
            content.add(ModItems.MAGENTA_UMBRELLA);
            content.add(ModItems.YELLOW_UMBRELLA);
        });
    }
}
