package co.uk.silvania.Remula.powergrid.blocks;

import co.uk.silvania.Remula.CommonProxy;
import co.uk.silvania.Remula.Remula;
import co.uk.silvania.Remula.client.ClientProxy;
import co.uk.silvania.Remula.tileentity.TileEntityRemulaSolarPanel;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class RemulaSolarPanel extends BlockContainer {

	public RemulaSolarPanel(int id, Material material) {
		super(id, material);
        this.setCreativeTab(Remula.tabRemula);
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
	
    @Override
    public String getTextureFile () {
            return CommonProxy.BLOCK_PNG;
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
