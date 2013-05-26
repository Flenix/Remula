package co.uk.silvania.Remula.powergrid.blocks;

import co.uk.silvania.Remula.CommonProxy;
import co.uk.silvania.Remula.Remula;
import co.uk.silvania.Remula.client.ClientProxy;
import co.uk.silvania.Remula.powergrid.blocks.tileentity.TileEntityRemulaSolarPanel;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class P1SolarPanel extends BlockContainer {

	public P1SolarPanel(int id, Material material) {
		super(id, material);
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
		blockIcon = iconRegister.registerIcon("Remula:P1SolarPanel");
	}
    
    @Override
    public int getRenderBlockPass() {
    	return 1;
    }

	@Override
	public TileEntity createNewTileEntity(World var1) {
		return new TileEntityRemulaSolarPanel();
	}

}
