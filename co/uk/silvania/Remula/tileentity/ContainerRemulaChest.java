package co.uk.silvania.Remula.tileentity;

import co.uk.silvania.Remula.Remula;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerRemulaChest extends Container {
	
	protected TileEntityRemulaChest tileEntity;
	private IInventory remulaChestInventory;
	
	public ContainerRemulaChest (InventoryPlayer inventoryPlayer, TileEntityRemulaChest te) {
		tileEntity = te;
		//Main Storage
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 9; j++) {
				addSlotToContainer(new Slot(tileEntity, j + i * 9 + 6, -21 + j * 18, -10 + i * 18));
			}
		}
		//Upper Bucket Slot 1
        for (int k = 0; k < 1; k++) {
            addSlotToContainer(new Slot(tileEntity, k, 143 + k * 18, -10));
        }
        //Lower Bucket Slot 1
        for (int l = 0; l < 1; l++) {
            addSlotToContainer(new Slot(tileEntity, l, 143 + l * 18, 148));
        }
		//Upper Bucket Slot 2
        for (int k = 0; k < 1; k++) {
            addSlotToContainer(new Slot(tileEntity, k, 163 + k * 18, -10));
        }
        //Lower Bucket Slot 2
        for (int l = 0; l < 1; l++) {
            addSlotToContainer(new Slot(tileEntity, l, 163 + l * 18, 148));
        }
		//Upper Bucket Slot 3
        for (int k = 0; k < 1; k++) {
            addSlotToContainer(new Slot(tileEntity, k, 183 + k * 18, -10));
        }
        //Lower Bucket Slot 3
        for (int l = 0; l < 1; l++) {
            addSlotToContainer(new Slot(tileEntity, l, 183 + l * 18, 148));
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
                            addSlotToContainer(new Slot(inventoryPlayer, n + m * 9 + 9, -21 + n * 18, 112 + m * 18));
                    }
            }
            //Player's hotbar
            for (int o = 0; o < 9; o++) {
                    addSlotToContainer(new Slot(inventoryPlayer, o, -21 + o * 18, 170));
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
    public IInventory getRemulaChestInventory()
    {
        return this.remulaChestInventory;
    }
}