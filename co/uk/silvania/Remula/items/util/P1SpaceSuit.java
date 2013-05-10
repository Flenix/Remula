/*package co.uk.silvania.Remula.items.util;

import co.uk.silvania.Remula.Remula;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.IArmorTextureProvider;

public class P1SpaceSuit extends ItemArmor implements IArmorTextureProvider {

	public P1SpaceSuit(int id, EnumArmorMaterial material, int proxy, int slot) {
		super(id, material, proxy, slot);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getArmorTextureFile(ItemStack itemstack) {
		if(itemstack.itemID == Remula.p1SpaceSuitHelmet.itemID || itemstack.itemID == Remula.p1SpaceSuitHelmet.itemID ||
			itemstack.itemID == Remula.p1SpaceSuitHelmet.itemID || itemstack.itemID == Remula.p1SpaceSuitHelmet.itemID) {
			return "/co/uk/silvania/Remula/resources/spacesuit1_1.png";
			}
			if(itemstack.itemID == Remula.p1SpaceSuitLegs.itemID) {
				return "/co/uk/silvania/Remula/resources/spacesuit1_2.png";
			}
			else return null;
	}
	
	/*@SideOnly(Side.CLIENT)
	public void func_94581_a(IconRegister iconRegister) {
		if(this == Remula.p1SpaceSuitHelmet)
		this.iconIndex = iconRegister,func_94245_a("")
	}

}*/
