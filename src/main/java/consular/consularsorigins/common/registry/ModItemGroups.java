package consular.consularsorigins.common.registry;

import consular.consularsorigins.common.ConsularsOrigins;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class ModItemGroups {

    public static final ItemGroup ORIGINS = FabricItemGroup
    .builder(new Identifier(ConsularsOrigins.MODID, "origins"))
    .icon(() -> new ItemStack(ModItems.GOLEMTOTEM))
    .entries((enabledFeatures, entries, operatorEnabled) -> {
        entries.add(ModItems.GOLEMTOTEM_BOTTOM);
        entries.add(ModItems.GOLEMTOTEM_TOPSHELL);
        entries.add(ModItems.GOLEMTOTEM_TOP);
        entries.add(ModItems.GOLEMTOTEM);
        entries.add(ModItems.COFFIN);
        entries.add(ModItems.RED_UMBRELLA);
        entries.add(ModItems.BLUE_UMBRELLA);
        entries.add(ModItems.LIGHT_BLUE_UMBRELLA);
        entries.add(ModItems.CYAN_UMBRELLA);
        entries.add(ModItems.LIME_UMBRELLA);
        entries.add(ModItems.PINK_UMBRELLA);
        entries.add(ModItems.BLACK_UMBRELLA);
        entries.add(ModItems.GRAY_UMBRELLA);
        entries.add(ModItems.LIGHT_GRAY_UMBRELLA);
        entries.add(ModItems.WHITE_UMBRELLA);
        entries.add(ModItems.BROWN_UMBRELLA);
        entries.add(ModItems.GREEN_UMBRELLA);
        entries.add(ModItems.ORANGE_UMBRELLA);
        entries.add(ModItems.PURPLE_UMBRELLA);
        entries.add(ModItems.MAGENTA_UMBRELLA);
        entries.add(ModItems.YELLOW_UMBRELLA);
    }).build();

    public static void registerItemGroups(){
        System.out.println("Registering item groups");
    }
}
