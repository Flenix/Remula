package co.uk.silvania.Remula.tileentity.container;

import java.util.HashSet;
import java.util.Set;


import cpw.mods.fml.common.registry.LanguageRegistry;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class LITableSlot extends Slot {

	public LITableSlot(IInventory par1iInventory, int par2, int par3, int par4) {
		super(par1iInventory, par2, par3, par4);
	}

	@Override
	public boolean isItemValid(ItemStack par1ItemStack) {
        if (par1ItemStack != null)
        {
                Item item = par1ItemStack.getItem();
                return item != null && ContainerLITable.validItems.contains(item);
        }
        return false;
	}
}
