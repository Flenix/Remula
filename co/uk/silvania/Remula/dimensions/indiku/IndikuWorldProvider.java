package co.uk.silvania.Remula.dimensions.indiku;

import co.uk.silvania.Remula.Remula;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.WorldChunkManagerHell;
import net.minecraft.world.chunk.IChunkProvider;

public class IndikuWorldProvider extends WorldProvider {
	
	

	public String getDimensionName() {
		return "Indiku";
	}
	
	public boolean canRespawnHere() {
		return true;
	}
	
	public void registerWorldChunkManager() {
		this.worldChunkMgr = new IndikuChunkManager(Remula.indikuJungleBiome);
        //worldChunkMgr = terrainType.getChunkManager(worldObj);
		this.dimensionId = Remula.indikuDimension;
	}
	
	@Override
	public IChunkProvider createChunkGenerator() {
		return new IndikuChunkProvider(worldObj, worldObj.getSeed(), true);
	}
	
	public String getSaveFolder() {
		return "DIM_INDIKU";
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
	
    /*public boolean onTickInGame(float f, Minecraft minecraft, EntityPlayerMP mp)
    {
    	EntityPlayerMP thePlayer = (EntityPlayerMP) mp;
    	
    	if (minecraft.thePlayer.dimension == Remula.indikuDimension) 
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
    }*/
    
    public float calculateCelestialAngle(long par1, float par3)
    {
    	return 1.11F;	 
    } 	

}
