package co.uk.silvania.Remula.dimensions.akatoe.items;

import co.uk.silvania.Remula.CommonProxy;
import co.uk.silvania.Remula.Remula;
import net.minecraft.item.ItemFood;

public class RawGarfinMeat extends ItemFood {
	
	public RawGarfinMeat(int id, int food, float saturation, boolean isWolfMeat) {
		super(id, food, saturation, isWolfMeat);
		this.setMaxStackSize(16);
		this.setIconIndex(69);
		this.setCreativeTab(Remula.tabAkatoe);
	}
	
	public String getTextureFile() {
		return CommonProxy.AKATOEITEMS_PNG;
	}

}
