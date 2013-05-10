package co.uk.silvania.Remula.tileentity;

import co.uk.silvania.Remula.Remula;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerSilvaniteChest extends Container {
	
	protected TileEntitySilvaniteChest tileEntity;
	
	public ContainerSilvaniteChest (InventoryPlayer inventoryPlayer, TileEntitySilvaniteChest te) {
		tileEntity = te;
		//Main Storage
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 9; j++) {
				addSlotToContainer(new Slot(tileEntity, j + i, -1 + j * 18, -10 + i * 18));
			}
		}
		//Upper Bucket Slot
        for (int i = 0; i < 1; i++) {
            addSlotToContainer(new Slot(tileEntity, i, 163 + i * 18, -10));
        }
        //Lower Bucket Slot
        for (int i = 0; i < 1; i++) {
            addSlotToContainer(new Slot(tileEntity, i, 163 + i * 18, 148));
        }
		bindPlayerInventory(inventoryPlayer);
	}

    @Override
    public boolean canInteractWith(EntityPlayer player) {
            return tileEntity.isUseableByPlayer(player);
    }

    //Player Inventory
    protected void bindPlayerInventory(InventoryPlayer inventoryPlayer) {
            for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 9; j++) {
                            addSlotToContainer(new Slot(inventoryPlayer, j + i * 9 + 9, -1 + j * 18, 112 + i * 18));
                    }
            }
            //Player's hotbar
            for (int i = 0; i < 9; i++) {
                    addSlotToContainer(new Slot(inventoryPlayer, i, -1 + i * 18, 170));
            }
    }

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

                    if (stackInSlot.stackSize == 0) {
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
}
