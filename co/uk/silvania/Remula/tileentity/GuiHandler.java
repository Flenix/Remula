package co.uk.silvania.Remula.tileentity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler {
 
	
		public GuiHandler() {
		}
        @Override
        public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
        	switch(id) {
        	case 0: {
                TileEntity tileEntity = world.getBlockTileEntity(x, y, z);
                if(tileEntity instanceof TileEntityRemulaChest) {
                        return new ContainerRemulaChest(player.inventory, (TileEntityRemulaChest) tileEntity);
                }	
        	}
            case 1: {
                TileEntity tileEntity = world.getBlockTileEntity(x, y, z);
                if(tileEntity instanceof TileEntitySilvaniteChest) {
                        return new ContainerSilvaniteChest(player.inventory, (TileEntitySilvaniteChest) tileEntity);
                }
        	}
            case 2: {
                TileEntity tileEntity = world.getBlockTileEntity(x, y, z);
                if(tileEntity instanceof TileEntityMerciliteChest) {
                        return new ContainerMerciliteChest(player.inventory, (TileEntityMerciliteChest) tileEntity);
                }
            }
            case 3: {
                TileEntity tileEntity = world.getBlockTileEntity(x, y, z);
                if(tileEntity instanceof TileEntityLITable) {
                        return new ContainerLITable(player.inventory, (TileEntityLITable) tileEntity);
                }
        	}
        }
			return null;	
    }

        @Override
        public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
        	switch(id) {
        	case 0: {
                TileEntity tileEntity = world.getBlockTileEntity(x, y, z);
                if(tileEntity instanceof TileEntityRemulaChest) {
                        return new RemulaGuiChest(player.inventory, (TileEntityRemulaChest) tileEntity);
                }	
        	}
            
        	case 1: {
                TileEntity tileEntity = world.getBlockTileEntity(x, y, z);
                if(tileEntity instanceof TileEntitySilvaniteChest) {
                        return new SilvaniteGuiChest(player.inventory, (TileEntitySilvaniteChest) tileEntity);
                }
        	}
            
        	case 2: {
                TileEntity tileEntity = world.getBlockTileEntity(x, y, z);
                if(tileEntity instanceof TileEntityMerciliteChest) {
                        return new MerciliteGuiChest(player.inventory, (TileEntityMerciliteChest) tileEntity);
                }
        	}
            case 3: {
                TileEntity tileEntity = world.getBlockTileEntity(x, y, z);
                if(tileEntity instanceof TileEntityLITable) {
                        return new LITableGui(player.inventory, (TileEntityLITable) tileEntity);
                }
        	}
        }
			return null;
    }
}