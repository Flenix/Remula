package co.uk.silvania.Remula.dimensions.deepspace;

import co.uk.silvania.Remula.CommonProxy;
import co.uk.silvania.Remula.Remula;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;

public class DeepSpaceWhiteAsteroid extends Block {

	public DeepSpaceWhiteAsteroid(int id, Material material) {
		super(id, material);
		this.setCreativeTab(Remula.tabDeepSpace);
		this.setHardness(1.0F);
	}
   
	public void registerIcons(IconRegister iconRegister)
	{
	         blockIcon = iconRegister.registerIcon("Remula:DeepSpaceWhiteAsteroid");
	}

}
