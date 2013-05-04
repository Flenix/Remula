package co.uk.silvania.Remula;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.oredict.OreDictionary;
import co.uk.silvania.Remula.CommonProxy;
import co.uk.silvania.Remula.blocks.*;
import co.uk.silvania.Remula.dimensions.AkatoePortalBlock;
import co.uk.silvania.Remula.dimensions.AkatoeWorldProvider;
import co.uk.silvania.Remula.dimensions.akatoe.AkatoeBricks;
import co.uk.silvania.Remula.dimensions.akatoe.AkatoeCoal;
import co.uk.silvania.Remula.dimensions.akatoe.AkatoeCobble;
import co.uk.silvania.Remula.dimensions.akatoe.AkatoeCopper;
import co.uk.silvania.Remula.dimensions.akatoe.AkatoeDecorBricks;
import co.uk.silvania.Remula.dimensions.akatoe.AkatoeDirt;
import co.uk.silvania.Remula.dimensions.akatoe.AkatoeGold;
import co.uk.silvania.Remula.dimensions.akatoe.AkatoeGrass;
import co.uk.silvania.Remula.dimensions.akatoe.AkatoeIron;
import co.uk.silvania.Remula.dimensions.akatoe.AkatoeLapis;
import co.uk.silvania.Remula.dimensions.akatoe.AkatoeLargeBricks;
import co.uk.silvania.Remula.dimensions.akatoe.AkatoeRefinedStone;
import co.uk.silvania.Remula.dimensions.akatoe.AkatoeSand;
import co.uk.silvania.Remula.dimensions.akatoe.AkatoeStone;
import co.uk.silvania.Remula.dimensions.akatoe.AkatoeTilledDirt;
import co.uk.silvania.Remula.dimensions.akatoe.AkatoeTin;
import co.uk.silvania.Remula.dimensions.akatoe.PorinCrop;
import co.uk.silvania.Remula.dimensions.akatoe.PorinFruit;
import co.uk.silvania.Remula.dimensions.akatoe.PorinSeeds;
import co.uk.silvania.Remula.dimensions.akatoe.PoriniteOre;
import co.uk.silvania.Remula.entity.MerciliteChest;
import co.uk.silvania.Remula.entity.RemulaChest;
import co.uk.silvania.Remula.entity.RemulaGuiHandler;
import co.uk.silvania.Remula.entity.SilvaniteChest;
import co.uk.silvania.Remula.entity.SilvaniteGuiHandler;
import co.uk.silvania.Remula.items.*;
import co.uk.silvania.Remula.powergrid.blocks.RemulaAdvancedGenerator;
import co.uk.silvania.Remula.powergrid.blocks.RemulaAdvancedSolarPanel;
import co.uk.silvania.Remula.powergrid.blocks.RemulaBasicStorageUnit;
import co.uk.silvania.Remula.powergrid.blocks.RemulaExcessiveStorageUnit;
import co.uk.silvania.Remula.powergrid.blocks.RemulaExperimentalStorageUnit;
import co.uk.silvania.Remula.powergrid.blocks.RemulaGrinder;
import co.uk.silvania.Remula.powergrid.blocks.RemulaHighStorageUnit;
import co.uk.silvania.Remula.powergrid.blocks.RemulaReactorCore;
import co.uk.silvania.Remula.powergrid.blocks.RemulaSimpleGenerator;
import co.uk.silvania.Remula.powergrid.blocks.RemulaSimpleSolarPanel;
import co.uk.silvania.Remula.powergrid.blocks.RemulaSimpleStorageUnit;
import co.uk.silvania.Remula.powergrid.blocks.RemulaThermalGenerator;
import co.uk.silvania.Remula.powergrid.items.AdvancedPRSU;
import co.uk.silvania.Remula.powergrid.items.HighBattery;
import co.uk.silvania.Remula.powergrid.items.MidBattery;
import co.uk.silvania.Remula.powergrid.items.MidPRSU;
import co.uk.silvania.Remula.powergrid.items.SimpleBattery;
import co.uk.silvania.Remula.powergrid.items.SimplePRSU;
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
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@Mod(modid="Remula", name="Remula", version="0.0.1")
@NetworkMod(clientSideRequired=true, serverSideRequired=false)
public class Remula { 
	
