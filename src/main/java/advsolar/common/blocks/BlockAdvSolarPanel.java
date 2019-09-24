package advsolar.common.blocks;

import advsolar.client.ASPClientProxy;
import advsolar.common.AdvancedSolarPanel;
import advsolar.common.tiles.*;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import java.util.List;
import java.util.Random;

public class BlockAdvSolarPanel extends BlockContainer {
    public boolean qgActive;
    private IIcon[][] iconBuffer;

    public BlockAdvSolarPanel() {
        super(Material.iron);
        this.setHardness(3.0F);
        this.setCreativeTab(AdvancedSolarPanel.ic2Tab);
        this.qgActive = false;
    }

    public static boolean isActive(IBlockAccess var0, int var1, int var2, int var3) {
        return ((TileEntityBase) var0.getTileEntity(var1, var2, var3)).getActive();
    }

    @Override
    public void registerBlockIcons(IIconRegister par1IconRegister) {
        this.iconBuffer = new IIcon[5][12];
        this.iconBuffer[0][0] = par1IconRegister.registerIcon("advancedsolarpanel:asp_bottom");
        this.iconBuffer[0][1] = par1IconRegister.registerIcon("advancedsolarpanel:asp_top");
        this.iconBuffer[0][2] = par1IconRegister.registerIcon("advancedsolarpanel:asp_side");
        this.iconBuffer[0][3] = par1IconRegister.registerIcon("advancedsolarpanel:asp_side");
        this.iconBuffer[0][4] = par1IconRegister.registerIcon("advancedsolarpanel:asp_side");
        this.iconBuffer[0][5] = par1IconRegister.registerIcon("advancedsolarpanel:asp_side");
        this.iconBuffer[0][6] = par1IconRegister.registerIcon("advancedsolarpanel:asp_bottom");
        this.iconBuffer[0][7] = par1IconRegister.registerIcon("advancedsolarpanel:asp_top");
        this.iconBuffer[0][8] = par1IconRegister.registerIcon("advancedsolarpanel:asp_side");
        this.iconBuffer[0][9] = par1IconRegister.registerIcon("advancedsolarpanel:asp_side");
        this.iconBuffer[0][10] = par1IconRegister.registerIcon("advancedsolarpanel:asp_side");
        this.iconBuffer[0][11] = par1IconRegister.registerIcon("advancedsolarpanel:asp_side");
        this.iconBuffer[1][0] = par1IconRegister.registerIcon("advancedsolarpanel:hsp_bottom");
        this.iconBuffer[1][1] = par1IconRegister.registerIcon("advancedsolarpanel:hsp_top");
        this.iconBuffer[1][2] = par1IconRegister.registerIcon("advancedsolarpanel:hsp_side");
        this.iconBuffer[1][3] = par1IconRegister.registerIcon("advancedsolarpanel:hsp_side");
        this.iconBuffer[1][4] = par1IconRegister.registerIcon("advancedsolarpanel:hsp_side");
        this.iconBuffer[1][5] = par1IconRegister.registerIcon("advancedsolarpanel:hsp_side");
        this.iconBuffer[1][6] = par1IconRegister.registerIcon("advancedsolarpanel:hsp_bottom");
        this.iconBuffer[1][7] = par1IconRegister.registerIcon("advancedsolarpanel:hsp_top");
        this.iconBuffer[1][8] = par1IconRegister.registerIcon("advancedsolarpanel:hsp_side");
        this.iconBuffer[1][9] = par1IconRegister.registerIcon("advancedsolarpanel:hsp_side");
        this.iconBuffer[1][10] = par1IconRegister.registerIcon("advancedsolarpanel:hsp_side");
        this.iconBuffer[1][11] = par1IconRegister.registerIcon("advancedsolarpanel:hsp_side");
        this.iconBuffer[2][0] = par1IconRegister.registerIcon("advancedsolarpanel:usp_bottom");
        this.iconBuffer[2][1] = par1IconRegister.registerIcon("advancedsolarpanel:usp_top");
        this.iconBuffer[2][2] = par1IconRegister.registerIcon("advancedsolarpanel:usp_side");
        this.iconBuffer[2][3] = par1IconRegister.registerIcon("advancedsolarpanel:usp_side");
        this.iconBuffer[2][4] = par1IconRegister.registerIcon("advancedsolarpanel:usp_side");
        this.iconBuffer[2][5] = par1IconRegister.registerIcon("advancedsolarpanel:usp_side");
        this.iconBuffer[2][6] = par1IconRegister.registerIcon("advancedsolarpanel:usp_bottom");
        this.iconBuffer[2][7] = par1IconRegister.registerIcon("advancedsolarpanel:usp_top");
        this.iconBuffer[2][8] = par1IconRegister.registerIcon("advancedsolarpanel:usp_side");
        this.iconBuffer[2][9] = par1IconRegister.registerIcon("advancedsolarpanel:usp_side");
        this.iconBuffer[2][10] = par1IconRegister.registerIcon("advancedsolarpanel:usp_side");
        this.iconBuffer[2][11] = par1IconRegister.registerIcon("advancedsolarpanel:usp_side");
        this.iconBuffer[3][0] = par1IconRegister.registerIcon("advancedsolarpanel:qsp_bottom");
        this.iconBuffer[3][1] = par1IconRegister.registerIcon("advancedsolarpanel:qsp_top");
        this.iconBuffer[3][2] = par1IconRegister.registerIcon("advancedsolarpanel:qsp_side");
        this.iconBuffer[3][3] = par1IconRegister.registerIcon("advancedsolarpanel:qsp_side");
        this.iconBuffer[3][4] = par1IconRegister.registerIcon("advancedsolarpanel:qsp_side");
        this.iconBuffer[3][5] = par1IconRegister.registerIcon("advancedsolarpanel:qsp_side");
        this.iconBuffer[3][6] = par1IconRegister.registerIcon("advancedsolarpanel:qsp_bottom");
        this.iconBuffer[3][7] = par1IconRegister.registerIcon("advancedsolarpanel:qsp_top");
        this.iconBuffer[3][8] = par1IconRegister.registerIcon("advancedsolarpanel:qsp_side");
        this.iconBuffer[3][9] = par1IconRegister.registerIcon("advancedsolarpanel:qsp_side");
        this.iconBuffer[3][10] = par1IconRegister.registerIcon("advancedsolarpanel:qsp_side");
        this.iconBuffer[3][11] = par1IconRegister.registerIcon("advancedsolarpanel:qsp_side");
        this.iconBuffer[4][0] = par1IconRegister.registerIcon("advancedsolarpanel:qgen_a_side");
        this.iconBuffer[4][1] = par1IconRegister.registerIcon("advancedsolarpanel:qgen_a_side");
        this.iconBuffer[4][2] = par1IconRegister.registerIcon("advancedsolarpanel:qgen_a_side");
        this.iconBuffer[4][3] = par1IconRegister.registerIcon("advancedsolarpanel:qgen_a_side");
        this.iconBuffer[4][4] = par1IconRegister.registerIcon("advancedsolarpanel:qgen_a_side");
        this.iconBuffer[4][5] = par1IconRegister.registerIcon("advancedsolarpanel:qgen_a_side");
        this.iconBuffer[4][6] = par1IconRegister.registerIcon("advancedsolarpanel:qgen_d_side");
        this.iconBuffer[4][7] = par1IconRegister.registerIcon("advancedsolarpanel:qgen_d_side");
        this.iconBuffer[4][8] = par1IconRegister.registerIcon("advancedsolarpanel:qgen_d_side");
        this.iconBuffer[4][9] = par1IconRegister.registerIcon("advancedsolarpanel:qgen_d_side");
        this.iconBuffer[4][10] = par1IconRegister.registerIcon("advancedsolarpanel:qgen_d_side");
        this.iconBuffer[4][11] = par1IconRegister.registerIcon("advancedsolarpanel:qgen_d_side");
    }

