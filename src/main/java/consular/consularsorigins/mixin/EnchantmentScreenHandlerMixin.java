package consular.consularsorigins.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import consular.consularsorigins.common.ConsularsOrigins;
import consular.consularsorigins.common.registry.ModPowers;

import org.spongepowered.asm.mixin.injection.At;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.EnchantmentScreenHandler;
import net.minecraft.screen.ScreenHandlerContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

@Mixin(EnchantmentScreenHandler.class)
public class EnchantmentScreenHandlerMixin {

    private PlayerEntity enchanter;

    @Inject(method = "<init>(ILnet/minecraft/entity/player/PlayerInventory;Lnet/minecraft/screen/ScreenHandlerContext;)V", at = @At("TAIL"))
    private void saveEnchanterInHandler(int syncId, PlayerInventory playerInventory, ScreenHandlerContext context, CallbackInfo ci) {
        this.enchanter = playerInventory.player;
    }

    @Inject(method = "method_17411", at = @At(value = "INVOKE", target = "Lnet/minecraft/screen/EnchantmentScreenHandler;generateEnchantments(Lnet/minecraft/item/ItemStack;II)Ljava/util/List;"))
    private void saveEnchanterForPreview(ItemStack stack, World world, BlockPos pos, CallbackInfo ci) {
        ConsularsOrigins.isEnchantlingEnchanting = ModPowers.BETTER_ENCHANTING.isActive(enchanter);
    }

    @Inject(method = "method_17410", at = @At(value = "INVOKE", target = "Lnet/minecraft/screen/EnchantmentScreenHandler;generateEnchantments(Lnet/minecraft/item/ItemStack;II)Ljava/util/List;"))
    private void saveEnchanter(ItemStack itemStack, int id, PlayerEntity playerEntity, int level, ItemStack stack2, World world, BlockPos pos, CallbackInfo ci) {
        ConsularsOrigins.isEnchantlingEnchanting = ModPowers.BETTER_ENCHANTING.isActive(playerEntity);
    }
}