	public static CreativeTabs tabRemula = new CreativeTabs("tabRemula") {
		public ItemStack getIconItemStack() {
				return new ItemStack(Remula.advancedRemulaChip, 1, 0);
			}
	};
	
    @Instance("Remula")
    public static Remula instance;

    // Says where the client and server proxy code is loaded.
    @SidedProxy(clientSide="co.uk.silvania.Remula.client.ClientProxy", serverSide="co.uk.silvania.Remula.CommonProxy")
    public static CommonProxy proxy;
    public static int akatoeDimension = 20;
    
    //public static int blockRemulaID;
    @SideOnly(Side.CLIENT)

    @PreInit
    public void preInit(FMLPreInitializationEvent event) {
    	NetworkRegistry.instance().registerGuiHandler(this,  this.proxy);
    	instance = this;    	
    }
    //Blocks (IDs 1800-2000 to avoid clash with top 100 mods)
    public final static Block silvaniteOre = new SilvaniteOre(1800, 0).setBlockName("silvaniteOre");
    public final static Block merciliteOre = new MerciliteOre(1801, 1).setBlockName("merciliteOre");
    public final static Block remulaOre = new RemulaOre(1802, 2).setBlockName("remulaOre");
    public final static Block copperOre = new CopperOre(1803, 3).setBlockName("copperOre");
    public final static Block tinOre = new TinOre(1804, 4).setBlockName("tinOre");
    public final static Block zincOre = new ZincOre(1805, 5).setBlockName("zincOre");
    public final static Block silverOre = new SilverOre(1806, 6).setBlockName("silverOre");
    public final static Block rubberLog = new RubberLog(1807, Material.wood).setBlockName("rubberLog");
    public final static Block rubberSapling = new RubberSapling(1808, 9).setBlockName("rubberSapling");
    public final static Block rubberLeaves = new RubberLeaves(1809, 10).setBlockName("rubberLeaves");
    public final static Block remulaLiquidizer = new RemulaLiquidizer(1810, Material.iron).setBlockName("remulaLiquidizer");
    public final static Block remulaCraftingTable = new RemulaCraftingTable(1811, Material.iron).setBlockName("remulaCraftingTable");
    public final static Block remulaBasicStorageUnit = new RemulaBasicStorageUnit(1812, Material.iron).setBlockName("remulaStorageUnit");
    public final static Block remulaSimpleStorageUnit = new RemulaSimpleStorageUnit(1813, Material.iron).setBlockName("remulaSimpleStorageUnit");
    //public final static Block remulaMidStorageUnit = new RemulaMidStorageUnit(1814, Material.iron).setBlockName("remulaMidStorageUnit");
    public final static Block remulaHighStorageUnit = new RemulaHighStorageUnit(1815, Material.iron).setBlockName("remulaHighStorageUnit");
    public final static Block remulaExcessiveStorageUnit = new RemulaExcessiveStorageUnit(1816, Material.iron).setBlockName("remulaExcessiveStorageUnit");
    public final static Block remulaExperimentalStorageUnit = new RemulaExperimentalStorageUnit(1817, Material.iron).setBlockName("remulaExperimentalStorageUnit");
    public final static Block remulaSimpleGenerator = new RemulaSimpleGenerator(1818, Material.iron).setBlockName("remulaSimpleGenerator");
    //public final static Block remulaMidGenerator = new RemulaMidGenerator(1819, Material.iron).setBlockName("remulaMidGenerator");
    public final static Block remulaAdvancedGenerator = new RemulaAdvancedGenerator(1820, Material.iron).setBlockName("remulaAdvancedGenerator");
    public final static Block remulaSimpleSolarPanel = new RemulaSimpleSolarPanel(1821, Material.iron).setBlockName("remulaSimpleSolarPanel");
    //public final static Block remulaMidSolarPanel = new RemulaMidSolarPanel(1822, Material.iron).setBlockName("remulaMidSolarPanel");
    public final static Block remulaAdvancedSolarPanel = new RemulaAdvancedSolarPanel(1823, Material.iron).setBlockName("remulaAdvancedSolarPanel");
    public final static Block remulaThermalGenerator = new RemulaThermalGenerator(1824, Material.iron).setBlockName("remulaThermalGenerator");
    public final static Block remulaGrinder = new RemulaGrinder(1825, Material.iron).setBlockName("remulaGrinder");
    public final static Block remulaReactorCore = new RemulaReactorCore(1826, Material.iron).setBlockName("remulaReactorCore");
    //Reactor Part 1827
    //Reactor Part 1828
    //Reactor Part 1829
    //Reactor Part 1830
    public final static Block silvaniteChest = new SilvaniteChest(1850).setBlockName("silvaniteChest");
    public final static Block merciliteChest = new MerciliteChest(1851).setBlockName("merciliteChest");
    public final static Block remulaChest = new RemulaChest(1852).setBlockName("remulaChest");
    
