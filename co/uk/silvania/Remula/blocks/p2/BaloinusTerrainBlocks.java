package co.uk.silvania.Remula.blocks.p2;

import java.util.List;

import co.uk.silvania.Remula.Remula;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;

public class BaloinusTerrainBlocks extends Block {

	public BaloinusTerrainBlocks(int id, Material material) {
		super(id, material);
		this.setCreativeTab(Remula.tabWorlds);
	}
	
	@SideOnly(Side.CLIENT)
	private Icon[] icons;
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister iconRegister) {
		icons = new Icon[6];
		
		for(int i = 0; i < icons.length; i++) {
			icons[i] = iconRegister.registerIcon(Remula.modid + ":" + (this.getUnlocalizedName().substring(5)) + i);
		}
	}
	
	@SideOnly(Side.CLIENT)
	public Icon getIcon(int par1, int par2) {
		return icons[par2];
	}
	
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(int par1, CreativeTabs creativeTabs, List list) {
		for (int var4 = 0; var4 < 6; ++var4) {
			list.add(new ItemStack(par1, 1, var4));
		}
	}
	
	@Override
	public int damageDropped(int meta) {
		return meta;
	}
}