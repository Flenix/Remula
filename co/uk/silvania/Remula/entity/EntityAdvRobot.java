package co.uk.silvania.Remula.entity;

import co.uk.silvania.Remula.Remula;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAIFollowOwner;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIOwnerHurtByTarget;
import net.minecraft.entity.ai.EntityAIOwnerHurtTarget;
import net.minecraft.entity.ai.EntityAITargetNonTamed;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class EntityAdvRobot extends EntityTameable {
	
	public EntityAdvRobot(World par1World) {
		super(par1World);
		//this.texture = "/co/uk/silvania/Remula/resources/robot.png";
		this.getNavigator().setAvoidsWater(true);
		this.setTamed(true);
		this.setSize(0.4F,  2.0F);
        this.isImmuneToFire = true;
		float var2 = 0.25F;
        //this.tasks.addTask(1, new EntityAIFollowOwner(this, this.moveSpeed, 10.0F, 2.0F));
		this.tasks.addTask(2, new EntityAIWander(this, var2));
		this.tasks.addTask(3, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
		this.tasks.addTask(4, new EntityAILookIdle(this));
        this.targetTasks.addTask(1, new EntityAIOwnerHurtByTarget(this));
        this.targetTasks.addTask(2, new EntityAIOwnerHurtTarget(this));
        this.targetTasks.addTask(3, new EntityAIHurtByTarget(this, true));
        this.targetTasks.addTask(4, new EntityAITargetNonTamed(this, EntitySpider.class, 200, false));

	}
	
/*	public boolean canPickUpLoot() {
		return true;
	}
	
	public boolean canDespawn() {
		return false;
	}*/

	public boolean isAIEnabled() {
		return true;
	}
	
	public boolean entityActivated(World world, int x, int y, int z, EntityPlayer player) {
		player.openGui(Remula.instance, 0, world, x, y, z);
		return true;
	}
	
	protected String getLivingSound() {
		return "mob.robot.say";
	}
	
	protected String getHurtSound() {
		return "mob.robot.say";
	}
	
	protected String getDeathSound() {
		return "mob.robot.death";
	}
	
	protected void playStepSound(int par1, int par2, int par3, int par4) {
		this.worldObj.playSoundAtEntity(this, "mob.robot.step", 0.15F,  1.0F);
	}
	
	protected int getDropItemId() {
		return Item.ingotIron.itemID;
	}
	
	public EntityAgeable createChild(EntityAgeable var1) {
		return null;
	}
	
	/*public void onLivingUpdate()
    {
        if (this.isInWater())
        {
            this.attackEntityFrom(DamageSource.drown, 10);
        }
        else
        {
        	return;
        }
    }*/
	
}