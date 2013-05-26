package co.uk.silvania.Remula.dimensions.elkost.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSand;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import co.uk.silvania.Remula.CommonProxy;
import co.uk.silvania.Remula.Remula;

public class ElkostSand extends BlockSand {
	
    public ElkostSand(int id, Material material) {
		super(id, material);
		this.setCreativeTab(Remula.tabWorlds);
		this.setHardness(0.3F);
		this.setStepSound(Block.soundStoneFootstep);
	}

	public void registerIcons(IconRegister iconRegister)
	{
	         blockIcon = iconRegister.registerIcon("Remula:ElkostSand");
	}

}

