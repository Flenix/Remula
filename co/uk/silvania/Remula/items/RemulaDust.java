package co.uk.silvania.Remula.items;

import co.uk.silvania.Remula.Remula;
import net.minecraft.item.Item;

public class RemulaDust extends Item{

	public RemulaDust(int id) {
		super(id);
		this.setMaxStackSize(64);
		this.setIconIndex(1);
		this.setCreativeTab(Remula.tabRemula);
	}

}
