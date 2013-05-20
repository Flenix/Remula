package co.uk.silvania.Remula.dimensions.deepspace.blocks;

import co.uk.silvania.Remula.CommonProxy;
import co.uk.silvania.Remula.Remula;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class WhiteAsteroidRubble extends Block {

	public WhiteAsteroidRubble(int id, int texture, Material material) {
		super(id, texture, material);
		this.setCreativeTab(Remula.tabDeepSpace);
		this.setHardness(1.0F);
		this.setStepSound(Block.soundStoneFootstep);
	}
   
    @Override
    public String getTextureFile () {
            return CommonProxy.DEEPSPACEBLOCKS_PNG;
    }

}
