package co.uk.silvania.Remula;

import co.uk.silvania.Remula.entity.EntityAdvRobot;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.registry.EntityRegistry;

public class CommonProxy implements IGuiHandler {
	
	public void registerRenderInformation() {}
	
		public void init () {
			EntityRegistry.registerGlobalEntityID(EntityAdvRobot.class, "Robot", EntityRegistry.findGlobalUniqueEntityId(), 3515848, 12102);
			registerRenderInformation();
        }

		@Override
		public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
			TileEntity tileEntity = world.getBlockTileEntity(x, y, z);
			
			if(tileEntity != null) {
				switch(ID) {
					case 0:
					//Containers
				}
			}
			return tileEntity;
		}

		@Override
		public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {

			return null;
		}
		
        public static String ITEMS_PNG = "/co/uk/silvania/remula/items.png";
        public static String BLOCK_PNG = "/co/uk/silvania/remula/blocks.png";
        public static String AKATOEBLOCKS_PNG = "/co/uk/silvania/remula/akatoeblocks.png";
        
        public void registerRenderThings() {
        }

}