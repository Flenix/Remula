package co.uk.silvania.Remula.dimensions.akatoe.items;

import co.uk.silvania.Remula.CommonProxy;
import co.uk.silvania.Remula.Remula;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;

public class PoriniteDust extends Item {

	public PoriniteDust(int id) {
		super(id);
		this.setMaxStackSize(64);
		this.setCreativeTab(Remula.tabMinerals);
	}
	
	public void registerIcons(IconRegister iconRegister)
	{
	         itemIcon = iconRegister.registerIcon("Remula:PoriniteDust");
	}

}
