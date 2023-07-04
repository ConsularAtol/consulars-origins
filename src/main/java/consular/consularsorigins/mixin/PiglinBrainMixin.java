package consular.consularsorigins.mixin;

import io.github.apace100.apoli.component.PowerHolderComponent;
import consular.consularsorigins.common.power.LegacyMobNeutralityPower;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.PiglinBrain;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PiglinBrain.class)
public class PiglinBrainMixin {
	@Inject(method = "wearsGoldArmor", at = @At("HEAD"), cancellable = true)
	private static void consularsorigins$mobNeutrality(LivingEntity target, CallbackInfoReturnable<Boolean> cir) {
		PowerHolderComponent.getPowers(target, LegacyMobNeutralityPower.class).forEach(mobNeutralityPower -> {
			if (mobNeutralityPower.shouldBeNeutral(EntityType.PIGLIN)) {
				cir.setReturnValue(true);
			}
		});
	}

	@Inject(method = "onGuardedBlockInteracted", at = @At("HEAD"), cancellable = true)
	private static void consularsorigins$mobNeutrality(PlayerEntity player, boolean blockOpen, CallbackInfo ci) {
		PowerHolderComponent.getPowers(player, LegacyMobNeutralityPower.class).forEach(mobNeutralityPower -> {
			if (mobNeutralityPower.shouldBeNeutral(EntityType.PIGLIN)) {
				ci.cancel();
			}
		});
	}
}
