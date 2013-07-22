package co.uk.silvania.Remula.entity.baloinus;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.world.World;

public class EntityXylexian extends EntityMob {

	public EntityXylexian(World world) {
		super(world);
		//this.texture = "/co/uk/silvania/Remula/resources/mobxylexian.png";
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(1, new EntityAIAttackOnCollide(this, EntityPlayer.class, 3.0D, false));
		this.tasks.addTask(2, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
		this.tasks.addTask(3, new EntityAIWander(this, 3.0D));
		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
	}
	
	public int getTotalArmorValue() {
		return 4;
	}
	
	protected boolean isAIEnabled() {
		return true;
	}
	

	protected void func_110147_ax() {
		super.func_110147_ax();
		this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(300.0D); 
	}
	
	public EnumCreatureAttribute getCreatureAttribute() {
		return EnumCreatureAttribute.UNDEFINED;
	}
	
	protected String getLivingSound() {
		return "mob.zombie.say";
	}
	
	protected String getHurtSound() {
		return "mob.zombie.hurt";
	}

	protected String getDeathSound() {
		return "mob.zombie.death";
	}
	
	protected void playStepSound(int par1, int par2, int par3, int par4) {
		this.worldObj.playSoundAtEntity(this, "mob.zombie.wood", 0.15F, 1.0F);
	}
	
	protected int getDroItemId() {
		return Item.arrow.itemID;
	}
	
	protected void dropRareDrop(int par1) {
		switch(this.rand.nextInt(2)) {
		case 0:
			this.dropItem(Item.shovelIron.itemID, 1);
		case 1:
			this.dropItem(Block.blockDiamond.blockID, this.rand.nextInt(3) + 1);
		}
	}
	
	protected void dropFewItems(boolean par1, int par2) {
		if(this.rand.nextInt(4) == 0) {
			this.dropItem(Item.appleRed.itemID, 5);
		}
	}
}
