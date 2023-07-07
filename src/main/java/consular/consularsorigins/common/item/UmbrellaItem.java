package consular.consularsorigins.common.item;

import java.util.List;

import org.jetbrains.annotations.Nullable;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;

public class UmbrellaItem extends Item{

    public UmbrellaItem(Settings settings) {
        super(settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable("tooltip.consularsorigins.sun_protection").formatted(Formatting.BLUE));
        tooltip.add(Text.translatable("tooltip.consularsorigins.rain_protection").formatted(Formatting.BLUE));
    }
    
}
