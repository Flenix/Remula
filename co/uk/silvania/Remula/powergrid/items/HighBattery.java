package co.uk.silvania.Remula.powergrid.items;

import co.uk.silvania.Remula.CommonProxy;
import co.uk.silvania.Remula.Remula;
import net.minecraft.item.Item;

public class HighBattery extends Item {

	public HighBattery(int id) {
		super(id);
		this.setMaxStackSize(64);
		this.setIconIndex(114);
		this.setCreativeTab(Remula.tabRemula);
	}
	
    public String getTextureFile() {
        return CommonProxy.ITEMS_PNG;
    }

}
