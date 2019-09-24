package advsolar.utils;

import net.minecraft.item.ItemStack;

public class ItemStackUtil {
    public static boolean areStacksEqual(ItemStack first, ItemStack second) {
        if (first != null && second != null) {
            return first.getItem() == second.getItem() && (first.getItemDamage() == second.getItemDamage() || first.getItemDamage() == 32767 || second.getItemDamage() == 32767);
        } else {
            return false;
        }
    }
}
