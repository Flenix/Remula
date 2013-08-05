package co.uk.silvania.Remula.blocks.p2;

import java.util.List;
import java.util.Random;

import co.uk.silvania.Remula.Remula;

import net.minecraft.block.Block;
import net.minecraft.block.BlockRotatedPillar;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class AkatoeLogs extends BlockRotatedPillar {
	
	public static final String[] woodType = new String[] {"AkatoeLogs"};
	@SideOnly(Side.CLIENT)
	private Icon[] icons;
	@SideOnly(Side.CLIENT)
	private Icon redtop;
	@SideOnly(Side.CLIENT)
	private Icon greentop;
	@SideOnly(Side.CLIENT)
	private Icon browntop;
	@SideOnly(Side.CLIENT)
	private Icon yellowtop;

	public AkatoeLogs(int par1) {
		super(par1, Material.wood);
		this.setCreativeTab(Remula.tabWorlds);
		this.setStepSound(soundWoodFootstep);
		this.setHardness(2.0F);
	}

	/**
	* Called when a block is placed using its ItemBlock. Args: World, X, Y, Z, side, hitX, hitY, hitZ, block metadata
	*/
	public int onBlockPlaced(World par1World, int par2, int par3, int par4, int par5, float par6, float par7, float par8, int par9) {
		int j1 = par9 & 3;
		byte b0 = 0;
		switch (par5) {
		case 0:
		case 1:
			b0 = 0;
			break;
		case 2:
		case 3:
			b0 = 8;
			break;
		case 4:
		case 5:
			b0 = 4;
		}
		return j1 | b0;
	}

	public int idDropped(int par1, Random par2Random, int par3) {
		return this.blockID;
	}

	public int quantityDropped(Random par1Random) {
		return 1;
	}

	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister iconRegister) {
		icons = new Icon[16];
		
		for(int i = 0; i < icons.length; i++) {
			icons[i] = iconRegister.registerIcon("Remula:" + (this.getUnlocalizedName().substring(5)) + i);
		}
		redtop = iconRegister.registerIcon("Remula:AkatoeLogsTop0");
		greentop = iconRegister.registerIcon("Remula:AkatoeLogsTop1");
		browntop = iconRegister.registerIcon("Remula:AkatoeLogsTop2");
		yellowtop = iconRegister.registerIcon("Remula:AkatoeLogsTop3");
	}
	
	@SideOnly(Side.CLIENT)
	public Icon getIcon(int side, int meta) {
		if (side == 0 && meta == 0) {
			return redtop;
		}
		if (side == 1 && meta == 0) {
			return redtop;
		}
		if (side == 0 && meta == 1) {
			return greentop;
		}
		if (side == 1 && meta == 1) {
			return greentop;
		}
		if (side == 0 && meta == 2) {
			return browntop;
		}
		if (side == 1 && meta == 2) {
			return browntop;
		}
		if (side == 0 && meta == 3) {
			return yellowtop;
		}
		if (side == 1 && meta == 3) {
			return yellowtop;
		}
		
		return icons[meta];
	}
	
	@Override
	public boolean canSustainLeaves(World world, int x, int y, int z) {
		return true;
	}

	@Override
	public boolean isWood(World world, int x, int y, int z) {
		return true;
	}

	@SideOnly(Side.CLIENT)
	public void getSubBlocks(int par1, CreativeTabs par2CreativeTabs, List par3List) {
		par3List.add(new ItemStack(par1, 1, 0));
		par3List.add(new ItemStack(par1, 1, 1));
		par3List.add(new ItemStack(par1, 1, 2));
		par3List.add(new ItemStack(par1, 1, 3));
	}

	@Override
	@SideOnly(Side.CLIENT)
	protected Icon func_111048_c(int i) {
		// TODO Auto-generated method stub
		return null;
	}
}

