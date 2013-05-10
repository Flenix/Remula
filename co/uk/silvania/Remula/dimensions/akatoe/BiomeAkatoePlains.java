package co.uk.silvania.Remula.dimensions.akatoe;

import co.uk.silvania.Remula.Remula;
import co.uk.silvania.Remula.entity.akatoe.EntityAkatonian;
import co.uk.silvania.Remula.entity.akatoe.EntityGlog;
import net.minecraft.world.biome.BiomeGenBase;

public class BiomeAkatoePlains extends BiomeGenBase {

	public BiomeAkatoePlains(int id) {
		super(id);
		this.setBiomeName("Akatonian Plain");
		this.setDisableRain();
		this.topBlock = (byte) Remula.akatoeGrass.blockID;
		this.fillerBlock = (byte) Remula.akatoeDirt.blockID;
		this.maxHeight = 0.5F;
		this.minHeight = 0.0F;
		this.waterColorMultiplier = 0XE42D17;
	}
}
