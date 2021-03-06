package co.uk.silvania.Remula.blocks.p5;

import co.uk.silvania.Remula.CommonProxy;
import co.uk.silvania.Remula.Remula;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;

public class XylexianGlassPane extends Block {

	public XylexianGlassPane(int id, Material material) {
		super(id, material);
		this.setCreativeTab(Remula.tabWorlds);
		this.setHardness(1.0F);
		this.setStepSound(Block.soundStoneFootstep);
	}
   
	public void registerIcons(IconRegister iconRegister)
	{
	         blockIcon = iconRegister.registerIcon("Remula:XylexiaGlass");
	}

}
