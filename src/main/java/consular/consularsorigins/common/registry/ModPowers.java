package consular.consularsorigins.common.registry;

import io.github.apace100.apoli.power.Power;
import io.github.apace100.apoli.power.PowerType;
import io.github.apace100.apoli.power.PowerTypeReference;
import io.github.apace100.apoli.power.factory.PowerFactory;
import io.github.apace100.apoli.registry.ApoliRegistries;
import io.github.apace100.calio.data.SerializableData;
import io.github.apace100.calio.data.SerializableDataTypes;
import consular.consularsorigins.common.ConsularsOrigins;
import consular.consularsorigins.common.power.MobNeutralityPower;
import consular.consularsorigins.common.power.ModifySizePower;
import net.minecraft.util.Identifier;
import net.minecraft.registry.Registry;
import virtuoel.pehkui.api.ScaleRegistries;

import java.util.Collections;

public class ModPowers {

	public static final PowerFactory<Power> MODIFY_SIZE = new PowerFactory<>(new Identifier(ConsularsOrigins.MODID, "modify_size"), new SerializableData().add("scale_types", SerializableDataTypes.IDENTIFIERS, Collections.singletonList(ScaleRegistries.getId(ScaleRegistries.SCALE_TYPES, ModScaleTypes.MODIFY_SIZE_TYPE))).add("scale", SerializableDataTypes.FLOAT), data -> (type, entity) -> new ModifySizePower(type, entity, data.get("scale_types"), data.getFloat("scale"))).allowCondition();
	
	public static final PowerType<Power> BETTER_ENCHANTING = new PowerTypeReference<>(new Identifier(ConsularsOrigins.MODID, "better_enchanting"));

	public static final PowerType<Power> SILK_TOUCH = new PowerTypeReference<>(new Identifier(ConsularsOrigins.MODID, "silk_touch"));

	public static final PowerType<Power> PEP_IN_YOUR_STEP = new PowerTypeReference<>(new Identifier(ConsularsOrigins.MODID, "pep_in_your_step"));
	
	public static void init() {
		Registry.register(ApoliRegistries.POWER_FACTORY, MODIFY_SIZE.getSerializerId(), MODIFY_SIZE);
		register(MobNeutralityPower.getFactory());
	}

	public static void register(PowerFactory<?> serializer) {
        Registry.register(ApoliRegistries.POWER_FACTORY, serializer.getSerializerId(), serializer);
    }
}
