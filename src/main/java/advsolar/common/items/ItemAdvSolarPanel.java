package advsolar.common.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class ItemAdvSolarPanel extends ItemBlock {
    private List itemNames;

    public ItemAdvSolarPanel(Block b) {
        super(b);
        this.setMaxDamage(0);
        this.setHasSubtypes(true);
        this.itemNames = new ArrayList();
        this.addItemsNames();
    }

    public int getMetadata(int i) {
        return i;
    }

    public String getUnlocalizedName(ItemStack itemstack) {
        return (String) this.itemNames.get(itemstack.getItemDamage());
    }

    public void addItemsNames() {
        this.itemNames.add("blockAdvancedSolarPanel");
        this.itemNames.add("blockHybridSolarPanel");
        this.itemNames.add("blockUltimateSolarPanel");
        this.itemNames.add("blockQuantumSolarPanel");
        this.itemNames.add("blockQuantumGenerator");
    }

    @SideOnly(Side.CLIENT)
    public EnumRarity getRarity(ItemStack itemstack) {
        int i = itemstack.getItemDamage();
        switch (i) {
            case 0:
                return EnumRarity.uncommon;
            case 1:
                return EnumRarity.rare;
            case 2:
                return EnumRarity.epic;
            case 3:
                return EnumRarity.epic;
            case 4:
                return EnumRarity.epic;
            default:
                return EnumRarity.uncommon;
        }
    }
}
