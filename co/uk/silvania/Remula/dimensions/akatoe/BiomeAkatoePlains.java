package co.uk.silvania.Remula.dimensions.akatoe;

import java.util.Random;

import co.uk.silvania.Remula.Remula;
import co.uk.silvania.Remula.entity.akatoe.EntityGlog;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.SpawnListEntry;
import net.minecraft.world.gen.feature.WorldGenerator;

public class BiomeAkatoePlains extends BiomeGenBase {
	
	AkatoeBiomeDecorator thebiomedecorator = new AkatoeBiomeDecorator();
	private Object currentWorld;
	private Random randomGenerator;
	private int chunk_X;
	private int chunk_Z;
	private WorldGenerator WorldGenAkatoeTrees;
	
	public BiomeAkatoePlains(int id) {
		super(id);
		this.setBiomeName("Akatonian Plain");
		this.setDisableRain();
        this.spawnableMonsterList.clear();
        this.spawnableCreatureList.clear();
        this.spawnableWaterCreatureList.clear();
        this.spawnableCreatureList.add(new SpawnListEntry(EntityGlog.class, 10, 4, 4));
		this.topBlock = (byte) Remula.akatoeGrass.blockID;
		this.fillerBlock = (byte) Remula.akatoeDirt.blockID;
		this.maxHeight = 0.5F;
		this.minHeight = 0.0F;
		this.waterColorMultiplier = 0X00FF21;
	}


    public void akatoebiomedecorator(World par1World, Random par2Random, int par3, int par4) {
    	if (this.currentWorld != null) {
    		throw new RuntimeException("Already decorating!!");
    	} else {
            this.currentWorld = par1World;
            this.randomGenerator = par2Random;
            this.chunk_X = par3;
            this.chunk_Z = par4;
            this.currentWorld = null;
            this.randomGenerator = null;
            
            
    	}
    }
    
    public WorldGenerator getRandomWorldGenForTrees(Random random) {
    	return (WorldGenerator) (random.nextInt(5) == 0 ? this.worldGeneratorForest : (random.nextInt(10) == 0 ? this.WorldGenAkatoeTrees : this.worldGeneratorTrees));
    }
}
