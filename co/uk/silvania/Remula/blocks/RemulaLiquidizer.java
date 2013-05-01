package co.uk.silvania.Remula.blocks;

import co.uk.silvania.Remula.CommonProxy;
import co.uk.silvania.Remula.Remula;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class RemulaLiquidizer extends Block {

	public RemulaLiquidizer(int id, Material material) {
		super(id, material);
		this.setHardness(1.5F);
		this.setStepSound(Block.soundStoneFootstep);
		this.setCreativeTab(Remula.tabRemula);
	}
	@Override
	public String getTextureFile () {
	        return CommonProxy.BLOCK_PNG;
	}

}
