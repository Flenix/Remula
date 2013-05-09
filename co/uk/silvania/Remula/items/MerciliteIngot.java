package co.uk.silvania.Remula.items;

import co.uk.silvania.Remula.CommonProxy;
import co.uk.silvania.Remula.Remula;
import net.minecraft.item.Item;

public class MerciliteIngot extends Item {

	public MerciliteIngot(int id) {
		super(id);
		this.setMaxStackSize(64);
		this.setIconIndex(34);
		this.setCreativeTab(Remula.tabRemula);
	}
	
    public String getTextureFile() {
        return CommonProxy.ITEMS_PNG;
    }

}
