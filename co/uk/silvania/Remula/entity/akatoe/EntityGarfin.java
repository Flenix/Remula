package co.uk.silvania.Remula.entity.akatoe;

import co.uk.silvania.Remula.Remula;
import net.minecraft.entity.passive.EntityWaterMob;
import net.minecraft.world.World;

public class EntityGarfin extends EntityWaterMob {

	public EntityGarfin(World par1World) {
		super(par1World);
        this.texture = "/co/uk/silvania/Remula/resources/mobgarfin.png";
        this.setSize(0.95F, 0.95F);
        this.field_70864_bA = 1.0F / (this.rand.nextFloat() + 1.0F) * 0.2F;
	}
	
    private float field_70864_bA = 0.0F;

	@Override
	public int getMaxHealth() {
		return 16;
	}
	
	protected int getDropItemId() {
		return Remula.rawGarfinMeat.itemID;
	}

}
