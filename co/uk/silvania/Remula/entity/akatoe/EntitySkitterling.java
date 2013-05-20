package co.uk.silvania.Remula.entity.akatoe;

import co.uk.silvania.Remula.Remula;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAIControlledByPlayer;
import net.minecraft.entity.ai.EntityAIFollowOwner;
import net.minecraft.entity.ai.EntityAIFollowParent;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMate;
import net.minecraft.entity.ai.EntityAIOwnerHurtByTarget;
import net.minecraft.entity.ai.EntityAIOwnerHurtTarget;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAITargetNonTamed;
import net.minecraft.entity.ai.EntityAITempt;
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

public class EntitySkitterling extends EntityAnimal {
	
	public EntitySkitterling(World par1World) {
		super(par1World);
		this.texture = "/co/uk/silvania/Remula/resources/mobskitterling.png";
		this.getNavigator().setAvoidsWater(true);
		this.setSize(1.5F, 0.9F);
        this.isImmuneToFire = true;
		float var2 = 0.25F;
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, new EntityAIPanic(this, 0.38F));
        this.tasks.addTask(2, new EntityAIMate(this, var2));
        this.tasks.addTask(3, new EntityAIFollowParent(this, 0.28F));
        this.tasks.addTask(4, new EntityAIWander(this, var2));
        this.tasks.addTask(5, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
        this.tasks.addTask(6, new EntityAILookIdle(this));
	}

	public boolean isAIEnabled() {
		return true;
	}
	
	public int getMaxHealth() {
		return 3;
	}
	
	protected String getLivingSound() {
		return "mob.skitterling.say";
	}
	
	protected String getHurtSound() {
		return "mob.skitterling.say";
	}
	
	protected String getDeathSound() {
		return "mob.skitterling.death";
	}
	
	protected void playStepSound(int par1, int par2, int par3, int par4) {
		this.worldObj.playSoundAtEntity(this, "mob.skitterling.step", 0.15F,  1.0F);
	}
	
	protected int getDropItemId() {
		return Remula.skitterlingDead.itemID;
	}
	
	public EntityAgeable createChild(EntityAgeable var1) {
		return null;
	}
}