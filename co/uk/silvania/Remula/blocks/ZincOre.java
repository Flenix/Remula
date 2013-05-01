package co.uk.silvania.Remula.blocks;

import java.util.Random;

import co.uk.silvania.Remula.CommonProxy;
import co.uk.silvania.Remula.Remula;
import net.minecraft.block.Block;
import net.minecraft.block.BlockOre;

public class ZincOre extends BlockOre {

	public ZincOre(int id, int texture) {
		super(id, texture);
		this.setCreativeTab(Remula.tabRemula);
		this.setHardness(1.5F);
		this.setStepSound(Block.soundStoneFootstep);
	}
    
    @Override
    public String getTextureFile () {
            return CommonProxy.BLOCK_PNG;
    }

}
