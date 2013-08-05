package co.uk.silvania.Remula.items;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;
import co.uk.silvania.Remula.Remula;

public class CraftingIngredientsChips extends Item {
	
	public CraftingIngredientsChips(int id) {
		super(id);
		this.setMaxStackSize(16);
		this.setCreativeTab(Remula.tabMachines);
	}
	
	public void registerIcons(IconRegister iconRegister) {
		itemIcon = iconRegister.registerIcon("Remula:" + (this.getUnlocalizedName().substring(5)));
	}
}
