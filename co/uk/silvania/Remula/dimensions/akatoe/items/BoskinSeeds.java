package co.uk.silvania.Remula.dimensions.akatoe.items;

import co.uk.silvania.Remula.CommonProxy;
import co.uk.silvania.Remula.Remula;
import net.minecraft.item.ItemSeeds;

public class BoskinSeeds extends ItemSeeds {

	public BoskinSeeds(int id, int plantId, int soilId) {
		super(id, plantId, soilId);
		this.setCreativeTab(Remula.tabAkatoe);
		this.setIconIndex(7);
		this.setMaxStackSize(64);
	}
	
    public String getTextureFile() {
        return CommonProxy.AKATOEITEMS_PNG;
    }

}
