package co.uk.silvania.Remula.dimensions.xylexia.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import co.uk.silvania.Remula.CommonProxy;
import co.uk.silvania.Remula.Remula;

public class XylexianStone extends Block {
	
    public XylexianStone(int id, int texture, Material material) {
		super(id, texture, material);
		this.setCreativeTab(Remula.tabXylexia);
		this.setHardness(0.3F);
		this.setStepSound(Block.soundStoneFootstep);
	}

	@Override
    public String getTextureFile () {
            return CommonProxy.XYLEXIABLOCKS_PNG;
    }

}

