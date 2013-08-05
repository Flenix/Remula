package co.uk.silvania.Remula.dimensions.akatoe;

import co.uk.silvania.Remula.RemulaBlocks;
import co.uk.silvania.Remula.entity.akatoe.EntityGlog;
import co.uk.silvania.Remula.entity.akatoe.EntityHermust;
import net.minecraft.block.Block;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.SpawnListEntry;

public class BiomeAkatoeDesert extends BiomeGenBase {

	public BiomeAkatoeDesert(int id) {
		super(id);
		this.setBiomeName("Akatonian Desert");
		this.setDisableRain();
        this.spawnableMonsterList.clear();
        this.spawnableCreatureList.clear();
        this.spawnableWaterCreatureList.clear();
        this.spawnableCreatureList.add(new SpawnListEntry(EntityHermust.class, 10, 4, 4));
		this.topBlock = (byte) RemulaBlocks.akatoeSand.blockID;
		this.fillerBlock = (byte) RemulaBlocks.akatoeSand.blockID;
		this.maxHeight = 0.5F;
		this.minHeight = 0.0F;
		this.waterColorMultiplier = 0X00FF21;
	}
}
