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
import co.uk.silvania.Remula.blocks.CopperOre;
import co.uk.silvania.Remula.blocks.MerciliteOre;
import co.uk.silvania.Remula.blocks.RemulaAdvancedGenerator;
import co.uk.silvania.Remula.blocks.RemulaAdvancedSolarPanel;
import co.uk.silvania.Remula.blocks.RemulaCraftingTable;
import co.uk.silvania.Remula.blocks.RemulaExcessiveStorageUnit;
import co.uk.silvania.Remula.blocks.RemulaExperimentalStorageUnit;
import co.uk.silvania.Remula.blocks.RemulaGrinder;
import co.uk.silvania.Remula.blocks.RemulaHighStorageUnit;
import co.uk.silvania.Remula.blocks.RemulaLiquidizer;
import co.uk.silvania.Remula.blocks.RemulaOre;
import co.uk.silvania.Remula.blocks.RemulaBasicStorageUnit;
import co.uk.silvania.Remula.blocks.RemulaReactorCore;
import co.uk.silvania.Remula.blocks.RemulaSimpleGenerator;
import co.uk.silvania.Remula.blocks.RemulaSimpleSolarPanel;
import co.uk.silvania.Remula.blocks.RemulaSimpleStorageUnit;
import co.uk.silvania.Remula.blocks.RemulaThermalGenerator;
import co.uk.silvania.Remula.blocks.RubberLeaves;
import co.uk.silvania.Remula.blocks.RubberLog;
import co.uk.silvania.Remula.blocks.RubberSapling;
import co.uk.silvania.Remula.blocks.SilvaniteOre;
import co.uk.silvania.Remula.blocks.SilverOre;
import co.uk.silvania.Remula.blocks.TinOre;
import co.uk.silvania.Remula.blocks.ZincOre;
import co.uk.silvania.Remula.dimensions.AkatoePortalBlock;
import co.uk.silvania.Remula.dimensions.AkatoeWorldProvider;
import co.uk.silvania.Remula.dimensions.akatoe.AkatoeCobble;
import co.uk.silvania.Remula.dimensions.akatoe.AkatoeDirt;
import co.uk.silvania.Remula.dimensions.akatoe.AkatoeGrass;
import co.uk.silvania.Remula.dimensions.akatoe.AkatoeSand;
import co.uk.silvania.Remula.dimensions.akatoe.AkatoeStone;
import co.uk.silvania.Remula.entity.SilvaniteChest;
import co.uk.silvania.Remula.items.AdvancedRemulaChip;
import co.uk.silvania.Remula.items.EmptyCell;
import co.uk.silvania.Remula.items.MerciliteDust;
import co.uk.silvania.Remula.items.MidRobotSpawner;
import co.uk.silvania.Remula.items.RemulaDust;
import co.uk.silvania.Remula.items.RemulaIngot;
import co.uk.silvania.Remula.items.AdvancedRobotSpawner;
import co.uk.silvania.Remula.items.SilvaniteDust;
import co.uk.silvania.Remula.items.SimpleRobotSpawner;
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
    
    public final static Block akatoePortal = new AkatoePortalBlock(1900, 48).setBlockName("akatoePortal");
    public final static Block akatoeStone = new AkatoeStone(1901, 0, Material.rock).setBlockName("akatoeStone");
    public final static Block akatoeCobble = new AkatoeCobble(1902, 1, Material.rock).setBlockName("akatoeCobble");
    public final static Block akatoeGrass = new AkatoeGrass(1903).setBlockName("akatoeGrass");
    public final static Block akatoeDirt = new AkatoeDirt(1904, 2, Material.ground).setBlockName("akatoeGround");
    public final static Block akatoeSand = new AkatoeSand(1905, 47, Material.sand).setBlockName("akatoeSand");
    
    //Liquids
    //Silvanite Liquid
    //Mid Liquid
    //Remula Liquid
    //Redstone Liquid
    //Lapis
    
    //Items (IDs 17000 - 17300)
    public final static Item emptyCell = new EmptyCell(17000).setItemName("emptyCell");
	public final static Item silvaniteDust = new SilvaniteDust(17001).setItemName("silvaniteDust");
	//SilvaniteIngot
	//SilvaniteBucket
	//SilvaniteCell
	public final static Item merciliteDust = new MerciliteDust(17005).setItemName("merciliteDust");
	//MidIngot
	//MidBucket
	//MidCell
	public final static Item remulaDust = new RemulaDust(17009).setItemName("remulaDust");
	public final static Item remulaIngot = new RemulaIngot(17010).setItemName("remulaIngot");
	//RemulaCell
	//SimpleRemBattery
	//MidRemBattery
	//HighRemBattery
	//Alien1Battery1
	//Alien1Battery2
	//Alien1Battery3
	//Alien2Battery1
	//Alien2Battery2
	//Alien2Battery3
	//StandardPSU
	//AdvancedPSU
	//SupremePSU
	//SimpleSilvaniteChip
	//MidSilvaniteChip
	//AdvancedSilvaniteChip
	//SimpleMidChip
	//MidMidChip
	//AdvancedMidChip
	//SimpleRemulaChip
	//MidRemulaChip
	public final static Item advancedRemulaChip = new AdvancedRemulaChip(17032).setItemName("advancedRemulaChip");
	//RemDrill
	public final static Item simpleRobotSpawner = new SimpleRobotSpawner(17034).setItemName("simpleRobotSpawner");
	public final static Item midRobotSpawner = new MidRobotSpawner(17035).setItemName("midRobotSpawner");
	public final static Item advancedRobotSpawner = new AdvancedRobotSpawner(17036).setItemName("advancedRobotSpawner");
	
	//DrillTransformerUpgrade
	//DrillSilkTouchUpgrade
	//DrillSpeedControlUpgrade
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
            
            OreDictionary.registerOre("oreSilvanite", new ItemStack(silvaniteOre));
            OreDictionary.registerOre("oreMercilite", new ItemStack (merciliteOre));
            OreDictionary.registerOre("oreRemula", new ItemStack (remulaOre));
            OreDictionary.registerOre("oreCopper", new ItemStack (copperOre));
            OreDictionary.registerOre("oreTin", new ItemStack (tinOre));
            OreDictionary.registerOre("oreZinc", new ItemStack (zincOre));
            OreDictionary.registerOre("oreSilver", new ItemStack (silverOre));
            OreDictionary.registerOre("woodRubber", new ItemStack (rubberLog));
            
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
            
            LanguageRegistry.addName(remulaLiquidizer, "Liquid Refinery");
            LanguageRegistry.addName(remulaCraftingTable, "Liquid Infusion Station");
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
            
            LanguageRegistry.addName(silvaniteChest, "Silvanite Chest");
            
            LanguageRegistry.addName(akatoePortal, "Akatoe Portal");
            LanguageRegistry.addName(akatoeStone, "Akatonian Stone");
            LanguageRegistry.addName(akatoeCobble, "Akatonian Cobble");
            LanguageRegistry.addName(akatoeGrass, "Akatonian Grass");
            LanguageRegistry.addName(akatoeDirt, "Akatonian Dirt");
            LanguageRegistry.addName(akatoeSand, "Akatonian Sand");
                        
            
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
            
            GameRegistry.registerBlock(remulaLiquidizer, "remulaLiquidizer");
            GameRegistry.registerBlock(remulaCraftingTable, "remulaCraftingTable");
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
            
            GameRegistry.registerBlock(silvaniteChest, "silvaniteChest");
            
            GameRegistry.registerBlock(akatoePortal, "AkatoePortal");
            GameRegistry.registerBlock(akatoeStone, "akatoeStone");
            GameRegistry.registerBlock(akatoeCobble, "akatoeCobble");
            GameRegistry.registerBlock(akatoeGrass, "akatoeGrass");
            GameRegistry.registerBlock(akatoeDirt, "akatoeDirt");
            GameRegistry.registerBlock(akatoeSand, "akatoeSand");
            
            MinecraftForge.setBlockHarvestLevel(silvaniteOre, "pickaxe", 1);
            MinecraftForge.setBlockHarvestLevel(merciliteOre, "pickaxe", 2);
            MinecraftForge.setBlockHarvestLevel(remulaOre, "pickaxe", 3);
            
            
            //Items
            LanguageRegistry.addName(advancedRemulaChip, "Advanced Remula Chip");
            LanguageRegistry.addName(merciliteDust, "Mercilite Dust");
            LanguageRegistry.addName(remulaDust, "Remula Dust");
            LanguageRegistry.addName(remulaIngot, "Remula Ingot");
            LanguageRegistry.addName(advancedRobotSpawner, "Flendroid 5000");
            LanguageRegistry.addName(silvaniteDust, "Silvanite Dust");
            LanguageRegistry.addName(emptyCell, "Empty Storage Cell");
            LanguageRegistry.addName(simpleRobotSpawner, "Helper Droid");
            LanguageRegistry.addName(midRobotSpawner, "Powerdroid 1000");
            
            GameRegistry.registerItem(advancedRemulaChip, "advancedRemulaChip");
            GameRegistry.registerItem(merciliteDust, "mercliteDust");
            GameRegistry.registerItem(remulaDust, "remulaDust");
            GameRegistry.registerItem(remulaIngot, "remulaIngot");
            GameRegistry.registerItem(advancedRobotSpawner, "robotSpawner");
            GameRegistry.registerItem(silvaniteDust, "silvaniteDust");
            GameRegistry.registerItem(emptyCell, "emptyCell");
            GameRegistry.registerItem(simpleRobotSpawner, "simpleRobotSpawner");
            GameRegistry.registerItem(midRobotSpawner, "midRobotSpawner");
            
            
            //Other
            LanguageRegistry.instance().addStringLocalization("itemGroup.tabRemula", "en_US", "Remula");
            DimensionManager.registerProviderType(akatoeDimension, AkatoeWorldProvider.class, false);
            DimensionManager.registerDimension(akatoeDimension, akatoeDimension);
            GameRegistry.registerWorldGenerator(new WorldGen());
    }


	@PostInit
    public void postInit(FMLPostInitializationEvent event) {
            // Stub Method
    		}
	};

