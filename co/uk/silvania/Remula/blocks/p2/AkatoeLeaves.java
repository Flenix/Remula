package co.uk.silvania.Remula.blocks.p2;

import java.util.List;
import java.util.Random;

import co.uk.silvania.Remula.Remula;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;

public class AkatoeLeaves extends Block {
	public AkatoeLeaves(int par1) {
		super(par1, Material.leaves);
		this.setCreativeTab(Remula.tabWorlds);
		this.setStepSound(soundGrassFootstep);
		this.setHardness(0.2F);
	}
	
	@SideOnly(Side.CLIENT)
	private Icon[] icons;

	public boolean isOpaqueCube() {
		return false;
	}

	public int idDropped(int par1, Random par2Random, int par3) {
		return this.blockID;
	}

	public int quantityDropped(Random par1Random) {
		return 1;
	}
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister iconRegister) {
		icons = new Icon[4];
		
		for(int i = 0; i < icons.length; i++) {
			icons[i] = iconRegister.registerIcon("Remula:" + (this.getUnlocalizedName().substring(5)) + i);
		}
	}
	
	@SideOnly(Side.CLIENT)
	public Icon getIcon(int par1, int par2) {
		return icons[par2];
	}
	
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(int par1, CreativeTabs par2CreativeTabs, List par3List) {
		par3List.add(new ItemStack(par1, 1, 0));
		par3List.add(new ItemStack(par1, 1, 1));
		par3List.add(new ItemStack(par1, 1, 2));
		par3List.add(new ItemStack(par1, 1, 3));
	}
}