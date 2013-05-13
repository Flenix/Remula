package co.uk.silvania.Remula.dimensions.deepspace;

import co.uk.silvania.Remula.CommonProxy;
import co.uk.silvania.Remula.Remula;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class DeepSpaceMeteoriteRock extends Block {

	public DeepSpaceMeteoriteRock(int id, int texture, Material material) {
		super(id, texture, material);
		this.setCreativeTab(Remula.tabDeepSpace);
		this.setHardness(2.0F);
	}
	
	@Override
    public String getTextureFile () {
            return CommonProxy.DEEPSPACEBLOCKS_PNG;
    }
}
