package co.uk.silvania.Remula.dimensions.akatoe.blocks;

import co.uk.silvania.Remula.CommonProxy;
import co.uk.silvania.Remula.Remula;
import net.minecraft.block.BlockFlower;

public class PlantFuxii extends BlockFlower {

	public PlantFuxii(int id, int texture) {
		super(id, texture);
		this.setCreativeTab(Remula.tabAkatoe);
	}
	
	public String getTextureFile() {
		return CommonProxy.AKATOEBLOCKS_PNG;
	}
}
