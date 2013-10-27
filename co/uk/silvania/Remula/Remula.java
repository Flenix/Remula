package co.uk.silvania.Remula;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.EnumHelper;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.oredict.OreDictionary;
import co.uk.silvania.Remula.CommonProxy;
import co.uk.silvania.Remula.client.ClientProxy;
import co.uk.silvania.Remula.dimensions.*;
import co.uk.silvania.Remula.dimensions.akatoe.*;
import co.uk.silvania.Remula.dimensions.akatoe.items.*;
import co.uk.silvania.Remula.dimensions.baloinus.*;
import co.uk.silvania.Remula.dimensions.deepspace.*;
import co.uk.silvania.Remula.dimensions.elkost.*;
import co.uk.silvania.Remula.dimensions.indiku.*;
import co.uk.silvania.Remula.dimensions.xylexia.*;
import co.uk.silvania.Remula.entity.EntityAdvRobot;
import co.uk.silvania.Remula.entity.akatoe.EntityGarfin;
import co.uk.silvania.Remula.entity.akatoe.EntityGlog;
import co.uk.silvania.Remula.entity.akatoe.EntityHermust;
import co.uk.silvania.Remula.entity.akatoe.EntityLignis;
import co.uk.silvania.Remula.entity.akatoe.EntitySkitterling;
import co.uk.silvania.Remula.entity.baloinus.EntityXylexian;
import co.uk.silvania.Remula.network.PacketHandler;
import co.uk.silvania.Remula.tileentity.*;
import co.uk.silvania.Remula.tileentity.block.MerciliteChest;
import co.uk.silvania.Remula.tileentity.block.SilvaniteChest;
import co.uk.silvania.Remula.tileentity.block.TecmoniumChest;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkMod.SidedPacketHandler;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@Mod(modid=Remula.modid, name="Remula", version="0.0.6")
@NetworkMod(channels = { "Remula" }, clientSideRequired=true, serverSideRequired=false, packetHandler = PacketHandler.class)
public class Remula {
	
	public static final String modid = "remula";
	
	public static CreativeTabs tabRemula = new CreativeTabs("tabRemula") {
		public ItemStack getIconItemStack() {
			return new ItemStack(Block.stone, 1, 0);
		}
	};
	public static CreativeTabs tabMinerals = new CreativeTabs("tabMinerals") {
		public ItemStack getIconItemStack() {
			return new ItemStack(RemulaBlocks.earthOreBlocks, 1, 6);
		}
	};
	public static CreativeTabs tabMachines = new CreativeTabs("tabMachines") {
		public ItemStack getIconItemStack() {
			return new ItemStack(RemulaBlocks.shipComputer, 1, 0);
		}
	};
	public static CreativeTabs tabWorlds = new CreativeTabs("tabWorlds") {
		public ItemStack getIconItemStack() {
			return new ItemStack(RemulaBlocks.xylexiaTerrainBlocks, 1, 1);
		}
	};
	public static CreativeTabs tabEquip = new CreativeTabs("tabEquip") {
		public ItemStack getIconItemStack() {
			return new ItemStack(Block.stone/*Remula.p1HudUnit*/, 1, 0);
		}
	};
	public static CreativeTabs tabMisc = new CreativeTabs("tabMisc") {
		public ItemStack getIconItemStack() {
			return new ItemStack(Block.stone/*Remula.akatoePortal*/, 1, 1);
		}
	};

	
    @Instance("Remula")
    public static Remula instance;
    public static GuiHandler remulaGuiHandler = new GuiHandler();

    // Says where the client and server proxy code is loaded.
    @SidedProxy(clientSide="co.uk.silvania.Remula.client.ClientProxy", serverSide="co.uk.silvania.Remula.CommonProxy")
    public static CommonProxy proxy;
    public static int akatoeDimension = 20;
    public static int baloinusDimension = 21;
    public static int deepSpaceDimension = 22;
    public static int indikuDimension = 23;
    public static int elkostDimension = 24;
    public static int xylexiaDimension = 25;
    
    public static BiomeGenBase akatoePlainsBiome;
    public static BiomeGenBase akatoeDesertBiome;
    public static BiomeGenBase akatoeOceanBiome;
    public static BiomeGenBase akatoeWastelandBiome;
    public static BiomeGenBase baloinusPlainsBiome;
    public static BiomeGenBase baloinusWastelandsBiome;
    public static BiomeGenBase elkostDesertBiome;
    public static BiomeGenBase elkostDunesBiome;
    public static BiomeGenBase indikuJungleBiome;
    public static BiomeGenBase xylexiaPlainsBiome;
    public static BiomeGenBase openSpaceBiome;
    public static BiomeGenBase whiteAsteroidBiome;
    public static BiomeGenBase brownAsteroidBiome;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
    	NetworkRegistry.instance().registerGuiHandler(this, remulaGuiHandler);
    	
