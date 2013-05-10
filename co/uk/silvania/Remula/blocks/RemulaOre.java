package co.uk.silvania.Remula.blocks;

import java.util.Random;

import co.uk.silvania.Remula.CommonProxy;
import co.uk.silvania.Remula.Remula;
import net.minecraft.block.Block;
import net.minecraft.block.BlockOre;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class RemulaOre extends BlockOre {

        public RemulaOre (int id, int texture) {
                super(id, texture);
                this.setCreativeTab(Remula.tabRemula);
                this.setHardness(2.0F);
                this.setStepSound(Block.soundStoneFootstep);
        }
        
        public int idDropped(int par1, Random random, int par2) {
        	return (Remula.remulaDust.itemID);
        	
        }
        
        @Override
        public String getTextureFile () {
                return CommonProxy.BLOCK_PNG;
        }
}