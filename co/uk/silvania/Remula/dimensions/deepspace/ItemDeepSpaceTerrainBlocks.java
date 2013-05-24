package co.uk.silvania.Remula.dimensions.deepspace;

import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemDeepSpaceTerrainBlocks extends ItemBlock {

	public ItemDeepSpaceTerrainBlocks(int par1) {
		super(par1);
		this.setHasSubtypes(true);
	}
	
	public String getUnlocalizedName(ItemStack itemstack) {
		
		String name = "";
		switch(itemstack.getItemDamage()) {
			case 0: {
				name = "brownrubble";
				break;
			}
			case 1: {
				name = "brownbricks";
				break;
			}
			case 2: {
				name = "brownsmallbricks";
				break;
			}
			case 3: {
				name = "browndecorbricks";
				break;
			}
			case 4: {
				name = "brownrefinedasteroid";
				break;
			}
			case 5: {
				name = "browndust";
				break;
			}
			case 6: {
				name = "";
				break;
			}
			case 7: {
				name = "";
				break;
			}
			case 8: {
				name = "whiterubble";
				break;
			}
			case 9: {
				name = "whitebricks";
				break;
			}
			case 10: {
				name = "whitesmallbricks";
				break;
			}
			case 11: {
				name = "whitedecorbricks";
				break;
			}
			case 12: {
				name = "whiterefinedasteroid";
				break;
			}
			case 13: {
				name = "whitedust";
				break;
			}
			case 14: {
				name = "";
				break;
			}
			case 15: {
				name = "";
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
