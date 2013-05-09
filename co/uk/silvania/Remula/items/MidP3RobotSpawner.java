package co.uk.silvania.Remula.items;

import co.uk.silvania.Remula.CommonProxy;
import co.uk.silvania.Remula.Remula;
import net.minecraft.item.Item;

public class MidP3RobotSpawner extends Item {

	public MidP3RobotSpawner(int id) {
		super(id);
		this.setMaxStackSize(1);
		this.setIconIndex(84);
		this.setCreativeTab(Remula.tabRemula);
	}
	
    public String getTextureFile() {
        return CommonProxy.ITEMS_PNG;
    }

}
