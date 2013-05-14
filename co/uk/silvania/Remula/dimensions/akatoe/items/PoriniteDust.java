package co.uk.silvania.Remula.dimensions.akatoe.items;

import co.uk.silvania.Remula.CommonProxy;
import co.uk.silvania.Remula.Remula;
import net.minecraft.item.Item;

public class PoriniteDust extends Item {

	public PoriniteDust(int id) {
		super(id);
		this.setMaxStackSize(64);
		this.setIconIndex(17);
		this.setCreativeTab(Remula.tabAkatoe);
	}
	
    public String getTextureFile() {
        return CommonProxy.AKATOEITEMS_PNG;
    }

}
