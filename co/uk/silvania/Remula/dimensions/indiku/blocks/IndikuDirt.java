package co.uk.silvania.Remula.dimensions.indiku.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import co.uk.silvania.Remula.CommonProxy;
import co.uk.silvania.Remula.Remula;

public class IndikuDirt extends Block {
	
    public IndikuDirt(int id, int texture, Material material) {
		super(id, texture, material);
		this.setCreativeTab(Remula.tabIndiku);
		this.setHardness(0.3F);
		this.setStepSound(Block.soundGravelFootstep);
	}

	@Override
    public String getTextureFile () {
            return CommonProxy.INDIKUBLOCKS_PNG;
    }

}

