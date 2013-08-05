package co.uk.silvania.Remula.dimensions.deepspace;

import co.uk.silvania.Remula.CommonProxy;
import co.uk.silvania.Remula.Remula;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;

public class DeepSpaceBrownAsteroid extends Block {

	public DeepSpaceBrownAsteroid(int id) {
		super(id, Material.rock);
		this.setCreativeTab(Remula.tabWorlds);
		this.setHardness(1.0F);
	}
   
	public void registerIcons(IconRegister iconRegister)
	{
	         blockIcon = iconRegister.registerIcon("Remula:DeepSpaceBrownAsteroid");
	}

}