    public final static Block akatoePortal = new AkatoePortalBlock(1900, 48).setBlockName("akatoePortal");
    public final static Block akatoeStone = new AkatoeStone(1901, 0, Material.rock).setBlockName("akatoeStone");
    public final static Block akatoeCobble = new AkatoeCobble(1902, 1, Material.rock).setBlockName("akatoeCobble");
    public final static Block akatoeGrass = new AkatoeGrass(1903).setBlockName("akatoeGrass");
    public final static Block akatoeDirt = new AkatoeDirt(1904, 2, Material.ground).setBlockName("akatoeGround");
    public final static Block akatoeSand = new AkatoeSand(1905, 49, Material.sand).setBlockName("akatoeSand");
    public final static Block akatoeRefinedStone = new AkatoeRefinedStone(1906, 16, Material.rock).setBlockName("akatoeRefinedStone");
    public final static Block akatoeBricks = new AkatoeBricks(1907, 17, Material.rock).setBlockName("akatoeBricks");
    public final static Block akatoeLargeBricks = new AkatoeLargeBricks(1908, 18, Material.rock).setBlockName("akatoeBricks");
    public final static Block akatoeDecorBricks = new AkatoeDecorBricks(1909, 19, Material.rock).setBlockName("akatoeDecorBricks");
    public final static Block akatoeCoal = new AkatoeCoal(1910, 32).setBlockName("akatoeCoal");
    public final static Block akatoeIron = new AkatoeIron(1911, 33).setBlockName("akatoeIron");
    public final static Block akatoeGold = new AkatoeGold(1912, 34).setBlockName("akatoeGold");
    public final static Block akatoeCopper = new AkatoeCopper(1913, 35).setBlockName("akatoeCopper");
    public final static Block akatoeTin = new AkatoeTin(1914, 36).setBlockName("akatoeTin");
    public final static Block akatoeLapis = new AkatoeLapis(1915, 37).setBlockName("akatoeLapis");
    public final static Block poriniteOre = new PoriniteOre(1916, 38).setBlockName("poriniteOre");
    //Ore 2
    public final static Block akatoeTilledDirt = new AkatoeTilledDirt(1919).setBlockName("akatoeTilledDirt");
    public final static Block porinCrop = new PorinCrop(1920).setBlockName("porinCrop");
    
    //Liquids
    //Silvanite
    //Mercilite
    //Remula
    //Redstone
    //Lapis
    
