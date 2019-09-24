package advsolar.client;

import advsolar.api.MTAPI;
import advsolar.client.gui.GuiAdvSolarPanel;
import advsolar.client.gui.GuiMolecularTransformer;
import advsolar.client.gui.GuiQGenerator;
import advsolar.client.renderers.block.BlockMolecularTransformerRenderer;
import advsolar.client.renderers.tile.TileMolecularTransformerRenderer;
import advsolar.common.ASPServerProxy;
import advsolar.common.AdvancedSolarPanel;
import advsolar.common.tiles.TileEntityMolecularTransformer;
import advsolar.common.tiles.TileEntityQGenerator;
import advsolar.common.tiles.TileEntitySolarPanel;
import advsolar.utils.MTRecipeManager;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class ASPClientProxy extends ASPServerProxy {
    public static int[][] sideAndFacingToSpriteOffset;

    public void load() {
        try {
            sideAndFacingToSpriteOffset = (int[][]) ((int[][]) Class.forName("ic2.core.block.BlockMultiID").getField("sideAndFacingToSpriteOffset").get((Object) null));
        } catch (Exception var2) {
            sideAndFacingToSpriteOffset = new int[][]{{3, 2, 0, 0, 0, 0}, {2, 3, 1, 1, 1, 1}, {1, 1, 3, 2, 5, 4}, {0, 0, 2, 3, 4, 5}, {4, 5, 4, 5, 3, 2}, {5, 4, 5, 4, 2, 3}};
        }

    }

    public void registerRenderers() {
        AdvancedSolarPanel.blockMolecularTransformerRenderID = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new BlockMolecularTransformerRenderer());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityMolecularTransformer.class, new TileMolecularTransformerRenderer());
    }

    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int X, int Y, int Z) {
        TileEntity te = world.getTileEntity(X, Y, Z);
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

    public void initRecipes() {
        MTAPI.manager = MTRecipeManager.instance;
        MTRecipeManager.instance.initRecipes();
    }

    public int addArmor(String armorName) {
        return RenderingRegistry.addNewArmourRendererPrefix(armorName);
    }
}
