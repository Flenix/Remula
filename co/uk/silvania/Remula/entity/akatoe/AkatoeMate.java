package co.uk.silvania.Remula.entity.akatoe;

import net.minecraft.entity.Entity;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.util.MathHelper;
import net.minecraft.village.Village;
import net.minecraft.world.World;

public class AkatoeMate extends EntityAIBase
{
    private EntityAkatonian akatonianObj;
    private EntityAkatonian mate;
    private World worldObj;
    private int matingTimeout = 0;
    Village villageObj;

    public AkatoeMate(EntityAkatonian par1EntityAkatonian)
    {
        this.akatonianObj = par1EntityAkatonian;
        this.worldObj = par1EntityAkatonian.worldObj;
        this.setMutexBits(3);
    }

    /**
     * Returns whether the EntityAIBase should begin execution.
     */
    public boolean shouldExecute()
    {
        if (this.akatonianObj.getGrowingAge() != 0)
        {
            return false;
        }
        else if (this.akatonianObj.getRNG().nextInt(500) != 0)
        {
            return false;
        }
        else
        {
            this.villageObj = this.worldObj.villageCollectionObj.findNearestVillage(MathHelper.floor_double(this.akatonianObj.posX), MathHelper.floor_double(this.akatonianObj.posY), MathHelper.floor_double(this.akatonianObj.posZ), 0);

            if (this.villageObj == null)
            {
                return false;
            }
            else if (!this.checkSufficientDoorsPresentForNewVillager())
            {
                return false;
            }
            else
            {
                Entity var1 = this.worldObj.findNearestEntityWithinAABB(EntityAkatonian.class, this.akatonianObj.boundingBox.expand(8.0D, 3.0D, 8.0D), this.akatonianObj);

                if (var1 == null)
                {
                    return false;
                }
                else
                {
                    this.mate = (EntityAkatonian)var1;
                    return this.mate.getGrowingAge() == 0;
                }
            }
        }
    }

    /**
     * Execute a one shot task or start executing a continuous task
     */
    public void startExecuting()
    {
        this.matingTimeout = 300;
        this.akatonianObj.setMating(true);
    }

    /**
     * Resets the task
     */
    public void resetTask()
    {
        this.villageObj = null;
        this.mate = null;
        this.akatonianObj.setMating(false);
    }

    /**
     * Returns whether an in-progress EntityAIBase should continue executing
     */
    public boolean continueExecuting()
    {
        return this.matingTimeout >= 0 && this.checkSufficientDoorsPresentForNewVillager() && this.akatonianObj.getGrowingAge() == 0;
    }

    /**
     * Updates the task
     */
    public void updateTask()
    {
        --this.matingTimeout;
        this.akatonianObj.getLookHelper().setLookPositionWithEntity(this.mate, 10.0F, 30.0F);

        if (this.akatonianObj.getDistanceSqToEntity(this.mate) > 2.25D)
        {
            this.akatonianObj.getNavigator().tryMoveToEntityLiving(this.mate, 0.25F);
        }
        else if (this.matingTimeout == 0 && this.mate.isMating())
        {
            this.giveBirth();
        }

        if (this.akatonianObj.getRNG().nextInt(35) == 0)
        {
            this.worldObj.setEntityState(this.akatonianObj, (byte)12);
        }
    }

    private boolean checkSufficientDoorsPresentForNewVillager()
    {
        if (!this.villageObj.isMatingSeason())
        {
            return false;
        }
        else
        {
            int var1 = (int)((double)((float)this.villageObj.getNumVillageDoors()) * 0.35D);
            return this.villageObj.getNumVillagers() < var1;
        }
    }

    private void giveBirth()
    {
        EntityAkatonian var1 = this.akatonianObj.func_90012_b(this.mate);
        this.mate.setGrowingAge(6000);
        this.akatonianObj.setGrowingAge(6000);
        var1.setGrowingAge(-24000);
        var1.setLocationAndAngles(this.akatonianObj.posX, this.akatonianObj.posY, this.akatonianObj.posZ, 0.0F, 0.0F);
        this.worldObj.spawnEntityInWorld(var1);
        this.worldObj.setEntityState(var1, (byte)12);
    }
}
