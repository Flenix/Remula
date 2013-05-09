package co.uk.silvania.Remula.items;

import co.uk.silvania.Remula.CommonProxy;
import co.uk.silvania.Remula.Remula;
import net.minecraft.item.Item;

public class AdvancedP9RobotSpawner extends Item {

	public AdvancedP9RobotSpawner(int id) {
		super(id);
		this.setMaxStackSize(1);
		this.setIconIndex(94);
		this.setCreativeTab(Remula.tabRemula);
	}
	
    public String getTextureFile() {
        return CommonProxy.ITEMS_PNG;
    }

}
