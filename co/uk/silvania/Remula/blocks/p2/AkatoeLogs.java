package co.uk.silvania.Remula.blocks.p2;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class AkatoeLogs extends Block {
	
	public static final String[] woodType = new String[] {"Tutorial"};
	@SideOnly(Side.CLIENT)
	private Icon iconLogTop;
	@SideOnly(Side.CLIENT)
	private Icon iconLogBottom;

	public AkatoeLogs(int par1) {
		super(par1, Material.wood);
		this.setCreativeTab(CreativeTabs.tabBlock);
		this.setStepSound(soundWoodFootstep);
		this.setHardness(2.0F);
	}

	/**
	* Called when a block is placed using its ItemBlock. Args: World, X, Y, Z, side, hitX, hitY, hitZ, block metadata
	*/
	public int onBlockPlaced(World par1World, int par2, int par3, int par4, int par5, float par6, float par7, float par8, int par9) {
		int j1 = par9 & 3;
		byte b0 = 0;
		switch (par5) {
		case 0:
		case 1:
			b0 = 0;
			break;
		case 2:
		case 3:
			b0 = 8;
			break;
		case 4:
		case 5:
			b0 = 4;
		}
		return j1 | b0;
	}

	public int idDropped(int par1, Random par2Random, int par3) {
		return this.blockID;
	}

	public int quantityDropped(Random par1Random) {
		return 1;
	}

	public Icon getIcon(int par1, int par2) {
		return par1 == 1 ? this.iconLogTop : (par1 == 0 ? this.iconLogBottom : this.blockIcon);
	}

	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1IconRegister) {
		this.blockIcon = par1IconRegister.registerIcon("Tutorial:LogSide");
		this.iconLogTop = par1IconRegister.registerIcon("Tutorial:LogTop");
		this.iconLogBottom = par1IconRegister.registerIcon("Tutorial:LogTop");
	}

	@Override
	public boolean canSustainLeaves(World world, int x, int y, int z) {
		return true;
	}

	@Override
	public boolean isWood(World world, int x, int y, int z) {
		return true;
	}

	@SideOnly(Side.CLIENT)
	public void getSubBlocks(int par1, CreativeTabs par2CreativeTabs, List par3List) {
		par3List.add(new ItemStack(par1, 1, 0));
	}
}

