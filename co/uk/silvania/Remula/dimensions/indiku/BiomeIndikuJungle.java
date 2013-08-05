package co.uk.silvania.Remula.dimensions.indiku;

import co.uk.silvania.Remula.Remula;
import co.uk.silvania.Remula.RemulaBlocks;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.SpawnListEntry;

public class BiomeIndikuJungle extends BiomeGenBase {

	public BiomeIndikuJungle(int id) {
		super(id);
		this.setBiomeName("Indikian Jungle");
		this.setDisableRain();
        this.spawnableMonsterList.clear();
        this.spawnableCreatureList.clear();
        this.spawnableWaterCreatureList.clear();
        //this.spawnableCreatureList.add(new SpawnListEntry(EntityGlog.class, 10, 4, 4));
		this.topBlock = (byte) RemulaBlocks.indikuGrass.blockID;
		this.fillerBlock = (byte) RemulaBlocks.indikuDirt.blockID;
		this.maxHeight = 0.5F;
		this.minHeight = 0.0F;
		this.waterColorMultiplier = 0X002000;
	}
}
