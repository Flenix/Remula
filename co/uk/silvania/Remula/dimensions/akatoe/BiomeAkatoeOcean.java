package co.uk.silvania.Remula.dimensions.akatoe;

import co.uk.silvania.Remula.Remula;
import co.uk.silvania.Remula.entity.akatoe.EntityGarfin;
import co.uk.silvania.Remula.entity.akatoe.EntityGlog;
import net.minecraft.block.Block;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.SpawnListEntry;

public class BiomeAkatoeOcean extends BiomeGenBase {

	public BiomeAkatoeOcean(int id) {
		super(id);
		this.setBiomeName("Akatonian Ocean");
        this.spawnableMonsterList.clear();
        this.spawnableCreatureList.clear();
        this.spawnableWaterCreatureList.clear();
        this.spawnableCreatureList.add(new SpawnListEntry(EntityGarfin.class, 10, 4, 4));
		this.topBlock = (byte) Block.waterMoving.blockID;
		this.fillerBlock = (byte) Block.waterMoving.blockID;
		this.maxHeight = 0.0F;
		this.minHeight = -0.5F;
		this.waterColorMultiplier = 0X00FF21;
	}
}
