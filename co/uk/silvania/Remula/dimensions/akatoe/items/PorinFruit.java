package co.uk.silvania.Remula.dimensions.akatoe.items;

import co.uk.silvania.Remula.CommonProxy;
import co.uk.silvania.Remula.Remula;
import net.minecraft.item.Item;

public class PorinFruit extends Item {

	public PorinFruit(int id) {
		super(id);
		this.setCreativeTab(Remula.tabAkatoe);
		this.setIconIndex(20);
		this.setMaxStackSize(16);
	}
	
    public String getTextureFile() {
        return CommonProxy.AKATOEITEMS_PNG;
    }

}
