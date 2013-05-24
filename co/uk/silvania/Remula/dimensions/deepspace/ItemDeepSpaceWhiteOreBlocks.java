package co.uk.silvania.Remula.dimensions.deepspace;

import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemDeepSpaceWhiteOreBlocks extends ItemBlock {

	public ItemDeepSpaceWhiteOreBlocks(int par1) {
		super(par1);
		this.setHasSubtypes(true);
	}
	
	public String getUnlocalizedName(ItemStack itemstack) {
		
		String name = "";
		switch(itemstack.getItemDamage()) {
			case 0: {
				name = "copper";
				break;
			}
			case 1: {
				name = "tin";
				break;
			}
			case 2: {
				name = "iron";
				break;
			}
			case 3: {
				name = "silvanite";
				break;
			}
			case 4: {
				name = "mercilite";
				break;
			}
			case 5: {
				name = "porinite";
				break;
			}
			case 6: {
				name = "zinc";
				break;
			}
			case 7: {
				name = "thori";
				break;
			}
			case 8: {
				name = "ventiium";
				break;
			}
			case 9: {
				name = "farithium";
				break;
			}
			case 10: {
				name = "boria";
				break;
			}
			case 11: {
				name = "heri";
				break;
			}
			case 12: {
				name = "6";
				break;
			}
			case 13: {
				name = "7";
				break;
			}
			case 14: {
				name = "8";
				break;
			}
			case 15: {
				name = "9";
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
