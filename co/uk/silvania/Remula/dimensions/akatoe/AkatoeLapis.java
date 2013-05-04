package co.uk.silvania.Remula.dimensions.akatoe;

import java.util.Random;

import co.uk.silvania.Remula.CommonProxy;
import co.uk.silvania.Remula.Remula;
import net.minecraft.block.Block;
import net.minecraft.block.BlockOre;

public class AkatoeLapis extends BlockOre {

	public AkatoeLapis(int id, int texture) {
		super(id, texture);
		this.setCreativeTab(Remula.tabRemula);
		this.setHardness(1.0F);
		this.setStepSound(Block.soundStoneFootstep);
	}
   
    @Override
    public String getTextureFile () {
            return CommonProxy.AKATOEBLOCKS_PNG;
    }

}