    //Items (IDs 17000 - 17300)
    public final static Item emptyCell = new EmptyCell(17000).setItemName("emptyCell");
	public final static Item silvaniteDust = new SilvaniteDust(17001).setItemName("silvaniteDust");
	public final static Item silvaniteIngot = new SilvaniteIngot(17002).setItemName("silvaniteIngot");
	//public final static Item silvaniteBucket = new SilvaniteBucket(17003).setItemName("silvaniteBucket");
	public final static Item silvaniteCell = new SilvaniteCell(17004).setItemName("silvaniteCell");
	public final static Item merciliteDust = new MerciliteDust(17005).setItemName("merciliteDust");
	public final static Item merciliteIngot = new MerciliteIngot(17006).setItemName("merciliteIngot");
	//public final static Item merciliteBucket = new MerciliteBucket(17007).setItemName("merciliteBucket");
	public final static Item merciliteCell = new MerciliteCell(17008).setItemName("merciliteCell");
	public final static Item remulaDust = new RemulaDust(17009).setItemName("remulaDust");
	public final static Item remulaIngot = new RemulaIngot(17010).setItemName("remulaIngot");
	public final static Item remulaCell = new RemulaCell(17011).setItemName("remulaCell");
	public final static Item simpleBattery = new SimpleBattery(17012).setItemName("simpleBattery");
	public final static Item midBattery = new MidBattery(17013).setItemName("midBattery");
	public final static Item highBattery = new HighBattery(17014).setItemName("highBattery");
	public final static Item simplePRSU = new SimplePRSU(17015).setItemName("simpleRSU");
	public final static Item midPRSU = new MidPRSU(17016).setItemName("midRSU");
	public final static Item advancedPRSU = new AdvancedPRSU(17017).setItemName("advancedRSU");
	public final static Item simpleSilvaniteChip = new SimpleSilvaniteChip(17018).setItemName("simpleSilvaniteChip");
	//public final static Item midSilvaniteChip = new MidSilvaniteChip(17019).setItemName("midSilvaniteChip");
	public final static Item advancedSilvaniteChip = new AdvancedSilvaniteChip(17020).setItemName("advancedSilvaniteChip");
	public final static Item simpleMerciliteChip = new SimpleMerciliteChip(17021).setItemName("simpleMerciliteChip");
	//public final static Item midMerciliteChip = new MidMerciliteChip(17022).setItemName("midMerciliteChip");
	public final static Item advancedMerciliteChip = new AdvancedMerciliteChip(17023).setItemName("advancedMercilieChip");
	public final static Item simpleRemulaChip = new SimpleRemulaChip(17024).setItemName("simpleRemulaChip");
	//public final static Item midRemulaChip = new MidRemulaChip(17025).setItemName("midRemulaChip")
	public final static Item advancedRemulaChip = new AdvancedRemulaChip(17026).setItemName("advancedRemulaChip");
	//public final static Item remDrill = new RemDrill(17027).setItemName("remDrill");
	public final static Item drillTransformerUpgrade = new DrillTransformerUpgrade(17028).setItemName("drillTransformerUpgrade");
	public final static Item drillSilkTouchUpgrade = new DrillSilkTouchUpgrade(17029).setItemName("drillSilkTouchUpgrade");
	public final static Item drillSpeedControlUpgrade = new DrillSpeedControlUpgrade(17030).setItemName("drillSpeedControlUpgrade");
	public final static Item drillBatteryUpgrade = new DrillBatteryUpgrade(17031).setItemName("drillBatteryUpgrade");
	public final static Item simpleP1RobotSpawner = new SimpleP1RobotSpawner(17034).setItemName("simpleP1RobotSpawner");
	public final static Item midP1RobotSpawner = new MidP1RobotSpawner(17035).setItemName("midP1RobotSpawner");
	public final static Item advancedP1RobotSpawner = new AdvancedP1RobotSpawner(17036).setItemName("advancedP1RobotSpawner");
	public final static Item simpleP3RobotSpawner = new SimpleP3RobotSpawner(17037).setItemName("simpleP3RobotSpawner");
	public final static Item midP3RobotSpawner = new MidP3RobotSpawner(17038).setItemName("midP3RobotSpawner");
	public final static Item advancedP3RobotSpawner = new AdvancedP3RobotSpawner(17039).setItemName("advancedP3RobotSpawner");
	public final static Item simpleP5RobotSpawner = new SimpleP5RobotSpawner(17037).setItemName("simpleP5RobotSpawner");
	public final static Item midP5RobotSpawner = new MidP5RobotSpawner(17038).setItemName("midP5RobotSpawner");
	public final static Item advancedP5RobotSpawner = new AdvancedP5RobotSpawner(17039).setItemName("advancedP5RobotSpawner");
	public final static Item simpleP7RobotSpawner = new SimpleP7RobotSpawner(17037).setItemName("simpleP7RobotSpawner");
	public final static Item midP7RobotSpawner = new MidP7RobotSpawner(17038).setItemName("midP7RobotSpawner");
	public final static Item advancedP7RobotSpawner = new AdvancedP7RobotSpawner(17039).setItemName("advancedP7RobotSpawner");
	public final static Item simpleP9RobotSpawner = new SimpleP9RobotSpawner(17037).setItemName("simpleP9RobotSpawner");
	public final static Item midP9RobotSpawner = new MidP9RobotSpawner(17038).setItemName("midP9RobotSpawner");
	public final static Item advancedP9RobotSpawner = new AdvancedP9RobotSpawner(17039).setItemName("advancedP9RobotSpawner");
	//TODO find a decent plant tutorial o.O
	public final static Item porinSeeds = new PorinSeeds(17040, porinCrop.blockID, akatoeTilledDirt.blockID).setItemName("porinSeeds");
	public final static Item porinFruit = new PorinFruit(17041).setItemName("porinFruit");
	//InfusionUpgrade
	//StorageUpgrade
	//SpeedUpgrade
	//StrengthUpgrade
	//CCUpgrade?
    
	
	//And finally the worldgen
	public static WorldGen worldGen = new WorldGen();
	
