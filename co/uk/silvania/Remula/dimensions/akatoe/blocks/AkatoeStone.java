package co.uk.silvania.Remula.dimensions.akatoe.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import co.uk.silvania.Remula.CommonProxy;
import co.uk.silvania.Remula.Remula;

public class AkatoeStone extends Block {
	
    public AkatoeStone(int id, int texture, Material material) {
		super(id, material);
		this.setCreativeTab(Remula.tabAkatoe);
		this.setHardness(0.3F);
		this.setStepSound(Block.soundStoneFootstep);
	}

	@Override
    public String getTextureFile () {
            return CommonProxy.AKATOEBLOCKS_PNG;
    }

}

