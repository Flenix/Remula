package co.uk.silvania.Remula.items.armor;

import javax.swing.text.html.parser.Entity;

import co.uk.silvania.Remula.Remula;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class P1SpaceSuit extends ItemArmor {
	
	public String armorNamePrefix;

	public P1SpaceSuit(int id, EnumArmorMaterial material, int par3, int par4) {
		super(id, material, par3, par4);
		this.setCreativeTab(Remula.tabEquip);
		this.maxStackSize = 1;
	}
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister icon) {
		this.itemIcon = icon.registerIcon("remula:" + (this.getUnlocalizedName().substring(5)));
	}
	
	public String getArmorTexture(ItemStack item, Entity entity, int slot, int layer) {
		return "remula:textures/models/armor/p1spacesuit_" + (this.armorType == 2 ? 2 : 1) + ".png";
	}
}
