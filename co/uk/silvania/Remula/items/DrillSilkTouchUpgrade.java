package co.uk.silvania.Remula.items;

import co.uk.silvania.Remula.CommonProxy;
import co.uk.silvania.Remula.Remula;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;

public class DrillSilkTouchUpgrade extends Item {

	public DrillSilkTouchUpgrade(int id) {
		super(id);
		this.setMaxStackSize(1);
		this.setCreativeTab(Remula.tabRemula);
	}
	
	public void registerIcons(IconRegister iconRegister)
	{
	         itemIcon = iconRegister.registerIcon("Remula:DrillSilkTouchUpgrade");
	}

}
