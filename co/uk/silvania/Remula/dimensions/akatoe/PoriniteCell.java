package co.uk.silvania.Remula.dimensions.akatoe;

import co.uk.silvania.Remula.CommonProxy;
import co.uk.silvania.Remula.Remula;
import net.minecraft.item.Item;

public class PoriniteCell extends Item {

	public PoriniteCell(int id) {
		super(id);
		this.setMaxStackSize(64);
		this.setIconIndex(1);
		this.setCreativeTab(Remula.tabAkatoe);
	}
	
    public String getTextureFile() {
        return CommonProxy.AKATOEITEMS_PNG;
    }

}
