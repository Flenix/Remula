package co.uk.silvania.Remula.dimensions.deepspace.blocks;

import java.awt.List;

import co.uk.silvania.Remula.CommonProxy;
import co.uk.silvania.Remula.Remula;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public class DeepSpaceWhiteAsteroidRock extends Block {

	public DeepSpaceWhiteAsteroidRock(int id, int texture, Material material) {
		super(id, texture, material);
		this.setCreativeTab(Remula.tabDeepSpace);
		this.setHardness(2.0F);
	}
	
	@Override
    public String getTextureFile () {
            return CommonProxy.DEEPSPACEBLOCKS_PNG;
    }
	
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean par4) {
		list.add("White");
		}
}
