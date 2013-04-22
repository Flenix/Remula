package co.uk.silvania.Remula.items;

import co.uk.silvania.Remula.Remula;
import net.minecraft.item.Item;

public class RemulaIngot extends Item {

	public RemulaIngot(int id) {
		super(id);
		this.setMaxStackSize(64);
		this.setIconIndex(2);
		this.setCreativeTab(Remula.tabRemula);
	}

}
