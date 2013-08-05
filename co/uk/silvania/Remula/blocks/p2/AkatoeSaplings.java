package co.uk.silvania.Remula.blocks.p2;

import java.util.List;
import java.util.Random;

import co.uk.silvania.Remula.Remula;
import co.uk.silvania.Remula.RemulaBlocks;
import co.uk.silvania.Remula.dimensions.akatoe.WorldGenAkatoeTrees;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFlower;
import net.minecraft.client.main.Main;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenBigTree;
import net.minecraft.world.gen.feature.WorldGenForest;
import net.minecraft.world.gen.feature.WorldGenTaiga2;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.event.terraingen.TerrainGen;

public class AkatoeSaplings extends BlockFlower {
	
	public static final String[] WOOD_TYPES = new String[] {"AkatoeLogs"};
	
	@SideOnly(Side.CLIENT)
	private Icon[] icons;
	
	public AkatoeSaplings(int i, int j) {
		super(i);
		float var3 = 0.4F;
		this.setBlockBounds(0.5F - var3, 0.0F, 0.5F - var3, 0.5F + var3, var3 * 2.0F, 0.5F + var3);
		this.setCreativeTab(CreativeTabs.tabDecorations);
	}

	public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random) {
		if (!par1World.isRemote) {
			super.updateTick(par1World, par2, par3, par4, par5Random);
			if (par1World.getBlockLightValue(par2, par3 + 1, par4) >= 9 && par5Random.nextInt(7) == 0) {
				this.func_96477_c(par1World, par2, par3, par4, par5Random);
			}
		}
	}
	
	public void func_96477_c(World par1World, int par2, int par3, int par4, Random par5Random) {
		int l = par1World.getBlockMetadata(par2, par3, par4);
		if ((l & 8) == RemulaBlocks.akatoeGrass.blockID) {
			par1World.setBlockMetadataWithNotify(par2, par3, par4, l | 8, 4);
		} else {
			this.growTree(par1World, par2, par3, par4, par5Random);
		}
	}

	public void growTree(World par1World, int par2, int par3, int par4, Random par5Random) {
		if (!TerrainGen.saplingGrowTree(par1World, par5Random, par2, par3, par4)) return;
		int l = par1World.getBlockMetadata(par2, par3, par4) & 3;
		Object object = null;
		int i1 = 0;
		int j1 = 0;
		boolean flag = false;
		if (l == 1) {
			object = new WorldGenTaiga2(true);
		}
		else if (l == 2) {
			object = new WorldGenForest(true);
		}
		else if (l == 3) {
			for (i1 = 0; i1 >= -1; --i1) {
				for (j1 = 0; j1 >= -1; --j1) {
					if (this.isSameSapling(par1World, par2 + i1, par3, par4 + j1, 3) && this.isSameSapling(par1World, par2 + i1 + 1, par3, par4 + j1, 3) && this.isSameSapling(par1World, par2 + i1, par3, par4 + j1 + 1, 3) && this.isSameSapling(par1World, par2 + i1 + 1, par3, par4 + j1 + 1, 3)) {
						object = new WorldGenAkatoeTrees(true, 10 + par5Random.nextInt(20), 3, 3, false);
						flag = true;
						break;
					}
				}
				if (object != null) {
					break;
				}
			}
			if (object == null) {
				j1 = 0;
				i1 = 0;
				object = new WorldGenAkatoeTrees(true, 4 + par5Random.nextInt(7), 3, 3, false);
			}
		} else {
			object = new WorldGenAkatoeTrees(true); // Changed //
			if (par5Random.nextInt(10) == 0) {
				object = new WorldGenBigTree(true);
			}
		}
		if (flag) {
			par1World.setBlock(par2 + i1, par3, par4 + j1, 0, 0, 4);
			par1World.setBlock(par2 + i1 + 1, par3, par4 + j1, 0, 0, 4);
			par1World.setBlock(par2 + i1, par3, par4 + j1 + 1, 0, 0, 4);
			par1World.setBlock(par2 + i1 + 1, par3, par4 + j1 + 1, 0, 0, 4);
		} else {
			par1World.setBlock(par2, par3, par4, 0, 0, 4);
		}
		if (!((WorldGenerator)object).generate(par1World, par5Random, par2 + i1, par3, par4 + j1)) {
			if (flag) {
				par1World.setBlock(par2 + i1, par3, par4 + j1, this.blockID, l, 4);
				par1World.setBlock(par2 + i1 + 1, par3, par4 + j1, this.blockID, l, 4);
				par1World.setBlock(par2 + i1, par3, par4 + j1 + 1, this.blockID, l, 4);
				par1World.setBlock(par2 + i1 + 1, par3, par4 + j1 + 1, this.blockID, l, 4);
			} else {
				par1World.setBlock(par2, par3, par4, this.blockID, l, 4);
			}
		}
	}

	public boolean isSameSapling(World par1World, int par2, int par3, int par4, int par5) {
		return par1World.getBlockId(par2, par3, par4) == this.blockID && (par1World.getBlockMetadata(par2, par3, par4) & 3) == par5;
	}

	protected boolean canThisPlantGrowOnThisBlockID(int par1) {
		return par1 == RemulaBlocks.akatoeGrass.blockID || par1 == Block.dirt.blockID || par1 == Block.tilledField.blockID;
	}

	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister iconRegister) {
		icons = new Icon[4];
		
		for(int i = 0; i < icons.length; i++) {
			icons[i] = iconRegister.registerIcon("Remula:" + (this.getUnlocalizedName().substring(5)) + i);
		}
	}
	
	@SideOnly(Side.CLIENT)
	public Icon getIcon(int par1, int par2) {
		return icons[par2];
	}
	
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(int par1, CreativeTabs par2CreativeTabs, List par3List) {
		par3List.add(new ItemStack(par1, 1, 0));
		par3List.add(new ItemStack(par1, 1, 1));
		par3List.add(new ItemStack(par1, 1, 2));
		par3List.add(new ItemStack(par1, 1, 3));
	}
}
