package co.uk.silvania.Remula.dimensions.akatoe.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;

import co.uk.silvania.Remula.CommonProxy;
import co.uk.silvania.Remula.Remula;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.Icon;
import net.minecraft.world.ColorizerGrass;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class AkatoeGrass extends Block
{
    public AkatoeGrass(int id)
    {
        super(id, Material.grass);
        this.setTickRandomly(true);
		this.setCreativeTab(Remula.tabWorlds);
        this.setStepSound(Block.soundGrassFootstep);
        this.setHardness(0.4F);
    }
    
	@SideOnly(Side.CLIENT)
	private Icon sides;
	@SideOnly(Side.CLIENT)
	private Icon top;
	@SideOnly(Side.CLIENT)
	private Icon base;

	public void registerIcons(IconRegister iconRegister) {
        this.sides = iconRegister.registerIcon("Remula:AkatoeGrassSide");
        this.top = iconRegister.registerIcon("Remula:AkatoeGrassTop");
        this.base = iconRegister.registerIcon("Remula:AkatoeDirt");
	}
   
    @SideOnly(Side.CLIENT)
    @Override
    public Icon getIcon(int side, int meta)
    {
    	if (side == 1)
    		return top;
    	if (side == 0)
    		return base;
    	
    	return sides;
    }


    //Checks if the grass can recieve light. If not, KILL IT!
    public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random)
    {
        if (!par1World.isRemote)
        {
            if (par1World.getBlockLightValue(par2, par3 + 1, par4) < 4 && par1World.getBlockLightOpacity(par2, par3 + 1, par4) > 2)
            {
                par1World.setBlock(par2, par3, par4, Remula.akatoeDirt.blockID);
            }
            else if (par1World.getBlockLightValue(par2, par3 + 1, par4) >= 9)
            {
                for (int var6 = 0; var6 < 4; ++var6)
                {
                    int var7 = par2 + par5Random.nextInt(3) - 1;
                    int var8 = par3 + par5Random.nextInt(5) - 3;
                    int var9 = par4 + par5Random.nextInt(3) - 1;
                    int var10 = par1World.getBlockId(var7, var8 + 1, var9);

                    if (par1World.getBlockId(var7, var8, var9) == Remula.akatoeDirt.blockID && par1World.getBlockLightValue(var7, var8 + 1, var9) >= 4 && par1World.getBlockLightOpacity(var7, var8 + 1, var9) <= 2)
                    {
                        par1World.setBlock(var7, var8, var9, Remula.akatoeGrass.blockID);
                    }
                }
            }
        }
    }

    //Drop Akatonian Dirt instead of itself, just like grass/dirt vanilla.
    public int idDropped(int par1, Random par2Random, int par3)
    {
        return Remula.akatoeDirt.idDropped(0, par2Random, par3);
    }
}
