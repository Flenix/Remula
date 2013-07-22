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
import co.uk.silvania.Remula.blocks.*;
import co.uk.silvania.Remula.blocks.p1.*;
import co.uk.silvania.Remula.blocks.p2.*;
import co.uk.silvania.Remula.blocks.p3.*;
import co.uk.silvania.Remula.blocks.p4.*;
import co.uk.silvania.Remula.blocks.p5.*;
import co.uk.silvania.Remula.blocks.p6.*;
import co.uk.silvania.Remula.blocks.p7.*;
import co.uk.silvania.Remula.blocks.p8.*;
import co.uk.silvania.Remula.blocks.p9.*;
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
//TODO fix import co.uk.silvania.Remula.entity.akatoe.EntityAkatonian;
import co.uk.silvania.Remula.entity.akatoe.EntityGarfin;
import co.uk.silvania.Remula.entity.akatoe.EntityGlog;
import co.uk.silvania.Remula.entity.akatoe.EntityHermust;
import co.uk.silvania.Remula.entity.akatoe.EntityLignis;
import co.uk.silvania.Remula.entity.akatoe.EntitySkitterling;
import co.uk.silvania.Remula.entity.baloinus.EntityXylexian;
import co.uk.silvania.Remula.items.*;
import co.uk.silvania.Remula.items.armor.P1HUDUnit;
import co.uk.silvania.Remula.items.minerals.*;
import co.uk.silvania.Remula.items.weapons.ItemP1Pistol;
import co.uk.silvania.Remula.items.weapons.P1IronBullet;
import co.uk.silvania.Remula.network.PacketHandler;
import co.uk.silvania.Remula.powergrid.items.*;
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

@Mod(modid="Remula", name="Remula", version="0.0.1")
@NetworkMod(channels = { "Remula" }, clientSideRequired=true, serverSideRequired=false, packetHandler = PacketHandler.class)
public class Remula { 
	
