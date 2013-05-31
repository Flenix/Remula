package co.uk.silvania.Remula.items;

import co.uk.silvania.Remula.CommonProxy;
import co.uk.silvania.Remula.Remula;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;

public class RemulaDust extends Item{

	public RemulaDust(int id) {
		super(id);
		this.setMaxStackSize(64);
		this.setCreativeTab(Remula.tabMinerals);
	}
	
	public void registerIcons(IconRegister iconRegister)
	{
	         itemIcon = iconRegister.registerIcon("Remula:RemulaDust");
	}

}