    @Override
    public IIcon getIcon(IBlockAccess world, int x, int y, int z, int blockSide) {
        int blockMeta = world.getBlockMetadata(x, y, z);
        TileEntity te = world.getTileEntity(x, y, z);
        int facing = te instanceof TileEntityBase ? ((TileEntityBase) te).getFacing() : 0;
        return isActive(world, x, y, z) ? this.iconBuffer[blockMeta][ASPClientProxy.sideAndFacingToSpriteOffset[blockSide][facing] + 6] : this.iconBuffer[blockMeta][ASPClientProxy.sideAndFacingToSpriteOffset[blockSide][facing]];
    }

    @Override
    public IIcon getIcon(int blockSide, int blockMeta) {
        return this.iconBuffer[blockMeta][ASPClientProxy.sideAndFacingToSpriteOffset[blockSide][3]];
    }

    @Override
    public void breakBlock(World world, int i, int j, int k, Block par5, int par6) {
        TileEntity tileentity = world.getTileEntity(i, j, k);
        if (tileentity != null && !(tileentity instanceof TileEntityQGenerator)) {
            this.dropItems((TileEntitySolarPanel) tileentity, world);
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

    private void dropItems(TileEntitySolarPanel tileentity, World world) {
        Random rand = new Random();
        if (tileentity != null) {

            for (int i = 0; i < ((IInventory) tileentity).getSizeInventory(); ++i) {
                ItemStack item = ((IInventory) tileentity).getStackInSlot(i);
                if (item != null && item.stackSize > 0) {
                    float rx = rand.nextFloat() * 0.8F + 0.1F;
                    float ry = rand.nextFloat() * 0.8F + 0.1F;
                    float rz = rand.nextFloat() * 0.8F + 0.1F;
                    EntityItem entityItem = new EntityItem(world, (double) ((float) tileentity.xCoord + rx), (double) ((float) tileentity.yCoord + ry), (double) ((float) tileentity.zCoord + rz), new ItemStack(item.getItem(), item.stackSize, item.getItemDamage()));
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
        switch (i) {
            case 1:
                return new TileEntityHybridSolarPanel();
            case 2:
                return new TileEntityUltimateSolarPanel();
            case 3:
                return new TileEntityQuantumSolarPanel();
            case 4:
                return new TileEntityQGenerator();
            default:
                return new TileEntityAdvancedSolarPanel();
        }
    }

    @SuppressWarnings("unchecked")
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item item, CreativeTabs tab, List subItems) {
        for (int ix = 0; ix < this.iconBuffer.length; ++ix) {
            subItems.add(new ItemStack(this, 1, ix));
        }

    }
}
