package consular.consularsorigins.common.registry;

import consular.consularsorigins.common.ConsularsOrigins;
import net.minecraft.item.Item;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.registry.RegistryKeys;

public class ModTags {
	public static final TagKey<Item> GOLDEN_ARMOR = TagKey.of(RegistryKeys.ITEM, new Identifier(ConsularsOrigins.MODID, "golden_armor"));
	public static final TagKey<Item> GOLDEN_TOOLS = TagKey.of(RegistryKeys.ITEM, new Identifier(ConsularsOrigins.MODID, "golden_tools"));
	public static final TagKey<Item> NETHERITE_ARMOR = TagKey.of(RegistryKeys.ITEM, new Identifier(ConsularsOrigins.MODID, "netherite_armor"));
	public static final TagKey<Item> NETHERITE_TOOLS = TagKey.of(RegistryKeys.ITEM, new Identifier(ConsularsOrigins.MODID, "netherite_tools"));
	public static final TagKey<Item> UMBRELLAS = TagKey.of(RegistryKeys.ITEM, new Identifier(ConsularsOrigins.MODID, "umbrellas"));
}
