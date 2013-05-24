package co.uk.silvania.Remula.dimensions.akatoe;

import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemAkatoeOreBlocks extends ItemBlock {

	public ItemAkatoeOreBlocks(int par1) {
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
				name = "gold";
				break;
			}
			case 5: {
				name = "lapis";
				break;
			}
			case 6: {
				name = "remula";
				break;
			}
			case 7: {
				name = "porinite";
				break;
			}
			case 8: {
				name = "pilk";
				break;
			}
			case 9: {
				name = "akatoe";
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
