package co.uk.silvania.Remula.client;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.client.MinecraftForgeClient;
import co.uk.silvania.Remula.CommonProxy;
import co.uk.silvania.Remula.Remula;
import co.uk.silvania.Remula.blocks.render.RenderRemulaSolarPanel;
import co.uk.silvania.Remula.client.models.ModelAkatonian;
import co.uk.silvania.Remula.client.models.ModelGarfin;
import co.uk.silvania.Remula.client.models.ModelGlog;
import co.uk.silvania.Remula.client.models.ModelLignis;
import co.uk.silvania.Remula.client.models.ModelRobot;
import co.uk.silvania.Remula.client.models.ModelSkitterling;
import co.uk.silvania.Remula.client.models.ModelXylexian;
import co.uk.silvania.Remula.entity.EntityAdvRobot;
import co.uk.silvania.Remula.entity.akatoe.EntityAkatonian;
import co.uk.silvania.Remula.entity.akatoe.EntityGarfin;
import co.uk.silvania.Remula.entity.akatoe.EntityGlog;
import co.uk.silvania.Remula.entity.akatoe.EntityHermust;
import co.uk.silvania.Remula.entity.akatoe.EntityLignis;
import co.uk.silvania.Remula.entity.akatoe.EntitySkitterling;
import co.uk.silvania.Remula.entity.baloinus.EntityXylexian;
import co.uk.silvania.Remula.items.weapons.EntityBronzeBullet;
import co.uk.silvania.Remula.powergrid.blocks.RemulaSolarPanel;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.registry.EntityRegistry;

public class ClientProxy extends CommonProxy {
	
	public void registerRenderInformation() {
		RenderingRegistry.registerEntityRenderingHandler(EntityAdvRobot.class, new RenderRobot(new ModelRobot(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(EntityAkatonian.class, new RenderAkatonian(new ModelAkatonian(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(EntityGlog.class, new RenderGlog(new ModelGlog(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(EntityBronzeBullet.class, new RenderBronzeBullet());
		RenderingRegistry.registerEntityRenderingHandler(EntityXylexian.class, new RenderXylexian(new ModelXylexian(), 3.0F));
		RenderingRegistry.registerEntityRenderingHandler(EntitySkitterling.class, new RenderSkitterling(new ModelSkitterling(), 0.4F));
		RenderingRegistry.registerEntityRenderingHandler(EntityGarfin.class, new RenderGarfin(new ModelGarfin(), 1.0F));
		//RenderingRegistry.registerEntityRenderingHandler(EntityHermust.class, new RenderHermust(new ModelHermust(), 3.0F));
		RenderingRegistry.registerEntityRenderingHandler(EntityLignis.class, new RenderLignis(new ModelLignis(), 1.0F));
		
		EntityRegistry.registerGlobalEntityID(EntityAdvRobot.class, "Robot", EntityRegistry.findGlobalUniqueEntityId(), 3515848, 12102);
		EntityRegistry.registerGlobalEntityID(EntityAkatonian.class, "Akatonian", EntityRegistry.findGlobalUniqueEntityId(), 1234567, 12345);
		EntityRegistry.registerGlobalEntityID(EntityGlog.class, "Glog", EntityRegistry.findGlobalUniqueEntityId(), 7654321, 54321);		
		EntityRegistry.registerGlobalEntityID(EntityBronzeBullet.class, "BronzeBullet", EntityRegistry.findGlobalUniqueEntityId());
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
    MinecraftForgeClient.preloadTexture("/co/uk/silvania/remula/resources/blocks.png");
    MinecraftForgeClient.preloadTexture("/co/uk/silvania/remula/resources/items.png");
    MinecraftForgeClient.preloadTexture("/co/uk/silvania/remula/resources/akatoeblocks.png");
    MinecraftForgeClient.preloadTexture("/co/uk/silvania/remula/resources/akatoeitems.png");
    MinecraftForgeClient.preloadTexture("/co/uk/silvania/remula/resources/baloinusblocks.png");
    MinecraftForgeClient.preloadTexture("/co/uk/silvania/remula/resources/baloinusitems.png");
    MinecraftForgeClient.preloadTexture("/co/uk/silvania/remula/resources/deepspaceblocks.png");
    MinecraftForgeClient.preloadTexture("/co/uk/silvania/remula/resources/deepspaceitems.png");
    MinecraftForgeClient.preloadTexture("/co/uk/silvania/Remula/resources/SilvaniteChest1.png");
    MinecraftForgeClient.preloadTexture("/co/uk/silvania/remula/resources/indikublocks.png");
    MinecraftForgeClient.preloadTexture("/co/uk/silvania/remula/resources/indikuitems.png");
    MinecraftForgeClient.preloadTexture("/co/uk/silvania/remula/resources/elkostblocks.png");
    MinecraftForgeClient.preloadTexture("/co/uk/silvania/remula/resources/elkostitems.png");
    MinecraftForgeClient.preloadTexture("/co/uk/silvania/remula/resources/xylexiablocks.png");
    MinecraftForgeClient.preloadTexture("/co/uk/silvania/remula/resources/xylexiaitems.png");
    //ClientRegistry.bindTileEntitySpecialRenderer(co.uk.silvania.Remula.powergrid.blocks.tileentity.TileEntityRemulaSolarPanel.class, new RenderRemulaSolarPanel(0));
    }
        
}