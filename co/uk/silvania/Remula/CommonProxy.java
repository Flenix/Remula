package co.uk.silvania.Remula;

import co.uk.silvania.Remula.entity.EntityAdvRobot;
import co.uk.silvania.Remula.entity.akatoe.EntityAkatonian;
import co.uk.silvania.Remula.entity.akatoe.EntityGlog;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.registry.EntityRegistry;

public class CommonProxy implements IGuiHandler {
	
	public void registerRenderInformation() {}
	
		public void init () {
			registerRenderInformation();
			
        }
		
		public int addArmor(String string) {
			return 0;
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
		
        public static String ITEMS_PNG = "/co/uk/silvania/remula/resources/items.png";
        public static String BLOCK_PNG = "/co/uk/silvania/remula/resources/blocks.png";
        public static String AKATOEBLOCKS_PNG = "/co/uk/silvania/remula/resources/akatoeblocks.png";
        public static String AKATOEITEMS_PNG = "/co/uk/silvania/remula/resources/akatoeitems.png";
        public static String BALOINUSBLOCKS_PNG = "/co/uk/silvania/remula/resources/baloinusblocks.png";
        public static String BALOINUSITEMS_PNG = "/co/uk/silvania/remula/resources/baloinusitems.png";
        public static String DEEPSPACEBLOCKS_PNG = "/co/uk/silvania/remula/resources/deepspaceblocks.png";
        public static String DEEPSPACEITEMS_PNG = "/co/uk/silvania/remula/resources/deepspaceitems";
        
        public void registerRenderThings() {
        }
        
        public World getClientWorld() {
            return null;
        }

}