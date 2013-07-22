package co.uk.silvania.Remula.dimensions.elkost;

import co.uk.silvania.Remula.Remula;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.SpawnListEntry;

public class BiomeElkostPlains extends BiomeGenBase {

	public BiomeElkostPlains(int id) {
		super(id);
		this.setBiomeName("Elkostian Desert");
		this.setDisableRain();
        this.spawnableMonsterList.clear();
        this.spawnableCreatureList.clear();
        this.spawnableWaterCreatureList.clear();
        //this.spawnableCreatureList.add(new SpawnListEntry(EntityGlog.class, 10, 4, 4));
		this.topBlock = (byte) Remula.elkostSand.blockID;
		this.fillerBlock = (byte) Remula.elkostSand.blockID;
		this.maxHeight = 0.5F;
		this.minHeight = 0.0F;
		this.waterColorMultiplier = 0X00FF21;
	}
}
