package co.uk.silvania.Remula;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
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
import co.uk.silvania.Remula.client.ClientProxy;
import co.uk.silvania.Remula.dimensions.*;
import co.uk.silvania.Remula.dimensions.akatoe.*;
import co.uk.silvania.Remula.dimensions.akatoe.blocks.*;
import co.uk.silvania.Remula.dimensions.akatoe.items.*;
import co.uk.silvania.Remula.dimensions.akatoe.ores.*;
import co.uk.silvania.Remula.dimensions.baloinus.*;
import co.uk.silvania.Remula.dimensions.deepspace.*;
import co.uk.silvania.Remula.dimensions.elkost.*;
import co.uk.silvania.Remula.dimensions.elkost.blocks.*;
import co.uk.silvania.Remula.dimensions.indiku.*;
import co.uk.silvania.Remula.dimensions.indiku.blocks.*;
import co.uk.silvania.Remula.dimensions.xylexia.*;
import co.uk.silvania.Remula.dimensions.xylexia.blocks.*;
import co.uk.silvania.Remula.entity.EntityAdvRobot;
import co.uk.silvania.Remula.entity.akatoe.EntityAkatonian;
import co.uk.silvania.Remula.entity.akatoe.EntityGarfin;
import co.uk.silvania.Remula.entity.akatoe.EntityGlog;
import co.uk.silvania.Remula.entity.akatoe.EntityHermust;
import co.uk.silvania.Remula.entity.akatoe.EntityLignis;
import co.uk.silvania.Remula.entity.akatoe.EntitySkitterling;
import co.uk.silvania.Remula.entity.baloinus.EntityXylexian;
import co.uk.silvania.Remula.items.*;
import co.uk.silvania.Remula.items.armor.P1HUDUnit;
//import co.uk.silvania.Remula.items.util.P1SpaceSuit;
import co.uk.silvania.Remula.items.weapons.ItemPistol;
import co.uk.silvania.Remula.network.PacketHandler;
import co.uk.silvania.Remula.powergrid.blocks.*;
import co.uk.silvania.Remula.powergrid.items.*;
import co.uk.silvania.Remula.tileentity.*;
import cpw.mods.fml.common.Mod;
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
	public static CreativeTabs tabAkatoe = new CreativeTabs("tabAkatoe") {
		public ItemStack getIconItemStack() {
			return new ItemStack(Block.cobblestone, 1, 0);
		}
	};
	public static CreativeTabs tabBaloinus = new CreativeTabs("tabBaloinus") {
		public ItemStack getIconItemStack() {
			return new ItemStack(Block.dirt, 1, 0);
		}
	};
	public static CreativeTabs tabDeepSpace = new CreativeTabs("tabDeepSpace") {
		public ItemStack getIconItemSTack() {
			return new ItemStack(Block.grass, 1, 0);
		}
	};
	public static CreativeTabs tabIndiku = new CreativeTabs("tabIndiku") {
		public ItemStack getIconItemSTack() {
			return new ItemStack(Block.sand, 1, 0);
		}
	};
	public static CreativeTabs tabElkost = new CreativeTabs("tabElkost") {
		public ItemStack getIconItemSTack() {
			return new ItemStack(Block.bed, 1, 0);
		}
	};
	public static CreativeTabs tabXylexia = new CreativeTabs("tabXylexia") {
		public ItemStack getIconItemSTack() {
			return new ItemStack(Block.blockClay, 1, 0);
		}
	};
	
    @Instance("Remula")
    public static Remula instance;
    public static GuiHandler remulaGuiHandler = new GuiHandler();

    // Says where the client and server proxy code is loaded.
    @SidedProxy(clientSide="co.uk.silvania.Remula.client.ClientProxy", serverSide="co.uk.silvania.Remula.CommonProxy")
    public static CommonProxy proxy;
    /*public static int akatoeDimension = 20;
    public static int baloinusDimension = 21;
    public static int deepSpaceDimension = 22;
    public static int indikuDimension = 23;
    public static int elkostDimension = 24;
    public static int xylexiaDimension = 25;
    
    //public static int blockRemulaID;
    @SideOnly(Side.CLIENT)*/

    @PreInit
    public void preInit(FMLPreInitializationEvent event) {
    	NetworkRegistry.instance().registerGuiHandler(this, remulaGuiHandler);
    }/*
	public static WorldGen worldGen = new WorldGen();
	public static EnumArmorMaterial SpaceSuit1 = EnumHelper.addArmorMaterial("SpaceSuit1", 15, new int[]{1, 1, 1, 1}, 0);
	
    //Blocks (IDs 1800-2000 to avoid clash with top 100 mods)
    public final static Block silvaniteOre = new SilvaniteOre(1800).setUnlocalizedName("silvaniteOre");
    public final static Block merciliteOre = new MerciliteOre(1801).setUnlocalizedName("merciliteOre");
    public final static Block remulaOre = new RemulaOre(1802).setUnlocalizedName("remulaOre");
    public final static Block copperOre = new CopperOre(1803).setUnlocalizedName("copperOre");
    public final static Block tinOre = new TinOre(1804).setUnlocalizedName("tinOre");
    public final static Block zincOre = new ZincOre(1805).setUnlocalizedName("zincOre");
    public final static Block silverOre = new SilverOre(1806).setUnlocalizedName("silverOre");
    public final static Block rubberLog = new RubberLog(1807, Material.wood).setUnlocalizedName("rubberLog");
    public final static Block rubberSapling = new RubberSapling(1808).setUnlocalizedName("rubberSapling");
    public final static Block rubberLeaves = new RubberLeaves(1809).setUnlocalizedName("rubberLeaves");
    public final static Block remulaLiquidizer = new RemulaLiquidizer(1810, Material.iron).setUnlocalizedName("remulaLiquidizer");
    public final static Block remulaCraftingTable = new RemulaCraftingTable(1811).setUnlocalizedName("remulaCraftingTable");
    public final static Block remulaBasicStorageUnit = new RemulaBasicStorageUnit(1812, Material.iron).setUnlocalizedName("remulaStorageUnit");
    public final static Block remulaSimpleStorageUnit = new RemulaSimpleStorageUnit(1813, Material.iron).setUnlocalizedName("remulaSimpleStorageUnit");
    //public final static Block remulaMidStorageUnit = new RemulaMidStorageUnit(1814, Material.iron).setUnlocalizedName("remulaMidStorageUnit");
    public final static Block remulaHighStorageUnit = new RemulaHighStorageUnit(1815, Material.iron).setUnlocalizedName("remulaHighStorageUnit");
    public final static Block remulaExcessiveStorageUnit = new RemulaExcessiveStorageUnit(1816, Material.iron).setUnlocalizedName("remulaExcessiveStorageUnit");
    public final static Block remulaExperimentalStorageUnit = new RemulaExperimentalStorageUnit(1817, Material.iron).setUnlocalizedName("remulaExperimentalStorageUnit");
    public final static Block remulaGenerator = new RemulaSimpleGenerator(1818, Material.iron).setUnlocalizedName("remulaSimpleGenerator");
    public final static Block remulaSolarPanel = new RemulaSolarPanel(1821, Material.iron).setUnlocalizedName("remulaSolarPanel");
    public final static Block remulaThermalGenerator = new RemulaThermalGenerator(1824, Material.iron).setUnlocalizedName("remulaThermalGenerator");
    public final static Block remulaGrinder = new RemulaGrinder(1825, Material.iron).setUnlocalizedName("remulaGrinder");
    public final static Block remulaReactorCore = new RemulaReactorCore(1826, Material.iron).setUnlocalizedName("remulaReactorCore");
    //Reactor Part 1827
    //Reactor Part 1828
    //Reactor Part 1829
    //Reactor Part 1830
    public final static Block silvaniteChest = new SilvaniteChest(1850).setUnlocalizedName("silvaniteChest");
    public final static Block merciliteChest = new MerciliteChest(1851).setUnlocalizedName("merciliteChest");
    public final static Block remulaChest = new RemulaChest(1852).setUnlocalizedName("remulaChest");
    
    //Akatoe WGEN stuff
    public final static Block akatoeStone = new AkatoeStone(200, 0, Material.rock).setUnlocalizedName("akatoeStone");
    public final static Block akatoeGrass = new AkatoeGrass(201).setUnlocalizedName("akatoeGrass");
    public final static Block akatoeDirt = new AkatoeDirt(202, 2, Material.ground).setUnlocalizedName("akatoeGround");
    public final static Block akatoeSand = new AkatoeSand(203, 47, Material.sand).setUnlocalizedName("akatoeSand");
    
    //Baloinus WGEN stuff
    public final static Block baloinusStone = new BaloinusStone(205, 0, Material.rock);
    
    //Indiku WGEN stuff
    public final static Block indikuStone = new IndikuStone(206, 0, Material.rock).setUnlocalizedName("indikuStone");
    public final static Block indikuDirt = new IndikuDirt(207, 1, Material.ground).setUnlocalizedName("indikuDirt");
    public final static Block indikuGrass = new IndikuGrass(208).setUnlocalizedName("indikuGrass");
    
    //Elkost WGEN stuff
    public final static Block elkostSand = new ElkostSand(209, 0, Material.sand).setUnlocalizedName("elkostSand");
    
    //Xylexia WGEN stuff
    public final static Block xylexianStone = new XylexianStone(210, 0, Material.rock).setUnlocalizedName("xylexianStone");
    
    //Deep Space WGEN stuff
    public final static Block deepSpaceBrownAsteroidRock = new DeepSpaceBrownAsteroidRock(220, 0, Material.rock).setUnlocalizedName("deepSpaceAsteroidRock");
    public final static Block deepSpaceWhiteAsteroidRock = new DeepSpaceWhiteAsteroidRock(221, 16, Material.rock).setUnlocalizedName("deepSpaceMeteoriteRock");
    
    //Rest of Akatoe blocks
    public final static Block akatoePortal = new AkatoePortalBlock(1900).setUnlocalizedName("akatoePortal");
    public final static Block akatoeTilledDirt = new AkatoeTilledDirt(1901).setUnlocalizedName("akatoeTilledDirt");
    public final static Block porinCrop = new PorinCrop(1920).setUnlocalizedName("porinCrop");
    public final static Block ulinCrop = new UlinCrop(1921).setUnlocalizedName("ulinCrop");
    public final static Block cirCrop = new CirCrop(1922).setUnlocalizedName("cirCrop");
    public final static Block boskinCrop = new BoskinCrop(1923).setUnlocalizedName("boskinCrop");
	public final static Block plantFuxii = new PlantFuxii(1924, 56).setUnlocalizedName("plantFuxii");
	//Tree
	//Leaves*/
	
    public final static Block akatoeTerrainBlocks = new AkatoeTerrainBlocks(1940, Material.rock).setUnlocalizedName("akatoeTerrainBlocks");
    public final static Block akatoeOreBlocks = new AkatoeOreBlocks(1941).setUnlocalizedName("akatoeOreBlocks");
    
    //public final static Block baloinusPortal = new BaloinusPortalBlock(1950, 255).setUnlocalizedName("baloinusPortal");
    public final static Block baloinusTerrainBlocks = new BaloinusTerrainBlocks(1950, Material.rock).setUnlocalizedName("baloinusTerrainBlocks");
    public final static Block baloinusOreBlocks = new BaloinusOreBlocks(1951).setUnlocalizedName("baloinusOreBlocks");
    
    public final static Block indikuTerrainBlocks = new IndikuTerrainBlocks(1942, Material.rock).setUnlocalizedName("indikuTerrainBlocks");
    public final static Block indikuOreBlocks = new IndikuOreBlocks(1943).setUnlocalizedName("indikuOreBlocks");
    
    public final static Block elkostTerrainBlocks = new ElkostTerrainBlocks(1944, Material.rock).setUnlocalizedName("elkostTerrainBlocks");
    public final static Block elkostOreBlocks = new ElkostOreBlocks(1945).setUnlocalizedName("elkostOreBlocks");
    
    public final static Block xylexiaTerrainBlocks = new XylexiaTerrainBlocks(1946, Material.rock).setUnlocalizedName("xylexiaTerrainBlocks");
    public final static Block xylexiaOreBlocks = new XylexiaOreBlocks(1947).setUnlocalizedName("xylexiaOreBlocks");
    
    public final static Block deepSpaceTerrainBlocks = new DeepSpaceTerrainBlocks(1955, Material.rock).setUnlocalizedName("deepSpaceTerrainBlocks");
    public final static Block deepSpaceBrownOreBlocks = new DeepSpaceBrownOreBlocks(1956).setUnlocalizedName("deepSpaceBrownOreBlocks");
    public final static Block deepSpaceWhiteOreBlocks = new DeepSpaceWhiteOreBlocks(1957).setUnlocalizedName("deepSpaceWhiteOreBlocks");
    //public final static Block deepSpaceExtraOreBlocks = new DeepSpaceExtraOreBlocks(1958).setUnlocalizedName("deepSpaceExtraOreBlocks");
    

    
    //Rest of Indiku Blocks
    //Trees Multiblock
    //Leaves Multiblock
    //Crop 1
    //Crop 2
    //Crop 3
    //Crop 4
    //Crop 5
    //Crop 6
    //Crop 7
    //Crop 8
    //Plant 1
    //Plant 2
    //Plant 3
    //Plant 4
    //Plant 5
    //Plant 6
    //Plant 7
    //Plant 8
    //Plant 9
    //Plant 10
    //Plant 11
    //Plant 12
    //Plant 13
    //Plant 14
    //Plant 15
    //Plant 16
    /*public final static Block indikuPortalBlock = new IndikuPortalBlock(2024, 255).setUnlocalizedName("indikuPortalBlock");
    
    
    //Rest of Elkost Blocks
    public final static Block elkostGlassPane = new ElkostGlassPane(2044, 22, Material.glass).setUnlocalizedName("elkostGlassPane");
    public final static Block elkostPortalBlock = new ElkostPortalBlock(2074, 255).setUnlocalizedName("elkostPotalBlock");
    
    //Rest of Xylexia Blocks
    public final static Block xylexianSand = new XylexianSand(2075, 4, Material.sand).setUnlocalizedName("xylexianSand");
    public final static Block xylexianGlassPane = new XylexianGlassPane(2095, 23, Material.glass).setUnlocalizedName("xylexianGlassPane");
    public final static Block xylexianPortalBlock = new XylexiaPortalBlock(2124, 255).setUnlocalizedName("xylexianPortalBlock");
    
    
    /*Liquids:
    Silvanite
    Mercilite
    Remula
    Redstone
    Lapis
    Porinite
    Pilk
    Tritanite
    Ventiium
    Athirium
    Zirinium
    Boria
    Tristinium
    Grinist
    Heri
    Skatha
    Kzori
    -
    -
    -
    -
    -
    -
    -
    -
    -
    -
    -
    -
    */
       
    //Items (IDs 17000 - 17300)
    /*public final static Item emptyCell = new EmptyCell(17000).setUnlocalizedName("emptyCell");
	public final static Item silvaniteDust = new SilvaniteDust(17001).setUnlocalizedName("silvaniteDust");
	public final static Item silvaniteIngot = new SilvaniteIngot(17002).setUnlocalizedName("silvaniteIngot");
	//public final static Item silvaniteBucket = new SilvaniteBucket(17003).setUnlocalizedName("silvaniteBucket");
	public final static Item silvaniteCell = new SilvaniteCell(17004).setUnlocalizedName("silvaniteCell");
	public final static Item merciliteDust = new MerciliteDust(17005).setUnlocalizedName("merciliteDust");
	public final static Item merciliteIngot = new MerciliteIngot(17006).setUnlocalizedName("merciliteIngot");
	//public final static Item merciliteBucket = new MerciliteBucket(17007).setUnlocalizedName("merciliteBucket");
	public final static Item merciliteCell = new MerciliteCell(17008).setUnlocalizedName("merciliteCell");
	public final static Item remulaDust = new RemulaDust(17009).setUnlocalizedName("remulaDust");
	public final static Item remulaIngot = new RemulaIngot(17010).setUnlocalizedName("remulaIngot");
	public final static Item remulaCell = new RemulaCell(17011).setUnlocalizedName("remulaCell");
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
	public final static Item porinSeeds = new PorinSeeds(17040, porinCrop.blockID, akatoeTilledDirt.blockID).setUnlocalizedName("porinSeeds");
	public final static Item ulinSeeds = new UlinSeeds(17041, ulinCrop.blockID, akatoeTilledDirt.blockID).setUnlocalizedName("ulinSeeds");
	public final static Item cirSeeds = new CirSeeds(17042, cirCrop.blockID, akatoeTilledDirt.blockID).setUnlocalizedName("cirSeeds");
	public final static Item boskinSeeds = new BoskinSeeds(17043, cirCrop.blockID, akatoeTilledDirt.blockID).setUnlocalizedName("boskinSeeds");
	public final static Item porinFruit = new PorinFruit(17044, 5, 3.0F, false).setUnlocalizedName("porinFruit");
	public final static Item ulinFruit = new UlinFruit(17045, 2, 1.0F, false).setUnlocalizedName("ulinFruit");
	public final static Item itemCir = new ItemCir(17046).setUnlocalizedName("itemCir");
	public final static Item itemBoskin = new ItemBoskin(17047).setUnlocalizedName("itemBoskin");
	public final static Item poriniteCell = new PoriniteCell(17050).setUnlocalizedName("poriniteCell");
	public final static Item pilkCell = new PilkCell(17051).setUnlocalizedName("pilkCell");
	public final static Item akatiteCell = new AkatiteCell(17052).setUnlocalizedName("akatiteCell");
	public final static Item poriniteDust = new PoriniteDust(17053).setUnlocalizedName("poriniteDust");
	public final static Item pilkDust = new PilkDust(17054).setUnlocalizedName("pilkDust");
	public final static Item akatiteDust = new AkatiteDust(17055).setUnlocalizedName("akatiteDust");
	public final static Item poriniteIngot = new PoriniteIngot(17056).setUnlocalizedName("poriniteIngot");
	public final static Item pilkIngot = new PilkIngot(17057).setUnlocalizedName("pilkIngot");
	public final static Item akatiteIngot = new AkatiteIngot(17058).setUnlocalizedName("akatiteIngot");
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
	//public final static Item standardPistol = new ItemPistol(17042).setUnlocalizedName("standardPistol");
	//InfusionUpgrade
	//StorageUpgrade
	//SpeedUpgrade
	//StrengthUpgrade
	//CCUpgrade?
	
    public static BiomeGenBase akatoePlainsBiome = new BiomeAkatoePlains(60);
    public static BiomeGenBase akatoeDesertBiome = new BiomeAkatoeDesert(61);
    public static BiomeGenBase akatoeOceanBiome = new BiomeAkatoeOcean(62);
    public static BiomeGenBase baloinusPlainsBiome = new BiomeBaloinusPlains(65);
    public static BiomeGenBase elkostDesertBiome = new BiomeElkostPlains(66);
    public static BiomeGenBase indikuJungleBiome = new BiomeIndikuJungle(67);
    public static BiomeGenBase xylexiaPlainsBiome = new BiomeXylexiaPlains(68);*/
    
    @Init
    public void load(FMLInitializationEvent event) {
            proxy.registerRenderThings();
            proxy.init();
               /*         
            //The whitespace here is simply for organisation. I like to keep it neat.
            //If you're trying to learn from my code (good luck ;)), the below section doesn't need to be in any specific order.
            OreDictionary.registerOre("oreSilvanite", new ItemStack(silvaniteOre));
            OreDictionary.registerOre("oreMercilite", new ItemStack (merciliteOre));
            OreDictionary.registerOre("oreRemula", new ItemStack (remulaOre));
            OreDictionary.registerOre("oreCopper", new ItemStack (copperOre));
            OreDictionary.registerOre("oreTin", new ItemStack (tinOre));
            OreDictionary.registerOre("oreZinc", new ItemStack (zincOre));
            OreDictionary.registerOre("oreSilver", new ItemStack (silverOre));
            OreDictionary.registerOre("woodRubber", new ItemStack (rubberLog));
            OreDictionary.registerOre("oreCoal", new ItemStack (akatoeCoal));
            OreDictionary.registerOre("oreIron", new ItemStack (akatoeIron));
            OreDictionary.registerOre("oreGold", new ItemStack (akatoeGold));
            OreDictionary.registerOre("oreCopper", new ItemStack (akatoeCopper));
            OreDictionary.registerOre("oreTin", new ItemStack (akatoeTin));
            OreDictionary.registerOre("oreLapisLazuli", new ItemStack (akatoeLapis));
            OreDictionary.registerOre("orePorinite", new ItemStack (poriniteOre));
            OreDictionary.registerOre("orePilk", new ItemStack (pilkOre));
            OreDictionary.registerOre("oreAkatite", new ItemStack (akatiteOre));
            OreDictionary.registerOre("oreRemula", new ItemStack (akatoeRemulaOre));
            
            //Register names for blocks
            //Ores
            LanguageRegistry.addName(silvaniteOre, "Silvanite Ore");
            LanguageRegistry.addName(merciliteOre, "Mercilite Ore");
            LanguageRegistry.addName(remulaOre, "Remula Ore");
            LanguageRegistry.addName(copperOre, "Copper Ore");
            LanguageRegistry.addName(tinOre, "Tin Ore");
            LanguageRegistry.addName(zincOre, "Zinc Ore");
            LanguageRegistry.addName(silverOre, "Silver Ore");
            LanguageRegistry.addName(akatoeCoal, "Akatonian Coal Ore");
            LanguageRegistry.addName(akatoeIron, "Akatonian Iron Ore");
            LanguageRegistry.addName(akatoeGold, "Akationian Gold Ore");
            LanguageRegistry.addName(akatoeCopper, "Akatonian Copper Ore");
            LanguageRegistry.addName(akatoeTin, "Akatonian Tin Ore");
            LanguageRegistry.addName(akatoeLapis, "Akatonian Lapis Lazuli Ore");
            LanguageRegistry.addName(poriniteOre, "Porinite Ore");
            LanguageRegistry.addName(pilkOre, "Pilk Ore");
            LanguageRegistry.addName(akatoeRemulaOre, "Akatonian Remula Ore");
            LanguageRegistry.addName(akatiteOre, "Akatite Ore");
            
            
            //Tree Stuff
            LanguageRegistry.addName(rubberLog, "Rubber Log");
            LanguageRegistry.addName(rubberLeaves, "Rubber Leaves");
            LanguageRegistry.addName(rubberSapling, "Rubber Sapling");
            
            //Powergrid
            LanguageRegistry.addName(remulaBasicStorageUnit, "Basic RSU");
            LanguageRegistry.addName(remulaSimpleStorageUnit, "Simple RSU");
            //LanguageRegistry.addName(remulaMidStorageUnit, "Mid RSU");
            LanguageRegistry.addName(remulaHighStorageUnit, "Advanced RSU");
            LanguageRegistry.addName(remulaExcessiveStorageUnit, "Excessive RSU");
            LanguageRegistry.addName(remulaExperimentalStorageUnit, "Experimental RSU");
            LanguageRegistry.addName(remulaGenerator, "Remula Generator");
            LanguageRegistry.addName(remulaSolarPanel, "Remula Solar Panel");
            LanguageRegistry.addName(remulaThermalGenerator, "Thermal Generator");
            LanguageRegistry.addName(remulaGrinder, "Grinder");
            LanguageRegistry.addName(remulaReactorCore, "Reactor Core");
            
            //Nature and Plant Stuff
            LanguageRegistry.addName(porinCrop, "Porin Crop");
            LanguageRegistry.addName(ulinCrop, "Ulin Crop");
            LanguageRegistry.addName(cirCrop, "Cir Crop");
            LanguageRegistry.addName(boskinCrop, "Boskin Crop");
            LanguageRegistry.addName(plantFuxii, "Fuxii");
            
            //Storage and Tile Entites
            LanguageRegistry.addName(silvaniteChest, "Silvanite Chest");
            LanguageRegistry.addName(merciliteChest, "Mercilite Chest");
            LanguageRegistry.addName(remulaChest, "Remula Chest");
            LanguageRegistry.addName(remulaLiquidizer, "Liquid Refinery");
            LanguageRegistry.addName(remulaCraftingTable, "Liquid Infusion Station");
            
            //Akatoe
            LanguageRegistry.addName(akatoePortal, "Akatoe Portal");
            LanguageRegistry.addName(akatoeStone, "Akatonian Stone");
            LanguageRegistry.addName(akatoeCobble, "Akatonian Cobble");
            LanguageRegistry.addName(akatoeGrass, "Akatonian Grass");
            LanguageRegistry.addName(akatoeDirt, "Akatonian Dirt");
            LanguageRegistry.addName(akatoeSand, "Akatonian Sand");
            LanguageRegistry.addName(akatoeRefinedStone, "Akatonian Refined Stone");
            LanguageRegistry.addName(akatoeBricks, "Akatonian Bricks");
            LanguageRegistry.addName(akatoeLargeBricks, "Akatonian Large Bricks");
            LanguageRegistry.addName(akatoeDecorBricks, "Akatonian Decorative Brick");
            LanguageRegistry.addName(akatoeTilledDirt, "Akatonian Tilled Dirt");
            
            //Baloinus
            /*LanguageRegistry.addName(baloinusPortal, "Baloinus Portal");
            LanguageRegistry.addName(baloinusStone, "Baloinus Stone");*/
            
            //Indiku
            /*LanguageRegistry.addName(indikuStone, "Indiku Stone");
            LanguageRegistry.addName(indikuDirt, "Indiku Dirt");
            LanguageRegistry.addName(indikuGrass, "Indiku Grass");
            LanguageRegistry.addName(indikuTilledDirt, "Indiku Tilled Dirt");
            
            //Elkost
            LanguageRegistry.addName(elkostSand, "Elkost Dirt");
            LanguageRegistry.addName(elkostGlassPane, "Elkost Glass Pane");
            
            //Xylexia
            LanguageRegistry.addName(xylexianSand, "Xylexian Dirt");
            LanguageRegistry.addName(xylexianStone, "Xylexian Stone");
            LanguageRegistry.addName(xylexianGlassPane, "Xylexian Glass Pane");
            
            //DeepSpace
            LanguageRegistry.addName(deepSpacePortal, "Deep-Space Portal");
            LanguageRegistry.addName(deepSpaceBrownAsteroidRock, "Asteroid Rock");
            LanguageRegistry.addName(deepSpaceWhiteAsteroidRock, "Asteroid Rock");
            
            //Register Blocks
            //Earth Ores
            GameRegistry.registerBlock(remulaOre, "remulaOre");
            GameRegistry.registerBlock(merciliteOre, "merciliteOre");
            GameRegistry.registerBlock(silvaniteOre, "silvaniteOre");
            GameRegistry.registerBlock(copperOre, "copperOre");
            GameRegistry.registerBlock(tinOre, "tinOre");
            GameRegistry.registerBlock(zincOre, "zincOre");
            GameRegistry.registerBlock(silverOre, "silverOre");
            
            
            //Plants and Nature
            GameRegistry.registerBlock(rubberLog, "rubberLog");
            GameRegistry.registerBlock(rubberLeaves, "rubberLeaves");
            GameRegistry.registerBlock(rubberSapling, "rubberSapling");
            GameRegistry.registerBlock(porinCrop, "porinCrop");
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
            GameRegistry.registerBlock(remulaReactorCore, "remulaReactorCore");
            
            //Storage Blocks/Tile Entites
            GameRegistry.registerBlock(silvaniteChest, "silvaniteChest");
            GameRegistry.registerBlock(merciliteChest, "merciliteChest");
            GameRegistry.registerBlock(remulaChest, "remulaChest");
            GameRegistry.registerBlock(remulaLiquidizer, "remulaLiquidizer");
            GameRegistry.registerBlock(remulaCraftingTable, "remulaCraftingTable");
            
            //Akatoe Blocks
            GameRegistry.registerBlock(akatoePortal, "AkatoePortal");
            GameRegistry.registerBlock(akatoeStone, "akatoeStone");
            GameRegistry.registerBlock(akatoeGrass, "akatoeGrass");
            GameRegistry.registerBlock(akatoeDirt, "akatoeDirt");
            GameRegistry.registerBlock(akatoeSand, "akatoeSand");

            //Baloinus
            GameRegistry.registerBlock(baloinusPortal, "baloinusPortal");
            GameRegistry.registerBlock(baloinusStone, "baloinusStone");*/
            
            GameRegistry.registerBlock(akatoeTerrainBlocks, ItemAkatoeTerrainBlocks.class, "Remula" + (akatoeTerrainBlocks.getUnlocalizedName().substring(5)));
            GameRegistry.registerBlock(akatoeOreBlocks, ItemAkatoeOreBlocks.class, "Remula" + (akatoeOreBlocks.getUnlocalizedName().substring(5)));
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
            
            GameRegistry.registerBlock(baloinusTerrainBlocks, ItemBaloinusTerrainBlocks.class, "Remula" + (baloinusTerrainBlocks.getUnlocalizedName().substring(5)));
            GameRegistry.registerBlock(baloinusOreBlocks, ItemBaloinusOreBlocks.class, "Remula" + (baloinusOreBlocks.getUnlocalizedName().substring(5)));
            
            LanguageRegistry.addName(new ItemStack(baloinusTerrainBlocks, 1, 0), "Baloinus Cobblestone");
            LanguageRegistry.addName(new ItemStack(baloinusTerrainBlocks, 1, 1), "Baloinus Bricks");
            LanguageRegistry.addName(new ItemStack(baloinusTerrainBlocks, 1, 2), "Baloinus Small Bricks");
            LanguageRegistry.addName(new ItemStack(baloinusTerrainBlocks, 1, 3), "Baloinus Decorative Bricks");
            LanguageRegistry.addName(new ItemStack(baloinusTerrainBlocks, 1, 4), "Baloinus Refined Stone");
            LanguageRegistry.addName(new ItemStack(baloinusOreBlocks, 1, 0), "Baloinus Coal Ore");
            LanguageRegistry.addName(new ItemStack(baloinusOreBlocks, 1, 1), "Baloinus Copper Ore");
            LanguageRegistry.addName(new ItemStack(baloinusOreBlocks, 1, 2), "Baloinus Tin Ore");
            LanguageRegistry.addName(new ItemStack(baloinusOreBlocks, 1, 3), "Baloinus Iron Ore");
            LanguageRegistry.addName(new ItemStack(baloinusOreBlocks, 1, 4), "Baloinus Remula Ore");
            LanguageRegistry.addName(new ItemStack(baloinusOreBlocks, 1, 5), "Baloinus Porinite Ore");
            LanguageRegistry.addName(new ItemStack(baloinusOreBlocks, 1, 6), "Baloinus Pilk Ore");
            LanguageRegistry.addName(new ItemStack(baloinusOreBlocks, 1, 7), "Baloinus Tritanite Ore");
            LanguageRegistry.addName(new ItemStack(baloinusOreBlocks, 1, 8), "Baloinus Balum Ore");
            
            GameRegistry.registerBlock(indikuTerrainBlocks, ItemIndikuTerrainBlocks.class, "Remula" + (indikuTerrainBlocks.getUnlocalizedName().substring(5)));
            GameRegistry.registerBlock(indikuOreBlocks, ItemIndikuOreBlocks.class, "Remula" + (indikuOreBlocks.getUnlocalizedName().substring(5)));
            
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
            
            GameRegistry.registerBlock(elkostTerrainBlocks, ItemElkostTerrainBlocks.class, "Remula" + (elkostTerrainBlocks.getUnlocalizedName().substring(5)));
            GameRegistry.registerBlock(elkostOreBlocks, ItemElkostOreBlocks.class, "Remula" + (elkostOreBlocks.getUnlocalizedName().substring(5)));
            
            LanguageRegistry.addName(new ItemStack(elkostTerrainBlocks, 1, 0), "Elkost Cobblestone");
            LanguageRegistry.addName(new ItemStack(elkostTerrainBlocks, 1, 1), "Elkost Bricks");
            LanguageRegistry.addName(new ItemStack(elkostTerrainBlocks, 1, 2), "Elkost Small Bricks");
            LanguageRegistry.addName(new ItemStack(elkostTerrainBlocks, 1, 3), "Elkost Decorative Bricks");
            LanguageRegistry.addName(new ItemStack(elkostTerrainBlocks, 1, 4), "Elkost Refined Stone");
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
            LanguageRegistry.addName(new ItemStack(elkostOreBlocks, 1, 10), "Elkost Grinist Ore");
            LanguageRegistry.addName(new ItemStack(elkostOreBlocks, 1, 11), "Elkost Tristanium Ore");
            LanguageRegistry.addName(new ItemStack(elkostOreBlocks, 1, 12), "Elkost Elkostium Ore");
            
            GameRegistry.registerBlock(xylexiaTerrainBlocks, ItemXylexiaTerrainBlocks.class, "Remula" + (xylexiaTerrainBlocks.getUnlocalizedName().substring(5)));
            GameRegistry.registerBlock(xylexiaOreBlocks, ItemXylexiaOreBlocks.class, "Remula" + (xylexiaOreBlocks.getUnlocalizedName().substring(5)));
            
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
            LanguageRegistry.addName(new ItemStack(xylexiaOreBlocks, 1, 9), "Xylexian Tristanium Ore");
            LanguageRegistry.addName(new ItemStack(xylexiaOreBlocks, 1, 10), "Xylexian Heri Ore");
            LanguageRegistry.addName(new ItemStack(xylexiaOreBlocks, 1, 11), "Xylexian Skatha Ore");
            LanguageRegistry.addName(new ItemStack(xylexiaOreBlocks, 1, 12), "Xylexian Kzori Ore");
            LanguageRegistry.addName(new ItemStack(xylexiaOreBlocks, 1, 13), "Xylexian Xylexite Ore");
            
            //Deep Space
            GameRegistry.registerBlock(deepSpaceTerrainBlocks, ItemDeepSpaceTerrainBlocks.class, "Remula" + (deepSpaceTerrainBlocks.getUnlocalizedName().substring(5)));
            GameRegistry.registerBlock(deepSpaceBrownOreBlocks, ItemDeepSpaceBrownOreBlocks.class, "Remula" + (deepSpaceBrownOreBlocks.getUnlocalizedName().substring(5)));
            GameRegistry.registerBlock(deepSpaceWhiteOreBlocks, ItemDeepSpaceWhiteOreBlocks.class, "Remula" + (deepSpaceWhiteOreBlocks.getUnlocalizedName().substring(5)));
            
            LanguageRegistry.addName(new ItemStack(deepSpaceTerrainBlocks, 1, 0), "Brown Asteroid Rubble");
            LanguageRegistry.addName(new ItemStack(deepSpaceTerrainBlocks, 1, 1), "Brown Asteroid Bricks");
            LanguageRegistry.addName(new ItemStack(deepSpaceTerrainBlocks, 1, 2), "Brown Asteroid Small Bricks");
            LanguageRegistry.addName(new ItemStack(deepSpaceTerrainBlocks, 1, 3), "Brown Asteroid Decorative Bricks");
            LanguageRegistry.addName(new ItemStack(deepSpaceTerrainBlocks, 1, 4), "Refined Brown Asteroid");
            LanguageRegistry.addName(new ItemStack(deepSpaceTerrainBlocks, 1, 5), "Brown Asteroid Dust");
            LanguageRegistry.addName(new ItemStack(deepSpaceTerrainBlocks, 1, 6), "");
            LanguageRegistry.addName(new ItemStack(deepSpaceTerrainBlocks, 1, 7), "");
            LanguageRegistry.addName(new ItemStack(deepSpaceTerrainBlocks, 1, 8), "White Asteroid Rubble");
            LanguageRegistry.addName(new ItemStack(deepSpaceTerrainBlocks, 1, 9), "White Asteroid Bricks");
            LanguageRegistry.addName(new ItemStack(deepSpaceTerrainBlocks, 1, 10), "White Asteroid Small Bricks");
            LanguageRegistry.addName(new ItemStack(deepSpaceTerrainBlocks, 1, 11), "White Asteroid Decorative Bricks");
            LanguageRegistry.addName(new ItemStack(deepSpaceTerrainBlocks, 1, 12), "Refined White Asteroid ");
            LanguageRegistry.addName(new ItemStack(deepSpaceTerrainBlocks, 1, 13), "White Asteroid Dust");
            LanguageRegistry.addName(new ItemStack(deepSpaceTerrainBlocks, 1, 14), "");
            LanguageRegistry.addName(new ItemStack(deepSpaceTerrainBlocks, 1, 15), "");
            
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
            LanguageRegistry.addName(new ItemStack(deepSpaceBrownOreBlocks, 1, 12), "");
            LanguageRegistry.addName(new ItemStack(deepSpaceBrownOreBlocks, 1, 13), "");
            LanguageRegistry.addName(new ItemStack(deepSpaceBrownOreBlocks, 1, 14), "");
            LanguageRegistry.addName(new ItemStack(deepSpaceBrownOreBlocks, 1, 15), "");
            
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
            LanguageRegistry.addName(new ItemStack(deepSpaceWhiteOreBlocks, 1, 12), "");
            LanguageRegistry.addName(new ItemStack(deepSpaceWhiteOreBlocks, 1, 13), "");
            LanguageRegistry.addName(new ItemStack(deepSpaceWhiteOreBlocks, 1, 14), "");
            LanguageRegistry.addName(new ItemStack(deepSpaceWhiteOreBlocks, 1, 15), "");
            
            //Indiku
            /*GameRegistry.registerBlock(indikuStone, "indikuStone");
            GameRegistry.registerBlock(indikuDirt, "indikuDirt");
            GameRegistry.registerBlock(indikuGrass, "indikuGrass");
            GameRegistry.registerBlock(indikuCobblestone, "indikuCobblestone");
            GameRegistry.registerBlock(indikuBricks, "indikuBricks");
            GameRegistry.registerBlock(indikuSmallBricks, "indikuSmallBricks");
            GameRegistry.registerBlock(indikuRefinedStone, "indikuRefinedStone");
            GameRegistry.registerBlock(indikuTilledDirt, "indikuTilledDirt");
            GameRegistry.registerBlock(indikuCoalOre, "indikuCoalOre");
            GameRegistry.registerBlock(indikuCopperOre, "indikuCopperOre");
            GameRegistry.registerBlock(indikuTinOre, "indikuTinOre");
            GameRegistry.registerBlock(indikuIronOre, "indikuIronOre");
            GameRegistry.registerBlock(indikuGoldOre, "indikuGoldOre");
            GameRegistry.registerBlock(indikuLapisLazuliOre, "indikuLapisLazuliOre");
            GameRegistry.registerBlock(indikuRemulaOre, "indikuRemulaOre");
            GameRegistry.registerBlock(indikuTritaniteOre, "indikuTritaniteOre");
            GameRegistry.registerBlock(indikuVentiiumOre, "indikuVentiiumOre");
            GameRegistry.registerBlock(indikuArithiumOre, "indikuArithiumOre");
            GameRegistry.registerBlock(indikuZiriniumOre, "indikuZiriniumOre");
            GameRegistry.registerBlock(indikiteOre, "indikiteOre");
            
            //Elkost
            GameRegistry.registerBlock(elkostSand, "elkostSand");
            GameRegistry.registerBlock(elkostStone, "elkostStone");
            GameRegistry.registerBlock(elkostCobblestone, "elkostCobblestone");
            GameRegistry.registerBlock(elkostBricks, "elkostBricks");
            GameRegistry.registerBlock(elkostSmallBricks, "elkostSmallBricks");
            GameRegistry.registerBlock(elkostRefinedStone, "elkostRefinedStone");
            GameRegistry.registerBlock(elkostCoalOre, "elkostCoalOre");
            GameRegistry.registerBlock(elkostCopperOre, "elkostCopperOre");
            GameRegistry.registerBlock(elkostTinOre, "elkostTinOre");
            GameRegistry.registerBlock(elkostIronOre, "elkostIronOre");
            GameRegistry.registerBlock(elkostGoldOre, "elkostGoldOre");
            GameRegistry.registerBlock(elkostLapisLazuliOre, "elkostLapisLazuliOre");
            GameRegistry.registerBlock(elkostRemulaOre, "elkostRemulaOre");
            GameRegistry.registerBlock(elkostTritaniteOre, "elkostTritaniteOre");
            GameRegistry.registerBlock(elkostZiriniumOre, "elkostZiriniumOre");
            GameRegistry.registerBlock(elkostBoriaOre, "elkostVentiiumOre");
            GameRegistry.registerBlock(elkostTristaniumOre, "elkostArithiumOre");
            GameRegistry.registerBlock(elkostGrinistOre, "elkostGrinistOre");
            GameRegistry.registerBlock(elkostiumOre, "elkostiumOre");
            GameRegistry.registerBlock(elkostGlass, "elkostGlass");
            GameRegistry.registerBlock(elkostGlassPane, "elkostGlassPane");
            
            //Xylexia
            GameRegistry.registerBlock(xylexianSand, "xylexianSand");
            GameRegistry.registerBlock(xylexianStone, "xylexianStone");
            GameRegistry.registerBlock(xylexianCobblestone, "xylexianCobblestone");
            GameRegistry.registerBlock(xylexianBricks, "xylexianBricks");
            GameRegistry.registerBlock(xylexianSmallBricks, "xylexianSmallBricks");
            GameRegistry.registerBlock(xylexianRefinedStone, "xylexianRefined Stone");
            GameRegistry.registerBlock(xylexianCoalOre, "xylexianCoalOre");
            GameRegistry.registerBlock(xylexianCopperOre, "xylexianCopperOre");
            GameRegistry.registerBlock(xylexianTinOre, "xylexianTinOre");
            GameRegistry.registerBlock(xylexianIronOre, "xylexianIronOre");
            GameRegistry.registerBlock(xylexianGoldOre, "xylexianGoldOre");
            GameRegistry.registerBlock(xylexianLapisLazuliOre, "xylexianLapisLazuliOre");
            GameRegistry.registerBlock(xylexianRemulaOre, "xylexianRemulaOre");
            GameRegistry.registerBlock(xylexianTritaniteOre, "xylexianTritaniteOre");
            GameRegistry.registerBlock(xylexianZiriniumOre, "xylexianZiriniumOre");
            GameRegistry.registerBlock(xylexianGrinistOre, "xylexianGrinistOre");
            GameRegistry.registerBlock(xylexianHeriOre, "xylexianHeriOre");
            GameRegistry.registerBlock(xylexianSkathaOre, "xylexianSkathaOre");
            GameRegistry.registerBlock(xylexianKzoriOre, "xylexianKzoriOre");
            GameRegistry.registerBlock(xylexianiumOre, "XylexianiumOre");
            GameRegistry.registerBlock(xylexianGlass, "xylexianGlass");
            GameRegistry.registerBlock(xylexianGlassPane, "xylexianGlassPane");
            
            //Deep Space
            GameRegistry.registerBlock(deepSpacePortal, "deepSpacePortal");
            GameRegistry.registerBlock(deepSpaceBrownAsteroidRock, "deepSpaceAsteroidRock");
            GameRegistry.registerBlock(deepSpaceWhiteAsteroidRock, "deepSpaceMeteoriteRock");
            GameRegistry.registerBlock(brownAsteroidRubble, "brownAsteroidRubble");
            GameRegistry.registerBlock(brownAsteroidBricks, "brownAsteroidBricks");
            GameRegistry.registerBlock(brownAsteroidSmallBricks, "brownAsteroidSmallBricks");
            GameRegistry.registerBlock(brownAsteroidCopperOre, "brownAsteroidCopperOre");
            GameRegistry.registerBlock(brownAsteroidTinOre, "brownAsteroidTinOre");
            GameRegistry.registerBlock(brownAsteroidIronOre, "brownAsteroidIronOre");
            GameRegistry.registerBlock(brownAsteroidSilvaniteOre, "brownAsteroidSilvaniteOre");
            GameRegistry.registerBlock(brownAsteroidPoriniteOre, "brownAsteroidPoriniteOre");
            GameRegistry.registerBlock(brownAsteroidSirianOre, "brownAsteroidSirianOre");
            GameRegistry.registerBlock(brownAsteroidFariteOre, "brownAsteroidFariteOre");
            GameRegistry.registerBlock(brownAsteroidZincOre, "brownAsteroidZincOre");
            GameRegistry.registerBlock(brownAsteroidDragiteOre, "brownAsteroidDragiteOre");
            GameRegistry.registerBlock(brownAsteroidThoriOre, "brownAsteroidThoriOre");
            GameRegistry.registerBlock(brownAsteroidVentiiumOre, "brownAsteroidVentiiumOre");
            GameRegistry.registerBlock(brownAsteroidFarithiumOre, "brownAsteroidFarithiumOre");
            GameRegistry.registerBlock(brownAsteroidBoriaOre, "brownAsteroidBoriaOre");
            GameRegistry.registerBlock(brownAsteroidHeriOre, "brownAsteroidHeriOre");
            //GameRegistry.registerBlock(brownAsteroidP6, "brownAsteroidOre");
            //GameRegistry.registerBlock(brownAsteroidP7, "brownAsteroidOre");
            //GameRegistry.registerBlock(brownAsteroidP8, "brownAsteroidOre");
            //GameRegistry.registerBlock(brownAsteroidP9, "brownAsteroidOre");
            GameRegistry.registerBlock(whiteAsteroidRubble, "whiteAsteroidRubble");
            GameRegistry.registerBlock(whiteAsteroidBricks, "whiteAsteroidBricks");
            GameRegistry.registerBlock(whiteAsteroidSmallBricks, "whiteAsteroidSmallBricks");
            GameRegistry.registerBlock(whiteAsteroidCopperOre, "whiteAsteroidCopperOre");
            GameRegistry.registerBlock(whiteAsteroidTinOre, "whiteAsteroidTinOre");
            GameRegistry.registerBlock(whiteAsteroidIronOre, "whiteAsteroidIronOre");
            GameRegistry.registerBlock(whiteAsteroidSilvaniteOre, "whiteAsteroidSilvaniteOre");
            GameRegistry.registerBlock(whiteAsteroidPoriniteOre, "whiteAsteroidPoriniteOre");
            GameRegistry.registerBlock(whiteAsteroidSirianOre, "whiteAsteroidSirianOre");
            GameRegistry.registerBlock(whiteAsteroidFariteOre, "whiteAsteroidFariteOre");
            GameRegistry.registerBlock(whiteAsteroidZincOre, "whiteAsteroidZincOre");
            GameRegistry.registerBlock(whiteAsteroidDragiteOre, "whiteAsteroidDragiteOre");
            GameRegistry.registerBlock(whiteAsteroidThoriOre, "whiteAsteroidThoriOre");
            GameRegistry.registerBlock(whiteAsteroidVentiiumOre, "whiteAsteroidVentiiumOre");
            GameRegistry.registerBlock(whiteAsteroidFarithiumOre, "whiteAsteroidFarithiumOre");
            GameRegistry.registerBlock(whiteAsteroidBoriaOre, "whiteAsteroidBoriaOre");
            GameRegistry.registerBlock(whiteAsteroidHeriOre, "whiteAsteroidHeriOre");
            //GameRegistry.registerBlock(whiteAsteroidP6, "whiteAsteroidOre");
            //GameRegistry.registerBlock(whiteAsteroidP7, "whiteAsteroidOre");
            //GameRegistry.registerBlock(whiteAsteroidP8, "whiteAsteroidOre");
            //GameRegistry.registerBlock(whiteAsteroidP9, "whiteAsteroidOre");
            GameRegistry.registerBlock(indikuPortalBlock, "indikuPortalBlock");
            GameRegistry.registerBlock(elkostPortalBlock, "elkostPortalBlock");
            GameRegistry.registerBlock(xylexianPortalBlock, "xylexianPortalBlock");
            
            //Ore Mining Requirements
            MinecraftForge.setBlockHarvestLevel(silvaniteOre, "pickaxe", 1);
            MinecraftForge.setBlockHarvestLevel(merciliteOre, "pickaxe", 2);
            MinecraftForge.setBlockHarvestLevel(remulaOre, "pickaxe", 3);
            MinecraftForge.setBlockHarvestLevel(copperOre, "pickaxe", 1);
            MinecraftForge.setBlockHarvestLevel(tinOre, "pickaxe", 1);
            MinecraftForge.setBlockHarvestLevel(zincOre, "pickaxe", 2);
            MinecraftForge.setBlockHarvestLevel(silverOre, "pickaxe", 2);
            MinecraftForge.setBlockHarvestLevel(akatoeCoal, "pickaxe", 0);
            MinecraftForge.setBlockHarvestLevel(akatoeIron, "pickaxe", 1);
            MinecraftForge.setBlockHarvestLevel(akatoeGold, "pickaxe", 2);
            MinecraftForge.setBlockHarvestLevel(akatoeCopper, "pickaxe", 1);
            MinecraftForge.setBlockHarvestLevel(akatoeTin, "pickaxe", 1);
            MinecraftForge.setBlockHarvestLevel(akatoeLapis, "pickaxe", 2);
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
            LanguageRegistry.addName(porinSeeds, "Porin Seeds");
            LanguageRegistry.addName(ulinFruit, "Ulin");
            LanguageRegistry.addName(ulinSeeds, "Ulin Seeds");
            LanguageRegistry.addName(itemCir, "Cir");
            LanguageRegistry.addName(cirSeeds, "Cir Seeds");
            LanguageRegistry.addName(itemBoskin, "Boskin");
            LanguageRegistry.addName(boskinSeeds, "Boskin Seeds");
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
            //LanguageRegistry.addName(standardPistol, "Standard Pistol");
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
            GameRegistry.registerItem(porinSeeds, "porinSeeds");
            GameRegistry.registerItem(ulinFruit, "ulinFruit");
            GameRegistry.registerItem(ulinSeeds, "ulinSeeds");
            GameRegistry.registerItem(itemCir, "itemCir");
            GameRegistry.registerItem(cirSeeds, "cirSeeds");
            GameRegistry.registerItem(itemBoskin, "itemBoskin");
            GameRegistry.registerItem(boskinSeeds, "boskinSeeds");
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
            //GameRegistry.registerItem(standardPistol, "standardPistol");
            GameRegistry.registerItem(p1HudUnit, "p1HudUnit");
            
            //Power Grid
            GameRegistry.registerItem(simpleBattery, "simpleBattery");
            GameRegistry.registerItem(midBattery, "medBattery");
            GameRegistry.registerItem(highBattery, "highBattery");
            GameRegistry.registerItem(simplePRSU, "simplePRSU");
            GameRegistry.registerItem(midPRSU, "midPRSU");
            GameRegistry.registerItem(advancedPRSU, "advancedPRSU");
            
            
            //Tile Entities
            GameRegistry.registerTileEntity(TileEntitySilvaniteChest.class, "tileEntitySilvaniteChest");
            GameRegistry.registerTileEntity(TileEntityMerciliteChest.class, "tileEntityMerciliteChest");
            GameRegistry.registerTileEntity(TileEntityRemulaChest.class, "tileEntityRemulaChest");
            GameRegistry.registerTileEntity(TileEntityLITable.class, "tileEntityLITable");
            
            //Other Registry Stuff
            LanguageRegistry.instance().addStringLocalization("itemGroup.tabRemula", "en_US", "Remula");
            LanguageRegistry.instance().addStringLocalization("itemGroup.tabAkatoe", "en_US", "Akatoe");
            LanguageRegistry.instance().addStringLocalization("itemGroup.tabBaloinus", "en_US", "Baloinus");
            LanguageRegistry.instance().addStringLocalization("itemGroup.tabDeepSpace", "en_US", "Deep-Space");
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
            EntityRegistry.registerModEntity(EntityAkatonian.class, "Akatonian", 1, this, 80, 3, true);
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
            
            LanguageRegistry.instance().addStringLocalization("entity.instance.Akatonian.name", "Akatonian");
            LanguageRegistry.instance().addStringLocalization("entity.instance.Glog.name", "Glog");
            LanguageRegistry.instance().addStringLocalization("entity.instance.AdvancedRobot.name", "Flendroid 5000");
            LanguageRegistry.instance().addStringLocalization("entity.instance.Xylexian.name", "Xylexian");
            LanguageRegistry.instance().addStringLocalization("entity.instance.Skitterling.name", "Skitterling");
            LanguageRegistry.instance().addStringLocalization("entity.instance.Hermust.name", "Hermust");
            LanguageRegistry.instance().addStringLocalization("entity.instance.Garfin.name", "Garfin");
            LanguageRegistry.instance().addStringLocalization("entity.instance.Lignis.name", "Lignis");
            
            //CRAFTING!
            
            //Ingots
            ItemStack copperOreStack = new ItemStack(Remula.copperOre);
            ItemStack tinOreStack = new ItemStack(Remula.tinOre);*/
            
    }


	@PostInit
    public void postInit(FMLPostInitializationEvent event) {
            // Stub Method
    		}
	}
