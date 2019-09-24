package advsolar.client.gui;

import advsolar.common.tiles.TileEntityMolecularTransformer;
import advsolar.common.tiles.TileEntityQGenerator;
import advsolar.common.tiles.TileEntitySolarPanel;
import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class GuiHandler implements IGuiHandler {
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
        TileEntity te = world.getTileEntity(X, Y, Z);
        System.out.println("OpenGui");
        if (te != null) {
            if (te instanceof TileEntitySolarPanel) {
                return new GuiAdvSolarPanel(player.inventory, (TileEntitySolarPanel) te);
            } else if (te instanceof TileEntityQGenerator) {
                return new GuiQGenerator(player.inventory, (TileEntityQGenerator) te);
            } else {
                return te instanceof TileEntityMolecularTransformer ? new GuiMolecularTransformer(player.inventory, (TileEntityMolecularTransformer) te) : null;
            }
        } else {
            return null;
        }
    }

    public void registerRenderers() {
    }
}
