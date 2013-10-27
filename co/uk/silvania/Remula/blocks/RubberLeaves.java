package co.uk.silvania.Remula.blocks;

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

public class RubberLeaves extends Block {
	public RubberLeaves(int par1) {
		super(par1, Material.leaves);
		this.setCreativeTab(Remula.tabWorlds);
		this.setStepSound(soundGrassFootstep);
		this.setHardness(0.2F);
	}
	
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
		blockIcon = iconRegister.registerIcon(Remula.modid + ":" + (this.getUnlocalizedName().substring(5)));
	}
}