package co.uk.silvania.Remula.blocks;

import java.util.Random;

import co.uk.silvania.Remula.CommonProxy;
import co.uk.silvania.Remula.Remula;
import net.minecraft.block.Block;
import net.minecraft.block.BlockOre;

public class SilvaniteOre extends BlockOre {

	public SilvaniteOre(int id, int texture) {
		super(id, texture);
		this.setCreativeTab(Remula.tabRemula);
		this.setHardness(1.0F);
		this.setStepSound(Block.soundStoneFootstep);
	}
	
    public int idDropped(int par1, Random random, int par2) {
    	return (Remula.silvaniteDust.itemID);
    	
    }
    
    public int quantityDropped(Random par1Random)
    {
        return this.blockID == Remula.silvaniteOre.blockID ? 3 + par1Random.nextInt(4) : 1;
    }
    
    @Override
    public String getTextureFile () {
            return CommonProxy.BLOCK_PNG;
    }

}
