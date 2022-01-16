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

    public static void registerItems(){
        Registry.register(Registry.ITEM, new Identifier(ConsularsOrigins.MODID,"golemtotem_bottom"), GOLEMTOTEM_BOTTOM);
		Registry.register(Registry.ITEM, new Identifier(ConsularsOrigins.MODID,"golemtotem_top"), GOLEMTOTEM_TOP);
		Registry.register(Registry.ITEM, new Identifier(ConsularsOrigins.MODID,"golemtotem_topshell"), GOLEMTOTEM_TOPSHELL);
        Registry.register(Registry.ITEM, new Identifier(ConsularsOrigins.MODID,"golemtotem"), GOLEMTOTEM);
    }
}