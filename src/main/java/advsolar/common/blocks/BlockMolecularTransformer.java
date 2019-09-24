package advsolar.common.blocks;

import advsolar.common.AdvancedSolarPanel;
import advsolar.common.tiles.TileEntityBase;
import advsolar.common.tiles.TileEntityMolecularTransformer;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import java.util.Random;

public class BlockMolecularTransformer extends BlockContainer {
    public IIcon icon;

    public BlockMolecularTransformer() {
        super(Material.iron);
        this.setHardness(3.0F);
        this.setLightLevel(1.0F);
        this.setCreativeTab(AdvancedSolarPanel.ic2Tab);
    }

    public static boolean isActive(IBlockAccess var0, int var1, int var2, int var3) {
        return ((TileEntityBase) var0.getTileEntity(var1, var2, var3)).getActive();
    }

    @Override
    public void registerBlockIcons(IIconRegister par1IconRegister) {
        this.icon = par1IconRegister.registerIcon("advancedsolarpanel:qgen_a_side");
    }

    @Override
    public boolean isOpaqueCube() {
        return false;
    }

    @Override
    public boolean renderAsNormalBlock() {
        return false;
    }

    @Override
    public int getRenderType() {
        return AdvancedSolarPanel.blockMolecularTransformerRenderID;
    }

    @Override
    public void breakBlock(World world, int i, int j, int k, Block par5, int par6) {
        TileEntity tileentity = world.getTileEntity(i, j, k);
        if (tileentity != null) {
            this.dropItems((TileEntityMolecularTransformer) tileentity, world);
        }

        world.removeTileEntity(i, j, k);
        super.breakBlock(world, i, j, k, par5, par6);
    }

    @Override
    public int quantityDropped(Random random) {
        return 1;
    }

    @Override
    public int damageDropped(int i) {
        return i;
    }

    @Override
    public boolean onBlockActivated(World world, int i, int j, int k, EntityPlayer player, int s, float f1, float f2, float f3) {
        if (player.isSneaking()) {
            return false;
        } else if (world.isRemote) {
            return true;
        } else {
            TileEntity tileentity = world.getTileEntity(i, j, k);
            if (tileentity != null) {
                player.openGui(AdvancedSolarPanel.instance, 1, world, i, j, k);
            }

            return true;
        }
    }

    private void dropItems(TileEntityMolecularTransformer tileentity, World world) {
        Random rand = new Random();
        if (tileentity != null) {

            for (int i = 0; i < ((IInventory) tileentity).getSizeInventory(); ++i) {
                ItemStack item = ((IInventory) tileentity).getStackInSlot(i);
                if (item != null && item.stackSize > 0) {
                    float rx = rand.nextFloat() * 0.8F + 0.1F;
                    float ry = rand.nextFloat() * 0.8F + 0.1F;
                    float rz = rand.nextFloat() * 0.8F + 0.1F;
                    EntityItem entityItem = new EntityItem(world, (float) tileentity.xCoord + rx, (float) tileentity.yCoord + ry, (double) ((float) tileentity.zCoord + rz), new ItemStack(item.getItem(), item.stackSize, item.getItemDamage()));
                    if (item.hasTagCompound()) {
                        entityItem.getEntityItem().setTagCompound((NBTTagCompound) item.getTagCompound().copy());
                    }

                    float factor = 0.05F;
                    entityItem.motionX = rand.nextGaussian() * (double) factor;
                    entityItem.motionY = rand.nextGaussian() * (double) factor + 0.20000000298023224D;
                    entityItem.motionZ = rand.nextGaussian() * (double) factor;
                    world.spawnEntityInWorld(entityItem);
                    item.stackSize = 0;
                }
            }

        }
    }

    @Override
    public TileEntity createNewTileEntity(World var1, int i) {
        return new TileEntityMolecularTransformer();
    }
}
