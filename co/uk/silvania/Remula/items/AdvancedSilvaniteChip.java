package co.uk.silvania.Remula.items;

import co.uk.silvania.Remula.CommonProxy;
import co.uk.silvania.Remula.Remula;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;

public class AdvancedSilvaniteChip extends Item {

	public AdvancedSilvaniteChip(int id) {
		super(id);
		this.setMaxStackSize(16);
		this.setCreativeTab(Remula.tabMachines);
	}
	
	public void registerIcons(IconRegister iconRegister)
	{
	         itemIcon = iconRegister.registerIcon("Remula:AdvancedSilvaniteChip");
	}

}
