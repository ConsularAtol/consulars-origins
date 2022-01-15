package consular.consularsorigins.common;

import consular.consularsorigins.common.network.packet.BoneMealPacket;
import consular.consularsorigins.common.registry.ModConditions;
import consular.consularsorigins.common.registry.ModPowers;
import consular.consularsorigins.common.registry.ModScaleTypes;
import consular.consularsorigins.common.registry.ModItems;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class ConsularsOrigins implements ModInitializer {
	public static final String MODID = "consularsorigins";
	
	public static final ItemGroup CONSULARS = FabricItemGroupBuilder.build(
		new Identifier(MODID, "origins"),
		() -> new ItemStack(ModItems.GOLEMTOTEM)
	);

	@Override
	public void onInitialize() {
		ModItems.registerItems();
		ModScaleTypes.init();
		ModPowers.init();
		ModConditions.init();
		ServerPlayNetworking.registerGlobalReceiver(BoneMealPacket.ID, BoneMealPacket::receive);
	};
}