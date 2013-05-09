package co.uk.silvania.Remula.entity.akatoe;

import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.player.EntityPlayer;

public class AkatoeLookAtTradePlayer extends EntityAIWatchClosest
{
    private final EntityAkatonian theMerchant;

    public AkatoeLookAtTradePlayer(EntityAkatonian par1EntityAkatonian)
    {
        super(par1EntityAkatonian, EntityPlayer.class, 8.0F);
        this.theMerchant = par1EntityAkatonian;
    }

    /**
     * Returns whether the EntityAIBase should begin execution.
     */
    public boolean shouldExecute()
    {
        if (this.theMerchant.isTrading())
        {
            this.closestEntity = this.theMerchant.getCustomer();
            return true;
        }
        else
        {
            return false;
        }
    }
}
