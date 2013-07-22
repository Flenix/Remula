package co.uk.silvania.Remula.client;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.client.MinecraftForgeClient;
import co.uk.silvania.Remula.CommonProxy;
import co.uk.silvania.Remula.Remula;
import co.uk.silvania.Remula.blocks.p1.P1SolarPanel;
import co.uk.silvania.Remula.client.models.ModelAkatonian;
import co.uk.silvania.Remula.client.models.ModelGarfin;
import co.uk.silvania.Remula.client.models.ModelGlog;
import co.uk.silvania.Remula.client.models.ModelLignis;
import co.uk.silvania.Remula.client.models.ModelRobot;
import co.uk.silvania.Remula.client.models.ModelSkitterling;
import co.uk.silvania.Remula.client.models.ModelXylexian;
import co.uk.silvania.Remula.entity.EntityAdvRobot;
import co.uk.silvania.Remula.entity.akatoe.*;
import co.uk.silvania.Remula.entity.baloinus.EntityXylexian;
import co.uk.silvania.Remula.tileentity.*;
import co.uk.silvania.Remula.tileentity.renderer.*;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.registry.EntityRegistry;

public class ClientProxy extends CommonProxy {
	
	public void registerRenderInformation() {
		RenderingRegistry.registerEntityRenderingHandler(EntityAdvRobot.class, new RenderRobot(new ModelRobot(), 0.5F));
		//RenderingRegistry.registerEntityRenderingHandler(EntityAkatonian.class, new RenderAkatonian(new ModelAkatonian(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(EntityGlog.class, new RenderGlog(new ModelGlog(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(EntityXylexian.class, new RenderXylexian(new ModelXylexian(), 3.0F));
		RenderingRegistry.registerEntityRenderingHandler(EntitySkitterling.class, new RenderSkitterling(new ModelSkitterling(), 0.4F));
		RenderingRegistry.registerEntityRenderingHandler(EntityGarfin.class, new RenderGarfin(new ModelGarfin(), 1.0F));
		//RenderingRegistry.registerEntityRenderingHandler(EntityHermust.class, new RenderHermust(new ModelHermust(), 3.0F));
		RenderingRegistry.registerEntityRenderingHandler(EntityLignis.class, new RenderLignis(new ModelLignis(), 1.0F));
		
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityP1SolarPanel.class, new RenderP1SolarPanel());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityTecmoniumChest.class, new TileEntityTecmoniumChestRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityMerciliteChest.class, new TileEntityMerciliteChestRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntitySilvaniteChest.class, new TileEntitySilvaniteChestRenderer());
		
		EntityRegistry.registerGlobalEntityID(EntityAdvRobot.class, "Robot", EntityRegistry.findGlobalUniqueEntityId(), 3515848, 12102);
		//EntityRegistry.registerGlobalEntityID(EntityAkatonian.class, "Akatonian", EntityRegistry.findGlobalUniqueEntityId(), 1234567, 12345);
		EntityRegistry.registerGlobalEntityID(EntityGlog.class, "Glog", EntityRegistry.findGlobalUniqueEntityId(), 7654321, 54321);		
		EntityRegistry.registerGlobalEntityID(EntityXylexian.class, "Xylexian", EntityRegistry.findGlobalUniqueEntityId(), 1827364, 15243);
		EntityRegistry.registerGlobalEntityID(EntitySkitterling.class, "Skitterling", EntityRegistry.findGlobalUniqueEntityId(), 185654, 35637);
		EntityRegistry.registerGlobalEntityID(EntityGarfin.class, "Garfin", EntityRegistry.findGlobalUniqueEntityId(), 1324563, 15378);
		EntityRegistry.registerGlobalEntityID(EntityHermust.class, "Hermust", EntityRegistry.findGlobalUniqueEntityId(), 1935747, 28565);
		EntityRegistry.registerGlobalEntityID(EntityLignis.class, "Lignis", EntityRegistry.findGlobalUniqueEntityId(), 4759673, 65874);
	}
	
	public int addArmor(String armor) {
		return RenderingRegistry.addNewArmourRendererPrefix(armor);
	}
        
    @Override
    public void registerRenderThings() {
    //ClientRegistry.bindTileEntitySpecialRenderer(co.uk.silvania.Remula.powergrid.blocks.tileentity.TileEntityRemulaSolarPanel.class, new RenderRemulaSolarPanel(0));
    }
        
}