package co.uk.silvania.Remula.dimensions.akatoe.items;

import co.uk.silvania.Remula.CommonProxy;
import co.uk.silvania.Remula.Remula;
import net.minecraft.item.Item;

public class UlinFruit extends Item {

	public UlinFruit(int id) {
		super(id);
		this.setCreativeTab(Remula.tabAkatoe);
		this.setIconIndex(21);
		this.setMaxStackSize(16);
	}
	
    public String getTextureFile() {
        return CommonProxy.AKATOEITEMS_PNG;
    }

}
