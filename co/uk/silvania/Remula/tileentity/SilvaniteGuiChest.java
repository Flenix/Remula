package co.uk.silvania.Remula.tileentity;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.StatCollector;

import org.lwjgl.opengl.GL11;

public class SilvaniteGuiChest extends GuiContainer {

        public SilvaniteGuiChest (InventoryPlayer inventoryPlayer, TileEntitySilvaniteChest tileEntity) {
                                super(new ContainerSilvaniteChest(inventoryPlayer, tileEntity));
        }
        
        /** The X size of the inventory window in pixels. */
        protected int xSize = 194;

        /** The Y size of the inventory window in pixels. */
        protected int ySize = 222;

        @Override
        protected void drawGuiContainerForegroundLayer(int param1, int param2) {
                fontRenderer.drawString("Silvanite Chest", 0, -22, 4210752);
                fontRenderer.drawString(StatCollector.translateToLocal("container.inventory"), 0, ySize - 122, 4210752);
        }

        @Override
        protected void drawGuiContainerBackgroundLayer(float par1, int par2,
                        int par3) {
                int texture = mc.renderEngine.getTexture("/co/uk/silvania/Remula/gui/silvanitechest.png");
                GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
                this.mc.renderEngine.bindTexture(texture);
                int x = (width - xSize) / 2;
                int y = (height - ySize) / 2;
                this.drawTexturedModalRect(x, y, 0, 0, xSize, ySize);
        }

}