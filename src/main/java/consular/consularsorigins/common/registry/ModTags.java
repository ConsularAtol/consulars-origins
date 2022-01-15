package consular.consularsorigins.common.registry;

import consular.consularsorigins.common.ConsularsOrigins;
import net.fabricmc.fabric.api.tag.TagFactory;
import net.minecraft.item.Item;
import net.minecraft.tag.Tag;
import net.minecraft.util.Identifier;

public class ModTags {
	public static final Tag<Item> GOLDEN_ARMOR = TagFactory.ITEM.create(new Identifier(ConsularsOrigins.MODID, "golden_armor"));
	public static final Tag<Item> GOLDEN_TOOLS = TagFactory.ITEM.create(new Identifier(ConsularsOrigins.MODID, "golden_tools"));
	public static final Tag<Item> NETHERITE_ARMOR = TagFactory.ITEM.create(new Identifier(ConsularsOrigins.MODID, "netherite_armor"));
	public static final Tag<Item> NETHERITE_TOOLS = TagFactory.ITEM.create(new Identifier(ConsularsOrigins.MODID, "netherite_tools"));
}
