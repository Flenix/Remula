package co.uk.silvania.Remula.dimensions.akatoe;

import co.uk.silvania.Remula.CommonProxy;
import co.uk.silvania.Remula.Remula;
import net.minecraft.item.ItemSeeds;

public class UlinSeeds extends ItemSeeds {

	public UlinSeeds(int id, int plantId, int soilId) {
		super(id, plantId, soilId);
		this.setCreativeTab(Remula.tabAkatoe);
		this.setIconIndex(5);
		this.setMaxStackSize(64);
	}
	
    public String getTextureFile() {
        return CommonProxy.AKATOEITEMS_PNG;
    }

}
