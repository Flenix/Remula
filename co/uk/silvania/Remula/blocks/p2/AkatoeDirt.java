package co.uk.silvania.Remula.blocks.p2;

import net.minecraft.block.Block;
import net.minecraft.block.BlockDirt;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import co.uk.silvania.Remula.CommonProxy;
import co.uk.silvania.Remula.Remula;

public class AkatoeDirt extends BlockDirt {
	
    public AkatoeDirt(int id) {
		super(id);
		this.setCreativeTab(Remula.tabWorlds);
		this.setHardness(0.3F);
		this.setStepSound(Block.soundGravelFootstep);
	}
    
	public void registerIcons(IconRegister iconRegister)
	{
	         blockIcon = iconRegister.registerIcon("Remula:akatoeDirt");
	}

}

