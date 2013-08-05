package co.uk.silvania.Remula;

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
import co.uk.silvania.Remula.blocks.shipparts.TileEntityShipComputerBlock;
import co.uk.silvania.Remula.dimensions.akatoe.AkatoePortalBlock;
import co.uk.silvania.Remula.dimensions.baloinus.BaloinusPortalBlock;
import co.uk.silvania.Remula.dimensions.deepspace.DeepSpaceBrownAsteroid;
import co.uk.silvania.Remula.dimensions.deepspace.DeepSpaceBrownOreBlocks;
import co.uk.silvania.Remula.dimensions.deepspace.DeepSpacePortalBlock;
import co.uk.silvania.Remula.dimensions.deepspace.DeepSpaceTerrainBlocks;
import co.uk.silvania.Remula.dimensions.deepspace.DeepSpaceWhiteAsteroid;
import co.uk.silvania.Remula.dimensions.deepspace.DeepSpaceWhiteOreBlocks;
import co.uk.silvania.Remula.dimensions.elkost.ElkostPortalBlock;
import co.uk.silvania.Remula.dimensions.indiku.IndikuPortalBlock;
import co.uk.silvania.Remula.dimensions.xylexia.XylexiaPortalBlock;
import co.uk.silvania.Remula.tileentity.block.MerciliteChest;
import co.uk.silvania.Remula.tileentity.block.SilvaniteChest;
import co.uk.silvania.Remula.tileentity.block.TecmoniumChest;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class RemulaBlocks {
	
	private static RemulaConfig config;
	
    public static Block p1CraftingTable;
    public static Block shipComputer;
    
	public static Block p1Liquidizer;
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
    
    public static Block tecmoniumChest;
    public static Block merciliteChest;
    public static Block silvaniteChest;
    public static Block rubberLog;
    public static Block rubberSapling;
    public static Block rubberLeaves;
    public static Block earthOreBlocks;
    
	
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

    public static Block akatoeStone;
    public static Block akatoeGrass;
    public static Block akatoeSand;
    public static Block akatoeDirt;
    public static Block akatoeLogs;
    public static Block akatoeLeaves;
    public static Block akatoeSaplings;
    
    public static Block akatoeTerrainBlocks;
    public static Block akatoeOreBlocks;
    public static Block akatoePortal;
    public static Block akatoeTilledDirt;
    
    //public static Block porinCrop;
    //public static Block ulinCrop;
    //public static Block cirCrop;
    //public static Block boskinCrop;
	public static Block plantFuxii;
    
    public static Block baloinusTerrainBlocks;
    public static Block baloinusOreBlocks;
    public static Block baloinusPortal;
    public static Block baloinusStone;

    
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
    
    public static Block indikuPortal;
    public static Block indikuTerrainBlocks;
    public static Block indikuOreBlocks;
    public static Block indikuStone;
    public static Block indikuDirt;
    public static Block indikuGrass;
    public static Block indikuTilledDirt;
    
    public static Block indikuLogs1;
    public static Block indikuLogs2;
    public static Block indikuLeaves1;
    public static Block indikuLeaves2;
    public static Block indikuSaplings1;
    public static Block indikuSaplings2;
    
    
    
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
    
    public static Block elkostPortal;
    public static Block elkostTerrainBlocks;
    public static Block elkostOreBlocks;
    public static Block elkostSand;
    public static Block elkostGlassPane;
    
    
    
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
    
    public static Block xylexiaPortal;
    public static Block xylexiaTerrainBlocks;
    public static Block xylexiaOreBlocks;
    public static Block xylexiaStone;
    public static Block xylexiaSand;
    public static Block xylexiaGlassPane;

    
    
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
    
    
    
    public static Block deepSpacePortal;
    public static Block deepSpaceTerrainBlocks;
    public static Block deepSpaceBrownOreBlocks;
    public static Block deepSpaceWhiteOreBlocks;
    //public static Block deepSpaceExtraOreBlocks;
    
    public static Block deepSpaceBrownAsteroidRock;
    public static Block deepSpaceWhiteAsteroidRock;
	
	
	public static void init() {
		initGeneralBlocks();
		initEarthBlocks();
		initAkatoeBlocks();
		initBaloinusBlocks();
		initIndikuBlocks();
		initElkostBlocks();
		initXylexiaBlocks();
		initDeepSpaceBlocks();
	}
	
	private static void initGeneralBlocks() {
		p1CraftingTable = new P1CraftingTable(config.p1CraftingTableID).setUnlocalizedName("p1CraftingTable");
		shipComputer = new TileEntityShipComputerBlock(config.shipComputerID).setUnlocalizedName("shipComputer");
        //Liquids: Silvanite, Mercilite, Remula, Redstone, Lapis, Porinite, Pilk, Tritanite, Ventiium, Athirium, Zirinium, Boria, Tristinium, Grinist, Heri, Skatha, Kzori 
        // + 12 more, + any planitary unique liquids
	}
	
	private static void initEarthBlocks() {
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
        
    	rubberLog = new RubberLog(config.rubberLogID).setUnlocalizedName("rubberLog");
    	rubberSapling = new RubberSapling(config.rubberSaplingID).setUnlocalizedName("rubberSapling");
    	rubberLeaves = new RubberLeaves(config.rubberLeavesID).setUnlocalizedName("rubberLeaves");
	    tecmoniumChest = new TecmoniumChest(config.tecmoniumChestID).setUnlocalizedName("tecmoniumChest");
	    merciliteChest = new MerciliteChest(config.merciliteChestID).setUnlocalizedName("merciliteChest");
	    silvaniteChest = new SilvaniteChest(config.silvaniteChestID).setUnlocalizedName("silvaniteChest");
    	
    	earthOreBlocks = new EarthOreBlocks(config.earthOreBlocksID).setUnlocalizedName("earthOreBlocks");
	}
	
	private static void initAkatoeBlocks() {
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
        
        akatoeStone = new AkatoeStone(config.akatoeStoneID).setUnlocalizedName("akatoeStone");
        akatoeGrass = new AkatoeGrass(config.akatoeGrassID).setUnlocalizedName("akatoeGrass");
        akatoeDirt = new AkatoeDirt(config.akatoeDirtID).setUnlocalizedName("akatoeDirt");
        akatoeSand = new AkatoeSand(config.akatoeSandID).setUnlocalizedName("akatoeSand");
        akatoeLogs = new AkatoeLogs(config.akatoeLogsID).setUnlocalizedName("akatoeLogs");
        akatoeLeaves = new AkatoeLeaves(config.akatoeLeavesID).setUnlocalizedName("akatoeLeaves");
        akatoeSaplings = new AkatoeSaplings(config.akatoeSaplingsID, 0).setUnlocalizedName("akatoeSaplings");
        akatoeTilledDirt = new AkatoeTilledDirt(config.akatoeTilledDirtID).setUnlocalizedName("akatoeTilledDirt");
        
        akatoeTerrainBlocks = new AkatoeTerrainBlocks(config.akatoeTerrainBlocksID).setUnlocalizedName("akatoeTerrainBlocks");
        akatoeOreBlocks = new AkatoeOreBlocks(config.akatoeOreBlocksID).setUnlocalizedName("akatoeOreBlocks");
        akatoePortal = new AkatoePortalBlock(config.akatoePortalID).setUnlocalizedName("akatoePortal");
        
        //porinCrop = new PorinCrop(1920).setUnlocalizedName("porinCrop");
        //ulinCrop = new UlinCrop(1921).setUnlocalizedName("ulinCrop");
        //cirCrop = new CirCrop(1922).setUnlocalizedName("cirCrop");
        //boskinCrop = new BoskinCrop(1923).setUnlocalizedName("boskinCrop");
    	plantFuxii = new PlantFuxii(config.plantFuxiiID).setUnlocalizedName("plantFuxii");
	}
	
	private static void initBaloinusBlocks() {
        baloinusPortal = new BaloinusPortalBlock(config.baloinusPortalID).setUnlocalizedName("baloinusPortal");
        baloinusTerrainBlocks = new BaloinusTerrainBlocks(config.baloinusTerrainBlocksID, Material.rock).setUnlocalizedName("baloinusTerrainBlocks");
        baloinusOreBlocks = new BaloinusOreBlocks(config.baloinusOreBlocksID).setUnlocalizedName("baloinusOreBlocks");
        
        baloinusStone = new BaloinusStone(config.baloinusStoneID);
	}
	
	private static void initIndikuBlocks() {
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
        
        indikuPortal = new IndikuPortalBlock(config.indikuPortalID).setUnlocalizedName("indikuPortal");
        indikuTerrainBlocks = new IndikuTerrainBlocks(config.indikuTerrainBlocksID).setUnlocalizedName("indikuTerrainBlocks");
        indikuOreBlocks = new IndikuOreBlocks(config.indikuOreBlocksID).setUnlocalizedName("indikuOreBlocks");
        indikuStone = new IndikuStone(config.indikuStoneID).setUnlocalizedName("indikuStone");
        indikuDirt = new IndikuDirt(config.indikuDirtID).setUnlocalizedName("indikuDirt");
        indikuGrass = new IndikuGrass(config.indikuGrassID).setUnlocalizedName("indikuGrass");
        indikuTilledDirt = new IndikuTilledDirt(config.indikuTilledDirtID).setUnlocalizedName("indikuTilledDirt");
        
        indikuLogs1 = new IndikuLogs1(config.indikuLogs1ID).setUnlocalizedName("indikuLogs1");
        indikuLogs2 = new IndikuLogs2(config.indikuLogs2ID).setUnlocalizedName("indikuLogs2");
        indikuLeaves1 = new IndikuLeaves1(config.indikuLeaves1ID).setUnlocalizedName("indikuLeaves1");
        indikuLeaves2 = new IndikuLeaves2(config.indikuLeaves2ID).setUnlocalizedName("indikuLeaves2");
        indikuSaplings1 = new IndikuSaplings1(config.indikuSaplings1ID, 0).setUnlocalizedName("indikuSaplings1");
        indikuSaplings2 = new IndikuSaplings2(config.indikuSaplings2ID, 0).setUnlocalizedName("indikuSaplings2");
        //TODO - 8 crops, 16 plants
   	}
	
	private static void initElkostBlocks() {
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
        
        elkostPortal = new ElkostPortalBlock(config.elkostPortalID).setUnlocalizedName("elkostPortal");
        elkostTerrainBlocks = new ElkostTerrainBlocks(config.elkostTerrainBlocksID).setUnlocalizedName("elkostTerrainBlocks");
        elkostOreBlocks = new ElkostOreBlocks(config.elkostOreBlocksID).setUnlocalizedName("elkostOreBlocks");
        elkostSand = new ElkostSand(config.elkostSandID).setUnlocalizedName("elkostSand");
        elkostGlassPane = new ElkostGlassPane(config.elkostGlassPaneID, Material.glass).setUnlocalizedName("elkostGlassPane");
	}

	private static void initXylexiaBlocks() {
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
        
        xylexiaPortal = new XylexiaPortalBlock(config.xylexiaPortalID).setUnlocalizedName("xylexiaPortal");
        xylexiaTerrainBlocks = new XylexiaTerrainBlocks(config.xylexiaTerrainBlocksID).setUnlocalizedName("xylexiaTerrainBlocks");
        xylexiaOreBlocks = new XylexiaOreBlocks(config.xylexiaOreBlocksID).setUnlocalizedName("xylexiaOreBlocks");
        xylexiaStone = new XylexianStone(config.xylexiaStoneID).setUnlocalizedName("xylexianStone");
        xylexiaSand = new XylexianSand(config.xylexiaSandID).setUnlocalizedName("xylexianSand");
        xylexiaGlassPane = new XylexianGlassPane(config.xylexiaGlassPaneID, Material.glass).setUnlocalizedName("xylexianGlassPane");
	}
	
	private static void initPhase6Blocks() {
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
	}
	
	private static void initPhase7Blocks() {
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
	}
	
	private static void initPhase8Blocks() {
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
	}
	
	private static void initPhase9Blocks() {
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
	}
	
	private static void initDeepSpaceBlocks() {
		deepSpacePortal = new DeepSpacePortalBlock(config.deepSpacePortalID).setUnlocalizedName("deepSpacePortal");
		deepSpaceTerrainBlocks = new DeepSpaceTerrainBlocks(config.deepSpaceTerrainBlocksID, Material.rock).setUnlocalizedName("deepSpaceTerrainBlocks");
        deepSpaceBrownOreBlocks = new DeepSpaceBrownOreBlocks(config.deepSpaceBrownOreBlocksID).setUnlocalizedName("deepSpaceBrownOreBlocks");
        deepSpaceWhiteOreBlocks = new DeepSpaceWhiteOreBlocks(config.deepSpaceWhiteOreBlocksID).setUnlocalizedName("deepSpaceWhiteOreBlocks");
        //public final static Block deepSpaceExtraOreBlocks = new DeepSpaceExtraOreBlocks(1933).setUnlocalizedName("deepSpaceExtraOreBlocks");
        
        deepSpaceBrownAsteroidRock = new DeepSpaceBrownAsteroid(config.deepSpaceBrownAsteroidRockID).setUnlocalizedName("deepSpaceAsteroidRock");
        deepSpaceWhiteAsteroidRock = new DeepSpaceWhiteAsteroid(config.deepSpaceWhiteAsteroidRockID).setUnlocalizedName("deepSpaceMeteoriteRock");
	}
}
