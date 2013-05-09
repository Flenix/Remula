package co.uk.silvania.Remula.dimensions;

import co.uk.silvania.Remula.Remula;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.WorldChunkManagerHell;
import net.minecraft.world.chunk.IChunkProvider;

public class AkatoeWorldProvider extends WorldProvider {
	
	

	public String getDimensionName() {
		return "Akatoe";
	}
	
	public boolean canRespawnHere() {
		return true;
	}
	
	public void registerWorldChunkManager() {
		this.worldChunkMgr = new AkatoeChunkManager(BiomeGenBase.plains);
		this.dimensionId = Remula.akatoeDimension;
	}
	
	@Override
	public IChunkProvider createChunkGenerator() {
		return new AkatoeChunkProvider(worldObj, worldObj.getSeed(), true);
	}
	
	public String getSaveFolder() {
		return "DIM_AKATOE";
	}
	
	public String getWelcomeMessage() {
		return "You are now in Akatoe!";
	}
	
	public String getDepartMessage() {
		return "You are now leaving Akatoe!";
	}
	
	public String getSunTexture() {
		return "bla";
	}
	
	public String getMoonTexture() {
		return "la";
	}
	
	public int setFogColor() {
		return 123456;
	}
	
    public boolean onTickInGame(float f, Minecraft minecraft, EntityPlayerMP mp)
    {
    	EntityPlayerMP thePlayer = (EntityPlayerMP) mp;
    	
    	if (minecraft.thePlayer.dimension == Remula.akatoeDimension) 
        {
    		if (minecraft.thePlayer.jumpMovementFactor == 1F)
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
    	return 1.11F;	 
    } 	

}
