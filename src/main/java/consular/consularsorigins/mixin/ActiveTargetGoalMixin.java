package consular.consularsorigins.mixin;

import io.github.apace100.apoli.component.PowerHolderComponent;
import consular.consularsorigins.common.power.MobNeutralityPower;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.ActiveTargetGoal;
import net.minecraft.entity.ai.goal.TrackTargetGoal;
import net.minecraft.entity.mob.MobEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

import java.util.function.Predicate;

@Mixin(ActiveTargetGoal.class)
public abstract class ActiveTargetGoalMixin<T extends LivingEntity> extends TrackTargetGoal {
	public ActiveTargetGoalMixin(MobEntity mob, boolean checkVisibility) {
		super(mob, checkVisibility);
	}

	@ModifyArg(method = "<init>(Lnet/minecraft/entity/mob/MobEntity;Ljava/lang/Class;IZZLjava/util/function/Predicate;)V", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/ai/TargetPredicate;setPredicate(Ljava/util/function/Predicate;)Lnet/minecraft/entity/ai/TargetPredicate;"))
	private Predicate<LivingEntity> consularsorigins$mobNeutrality(Predicate<LivingEntity> value) {
		if (value != null) {
			value = value.and(targetPredicate -> {
				for (MobNeutralityPower mobNeutralityPower : PowerHolderComponent.getPowers(target, MobNeutralityPower.class)) {
					if (mobNeutralityPower.shouldBeNeutral(mob.getType())) {
						return false;
					}
				}
				return true;
			});
		}
		return value;
	}
}
