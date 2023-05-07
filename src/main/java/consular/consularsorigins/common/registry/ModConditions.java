package consular.consularsorigins.common.registry;

import io.github.apace100.apoli.power.factory.condition.ConditionFactory;
import io.github.apace100.apoli.registry.ApoliRegistries;
import io.github.apace100.calio.data.SerializableData;
import consular.consularsorigins.common.ConsularsOrigins;
import consular.consularsorigins.common.condition.NearbyEntitiesCondition;
import net.minecraft.entity.Entity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Pair;

public class ModConditions {

	public static void register() {
        register(NearbyEntitiesCondition.createFactory());
    }

	public static final ConditionFactory<Entity> PIGLIN_SAFE = new ConditionFactory<>(new Identifier(ConsularsOrigins.MODID, "piglin_safe"), new SerializableData(), (instance, entity) -> entity.world.getDimension().piglinSafe());
	
	public static final ConditionFactory<Pair<DamageSource, Float>> CROSSBOW_ARROW = new ConditionFactory<>(new Identifier(ConsularsOrigins.MODID, "crossbow_arrow"), new SerializableData(), (instance, damageSourceFloatPair) -> damageSourceFloatPair.getLeft().getSource() instanceof PersistentProjectileEntity projectile && projectile.isShotFromCrossbow());
	
	public static void init() {
		Registry.register(ApoliRegistries.ENTITY_CONDITION, PIGLIN_SAFE.getSerializerId(), PIGLIN_SAFE);
		Registry.register(ApoliRegistries.DAMAGE_CONDITION, CROSSBOW_ARROW.getSerializerId(), CROSSBOW_ARROW);
	}

	private static void register(ConditionFactory<Entity> serializer) {
        Registry.register(ApoliRegistries.ENTITY_CONDITION, serializer.getSerializerId(), serializer);
    }
}
