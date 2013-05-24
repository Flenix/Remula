package co.uk.silvania.Remula.blocks;

import java.util.Random;

import co.uk.silvania.Remula.CommonProxy;
import co.uk.silvania.Remula.Remula;
import net.minecraft.block.Block;
import net.minecraft.block.BlockOre;
import net.minecraft.client.renderer.texture.IconRegister;

public class TinOre extends BlockOre {

	public TinOre(int id) {
		super(id);
		this.setCreativeTab(Remula.tabRemula);
		this.setHardness(1.0F);
		this.setStepSound(Block.soundStoneFootstep);
	}
   
	public void registerIcons(IconRegister iconRegister)
	{
	         blockIcon = iconRegister.registerIcon("Remula:TinOre");
	}

}
