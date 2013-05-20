package co.uk.silvania.Remula.dimensions.deepspace.blocks;

import co.uk.silvania.Remula.CommonProxy;
import co.uk.silvania.Remula.Remula;
import net.minecraft.block.Block;
import net.minecraft.block.BlockOre;

public class WhiteAsteroidVentiiumOre extends BlockOre {

	public WhiteAsteroidVentiiumOre(int id, int texture) {
		super(id, texture);
		this.setCreativeTab(Remula.tabDeepSpace);
		this.setHardness(1.0F);
		this.setStepSound(Block.soundStoneFootstep);
	}
   
    @Override
    public String getTextureFile () {
            return CommonProxy.DEEPSPACEBLOCKS_PNG;
    }

}
