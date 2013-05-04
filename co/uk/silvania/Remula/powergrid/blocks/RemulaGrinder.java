package co.uk.silvania.Remula.powergrid.blocks;

import co.uk.silvania.Remula.CommonProxy;
import co.uk.silvania.Remula.Remula;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class RemulaGrinder extends Block {

	public RemulaGrinder(int id, Material material) {
		super(id, material);
        this.setCreativeTab(Remula.tabRemula);
        this.setHardness(1.0F);
        this.setStepSound(Block.soundMetalFootstep);
	}
	
    @Override
    public String getTextureFile () {
            return CommonProxy.BLOCK_PNG;
    }
    

}