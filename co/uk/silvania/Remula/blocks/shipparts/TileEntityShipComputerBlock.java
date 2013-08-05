package co.uk.silvania.Remula.blocks.shipparts;

import co.uk.silvania.Remula.Remula;
import co.uk.silvania.Remula.dimensions.TeleporterAkatoe;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class TileEntityShipComputerBlock extends BlockContainer {

	public TileEntityShipComputerBlock(int id) {
		super(id, Material.iron);
        this.setHardness(1.0F);
        this.setCreativeTab(Remula.tabMachines);
        this.setLightOpacity(0);
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileEntityShipComputerEntity();
	}
	
	@Override
	public int getRenderType() {
		return -1;
	}
	
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int i, float j, float k, float l) {
		if (player instanceof EntityPlayerMP) {
			EntityPlayerMP thePlayer = (EntityPlayerMP) player;
			if (player.dimension != Remula.akatoeDimension) {
				thePlayer.mcServer.getConfigurationManager().transferPlayerToDimension(thePlayer, Remula.akatoeDimension, new TeleporterAkatoe(thePlayer.mcServer.worldServerForDimension(Remula.akatoeDimension)));
			}
			else
			{
				//thePlayer.mcServer.getConfigurationManager().transferPlayerToDimension(thePlayer, Remula.akatoeDimension, new TeleporterAkatoe(thePlayer.mcServer.worldServerForDimension(Remula.akatoeDimension)));
				thePlayer.mcServer.getConfigurationManager().transferPlayerToDimension(thePlayer, 0, new TeleporterAkatoe(thePlayer.mcServer.worldServerForDimension(0)));
				
			}
		}
		return true;
	}
	
	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack item) {
        int rotation = MathHelper.floor_double((double)(entity.rotationYaw * 4.0F / 360.0F) + 2.5D) & 3;
        world.setBlockMetadataWithNotify(x, y, z, rotation, 2);
	}
	
	@Override
	public void registerIcons(IconRegister icon) {
		blockIcon = icon.registerIcon("Remula:ShipComputer");
	}
}
