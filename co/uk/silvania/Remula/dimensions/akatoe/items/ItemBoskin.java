package co.uk.silvania.Remula.dimensions.akatoe.items;

import co.uk.silvania.Remula.CommonProxy;
import co.uk.silvania.Remula.Remula;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;

public class ItemBoskin extends Item {

	public ItemBoskin(int id) {
		super(id);
		this.setCreativeTab(Remula.tabMisc);
		this.setMaxStackSize(16);
	}
	
	public void registerIcons(IconRegister iconRegister) {
        itemIcon = iconRegister.registerIcon("Remula:ItemBoskin");
	}

}
