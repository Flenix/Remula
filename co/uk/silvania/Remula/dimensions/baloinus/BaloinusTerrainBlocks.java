package co.uk.silvania.Remula.dimensions.baloinus;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import co.uk.silvania.Remula.CommonProxy;
import co.uk.silvania.Remula.Remula;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BaloinusTerrainBlocks extends Block {
	
	public BaloinusTerrainBlocks (int id) {
		super (id, Material.ground);
		this.setBlockName("baloinusTerrainBlocks");
		this.setCreativeTab(Remula.tabRemula);
	}
	
	@Override
	public int getBlockTextureFromSideAndMetadata (int side, int metadata) {
		return 16 + metadata;
	}
	
	@Override
	public String getTextureFile() {
		return CommonProxy.BALOINUSBLOCKS_PNG;
	}
	
	@Override
	public int damageDropped (int metadata) {
		return metadata;
	}
	
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(int unknown, CreativeTabs tab, List subItems) {
		for (int ix = 0; ix < 16; ix++) {
			subItems.add(new ItemStack(this, 1, ix));
		}
	}

}
