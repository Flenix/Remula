package co.uk.silvania.Remula.blocks.p3;

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
        this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.9375F, 1.0F);
        this.setLightOpacity(255);
		setCreativeTab(Remula.tabWorlds);
	}
    public boolean isOpaqueCube() {
    	return false;
    }
    
    public boolean renderAsNormalBlock() {
    	return false;
    }

	@Override
	public void registerIcons(IconRegister iconRegister) {
		sides = iconRegister.registerIcon("remula:indikuDirt");
		top = iconRegister.registerIcon("remula:indikuTilledDirt");
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