package advsolar.common.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemMolecularTransformer extends ItemBlock {
    public ItemMolecularTransformer(Block b) {
        super(b);
        this.setMaxDamage(0);
        this.setHasSubtypes(false);
    }

    public String getUnlocalizedName(ItemStack itemstack) {
        return "blockMolecularTransformer";
    }

    public int getMetadata(int i) {
        return i;
    }

    @SideOnly(Side.CLIENT)
    public EnumRarity getRarity(ItemStack itemstack) {
        return EnumRarity.rare;
    }
}
