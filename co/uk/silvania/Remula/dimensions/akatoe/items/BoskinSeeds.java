package co.uk.silvania.Remula.dimensions.akatoe.items;

import co.uk.silvania.Remula.CommonProxy;
import co.uk.silvania.Remula.Remula;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.ItemSeeds;

public class BoskinSeeds extends ItemSeeds {

	public BoskinSeeds(int id, int plantId, int soilId) {
		super(id, plantId, soilId);
		this.setCreativeTab(Remula.tabMisc);
		this.setMaxStackSize(64);
	}
	
	public void registerIcons(IconRegister iconRegister)
	{
	         itemIcon = iconRegister.registerIcon("Remula:BoskinSeeds");
	}

}
