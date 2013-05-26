package co.uk.silvania.Remula.dimensions.elkost.blocks;

import co.uk.silvania.Remula.CommonProxy;
import co.uk.silvania.Remula.Remula;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;

public class ElkostGlassPane extends Block {

	public ElkostGlassPane(int id, Material material) {
		super(id, material);
		this.setCreativeTab(Remula.tabWorlds);
		this.setHardness(1.0F);
		this.setStepSound(Block.soundGlassFootstep);
	}
   
	public void registerIcons(IconRegister iconRegister)
	{
	         blockIcon = iconRegister.registerIcon("Remula:ElkostGlassPane");
	}

}
