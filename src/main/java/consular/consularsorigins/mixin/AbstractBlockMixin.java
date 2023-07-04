package consular.consularsorigins.mixin;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.LootTables;
import net.minecraft.loot.context.LootContextParameterSet;
import net.minecraft.loot.context.LootContextParameters;
import net.minecraft.loot.context.LootContextTypes;
import net.minecraft.registry.Registries;
import net.minecraft.registry.tag.BlockTags;
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
    }

    @Inject(method = "getDroppedStacks", at = @At("RETURN"))
    private List<ItemStack> silkTouch(BlockState state, LootContextParameterSet.Builder builder, CallbackInfoReturnable cir){
            ConsularsOrigins.isKoboldMining = ModPowers.SILK_TOUCH.isActive(player);
            ConsularsOrigins.isHalflingPicking = ModPowers.CAREFUL_PICKER.isActive(player);
            if (ConsularsOrigins.isKoboldMining){
                List<ItemStack> droppedStacks = new ArrayList<ItemStack>();
                droppedStacks.add(state.getBlock().asItem().getDefaultStack());
                return droppedStacks;
            }
            else
            if (ConsularsOrigins.isHalflingPicking && state.isIn(BlockTags.LEAVES)){
                List<ItemStack> droppedStacks = new ArrayList<ItemStack>();
                Double random = Math.random();
                //if (random > 0.5) {
                    Item sapling = getMatchingSapling(state.getBlock());
                    System.out.println(sapling);
                    if (sapling != null) {
                        ItemStack saplingStack = new ItemStack(sapling);
                        droppedStacks.add(saplingStack);
                    }
                //}
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

    private Item getMatchingSapling(Block leafBlock) {
        Identifier leafIdentifier = Registries.BLOCK.getId(leafBlock);
        String leafBlockName = leafIdentifier.getPath();

        // Remove "leaves" from the block name and append "_sapling"
        String saplingBlockName = leafBlockName.replace("leaves", "") + "sapling";

        // Create the sapling identifier using the same namespace as the leaf block
        Identifier saplingIdentifier = new Identifier(saplingBlockName);
        System.out.println(saplingBlockName);
        System.out.println(saplingIdentifier);

        return Registries.ITEM.getOrEmpty(saplingIdentifier).orElse(null);
    }
}
