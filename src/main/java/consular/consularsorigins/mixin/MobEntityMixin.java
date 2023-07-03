package consular.consularsorigins.mixin;

import io.github.apace100.apoli.component.PowerHolderComponent;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

import consular.consularsorigins.common.power.MobNeutralityPower;

import java.util.List;

@Mixin(MobEntity.class)
public abstract class MobEntityMixin extends LivingEntity {
    protected MobEntityMixin(EntityType<? extends LivingEntity> type, World level) {
        super(type, level);
    }

    @ModifyVariable(method = "setTarget", at = @At("HEAD"))
    private LivingEntity modifyTarget(LivingEntity target) {
        if (this.getWorld().isClient() || !(target instanceof PlayerEntity)) {
            return target;
        }

        List<MobNeutralityPower> powers = PowerHolderComponent.getPowers(target, MobNeutralityPower.class);
        boolean shouldIgnore = powers.stream().anyMatch(power -> power.shouldIgnore(this));

        return shouldIgnore ? null : target;
    }
}