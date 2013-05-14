package co.uk.silvania.Remula.dimensions.baloinus.blocks;

import co.uk.silvania.Remula.Remula;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BaloinusStone extends Block {

	public BaloinusStone(int id, int texture, Material material) {
		super(id, texture, material);
		this.setCreativeTab(Remula.tabBaloinus);
		this.setHardness(2.0F);
	}
}
