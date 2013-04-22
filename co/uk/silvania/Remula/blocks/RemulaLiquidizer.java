package co.uk.silvania.Remula.blocks;

import co.uk.silvania.Remula.Remula;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class RemulaLiquidizer extends Block {

	public RemulaLiquidizer(int id, int texture, Material material) {
		super(id, texture, material);
		this.setHardness(1.5F);
		this.setStepSound(Block.soundStoneFootstep);
		this.setCreativeTab(Remula.tabRemula);
	}
}
