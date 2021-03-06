package co.uk.silvania.Remula.blocks.p2;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import co.uk.silvania.Remula.CommonProxy;
import co.uk.silvania.Remula.Remula;

public class AkatoeStone extends Block {
	
    public AkatoeStone(int id) {
		super(id, Material.rock);
		this.setCreativeTab(Remula.tabWorlds);
		this.setHardness(3.0F);
		this.setStepSound(Block.soundStoneFootstep);
	}

	public void registerIcons(IconRegister iconRegister)
	{
	         blockIcon = iconRegister.registerIcon(Remula.modid + ":" + (this.getUnlocalizedName().substring(5)));
	}
}

