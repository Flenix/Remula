package co.uk.silvania.Remula.dimensions.baloinus;

import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBaloinusOreBlocks extends ItemBlock {

	public ItemBaloinusOreBlocks(int par1) {
		super(par1);
		this.setHasSubtypes(true);
	}
	
	public String getUnlocalizedName(ItemStack itemstack) {
		
		String name = "";
		switch(itemstack.getItemDamage()) {
			case 0: {
				name = "coal";
				break;
			}
			case 1: {
				name = "copper";
				break;
			}
			case 2: {
				name = "tin";
				break;
			}
			case 3: {
				name = "iron";
				break;
			}
			case 4: {
				name = "remula";
				break;
			}
			case 5: {
				name = "porinite";
				break;
			}
			case 6: {
				name = "pilk";
				break;
			}
			case 7: {
				name = "tritanite";
				break;
			}
			case 8: {
				name = "balum";
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
