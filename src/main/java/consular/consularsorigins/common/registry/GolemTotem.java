package consular.consularsorigins.common.registry;

import net.minecraft.item.ItemStack;

public class GolemTotem {
    public void appendTooltip(ItemStack itemStack, World world, List<Text> list, TooltipContext tooltipContext) {
        list.add(new TranslatableText("classes.class.melee"));
    }
}
