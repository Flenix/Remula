package co.uk.silvania.Remula.dimensions.elkost;

import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemElkostTerrainBlocks extends ItemBlock {

	public ItemElkostTerrainBlocks(int par1) {
		super(par1);
		this.setHasSubtypes(true);
	}
	
	public String getUnlocalizedName(ItemStack itemstack) {
		
		String name = "";
		switch(itemstack.getItemDamage()) {
			case 0: {
				name = "cobble";
				break;
			}
			case 1: {
				name = "bricks";
				break;
			}
			case 2: {
				name = "smallbricks";
				break;
			}
			case 3: {
				name = "decorbricks";
				break;
			}
			case 4: {
				name = "refinedstone";
				break;
			}
			case 5: {
				name = "glass";
				break;
			}
			case 6: {
				name = "stone";
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
