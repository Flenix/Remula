package co.uk.silvania.Remula.dimensions.indiku.blocks;

import co.uk.silvania.Remula.CommonProxy;
import co.uk.silvania.Remula.Remula;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFarmland;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;

public class IndikuTilledDirt extends BlockFarmland {

	public IndikuTilledDirt(int id) {
		super(id);
		this.setCreativeTab(Remula.tabWorlds);
		this.setHardness(1.0F);
		this.setStepSound(Block.soundStoneFootstep);
	}
   
	public void registerIcons(IconRegister iconRegister)
	{
	         blockIcon = iconRegister.registerIcon("Remula:IndikuTilledDirt");
	}

}
