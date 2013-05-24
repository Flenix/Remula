package co.uk.silvania.Remula.blocks;

import java.util.Random;

import co.uk.silvania.Remula.CommonProxy;
import co.uk.silvania.Remula.Remula;
import net.minecraft.block.Block;
import net.minecraft.block.BlockOre;
import net.minecraft.client.renderer.texture.IconRegister;

public class MerciliteOre extends BlockOre {

	public MerciliteOre(int id) {
		super(id);
		this.setCreativeTab(Remula.tabRemula);
		this.setHardness(1.5F);
		this.setStepSound(Block.soundStoneFootstep);
	}
	
    public int idDropped(int par1, Random random, int par2) {
    	return (Remula.merciliteDust.itemID);
    	
    }
    
	public void registerIcons(IconRegister iconRegister)
	{
	         blockIcon = iconRegister.registerIcon("Remula:MerciliteOre");
	}

}
