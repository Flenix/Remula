package co.uk.silvania.Remula.powergrid.items;

import co.uk.silvania.Remula.CommonProxy;
import co.uk.silvania.Remula.Remula;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;

public class SimpleBattery extends Item {

	public SimpleBattery(int id) {
		super(id);
		this.setMaxStackSize(64);
		this.setCreativeTab(Remula.tabRemula);
	}
	
	public void registerIcons(IconRegister iconRegister)
	{
	         itemIcon = iconRegister.registerIcon("Remula:SimpleBattery");
	}

}
