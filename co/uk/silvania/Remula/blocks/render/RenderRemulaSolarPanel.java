package co.uk.silvania.Remula.blocks.render;

import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.world.IBlockAccess;
import org.lwjgl.opengl.GL11;

import co.uk.silvania.Remula.powergrid.blocks.tileentity.TileEntityRemulaSolarPanel;

	public class RenderRemulaSolarPanel implements ISimpleBlockRenderingHandler {
		final int renderID;
		private final TileEntityRemulaSolarPanel table = new TileEntityRemulaSolarPanel();

		public RenderRemulaSolarPanel(int var1) {
			this.renderID = var1;
		}

		public void renderNasaBench(RenderBlocks renderBlocks, IBlockAccess iblockaccess, Block par1Block, int par2, int par3, int par4) {
			renderBlocks.overrideBlockTexture = par1Block.blockIndexInTexture;
			renderBlocks.setRenderBounds(0.0D, 0.0D, 0.0D, 1.0D, 0.9200000166893005D, 1.0D);
			renderBlocks.renderStandardBlock(par1Block, par2, par3, par4);
			renderBlocks.overrideBlockTexture = -1;
		}

		public void renderInventoryBlock(Block block, int metadata, int modelID, RenderBlocks renderer) {
			GL11.glRotatef(90.0F, 0.0F, 1.0F, 0.0F);
			GL11.glTranslatef(-0.5F, -1.1F, -0.1F);
			GL11.glScalef(0.7F, 0.6F, 0.7F);
			TileEntityRenderer.instance.renderTileEntityAt(this.table, 0.0D, 0.0D, 0.0D, 0.0F);
			GL11.glEnable(32826);
		}

		public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer) {
			renderNasaBench(renderer, world, block, x, y, z);
			return true;
		}

		public boolean shouldRender3DInInventory() {
			return true;
		}

		public int getRenderId() {
			return this.renderID;
		}
	}
