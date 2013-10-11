package co.uk.silvania.Remula.tileentity.renderer;

import org.lwjgl.opengl.GL11;

import co.uk.silvania.Remula.client.models.ModelTecmoniumChest;

import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;


public class TileEntityMerciliteChestRenderer extends TileEntitySpecialRenderer {

	private final ModelTecmoniumChest model;

	public TileEntityMerciliteChestRenderer() {
		this.model = new ModelTecmoniumChest();
	}

	@Override
	public void renderTileEntityAt(TileEntity te, double x, double y, double z, float scale) {
		int i = te.getBlockMetadata();
		int meta = 180;

		if (i == 0) {
			meta = 0;
		}

		if (i == 3) {
			meta = 90;
		}

		if (i == 2) {
			meta = 180;
		}

		if (i == 1) {
			meta = 270;
		}

		Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("remula", "textures/entities/mercilitechest.png"));
		GL11.glPushMatrix();
		GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);
		GL11.glRotatef(meta, 0.0F, 1.0F, 0.0F);
		GL11.glScalef(1.0F, -1F, -1F);
		this.model.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
		GL11.glPopMatrix();
	}

	private void adjustLightFixture(World world, int i, int j, int k, Block block) {
		Tessellator tess = Tessellator.instance;
		float brightness = block.getBlockBrightness(world, i, j, k);
		int skyLight = world.getLightBrightnessForSkyBlocks(i, j, k, 0);
		int modulousModifier = skyLight % 65536;
		int divModifier = skyLight / 65536;
		tess.setColorOpaque_F(brightness, brightness, brightness);
		OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit,  (float) modulousModifier,  divModifier);
	}
}