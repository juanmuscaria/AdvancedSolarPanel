package advsolar.common;

import advsolar.api.MTAPI;
import advsolar.common.tiles.TileEntityMolecularTransformer;
import advsolar.common.tiles.TileEntityQGenerator;
import advsolar.common.tiles.TileEntitySolarPanel;
import advsolar.utils.MTRecipeManager;
import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class ASPServerProxy implements IGuiHandler {
    public void load() {
    }

    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int X, int Y, int Z) {
        TileEntity te = world.getTileEntity(X, Y, Z);
        if (te != null) {
            if (te instanceof TileEntitySolarPanel) {
                return ((TileEntitySolarPanel) te).getGuiContainer(player.inventory);
            } else if (te instanceof TileEntityQGenerator) {
                return ((TileEntityQGenerator) te).getGuiContainer(player.inventory);
            } else {
                return te instanceof TileEntityMolecularTransformer ? ((TileEntityMolecularTransformer) te).getGuiContainer(player.inventory) : null;
            }
        } else {
            return null;
        }
    }

    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int X, int Y, int Z) {
        return null;
    }

    public void initRecipes() {
        MTAPI.manager = MTRecipeManager.instance;
        MTRecipeManager.instance.initRecipes();
    }

    public int addArmor(String armorName) {
        return 0;
    }

    public void registerRenderers() {
    }
}
