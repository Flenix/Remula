package co.uk.silvania.Remula.blocks;

import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemEarthOreBlocks extends ItemBlock {

	public ItemEarthOreBlocks(int par1) {
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
				name = "zinc";
				break;
			}
			case 3: {
				name = "silver";
				break;
			}
			case 4: {
				name = "silvanite";
				break;
			}
			case 5: {
				name = "mercilite";
				break;
			}
			case 6: {
				name = "remula";
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
