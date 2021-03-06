/*package co.uk.silvania.Remula.entity.akatoe;

import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;

public class AkatoeTradePlayer extends EntityAIBase
{
    private EntityAkatonian akatonian;

    public AkatoeTradePlayer(EntityAkatonian entityAkatonian)
    {
        this.akatonian = entityAkatonian;
        this.setMutexBits(5);
    }

    public boolean shouldExecute()
    {
        if (!this.akatonian.isEntityAlive())
        {
            return false;
        }
        else if (this.akatonian.isInWater())
        {
            return false;
        }
        else if (!this.akatonian.onGround)
        {
            return false;
        }
        else if (this.akatonian.velocityChanged)
        {
            return false;
        }
        else
        {
            EntityPlayer var1 = this.akatonian.getCustomer();
            return var1 == null ? false : (this.akatonian.getDistanceSqToEntity(var1) > 16.0D ? false : var1.openContainer instanceof Container);
        }
    }


    public void startExecuting()
    {
        this.akatonian.getNavigator().clearPathEntity();
    }

    public void resetTask()
    {
        this.akatonian.setCustomer((EntityPlayer)null);
    }
}
/**/
