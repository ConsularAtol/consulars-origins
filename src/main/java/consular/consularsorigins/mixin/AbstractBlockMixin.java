package consular.consularsorigins.mixin;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.LootTables;
import net.minecraft.loot.context.LootContextParameterSet;
import net.minecraft.loot.context.LootContextParameters;
import net.minecraft.loot.context.LootContextTypes;
import net.minecraft.resource.featuretoggle.ToggleableFeature;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import consular.consularsorigins.common.ConsularsOrigins;
import consular.consularsorigins.common.registry.ModPowers;

import org.spongepowered.asm.mixin.injection.At;

@Mixin(AbstractBlock.class)
public abstract class AbstractBlockMixin implements ToggleableFeature{

    PlayerEntity player;

    @Inject(method =  "onBlockBreakStart", at = @At("HEAD"))
    public void playerAccessor(BlockState state, World world, BlockPos pos, PlayerEntity player, CallbackInfo ci) {
        this.player = player;
        System.out.println(player);
    }

    @Inject(method = "getDroppedStacks", at = @At("RETURN"))
    private List<ItemStack> getDroppedStacks(BlockState state, LootContextParameterSet.Builder builder, CallbackInfoReturnable cir){
            ConsularsOrigins.isKoboldMining = ModPowers.SILK_TOUCH.isActive(player);
            System.out.println(ConsularsOrigins.isKoboldMining);
            if (ConsularsOrigins.isKoboldMining){
                List<ItemStack> droppedStacks = new ArrayList<ItemStack>();
                droppedStacks.add(state.getBlock().asItem().getDefaultStack());
                return droppedStacks;
            }
            else{
                Identifier identifier = state.getBlock().getLootTableId();
                if (identifier == LootTables.EMPTY) {
                    return Collections.emptyList();
                }
            LootContextParameterSet lootContextParameterSet = builder.add(LootContextParameters.BLOCK_STATE, state).build(LootContextTypes.BLOCK);
            ServerWorld serverWorld = lootContextParameterSet.getWorld();
            LootTable lootTable = serverWorld.getServer().getLootManager().getLootTable(identifier);
            return lootTable.generateLoot(lootContextParameterSet);
        }
    }
}
