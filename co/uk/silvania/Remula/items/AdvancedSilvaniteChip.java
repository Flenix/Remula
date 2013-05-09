package co.uk.silvania.Remula.items;

import co.uk.silvania.Remula.CommonProxy;
import co.uk.silvania.Remula.Remula;
import net.minecraft.item.Item;

public class AdvancedSilvaniteChip extends Item {

	public AdvancedSilvaniteChip(int id) {
		super(id);
		this.setMaxStackSize(16);
		this.setIconIndex(50);
		this.setCreativeTab(Remula.tabRemula);
	}
	
    public String getTextureFile() {
        return CommonProxy.ITEMS_PNG;
    }

}