    @Init
    public void load(FMLInitializationEvent event) {
            proxy.registerRenderThings();
            proxy.init();
            
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
            
            //Register names for blocks
            //Ores
            LanguageRegistry.addName(silvaniteOre, "Silvanite Ore");
            LanguageRegistry.addName(merciliteOre, "Mercilite Ore");
            LanguageRegistry.addName(remulaOre, "Remula Ore");
            LanguageRegistry.addName(copperOre, "Copper Ore");
            LanguageRegistry.addName(tinOre, "Tin Ore");
            LanguageRegistry.addName(zincOre, "Zinc Ore");
            LanguageRegistry.addName(silverOre, "Silver Ore");
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
            LanguageRegistry.addName(remulaSimpleGenerator, "Simple Generator");
            //LanguageRegistry.addName(remulaMidGenerator, "Mid Generator");
            LanguageRegistry.addName(remulaAdvancedGenerator, "Advanced Generator");
            LanguageRegistry.addName(remulaSimpleSolarPanel, "Simple Solar Panel");
            //LanguageRegistry.addName(remulaMidSolarPanel, "Mid Solar Panel");
            LanguageRegistry.addName(remulaAdvancedSolarPanel, "Advanced Solar Panel");
            LanguageRegistry.addName(remulaThermalGenerator, "Thermal Generator");
            LanguageRegistry.addName(remulaGrinder, "Grinder");
            LanguageRegistry.addName(remulaReactorCore, "Reactor Core");
            
            //Nature and Plant Stuff
            LanguageRegistry.addName(porinCrop, "Porin Crop");
            
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
            LanguageRegistry.addName(akatoeCoal, "Akatonian Coal Ore");
            LanguageRegistry.addName(akatoeIron, "Akatonian Iron Ore");
            LanguageRegistry.addName(akatoeGold, "Akationian Gold Ore");
            LanguageRegistry.addName(akatoeCopper, "Akatonian Copper Ore");
            LanguageRegistry.addName(akatoeTin, "Akatonian Tin Ore");
            LanguageRegistry.addName(akatoeLapis, "Akatonian Lapis Lazuli Ore");
            LanguageRegistry.addName(akatoeTilledDirt, "Akatonian Tilled Dirt");
            
            //Register Blocks
            //Ores
            GameRegistry.registerBlock(remulaOre, "remulaOre");
            GameRegistry.registerBlock(merciliteOre, "merciliteOre");
            GameRegistry.registerBlock(silvaniteOre, "silvaniteOre");
            GameRegistry.registerBlock(copperOre, "copperOre");
            GameRegistry.registerBlock(tinOre, "tinOre");
            GameRegistry.registerBlock(zincOre, "zincOre");
            GameRegistry.registerBlock(silverOre, "silverOre");
            GameRegistry.registerBlock(rubberLog, "rubberLog");
            GameRegistry.registerBlock(rubberLeaves, "rubberLeaves");
            GameRegistry.registerBlock(rubberSapling, "rubberSapling");
            
            //Plants and Nature
            GameRegistry.registerBlock(porinCrop, "porinCrop");
            
            //Powergrid
            GameRegistry.registerBlock(remulaBasicStorageUnit, "remulaBasicStorageUnit");
            GameRegistry.registerBlock(remulaSimpleStorageUnit, "remulaSimpleStorageUnit");
            //GameRegistry.registerBlock(remulaMidStorageUnit, "remulaMidStorageUnit");
            GameRegistry.registerBlock(remulaHighStorageUnit, "remulaHighStorageUnit");
            GameRegistry.registerBlock(remulaExcessiveStorageUnit, "remulaExcessiveStorageUnit");
            GameRegistry.registerBlock(remulaExperimentalStorageUnit, "remulaExperimentalStorageUnit");
            GameRegistry.registerBlock(remulaSimpleGenerator, "remulaSimpleGenerator");
            //GameRegistry.registerBlock(remulaMidGenerator, "remulaMidGenerator");
            GameRegistry.registerBlock(remulaAdvancedGenerator, "remulaAdvancedGenerator");
            GameRegistry.registerBlock(remulaSimpleSolarPanel, "remulaSimpleSolarPanel");
            //GameRegistry.registerBlock(remulaMidSolarPanel, "remulaMidSolarPanel");
            GameRegistry.registerBlock(remulaAdvancedSolarPanel, "remulaAdvancedSolarPanel");
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
            GameRegistry.registerBlock(akatoeCobble, "akatoeCobble");
            GameRegistry.registerBlock(akatoeGrass, "akatoeGrass");
            GameRegistry.registerBlock(akatoeDirt, "akatoeDirt");
            GameRegistry.registerBlock(akatoeSand, "akatoeSand");
            GameRegistry.registerBlock(akatoeRefinedStone, "akatoeRefinedStone");
            GameRegistry.registerBlock(akatoeBricks, "akatoeBricks");
            GameRegistry.registerBlock(akatoeLargeBricks, "akatoeLargeBricks");
            GameRegistry.registerBlock(akatoeDecorBricks, "akatoeDecorBricks");
            GameRegistry.registerBlock(akatoeCoal, "akatoeCoal");
            GameRegistry.registerBlock(akatoeIron, "akatoeIron");
            GameRegistry.registerBlock(akatoeGold, "akatoeGold");
            GameRegistry.registerBlock(akatoeCopper, "akatoeCopper");
            GameRegistry.registerBlock(akatoeTin, "akatoeTin");
            GameRegistry.registerBlock(akatoeLapis, "akatoeLapis");
            GameRegistry.registerBlock(akatoeTilledDirt, "akatoeTilledDirt");
            
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
            
            //Power Grid
            GameRegistry.registerItem(simpleBattery, "simpleBattery");
            GameRegistry.registerItem(midBattery, "medBattery");
            GameRegistry.registerItem(highBattery, "highBattery");
            GameRegistry.registerItem(simplePRSU, "simplePRSU");
            GameRegistry.registerItem(midPRSU, "midPRSU");
            GameRegistry.registerItem(advancedPRSU, "advancedPRSU");
            
            //Other Registry Stuff
            LanguageRegistry.instance().addStringLocalization("itemGroup.tabRemula", "en_US", "Remula");
            DimensionManager.registerProviderType(akatoeDimension, AkatoeWorldProvider.class, false);
            DimensionManager.registerDimension(akatoeDimension, akatoeDimension);
            GameRegistry.registerWorldGenerator(new WorldGen());
            NetworkRegistry.instance().registerGuiHandler(this, new SilvaniteGuiHandler());
            NetworkRegistry.instance().registerGuiHandler(this, new RemulaGuiHandler());
    }


	@PostInit
    public void postInit(FMLPostInitializationEvent event) {
            // Stub Method
    		}
	};

