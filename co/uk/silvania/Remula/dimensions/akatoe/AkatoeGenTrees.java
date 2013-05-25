/*package co.uk.silvania.Remula.dimensions.akatoe;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSapling;
import net.minecraft.util.Direction;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.ForgeDirection;

public class AkatoeGenTrees extends WorldGenerator
{
    /** The minimum height of a generated tree. */
    /*private final int minTreeHeight;

    /** The metadata value of the wood to use in tree generation. */
    //private final int metaWood;

    /** The metadata value of the leaves to use in tree generation. */
    /*private final int metaLeaves;

    public AkatoeGenTrees(boolean par1)
    {
        this(par1, 4, 0, 0, false);
    }

    public AkatoeGenTrees(boolean par1, int par2, int par3, int par4, boolean par5)
    {
        super(par1);
        this.minTreeHeight = par2;
        this.metaWood = par3;
        this.metaLeaves = par4;
    }

    public boolean generate(World par1World, Random par2Random, int par3, int par4, int par5)
    {
        int var6 = par2Random.nextInt(3) + this.minTreeHeight;
        boolean var7 = true;

        if (par4 >= 1 && par4 + var6 + 1 <= 256)
        {
            int var8;
            byte var9;
            int var11;
            int var12;

            for (var8 = par4; var8 <= par4 + 1 + var6; ++var8)
            {
                var9 = 1;

                if (var8 == par4)
                {
                    var9 = 0;
                }

                if (var8 >= par4 + 1 + var6 - 2)
                {
                    var9 = 2;
                }

                for (int var10 = par3 - var9; var10 <= par3 + var9 && var7; ++var10)
                {
                    for (var11 = par5 - var9; var11 <= par5 + var9 && var7; ++var11)
                    {
                        if (var8 >= 0 && var8 < 256)
                        {
                            var12 = par1World.getBlockId(var10, var8, var11);

                            Block block = Block.blocksList[var12];

                            if (block != null &&
                               !block.isLeaves(par1World, var10, var8, var11) &&
                               !block.canSustainPlant(par1World, var10, var8, var11, ForgeDirection.UP, (BlockSapling)Block.sapling) &&
                               !block.isWood(par1World, var10, var8, var11))
                            {
                                var7 = false;
                            }
                        }
                        else
                        {
                            var7 = false;
                        }
                    }
                }
            }

            if (!var7)
            {
                return false;
            }
            else
            {
                var8 = par1World.getBlockId(par3, par4 - 1, par5);
                Block soil = Block.blocksList[var8];
                boolean isSoil = (soil != null && soil.canSustainPlant(par1World, par3, par4 - 1, par5, ForgeDirection.UP, (BlockSapling)Block.sapling));

                if (isSoil && par4 < 256 - var6 - 1)
                {
                    soil.onPlantGrow(par1World, par3, par4 - 1, par5, par3, par4, par5);
                    var9 = 3;
                    byte var18 = 0;
                    int var13;
                    int var14;
                    int var15;

                    for (var11 = par4 - var9 + var6; var11 <= par4 + var6; ++var11)
                    {
                        var12 = var11 - (par4 + var6);
                        var13 = var18 + 1 - var12 / 2;

                        for (var14 = par3 - var13; var14 <= par3 + var13; ++var14)
                        {
                            var15 = var14 - par3;

                            for (int var16 = par5 - var13; var16 <= par5 + var13; ++var16)
                            {
                                int var17 = var16 - par5;

                                Block block = Block.blocksList[par1World.getBlockId(var14, var11, var16)];

                                if ((Math.abs(var15) != var13 || Math.abs(var17) != var13 || par2Random.nextInt(2) != 0 && var12 != 0) &&
                                    (block == null || block.canBeReplacedByLeaves(par1World, var14, var11, var16)))
                                {
                                    this.setBlockAndMetadata(par1World, var14, var11, var16, Block.leaves.blockID, this.metaLeaves);
                                }
                            }
                        }
                    }

                    for (var11 = 0; var11 < var6; ++var11)
                    {
                        var12 = par1World.getBlockId(par3, par4 + var11, par5);

                        Block block = Block.blocksList[var12];

                        if (var12 == 0 || block == null || block.isLeaves(par1World, par3, par4 + var11, par5))
                        {
                            this.setBlockAndMetadata(par1World, par3, par4 + var11, par5, Block.wood.blockID, this.metaWood);

                         
                            }
                        }
                    }

                if (par2Random.nextInt(5) == 0 && var6 > 5) {
                	int var13;
                    for (var11 = 0; var11 < 2; ++var11) {
                    	for (var12 = 0; var12 < 4; ++var12) {
                    		if (par2Random.nextInt(4 - var11) == 0) {
                    			var13 = par2Random.nextInt(3);
                    			this.setBlockAndMetadata(par1World, par3 + Direction.offsetX[Direction.footInvisibleFaceRemap[var12]], par4 + var6 - 5 + var11, par5 + Direction.offsetZ[Direction.footInvisibleFaceRemap[var12]], Block.cocoaPlant.blockID, var13 << 2 | var12);
                            }
                        }
                    }
                }
            }

            return true;
        }
        else
        {
        	return false;
        }
    }
}*/
