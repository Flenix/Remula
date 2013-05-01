package co.uk.silvania.Remula.dimensions;

import co.uk.silvania.Remula.Remula;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.WorldChunkManagerHell;
import net.minecraft.world.chunk.IChunkProvider;

public class AkatoeWorldProvider extends WorldProvider {

	public String getDimensionName() {
		return "Akatoe";
	}
	
	public boolean canRespawnHere() {
		return true;
	}
	
	public void registerWorldChunkManager() {
		this.worldChunkMgr = new WorldChunkManagerHell(BiomeGenBase.beach, 0.8F, 0.1F);
		this.dimensionId = Remula.akatoeDimension;
	}
	
	@Override
	public IChunkProvider createChunkGenerator() {
		return new AkatoeChunkProvider(worldObj, worldObj.getSeed(), true);
	}
	
	public String getSaveFolder() {
		return "Akatoe";
	}

}
