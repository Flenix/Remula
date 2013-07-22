package co.uk.silvania.Remula.blocks.p1;

import co.uk.silvania.Remula.CommonProxy;
import co.uk.silvania.Remula.Remula;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;

public class P1Grinder extends Block {

	public P1Grinder(int id) {
		super(id, Material.iron);
        this.setCreativeTab(Remula.tabMachines);
        this.setHardness(1.0F);
        this.setStepSound(Block.soundMetalFootstep);
	}
	
	public void registerIcons(IconRegister iconRegister) {
        blockIcon = iconRegister.registerIcon("Remula:P1Grinder");
	}
}
