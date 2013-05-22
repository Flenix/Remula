package co.uk.silvania.Remula.tileentity;

import java.util.HashSet;
import java.util.Set;

import co.uk.silvania.Remula.Remula;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerLITable extends Container {
	
	protected TileEntityLITable tileEntity;
	private IInventory liTableChestInventory;
	
	public ContainerLITable (InventoryPlayer inventoryPlayer, TileEntityLITable te) {
		tileEntity = te;
		//Main Storage
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				addSlotToContainer(new Slot(tileEntity, i + j * 3 + 1, 62 + j * 18, 17 + i * 18));
			}
	        for (int k = 0; k < 1; k++) {
	            addSlotToContainer(new Slot(tileEntity, k, 148 + k * 18, 35));
	        }
		}
		bindPlayerInventory(inventoryPlayer);
	}
	
    @Override
    public boolean canInteractWith(EntityPlayer player) {
            return tileEntity.isUseableByPlayer(player);
    }

    //Player Inventory
    protected void bindPlayerInventory(InventoryPlayer inventoryPlayer) {
            for (int m = 0; m < 3; m++) {
                    for (int n = 0; n < 9; n++) {
                            addSlotToContainer(new Slot(inventoryPlayer, n + m * 9 + 9, 8 + n * 18, 84 + m * 18));
                    }
            }
            //Player's hotbar
            for (int o = 0; o < 9; o++) {
                    addSlotToContainer(new Slot(inventoryPlayer, o, 8 + o * 18, 142));
            }
    }

    public static Set validItems = new HashSet();
    
    @Override
    public ItemStack transferStackInSlot(EntityPlayer player, int slot) {
            ItemStack stack = null;
            Slot slotObject = (Slot) inventorySlots.get(slot);

            if (slotObject != null && slotObject.getHasStack()) {
                    ItemStack stackInSlot = slotObject.getStack();
                    stack = stackInSlot.copy();

                    if (slot < 9) {
                            if (!this.mergeItemStack(stackInSlot, 9, 45, true)) {
                                    return null;
                            }
                    }

                    else if (!this.mergeItemStack(stackInSlot, 0, 9, false)) {
                            return null;
                    }

                    if (stackInSlot.stackSize == 10) {
                            slotObject.putStack(null);
                    } else {
                            slotObject.onSlotChanged();
                    }

                    if (stackInSlot.stackSize == stack.stackSize) {
                            return null;
                    }
                    slotObject.onPickupFromSlot(player, stackInSlot);
            }
            return stack;
    }
    public IInventory getLITableChestInventory()
    {
        return this.liTableChestInventory;
    }
}