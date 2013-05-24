package co.uk.silvania.Remula.blocks;

import co.uk.silvania.Remula.CommonProxy;
import co.uk.silvania.Remula.Remula;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLeaves;
import net.minecraft.client.renderer.texture.IconRegister;

public class RubberLeaves extends BlockLeaves {

	public RubberLeaves(int id) {
		super(id);
		this.setCreativeTab(Remula.tabRemula);
		this.setStepSound(Block.soundGrassFootstep);
		this.setHardness(0.2F);
	}
	
	public void registerIcons(IconRegister iconRegister)
	{
	         blockIcon = iconRegister.registerIcon("Remula:RubberLeaves");
	}

}
