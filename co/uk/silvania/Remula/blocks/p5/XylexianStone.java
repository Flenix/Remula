package co.uk.silvania.Remula.blocks.p5;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import co.uk.silvania.Remula.CommonProxy;
import co.uk.silvania.Remula.Remula;

public class XylexianStone extends Block {
	
    public XylexianStone(int id) {
		super(id, Material.iron);
		this.setCreativeTab(Remula.tabWorlds);
		this.setHardness(0.3F);
		this.setStepSound(Block.soundMetalFootstep);
	}

	public void registerIcons(IconRegister iconRegister)
	{
	         blockIcon = iconRegister.registerIcon("Remula:XylexiaStone");
	}

}

