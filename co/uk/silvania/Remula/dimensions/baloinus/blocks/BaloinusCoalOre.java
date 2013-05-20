package co.uk.silvania.Remula.dimensions.baloinus.blocks;

import java.util.Random;

import co.uk.silvania.Remula.CommonProxy;
import co.uk.silvania.Remula.Remula;
import net.minecraft.block.Block;
import net.minecraft.block.BlockOre;

public class BaloinusCoalOre extends BlockOre {

	public BaloinusCoalOre(int id, int texture) {
		super(id, texture);
		this.setCreativeTab(Remula.tabBaloinus);
		this.setHardness(1.0F);
		this.setStepSound(Block.soundStoneFootstep);
	}
   
    @Override
    public String getTextureFile () {
            return CommonProxy.BALOINUSBLOCKS_PNG;
    }

}
