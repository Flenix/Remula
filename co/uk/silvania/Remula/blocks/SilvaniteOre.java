package co.uk.silvania.Remula.blocks;

import java.util.Random;

import co.uk.silvania.Remula.CommonProxy;
import co.uk.silvania.Remula.Remula;
import net.minecraft.block.Block;
import net.minecraft.block.BlockOre;
import net.minecraft.client.renderer.texture.IconRegister;

public class SilvaniteOre extends BlockOre {

	public SilvaniteOre(int id) {
		super(id);
		this.setCreativeTab(Remula.tabRemula);
		this.setHardness(1.0F);
		this.setStepSound(Block.soundStoneFootstep);
	}
	
    public int idDropped(int par1, Random random, int par2) {
    	return (Remula.silvaniteDust.itemID);
    	
    }
     
	
	public void registerIcons(IconRegister iconRegister)
	{
	         blockIcon = iconRegister.registerIcon("Remula:SilvaniteOre");
	}

}
