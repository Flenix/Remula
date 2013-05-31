package co.uk.silvania.Remula.items;

import co.uk.silvania.Remula.CommonProxy;
import co.uk.silvania.Remula.Remula;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;

public class AdvancedP7RobotSpawner extends Item {

	public AdvancedP7RobotSpawner(int id) {
		super(id);
		this.setMaxStackSize(1);
		this.setCreativeTab(Remula.tabMachines);
	}
	
	public void registerIcons(IconRegister iconRegister)
	{
	         itemIcon = iconRegister.registerIcon("Remula:AdvancedP7RobotSpawner");
	}

}
