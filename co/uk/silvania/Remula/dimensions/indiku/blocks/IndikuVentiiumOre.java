package co.uk.silvania.Remula.dimensions.indiku.blocks;

import co.uk.silvania.Remula.CommonProxy;
import co.uk.silvania.Remula.Remula;
import net.minecraft.block.Block;
import net.minecraft.block.BlockOre;

public class IndikuVentiiumOre extends BlockOre {

	public IndikuVentiiumOre(int id, int texture) {
		super(id, texture);
		this.setCreativeTab(Remula.tabIndiku);
		this.setHardness(1.0F);
		this.setStepSound(Block.soundStoneFootstep);
	}
   
    @Override
    public String getTextureFile () {
            return CommonProxy.INDIKUBLOCKS_PNG;
    }

}
