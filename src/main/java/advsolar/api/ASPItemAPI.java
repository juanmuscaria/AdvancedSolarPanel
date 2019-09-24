package advsolar.api;

import cpw.mods.fml.common.FMLLog;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.lang.reflect.Field;

public class ASPItemAPI {
    private static Class aspClass = null;
    private static boolean inited = false;

    private static void lazyInit() {
        if (!inited) {
            try {
                aspClass = Class.forName("advsolar.common.AdvancedSolarPanel");
            } catch (Exception var1) {
                FMLLog.severe("Fatal exception hapenned when tried to instantiate ASP API.");
            }

            inited = true;
        }

    }

    public static ItemStack get(String name) {
        lazyInit();

        try {
            Field fField = aspClass.getField(name);
            Object retObj = fField.get((Object) null);
            if (retObj instanceof ItemStack) {
                return ((ItemStack) retObj).copy();
            } else if (retObj instanceof Item) {
                return (new ItemStack((Item) retObj)).copy();
            } else {
                return retObj instanceof Block ? (new ItemStack((Block) retObj)).copy() : null;
            }
        } catch (Exception var3) {
            throw new RuntimeException(var3);
        }
    }
}
