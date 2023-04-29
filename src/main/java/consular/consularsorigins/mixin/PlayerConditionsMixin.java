package consular.consularsorigins.mixin;

import io.github.apace100.apoli.power.factory.condition.EntityConditions;
import io.github.apace100.calio.data.SerializableData;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import consular.consularsorigins.common.registry.ModTags;

@Mixin(EntityConditions.class)
public class PlayerConditionsMixin {

    @Inject(method = "lambda$register$9", at = @At("HEAD"), cancellable = true)
    private static void sunDamagePrevention(SerializableData.Instance data, Entity player, CallbackInfoReturnable<Boolean> cir) {
        for (ItemStack stack : player.getHandItems()) {
            if (stack.isIn(ModTags.UMBRELLAS)) {
                cir.setReturnValue(false);
            }
        }
    }

    @Inject(method = "lambda$register$10", at = @At("HEAD"), cancellable = true)
    private static void umbrellaRainedOn(SerializableData.Instance data, Entity player, CallbackInfoReturnable<Boolean> cir) {
        for (ItemStack stack : player.getHandItems()) {
            if (stack.isIn(ModTags.UMBRELLAS)) {
                cir.setReturnValue(false);
            }
        }
    }


}
