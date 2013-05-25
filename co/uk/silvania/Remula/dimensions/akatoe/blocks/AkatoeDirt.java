package co.uk.silvania.Remula.dimensions.akatoe.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import co.uk.silvania.Remula.CommonProxy;
import co.uk.silvania.Remula.Remula;

public class AkatoeDirt extends Block {
	
    public AkatoeDirt(int id, Material material) {
		super(id, material);
		this.setCreativeTab(Remula.tabAkatoe);
		this.setHardness(0.3F);
		this.setStepSound(Block.soundGravelFootstep);
	}
    
	public void registerIcons(IconRegister iconRegister)
	{
	         blockIcon = iconRegister.registerIcon("Remula:AkatoeDirt");
	}

}

