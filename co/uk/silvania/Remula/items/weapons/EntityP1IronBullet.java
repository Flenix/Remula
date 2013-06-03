package co.uk.silvania.Remula.items.weapons;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityP1IronBullet extends EntityThrowable
{
    private int explosionRadius = 3;
	
    public EntityP1IronBullet(World world)
    {
    	super(world);
    }
   
    public EntityP1IronBullet(World world, EntityLiving entity)
    {
    	super(world, entity);
    }
   
    public EntityP1IronBullet(World world, double par2, double par4, double par6)
    {
    	super(world, par2, par4, par6);
    }
   
    @Override
    protected void onImpact(MovingObjectPosition movingobjectposition) {
   		this.worldObj.createExplosion(this, this.posX, this.posY, this.posZ, (float)this.explosionRadius, true);
		this.setDead();
    }
}