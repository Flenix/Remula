package co.uk.silvania.Remula.tileentity.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

import org.lwjgl.opengl.GL11;

import co.uk.silvania.Remula.tileentity.TileEntityLITable;
import co.uk.silvania.Remula.tileentity.container.ContainerLITable;

public class LITableGui extends GuiContainer {

        public LITableGui (InventoryPlayer inventoryPlayer, TileEntityLITable tileEntity) {
                                super(new ContainerLITable(inventoryPlayer, tileEntity));
        }
        
        /** The X size of the inventory window in pixels. */
        protected int xSize = 176;

        /** The Y size of the inventory window in pixels. */
        protected int ySize = 166;

        @Override
        protected void drawGuiContainerForegroundLayer(int param1, int param2) {
                fontRenderer.drawString("Liquid Infusion Table", 7, 6, 4210752);
                fontRenderer.drawString(StatCollector.translateToLocal("container.inventory"), 7, ySize - 93, 4210752);
        }

        @Override
        protected void drawGuiContainerBackgroundLayer(float par1, int par2,
                        int par3) {
                GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
                Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("remula", "textures/gui/infuser.png"));
                int x = (width - xSize) / 2;
                int y = (height - ySize) / 2;
                this.drawTexturedModalRect(x, y, 0, 0, xSize, ySize);
        }

}