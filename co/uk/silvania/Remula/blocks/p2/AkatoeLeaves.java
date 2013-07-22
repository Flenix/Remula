package co.uk.silvania.Remula.blocks.p2;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class AkatoeLeaves extends Block {
	public AkatoeLeaves(int par1) {
		super(par1, Material.leaves);
		this.setCreativeTab(CreativeTabs.tabBlock);
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
}