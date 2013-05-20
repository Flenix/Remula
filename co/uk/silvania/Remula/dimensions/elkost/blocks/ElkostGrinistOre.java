package co.uk.silvania.Remula.dimensions.elkost.blocks;

import co.uk.silvania.Remula.CommonProxy;
import co.uk.silvania.Remula.Remula;
import net.minecraft.block.Block;
import net.minecraft.block.BlockOre;

public class ElkostGrinistOre extends BlockOre {

	public ElkostGrinistOre(int id, int texture) {
		super(id, texture);
		this.setCreativeTab(Remula.tabElkost);
		this.setHardness(1.0F);
		this.setStepSound(Block.soundStoneFootstep);
	}
   
    @Override
    public String getTextureFile () {
            return CommonProxy.ELKOSTBLOCKS_PNG;
    }

}
