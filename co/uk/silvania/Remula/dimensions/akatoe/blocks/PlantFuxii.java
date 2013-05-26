package co.uk.silvania.Remula.dimensions.akatoe.blocks;

import co.uk.silvania.Remula.CommonProxy;
import co.uk.silvania.Remula.Remula;
import net.minecraft.block.BlockFlower;
import net.minecraft.client.renderer.texture.IconRegister;

public class PlantFuxii extends BlockFlower {

	public PlantFuxii(int id) {
		super(id);
		this.setCreativeTab(Remula.tabMisc);
	}
	
		public void registerIcons(IconRegister iconRegister)
		{
		         blockIcon = iconRegister.registerIcon("Remula:AkatoePlantFuxii");
		}
}
