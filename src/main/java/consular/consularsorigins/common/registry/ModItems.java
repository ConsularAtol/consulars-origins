package consular.consularsorigins.common.registry;

import consular.consularsorigins.common.ConsularsOrigins;
import net.minecraft.item.Item;
//import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems{
    public static final Item GOLEMTOTEM_BOTTOM = new Item(new Item.Settings().group(ConsularsOrigins.CONSULARS)); 
	public static final Item GOLEMTOTEM_TOP = new Item(new Item.Settings().group(ConsularsOrigins.CONSULARS)); 
	public static final Item GOLEMTOTEM_TOPSHELL = new Item(new Item.Settings().group(ConsularsOrigins.CONSULARS));
    public static final Item GOLEMTOTEM = new Item(new Item.Settings().group(ConsularsOrigins.CONSULARS));
    public static final Item RED_UMBRELLA = new Item(new Item.Settings().group(ConsularsOrigins.CONSULARS));
    public static final Item BLACK_UMBRELLA = new Item(new Item.Settings().group(ConsularsOrigins.CONSULARS));
    public static final Item BROWN_UMBRELLA = new Item(new Item.Settings().group(ConsularsOrigins.CONSULARS));
    public static final Item GREEN_UMBRELLA = new Item(new Item.Settings().group(ConsularsOrigins.CONSULARS));
    public static final Item WHITE_UMBRELLA = new Item(new Item.Settings().group(ConsularsOrigins.CONSULARS));
    public static final Item YELLOW_UMBRELLA = new Item(new Item.Settings().group(ConsularsOrigins.CONSULARS));
    public static final Item LIGHT_BLUE_UMBRELLA = new Item(new Item.Settings().group(ConsularsOrigins.CONSULARS));
    public static final Item LIGHT_GRAY_UMBRELLA = new Item(new Item.Settings().group(ConsularsOrigins.CONSULARS));
    public static final Item LIME_UMBRELLA = new Item(new Item.Settings().group(ConsularsOrigins.CONSULARS));
    public static final Item MAGENTA_UMBRELLA = new Item(new Item.Settings().group(ConsularsOrigins.CONSULARS));
    public static final Item ORANGE_UMBRELLA = new Item(new Item.Settings().group(ConsularsOrigins.CONSULARS));
    public static final Item PINK_UMBRELLA = new Item(new Item.Settings().group(ConsularsOrigins.CONSULARS));
    public static final Item CYAN_UMBRELLA = new Item(new Item.Settings().group(ConsularsOrigins.CONSULARS));
    public static final Item GRAY_UMBRELLA = new Item(new Item.Settings().group(ConsularsOrigins.CONSULARS));
    public static final Item PURPLE_UMBRELLA = new Item(new Item.Settings().group(ConsularsOrigins.CONSULARS));
    public static final Item COFFIN = new Item(new Item.Settings().group(ConsularsOrigins.CONSULARS));

    public static void registerItems(){
        Registry.register(Registry.ITEM, new Identifier(ConsularsOrigins.MODID,"golemtotem_bottom"), GOLEMTOTEM_BOTTOM);
		Registry.register(Registry.ITEM, new Identifier(ConsularsOrigins.MODID,"golemtotem_top"), GOLEMTOTEM_TOP);
		Registry.register(Registry.ITEM, new Identifier(ConsularsOrigins.MODID,"golemtotem_topshell"), GOLEMTOTEM_TOPSHELL);
        Registry.register(Registry.ITEM, new Identifier(ConsularsOrigins.MODID,"golemtotem"), GOLEMTOTEM);
        Registry.register(Registry.ITEM, new Identifier(ConsularsOrigins.MODID,"red_umbrella"), RED_UMBRELLA);
        Registry.register(Registry.ITEM, new Identifier(ConsularsOrigins.MODID,"black_umbrella"), BLACK_UMBRELLA);
        Registry.register(Registry.ITEM, new Identifier(ConsularsOrigins.MODID,"brown_umbrella"), BROWN_UMBRELLA);
        Registry.register(Registry.ITEM, new Identifier(ConsularsOrigins.MODID,"green_umbrella"), GREEN_UMBRELLA);
        Registry.register(Registry.ITEM, new Identifier(ConsularsOrigins.MODID,"white_umbrella"), WHITE_UMBRELLA);
        Registry.register(Registry.ITEM, new Identifier(ConsularsOrigins.MODID,"yellow_umbrella"), YELLOW_UMBRELLA);
        Registry.register(Registry.ITEM, new Identifier(ConsularsOrigins.MODID,"light_blue_umbrella"), LIGHT_BLUE_UMBRELLA);
        Registry.register(Registry.ITEM, new Identifier(ConsularsOrigins.MODID,"light_gray_umbrella"), LIGHT_GRAY_UMBRELLA);
        Registry.register(Registry.ITEM, new Identifier(ConsularsOrigins.MODID,"lime_umbrella"), LIME_UMBRELLA);
        Registry.register(Registry.ITEM, new Identifier(ConsularsOrigins.MODID,"magenta_umbrella"), MAGENTA_UMBRELLA);
        Registry.register(Registry.ITEM, new Identifier(ConsularsOrigins.MODID,"orange_umbrella"), ORANGE_UMBRELLA);
        Registry.register(Registry.ITEM, new Identifier(ConsularsOrigins.MODID,"pink_umbrella"), PINK_UMBRELLA);
        Registry.register(Registry.ITEM, new Identifier(ConsularsOrigins.MODID,"cyan_umbrella"), CYAN_UMBRELLA);
        Registry.register(Registry.ITEM, new Identifier(ConsularsOrigins.MODID,"gray_umbrella"), GRAY_UMBRELLA);
        Registry.register(Registry.ITEM, new Identifier(ConsularsOrigins.MODID,"purple_umbrella"), PURPLE_UMBRELLA);
        Registry.register(Registry.ITEM, new Identifier(ConsularsOrigins.MODID,"coffin"), COFFIN);
    }
}