package co.uk.silvania.Remula.items;

import co.uk.silvania.Remula.CommonProxy;
import co.uk.silvania.Remula.Remula;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class MidP1RobotSpawner extends Item {

	public MidP1RobotSpawner(int par1) {
		super(par1);
		this.setMaxStackSize(1);
		this.setIconIndex(35);
		this.setCreativeTab(Remula.tabRemula);

	}
	
    public String getTextureFile() {
        return CommonProxy.ITEMS_PNG;
    }
	
}