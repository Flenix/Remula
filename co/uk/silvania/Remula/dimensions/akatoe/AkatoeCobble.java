package co.uk.silvania.Remula.dimensions.akatoe;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import co.uk.silvania.Remula.CommonProxy;
import co.uk.silvania.Remula.Remula;

public class AkatoeCobble extends Block {
	
    public AkatoeCobble(int id, int texture, Material material) {
		super(id, texture, material);
		this.setCreativeTab(Remula.tabRemula);
		this.setHardness(0.3F);
		this.setStepSound(Block.soundStoneFootstep);
	}

	@Override
    public String getTextureFile () {
            return CommonProxy.AKATOEBLOCKS_PNG;
    }

}

