package co.uk.silvania.Remula.client;

import co.uk.silvania.Remula.Remula;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.world.IBlockAccess;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;

public class RemulaSolarPanelRenderer extends RenderBlocks {

	/*@Override
	public void renderInventoryBlock(Block block, int metadata, int modelID,
			RenderBlocks renderer) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z,
			Block block, int modelId, RenderBlocks renderer) {
		if(ClientProxy.renderPass == 0) {
			drawPanel(Remula.remulaSolarPanel,x,y,z);
		}
		return true;
	}
	
    public void drawPanel(Block par1Block, int x, int y, int z)
{
            //change the passed integer coordinates into double precision floats, and set the height on the y axis
            double par3 = (double)x;
    double par5 = (double)y + 0.25F;
    double par7 = (double)z;
            
    //this is the scale of the squares, in blocks
    float par9 = 0.5F;
    
    //get the tessellator instance
    Tessellator var10 = Tessellator.instance;
    
    //set the texture
    int var11 = Block.blockDiamond.getBlockTextureFromSide(0);

    //do texture mapping things here
    int var12 = (var11 & 15) << 4;
    int var13 = var11 & 240;
    
    //set the uv coordinates
    double var14 = (double)((float)var12 / 256.0F);
    double var16 = (double)(((float)var12 + 15.99F) / 256.0F);
    double var18 = (double)((float)var13 / 256.0F);
    double var20 = (double)(((float)var13 + 15.99F) / 256.0F);
    
    //here the scale is changed
    double var22 = 0.45D * (double)par9;
    
    //offset the vertices from the centre of the block
    double var24 = par3 + 0.5D - var22;
    double var26 = par3 + 0.5D + var22;
    double var28 = par7 + 0.5D - var22;
    double var30 = par7 + 0.5D + var22;
    
    //not create the vertices
    var10.addVertexWithUV(var24, par5 + (double)par9, var28, var14, var18);
    var10.addVertexWithUV(var24, par5 + 0.0D, var28, var14, var20);
    var10.addVertexWithUV(var26, par5 + 0.0D, var30, var16, var20);
    var10.addVertexWithUV(var26, par5 + (double)par9, var30, var16, var18);
    var10.addVertexWithUV(var26, par5 + (double)par9, var30, var14, var18);
    var10.addVertexWithUV(var26, par5 + 0.0D, var30, var14, var20);
    var10.addVertexWithUV(var24, par5 + 0.0D, var28, var16, var20);
    var10.addVertexWithUV(var24, par5 + (double)par9, var28, var16, var18);
    var10.addVertexWithUV(var24, par5 + (double)par9, var30, var14, var18);
    var10.addVertexWithUV(var24, par5 + 0.0D, var30, var14, var20);
    var10.addVertexWithUV(var26, par5 + 0.0D, var28, var16, var20);
    var10.addVertexWithUV(var26, par5 + (double)par9, var28, var16, var18);
    var10.addVertexWithUV(var26, par5 + (double)par9, var28, var14, var18);
    var10.addVertexWithUV(var26, par5 + 0.0D, var28, var14, var20);
    var10.addVertexWithUV(var24, par5 + 0.0D, var30, var16, var20);
    var10.addVertexWithUV(var24, par5 + (double)par9, var30, var16, var18);
}
	


	@Override
	public boolean shouldRender3DInInventory() {
		return true;
	}

	@Override
	public int getRenderId() {
		return ClientProxy.remulaSolarPanelRenderType;
	}*/

}
