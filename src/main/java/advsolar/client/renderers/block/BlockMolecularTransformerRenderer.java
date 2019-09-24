package advsolar.client.renderers.block;

import advsolar.common.AdvancedSolarPanel;
import advsolar.common.tiles.TileEntityMolecularTransformer;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.world.IBlockAccess;

public class BlockMolecularTransformerRenderer implements ISimpleBlockRenderingHandler {
    public void renderInventoryBlock(Block block, int metadata, int modelID, RenderBlocks renderer) {
        TileEntityRendererDispatcher.instance.renderTileEntityAt(new TileEntityMolecularTransformer(), 0.0D, 0.0D, 0.0D, 0.0F);
    }

    public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer) {
        return false;
    }

    public int getRenderId() {
        return AdvancedSolarPanel.blockMolecularTransformerRenderID;
    }

    public boolean shouldRender3DInInventory(int modelId) {
        return true;
    }
}
