package co.uk.silvania.Remula.client;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.client.MinecraftForgeClient;
import co.uk.silvania.Remula.EntityRobot;
import co.uk.silvania.Remula.CommonProxy;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy {
	
	public void registerRenderInformation() {
		RenderingRegistry.registerEntityRenderingHandler(EntityRobot.class, new RenderRobot(new ModelRobot(), 0.5F));
	}
        
        @Override
        public void registerRenderThings() {
    		MinecraftForgeClient.preloadTexture("/co/uk/silvania/remula/blocks.png");
    		MinecraftForgeClient.preloadTexture("/co/uk/silvania/remula/items.png");
    		
        }
        
        public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        	TileEntity tileEntity = world.getBlockTileEntity(x, y, z);
        	if (tileEntity != null) {
        		switch(ID) {
        			case 0:
        				//GUIs go here!
        		}
        	}
			return tileEntity;
        }
        
}