package co.uk.silvania.Remula.items.minerals;

import co.uk.silvania.Remula.CommonProxy;
import co.uk.silvania.Remula.Remula;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class EmptyCell extends Item {

	public EmptyCell(int par1) {
		super(par1);
		this.setMaxStackSize(64);
		this.setCreativeTab(Remula.tabMinerals);

	}
	
	public void registerIcons(IconRegister iconRegister)
	{
	         itemIcon = iconRegister.registerIcon("Remula:EmptyCell");
	}
	
}