package co.uk.silvania.Remula.tileentity;

import java.util.Random;

import co.uk.silvania.Remula.CommonProxy;
import co.uk.silvania.Remula.Remula;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class SilvaniteChest extends BlockContainer {

        public SilvaniteChest (int id) {
                super(id, Material.iron);
                setHardness(2.0F);
                setResistance(5.0F);
                setCreativeTab(Remula.tabRemula);
                this.setBlockBounds(0.0625F, 0.0F, 0.0625F, 0.9375F, 0.875F, 0.9375F);
        }

        @Override
        public boolean onBlockActivated(World world, int x, int y, int z,
                        EntityPlayer player, int idk, float what, float these, float are) {
                TileEntity tileEntity = world.getBlockTileEntity(x, y, z);
                if (tileEntity == null || player.isSneaking()) {
                        return false;
                }
        player.openGui(Remula.instance, 0, world, x, y, z);
                return true;
        }

        @Override
        public void breakBlock(World world, int x, int y, int z, int par5, int par6) {
                dropItems(world, x, y, z);
                super.breakBlock(world, x, y, z, par5, par6);
        }
        
        public boolean isOpaqueCube()
        {
            return false;
        }

        public boolean renderAsNormalBlock()
        {
            return false;
        }

        public int getRenderType()
        {
            return 22;
        }
        
        public void onBlockPlacedBy(World par1World, int par2, int par3, int par4, EntityLiving par5EntityLiving)
        {
            int var6 = par1World.getBlockId(par2, par3, par4 - 1);
            int var7 = par1World.getBlockId(par2, par3, par4 + 1);
            int var8 = par1World.getBlockId(par2 - 1, par3, par4);
            int var9 = par1World.getBlockId(par2 + 1, par3, par4);
            byte var10 = 0;
            int var11 = MathHelper.floor_double((double)(par5EntityLiving.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;

            if (var11 == 0)
            {
                var10 = 2;
            }

            if (var11 == 1)
            {
                var10 = 5;
            }

            if (var11 == 2)
            {
                var10 = 3;
            }

            if (var11 == 3)
            {
                var10 = 4;
            }

            if (var6 != this.blockID && var7 != this.blockID && var8 != this.blockID && var9 != this.blockID)
            {
                par1World.setBlockMetadataWithNotify(par2, par3, par4, var10);
            }
            else
            {
                if ((var6 == this.blockID || var7 == this.blockID) && (var10 == 4 || var10 == 5))
                {
                    if (var6 == this.blockID)
                    {
                        par1World.setBlockMetadataWithNotify(par2, par3, par4 - 1, var10);
                    }
                    else
                    {
                        par1World.setBlockMetadataWithNotify(par2, par3, par4 + 1, var10);
                    }

                    par1World.setBlockMetadataWithNotify(par2, par3, par4, var10);
                }

                if ((var8 == this.blockID || var9 == this.blockID) && (var10 == 2 || var10 == 3))
                {
                    if (var8 == this.blockID)
                    {
                        par1World.setBlockMetadataWithNotify(par2 - 1, par3, par4, var10);
                    }
                    else
                    {
                        par1World.setBlockMetadataWithNotify(par2 + 1, par3, par4, var10);
                    }

                    par1World.setBlockMetadataWithNotify(par2, par3, par4, var10);
                }
            }
        }
        
        @Override
        public String getTextureFile () {
                return CommonProxy.BLOCK_PNG;
        }

        @SideOnly(Side.CLIENT)

        /**
         * Retrieves the block texture to use based on the display side. Args: iBlockAccess, x, y, z, side
         */
        public int getBlockTexture(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int par5)
        {
            return 4;
        }

        /**
         * Returns the block texture based on the side being looked at.  Args: side
         */
        public int getBlockTextureFromSide(int par1)
        {
            return 4;
        }

        private void dropItems(World world, int x, int y, int z){
                Random rand = new Random();

                TileEntity tileEntity = world.getBlockTileEntity(x, y, z);
                if (!(tileEntity instanceof IInventory)) {
                        return;
                }
                IInventory inventory = (IInventory) tileEntity;

                for (int i = 0; i < inventory.getSizeInventory(); i++) {
                        ItemStack item = inventory.getStackInSlot(i);

                        if (item != null && item.stackSize > 0) {
                                float rx = rand.nextFloat() * 0.8F + 0.1F;
                                float ry = rand.nextFloat() * 0.8F + 0.1F;
                                float rz = rand.nextFloat() * 0.8F + 0.1F;

                                EntityItem entityItem = new EntityItem(world,
                                                x + rx, y + ry, z + rz,
                                                new ItemStack(item.itemID, item.stackSize, item.getItemDamage()));

                                if (item.hasTagCompound()) {
                                        entityItem.getEntityItem().setTagCompound((NBTTagCompound) item.getTagCompound().copy());
                                }

                                float factor = 0.05F;
                                entityItem.motionX = rand.nextGaussian() * factor;
                                entityItem.motionY = rand.nextGaussian() * factor + 0.2F;
                                entityItem.motionZ = rand.nextGaussian() * factor;
                                world.spawnEntityInWorld(entityItem);
                                item.stackSize = 0;
                        }
                }
        }

        @Override
        public TileEntity createNewTileEntity(World world) {
                return new TileEntitySilvaniteChest();
        }
}