package co.uk.silvania.Remula.dimensions.indiku.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import co.uk.silvania.Remula.CommonProxy;
import co.uk.silvania.Remula.Remula;

public class IndikuDirt extends Block {
	
    public IndikuDirt(int id, Material material) {
		super(id, material);
		this.setCreativeTab(Remula.tabIndiku);
		this.setHardness(0.3F);
		this.setStepSound(Block.soundGravelFootstep);
	}

	public void registerIcons(IconRegister iconRegister)
	{
	         blockIcon = iconRegister.registerIcon("Remula:IndikuDirt");
	}

}

