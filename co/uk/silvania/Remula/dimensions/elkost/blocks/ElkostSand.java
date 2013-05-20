package co.uk.silvania.Remula.dimensions.elkost.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSand;
import net.minecraft.block.material.Material;
import co.uk.silvania.Remula.CommonProxy;
import co.uk.silvania.Remula.Remula;

public class ElkostSand extends BlockSand {
	
    public ElkostSand(int id, int texture, Material material) {
		super(id, texture, material);
		this.setCreativeTab(Remula.tabElkost);
		this.setHardness(0.3F);
		this.setStepSound(Block.soundStoneFootstep);
	}

	@Override
    public String getTextureFile () {
            return CommonProxy.ELKOSTBLOCKS_PNG;
    }

}

