package co.uk.silvania.Remula.dimensions.xylexia;

import co.uk.silvania.Remula.Remula;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;

public class XylexiaGenLayerBiomes extends GenLayer {

	protected BiomeGenBase[] allowedBiomes = {Remula.xylexiaPlainsBiome};

	public XylexiaGenLayerBiomes(long seed, GenLayer genlayer) {
		super(seed);
		this.parent = genlayer;
	}

	public XylexiaGenLayerBiomes(long seed) {
		super(seed);
	}

	@Override
	public int[] getInts(int x, int z, int width, int depth) {
		int[] dest = IntCache.getIntCache(width*depth);

		for (int dz=0; dz<depth; dz++) {
			for (int dx=0; dx<width; dx++) {
				this.initChunkSeed(dx+x, dz+z);
				dest[(dx+dz*width)] = this.allowedBiomes[nextInt(this.allowedBiomes.length)].biomeID;
			}
		}
		return dest;
	}
}