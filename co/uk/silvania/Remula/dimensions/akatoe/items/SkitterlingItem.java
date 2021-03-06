package co.uk.silvania.Remula.dimensions.akatoe.items;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemFood;

public class SkitterlingItem extends ItemFood {
	
	public SkitterlingItem(int id, int food, float saturation, boolean isWolfMeat) {
		super(id, food, saturation, isWolfMeat);
		this.setMaxStackSize(16);
		this.setCreativeTab(CreativeTabs.tabFood);
	}

	public void registerIcons(IconRegister iconRegister) {
         itemIcon = iconRegister.registerIcon("Remula:SkitterlingLiving");
	}
}