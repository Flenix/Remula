package co.uk.silvania.Remula.items;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;
import co.uk.silvania.Remula.Remula;

public class RemulaIngots extends Item {

	public RemulaIngots(int id) {
		super(id);
		this.setMaxStackSize(64);
		this.setCreativeTab(Remula.tabMinerals);
	}
	
	public void registerIcons(IconRegister iconRegister) {
		itemIcon = iconRegister.registerIcon("Remula:" + (this.getUnlocalizedName().substring(5)));
	}
}