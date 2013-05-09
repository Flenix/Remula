package co.uk.silvania.Remula.items;

import co.uk.silvania.Remula.CommonProxy;
import co.uk.silvania.Remula.Remula;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class AdvancedRemulaChip extends Item {

	    public AdvancedRemulaChip(int id) {
		        super(id);
		        this.setMaxStackSize(16);
		        this.setIconIndex(56);
		        this.setCreativeTab(Remula.tabRemula);
	}
	    
    public String getTextureFile() {
        return CommonProxy.ITEMS_PNG;
    }

}
