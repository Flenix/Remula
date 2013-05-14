package co.uk.silvania.Remula.tileentity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;

public class RemulaGuiHandler implements IGuiHandler {
        @Override
        public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
                TileEntity tileEntity = world.getBlockTileEntity(x, y, z);
                if(tileEntity instanceof TileEntityRemulaChest) {
                        return new ContainerRemulaChest(player.inventory, (TileEntityRemulaChest) tileEntity);
                }
                return null;
        }

        @Override
        public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
                TileEntity tileEntity = world.getBlockTileEntity(x, y, z);
                if(tileEntity instanceof TileEntityRemulaChest) {
                        return new RemulaGuiChest(player.inventory, (TileEntityRemulaChest) tileEntity);
                }
                return null;
        }
}