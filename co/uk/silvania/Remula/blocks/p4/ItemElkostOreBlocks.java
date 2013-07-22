package co.uk.silvania.Remula.blocks.p4;

import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemElkostOreBlocks extends ItemBlock {

	public ItemElkostOreBlocks(int par1) {
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
				name = "tritanite";
				break;
			}
			case 8: {
				name = "zirinium";
				break;
			}
			case 9: {
				name = "boria";
				break;
			}
			case 10: {
				name = "grinist";
				break;
			}
			case 11: {
				name = "tristonium";
				break;
			}
			case 12: {
				name = "elkostium";
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
