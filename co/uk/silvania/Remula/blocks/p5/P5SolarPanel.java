package co.uk.silvania.Remula.blocks.p5;

import co.uk.silvania.Remula.CommonProxy;
import co.uk.silvania.Remula.Remula;
import co.uk.silvania.Remula.client.ClientProxy;
import co.uk.silvania.Remula.tileentity.TileEntityP5SolarPanel;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class P5SolarPanel extends BlockContainer {

	public P5SolarPanel(int id) {
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
		blockIcon = iconRegister.registerIcon("Remula:P5SolarPanel");
	}
    
	@Override
	public TileEntity createNewTileEntity(World var1) {
		return new TileEntityP5SolarPanel();
	}
}
