package co.uk.silvania.Remula.dimensions.xylexia;

import co.uk.silvania.Remula.Remula;
import co.uk.silvania.Remula.entity.akatoe.EntityAkatonian;
import co.uk.silvania.Remula.entity.akatoe.EntityGlog;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.SpawnListEntry;

public class BiomeXylexiaPlains extends BiomeGenBase {

	public BiomeXylexiaPlains(int id) {
		super(id);
		this.setBiomeName("Xylexian Plains");
		this.setDisableRain();
        this.spawnableMonsterList.clear();
        this.spawnableCreatureList.clear();
        this.spawnableWaterCreatureList.clear();
        this.spawnableCreatureList.add(new SpawnListEntry(EntityGlog.class, 10, 4, 4));
		this.topBlock = (byte) Remula.xylexianStone.blockID;
		this.fillerBlock = (byte) Remula.xylexianStone.blockID;
		this.maxHeight = 0.5F;
		this.minHeight = 0.0F;
		this.waterColorMultiplier = 0X00FF21;
	}
}