package co.uk.silvania.Remula.dimensions.baloinus.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import co.uk.silvania.Remula.CommonProxy;
import co.uk.silvania.Remula.Remula;

public class BaloinusSmallBricks extends Block {
	
    public BaloinusSmallBricks(int id, int texture, Material material) {
		super(id, texture, material);
		this.setCreativeTab(Remula.tabBaloinus);
		this.setHardness(0.3F);
		this.setStepSound(Block.soundStoneFootstep);
	}

	@Override
    public String getTextureFile () {
            return CommonProxy.BALOINUSBLOCKS_PNG;
    }

}

