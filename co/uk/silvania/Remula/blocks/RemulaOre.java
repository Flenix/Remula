package co.uk.silvania.Remula.blocks;

import java.util.Random;

import co.uk.silvania.Remula.CommonProxy;
import co.uk.silvania.Remula.Remula;
import co.uk.silvania.roads.Roads;
import net.minecraft.block.Block;
import net.minecraft.block.BlockOre;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class RemulaOre extends BlockOre {

        public RemulaOre (int id, int texture) {
                super(id, texture);
                this.setCreativeTab(Remula.tabRemula);
                this.setHardness(1.5F);
                this.setStepSound(Block.soundStoneFootstep);
        }
        
        public int idDropped(int par1, Random random, int par2) {
        	return (Remula.remulaDust.itemID);
        	
        }
        
        public int quantityDropped(Random par1Random)
        {
            return this.blockID == Remula.remulaOre.blockID ? 1 : 1;
        }
        
        @Override
        public String getTextureFile () {
                return CommonProxy.BLOCK_PNG;
        }
        
    	@Override
    	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int i, float a, float b, float c) {
    		player.openGui(Remula.instance, 0, world, x, y, z);
    		System.out.println("Hello World");
    		return true;
    	}

}