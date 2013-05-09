package co.uk.silvania.Remula.dimensions.akatoe;

import co.uk.silvania.Remula.CommonProxy;
import co.uk.silvania.Remula.Remula;
import net.minecraft.item.Item;

public class ItemCir extends Item {

	public ItemCir(int id) {
		super(id);
		this.setCreativeTab(Remula.tabAkatoe);
		this.setIconIndex(22);
		this.setMaxStackSize(16);
	}
	
    public String getTextureFile() {
        return CommonProxy.AKATOEITEMS_PNG;
    }

}
