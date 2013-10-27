package co.uk.silvania.Remula.blocks.p2;

import co.uk.silvania.Remula.CommonProxy;
import co.uk.silvania.Remula.Remula;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;

public class BaloinusStone extends Block {

	public BaloinusStone(int id) {
		super(id, Material.rock);
		this.setCreativeTab(Remula.tabWorlds);
		this.setHardness(1.0F);
		this.setStepSound(Block.soundStoneFootstep);
	}
   
	public void registerIcons(IconRegister iconRegister)
	{
	         blockIcon = iconRegister.registerIcon(Remula.modid + ":" + (this.getUnlocalizedName().substring(5)));
	}

}
