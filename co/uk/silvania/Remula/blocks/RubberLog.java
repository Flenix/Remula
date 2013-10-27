package co.uk.silvania.Remula.blocks;

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

public class RubberLog extends BlockRotatedPillar {
	
	public static final String[] woodType = new String[] {"RubberLog"};
	@SideOnly(Side.CLIENT)
	private Icon[] icons;
	@SideOnly(Side.CLIENT)
	private Icon logtop;

	public RubberLog(int par1) {
		super(par1, Material.wood);
		this.setCreativeTab(Remula.tabWorlds);
		this.setStepSound(soundWoodFootstep);
		this.setHardness(2.0F);
	}

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
			icons[i] = iconRegister.registerIcon(Remula.modid + ":" + (this.getUnlocalizedName().substring(5)) + i);
		}
		logtop = iconRegister.registerIcon("remula:rubberLogTop");
	}
	
	@SideOnly(Side.CLIENT)
	public Icon getIcon(int side, int meta) {
		if (side == 0) {
			return logtop;
		} else if (side == 1) {
			return logtop;
		} else		
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

	@Override
	@SideOnly(Side.CLIENT)
	protected Icon getSideIcon(int i) {
		return null;
	}
}

