package co.uk.silvania.Remula.blocks.p2;

import java.util.Random;

import co.uk.silvania.Remula.Remula;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFarmland;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.common.IPlantable;

public class AkatoeTilledDirt extends Block {

	public AkatoeTilledDirt(int id) {
		super(id, Material.ground);
        this.setTickRandomly(true);
        this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.9375F, 1.0F);
        this.setLightOpacity(255);
        this.setCreativeTab(Remula.tabWorlds);
	}
	
	@SideOnly(Side.CLIENT)
	private Icon sides;
	@SideOnly(Side.CLIENT)
	private Icon top;
	@SideOnly(Side.CLIENT)
	private Icon base;

	public void registerIcons(IconRegister iconRegister) {
        this.sides = iconRegister.registerIcon("remula:akatoeDirt");
        this.top = iconRegister.registerIcon("remula:akatoeTilledDirt");
	}
   
    @SideOnly(Side.CLIENT)
    @Override
    public Icon getIcon(int side, int meta)
    {
    	if (side == 1)
    		return top;
    	return sides;
    }
    
    public boolean isOpaqueCube() {
    	return false;
    }
    
    public boolean renderAsNormalBlock() {
    	return false;
    }
}	
    /*public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, int par2, int par3, int par4) {
        return AxisAlignedBB.getAABBPool().addOrModifyAABBInPool((double)(par2 + 0), (double)(par3 + 0), (double)(par4 + 0), (double)(par2 + 1), (double)(par3 + 1), (double)(par4 + 1));
    }

    public boolean isOpaqueCube() {
        return false;
    }

    public boolean renderAsNormalBlock() {
        return false;
    }

    public int getBlockTextureFromSideAndMetadata(int par1, int par2) {
        return par1 == 1 && par2 > 0 ? this.blockIndexInTexture - 1 : (par1 == 1 ? this.blockIndexInTexture : 2);
    }

    public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random) {
        if (!this.isWaterNearby(par1World, par2, par3, par4) && !par1World.canLightningStrikeAt(par2, par3 + 1, par4)) {
            int var6 = par1World.getBlockMetadata(par2, par3, par4);

            if (var6 > 0) {
                par1World.setBlockMetadataWithNotify(par2, par3, par4, var6 - 1);
            }
            else if (!this.isCropsNearby(par1World, par2, par3, par4)) {
                par1World.setBlockWithNotify(par2, par3, par4, Remula.akatoeDirt.blockID);
            }
        }
        else
        {
            par1World.setBlockMetadataWithNotify(par2, par3, par4, 7);
        }
    }

    public void onFallenUpon(World par1World, int par2, int par3, int par4, Entity par5Entity, float par6) {
        if (!par1World.isRemote && par1World.rand.nextFloat() < par6 - 0.5F) {
            if (!(par5Entity instanceof EntityPlayer) && !par1World.getGameRules().getGameRuleBooleanValue("mobGriefing")) {
                return;
            }

            par1World.setBlockWithNotify(par2, par3, par4, Remula.akatoeDirt.blockID);
        }
    }

    private boolean isCropsNearby(World par1World, int par2, int par3, int par4) {
        byte var5 = 0;

        for (int var6 = par2 - var5; var6 <= par2 + var5; ++var6) {
            for (int var7 = par4 - var5; var7 <= par4 + var5; ++var7) {
                int var8 = par1World.getBlockId(var6, par3 + 1, var7);

                Block plant = blocksList[var8];
                if (plant instanceof IPlantable && canSustainPlant(par1World, par2, par3, par4, ForgeDirection.UP, (IPlantable)plant)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean isWaterNearby(World par1World, int par2, int par3, int par4) {
        for (int var5 = par2 - 4; var5 <= par2 + 4; ++var5) {
            for (int var6 = par3; var6 <= par3 + 1; ++var6) {
                for (int var7 = par4 - 4; var7 <= par4 + 4; ++var7) {
                    if (par1World.getBlockMaterial(var5, var6, var7) == Material.water) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public void onNeighborBlockChange(World par1World, int par2, int par3, int par4, int par5) {
        super.onNeighborBlockChange(par1World, par2, par3, par4, par5);
        Material var6 = par1World.getBlockMaterial(par2, par3 + 1, par4);

        if (var6.isSolid()) {
            par1World.setBlockWithNotify(par2, par3, par4, Remula.akatoeDirt.blockID);
        }
    }

    public int idDropped(int par1, Random par2Random, int par3) {
        return Remula.akatoeDirt.idDropped(0, par2Random, par3);
    }

    @SideOnly(Side.CLIENT)
    public int idPicked(World par1World, int par2, int par3, int par4) {
        return Remula.akatoeDirt.blockID;
    }
}*/
