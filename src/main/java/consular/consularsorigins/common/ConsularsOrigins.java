package consular.consularsorigins.common;

import consular.consularsorigins.common.network.packet.BoneMealPacket;
import consular.consularsorigins.common.registry.ModConditions;
import consular.consularsorigins.common.registry.ModItemGroups;
import consular.consularsorigins.common.registry.ModPowers;
import consular.consularsorigins.common.registry.ModScaleTypes;
import consular.consularsorigins.common.registry.ModItems;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.util.Identifier;

public class ConsularsOrigins implements ModInitializer {
	public static final String MODID = "consularsorigins";

	public static boolean isEnchantlingEnchanting;

	public static Identifier id(String path) {
        return new Identifier(MODID, path);
    }

	@Override
	public void onInitialize() {
		ModItems.registerItems();
		ModScaleTypes.init();
		ModPowers.init();
		ModConditions.init();
		ModConditions.register();
		ModItemGroups.registerItemGroups();
		ServerPlayNetworking.registerGlobalReceiver(BoneMealPacket.ID, BoneMealPacket::receive);
	};
}