    	RemulaConfig.loadConfig(event);
    	RemulaConfig config = new RemulaConfig();
    	
    	RemulaBlocks.init();
    	RemulaItems.init();
        openSpaceBiome = new BiomeOpenSpace(55);
        whiteAsteroidBiome = new BiomeWhiteAsteroid(56);
        brownAsteroidBiome = new BiomeBrownAsteroid(57);
        akatoePlainsBiome = new BiomeAkatoePlains(60);
        akatoeDesertBiome = new BiomeAkatoeDesert(61);
        akatoeOceanBiome = new BiomeAkatoeOcean(62);
        akatoeWastelandBiome = new BiomeAkatoeWasteland(63);
        baloinusPlainsBiome = new BiomeBaloinusPlains(65);
        baloinusWastelandsBiome = new BiomeBaloinusWastelands(66);
        indikuJungleBiome = new BiomeIndikuJungle(70);
        elkostDesertBiome = new BiomeElkostPlains(75);
        elkostDunesBiome = new BiomeElkostDunes(76);
        xylexiaPlainsBiome = new BiomeXylexiaPlains(80);
    }
    
	public static WorldGen worldGen = new WorldGen();
    
    @EventHandler
    public void load(FMLInitializationEvent event) {
            proxy.registerRenderThings();
            proxy.init();
            
            proxy.registerGeneralBlocks();
            proxy.registerEarthBlocks();
            proxy.registerAkatoeBlocks();
            proxy.registerBaloinusBlocks();
            proxy.registerIndikuBlocks();
            proxy.registerElkostBlocks();
            proxy.registerXylexiaBlocks();
            proxy.registerDeepSpaceBlocks();
            
            proxy.addGeneralNames();
            proxy.addEarthNames();
            proxy.addAkatoeNames();
            proxy.addBaloinusNames();
            proxy.addIndikuNames();
            proxy.addElkostNames();
            proxy.addXylexiaNames();            
            proxy.addDeepSpaceNames();
            
            proxy.registerMineralItems();
            proxy.registerEquipmentItems();
            proxy.registerFoodItems();
            proxy.registerNaturalItems();
            proxy.registerPowerGridItems();
            
            proxy.addMineralNames();
            proxy.addEquipmentNames();
            proxy.addFoodNames();
            proxy.addNaturalNames();
            proxy.addPowerGridNames();
            
            proxy.oreDictionary();
            proxy.dimensionManager();
            
            proxy.stringLocalization();
            proxy.tileEntities();
            
            //TODO Fix EntityRegistry.registerModEntity(EntityAkatonian.class, "Akatonian", 1, this, 80, 3, true);
            EntityRegistry.registerModEntity(EntityGlog.class, "Glog", 2, this, 80, 3, true);
            EntityRegistry.registerModEntity(EntityAdvRobot.class, "AdvancedRobot", 3, this, 80, 3, true);
            EntityRegistry.registerModEntity(EntityXylexian.class, "Xylexian", 4, this, 80, 3, true);
            EntityRegistry.registerModEntity(EntitySkitterling.class, "Skitterling", 5, this, 80, 3, true);
            EntityRegistry.registerModEntity(EntityHermust.class, "Hermust", 5, this, 80, 3, true);
            EntityRegistry.registerModEntity(EntityGarfin.class, "Garfin", 6, this, 80, 3, true);
            EntityRegistry.registerModEntity(EntityLignis.class, "Lignis", 7, this, 80, 3, true);
            
            EntityRegistry.addSpawn(EntityGlog.class, 5, 2, 6, EnumCreatureType.creature, Remula.akatoePlainsBiome);
            EntityRegistry.addSpawn(EntitySkitterling.class, 5, 6, 10, EnumCreatureType.monster, Remula.akatoePlainsBiome, Remula.akatoeDesertBiome, Remula.akatoeWastelandBiome);
            EntityRegistry.addSpawn(EntityHermust.class, 5, 2, 4, EnumCreatureType.creature, Remula.akatoePlainsBiome, Remula.akatoeDesertBiome);
            EntityRegistry.addSpawn(EntityGarfin.class, 5, 3, 7, EnumCreatureType.waterCreature, Remula.akatoePlainsBiome, Remula.akatoeOceanBiome);
            EntityRegistry.addSpawn(EntityLignis.class, 5, 1, 2, EnumCreatureType.creature, Remula.akatoePlainsBiome, Remula.akatoeDesertBiome, Remula.akatoeOceanBiome);
            EntityRegistry.addSpawn(EntityXylexian.class, 5, 1, 1, EnumCreatureType.monster, Remula.xylexiaPlainsBiome);
          
            MinecraftForge.EVENT_BUS.register(new AkatoeBonemealEventClass());
            MinecraftForge.EVENT_BUS.register(new RubberTreeBonemealEvent());
            
            GameRegistry.registerWorldGenerator(new WorldGen());
    }


	@EventHandler
    public void postInit(FMLPostInitializationEvent event) {
	}
}
