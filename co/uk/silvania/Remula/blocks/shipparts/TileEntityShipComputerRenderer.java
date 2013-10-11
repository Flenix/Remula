package co.uk.silvania.Remula.blocks.shipparts;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import co.uk.silvania.Remula.client.ShipComputerModel;

public class TileEntityShipComputerRenderer extends TileEntitySpecialRenderer {

    private ShipComputerModel model;

    public TileEntityShipComputerRenderer() {
        model = new ShipComputerModel();
    }

    @Override
    public void renderTileEntityAt(TileEntity te, double x, double y, double z, float scale) {
        int rotation = 180;
        switch (te.getBlockMetadata()) {
            case 0:
                rotation = 0;
                break;
            case 3:
                rotation = 90;
                break;
            case 2:
                rotation = 180;
                break;
            case 1:
                rotation = 270;
                break;
        }

        GL11.glPushMatrix();
        Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("remula", "textures/entities/shipcomputer.png"));
        GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);
        GL11.glRotatef(rotation, 0.0F, 1.0F, 0.0F);
        GL11.glScalef(1.0F, -1F, -1F);
        model.render((Entity) null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
        GL11.glPopMatrix();
    }
}