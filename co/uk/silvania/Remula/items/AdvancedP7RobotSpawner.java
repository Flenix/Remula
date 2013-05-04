package co.uk.silvania.Remula.items;

import co.uk.silvania.Remula.CommonProxy;
import co.uk.silvania.Remula.Remula;
import net.minecraft.item.Item;

public class AdvancedP7RobotSpawner extends Item {

	public AdvancedP7RobotSpawner(int id) {
		super(id);
		this.setMaxStackSize(1);
		this.setIconIndex(2);
		this.setCreativeTab(Remula.tabRemula);
	}
	
    public String getTextureFile() {
        return CommonProxy.ITEMS_PNG;
    }

}
