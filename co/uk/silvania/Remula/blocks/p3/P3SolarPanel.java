package co.uk.silvania.Remula.blocks.p3;

import co.uk.silvania.Remula.CommonProxy;
import co.uk.silvania.Remula.Remula;
import co.uk.silvania.Remula.client.ClientProxy;
import co.uk.silvania.Remula.tileentity.TileEntityP3SolarPanel;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class P3SolarPanel extends BlockContainer {

	public P3SolarPanel(int id) {
		super(id, Material.iron);
        this.setCreativeTab(Remula.tabMachines);
        this.setHardness(1.0F);
        this.setStepSound(Block.soundMetalFootstep);
	}
	
	@Override
	public boolean renderAsNormalBlock() {
		return false;
	}
	
	@Override
	public boolean shouldSideBeRendered(IBlockAccess iblockaccess, int i, int j, int k, int l)
	{
	   return false;
	}
	
	@Override
	public boolean isOpaqueCube() {
		return false;
	}
	

	public void registerIcons(IconRegister iconRegister) {
		blockIcon = iconRegister.registerIcon("Remula:P3SolarPanel");
	}
    
	@Override
	public TileEntity createNewTileEntity(World var1) {
		return new TileEntityP3SolarPanel();
	}
}