	public static CreativeTabs tabRemula = new CreativeTabs("tabRemula") {
		public ItemStack getIconItemStack() {
			return new ItemStack(Block.stone, 1, 0);
		}
	};
	public static CreativeTabs tabMinerals = new CreativeTabs("tabMinerals") {
		public ItemStack getIconItemStack() {
			return new ItemStack(Remula.earthOreBlocks, 1, 6);
		}
	};
	public static CreativeTabs tabMachines = new CreativeTabs("tabMachines") {
		public ItemStack getIconItemStack() {
			return new ItemStack(Block.stone, 1, 0);
		}
	};
	public static CreativeTabs tabWorlds = new CreativeTabs("tabWorlds") {
		public ItemStack getIconItemStack() {
			return new ItemStack(Remula.xylexiaTerrainBlocks, 1, 1);
		}
	};
	public static CreativeTabs tabEquip = new CreativeTabs("tabEquip") {
		public ItemStack getIconItemStack() {
			return new ItemStack(Remula.p1HudUnit, 1, 0);
		}
	};
	public static CreativeTabs tabMisc = new CreativeTabs("tabMisc") {
		public ItemStack getIconItemStack() {
			return new ItemStack(Remula.akatoePortal, 1, 1);
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
    
    //Machines etc
    public static Block p1Liquidizer;
    public static Block p1CraftingTable;
    public static Block p1T1StorageUnit;
    public static Block p1T2StorageUnit;
    public static Block p1T3StorageUnit;
    public static Block p1Generator;
    public static Block p1SolarPanel;
    public static Block p1ThermalGenerator;
    public static Block p1Grinder;
    public static Block p1ReactorCore;
    public static Block p1Compressor;
    public static Block p1Furnace;
    public static Block p1Extractor;
    public static Block p1Crusher;
    
    public static Block p2Liquidizer;
    public static Block p2CraftingTable;
    public static Block p2T1StorageUnit;
    public static Block p2T2StorageUnit;
    public static Block p2T3StorageUnit;
    public static Block p2Generator;
    public static Block p2SolarPanel;
    public static Block p2ThermalGenerator;
    public static Block p2Grinder;
    public static Block p2ReactorCore;
    public static Block p2Compressor;
    public static Block p2Furnace;
    public static Block p2Extractor;
    public static Block p2Crusher;
    
    public static Block p3Liquidizer;
    public static Block p3CraftingTable;
    public static Block p3T1StorageUnit;
    public static Block p3T2StorageUnit;
    public static Block p3T3StorageUnit;
    public static Block p3Generator;
    public static Block p3SolarPanel;
    public static Block p3ThermalGenerator;
    public static Block p3Grinder;
    public static Block p3ReactorCore;
    public static Block p3Compressor;
    public static Block p3Furnace;
    public static Block p3Extractor;
    public static Block p3Crusher;
    
    public static Block p4Liquidizer;
    public static Block p4CraftingTable;
    public static Block p4T1StorageUnit;
    public static Block p4T2StorageUnit;
    public static Block p4T3StorageUnit;
    public static Block p4Generator;
    public static Block p4SolarPanel;
    public static Block p4ThermalGenerator;
    public static Block p4Grinder;
    public static Block p4ReactorCore;
    public static Block p4Compressor;
    public static Block p4Furnace;
    public static Block p4Extractor;
    public static Block p4Crusher;
    
    public static Block p5Liquidizer;
    public static Block p5CraftingTable;
    public static Block p5T1StorageUnit;
    public static Block p5T2StorageUnit;
    public static Block p5T3StorageUnit;
    public static Block p5Generator;
    public static Block p5SolarPanel;
    public static Block p5ThermalGenerator;
    public static Block p5Grinder;
    public static Block p5ReactorCore;
    public static Block p5Compressor;
    public static Block p5Furnace;
    public static Block p5Extractor;
    public static Block p5Crusher;
    
    public static Block p6Liquidizer;
    public static Block p6CraftingTable;
    public static Block p6T1StorageUnit;
    public static Block p6T2StorageUnit;
    public static Block p6T3StorageUnit;
    public static Block p6Generator;
    public static Block p6SolarPanel;
    public static Block p6ThermalGenerator;
    public static Block p6Grinder;
    public static Block p6ReactorCore;
    public static Block p6Compressor;
    public static Block p6Furnace;
    public static Block p6Extractor;
    public static Block p6Crusher;
    
    public static Block p7Liquidizer;
    public static Block p7CraftingTable;
    public static Block p7T1StorageUnit;
    public static Block p7T2StorageUnit;
    public static Block p7T3StorageUnit;
    public static Block p7Generator;
    public static Block p7SolarPanel;
    public static Block p7ThermalGenerator;
    public static Block p7Grinder;
    public static Block p7ReactorCore;
    public static Block p7Compressor;
    public static Block p7Furnace;
    public static Block p7Extractor;
    public static Block p7Crusher;
    
    public static Block p8Liquidizer;
    public static Block p8CraftingTable;
    public static Block p8T1StorageUnit;
    public static Block p8T2StorageUnit;
    public static Block p8T3StorageUnit;
    public static Block p8Generator;
    public static Block p8SolarPanel;
    public static Block p8ThermalGenerator;
    public static Block p8Grinder;
    public static Block p8ReactorCore;
    public static Block p8Compressor;
    public static Block p8Furnace;
    public static Block p8Extractor;
    public static Block p8Crusher;
    
    public static Block p9Liquidizer;
    public static Block p9CraftingTable;
    public static Block p9T1StorageUnit;
    public static Block p9T2StorageUnit;
    public static Block p9T3StorageUnit;
    public static Block p9Generator;
    public static Block p9SolarPanel;
    public static Block p9ThermalGenerator;
    public static Block p9Grinder;
    public static Block p9ReactorCore;
    public static Block p9Compressor;
    public static Block p9Furnace;
    public static Block p9Extractor;
    public static Block p9Crusher;
    
    
    
    //Earth Natural Stuff
    public static Block rubberLog;
    public static Block rubberSapling;
    public static Block rubberLeaves;
    
    
    
    //Akatoe Natural Stuff
    public static Block akatoeStone;
    public static Block akatoeGrass;
    public static Block akatoeDirt;
    public static Block akatoeSand;
    public static Block akatoeLogs;
    public static Block akatoeLeaves;
    public static Block akatoeSaplings;
    
    //public static int blockRemulaID;
    @SideOnly(Side.CLIENT)

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
    	NetworkRegistry.instance().registerGuiHandler(this, remulaGuiHandler);
    	RemulaConfig.loadConfig(event);
    	
    	RemulaConfig config = new RemulaConfig();
    	
    	//Machines etc
        p1CraftingTable = new P1CraftingTable(config.p1CraftingTableID).setUnlocalizedName("p1CraftingTable");
    	
    	p1Liquidizer = new P1Liquidizer(config.p1LiquidizerID).setUnlocalizedName("p1Liquidizer");
        p1T1StorageUnit = new P1T1StorageUnit(config.p1T1StorageUnitID).setUnlocalizedName("p1T1StorageUnit");
        p1T2StorageUnit = new P1T2StorageUnit(config.p1T2StorageUnitID).setUnlocalizedName("p1T2StorageUnit");
        p1T3StorageUnit = new P1T3StorageUnit(config.p1T3StorageUnitID).setUnlocalizedName("p1T3StorageUnit");
        p1Generator = new P1Generator(config.p1GeneratorID).setUnlocalizedName("p1SimpleGenerator");
        p1SolarPanel = new P1SolarPanel(config.p1SolarPanelID).setUnlocalizedName("p1SolarPanel");
        p1ThermalGenerator = new P1ThermalGenerator(config.p1ThermalGeneratorID).setUnlocalizedName("p1ThermalGenerator");
        p1Grinder = new P1Grinder(config.p1GrinderID).setUnlocalizedName("p1Grinder");
        p1ReactorCore = new P1ReactorCore(config.p1ReactorCoreID).setUnlocalizedName("p1ReactorCore");
        p1Compressor = new P1Compressor(config.p1CompressorID).setUnlocalizedName("p1Compressor");
        p1Furnace = new P1Furnace(config.p1FurnaceID).setUnlocalizedName("p1Furnace");
        p1Extractor = new P1Extractor(config.p1ExtractorID).setUnlocalizedName("p1Extractor");
        p1Crusher = new P1Crusher(config.p1CrusherID).setUnlocalizedName("p1Crusher");
        
    	p2Liquidizer = new P2Liquidizer(config.p2LiquidizerID).setUnlocalizedName("p2Liquidizer");
        p2T1StorageUnit = new P2T1StorageUnit(config.p2T1StorageUnitID).setUnlocalizedName("p2T1StorageUnit");
        p2T2StorageUnit = new P2T2StorageUnit(config.p2T2StorageUnitID).setUnlocalizedName("p2T2StorageUnit");
        p2T3StorageUnit = new P2T3StorageUnit(config.p2T3StorageUnitID).setUnlocalizedName("p2T3StorageUnit");
        p2Generator = new P2Generator(config.p2GeneratorID).setUnlocalizedName("p2SimpleGenerator");
        p2SolarPanel = new P2SolarPanel(config.p2SolarPanelID).setUnlocalizedName("p2SolarPanel");
        p2ThermalGenerator = new P2ThermalGenerator(config.p2ThermalGeneratorID).setUnlocalizedName("p2ThermalGenerator");
        p2Grinder = new P2Grinder(config.p2GrinderID).setUnlocalizedName("p2Grinder");
        p2ReactorCore = new P2ReactorCore(config.p2ReactorCoreID).setUnlocalizedName("p2ReactorCore");
        p2Compressor = new P2Compressor(config.p2CompressorID).setUnlocalizedName("p2Compressor");
        p2Furnace = new P2Furnace(config.p2FurnaceID).setUnlocalizedName("p2Furnace");
        p2Extractor = new P2Extractor(config.p2ExtractorID).setUnlocalizedName("p2Extractor");
        p2Crusher = new P2Crusher(config.p2CrusherID).setUnlocalizedName("p2Crusher");
        
    	p3Liquidizer = new P3Liquidizer(config.p3LiquidizerID).setUnlocalizedName("p3Liquidizer");
        p3T1StorageUnit = new P3T1StorageUnit(config.p3T1StorageUnitID).setUnlocalizedName("p3T1StorageUnit");
        p3T2StorageUnit = new P3T2StorageUnit(config.p3T2StorageUnitID).setUnlocalizedName("p3T2StorageUnit");
        p3T3StorageUnit = new P3T3StorageUnit(config.p3T3StorageUnitID).setUnlocalizedName("p3T3StorageUnit");
        p3Generator = new P3Generator(config.p3GeneratorID).setUnlocalizedName("p3SimpleGenerator");
        p3SolarPanel = new P3SolarPanel(config.p3SolarPanelID).setUnlocalizedName("p3SolarPanel");
        p3ThermalGenerator = new P3ThermalGenerator(config.p3ThermalGeneratorID).setUnlocalizedName("p3ThermalGenerator");
        p3Grinder = new P3Grinder(config.p3GrinderID).setUnlocalizedName("p3Grinder");
        p3ReactorCore = new P3ReactorCore(config.p3ReactorCoreID).setUnlocalizedName("p3ReactorCore");
        p3Compressor = new P3Compressor(config.p3CompressorID).setUnlocalizedName("p3Compressor");
        p3Furnace = new P3Furnace(config.p3FurnaceID).setUnlocalizedName("p3Furnace");
        p3Extractor = new P3Extractor(config.p3ExtractorID).setUnlocalizedName("p3Extractor");
        p3Crusher = new P3Crusher(config.p3CrusherID).setUnlocalizedName("p3Crusher");
        
    	p4Liquidizer = new P4Liquidizer(config.p4LiquidizerID).setUnlocalizedName("p4Liquidizer");
        p4T1StorageUnit = new P4T1StorageUnit(config.p4T1StorageUnitID).setUnlocalizedName("p4T1StorageUnit");
        p4T2StorageUnit = new P4T2StorageUnit(config.p4T2StorageUnitID).setUnlocalizedName("p4T2StorageUnit");
        p4T3StorageUnit = new P4T3StorageUnit(config.p4T3StorageUnitID).setUnlocalizedName("p4T3StorageUnit");
        p4Generator = new P4Generator(config.p4GeneratorID).setUnlocalizedName("p4SimpleGenerator");
        p4SolarPanel = new P4SolarPanel(config.p4SolarPanelID).setUnlocalizedName("p4SolarPanel");
        p4ThermalGenerator = new P4ThermalGenerator(config.p4ThermalGeneratorID).setUnlocalizedName("p4ThermalGenerator");
        p4Grinder = new P4Grinder(config.p4GrinderID).setUnlocalizedName("p4Grinder");
        p4ReactorCore = new P4ReactorCore(config.p4ReactorCoreID).setUnlocalizedName("p4ReactorCore");
        p4Compressor = new P4Compressor(config.p4CompressorID).setUnlocalizedName("p4Compressor");
        p4Furnace = new P4Furnace(config.p4FurnaceID).setUnlocalizedName("p4Furnace");
        p4Extractor = new P4Extractor(config.p4ExtractorID).setUnlocalizedName("p4Extractor");
        p4Crusher = new P4Crusher(config.p4CrusherID).setUnlocalizedName("p4Crusher");
        
    	p5Liquidizer = new P5Liquidizer(config.p5LiquidizerID).setUnlocalizedName("p5Liquidizer");
        p5T1StorageUnit = new P5T1StorageUnit(config.p5T1StorageUnitID).setUnlocalizedName("p5T1StorageUnit");
        p5T2StorageUnit = new P5T2StorageUnit(config.p5T2StorageUnitID).setUnlocalizedName("p5T2StorageUnit");
        p5T3StorageUnit = new P5T3StorageUnit(config.p5T3StorageUnitID).setUnlocalizedName("p5T3StorageUnit");
        p5Generator = new P5Generator(config.p5GeneratorID).setUnlocalizedName("p5SimpleGenerator");
        p5SolarPanel = new P5SolarPanel(config.p5SolarPanelID).setUnlocalizedName("p5SolarPanel");
        p5ThermalGenerator = new P5ThermalGenerator(config.p5ThermalGeneratorID).setUnlocalizedName("p5ThermalGenerator");
        p5Grinder = new P5Grinder(config.p5GrinderID).setUnlocalizedName("p5Grinder");
        p5ReactorCore = new P5ReactorCore(config.p5ReactorCoreID).setUnlocalizedName("p5ReactorCore");
        p5Compressor = new P5Compressor(config.p5CompressorID).setUnlocalizedName("p5Compressor");
        p5Furnace = new P5Furnace(config.p5FurnaceID).setUnlocalizedName("p5Furnace");
        p5Extractor = new P5Extractor(config.p5ExtractorID).setUnlocalizedName("p5Extractor");
        p5Crusher = new P5Crusher(config.p5CrusherID).setUnlocalizedName("p5Crusher");
        
    	p6Liquidizer = new P6Liquidizer(config.p6LiquidizerID).setUnlocalizedName("p6Liquidizer");
        p6T1StorageUnit = new P6T1StorageUnit(config.p6T1StorageUnitID).setUnlocalizedName("p6T1StorageUnit");
        p6T2StorageUnit = new P6T2StorageUnit(config.p6T2StorageUnitID).setUnlocalizedName("p6T2StorageUnit");
        p6T3StorageUnit = new P6T3StorageUnit(config.p6T3StorageUnitID).setUnlocalizedName("p6T3StorageUnit");
        p6Generator = new P6Generator(config.p6GeneratorID).setUnlocalizedName("p6SimpleGenerator");
        p6SolarPanel = new P6SolarPanel(config.p6SolarPanelID).setUnlocalizedName("p6SolarPanel");
        p6ThermalGenerator = new P6ThermalGenerator(config.p6ThermalGeneratorID).setUnlocalizedName("p6ThermalGenerator");
        p6Grinder = new P6Grinder(config.p6GrinderID).setUnlocalizedName("p6Grinder");
        p6ReactorCore = new P6ReactorCore(config.p6ReactorCoreID).setUnlocalizedName("p6ReactorCore");
        p6Compressor = new P6Compressor(config.p6CompressorID).setUnlocalizedName("p6Compressor");
        p6Furnace = new P6Furnace(config.p6FurnaceID).setUnlocalizedName("p6Furnace");
        p6Extractor = new P6Extractor(config.p6ExtractorID).setUnlocalizedName("p6Extractor");
        p6Crusher = new P6Crusher(config.p6CrusherID).setUnlocalizedName("p6Crusher");
        
    	p7Liquidizer = new P7Liquidizer(config.p7LiquidizerID).setUnlocalizedName("p7Liquidizer");
        p7T1StorageUnit = new P7T1StorageUnit(config.p7T1StorageUnitID).setUnlocalizedName("p7T1StorageUnit");
        p7T2StorageUnit = new P7T2StorageUnit(config.p7T2StorageUnitID).setUnlocalizedName("p7T2StorageUnit");
        p7T3StorageUnit = new P7T3StorageUnit(config.p7T3StorageUnitID).setUnlocalizedName("p7T3StorageUnit");
        p7Generator = new P7Generator(config.p7GeneratorID).setUnlocalizedName("p7SimpleGenerator");
        p7SolarPanel = new P7SolarPanel(config.p7SolarPanelID).setUnlocalizedName("p7SolarPanel");
        p7ThermalGenerator = new P7ThermalGenerator(config.p7ThermalGeneratorID).setUnlocalizedName("p7ThermalGenerator");
        p7Grinder = new P7Grinder(config.p7GrinderID).setUnlocalizedName("p7Grinder");
        p7ReactorCore = new P7ReactorCore(config.p7ReactorCoreID).setUnlocalizedName("p7ReactorCore");
        p7Compressor = new P7Compressor(config.p7CompressorID).setUnlocalizedName("p7Compressor");
        p7Furnace = new P7Furnace(config.p7FurnaceID).setUnlocalizedName("p7Furnace");
        p7Extractor = new P7Extractor(config.p7ExtractorID).setUnlocalizedName("p7Extractor");
        p7Crusher = new P7Crusher(config.p7CrusherID).setUnlocalizedName("p7Crusher");
        
    	p8Liquidizer = new P8Liquidizer(config.p8LiquidizerID).setUnlocalizedName("p8Liquidizer");
        p8T1StorageUnit = new P8T1StorageUnit(config.p8T1StorageUnitID).setUnlocalizedName("p8T1StorageUnit");
        p8T2StorageUnit = new P8T2StorageUnit(config.p8T2StorageUnitID).setUnlocalizedName("p8T2StorageUnit");
        p8T3StorageUnit = new P8T3StorageUnit(config.p8T3StorageUnitID).setUnlocalizedName("p8T3StorageUnit");
        p8Generator = new P8Generator(config.p8GeneratorID).setUnlocalizedName("p8SimpleGenerator");
        p8SolarPanel = new P8SolarPanel(config.p8SolarPanelID).setUnlocalizedName("p8SolarPanel");
        p8ThermalGenerator = new P8ThermalGenerator(config.p8ThermalGeneratorID).setUnlocalizedName("p8ThermalGenerator");
        p8Grinder = new P8Grinder(config.p8GrinderID).setUnlocalizedName("p8Grinder");
        p8ReactorCore = new P8ReactorCore(config.p8ReactorCoreID).setUnlocalizedName("p8ReactorCore");
        p8Compressor = new P8Compressor(config.p8CompressorID).setUnlocalizedName("p8Compressor");
        p8Furnace = new P8Furnace(config.p8FurnaceID).setUnlocalizedName("p8Furnace");
        p8Extractor = new P8Extractor(config.p8ExtractorID).setUnlocalizedName("p8Extractor");
        p8Crusher = new P8Crusher(config.p8CrusherID).setUnlocalizedName("p8Crusher");
        
    	p9Liquidizer = new P9Liquidizer(config.p9LiquidizerID).setUnlocalizedName("p9Liquidizer");
        p9T1StorageUnit = new P9T1StorageUnit(config.p9T1StorageUnitID).setUnlocalizedName("p9T1StorageUnit");
        p9T2StorageUnit = new P9T2StorageUnit(config.p9T2StorageUnitID).setUnlocalizedName("p9T2StorageUnit");
        p9T3StorageUnit = new P9T3StorageUnit(config.p9T3StorageUnitID).setUnlocalizedName("p9T3StorageUnit");
        p9Generator = new P9Generator(config.p9GeneratorID).setUnlocalizedName("p9SimpleGenerator");
        p9SolarPanel = new P9SolarPanel(config.p9SolarPanelID).setUnlocalizedName("p9SolarPanel");
        p9ThermalGenerator = new P9ThermalGenerator(config.p9ThermalGeneratorID).setUnlocalizedName("p9ThermalGenerator");
        p9Grinder = new P9Grinder(config.p9GrinderID).setUnlocalizedName("p9Grinder");
        p9ReactorCore = new P9ReactorCore(config.p9ReactorCoreID).setUnlocalizedName("p9ReactorCore");
        p9Compressor = new P9Compressor(config.p9CompressorID).setUnlocalizedName("p9Compressor");
        p9Furnace = new P9Furnace(config.p9FurnaceID).setUnlocalizedName("p9Furnace");
        p9Extractor = new P9Extractor(config.p9ExtractorID).setUnlocalizedName("p9Extractor");
        p9Crusher = new P9Crusher(config.p9CrusherID).setUnlocalizedName("p9Crusher");
        
        
        //Earth Natural Stuff
    	rubberLog = new RubberLog(config.rubberLogID).setUnlocalizedName("rubberLog");
    	rubberSapling = new RubberSapling(config.rubberSaplingID).setUnlocalizedName("rubberSapling");
    	rubberLeaves = new RubberLeaves(config.rubberLeavesID).setUnlocalizedName("rubberLeaves");
        
        //Akatoe Natural Stuff
        akatoeStone = new AkatoeStone(200, Material.rock).setUnlocalizedName("akatoeStone");
        akatoeGrass = new AkatoeGrass(201).setUnlocalizedName("akatoeGrass");
        akatoeDirt = new AkatoeDirt(202).setUnlocalizedName("akatoeGround");
        akatoeSand = new AkatoeSand(203, Material.sand).setUnlocalizedName("akatoeSand");
        akatoeLogs = new AkatoeLogs(240).setUnlocalizedName("akatoeLogs");
        akatoeLeaves = new AkatoeLeaves(241).setUnlocalizedName("akatoeLeaves");
        akatoeSaplings = new AkatoeSaplings(242, 0).setUnlocalizedName("akatoeSaplings");
    }
	public static WorldGen worldGen = new WorldGen();
	public static EnumArmorMaterial SpaceSuit1 = EnumHelper.addArmorMaterial("SpaceSuit1", 15, new int[]{1, 1, 1, 1}, 0);
	
    //Blocks (IDs 1800-2000 to avoid clash with top 100 mods)
    
    //Reactor Part 1827
    //Reactor Part 1828
    //Reactor Part 1829
    //Reactor Part 1830
    public final static Block tecmoniumChest = new TecmoniumChest(1830).setUnlocalizedName("tecmoniumChest");
    public final static Block merciliteChest = new MerciliteChest(1831).setUnlocalizedName("merciliteChest");
    public final static Block silvaniteChest = new SilvaniteChest(1832).setUnlocalizedName("silvaniteChest");
    
    public final static Block baloinusStone = new BaloinusStone(205, Material.rock);
    public final static Block indikuStone = new IndikuStone(206, Material.rock).setUnlocalizedName("indikuStone");
    public final static Block indikuDirt = new IndikuDirt(207).setUnlocalizedName("indikuDirt");
    public final static Block indikuGrass = new IndikuGrass(208).setUnlocalizedName("indikuGrass");
    public final static Block elkostSand = new ElkostSand(209, Material.sand).setUnlocalizedName("elkostSand");
    public final static Block xylexianStone = new XylexianStone(210, Material.iron).setUnlocalizedName("xylexianStone");
    public final static Block xylexianSand = new XylexianSand(211, Material.sand).setUnlocalizedName("xylexianSand");
    public final static Block deepSpaceBrownAsteroidRock = new DeepSpaceBrownAsteroid(220, Material.rock).setUnlocalizedName("deepSpaceAsteroidRock");
    public final static Block deepSpaceWhiteAsteroidRock = new DeepSpaceWhiteAsteroid(221, Material.rock).setUnlocalizedName("deepSpaceMeteoriteRock");
    
    //Rest of blocks

    //public final static Block porinCrop = new PorinCrop(1920).setUnlocalizedName("porinCrop");
    //public final static Block ulinCrop = new UlinCrop(1921).setUnlocalizedName("ulinCrop");
    //public final static Block cirCrop = new CirCrop(1922).setUnlocalizedName("cirCrop");
    //public final static Block boskinCrop = new BoskinCrop(1923).setUnlocalizedName("boskinCrop");
	public final static Block plantFuxii = new PlantFuxii(1924).setUnlocalizedName("plantFuxii");
	//Tree x3
	//Leaves x3
    public final static Block akatoeTerrainBlocks = new AkatoeTerrainBlocks(1900, Material.rock).setUnlocalizedName("akatoeTerrainBlocks");
    public final static Block baloinusTerrainBlocks = new BaloinusTerrainBlocks(1901, Material.rock).setUnlocalizedName("baloinusTerrainBlocks");
    public final static Block indikuTerrainBlocks = new IndikuTerrainBlocks(1902, Material.rock).setUnlocalizedName("indikuTerrainBlocks");
    public final static Block elkostTerrainBlocks = new ElkostTerrainBlocks(1903, Material.rock).setUnlocalizedName("elkostTerrainBlocks");
    public final static Block xylexiaTerrainBlocks = new XylexiaTerrainBlocks(1904, Material.rock).setUnlocalizedName("xylexiaTerrainBlocks");
    public final static Block deepSpaceTerrainBlocks = new DeepSpaceTerrainBlocks(1905, Material.rock).setUnlocalizedName("deepSpaceTerrainBlocks");
    //1905-1920 reserved for new dimensional blocks
    
    public final static Block earthOreBlocks = new EarthOreBlocks(1920).setUnlocalizedName("earthOreBlocks");
    public final static Block akatoeOreBlocks = new AkatoeOreBlocks(1921).setUnlocalizedName("akatoeOreBlocks");
    public final static Block baloinusOreBlocks = new BaloinusOreBlocks(1923).setUnlocalizedName("baloinusOreBlocks");
    public final static Block indikuOreBlocks = new IndikuOreBlocks(1925).setUnlocalizedName("indikuOreBlocks");
    public final static Block elkostOreBlocks = new ElkostOreBlocks(1927).setUnlocalizedName("elkostOreBlocks");
    public final static Block xylexiaOreBlocks = new XylexiaOreBlocks(1929).setUnlocalizedName("xylexiaOreBlocks");
    public final static Block deepSpaceBrownOreBlocks = new DeepSpaceBrownOreBlocks(1931).setUnlocalizedName("deepSpaceBrownOreBlocks");
    public final static Block deepSpaceWhiteOreBlocks = new DeepSpaceWhiteOreBlocks(1932).setUnlocalizedName("deepSpaceWhiteOreBlocks");
    //public final static Block deepSpaceExtraOreBlocks = new DeepSpaceExtraOreBlocks(1933).setUnlocalizedName("deepSpaceExtraOreBlocks");
    //1934-1950 reserved for dimensional ore blocks
    
    public final static Block akatoePortal = new AkatoePortalBlock(1851).setUnlocalizedName("akatoePortal");
    public final static Block baloinusPortal = new BaloinusPortalBlock(1852).setUnlocalizedName("baloinusPortal");
    public final static Block indikuPortal = new IndikuPortalBlock(1853).setUnlocalizedName("indikuPortal");
    public final static Block elkostPortal = new ElkostPortalBlock(1854).setUnlocalizedName("elkostPortal");
    public final static Block xylexiaPortal = new XylexiaPortalBlock(1855).setUnlocalizedName("xylexiaPortal");
    public final static Block deepSpacePortal = new DeepSpacePortalBlock(1856).setUnlocalizedName("deepSpacePortal");
    //1955-1970 reserved for portal blocks
    
    public final static Block akatoeTilledDirt = new AkatoeTilledDirt(1871).setUnlocalizedName("akatoeTilledDirt");
    public final static Block indikuTilledDirt = new IndikuTilledDirt(1872).setUnlocalizedName("indikuTilledDirt");
    public final static Block elkostGlassPane = new ElkostGlassPane(1873, Material.glass).setUnlocalizedName("elkostGlassPane");
    public final static Block xylexianGlassPane = new XylexianGlassPane(1874, Material.glass).setUnlocalizedName("xylexianGlassPane");

    //TODO - 8 Indiku trees, 8 crops, 16 plants
    //Liquids: Silvanite, Mercilite, Remula, Redstone, Lapis, Porinite, Pilk, Tritanite, Ventiium, Athirium, Zirinium, Boria, Tristinium, Grinist, Heri, Skatha, Kzori 
    // + 12 more, + any planitary unique liquids

       
    //Items (IDs 17000 - 17300)
    public final static Item emptyCell = new EmptyCell(17000).setUnlocalizedName("emptyCell");
    public final static Item copperCell = new CopperCell(17001).setUnlocalizedName("copperCell");
    public final static Item tinCell = new TinCell(17002).setUnlocalizedName("tinCell");
    public final static Item coalCell = new CoalCell(17003).setUnlocalizedName("coalCell");
    public final static Item ironCell = new IronCell(17004).setUnlocalizedName("ironCell");
    public final static Item goldCell = new GoldCell(17005).setUnlocalizedName("goldCell");
    public final static Item redstoneCell = new RedstoneCell(17006).setUnlocalizedName("redstoneCell");
    public final static Item lapisLazuliCell = new LapisLazuliCell(17007).setUnlocalizedName("lapisLazuliCell");
    public final static Item diamondCell = new DiamondCell(17008).setUnlocalizedName("diamondCell");
	public final static Item silvaniteCell = new SilvaniteCell(17009).setUnlocalizedName("silvaniteCell"); 
	public final static Item merciliteCell = new MerciliteCell(17010).setUnlocalizedName("merciliteCell");
	public final static Item remulaCell = new RemulaCell(17011).setUnlocalizedName("remulaCell");
	public final static Item poriniteCell = new PoriniteCell(17012).setUnlocalizedName("poriniteCell");
	public final static Item pilkCell = new PilkCell(17013).setUnlocalizedName("pilkCell");
	//public final static Item tritaniteCell = new TritaniteCell(17014).setUnlocalizedName("tritaniteCell");
	public final static Item akatiteCell = new AkatiteCell(17015).setUnlocalizedName("akatiteCell");
	/*public final static Item balumCell = new BalumCell(17016).setUnlocalizedName("balumCell");
	public final static Item ventiiumCell = new VentiiumCell(17017).setUnlocalizedName("ventiiumCell");
	public final static Item arithiumCell = new ArithiumCell(17018).setUnlocalizedName("arithiumCell");
	public final static Item ziriniumCell = new ZiriniumCell(17019).setUnlocalizedName("ziriniumCell");
	public final static Item elkostiumCell = new ElkostiumCell(17020).setUnlocalizedName("elkostiumCell");
	public final static Item heriCell = new HeriCell(17021).setUnlocalizedName("heriCell");
	public final static Item skathaCell = new SkathaCell(17022).setUnlocalizedName("skathaCell");
	public final static Item kzoriCell = new KzoriCell(17023).setUnlocalizedName("kzoriCell");
	public final static Item xylexiteCell = new XylexiteCell(17024).setUnlocalizedName("xylexiteCell");*/
	    
	public final static Item copperDust = new CopperDust(17051).setUnlocalizedName("copperDust");
	public final static Item tinDust = new TinDust(17052).setUnlocalizedName("tinDust");
	public final static Item coalDust = new CoalDust(17053).setUnlocalizedName("coalDust");
	public final static Item ironDust = new IronDust(17054).setUnlocalizedName("ironDust");
	public final static Item goldDust = new GoldDust(17055).setUnlocalizedName("goldDust");
	public final static Item diamondDust = new DiamondDust(17056).setUnlocalizedName("diamondDust");
	public final static Item silvaniteDust = new SilvaniteDust(17057).setUnlocalizedName("silvaniteDust");
	public final static Item merciliteDust = new MerciliteDust(17058).setUnlocalizedName("merciliteDust");
	public final static Item remulaDust = new RemulaDust(17059).setUnlocalizedName("remulaDust");
	public final static Item poriniteDust = new PoriniteDust(17060).setUnlocalizedName("poriniteDust");
	public final static Item pilkDust = new PilkDust(17061).setUnlocalizedName("pilkDust");
	//public final static Item tritaniteDust = new TritaniteDust(17062).setUnlocalizedName("tritaniteDust");
	public final static Item akatiteDust = new AkatiteDust(17063).setUnlocalizedName("akatiteDust");
	/*public final static Item balumDust = new BalumDust(17064).setUnlocalizedName("balumDust");
	public final static Item ventiiumDust = new VentiiumDust(17065).setUnlocalizedName("ventiiumDust");
	public final static Item arithiumDust = new ArithiumDust(17066).setUnlocalizedName("arithiumDust");
	public final static Item ziriniumDust = new ZiriniumDust(17067).setUnlocalizedName("ziriniumDust");
	public final static Item elkostiumDust = new ElkostiumDust(17068).setUnlocalizedName("elkostiumDust");
	public final static Item heriDust = new HeriDust(17069).setUnlocalizedName("heriDust");
	public final static Item skathaDust = new SkathaDust(17070).setUnlocalizedName("skathaDust");
	public final static Item kzoriDust = new KzoriDust(17071).setUnlocalizedName("kzoriDust");
	public final static Item xylexiteDust = new XylexiteDust(17072).setUnlocalizedName("xylexiteDust");*/
	
    public final static Item copperIngot = new CopperIngot(17100).setUnlocalizedName("copperIngot");
    public final static Item tinIngot = new TinIngot(17101).setUnlocalizedName("tinIngot");
	public final static Item silvaniteIngot = new SilvaniteIngot(17102).setUnlocalizedName("silvaniteIngot"); 
	public final static Item merciliteIngot = new MerciliteIngot(17103).setUnlocalizedName("merciliteIngot");
	public final static Item remulaIngot = new RemulaIngot(17104).setUnlocalizedName("remulaIngot");
	public final static Item poriniteIngot = new PoriniteIngot(17105).setUnlocalizedName("poriniteIngot");
	public final static Item pilkIngot = new PilkIngot(17106).setUnlocalizedName("pilkIngot");
	//public final static Item tritaniteIngot = new TritaniteIngot(17107).setUnlocalizedName("tritaniteIngot");
	public final static Item akatiteIngot = new AkatiteIngot(17108).setUnlocalizedName("akatiteIngot");
	/*public final static Item balumIngot = new BalumIngot(17109).setUnlocalizedName("balumIngot");
	public final static Item ventiiumIngot = new VentiiumIngot(17110).setUnlocalizedName("ventiiumIngot");
	public final static Item arithiumIngot = new ArithiumIngot(17111).setUnlocalizedName("arithiumIngot");
	public final static Item ziriniumIngot = new ZiriniumIngot(17112).setUnlocalizedName("ziriniumIngot");
	public final static Item elkostiumIngot = new ElkostiumIngot(17113).setUnlocalizedName("elkostiumIngot");
	public final static Item heriIngot = new HeriIngot(17114).setUnlocalizedName("heriIngot");
	public final static Item skathaIngot = new SkathaIngot(17115).setUnlocalizedName("skathaIngot");
	public final static Item kzoriIngot = new KzoriIngot(17116).setUnlocalizedName("kzoriIngot");
	public final static Item xylexiteIngot = new XylexiteIngot(17117).setUnlocalizedName("xylexiteIngot");*/
	
	//public final static Item silvaniteBucket = new SilvaniteBucket(17003).setUnlocalizedName("silvaniteBucket");
	//public final static Item merciliteBucket = new MerciliteBucket(17007).setUnlocalizedName("merciliteBucket");
	public final static Item simpleBattery = new SimpleBattery(17012).setUnlocalizedName("simpleBattery");
	public final static Item midBattery = new MidBattery(17013).setUnlocalizedName("midBattery");
	public final static Item highBattery = new HighBattery(17014).setUnlocalizedName("highBattery");
	public final static Item simplePRSU = new SimplePRSU(17015).setUnlocalizedName("simpleRSU");
	public final static Item midPRSU = new MidPRSU(17016).setUnlocalizedName("midRSU");
	public final static Item advancedPRSU = new AdvancedPRSU(17017).setUnlocalizedName("advancedRSU");
	public final static Item simpleSilvaniteChip = new SimpleSilvaniteChip(17018).setUnlocalizedName("simpleSilvaniteChip");
	//public final static Item midSilvaniteChip = new MidSilvaniteChip(17019).setUnlocalizedName("midSilvaniteChip");
	public final static Item advancedSilvaniteChip = new AdvancedSilvaniteChip(17020).setUnlocalizedName("advancedSilvaniteChip");
	public final static Item simpleMerciliteChip = new SimpleMerciliteChip(17021).setUnlocalizedName("simpleMerciliteChip");
	//public final static Item midMerciliteChip = new MidMerciliteChip(17022).setUnlocalizedName("midMerciliteChip");
	public final static Item advancedMerciliteChip = new AdvancedMerciliteChip(17023).setUnlocalizedName("advancedMercilieChip");
	public final static Item simpleRemulaChip = new SimpleRemulaChip(17024).setUnlocalizedName("simpleRemulaChip");
	//public final static Item midRemulaChip = new MidRemulaChip(17025).setUnlocalizedName("midRemulaChip")
	public final static Item advancedRemulaChip = new AdvancedRemulaChip(17026).setUnlocalizedName("advancedRemulaChip");
	//public final static Item remDrill = new RemDrill(17027).setUnlocalizedName("remDrill");
	public final static Item drillTransformerUpgrade = new DrillTransformerUpgrade(17028).setUnlocalizedName("drillTransformerUpgrade");
	public final static Item drillSilkTouchUpgrade = new DrillSilkTouchUpgrade(17029).setUnlocalizedName("drillSilkTouchUpgrade");
	public final static Item drillSpeedControlUpgrade = new DrillSpeedControlUpgrade(17030).setUnlocalizedName("drillSpeedControlUpgrade");
	public final static Item drillBatteryUpgrade = new DrillBatteryUpgrade(17031).setUnlocalizedName("drillBatteryUpgrade");
	public final static Item simpleP1RobotSpawner = new SimpleP1RobotSpawner(17034).setUnlocalizedName("simpleP1RobotSpawner");
	public final static Item midP1RobotSpawner = new MidP1RobotSpawner(17035).setUnlocalizedName("midP1RobotSpawner");
	public final static Item advancedP1RobotSpawner = new AdvancedP1RobotSpawner(17036).setUnlocalizedName("advancedP1RobotSpawner");
	public final static Item simpleP3RobotSpawner = new SimpleP3RobotSpawner(17037).setUnlocalizedName("simpleP3RobotSpawner");
	public final static Item midP3RobotSpawner = new MidP3RobotSpawner(17038).setUnlocalizedName("midP3RobotSpawner");
	public final static Item advancedP3RobotSpawner = new AdvancedP3RobotSpawner(17039).setUnlocalizedName("advancedP3RobotSpawner");
	public final static Item simpleP5RobotSpawner = new SimpleP5RobotSpawner(17037).setUnlocalizedName("simpleP5RobotSpawner");
	public final static Item midP5RobotSpawner = new MidP5RobotSpawner(17038).setUnlocalizedName("midP5RobotSpawner");
	public final static Item advancedP5RobotSpawner = new AdvancedP5RobotSpawner(17039).setUnlocalizedName("advancedP5RobotSpawner");
	public final static Item simpleP7RobotSpawner = new SimpleP7RobotSpawner(17037).setUnlocalizedName("simpleP7RobotSpawner");
	public final static Item midP7RobotSpawner = new MidP7RobotSpawner(17038).setUnlocalizedName("midP7RobotSpawner");
	public final static Item advancedP7RobotSpawner = new AdvancedP7RobotSpawner(17039).setUnlocalizedName("advancedP7RobotSpawner");
	public final static Item simpleP9RobotSpawner = new SimpleP9RobotSpawner(17037).setUnlocalizedName("simpleP9RobotSpawner");
	public final static Item midP9RobotSpawner = new MidP9RobotSpawner(17038).setUnlocalizedName("midP9RobotSpawner");
	public final static Item advancedP9RobotSpawner = new AdvancedP9RobotSpawner(17039).setUnlocalizedName("advancedP9RobotSpawner");
	//TODO find a decent plant tutorial o.O
	//public final static Item porinSeeds = new PorinSeeds(17040, akatoeDirt.blockID, akatoeTilledDirt.blockID).setUnlocalizedName("porinSeeds");
	//public final static Item ulinSeeds = new UlinSeeds(17041, remulaOre.blockID, akatoeTilledDirt.blockID).setUnlocalizedName("ulinSeeds");
	//public final static Item cirSeeds = new CirSeeds(17042, remulaOre.blockID, akatoeTilledDirt.blockID).setUnlocalizedName("cirSeeds");
	//public final static Item boskinSeeds = new BoskinSeeds(17043, remulaOre.blockID, akatoeTilledDirt.blockID).setUnlocalizedName("boskinSeeds");
	public final static Item porinFruit = new PorinFruit(17044, 5, 3.0F, false).setUnlocalizedName("porinFruit");
	public final static Item ulinFruit = new UlinFruit(17045, 2, 1.0F, false).setUnlocalizedName("ulinFruit");
	public final static Item itemCir = new ItemCir(17046).setUnlocalizedName("itemCir");
	public final static Item itemBoskin = new ItemBoskin(17047).setUnlocalizedName("itemBoskin");
	public final static Item rawGlogMeat = new RawGlogMeat(17059, 0, 0.0F, false).setUnlocalizedName("rawGlogMeat");
	public final static Item cookedGlogMeat = new CookedGlogMeat(17060, 8, 14.0F, true).setUnlocalizedName("cookedGlogMeat");
	public final static Item skitterling = new SkitterlingItem(17061, 3, 6.0F, false).setUnlocalizedName("skitterling");
	public final static Item skitterlingDead = new SkitterlingDead(17062, 1, 3.0F, false).setUnlocalizedName("skitterlingDead");
	public final static Item rawSkitterlingStick = new RawSkitterlingStick(17063, 9, 6.0F, false).setUnlocalizedName("rawSkitterlingStick");
	public final static Item cookedSkitterlingStick = new CookedSkitterlingStick(17064, 12, 6.0F, false).setUnlocalizedName("cookedSkitterlingStick");
	public final static Item rawHermustMeat = new RawHermustMeat(17065, 4, 4.0F, true).setUnlocalizedName("rawHermustMeat");
	public final static Item cookedHermustMeat = new CookedHermustMeat(17066, 10, 10.0F, true).setUnlocalizedName("cookedHermustMeat");
	public final static Item rawGarfinMeat = new RawGarfinMeat(17067, 5, 3.5F, false).setUnlocalizedName("rawGarfinMeat");
	public final static Item cookedGarfinMeat = new CookedGarfinMeat(17068, 12, 12.0F, false).setUnlocalizedName("cookedGarfinMeat");
	public final static Item rawLignisMeat = new RawLignisMeat(17069, 8, 8.0F, false).setUnlocalizedName("rawLingisMeat");
	public final static Item cookedLignisMeat = new CookedLignisMeat(17070, 16, 15.0F, false).setUnlocalizedName("cookedLingisMeat");
	
	
	public final static Item p1HudUnit = new P1HUDUnit(17071, SpaceSuit1, 1, 0, false).setUnlocalizedName("p1HudUnit");
	//public final static Item p1SpaceSuitHelmet = new P1SpaceSuit(17056, EnumArmorMaterial.CLOTH, proxy.addArmor("P1SpaceSuit"), 0).setUnlocalizedName("p1SpaceSuitHelmet");
	//public final static Item p1SpaceSuitBody = new P1SpaceSuit(17057, EnumArmorMaterial.CLOTH, proxy.addArmor("P1SpaceSuit"), 1).setUnlocalizedName("p1SpaceSuitBody");
	//public final static Item p1SpaceSuitLegs = new P1SpaceSuit(17058, EnumArmorMaterial.CLOTH, proxy.addArmor("P1SpaceSuit"), 2).setUnlocalizedName("p1SpaceSuitLegs");
	//public final static Item p1SpaceSuitBoots = new P1SpaceSuit(17059, SpaceSuit1, proxy.addArmor("P1SpaceSuit"), 3).setUnlocalizedName("p1SpaceSuitBoots");
	//public final static Item p1HeadUI = new P1HeadUI(17060).setUnlocalizedName("p1HeadUI");
	public final static Item p1Pistol = new ItemP1Pistol(17042).setUnlocalizedName("p1Pistol");
	public final static Item p1IronBullet = new P1IronBullet(17043).setUnlocalizedName("p1IronBullet");
	//InfusionUpgrade
	//StorageUpgrade
	//SpeedUpgrade
	//StrengthUpgrade
	//CCUpgrade?*/
	
    public static BiomeGenBase akatoePlainsBiome = new BiomeAkatoePlains(60);
    public static BiomeGenBase akatoeDesertBiome = new BiomeAkatoeDesert(61);
    public static BiomeGenBase akatoeOceanBiome = new BiomeAkatoeOcean(62);
    public static BiomeGenBase baloinusPlainsBiome = new BiomeBaloinusPlains(65);
    public static BiomeGenBase elkostDesertBiome = new BiomeElkostPlains(66);
    public static BiomeGenBase indikuJungleBiome = new BiomeIndikuJungle(67);
    public static BiomeGenBase xylexiaPlainsBiome = new BiomeXylexiaPlains(68);
    
    @EventHandler
    public void load(FMLInitializationEvent event) {
            proxy.registerRenderThings();
            proxy.init();
                 
            //The whitespace here is simply for organisation. I like to keep it neat.
            //If you're trying to learn from my code (good luck ;)), the below section doesn't need to be in any specific order.
            OreDictionary.registerOre("woodRubber", new ItemStack (rubberLog));
            OreDictionary.registerOre("oreCoal", new ItemStack(akatoeOreBlocks, 1, 0));
            OreDictionary.registerOre("oreIron", new ItemStack(akatoeOreBlocks, 1, 3));
            OreDictionary.registerOre("oreGold", new ItemStack(akatoeOreBlocks, 1, 4));
            OreDictionary.registerOre("oreCopper", new ItemStack(akatoeOreBlocks, 1, 1));
            OreDictionary.registerOre("oreTin", new ItemStack(akatoeOreBlocks, 1, 2));
            OreDictionary.registerOre("oreLapisLazuli", new ItemStack(akatoeOreBlocks, 1, 5));
            OreDictionary.registerOre("orePorinite", new ItemStack(akatoeOreBlocks, 1, 7));
            OreDictionary.registerOre("orePilk", new ItemStack(akatoeOreBlocks, 1, 8));
            OreDictionary.registerOre("oreRemula", new ItemStack(akatoeOreBlocks, 1, 6));
            OreDictionary.registerOre("oreAkatoe", new ItemStack(akatoeOreBlocks, 1, 9));
            
            //Register names for blocks
            
            //Tree Stuff
            LanguageRegistry.addName(rubberLog, "Rubber Log");
            LanguageRegistry.addName(rubberLeaves, "Rubber Leaves");
            LanguageRegistry.addName(rubberSapling, "Rubber Sapling");
            
            
            //Powergrid
            LanguageRegistry.addName(p1T1StorageUnit, "Tier 1 RSU");
            LanguageRegistry.addName(p1T2StorageUnit, "Tier 2 RSU");
            LanguageRegistry.addName(p1T3StorageUnit, "Tier 3 RSU");
            LanguageRegistry.addName(p1Generator, "Remula Generator");
            LanguageRegistry.addName(p1SolarPanel, "Remula Solar Panel");
            LanguageRegistry.addName(p1ThermalGenerator, "Thermal Generator");
            LanguageRegistry.addName(p1Grinder, "Grinder");
            LanguageRegistry.addName(p1ReactorCore, "Reactor Core");
            
            //Nature and Plant Stuff
            /*LanguageRegistry.addName(porinCrop, "Porin Crop");
            LanguageRegistry.addName(ulinCrop, "Ulin Crop");
            LanguageRegistry.addName(cirCrop, "Cir Crop");
            LanguageRegistry.addName(boskinCrop, "Boskin Crop");*/
            LanguageRegistry.addName(plantFuxii, "Fuxii");
            
            //Storage and Tile Entites
            LanguageRegistry.addName(silvaniteChest, "Silvanite Chest");
            LanguageRegistry.addName(merciliteChest, "Mercilite Chest");
            LanguageRegistry.addName(tecmoniumChest, "Tecmonium Chest");

            //Register Blocks
            //Plants and Nature
            GameRegistry.registerBlock(akatoeLogs, "akatoeLogs");
            GameRegistry.registerBlock(akatoeLeaves, "akatoeLeaves");
            GameRegistry.registerBlock(akatoeSaplings, "akatoeSaplings");
            GameRegistry.registerBlock(rubberLog, "rubberLog");
            //GameRegistry.registerBlock(rubberLeaves, "rubberLeaves");
            GameRegistry.registerBlock(rubberSapling, "rubberSapling");
            /*GameRegistry.registerBlock(porinCrop, "porinCrop");
            GameRegistry.registerBlock(ulinCrop, "ulinCrop");
            GameRegistry.registerBlock(cirCrop, "cirCrop");
            GameRegistry.registerBlock(boskinCrop, "boskinCrop");
            GameRegistry.registerBlock(plantFuxii, "plantFuxii");
            
            
            
            //Powergrid
            GameRegistry.registerBlock(remulaBasicStorageUnit, "remulaBasicStorageUnit");
            GameRegistry.registerBlock(remulaSimpleStorageUnit, "remulaSimpleStorageUnit");
            //GameRegistry.registerBlock(remulaMidStorageUnit, "remulaMidStorageUnit");
            GameRegistry.registerBlock(remulaHighStorageUnit, "remulaHighStorageUnit");
            GameRegistry.registerBlock(remulaExcessiveStorageUnit, "remulaExcessiveStorageUnit");
            GameRegistry.registerBlock(remulaExperimentalStorageUnit, "remulaExperimentalStorageUnit");
            GameRegistry.registerBlock(remulaGenerator, "remulaGenerator");
            GameRegistry.registerBlock(remulaSolarPanel, "remulaSolarPanel");
            GameRegistry.registerBlock(remulaThermalGenerator, "remulaThermalGenerator");
            GameRegistry.registerBlock(remulaGrinder, "remulaGrinder");
            GameRegistry.registerBlock(remulaReactorCore, "remulaReactorCore");*/
            
            //Storage Blocks/Tile Entites
            GameRegistry.registerBlock(silvaniteChest, "silvaniteChest");
            GameRegistry.registerBlock(merciliteChest, "merciliteChest");
            GameRegistry.registerBlock(tecmoniumChest, "tecmoniumChest");
            
            GameRegistry.registerBlock(earthOreBlocks, ItemEarthOreBlocks.class, "Remula" + (earthOreBlocks.getUnlocalizedName().substring(5)));
            LanguageRegistry.addName(new ItemStack(earthOreBlocks, 1, 0), "Copper Ore");
            LanguageRegistry.addName(new ItemStack(earthOreBlocks, 1, 1), "Tin Ore");
            LanguageRegistry.addName(new ItemStack(earthOreBlocks, 1, 2), "Zinc Ore");
            LanguageRegistry.addName(new ItemStack(earthOreBlocks, 1, 3), "Silver Ore");
            LanguageRegistry.addName(new ItemStack(earthOreBlocks, 1, 4), "Silvanite Ore");
            LanguageRegistry.addName(new ItemStack(earthOreBlocks, 1, 5), "Mercilite Ore");
            LanguageRegistry.addName(new ItemStack(earthOreBlocks, 1, 6), "Remula Ore");
            
            
            //Akatoe
            GameRegistry.registerBlock(akatoeTerrainBlocks, ItemAkatoeTerrainBlocks.class, "Remula" + (akatoeTerrainBlocks.getUnlocalizedName().substring(5)));
            GameRegistry.registerBlock(akatoeOreBlocks, ItemAkatoeOreBlocks.class, "Remula" + (akatoeOreBlocks.getUnlocalizedName().substring(5)));
            GameRegistry.registerBlock(akatoePortal, "akatoePortal");
            GameRegistry.registerBlock(akatoeStone, "akatoeStone");
            GameRegistry.registerBlock(akatoeGrass, "akatoeGrass");
            GameRegistry.registerBlock(akatoeDirt, "akatoeDirt");
            GameRegistry.registerBlock(akatoeSand, "akatoeSand");
            GameRegistry.registerBlock(akatoeTilledDirt, "akatoeTilledDirt");
            
            LanguageRegistry.addName(new ItemStack(akatoeTerrainBlocks, 1, 0), "Akatonian Cobblestone");
            LanguageRegistry.addName(new ItemStack(akatoeTerrainBlocks, 1, 1), "Akatonian Bricks");
            LanguageRegistry.addName(new ItemStack(akatoeTerrainBlocks, 1, 2), "Akatonian Small Bricks");
            LanguageRegistry.addName(new ItemStack(akatoeTerrainBlocks, 1, 3), "Akatonian Decorative Bricks");
            LanguageRegistry.addName(new ItemStack(akatoeTerrainBlocks, 1, 4), "Akatonian Refined Stone");
            LanguageRegistry.addName(new ItemStack(akatoeTerrainBlocks, 1, 5), "Akatonian Glass");
            LanguageRegistry.addName(new ItemStack(akatoeOreBlocks, 1, 0), "Akatonian Coal Ore");
            LanguageRegistry.addName(new ItemStack(akatoeOreBlocks, 1, 1), "Akatonian Copper Ore");
            LanguageRegistry.addName(new ItemStack(akatoeOreBlocks, 1, 2), "Akatonian Tin Ore");
            LanguageRegistry.addName(new ItemStack(akatoeOreBlocks, 1, 3), "Akatonian Iron Ore");
            LanguageRegistry.addName(new ItemStack(akatoeOreBlocks, 1, 4), "Akatonian Gold Ore");
            LanguageRegistry.addName(new ItemStack(akatoeOreBlocks, 1, 5), "Akatonian Lapis Ore"); 
            LanguageRegistry.addName(new ItemStack(akatoeOreBlocks, 1, 6), "Akatonian Remula Ore");
            LanguageRegistry.addName(new ItemStack(akatoeOreBlocks, 1, 7), "Akatonian Porinite Ore");
            LanguageRegistry.addName(new ItemStack(akatoeOreBlocks, 1, 8), "Akatonian Pilk Ore");
            LanguageRegistry.addName(new ItemStack(akatoeOreBlocks, 1, 9), "Akatite Ore");
            LanguageRegistry.addName(akatoePortal, "Akatoe Portal");
            LanguageRegistry.addName(akatoeStone, "Akatonian Stone");
            LanguageRegistry.addName(akatoeGrass, "Akatonian Grass");
            LanguageRegistry.addName(akatoeDirt, "Akatonian Dirt");
            LanguageRegistry.addName(akatoeSand, "Akatonian Sand");
            LanguageRegistry.addName(akatoeTilledDirt, "Akatonian Tilled Dirt");
            
            
            //Baloinus
            GameRegistry.registerBlock(baloinusTerrainBlocks, ItemBaloinusTerrainBlocks.class, "Remula" + (baloinusTerrainBlocks.getUnlocalizedName().substring(5)));
            GameRegistry.registerBlock(baloinusOreBlocks, ItemBaloinusOreBlocks.class, "Remula" + (baloinusOreBlocks.getUnlocalizedName().substring(5)));
            GameRegistry.registerBlock(baloinusPortal, "baloinusPortal");
            GameRegistry.registerBlock(baloinusStone, "baloinusStone");
            
            LanguageRegistry.addName(new ItemStack(baloinusTerrainBlocks, 1, 0), "Baloinus Cobblestone");
            LanguageRegistry.addName(new ItemStack(baloinusTerrainBlocks, 1, 1), "Baloinus Bricks");
            LanguageRegistry.addName(new ItemStack(baloinusTerrainBlocks, 1, 2), "Baloinus Small Bricks");
            LanguageRegistry.addName(new ItemStack(baloinusTerrainBlocks, 1, 3), "Baloinus Decorative Bricks");
            LanguageRegistry.addName(new ItemStack(baloinusTerrainBlocks, 1, 4), "Baloinus Refined Stone");
            LanguageRegistry.addName(new ItemStack(baloinusTerrainBlocks, 1, 5), "Baloinus Sand");
            LanguageRegistry.addName(new ItemStack(baloinusOreBlocks, 1, 0), "Baloinus Coal Ore");
            LanguageRegistry.addName(new ItemStack(baloinusOreBlocks, 1, 1), "Baloinus Copper Ore");
            LanguageRegistry.addName(new ItemStack(baloinusOreBlocks, 1, 2), "Baloinus Tin Ore");
            LanguageRegistry.addName(new ItemStack(baloinusOreBlocks, 1, 3), "Baloinus Iron Ore");
            LanguageRegistry.addName(new ItemStack(baloinusOreBlocks, 1, 4), "Baloinus Remula Ore");
            LanguageRegistry.addName(new ItemStack(baloinusOreBlocks, 1, 5), "Baloinus Porinite Ore");
            LanguageRegistry.addName(new ItemStack(baloinusOreBlocks, 1, 6), "Baloinus Pilk Ore");
            LanguageRegistry.addName(new ItemStack(baloinusOreBlocks, 1, 7), "Baloinus Tritanite Ore");
            LanguageRegistry.addName(new ItemStack(baloinusOreBlocks, 1, 8), "Baloinus Balum Ore");
            LanguageRegistry.addName(baloinusPortal, "Baloinus Portal");
            LanguageRegistry.addName(baloinusStone, "Baloinus Stone");
            
            
            //Indiku
            GameRegistry.registerBlock(indikuTerrainBlocks, ItemIndikuTerrainBlocks.class, "Remula" + (indikuTerrainBlocks.getUnlocalizedName().substring(5)));
            GameRegistry.registerBlock(indikuOreBlocks, ItemIndikuOreBlocks.class, "Remula" + (indikuOreBlocks.getUnlocalizedName().substring(5)));
            GameRegistry.registerBlock(indikuPortal, "indikuPortal");
            GameRegistry.registerBlock(indikuStone, "indikuStone");
            GameRegistry.registerBlock(indikuDirt, "indikuDirt");
            GameRegistry.registerBlock(indikuGrass, "indikuGrass");
            GameRegistry.registerBlock(indikuTilledDirt, "indikuTilledDirt");
            
            
            LanguageRegistry.addName(new ItemStack(indikuTerrainBlocks, 1, 0), "Indiku Cobblestone");
            LanguageRegistry.addName(new ItemStack(indikuTerrainBlocks, 1, 1), "Indiku Bricks");
            LanguageRegistry.addName(new ItemStack(indikuTerrainBlocks, 1, 2), "Indiku Small Bricks");
            LanguageRegistry.addName(new ItemStack(indikuTerrainBlocks, 1, 3), "Indiku Decorative Bricks");
            LanguageRegistry.addName(new ItemStack(indikuTerrainBlocks, 1, 4), "Indiku Refined Stone");
            LanguageRegistry.addName(new ItemStack(indikuTerrainBlocks, 1, 5), "Indiku Sand");
            LanguageRegistry.addName(new ItemStack(indikuTerrainBlocks, 1, 6), "Indiku Glass");
            LanguageRegistry.addName(new ItemStack(indikuOreBlocks, 1, 0), "Indiku Coal Ore");
            LanguageRegistry.addName(new ItemStack(indikuOreBlocks, 1, 1), "Indiku Copper Ore");
            LanguageRegistry.addName(new ItemStack(indikuOreBlocks, 1, 2), "Indiku Tin Ore");
            LanguageRegistry.addName(new ItemStack(indikuOreBlocks, 1, 3), "Indiku Iron Ore");
            LanguageRegistry.addName(new ItemStack(indikuOreBlocks, 1, 4), "Indiku Gold Ore");
            LanguageRegistry.addName(new ItemStack(indikuOreBlocks, 1, 5), "Indiku Lapis Lazuli Ore");
            LanguageRegistry.addName(new ItemStack(indikuOreBlocks, 1, 6), "Indiku Remula Ore");
            LanguageRegistry.addName(new ItemStack(indikuOreBlocks, 1, 7), "Indiku Tritanite Ore");
            LanguageRegistry.addName(new ItemStack(indikuOreBlocks, 1, 8), "Indiku Ventiium Ore");
            LanguageRegistry.addName(new ItemStack(indikuOreBlocks, 1, 9), "Indiku Arithium Ore");
            LanguageRegistry.addName(new ItemStack(indikuOreBlocks, 1, 10), "Indiku Zirinium Ore");
            LanguageRegistry.addName(new ItemStack(indikuOreBlocks, 1, 11), "Indikite Ore");
            LanguageRegistry.addName(indikuStone, "Indiku Stone");
            LanguageRegistry.addName(indikuDirt, "Indiku Dirt");
            LanguageRegistry.addName(indikuGrass, "Indiku Grass");
            LanguageRegistry.addName(indikuTilledDirt, "Indiku Tilled Dirt");
            LanguageRegistry.addName(indikuPortal, "Indiku Portal");
            
            
            //Elkost
            GameRegistry.registerBlock(elkostTerrainBlocks, ItemElkostTerrainBlocks.class, "Remula" + (elkostTerrainBlocks.getUnlocalizedName().substring(5)));
            GameRegistry.registerBlock(elkostOreBlocks, ItemElkostOreBlocks.class, "Remula" + (elkostOreBlocks.getUnlocalizedName().substring(5)));
            GameRegistry.registerBlock(elkostPortal, "elkostPortal");
            GameRegistry.registerBlock(elkostSand, "elkostSand");
            GameRegistry.registerBlock(elkostGlassPane, "elkostGlassPane");
                        
            LanguageRegistry.addName(new ItemStack(elkostTerrainBlocks, 1, 0), "Elkost Cobblestone");
            LanguageRegistry.addName(new ItemStack(elkostTerrainBlocks, 1, 1), "Elkost Bricks");
            LanguageRegistry.addName(new ItemStack(elkostTerrainBlocks, 1, 2), "Elkost Small Bricks");
            LanguageRegistry.addName(new ItemStack(elkostTerrainBlocks, 1, 3), "Elkost Decorative Bricks");
            LanguageRegistry.addName(new ItemStack(elkostTerrainBlocks, 1, 4), "Elkost Refined Stone");
            LanguageRegistry.addName(new ItemStack(elkostTerrainBlocks, 1, 5), "Elkost Stone");
            LanguageRegistry.addName(new ItemStack(elkostOreBlocks, 1, 0), "Elkost Coal Ore");
            LanguageRegistry.addName(new ItemStack(elkostOreBlocks, 1, 1), "Elkost Copper Ore");
            LanguageRegistry.addName(new ItemStack(elkostOreBlocks, 1, 2), "Elkost Tin Ore");
            LanguageRegistry.addName(new ItemStack(elkostOreBlocks, 1, 3), "Elkost Iron Ore");
            LanguageRegistry.addName(new ItemStack(elkostOreBlocks, 1, 4), "Elkost Gold Ore");
            LanguageRegistry.addName(new ItemStack(elkostOreBlocks, 1, 5), "Elkost Lapis Lazuli Ore");            
            LanguageRegistry.addName(new ItemStack(elkostOreBlocks, 1, 6), "Elkost Remula Ore");
            LanguageRegistry.addName(new ItemStack(elkostOreBlocks, 1, 7), "Elkost Tritanite Ore");
            LanguageRegistry.addName(new ItemStack(elkostOreBlocks, 1, 8), "Elkost Zirinium Ore");
            LanguageRegistry.addName(new ItemStack(elkostOreBlocks, 1, 9), "Elkost Boria Ore");
            LanguageRegistry.addName(new ItemStack(elkostOreBlocks, 1, 10), "Elkost Tristanium Ore");
            LanguageRegistry.addName(new ItemStack(elkostOreBlocks, 1, 11), "Elkost Grinist Ore");
            LanguageRegistry.addName(new ItemStack(elkostOreBlocks, 1, 12), "Elkost Elkostium Ore");
            LanguageRegistry.addName(elkostSand, "Elkost Sand");
            LanguageRegistry.addName(elkostGlassPane, "Elkost Glass Pane");
            LanguageRegistry.addName(elkostPortal, "Elkost Portal");
            
            
            //Xylexia
            GameRegistry.registerBlock(xylexiaTerrainBlocks, ItemXylexiaTerrainBlocks.class, "Remula" + (xylexiaTerrainBlocks.getUnlocalizedName().substring(5)));
            GameRegistry.registerBlock(xylexiaOreBlocks, ItemXylexiaOreBlocks.class, "Remula" + (xylexiaOreBlocks.getUnlocalizedName().substring(5)));
            GameRegistry.registerBlock(xylexiaPortal, "xylexiaPortal");
            GameRegistry.registerBlock(xylexianSand, "xylexianSand");
            GameRegistry.registerBlock(xylexianStone, "xylexianStone");
            GameRegistry.registerBlock(xylexianGlassPane, "xylexianGlassPane");
            
            LanguageRegistry.addName(xylexianSand, "Xylexian Sand");
            LanguageRegistry.addName(xylexianStone, "Impure Xylexite");
            LanguageRegistry.addName(xylexianGlassPane, "Xylexian Glass Pane");
            LanguageRegistry.addName(new ItemStack(xylexiaTerrainBlocks, 1, 0), "Xylexian Cobblestone");
            LanguageRegistry.addName(new ItemStack(xylexiaTerrainBlocks, 1, 1), "Xylexian Bricks");
            LanguageRegistry.addName(new ItemStack(xylexiaTerrainBlocks, 1, 2), "Xylexian Small Bricks");
            LanguageRegistry.addName(new ItemStack(xylexiaTerrainBlocks, 1, 3), "Xylexian Decorative Bricks");
            LanguageRegistry.addName(new ItemStack(xylexiaTerrainBlocks, 1, 4), "Xylexian Refined Stone");
            LanguageRegistry.addName(new ItemStack(xylexiaTerrainBlocks, 1, 5), "Xylexian Glass");
            LanguageRegistry.addName(new ItemStack(xylexiaOreBlocks, 1, 0), "Xylexian Coal Ore");
            LanguageRegistry.addName(new ItemStack(xylexiaOreBlocks, 1, 1), "Xylexian Copper Ore");
            LanguageRegistry.addName(new ItemStack(xylexiaOreBlocks, 1, 2), "Xylexian Tin Ore");
            LanguageRegistry.addName(new ItemStack(xylexiaOreBlocks, 1, 3), "Xylexian Iron Ore");
            LanguageRegistry.addName(new ItemStack(xylexiaOreBlocks, 1, 4), "Xylexian Gold Ore");
            LanguageRegistry.addName(new ItemStack(xylexiaOreBlocks, 1, 5), "Xylexian Lapis Lazuli Ore");
            LanguageRegistry.addName(new ItemStack(xylexiaOreBlocks, 1, 6), "Xylexian Remula Ore");
            LanguageRegistry.addName(new ItemStack(xylexiaOreBlocks, 1, 7), "Xylexian Tritanite Ore");
            LanguageRegistry.addName(new ItemStack(xylexiaOreBlocks, 1, 8), "Xylexian Zirinium Ore");
            LanguageRegistry.addName(new ItemStack(xylexiaOreBlocks, 1, 9), "Xylexian Grinist Ore");
            LanguageRegistry.addName(new ItemStack(xylexiaOreBlocks, 1, 10), "Xylexian Heri Ore");
            LanguageRegistry.addName(new ItemStack(xylexiaOreBlocks, 1, 11), "Xylexian Skatha Ore");
            LanguageRegistry.addName(new ItemStack(xylexiaOreBlocks, 1, 12), "Xylexian Kzori Ore");
            LanguageRegistry.addName(new ItemStack(xylexiaOreBlocks, 1, 13), "Xylexite Ore");
            
            //Deep Space
            GameRegistry.registerBlock(deepSpaceTerrainBlocks, ItemDeepSpaceTerrainBlocks.class, "Remula" + (deepSpaceTerrainBlocks.getUnlocalizedName().substring(5)));
            GameRegistry.registerBlock(deepSpaceBrownOreBlocks, ItemDeepSpaceBrownOreBlocks.class, "Remula" + (deepSpaceBrownOreBlocks.getUnlocalizedName().substring(5)));
            GameRegistry.registerBlock(deepSpaceWhiteOreBlocks, ItemDeepSpaceWhiteOreBlocks.class, "Remula" + (deepSpaceWhiteOreBlocks.getUnlocalizedName().substring(5)));
            GameRegistry.registerBlock(deepSpacePortal, "deepSpacePortal");
            GameRegistry.registerBlock(deepSpaceBrownAsteroidRock, "deepSpaceAsteroidRock");
            GameRegistry.registerBlock(deepSpaceWhiteAsteroidRock, "deepSpaceMeteoriteRock");
            
            LanguageRegistry.addName(new ItemStack(deepSpaceTerrainBlocks, 1, 0), "Brown Asteroid Rubble");
            LanguageRegistry.addName(new ItemStack(deepSpaceTerrainBlocks, 1, 1), "Brown Asteroid Bricks");
            LanguageRegistry.addName(new ItemStack(deepSpaceTerrainBlocks, 1, 2), "Brown Asteroid Small Bricks");
            LanguageRegistry.addName(new ItemStack(deepSpaceTerrainBlocks, 1, 3), "Brown Asteroid Decorative Bricks");
            LanguageRegistry.addName(new ItemStack(deepSpaceTerrainBlocks, 1, 4), "Refined Brown Asteroid");
            LanguageRegistry.addName(new ItemStack(deepSpaceTerrainBlocks, 1, 5), "Brown Asteroid Dust");
            LanguageRegistry.addName(new ItemStack(deepSpaceTerrainBlocks, 1, 6), "Null");
            LanguageRegistry.addName(new ItemStack(deepSpaceTerrainBlocks, 1, 7), "Null");
            LanguageRegistry.addName(new ItemStack(deepSpaceTerrainBlocks, 1, 8), "White Asteroid Rubble");
            LanguageRegistry.addName(new ItemStack(deepSpaceTerrainBlocks, 1, 9), "White Asteroid Bricks");
            LanguageRegistry.addName(new ItemStack(deepSpaceTerrainBlocks, 1, 10), "White Asteroid Small Bricks");
            LanguageRegistry.addName(new ItemStack(deepSpaceTerrainBlocks, 1, 11), "White Asteroid Decorative Bricks");
            LanguageRegistry.addName(new ItemStack(deepSpaceTerrainBlocks, 1, 12), "Refined White Asteroid ");
            LanguageRegistry.addName(new ItemStack(deepSpaceTerrainBlocks, 1, 13), "White Asteroid Dust");
            LanguageRegistry.addName(new ItemStack(deepSpaceTerrainBlocks, 1, 14), "Null");
            LanguageRegistry.addName(new ItemStack(deepSpaceTerrainBlocks, 1, 15), "Null");
            
            LanguageRegistry.addName(new ItemStack(deepSpaceBrownOreBlocks, 1, 0), "Brown Asteroid Copper Ore");
            LanguageRegistry.addName(new ItemStack(deepSpaceBrownOreBlocks, 1, 1), "Brown Asteroid Tin Ore");
            LanguageRegistry.addName(new ItemStack(deepSpaceBrownOreBlocks, 1, 2), "Brown Asteroid Iron Ore");
            LanguageRegistry.addName(new ItemStack(deepSpaceBrownOreBlocks, 1, 3), "Brown Asteroid Silvanite Ore");
            LanguageRegistry.addName(new ItemStack(deepSpaceBrownOreBlocks, 1, 4), "Brown Asteroid Mercilite Ore");
            LanguageRegistry.addName(new ItemStack(deepSpaceBrownOreBlocks, 1, 5), "Brown Asteroid Porinite Ore");
            LanguageRegistry.addName(new ItemStack(deepSpaceBrownOreBlocks, 1, 6), "Brown Asteroid Zinc Ore");
            LanguageRegistry.addName(new ItemStack(deepSpaceBrownOreBlocks, 1, 7), "Brown Asteroid Thori Ore");
            LanguageRegistry.addName(new ItemStack(deepSpaceBrownOreBlocks, 1, 8), "Brown Asteroid Ventiium Ore");
            LanguageRegistry.addName(new ItemStack(deepSpaceBrownOreBlocks, 1, 9), "Brown Asteroid Farithium Ore");
            LanguageRegistry.addName(new ItemStack(deepSpaceBrownOreBlocks, 1, 10), "Brown Asteroid Boria Ore");
            LanguageRegistry.addName(new ItemStack(deepSpaceBrownOreBlocks, 1, 11), "Brown Asteroid Heri Ore");
            LanguageRegistry.addName(new ItemStack(deepSpaceBrownOreBlocks, 1, 12), "Brown Asteroid Paladixium Ore");
            LanguageRegistry.addName(new ItemStack(deepSpaceBrownOreBlocks, 1, 13), "Brown Asteroid Aerolian Ore");
            LanguageRegistry.addName(new ItemStack(deepSpaceBrownOreBlocks, 1, 14), "Brown Asteroid Technolium Ore");
            LanguageRegistry.addName(new ItemStack(deepSpaceBrownOreBlocks, 1, 15), "Brown Asteroid P9 Ore");
            
            LanguageRegistry.addName(new ItemStack(deepSpaceWhiteOreBlocks, 1, 0), "White Asteroid Copper Ore");
            LanguageRegistry.addName(new ItemStack(deepSpaceWhiteOreBlocks, 1, 1), "White Asteroid Tin Ore");
            LanguageRegistry.addName(new ItemStack(deepSpaceWhiteOreBlocks, 1, 2), "White Asteroid Iron Ore");
            LanguageRegistry.addName(new ItemStack(deepSpaceWhiteOreBlocks, 1, 3), "White Asteroid Silvanite Ore");
            LanguageRegistry.addName(new ItemStack(deepSpaceWhiteOreBlocks, 1, 4), "White Asteroid Mercilite Ore");
            LanguageRegistry.addName(new ItemStack(deepSpaceWhiteOreBlocks, 1, 5), "White Asteroid Porinite Ore");
            LanguageRegistry.addName(new ItemStack(deepSpaceWhiteOreBlocks, 1, 6), "White Asteroid Zinc Ore");
            LanguageRegistry.addName(new ItemStack(deepSpaceWhiteOreBlocks, 1, 7), "White Asteroid Thori Ore");
            LanguageRegistry.addName(new ItemStack(deepSpaceWhiteOreBlocks, 1, 8), "White Asteroid Ventiium Ore");
            LanguageRegistry.addName(new ItemStack(deepSpaceWhiteOreBlocks, 1, 9), "White Asteroid Farithium Ore");
            LanguageRegistry.addName(new ItemStack(deepSpaceWhiteOreBlocks, 1, 10), "White Asteroid Boria Ore");
            LanguageRegistry.addName(new ItemStack(deepSpaceWhiteOreBlocks, 1, 11), "White Asteroid Heri Ore");
            LanguageRegistry.addName(new ItemStack(deepSpaceWhiteOreBlocks, 1, 12), "White Asteroid Paladixium Ore");
            LanguageRegistry.addName(new ItemStack(deepSpaceWhiteOreBlocks, 1, 13), "White Asteroid Aerolian Ore");
            LanguageRegistry.addName(new ItemStack(deepSpaceWhiteOreBlocks, 1, 14), "White Asteroid Technolium Ore");
            LanguageRegistry.addName(new ItemStack(deepSpaceWhiteOreBlocks, 1, 15), "White Asteroid P9 Ore");
            LanguageRegistry.addName(deepSpacePortal, "Deep-Space Portal");
            LanguageRegistry.addName(deepSpaceBrownAsteroidRock, "Asteroid Rock");
            LanguageRegistry.addName(deepSpaceWhiteAsteroidRock, "Asteroid Rock");
            
            //Ore Mining Requirements
            /*MinecraftForge.setBlockHarvestLevel(silvaniteOre, "pickaxe", 1);
            MinecraftForge.setBlockHarvestLevel(merciliteOre, "pickaxe", 2);
            MinecraftForge.setBlockHarvestLevel(remulaOre, "pickaxe", 3);
            MinecraftForge.setBlockHarvestLevel(copperOre, "pickaxe", 1);
            MinecraftForge.setBlockHarvestLevel(tinOre, "pickaxe", 1);
            MinecraftForge.setBlockHarvestLevel(zincOre, "pickaxe", 2);
            MinecraftForge.setBlockHarvestLevel(silverOre, "pickaxe", 2);*/
            //TODO fix
            //MinecraftForge.setBlockHarvestLevel(akatoeCoal, "pickaxe", 0);
            //MinecraftForge.setBlockHarvestLevel(akatoeIron, "pickaxe", 1);
            //MinecraftForge.setBlockHarvestLevel(akatoeGold, "pickaxe", 2);
            //MinecraftForge.setBlockHarvestLevel(akatoeCopper, "pickaxe", 1);
            //MinecraftForge.setBlockHarvestLevel(akatoeTin, "pickaxe", 1);
            //MinecraftForge.setBlockHarvestLevel(akatoeLapis, "pickaxe", 2);
            MinecraftForge.setBlockHarvestLevel(akatoeStone, "pickaxe", 0);
            MinecraftForge.setBlockHarvestLevel(baloinusStone, "pickaxe", 0);
            MinecraftForge.setBlockHarvestLevel(deepSpaceBrownAsteroidRock, "pickaxe", 0);
            MinecraftForge.setBlockHarvestLevel(deepSpaceWhiteAsteroidRock, "pickaxe", 0);
            
            //Items
            //Ingots Etc
            LanguageRegistry.addName(emptyCell, "Empty Storage Cell");
            LanguageRegistry.addName(silvaniteDust, "Silvanite Dust");
            LanguageRegistry.addName(silvaniteIngot, "Silvanite Ingot");
            //LanguageRegistry.addName(silvaniteBucket, "Silvanite Bucket");
            LanguageRegistry.addName(silvaniteCell, "Silvanite Cell");
            LanguageRegistry.addName(merciliteDust, "Mercilite Dust");
            LanguageRegistry.addName(merciliteIngot, "Mercilite Ingot");
            //LanguageRegistry.addName(merciliteBucket, "Mercilite Bucket");
            LanguageRegistry.addName(merciliteCell, "Mercilite Cell");
            LanguageRegistry.addName(remulaDust, "Remula Dust");
            LanguageRegistry.addName(remulaIngot, "Remula Ingot");
            LanguageRegistry.addName(remulaCell, "RemulaCell");
            LanguageRegistry.addName(poriniteCell, "Porinite Cell");
            LanguageRegistry.addName(pilkCell, "Pilk Cell");
            LanguageRegistry.addName(akatiteCell, "Akatite Cell");
            LanguageRegistry.addName(poriniteDust, "Porinite Dust");
            LanguageRegistry.addName(pilkDust, "Pilk Dust");
            LanguageRegistry.addName(akatiteDust, "Akatite Dust");
            LanguageRegistry.addName(poriniteIngot, "Porinite Ingot");
            LanguageRegistry.addName(pilkIngot, "Pilk Ingot");
            LanguageRegistry.addName(akatiteIngot, "Akatite Ingot");
            
            //General Items            
            LanguageRegistry.addName(simpleSilvaniteChip, "Simple Silvanite Chip");
            //LanguageRegistry.addName(midSilvaniteChip, "Mid Silvanite Chip");
            LanguageRegistry.addName(advancedSilvaniteChip, "Advanced Silvanite Chip");
            LanguageRegistry.addName(simpleMerciliteChip, "Simple Mercilite Chip");
            //LanguageRegistry.addName(midMerciliteChip, "Mid Mercilite Chip");
            LanguageRegistry.addName(advancedMerciliteChip, "Advanced Mercilite Chip");
            LanguageRegistry.addName(simpleRemulaChip, "Simple Remula Chip");
            //LanguageRegistry.addName(midRemulaChip, "Mid Remula Chip");
            LanguageRegistry.addName(advancedRemulaChip, "Advanced Remula Chip");
            //LanguageRegistry.addName(remDrill, "Rem Drill");
            LanguageRegistry.addName(drillTransformerUpgrade, "Drill Transformer Upgrade");
            LanguageRegistry.addName(drillSilkTouchUpgrade, "Drill Silk Touch Upgrade");
            LanguageRegistry.addName(drillSpeedControlUpgrade, "Drill Speed Control Upgrade");
            LanguageRegistry.addName(drillBatteryUpgrade, "Drill Battery Upgrade");
            
            //Foods and Plant Stuff
            LanguageRegistry.addName(porinFruit, "Porin");
            //LanguageRegistry.addName(porinSeeds, "Porin Seeds");
            LanguageRegistry.addName(ulinFruit, "Ulin");
            //LanguageRegistry.addName(ulinSeeds, "Ulin Seeds");
            LanguageRegistry.addName(itemCir, "Cir");
            //LanguageRegistry.addName(cirSeeds, "Cir Seeds");
            LanguageRegistry.addName(itemBoskin, "Boskin");
            //LanguageRegistry.addName(boskinSeeds, "Boskin Seeds");
            LanguageRegistry.addName(rawGlogMeat, "Raw Glog");
            LanguageRegistry.addName(cookedGlogMeat, "Cooked Glog");
            LanguageRegistry.addName(skitterling, "Skitterling");
            LanguageRegistry.addName(skitterlingDead, "Skitterling (Dead)");
            LanguageRegistry.addName(rawSkitterlingStick, "Raw Skitterling (Stick)");
            LanguageRegistry.addName(cookedSkitterlingStick, "Roasted Skitterling");
            LanguageRegistry.addName(rawHermustMeat, "Raw Hermust");
            LanguageRegistry.addName(cookedHermustMeat, "Cooked Hermust");
            LanguageRegistry.addName(rawGarfinMeat, "Raw Garfin");
            LanguageRegistry.addName(cookedGarfinMeat, "Cooked Garfin");
            LanguageRegistry.addName(rawLignisMeat, "Raw Lignis");
            LanguageRegistry.addName(cookedLignisMeat, "Cooked Lignis");
            
            //Weapons and Armour
            LanguageRegistry.addName(p1Pistol, "F24 Pistol");
            LanguageRegistry.addName(p1IronBullet, "F24 Pistol Ammo");
            LanguageRegistry.addName(p1HudUnit, "Phase 1 HUD Unit");
            
            //Robot Spawners
            LanguageRegistry.addName(simpleP1RobotSpawner, "Helper Droid");
            LanguageRegistry.addName(midP1RobotSpawner, "Powerdroid 1000");
            LanguageRegistry.addName(advancedP1RobotSpawner, "Flendroid 5000");
            LanguageRegistry.addName(simpleP3RobotSpawner, "Helper Droid");
            LanguageRegistry.addName(midP3RobotSpawner, "Powerdroid 1000");
            LanguageRegistry.addName(advancedP3RobotSpawner, "Flendroid 5000");
            LanguageRegistry.addName(simpleP5RobotSpawner, "Helper Droid");
            LanguageRegistry.addName(midP5RobotSpawner, "Powerdroid 1000");
            LanguageRegistry.addName(advancedP5RobotSpawner, "Flendroid 5000");
            LanguageRegistry.addName(simpleP7RobotSpawner, "Helper Droid");
            LanguageRegistry.addName(midP7RobotSpawner, "Powerdroid 1000");
            LanguageRegistry.addName(advancedP7RobotSpawner, "Flendroid 5000");
            LanguageRegistry.addName(simpleP9RobotSpawner, "Helper Droid");
            LanguageRegistry.addName(midP9RobotSpawner, "Powerdroid 1000");
            LanguageRegistry.addName(advancedP9RobotSpawner, "Flendroid 5000");
            
            //Powergrid
            LanguageRegistry.addName(simpleBattery, "Simple Battery");
            LanguageRegistry.addName(midBattery, "Mid Battery");
            LanguageRegistry.addName(highBattery, "Advanced Battery");
            LanguageRegistry.addName(simplePRSU, "Simple PRSU");
            LanguageRegistry.addName(midPRSU, "Mid PRSU");
            LanguageRegistry.addName(advancedPRSU, "Advanced PRSU");
            
            //GameRegistry
            //Ingots Etc
            GameRegistry.registerItem(emptyCell, "emptyCell");
            GameRegistry.registerItem(silvaniteDust, "silvaniteDust");
            GameRegistry.registerItem(silvaniteIngot, "silvaniteIngot");
            //GameRegistry.registerItem(silvaniteBucket, "silvaniteBucket");
            GameRegistry.registerItem(silvaniteCell, "silvaniteCell");
            GameRegistry.registerItem(merciliteDust, "mercliteDust");
            GameRegistry.registerItem(merciliteIngot, "merciliteIngot");
            //GameRegistry.registerItem(merciliteBucket, "merciliteBucket");
            GameRegistry.registerItem(merciliteCell, "merciliteCell");
            GameRegistry.registerItem(remulaDust, "remulaDust");
            GameRegistry.registerItem(remulaIngot, "remulaIngot");
            GameRegistry.registerItem(remulaCell, "remulaCell");
            GameRegistry.registerItem(poriniteCell, "poriniteCell");
            GameRegistry.registerItem(pilkCell, "pilkCell");
            GameRegistry.registerItem(akatiteCell, "akatiteCell");
            GameRegistry.registerItem(poriniteDust, "poriniteDust");
            GameRegistry.registerItem(pilkDust, "pilkDust");
            GameRegistry.registerItem(akatiteDust, "akatiteDust");
            GameRegistry.registerItem(poriniteIngot, "poriniteIngot");
            GameRegistry.registerItem(pilkIngot, "pilkIngot");
            GameRegistry.registerItem(akatiteIngot, "akatiteIngot");
            
            GameRegistry.registerItem(simpleSilvaniteChip, "simpleSilvaniteChip");
            //GameRegistry.registerItem(midSilvaniteChip, "midSilvaniteChip");
            GameRegistry.registerItem(advancedSilvaniteChip, "advancedSilvaniteChip");
            GameRegistry.registerItem(simpleMerciliteChip, "simpleMerciliteChip");
            //GameRegistry.registerItem(midMerciliteChip, "midMerciliteChip");
            GameRegistry.registerItem(advancedMerciliteChip, "advancedMerciliteChip");
            GameRegistry.registerItem(simpleRemulaChip, "simpleRemulaChip");
            //GameRegistry.registerItem(midRemulaChip, "midRemulaChip);
            GameRegistry.registerItem(advancedRemulaChip, "advancedRemulaChip");
            //GameRegistry.registerItem(remDrill, "remDrill");
            GameRegistry.registerItem(drillTransformerUpgrade, "drillTransformerUpgrade");
            GameRegistry.registerItem(drillSilkTouchUpgrade, "drillSilkTouchUpgrade");
            GameRegistry.registerItem(drillSpeedControlUpgrade, "drillSpeedControlUpgrade");
            GameRegistry.registerItem(drillBatteryUpgrade, "drillBatteryUpgrade");
            
            //Robot Spawners
            GameRegistry.registerItem(simpleP1RobotSpawner, "simpleP1RobotSpawner");
            GameRegistry.registerItem(midP1RobotSpawner, "midP1RobotSpawner");
            GameRegistry.registerItem(advancedP1RobotSpawner, "advancedP1RobotSpawner");     
            GameRegistry.registerItem(simpleP3RobotSpawner, "simpleP3RobotSpawner");
            GameRegistry.registerItem(midP3RobotSpawner, "midP3RobotSpawner");
            GameRegistry.registerItem(advancedP3RobotSpawner, "advancedP3RobotSpawner");     
            GameRegistry.registerItem(simpleP5RobotSpawner, "simpleP5RobotSpawner");
            GameRegistry.registerItem(midP5RobotSpawner, "midP5RobotSpawner");
            GameRegistry.registerItem(advancedP5RobotSpawner, "advancedP5RobotSpawner");     
            GameRegistry.registerItem(simpleP7RobotSpawner, "simpleP7RobotSpawner");
            GameRegistry.registerItem(midP7RobotSpawner, "midP7RobotSpawner");
            GameRegistry.registerItem(advancedP7RobotSpawner, "advancedP7RobotSpawner");     
            GameRegistry.registerItem(simpleP9RobotSpawner, "simpleP9RobotSpawner");
            GameRegistry.registerItem(midP9RobotSpawner, "midP9RobotSpawner");
            GameRegistry.registerItem(advancedP9RobotSpawner, "advancedP9RobotSpawner");     
            
            //Food and Plant Stuff
            GameRegistry.registerItem(porinFruit, "porinFruit");
            //GameRegistry.registerItem(porinSeeds, "porinSeeds");
            GameRegistry.registerItem(ulinFruit, "ulinFruit");
            //GameRegistry.registerItem(ulinSeeds, "ulinSeeds");
            GameRegistry.registerItem(itemCir, "itemCir");
            //GameRegistry.registerItem(cirSeeds, "cirSeeds");
            GameRegistry.registerItem(itemBoskin, "itemBoskin");
            //GameRegistry.registerItem(boskinSeeds, "boskinSeeds");
            GameRegistry.registerItem(rawGlogMeat, "rawGlogMeat");
            GameRegistry.registerItem(cookedGlogMeat, "cookedGlogMeat");
            GameRegistry.registerItem(skitterling, "skitterling");
            GameRegistry.registerItem(skitterlingDead, "skitterlingDead");
            GameRegistry.registerItem(rawSkitterlingStick, "rawSkitterlingStick");
            GameRegistry.registerItem(cookedSkitterlingStick, "cookedSkitterlingStick");
            GameRegistry.registerItem(rawHermustMeat, "rawHermustMeat");
            GameRegistry.registerItem(cookedHermustMeat, "cookedHermustMeat");
            GameRegistry.registerItem(rawGarfinMeat, "rawGarfinMeat");
            GameRegistry.registerItem(cookedGarfinMeat, "cookedGarfinMeat");
            GameRegistry.registerItem(rawLignisMeat, "rawLignisMeat");
            GameRegistry.registerItem(cookedLignisMeat, "cookedLignisMeat");
            
            //Weapons and Armour
            GameRegistry.registerItem(p1Pistol, "p1Pistol");
            GameRegistry.registerItem(p1IronBullet, "p1IronBullet");
            GameRegistry.registerItem(p1HudUnit, "p1HudUnit");
            
            //Power Grid
            GameRegistry.registerItem(simpleBattery, "simpleBattery");
            GameRegistry.registerItem(midBattery, "medBattery");
            GameRegistry.registerItem(highBattery, "highBattery");
            GameRegistry.registerItem(simplePRSU, "simplePRSU");
            GameRegistry.registerItem(midPRSU, "midPRSU");
            GameRegistry.registerItem(advancedPRSU, "advancedPRSU");
            
            
            //Tile Entities
            GameRegistry.registerTileEntity(TileEntityTecmoniumChest.class, "tileEntitySilvaniteChest");
            GameRegistry.registerTileEntity(TileEntityMerciliteChest.class, "tileEntityMerciliteChest");
            GameRegistry.registerTileEntity(TileEntitySilvaniteChest.class, "tileEntityRemulaChest");
            GameRegistry.registerTileEntity(TileEntityLITable.class, "tileEntityLITable");
            
            //Other Registry Stuff
            LanguageRegistry.instance().addStringLocalization("itemGroup.tabRemula", "en_US", "Remula");
            LanguageRegistry.instance().addStringLocalization("itemGroup.tabMinerals", "en_US", "Minerals");
            LanguageRegistry.instance().addStringLocalization("itemGroup.tabMachines", "en_US", "Machines");
            LanguageRegistry.instance().addStringLocalization("itemGroup.tabWorlds", "en_US", "Worlds");
            LanguageRegistry.instance().addStringLocalization("itemGroup.tabEquip", "en_US", "Equipment");
            LanguageRegistry.instance().addStringLocalization("itemGroup.tabMisc", "en_US", "Misc");
            
            GameRegistry.registerWorldGenerator(new WorldGenAkatoeTrees(false));
            GameRegistry.registerWorldGenerator(new WorldGen());
            NetworkRegistry.instance().registerGuiHandler(this, new GuiHandler());
            GameRegistry.removeBiome(akatoePlainsBiome);
            GameRegistry.removeBiome(akatoeDesertBiome);
            GameRegistry.removeBiome(akatoeOceanBiome);
            GameRegistry.removeBiome(baloinusPlainsBiome);
            GameRegistry.removeBiome(elkostDesertBiome);
            GameRegistry.removeBiome(indikuJungleBiome);
            GameRegistry.removeBiome(xylexiaPlainsBiome);
            
            DimensionManager.registerProviderType(akatoeDimension, AkatoeWorldProvider.class, false);
            DimensionManager.registerProviderType(baloinusDimension, BaloinusWorldProvider.class, false);
            DimensionManager.registerProviderType(deepSpaceDimension, DeepSpaceWorldProvider.class, false);
            DimensionManager.registerProviderType(indikuDimension, IndikuWorldProvider.class, false);
            DimensionManager.registerProviderType(elkostDimension, ElkostWorldProvider.class, false);
            DimensionManager.registerProviderType(xylexiaDimension, XylexiaWorldProvider.class, false);
            
            DimensionManager.registerDimension(akatoeDimension, akatoeDimension);
            DimensionManager.registerDimension(baloinusDimension, baloinusDimension);
            DimensionManager.registerDimension(deepSpaceDimension, deepSpaceDimension);
            DimensionManager.registerDimension(indikuDimension, indikuDimension);
            DimensionManager.registerDimension(elkostDimension, elkostDimension);
            DimensionManager.registerDimension(xylexiaDimension, xylexiaDimension);
            
            //Entites
            //TODO Fix EntityRegistry.registerModEntity(EntityAkatonian.class, "Akatonian", 1, this, 80, 3, true);
            EntityRegistry.registerModEntity(EntityGlog.class, "Glog", 2, this, 80, 3, true);
            EntityRegistry.registerModEntity(EntityAdvRobot.class, "AdvancedRobot", 3, this, 80, 3, true);
            EntityRegistry.registerModEntity(EntityXylexian.class, "Xylexian", 4, this, 80, 3, true);
            EntityRegistry.registerModEntity(EntitySkitterling.class, "Skitterling", 5, this, 80, 3, true);
            EntityRegistry.registerModEntity(EntityHermust.class, "Hermust", 5, this, 80, 3, true);
            EntityRegistry.registerModEntity(EntityGarfin.class, "Garfin", 6, this, 80, 3, true);
            EntityRegistry.registerModEntity(EntityLignis.class, "Lignis", 7, this, 80, 3, true);
            
            EntityRegistry.addSpawn(EntityGlog.class, 5, 2, 6, EnumCreatureType.creature, Remula.akatoePlainsBiome);
            EntityRegistry.addSpawn(EntitySkitterling.class, 5, 6, 10, EnumCreatureType.monster, Remula.akatoePlainsBiome, Remula.akatoeDesertBiome);
            EntityRegistry.addSpawn(EntityHermust.class, 5, 2, 4, EnumCreatureType.creature, Remula.akatoePlainsBiome, Remula.akatoeDesertBiome);
            EntityRegistry.addSpawn(EntityGarfin.class, 5, 3, 7, EnumCreatureType.waterCreature, Remula.akatoePlainsBiome, Remula.akatoeOceanBiome);
            EntityRegistry.addSpawn(EntityLignis.class, 5, 1, 2, EnumCreatureType.creature, Remula.akatoePlainsBiome, Remula.akatoeDesertBiome, Remula.akatoeOceanBiome);
            EntityRegistry.addSpawn(EntityXylexian.class, 5, 1, 1, EnumCreatureType.monster, Remula.xylexiaPlainsBiome);
            
            LanguageRegistry.instance().addStringLocalization("entity.instance.Akatonian.name", "Akatonian");
            LanguageRegistry.instance().addStringLocalization("entity.instance.Glog.name", "Glog");
            LanguageRegistry.instance().addStringLocalization("entity.instance.AdvancedRobot.name", "Flendroid 5000");
            LanguageRegistry.instance().addStringLocalization("entity.instance.Xylexian.name", "Xylexian");
            LanguageRegistry.instance().addStringLocalization("entity.instance.Skitterling.name", "Skitterling");
            LanguageRegistry.instance().addStringLocalization("entity.instance.Hermust.name", "Hermust");
            LanguageRegistry.instance().addStringLocalization("entity.instance.Garfin.name", "Garfin");
            LanguageRegistry.instance().addStringLocalization("entity.instance.Lignis.name", "Lignis");
                        
            MinecraftForge.EVENT_BUS.register(new AkatoeBonemealEventClass());
            
            //CRAFTING!
            
            //Ingots
            //ItemStack copperOreStack = new ItemStack(Remula.copperOre);
            //ItemStack tinOreStack = new ItemStack(Remula.tinOre);
            
    }


	@EventHandler
    public void postInit(FMLPostInitializationEvent event) {
    		}
	}
