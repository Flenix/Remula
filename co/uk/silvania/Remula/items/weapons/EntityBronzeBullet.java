package co.uk.silvania.Remula.items.weapons;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityBronzeBullet extends EntityThrowable {
	
	public EntityBronzeBullet (World world) {
		super(world);
	}
	
	public EntityBronzeBullet(World world, EntityLiving entityLiving) {
		super(world, entityLiving);
	}
	
	public EntityBronzeBullet (World world, double par2, double par4, double par6) {
		super(world, par2, par4, par6);
	}
	
	@Override
	protected void onImpact (MovingObjectPosition movingobjetposition) {
	    {
	        if (movingobjetposition.entityHit != null)
	        {
	            byte var2 = 0;

	            movingobjetposition.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), var2);
	        }

	        for (int var3 = 0; var3 < 8; ++var3)
	        {
	            this.worldObj.spawnParticle("snowballpoof", this.posX, this.posY, this.posZ, 0.0D, 0.0D, 0.0D);
	        }

	        if (!this.worldObj.isRemote)
	        {
	            this.setDead();
	        }
	    }
	}
	
	@Override
	protected float getGravityVelocity() {
		return 0;
	}
}
