package co.uk.silvania.Remula.items.weapons;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import co.uk.silvania.Remula.Remula;

public class ItemPistol extends Item {
	
	public ItemPistol (int id) {
		super(id);
		this.setCreativeTab(Remula.tabRemula);
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer entityPlayer) {
		if (entityPlayer.capabilities.isCreativeMode||entityPlayer.inventory.consumeInventoryItem(Item.redstone.itemID)) {
			world.playSoundAtEntity(entityPlayer, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
			if (!world.isRemote) {
				world.spawnEntityInWorld(new EntityBronzeBullet(world, entityPlayer));
			}
		return itemStack;
		}
		
	return itemStack;
	}
}
