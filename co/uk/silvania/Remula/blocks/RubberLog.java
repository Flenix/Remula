package co.uk.silvania.Remula.blocks;

import co.uk.silvania.Remula.CommonProxy;
import co.uk.silvania.Remula.Remula;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLog;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class RubberLog extends Block {

	public RubberLog(int id, Material material) {
		super(id, material);
		this.setCreativeTab(Remula.tabRemula);
		this.setStepSound(Block.soundWoodFootstep);
		this.setHardness(0.7F);
	}
	
    @Override
    public String getTextureFile () {
            return CommonProxy.BLOCK_PNG;
    }
    
    public int getBlockTextureFromSide(int side){
    	if(side == 0 | side ==1) {
    		return this.blockIndexInTexture + 8;
    	} else {
    		return this.blockIndexInTexture + 7;
    	}
    }
	
}