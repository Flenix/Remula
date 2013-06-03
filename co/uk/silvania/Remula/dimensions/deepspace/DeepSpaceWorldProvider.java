package co.uk.silvania.Remula.dimensions.deepspace;

import co.uk.silvania.Remula.Remula;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.Vec3;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.WorldChunkManagerHell;
import net.minecraft.world.chunk.IChunkProvider;

public class DeepSpaceWorldProvider extends WorldProvider {
	
	public String getDimensionName() {
		return "Deep Space";
	}
	
	public boolean canRespawnHere() {
		return true;
	}
	
	public void registerWorldChunkManager() {
		this.worldChunkMgr = new WorldChunkManagerHell(BiomeGenBase.sky, 0.5F, 0.0F);
		this.dimensionId = Remula.deepSpaceDimension;
		this.hasNoSky = false;
		this.setWorldTime(18000);
	}
	
	@Override
	public IChunkProvider createChunkGenerator() {
		return new DeepSpaceChunkProvider(worldObj, worldObj.getSeed());
	}
	
    public Vec3 getFogColor(float par1, float par2)
    {
        return this.worldObj.getWorldVec3Pool().getVecFromPool(0.00000000000000000D, 0.00000000000000000D, 0.00000000000000000D);
    }
	
	public String getSaveFolder() {
		return "DIM_DEEPSPACE";
	}
	
	public String getWelcomeMessage() {
		return "You are now in Deep Space!";
	}
	
	public String getDepartMessage() {
		return "You are now leaving Deep Space!";
	}
	
	public String getSunTexture() {
		return "bla";
	}
	
	public String getMoonTexture() {
		return "la";
	}
	
	public int setFogColor() {
		return 000000;
	}
	
    public boolean onTickInGame(float f, Minecraft minecraft, EntityPlayerMP mp)
    {
    	EntityPlayerMP thePlayer = (EntityPlayerMP) mp;
    	
    	if (minecraft.thePlayer.dimension == Remula.deepSpaceDimension) 
        {
    		if (minecraft.thePlayer.jumpMovementFactor == 5F)
    		{
    			if (thePlayer.isJumping = true)
    			{
    				minecraft.thePlayer.motionY /= 1.8000000238418579D;
    				minecraft.thePlayer.fallDistance = 0.0F;
    			}
    		}
        }
    	return true;
    }
    
    public float calculateCelestialAngle(long par1, float par3)
    {
    	return 1000.11F;	 
    } 	

}
