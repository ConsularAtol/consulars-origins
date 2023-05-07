package consular.consularsorigins.common.condition;

import consular.consularsorigins.common.ConsularsOrigins;
import io.github.apace100.apoli.data.ApoliDataTypes;
import io.github.apace100.apoli.power.factory.condition.ConditionFactory;
import io.github.apace100.apoli.util.Comparison;
import io.github.apace100.calio.data.SerializableData;
import io.github.apace100.calio.data.SerializableDataTypes;
import net.minecraft.entity.Entity;
import net.minecraft.util.Pair;

import java.util.function.Predicate;

public class NearbyEntitiesCondition {
    public static ConditionFactory<Entity> createFactory() {
        return new ConditionFactory<>(ConsularsOrigins.id("nearby_entities"), new SerializableData()
                .add("radius", SerializableDataTypes.DOUBLE)
                .add("comparison", ApoliDataTypes.COMPARISON)
                .add("compare_to", SerializableDataTypes.INT)
                .add("bientity_condition", ApoliDataTypes.BIENTITY_CONDITION, null),
                (data, entity) -> {
                    Predicate<Pair<Entity, Entity>> bientityCondition = data.get("bientity_condition");
                    int amount = entity.getWorld().getOtherEntities(entity, entity.getBoundingBox().expand(data.getDouble("radius")), otherEntity -> bientityCondition.test(new Pair<>(entity, otherEntity))).size();
                    Comparison comparison = data.get("comparison");
                    int compareTo = data.getInt("compare_to");
                    return comparison.compare(amount, compareTo);
                });
    }
}
