package consular.consularsorigins.common.power;

import io.github.apace100.apoli.power.Power;
import io.github.apace100.apoli.power.PowerType;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LegacyMobNeutralityPower extends Power {
	private final Set<EntityType<?>> entityTypes = new HashSet<>();
	private final boolean inverted;

	@Deprecated
	public LegacyMobNeutralityPower(PowerType<?> type, LivingEntity entity, List<EntityType<?>> entityTypes, boolean inverted) {
		super(type, entity);
		this.entityTypes.addAll(entityTypes);
		this.inverted = inverted;
	}
	
	@Deprecated
	public boolean shouldBeNeutral(EntityType<?> entityType) {
		if (inverted) {
			return !entityTypes.contains(entityType);
		}
		return entityTypes.contains(entityType);
	}
}
