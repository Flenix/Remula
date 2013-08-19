package co.uk.silvania.Remula.blocks.p1;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.world.IBlockAccess;
import co.uk.silvania.Remula.Remula;

public class CopperCable extends Block {
	public static int renderID;
	
	public CopperCable(int id) {
		super(id, Material.iron);
		this.setCreativeTab(Remula.tabMachines);
		this.setHardness(1.0F);
	}
	
	@Override
	public int getRenderType() {
		return renderID;
	}
	
	@Override
	public boolean isOpaqueCube() {
		return false;
	}
	
	@Override
	public boolean renderAsNormalBlock() {
		return false;
	}
	
	@Override
	public boolean shouldSideBeRendered(IBlockAccess block, int x, int y, int z, int side) {
		return true;
	}
}
