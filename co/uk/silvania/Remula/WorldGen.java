package co.uk.silvania.Remula;

import java.util.Random;


import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenLakes;
import net.minecraft.world.gen.feature.WorldGenLiquids;
import net.minecraft.world.gen.feature.WorldGenMinable;
import cpw.mods.fml.common.IWorldGenerator;

public class WorldGen implements IWorldGenerator {
    
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world,IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
        
		switch(world.provider.dimensionId){
            case 1:
                generateNether(world, random, chunkX * 16, chunkZ * 16);
            case 0:
                generateSurface(world, random, chunkX * 16, chunkZ * 16);
            case -1:
                generateEnd(world, random, chunkX * 16, chunkZ * 16);
		}
		
	}
    
	private void generateEnd(World world, Random random, int chunkX, int chunkZ) {
		
	}
    
	private void generateSurface(World world, Random random, int chunkX, int chunkZ) {
		//Zinc
		for(int i = 0; i < 5; i++){
			int xCoord = chunkX + random.nextInt(16);
			int yCoord = random.nextInt(32);
			int zCoord = chunkZ + random.nextInt(16);
			
			(new WorldGenMinableRemula(RemulaBlocks.earthOreBlocks.blockID, 2, 5)).generate(world, random, xCoord, yCoord, zCoord);
		}
		//Silver
		for(int i = 0; i < 5; i++){
			int xCoord = chunkX + random.nextInt(16);
			int yCoord = random.nextInt(28);
			int zCoord = chunkZ + random.nextInt(16);
			
			(new WorldGenMinableRemula(RemulaBlocks.earthOreBlocks.blockID, 3, 5)).generate(world, random, xCoord, yCoord, zCoord);
		}
		//Mercilite
		for(int i = 0; i < 4; i++){
			int xCoord = chunkX + random.nextInt(16);
			int yCoord = random.nextInt(20);
			int zCoord = chunkZ + random.nextInt(16);
			
			(new WorldGenMinableRemula(RemulaBlocks.earthOreBlocks.blockID, 5, 4)).generate(world, random, xCoord, yCoord, zCoord);
		}
		//Silvanite
		for(int i = 0; i < 3; i++){
			int xCoord = chunkX + random.nextInt(16);
			int yCoord = random.nextInt(20);
			int zCoord = chunkZ + random.nextInt(16);
			
			(new WorldGenMinableRemula(RemulaBlocks.earthOreBlocks.blockID, 6, 5)).generate(world, random, xCoord, yCoord, zCoord);
		}
	}
    
	private void generateNether(World world, Random random, int chunkX, int chunkZ) {
		
	}    
}