package co.uk.silvania.Remula.blocks;

import co.uk.silvania.Remula.CommonProxy;
import co.uk.silvania.Remula.Remula;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLog;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public class RubberLog extends Block {
	
	@SideOnly(Side.CLIENT)
	private Icon sides;
	@SideOnly(Side.CLIENT)
	private Icon top;

	public RubberLog(int id, Material material) {
		super(id, material);
		this.setCreativeTab(Remula.tabRemula);
		this.setStepSound(Block.soundWoodFootstep);
		this.setHardness(0.7F);
	}
	
	public void registerIcons(IconRegister iconRegister) {
         this.sides = iconRegister.registerIcon("Remula:RubberLogSide");
         this.top = iconRegister.registerIcon("Remula:RubberLogTop");
	}
    
	public Icon getBlockTextureFromSideAndMeta(int i, int j) {
		if(i == 0 | i == 1) {
			return top;
		}
		else {
			return sides;
		}
	}

	
}