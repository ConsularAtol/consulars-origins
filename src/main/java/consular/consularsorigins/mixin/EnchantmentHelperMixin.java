package consular.consularsorigins.mixin;

import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

import consular.consularsorigins.common.ConsularsOrigins;

import org.spongepowered.asm.mixin.Mixin;

import net.minecraft.enchantment.EnchantmentHelper;

@Mixin(EnchantmentHelper.class)
public class EnchantmentHelperMixin {

    @ModifyVariable(method = "generateEnchantments", at = @At(value = "INVOKE_ASSIGN", target = "Lnet/minecraft/item/Item;getEnchantability()I"), ordinal = 0)
    private static int modifyEnchantabilityForClerics(int original) {
        if(original > 0 && ConsularsOrigins.isEnchantlingEnchanting) {
            ConsularsOrigins.isEnchantlingEnchanting = false;
            return original + 10;
        }
        return original;
    }
}
