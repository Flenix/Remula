package co.uk.silvania.Remula.items.weapons;

import co.uk.silvania.Remula.Remula;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntitySnowball;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemP1Pistol extends Item {
	
	public ItemP1Pistol(int id) {
		super(id);
		this.setMaxStackSize(1);
		this.setCreativeTab(Remula.tabEquip);
	}
	
	public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player) {
		if (!player.capabilities.isCreativeMode || player.inventory.consumeInventoryItem(Remula.p1IronBullet.itemID)) {
			--itemStack.stackSize;
		}
		world.playSoundAtEntity(player, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
		if (!world.isRemote) {
			world.spawnEntityInWorld(new EntityP1IronBullet(world, player));
		}
		return itemStack;
	}

}
