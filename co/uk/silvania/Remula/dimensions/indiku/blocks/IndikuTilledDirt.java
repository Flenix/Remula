package co.uk.silvania.Remula.dimensions.indiku.blocks;

import co.uk.silvania.Remula.Remula;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.Icon;

	public class IndikuTilledDirt extends Block {

		private Icon top;
		private Icon sides;

	public IndikuTilledDirt(int id) {
		super(id, Material.rock);
		setHardness(1.0F);
		setResistance(10.0F);
		setCreativeTab(Remula.tabWorlds);
	}

	@Override
	public void registerIcons(IconRegister iconRegister) {
		sides = iconRegister.registerIcon("Remula:IndikuDirt");
		top = iconRegister.registerIcon("Remula:IndikuTilledDirt");
	}
	
    @SideOnly(Side.CLIENT)
    @Override
    public Icon getIcon(int side, int meta)
    {
    	if (side == 1)
    		return top;
    	
    	return sides;
    }
}