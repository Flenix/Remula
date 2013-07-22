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
	
	private Icon sides;
	private Icon top;

	public RubberLog(int id) {
		super(id, Material.wood);
		this.setCreativeTab(Remula.tabRemula);
		this.setStepSound(Block.soundWoodFootstep);
		this.setHardness(0.7F);
	}
	
	public void registerIcons(IconRegister iconRegister) {
         sides = iconRegister.registerIcon("Remula:RubberLogSide");
         top = iconRegister.registerIcon("Remula:RubberLogTop");
	}
    
    @SideOnly(Side.CLIENT)
    @Override
    public Icon getIcon(int side, int meta)
    {
    	if (side == 1 || side == 0)
    		return top;
    	
    	return sides;
    }

	
}