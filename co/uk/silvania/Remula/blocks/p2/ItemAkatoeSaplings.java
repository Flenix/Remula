package co.uk.silvania.Remula.blocks.p2;

import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemAkatoeSaplings extends ItemBlock {

	public ItemAkatoeSaplings(int par1) {
		super(par1);
		this.setHasSubtypes(true);
	}
	
	public String getUnlocalizedName(ItemStack itemstack) {
		
		String name = "";
		switch(itemstack.getItemDamage()) {
			case 0: {
				name = "0";
				break;
			}
			case 1: {
				name = "1";
				break;
			}
			case 2: {
				name = "2";
				break;
			}
			case 3: {
				name = "3";
				break;
			}
			default: name = "broken";
		}
		return getUnlocalizedName() + "." + name;
	}
	
	public int getMetadata(int par1) {
		return par1;
	}

}
