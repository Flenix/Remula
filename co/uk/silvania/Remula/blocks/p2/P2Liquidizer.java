package co.uk.silvania.Remula.blocks.p2;

import co.uk.silvania.Remula.CommonProxy;
import co.uk.silvania.Remula.Remula;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;

public class P2Liquidizer extends Block {

	public P2Liquidizer(int id) {
		super(id, Material.iron);
		this.setHardness(1.5F);
		this.setStepSound(Block.soundStoneFootstep);
		this.setCreativeTab(Remula.tabRemula);
	}
	
	public void registerIcons(IconRegister iconRegister) {
	         blockIcon = iconRegister.registerIcon("Remula:RemulaLiquidizer");
	}
}
