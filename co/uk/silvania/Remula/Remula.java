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
import co.uk.silvania.Remula.dimensions.akatoe.blocks.AkatoeBricks;
import co.uk.silvania.Remula.dimensions.akatoe.blocks.AkatoeCobble;
import co.uk.silvania.Remula.dimensions.akatoe.blocks.AkatoeDecorBricks;
import co.uk.silvania.Remula.dimensions.akatoe.blocks.AkatoeDirt;
import co.uk.silvania.Remula.dimensions.akatoe.blocks.AkatoeGrass;
import co.uk.silvania.Remula.dimensions.akatoe.blocks.AkatoeLargeBricks;
import co.uk.silvania.Remula.dimensions.akatoe.blocks.AkatoeRefinedStone;
import co.uk.silvania.Remula.dimensions.akatoe.blocks.AkatoeSand;
import co.uk.silvania.Remula.dimensions.akatoe.blocks.AkatoeStone;
import co.uk.silvania.Remula.dimensions.akatoe.blocks.AkatoeTilledDirt;
import co.uk.silvania.Remula.dimensions.akatoe.blocks.BoskinCrop;
import co.uk.silvania.Remula.dimensions.akatoe.blocks.CirCrop;
import co.uk.silvania.Remula.dimensions.akatoe.blocks.PlantFuxii;
import co.uk.silvania.Remula.dimensions.akatoe.blocks.PorinCrop;
import co.uk.silvania.Remula.dimensions.akatoe.blocks.UlinCrop;
import co.uk.silvania.Remula.dimensions.akatoe.items.AkatiteCell;
import co.uk.silvania.Remula.dimensions.akatoe.items.AkatiteDust;
import co.uk.silvania.Remula.dimensions.akatoe.items.AkatiteIngot;
import co.uk.silvania.Remula.dimensions.akatoe.items.BoskinSeeds;
import co.uk.silvania.Remula.dimensions.akatoe.items.CirSeeds;
import co.uk.silvania.Remula.dimensions.akatoe.items.CookedGarfinMeat;
import co.uk.silvania.Remula.dimensions.akatoe.items.CookedGlogMeat;
import co.uk.silvania.Remula.dimensions.akatoe.items.CookedHermustMeat;
import co.uk.silvania.Remula.dimensions.akatoe.items.CookedLignisMeat;
import co.uk.silvania.Remula.dimensions.akatoe.items.CookedSkitterlingStick;
import co.uk.silvania.Remula.dimensions.akatoe.items.ItemBoskin;
import co.uk.silvania.Remula.dimensions.akatoe.items.ItemCir;
import co.uk.silvania.Remula.dimensions.akatoe.items.PilkCell;
import co.uk.silvania.Remula.dimensions.akatoe.items.PilkDust;
import co.uk.silvania.Remula.dimensions.akatoe.items.PilkIngot;
import co.uk.silvania.Remula.dimensions.akatoe.items.PorinFruit;
import co.uk.silvania.Remula.dimensions.akatoe.items.PorinSeeds;
import co.uk.silvania.Remula.dimensions.akatoe.items.PoriniteCell;
import co.uk.silvania.Remula.dimensions.akatoe.items.PoriniteDust;
import co.uk.silvania.Remula.dimensions.akatoe.items.PoriniteIngot;
import co.uk.silvania.Remula.dimensions.akatoe.items.RawGarfinMeat;
import co.uk.silvania.Remula.dimensions.akatoe.items.RawGlogMeat;
import co.uk.silvania.Remula.dimensions.akatoe.items.RawHermustMeat;
import co.uk.silvania.Remula.dimensions.akatoe.items.RawLignisMeat;
import co.uk.silvania.Remula.dimensions.akatoe.items.RawSkitterlingStick;
import co.uk.silvania.Remula.dimensions.akatoe.items.SkitterlingDead;
import co.uk.silvania.Remula.dimensions.akatoe.items.SkitterlingItem;
import co.uk.silvania.Remula.dimensions.akatoe.items.UlinFruit;
import co.uk.silvania.Remula.dimensions.akatoe.items.UlinSeeds;
import co.uk.silvania.Remula.dimensions.akatoe.ores.AkatiteOre;
import co.uk.silvania.Remula.dimensions.akatoe.ores.AkatoeCoal;
import co.uk.silvania.Remula.dimensions.akatoe.ores.AkatoeCopper;
import co.uk.silvania.Remula.dimensions.akatoe.ores.AkatoeGold;
import co.uk.silvania.Remula.dimensions.akatoe.ores.AkatoeIron;
import co.uk.silvania.Remula.dimensions.akatoe.ores.AkatoeLapis;
import co.uk.silvania.Remula.dimensions.akatoe.ores.AkatoeRemulaOre;
import co.uk.silvania.Remula.dimensions.akatoe.ores.AkatoeTin;
import co.uk.silvania.Remula.dimensions.akatoe.ores.PilkOre;
import co.uk.silvania.Remula.dimensions.akatoe.ores.PoriniteOre;
import co.uk.silvania.Remula.dimensions.baloinus.BaloinusPortalBlock;
import co.uk.silvania.Remula.dimensions.baloinus.BaloinusWorldProvider;
import co.uk.silvania.Remula.dimensions.baloinus.BiomeBaloinusPlains;
import co.uk.silvania.Remula.dimensions.baloinus.blocks.BaloinusBricks;
import co.uk.silvania.Remula.dimensions.baloinus.blocks.BaloinusCoalOre;
import co.uk.silvania.Remula.dimensions.baloinus.blocks.BaloinusCobblestone;
import co.uk.silvania.Remula.dimensions.baloinus.blocks.BaloinusCopperOre;
import co.uk.silvania.Remula.dimensions.baloinus.blocks.BaloinusIronOre;
import co.uk.silvania.Remula.dimensions.baloinus.blocks.BaloinusPilkOre;
import co.uk.silvania.Remula.dimensions.baloinus.blocks.BaloinusPoriniteOre;
import co.uk.silvania.Remula.dimensions.baloinus.blocks.BaloinusRefinedStone;
import co.uk.silvania.Remula.dimensions.baloinus.blocks.BaloinusRemulaOre;
import co.uk.silvania.Remula.dimensions.baloinus.blocks.BaloinusSmallBricks;
import co.uk.silvania.Remula.dimensions.baloinus.blocks.BaloinusStone;
import co.uk.silvania.Remula.dimensions.baloinus.blocks.BaloinusTinOre;
import co.uk.silvania.Remula.dimensions.baloinus.blocks.BaloinusTritaniteOre;
import co.uk.silvania.Remula.dimensions.baloinus.blocks.BalumOre;
import co.uk.silvania.Remula.dimensions.deepspace.DeepSpacePortalBlock;
import co.uk.silvania.Remula.dimensions.deepspace.DeepSpaceWorldProvider;
import co.uk.silvania.Remula.dimensions.deepspace.blocks.BrownAsteroidBoriaOre;
import co.uk.silvania.Remula.dimensions.deepspace.blocks.BrownAsteroidBricks;
import co.uk.silvania.Remula.dimensions.deepspace.blocks.BrownAsteroidCopperOre;
import co.uk.silvania.Remula.dimensions.deepspace.blocks.BrownAsteroidDragiteOre;
import co.uk.silvania.Remula.dimensions.deepspace.blocks.BrownAsteroidFariteOre;
import co.uk.silvania.Remula.dimensions.deepspace.blocks.BrownAsteroidFarithiumOre;
import co.uk.silvania.Remula.dimensions.deepspace.blocks.BrownAsteroidHeriOre;
import co.uk.silvania.Remula.dimensions.deepspace.blocks.BrownAsteroidIronOre;
import co.uk.silvania.Remula.dimensions.deepspace.blocks.BrownAsteroidPoriniteOre;
import co.uk.silvania.Remula.dimensions.deepspace.blocks.BrownAsteroidRubble;
import co.uk.silvania.Remula.dimensions.deepspace.blocks.BrownAsteroidSilvaniteOre;
import co.uk.silvania.Remula.dimensions.deepspace.blocks.BrownAsteroidSirianOre;
import co.uk.silvania.Remula.dimensions.deepspace.blocks.BrownAsteroidSmallBricks;
import co.uk.silvania.Remula.dimensions.deepspace.blocks.BrownAsteroidThoriOre;
import co.uk.silvania.Remula.dimensions.deepspace.blocks.BrownAsteroidTinOre;
import co.uk.silvania.Remula.dimensions.deepspace.blocks.BrownAsteroidVentiiumOre;
import co.uk.silvania.Remula.dimensions.deepspace.blocks.BrownAsteroidZincOre;
import co.uk.silvania.Remula.dimensions.deepspace.blocks.DeepSpaceBrownAsteroidRock;
import co.uk.silvania.Remula.dimensions.deepspace.blocks.DeepSpaceWhiteAsteroidRock;
import co.uk.silvania.Remula.dimensions.deepspace.blocks.WhiteAsteroidBoriaOre;
import co.uk.silvania.Remula.dimensions.deepspace.blocks.WhiteAsteroidBricks;
import co.uk.silvania.Remula.dimensions.deepspace.blocks.WhiteAsteroidCopperOre;
import co.uk.silvania.Remula.dimensions.deepspace.blocks.WhiteAsteroidDragiteOre;
import co.uk.silvania.Remula.dimensions.deepspace.blocks.WhiteAsteroidFariteOre;
import co.uk.silvania.Remula.dimensions.deepspace.blocks.WhiteAsteroidFarithiumOre;
import co.uk.silvania.Remula.dimensions.deepspace.blocks.WhiteAsteroidHeriOre;
import co.uk.silvania.Remula.dimensions.deepspace.blocks.WhiteAsteroidIronOre;
import co.uk.silvania.Remula.dimensions.deepspace.blocks.WhiteAsteroidPoriniteOre;
import co.uk.silvania.Remula.dimensions.deepspace.blocks.WhiteAsteroidRubble;
import co.uk.silvania.Remula.dimensions.deepspace.blocks.WhiteAsteroidSilvaniteOre;
import co.uk.silvania.Remula.dimensions.deepspace.blocks.WhiteAsteroidSirianOre;
import co.uk.silvania.Remula.dimensions.deepspace.blocks.WhiteAsteroidSmallBricks;
import co.uk.silvania.Remula.dimensions.deepspace.blocks.WhiteAsteroidThoriOre;
import co.uk.silvania.Remula.dimensions.deepspace.blocks.WhiteAsteroidTinOre;
import co.uk.silvania.Remula.dimensions.deepspace.blocks.WhiteAsteroidVentiiumOre;
import co.uk.silvania.Remula.dimensions.deepspace.blocks.WhiteAsteroidZincOre;
import co.uk.silvania.Remula.dimensions.elkost.BiomeElkostPlains;
import co.uk.silvania.Remula.dimensions.elkost.ElkostPortalBlock;
import co.uk.silvania.Remula.dimensions.elkost.ElkostWorldProvider;
import co.uk.silvania.Remula.dimensions.elkost.blocks.ElkostBoriaOre;
import co.uk.silvania.Remula.dimensions.elkost.blocks.ElkostBricks;
import co.uk.silvania.Remula.dimensions.elkost.blocks.ElkostCoalOre;
import co.uk.silvania.Remula.dimensions.elkost.blocks.ElkostCobblestone;
import co.uk.silvania.Remula.dimensions.elkost.blocks.ElkostCopperOre;
import co.uk.silvania.Remula.dimensions.elkost.blocks.ElkostGlass;
import co.uk.silvania.Remula.dimensions.elkost.blocks.ElkostGlassPane;
import co.uk.silvania.Remula.dimensions.elkost.blocks.ElkostGoldOre;
import co.uk.silvania.Remula.dimensions.elkost.blocks.ElkostGrinistOre;
import co.uk.silvania.Remula.dimensions.elkost.blocks.ElkostIronOre;
import co.uk.silvania.Remula.dimensions.elkost.blocks.ElkostLapisLazuliOre;
import co.uk.silvania.Remula.dimensions.elkost.blocks.ElkostRefinedStone;
import co.uk.silvania.Remula.dimensions.elkost.blocks.ElkostRemulaOre;
import co.uk.silvania.Remula.dimensions.elkost.blocks.ElkostSand;
import co.uk.silvania.Remula.dimensions.elkost.blocks.ElkostSmallBricks;
import co.uk.silvania.Remula.dimensions.elkost.blocks.ElkostStone;
import co.uk.silvania.Remula.dimensions.elkost.blocks.ElkostTinOre;
import co.uk.silvania.Remula.dimensions.elkost.blocks.ElkostTristaniumOre;
import co.uk.silvania.Remula.dimensions.elkost.blocks.ElkostTritaniteOre;
import co.uk.silvania.Remula.dimensions.elkost.blocks.ElkostZiriniumOre;
import co.uk.silvania.Remula.dimensions.elkost.blocks.ElkostiumOre;
import co.uk.silvania.Remula.dimensions.indiku.BiomeIndikuJungle;
import co.uk.silvania.Remula.dimensions.indiku.IndikuPortalBlock;
import co.uk.silvania.Remula.dimensions.indiku.IndikuWorldProvider;
import co.uk.silvania.Remula.dimensions.indiku.blocks.IndikiteOre;
import co.uk.silvania.Remula.dimensions.indiku.blocks.IndikuArithiumOre;
import co.uk.silvania.Remula.dimensions.indiku.blocks.IndikuBricks;
import co.uk.silvania.Remula.dimensions.indiku.blocks.IndikuCoalOre;
import co.uk.silvania.Remula.dimensions.indiku.blocks.IndikuCobblestone;
import co.uk.silvania.Remula.dimensions.indiku.blocks.IndikuCopperOre;
import co.uk.silvania.Remula.dimensions.indiku.blocks.IndikuDirt;
import co.uk.silvania.Remula.dimensions.indiku.blocks.IndikuGoldOre;
import co.uk.silvania.Remula.dimensions.indiku.blocks.IndikuGrass;
import co.uk.silvania.Remula.dimensions.indiku.blocks.IndikuIronOre;
import co.uk.silvania.Remula.dimensions.indiku.blocks.IndikuLapisLazuliOre;
import co.uk.silvania.Remula.dimensions.indiku.blocks.IndikuRefinedStone;
import co.uk.silvania.Remula.dimensions.indiku.blocks.IndikuRemulaOre;
import co.uk.silvania.Remula.dimensions.indiku.blocks.IndikuSmallBricks;
import co.uk.silvania.Remula.dimensions.indiku.blocks.IndikuStone;
import co.uk.silvania.Remula.dimensions.indiku.blocks.IndikuTilledDirt;
import co.uk.silvania.Remula.dimensions.indiku.blocks.IndikuTinOre;
import co.uk.silvania.Remula.dimensions.indiku.blocks.IndikuTritaniteOre;
import co.uk.silvania.Remula.dimensions.indiku.blocks.IndikuVentiiumOre;
import co.uk.silvania.Remula.dimensions.indiku.blocks.IndikuZiriniumOre;
import co.uk.silvania.Remula.dimensions.xylexia.BiomeXylexiaPlains;
import co.uk.silvania.Remula.dimensions.xylexia.XylexiaPortalBlock;
import co.uk.silvania.Remula.dimensions.xylexia.XylexiaWorldProvider;
import co.uk.silvania.Remula.dimensions.xylexia.blocks.XylexianBricks;
import co.uk.silvania.Remula.dimensions.xylexia.blocks.XylexianCoalOre;
import co.uk.silvania.Remula.dimensions.xylexia.blocks.XylexianCobblestone;
import co.uk.silvania.Remula.dimensions.xylexia.blocks.XylexianCopperOre;
import co.uk.silvania.Remula.dimensions.xylexia.blocks.XylexianGlass;
import co.uk.silvania.Remula.dimensions.xylexia.blocks.XylexianGlassPane;
import co.uk.silvania.Remula.dimensions.xylexia.blocks.XylexianGoldOre;
import co.uk.silvania.Remula.dimensions.xylexia.blocks.XylexianGrinistOre;
import co.uk.silvania.Remula.dimensions.xylexia.blocks.XylexianHeriOre;
import co.uk.silvania.Remula.dimensions.xylexia.blocks.XylexianIronOre;
import co.uk.silvania.Remula.dimensions.xylexia.blocks.XylexianKzoriOre;
import co.uk.silvania.Remula.dimensions.xylexia.blocks.XylexianLapisLazuliOre;
import co.uk.silvania.Remula.dimensions.xylexia.blocks.XylexianRefinedStone;
import co.uk.silvania.Remula.dimensions.xylexia.blocks.XylexianRemulaOre;
import co.uk.silvania.Remula.dimensions.xylexia.blocks.XylexianSand;
import co.uk.silvania.Remula.dimensions.xylexia.blocks.XylexianSkathaOre;
import co.uk.silvania.Remula.dimensions.xylexia.blocks.XylexianSmallBricks;
import co.uk.silvania.Remula.dimensions.xylexia.blocks.XylexianStone;
import co.uk.silvania.Remula.dimensions.xylexia.blocks.XylexianTinOre;
import co.uk.silvania.Remula.dimensions.xylexia.blocks.XylexianTritaniteOre;
import co.uk.silvania.Remula.dimensions.xylexia.blocks.XylexianZiriniumOre;
import co.uk.silvania.Remula.dimensions.xylexia.blocks.XylexiteOre;
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
			return new ItemStack(Remula.advancedP5RobotSpawner, 1, 0);
		}
	};
	public static CreativeTabs tabAkatoe = new CreativeTabs("tabAkatoe") {
		public ItemStack getIconItemStack() {
			return new ItemStack(Remula.akatoeBricks, 1, 0);
		}
	};
	public static CreativeTabs tabBaloinus = new CreativeTabs("tabBaloinus") {
		public ItemStack getIconItemStack() {
			return new ItemStack(Remula.baloinusStone, 1, 0);
		}
	};
	public static CreativeTabs tabDeepSpace = new CreativeTabs("tabDeepSpace") {
		public ItemStack getIconItemSTack() {
			return new ItemStack(Remula.deepSpaceBrownAsteroidRock, 1, 0);
		}
	};
	public static CreativeTabs tabIndiku = new CreativeTabs("tabIndiku") {
		public ItemStack getIconItemSTack() {
			return new ItemStack(Remula.deepSpaceBrownAsteroidRock, 1, 0);
		}
	};
	public static CreativeTabs tabElkost = new CreativeTabs("tabElkost") {
		public ItemStack getIconItemSTack() {
			return new ItemStack(Remula.deepSpaceBrownAsteroidRock, 1, 0);
		}
	};
	public static CreativeTabs tabXylexia = new CreativeTabs("tabXylexia") {
		public ItemStack getIconItemSTack() {
			return new ItemStack(Remula.deepSpaceBrownAsteroidRock, 1, 0);
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
    
    //public static int blockRemulaID;
    @SideOnly(Side.CLIENT)

    @PreInit
    public void preInit(FMLPreInitializationEvent event) {
    	NetworkRegistry.instance().registerGuiHandler(this, remulaGuiHandler);
    }
	public static WorldGen worldGen = new WorldGen();
	public static EnumArmorMaterial SpaceSuit1 = EnumHelper.addArmorMaterial("SpaceSuit1", 15, new int[]{1, 1, 1, 1}, 0);
	
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
    public final static Block remulaGenerator = new RemulaSimpleGenerator(1818, Material.iron).setBlockName("remulaSimpleGenerator");
    public final static Block remulaSolarPanel = new RemulaSolarPanel(1821, Material.iron).setBlockName("remulaSolarPanel");
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
    
    //Akatoe WGEN stuff
    public final static Block akatoeStone = new AkatoeStone(200, 0, Material.rock).setBlockName("akatoeStone");
    public final static Block akatoeGrass = new AkatoeGrass(201).setBlockName("akatoeGrass");
    public final static Block akatoeDirt = new AkatoeDirt(202, 2, Material.ground).setBlockName("akatoeGround");
    public final static Block akatoeSand = new AkatoeSand(203, 47, Material.sand).setBlockName("akatoeSand");
    
    //Baloinus WGEN stuff
    public final static Block baloinusStone = new BaloinusStone(205, 0, Material.rock);
    
    //Indiku WGEN stuff
    public final static Block indikuStone = new IndikuStone(206, 0, Material.rock).setBlockName("indikuStone");
    public final static Block indikuDirt = new IndikuDirt(207, 1, Material.ground).setBlockName("indikuDirt");
    public final static Block indikuGrass = new IndikuGrass(208).setBlockName("indikuGrass");
    
    //Elkost WGEN stuff
    public final static Block elkostSand = new ElkostSand(209, 0, Material.sand).setBlockName("elkostSand");
    
    //Xylexia WGEN stuff
    public final static Block xylexianStone = new XylexianStone(210, 0, Material.rock).setBlockName("xylexianStone");
    
    //Deep Space WGEN stuff
    public final static Block deepSpaceBrownAsteroidRock = new DeepSpaceBrownAsteroidRock(220, 0, Material.rock).setBlockName("deepSpaceAsteroidRock");
    public final static Block deepSpaceWhiteAsteroidRock = new DeepSpaceWhiteAsteroidRock(221, 16, Material.rock).setBlockName("deepSpaceMeteoriteRock");
    
    //Rest of Akatoe blocks
    public final static Block akatoePortal = new AkatoePortalBlock(1900, 30).setBlockName("akatoePortal");
    public final static Block akatoeTilledDirt = new AkatoeTilledDirt(1901).setBlockName("akatoeTilledDirt");
    public final static Block akatoeCobble = new AkatoeCobble(1902, 1, Material.rock).setBlockName("akatoeCobble");
    public final static Block akatoeRefinedStone = new AkatoeRefinedStone(1906, 5, Material.rock).setBlockName("akatoeRefinedStone");
    public final static Block akatoeBricks = new AkatoeBricks(1907, 6, Material.rock).setBlockName("akatoeBricks");
    public final static Block akatoeLargeBricks = new AkatoeLargeBricks(1908, 7, Material.rock).setBlockName("akatoeBricks");
    public final static Block akatoeDecorBricks = new AkatoeDecorBricks(1909, 8, Material.rock).setBlockName("akatoeDecorBricks");
    public final static Block akatoeCoal = new AkatoeCoal(1910, 16).setBlockName("akatoeCoal");
    public final static Block akatoeIron = new AkatoeIron(1911, 17).setBlockName("akatoeIron");
    public final static Block akatoeGold = new AkatoeGold(1912, 18).setBlockName("akatoeGold");
    public final static Block akatoeCopper = new AkatoeCopper(1913, 19).setBlockName("akatoeCopper");
    public final static Block akatoeTin = new AkatoeTin(1914, 20).setBlockName("akatoeTin");
    public final static Block akatoeLapis = new AkatoeLapis(1915, 21).setBlockName("akatoeLapis");
    public final static Block poriniteOre = new PoriniteOre(1916, 22).setBlockName("poriniteOre");
    public final static Block pilkOre = new PilkOre(1917, 23).setBlockName("pilkOre");
    public final static Block akatiteOre = new AkatiteOre(1918, 24).setBlockName("akatiteOre");
    public final static Block akatoeRemulaOre = new AkatoeRemulaOre(1919, 25).setBlockName("akatoeRemulaOre");
    public final static Block porinCrop = new PorinCrop(1920).setBlockName("porinCrop");
    public final static Block ulinCrop = new UlinCrop(1921).setBlockName("ulinCrop");
    public final static Block cirCrop = new CirCrop(1922).setBlockName("cirCrop");
    public final static Block boskinCrop = new BoskinCrop(1923).setBlockName("boskinCrop");
	public final static Block plantFuxii = new PlantFuxii(1924, 56).setBlockName("plantFuxii");
	//Tree
	//Leaves
	
    //Rest of Baloinus blocks
    public final static Block baloinusPortal = new BaloinusPortalBlock(1950, 255).setBlockName("baloinusPortal");
    public final static Block baloinusCobblestone = new BaloinusCobblestone(1951, 1, Material.rock).setBlockName("baloinusCobblestone");
    public final static Block baloinusBricks = new BaloinusBricks(1952, 2, Material.rock).setBlockName("baloinusBricks");
    public final static Block baloinusSmallBricks = new BaloinusSmallBricks(1953, 3, Material.rock).setBlockName("baloinusSmallBricks");
    public final static Block baloinusRefinedStone = new BaloinusRefinedStone(1954, 4, Material.rock).setBlockName("baloinusRefinedStone");
    public final static Block baloinusCoalOre = new BaloinusCoalOre(1955, 5).setBlockName("baloinusCoalOre");
    public final static Block baloinusCopperOre = new BaloinusCopperOre(1956, 6).setBlockName("baloinusCopperOre");
    public final static Block baloinusTinOre = new BaloinusTinOre(1957, 7).setBlockName("baloinusTinOre");
    public final static Block baloinusIronOre = new BaloinusIronOre(1958, 8).setBlockName("baloinusIronOre");
    public final static Block baloinusRemulaOre = new BaloinusRemulaOre(1959, 9).setBlockName("baloinusRemulaOre");
    public final static Block baloinusPoriniteOre = new BaloinusPoriniteOre(1960, 10).setBlockName("baloinusPoriniteOre");
    public final static Block baloinusPilkOre = new BaloinusPilkOre(1961, 11).setBlockName("baloinusPilkOre");
    public final static Block baloinusTritaniteOre = new BaloinusTritaniteOre(1962, 12).setBlockName("baloinusTritaniteOre");
    public final static Block balumOre = new BalumOre(1963, 13).setBlockName("balumOre");
    
    //Rest of Deep Space Blocks
    public final static Block deepSpacePortal = new DeepSpacePortalBlock(2200, 255).setBlockName("deepSpacePortal");
    public final static Block brownAsteroidRubble = new BrownAsteroidRubble(2201, 1, Material.rock).setBlockName("brownAsteroidRubble");
    public final static Block brownAsteroidBricks = new BrownAsteroidBricks(2202, 2, Material.rock).setBlockName("brownAsteroidBricks");
    public final static Block brownAsteroidSmallBricks = new BrownAsteroidSmallBricks(2203, 3, Material.rock).setBlockName("brownAsteroidSmallBricks");
    public final static Block brownAsteroidCopperOre = new BrownAsteroidCopperOre(2204, 4).setBlockName("brownAsteroidCopperOre");
    public final static Block brownAsteroidTinOre = new BrownAsteroidTinOre(2205, 5).setBlockName("brownAsteroidTinOre");
    public final static Block brownAsteroidIronOre = new BrownAsteroidIronOre(2206, 6).setBlockName("brownAsteroidIronOre");
    public final static Block brownAsteroidSilvaniteOre = new BrownAsteroidSilvaniteOre(2207, 7).setBlockName("brownAsteroidSilvaniteOre");
    public final static Block brownAsteroidPoriniteOre = new BrownAsteroidPoriniteOre(2208, 8).setBlockName("brownAsteroidPoriniteOre");
    public final static Block brownAsteroidSirianOre = new BrownAsteroidSirianOre(2209, 9).setBlockName("brownAsteroidSirianOre");
    public final static Block brownAsteroidFariteOre = new BrownAsteroidFariteOre(2210, 10).setBlockName("brownAsteroidFariteOre");
    public final static Block brownAsteroidZincOre = new BrownAsteroidZincOre(2211, 11).setBlockName("brownAsteroidZincOre");
    public final static Block brownAsteroidDragiteOre = new BrownAsteroidDragiteOre(2212, 12).setBlockName("brownAsteroidDragiteOre");
    public final static Block brownAsteroidThoriOre = new BrownAsteroidThoriOre(2213, 13).setBlockName("brownAsteroidThoriOre");
    public final static Block brownAsteroidVentiiumOre = new BrownAsteroidVentiiumOre(2214, 14).setBlockName("brownAsteroidVentiiumOre");
    public final static Block brownAsteroidFarithiumOre = new BrownAsteroidFarithiumOre(2215, 15).setBlockName("brownAsteroidFarithiumOre");
    public final static Block brownAsteroidBoriaOre = new BrownAsteroidBoriaOre(2216, 32).setBlockName("brownAsteroidBoriaOre");
    public final static Block brownAsteroidHeriOre = new BrownAsteroidHeriOre(2217, 33).setBlockName("brownAsteroidHeriOre");
    //P6 public final static Block brownAsteroidOre = new BrownAsteroidOre(2218, 34).setBlockName("brownAsteroidOre");
    //P7 public final static Block brownAsteroidOre = new BrownAsteroidOre(2219, 35).setBlockName("brownAsteroidOre");
    //P8 public final static Block brownAsteroidOre = new BrownAsteroidOre(2220, 36).setBlockName("brownAsteroidOre");
    //P9 public final static Block brownAsteroidOre = new BrownAsteroidOre(2221, 37).setBlockName("brownAsteroidOre");
    //Empty public final static Block brownAsteroidOre = new BrownAsteroidOre(2222, 38).setBlockName("brownAsteroidOre");
    //Empty public final static Block brownAsteroidOre = new BrownAsteroidOre(2223, 39).setBlockName("brownAsteroidOre");
    public final static Block whiteAsteroidBoriaOre = new WhiteAsteroidBoriaOre(2239, 40).setBlockName("whiteAsteroidBoriaOre");
    public final static Block whiteAsteroidHeriOre = new WhiteAsteroidHeriOre(2240, 41).setBlockName("whiteAsteroidHeriOre");
    //P6 public final static Block whiteAsteroidOre = new WhiteAsteroidOre(2241, 42).setBlockName("whiteAsteroidOre");
    //P7 public final static Block whiteAsteroidOre = new WhiteAsteroidOre(2242, 43).setBlockName("whiteAsteroidOre");
    //P8 public final static Block whiteAsteroidOre = new WhiteAsteroidOre(2243, 44).setBlockName("whiteAsteroidOre");
    //P9 public final static Block whiteAsteroidOre = new WhiteAsteroidOre(2244, 45).setBlockName("whiteAsteroidOre");
    //Empty public final static Block whiteAsteroidOre = new WhiteAsteroidOre(2245, 46).setBlockName("whiteAsteroidOre");
    //Empty public final static Block whiteAsteroidOre = new WhiteAsteroidOre(2246, 47).setBlockName("whiteAsteroidOre");
    public final static Block whiteAsteroidRubble = new WhiteAsteroidRubble(2224, 17, Material.rock).setBlockName("whiteAsteroidRubble");
    public final static Block whiteAsteroidBricks = new WhiteAsteroidBricks(2225, 18, Material.rock).setBlockName("whiteAsteroidBricks");
    public final static Block whiteAsteroidSmallBricks = new WhiteAsteroidSmallBricks(2226, 19, Material.rock).setBlockName("whiteAsteroidSmallBricks");
    public final static Block whiteAsteroidCopperOre = new WhiteAsteroidCopperOre(2227, 22).setBlockName("whiteAsteroidCopperOre");
    public final static Block whiteAsteroidTinOre = new WhiteAsteroidTinOre(2228, 21).setBlockName("whiteAsteroidTinOre");
    public final static Block whiteAsteroidIronOre = new WhiteAsteroidIronOre(2229, 22).setBlockName("whiteAsteroidIronOre");
    public final static Block whiteAsteroidSilvaniteOre = new WhiteAsteroidSilvaniteOre(2230, 23).setBlockName("whiteAsteroidSilvaniteOre");
    public final static Block whiteAsteroidPoriniteOre = new WhiteAsteroidPoriniteOre(2231, 24).setBlockName("whiteAsteroidPoriniteOre");
    public final static Block whiteAsteroidSirianOre = new WhiteAsteroidSirianOre(2232, 25).setBlockName("whiteAsteroidSirianOre");
    public final static Block whiteAsteroidFariteOre = new WhiteAsteroidFariteOre(2233, 26).setBlockName("whiteAsteroidFariteOre");
    public final static Block whiteAsteroidZincOre = new WhiteAsteroidZincOre(2234, 27).setBlockName("whiteAsteroidZincOre");
    public final static Block whiteAsteroidDragiteOre = new WhiteAsteroidDragiteOre(2235, 28).setBlockName("whiteAsteroidDragiteOre");
    public final static Block whiteAsteroidThoriOre = new WhiteAsteroidThoriOre(2236, 29).setBlockName("whiteAsteroidThoriOre");
    public final static Block whiteAsteroidVentiiumOre = new WhiteAsteroidVentiiumOre(2237, 30).setBlockName("whiteAsteroidVentiiumOre");
    public final static Block whiteAsteroidFarithiumOre = new WhiteAsteroidFarithiumOre(2238, 31).setBlockName("whiteAsteroidFarithiumOre");
    
    //Rest of Indiku Blocks
    public final static Block indikuCobblestone = new IndikuCobblestone(1975, 4, Material.rock).setBlockName("indikuCobblestone");
    public final static Block indikuBricks = new IndikuBricks(1976, 5, Material.rock).setBlockName("indikuBricks");
    public final static Block indikuSmallBricks = new IndikuSmallBricks(1977, 6, Material.rock).setBlockName("indikuSmallBricks");
    public final static Block indikuRefinedStone = new IndikuRefinedStone(1978, 7, Material.rock).setBlockName("indikuRefinedStone");
    public final static Block indikuTilledDirt = new IndikuTilledDirt(1979, 8, Material.ground).setBlockName("indikuTilledDirt");
    public final static Block indikuCoalOre = new IndikuCoalOre(1980, 9).setBlockName("indikuCoalOre");
    public final static Block indikuCopperOre = new IndikuCopperOre(1981, 10).setBlockName("indikuCopperOre");
    public final static Block indikuTinOre = new IndikuTinOre(1982, 11).setBlockName("indikuTinOre");
    public final static Block indikuIronOre = new IndikuIronOre(1983, 12).setBlockName("indikuIronOre");
    public final static Block indikuGoldOre = new IndikuGoldOre(1984, 13).setBlockName("indikuGoldOre");
    public final static Block indikuLapisLazuliOre = new IndikuLapisLazuliOre(1985, 14).setBlockName("indikuLapisLazuliOre");
    public final static Block indikuRemulaOre = new IndikuRemulaOre(1986, 15).setBlockName("indikuRemulaOre");
    public final static Block indikuTritaniteOre = new IndikuTritaniteOre(1987, 16).setBlockName("indikuTritaniteOre");
    public final static Block indikuVentiiumOre = new IndikuVentiiumOre(1988, 17).setBlockName("indikuVentiiumOre");
    public final static Block indikuArithiumOre = new IndikuArithiumOre(1989, 18).setBlockName("indikuArithiumOre");
    public final static Block indikuZiriniumOre = new IndikuZiriniumOre(1990, 19).setBlockName("indikuZiriniumOre");
    public final static Block indikiteOre = new IndikiteOre(1991, 20).setBlockName("indikiteOre");
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
    public final static Block indikuPortalBlock = new IndikuPortalBlock(2024, 255).setBlockName("indikuPortalBlock");
    
    
    //Rest of Elkost Blocks
    public final static Block elkostStone = new ElkostStone(2025, 4, Material.rock).setBlockName("elkostStone");
    public final static Block elkostCobblestone = new ElkostCobblestone(2026, 5, Material.rock).setBlockName("elkostCobblestone");
    public final static Block elkostBricks = new ElkostBricks(2027, 6, Material.rock).setBlockName("elkostBricks");
    public final static Block elkostSmallBricks = new ElkostSmallBricks(2028, 7, Material.rock).setBlockName("elkostSmallBricks");
    public final static Block elkostRefinedStone = new ElkostRefinedStone(2029, 8, Material.rock).setBlockName("elkostRefinedStone");
    public final static Block elkostCoalOre = new ElkostCoalOre(2030, 9).setBlockName("elkostCoalOre");
    public final static Block elkostCopperOre = new ElkostCopperOre(2031, 10).setBlockName("elkostCopperOre");
    public final static Block elkostTinOre = new ElkostTinOre(2032, 11).setBlockName("elkostTinOre");
    public final static Block elkostIronOre = new ElkostIronOre(2033, 12).setBlockName("elkostIronOre");
    public final static Block elkostGoldOre = new ElkostGoldOre(2034, 13).setBlockName("elkostGoldOre");
    public final static Block elkostLapisLazuliOre = new ElkostLapisLazuliOre(2035, 14).setBlockName("elkostLapisLazuliOre");
    public final static Block elkostRemulaOre = new ElkostRemulaOre(2036, 15).setBlockName("elkostRemulaOre");
    public final static Block elkostTritaniteOre = new ElkostTritaniteOre(2037, 16).setBlockName("elkostTritaniteOre");
    public final static Block elkostZiriniumOre = new ElkostZiriniumOre(2038, 17).setBlockName("elkostZiriniumOre");
    public final static Block elkostBoriaOre = new ElkostBoriaOre(2039, 18).setBlockName("elkostBoriaOre");
    public final static Block elkostTristaniumOre = new ElkostTristaniumOre(2040, 19).setBlockName("elkostTristaniumOre");
    public final static Block elkostGrinistOre = new ElkostGrinistOre(2041, 20).setBlockName("elkostGrinistOre");
    public final static Block elkostiumOre = new ElkostiumOre(2042, 21).setBlockName("elkostiumOre");
    public final static Block elkostGlass = new ElkostGlass(2043, 22, Material.glass).setBlockName("elkostGlass");
    public final static Block elkostGlassPane = new ElkostGlassPane(2044, 22, Material.glass).setBlockName("elkostGlassPane");
    public final static Block elkostPortalBlock = new ElkostPortalBlock(2074, 255).setBlockName("elkostPotalBlock");
    
    //Rest of Xylexia Blocks
    public final static Block xylexianSand = new XylexianSand(2075, 4, Material.sand).setBlockName("xylexianSand");
    public final static Block xylexianCobblestone = new XylexianCobblestone(2076, 5, Material.rock).setBlockName("xylexianCobblestone");
    public final static Block xylexianBricks = new XylexianBricks(2077, 6, Material.rock).setBlockName("xylexianBricks");
    public final static Block xylexianSmallBricks = new XylexianSmallBricks(2078, 7, Material.rock).setBlockName("xylexianSmallBricks");
    public final static Block xylexianRefinedStone = new XylexianRefinedStone(2079, 8, Material.rock).setBlockName("xylexianRefinedStone");
    public final static Block xylexianCoalOre = new XylexianCoalOre(2080, 9).setBlockName("xylexianCoalOre");
    public final static Block xylexianCopperOre = new XylexianCopperOre(2081, 10).setBlockName("xylexianCopperOre");
    public final static Block xylexianTinOre = new XylexianTinOre(2082, 11).setBlockName("xylexianTinOre");
    public final static Block xylexianIronOre = new XylexianIronOre(2083, 12).setBlockName("xylexianIronOre");
    public final static Block xylexianGoldOre = new XylexianGoldOre(2084, 13).setBlockName("xylexianGoldOre");
    public final static Block xylexianLapisLazuliOre = new XylexianLapisLazuliOre(2085, 14).setBlockName("xylexianLapisLazuliOre");
    public final static Block xylexianRemulaOre = new XylexianRemulaOre(2086, 15).setBlockName("xylexianRemulaOre");
    public final static Block xylexianTritaniteOre = new XylexianTritaniteOre(2087, 16).setBlockName("xylexianTritaniteOre");
    public final static Block xylexianZiriniumOre = new XylexianZiriniumOre(2088, 17).setBlockName("xylexianZiriniumOre");
    public final static Block xylexianGrinistOre = new XylexianGrinistOre(2089, 18).setBlockName("xylexianGrinistOre");
    public final static Block xylexianHeriOre = new XylexianHeriOre(2090, 19).setBlockName("xylexianHeriOre");
    public final static Block xylexianSkathaOre = new XylexianSkathaOre(2091, 20).setBlockName("xylexianSkathaOre");
    public final static Block xylexianKzoriOre = new XylexianKzoriOre(2092, 21).setBlockName("xylexianKzoriOre");
    public final static Block xylexianiumOre = new XylexiteOre(2093, 22).setBlockName("xylexianiumOre");
    public final static Block xylexianGlass = new XylexianGlass(2094, 23, Material.glass).setBlockName("xylexianGlass");
    public final static Block xylexianGlassPane = new XylexianGlassPane(2095, 23, Material.glass).setBlockName("xylexianGlassPane");
    public final static Block xylexianPortalBlock = new XylexiaPortalBlock(2124, 255).setBlockName("xylexianPortalBlock");
    
    
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
	public final static Item ulinSeeds = new UlinSeeds(17041, ulinCrop.blockID, akatoeTilledDirt.blockID).setItemName("ulinSeeds");
	public final static Item cirSeeds = new CirSeeds(17042, cirCrop.blockID, akatoeTilledDirt.blockID).setItemName("cirSeeds");
	public final static Item boskinSeeds = new BoskinSeeds(17043, cirCrop.blockID, akatoeTilledDirt.blockID).setItemName("boskinSeeds");
	public final static Item porinFruit = new PorinFruit(17044, 5, 3.0F, false).setItemName("porinFruit");
	public final static Item ulinFruit = new UlinFruit(17045, 2, 1.0F, false).setItemName("ulinFruit");
	public final static Item itemCir = new ItemCir(17046).setItemName("itemCir");
	public final static Item itemBoskin = new ItemBoskin(17047).setItemName("itemBoskin");
	public final static Item poriniteCell = new PoriniteCell(17050).setItemName("poriniteCell");
	public final static Item pilkCell = new PilkCell(17051).setItemName("pilkCell");
	public final static Item akatiteCell = new AkatiteCell(17052).setItemName("akatiteCell");
	public final static Item poriniteDust = new PoriniteDust(17053).setItemName("poriniteDust");
	public final static Item pilkDust = new PilkDust(17054).setItemName("pilkDust");
	public final static Item akatiteDust = new AkatiteDust(17055).setItemName("akatiteDust");
	public final static Item poriniteIngot = new PoriniteIngot(17056).setItemName("poriniteIngot");
	public final static Item pilkIngot = new PilkIngot(17057).setItemName("pilkIngot");
	public final static Item akatiteIngot = new AkatiteIngot(17058).setItemName("akatiteIngot");
	public final static Item rawGlogMeat = new RawGlogMeat(17059, 0, 0.0F, false).setItemName("rawGlogMeat");
	public final static Item cookedGlogMeat = new CookedGlogMeat(17060, 8, 14.0F, true).setItemName("cookedGlogMeat");
	public final static Item skitterling = new SkitterlingItem(17061, 3, 6.0F, false).setItemName("skitterling");
	public final static Item skitterlingDead = new SkitterlingDead(17062, 1, 3.0F, false).setItemName("skitterlingDead");
	public final static Item rawSkitterlingStick = new RawSkitterlingStick(17063, 9, 6.0F, false).setItemName("rawSkitterlingStick");
	public final static Item cookedSkitterlingStick = new CookedSkitterlingStick(17064, 12, 6.0F, false).setItemName("cookedSkitterlingStick");
	public final static Item rawHermustMeat = new RawHermustMeat(17065, 4, 4.0F, true).setItemName("rawHermustMeat");
	public final static Item cookedHermustMeat = new CookedHermustMeat(17066, 10, 10.0F, true).setItemName("cookedHermustMeat");
	public final static Item rawGarfinMeat = new RawGarfinMeat(17067, 5, 3.5F, false).setItemName("rawGarfinMeat");
	public final static Item cookedGarfinMeat = new CookedGarfinMeat(17068, 12, 12.0F, false).setItemName("cookedGarfinMeat");
	public final static Item rawLignisMeat = new RawLignisMeat(17069, 8, 8.0F, false).setItemName("rawLingisMeat");
	public final static Item cookedLignisMeat = new CookedLignisMeat(17070, 16, 15.0F, false).setItemName("cookedLingisMeat");
	
	
	public final static Item p1HudUnit = new P1HUDUnit(17071, SpaceSuit1, 1, 0, false).setItemName("p1HudUnit");
	//public final static Item p1SpaceSuitHelmet = new P1SpaceSuit(17056, EnumArmorMaterial.CLOTH, proxy.addArmor("P1SpaceSuit"), 0).setItemName("p1SpaceSuitHelmet");
	//public final static Item p1SpaceSuitBody = new P1SpaceSuit(17057, EnumArmorMaterial.CLOTH, proxy.addArmor("P1SpaceSuit"), 1).setItemName("p1SpaceSuitBody");
	//public final static Item p1SpaceSuitLegs = new P1SpaceSuit(17058, EnumArmorMaterial.CLOTH, proxy.addArmor("P1SpaceSuit"), 2).setItemName("p1SpaceSuitLegs");
	//public final static Item p1SpaceSuitBoots = new P1SpaceSuit(17059, SpaceSuit1, proxy.addArmor("P1SpaceSuit"), 3).setItemName("p1SpaceSuitBoots");
	//public final static Item p1HeadUI = new P1HeadUI(17060).setItemName("p1HeadUI");
	//public final static Item standardPistol = new ItemPistol(17042).setItemName("standardPistol");
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
    public static BiomeGenBase xylexiaPlainsBiome = new BiomeXylexiaPlains(68);
    
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
            LanguageRegistry.addName(baloinusPortal, "Baloinus Portal");
            LanguageRegistry.addName(baloinusStone, "Baloinus Stone");
            LanguageRegistry.addName(baloinusCobblestone, "Baloinus Cobblestone");
            LanguageRegistry.addName(baloinusBricks, "Baloinus Bricks");
            LanguageRegistry.addName(baloinusSmallBricks, "Baloinus Small Bricks");
            LanguageRegistry.addName(baloinusRefinedStone, "Baloinus Refined Stone");
            LanguageRegistry.addName(baloinusCoalOre, "Baloinus Coal Ore");
            LanguageRegistry.addName(baloinusCopperOre, "Baloinus Copper Ore");
            LanguageRegistry.addName(baloinusTinOre, "Baloinus Tin Ore");
            LanguageRegistry.addName(baloinusIronOre, "Baloinus Iron Ore");
            LanguageRegistry.addName(baloinusRemulaOre, "Baloinus Remula Ore");
            LanguageRegistry.addName(baloinusPoriniteOre, "Baloinus Porinite Ore");
            LanguageRegistry.addName(baloinusPilkOre, "Baloinus Pilk Ore");
            LanguageRegistry.addName(baloinusTritaniteOre, "Baloinus Tritanite Ore");
            LanguageRegistry.addName(balumOre, "Balum Ore");
            
            //Indiku
            LanguageRegistry.addName(indikuStone, "Indiku Stone");
            LanguageRegistry.addName(indikuDirt, "Indiku Dirt");
            LanguageRegistry.addName(indikuGrass, "Indiku Grass");
            LanguageRegistry.addName(indikuCobblestone, "Indiku Cobblestone");
            LanguageRegistry.addName(indikuBricks, "Indiku Bricks");
            LanguageRegistry.addName(indikuSmallBricks, "Indiku Small BRicks");
            LanguageRegistry.addName(indikuRefinedStone, "Indiku Refined Stone");
            LanguageRegistry.addName(indikuTilledDirt, "Indiku Tilled Dirt");
            LanguageRegistry.addName(indikuCoalOre, "Indiku Coal Ore");
            LanguageRegistry.addName(indikuCopperOre, "Indiku Copper Ore");
            LanguageRegistry.addName(indikuTinOre, "Indiku Tin Ore");
            LanguageRegistry.addName(indikuIronOre, "Indiku Iron Ore");
            LanguageRegistry.addName(indikuGoldOre, "Indiku Gold Ore");
            LanguageRegistry.addName(indikuLapisLazuliOre, "Indiku Lapis Lazuli Ore");
            LanguageRegistry.addName(indikuRemulaOre, "Indiku Remula Ore");
            LanguageRegistry.addName(indikuTritaniteOre, "Indiku Tritanite Ore");
            LanguageRegistry.addName(indikuVentiiumOre, "Indiku Ventiium Ore");
            LanguageRegistry.addName(indikuArithiumOre, "Indiku Arithium Ore");
            LanguageRegistry.addName(indikuZiriniumOre, "Indiku Zirinium Ore");
            LanguageRegistry.addName(indikiteOre, "Indikite Ore");
            
            //Elkost
            LanguageRegistry.addName(elkostSand, "Elkost Dirt");
            LanguageRegistry.addName(elkostStone, "Elkost Stone");
            LanguageRegistry.addName(elkostCobblestone, "Elkost Cobblestone");
            LanguageRegistry.addName(elkostBricks, "Elkost Bricks");
            LanguageRegistry.addName(elkostSmallBricks, "Elkost Small BRicks");
            LanguageRegistry.addName(elkostRefinedStone, "Elkost Refined Stone");
            LanguageRegistry.addName(elkostCoalOre, "Elkost Coal Ore");
            LanguageRegistry.addName(elkostCopperOre, "Elkost Copper Ore");
            LanguageRegistry.addName(elkostTinOre, "Elkost Tin Ore");
            LanguageRegistry.addName(elkostIronOre, "Elkost Iron Ore");
            LanguageRegistry.addName(elkostGoldOre, "Elkost Gold Ore");
            LanguageRegistry.addName(elkostLapisLazuliOre, "Elkost Lapis Lazuli Ore");
            LanguageRegistry.addName(elkostRemulaOre, "Elkost Remula Ore");
            LanguageRegistry.addName(elkostTritaniteOre, "Elkost Tritanite Ore");
            LanguageRegistry.addName(elkostZiriniumOre, "Elkost Zirinium Ore");
            LanguageRegistry.addName(elkostBoriaOre, "Elkost Ventiium Ore");
            LanguageRegistry.addName(elkostTristaniumOre, "Elkost Arithium Ore");
            LanguageRegistry.addName(elkostGrinistOre, "Elkost Zirinium Ore");
            LanguageRegistry.addName(elkostiumOre, "Elkostium Ore");
            LanguageRegistry.addName(elkostGlass, "Elkost Glass");
            LanguageRegistry.addName(elkostGlassPane, "Elkost Glass Pane");
            
            //Xylexia
            LanguageRegistry.addName(xylexianSand, "Xylexian Dirt");
            LanguageRegistry.addName(xylexianStone, "Xylexian Stone");
            LanguageRegistry.addName(xylexianCobblestone, "Xylexian Cobblestone");
            LanguageRegistry.addName(xylexianBricks, "Xylexian Bricks");
            LanguageRegistry.addName(xylexianSmallBricks, "Xylexian Small BRicks");
            LanguageRegistry.addName(xylexianRefinedStone, "Xylexian Refined Stone");
            LanguageRegistry.addName(xylexianCoalOre, "Xylexian Coal Ore");
            LanguageRegistry.addName(xylexianCopperOre, "Xylexian Copper Ore");
            LanguageRegistry.addName(xylexianTinOre, "Xylexian Tin Ore");
            LanguageRegistry.addName(xylexianIronOre, "Xylexian Iron Ore");
            LanguageRegistry.addName(xylexianGoldOre, "Xylexian Gold Ore");
            LanguageRegistry.addName(xylexianLapisLazuliOre, "Xylexian Lapis Lazuli Ore");
            LanguageRegistry.addName(xylexianRemulaOre, "Xylexian Remula Ore");
            LanguageRegistry.addName(xylexianTritaniteOre, "Xylexian Tritanite Ore");
            LanguageRegistry.addName(xylexianZiriniumOre, "Xylexian Zirinium Ore");
            LanguageRegistry.addName(xylexianGrinistOre, "Xylexian Zirinium Ore");
            LanguageRegistry.addName(xylexianHeriOre, "Xylexian Heri Ore");
            LanguageRegistry.addName(xylexianSkathaOre, "Xylexian Skatha Ore");
            LanguageRegistry.addName(xylexianKzoriOre, "Xylexian Kzori Ore");
            LanguageRegistry.addName(xylexianiumOre, "Xylexianium Ore");
            LanguageRegistry.addName(xylexianGlass, "Xylexian Glass");
            LanguageRegistry.addName(xylexianGlassPane, "Xylexian Glass Pane");
            
            //DeepSpace
            LanguageRegistry.addName(deepSpacePortal, "Deep-Space Portal");
            LanguageRegistry.addName(deepSpaceBrownAsteroidRock, "Asteroid Rock");
            LanguageRegistry.addName(deepSpaceWhiteAsteroidRock, "Asteroid Rock");
            LanguageRegistry.addName(brownAsteroidRubble, "Asteroid Rubble");
            LanguageRegistry.addName(brownAsteroidBricks, "Asteroid Bricks");
            LanguageRegistry.addName(brownAsteroidSmallBricks, "Asteroid Small Bricks");
            LanguageRegistry.addName(brownAsteroidCopperOre, "Asteroid Copper Ore");
            LanguageRegistry.addName(brownAsteroidTinOre, "Asteroid Tin Ore");
            LanguageRegistry.addName(brownAsteroidIronOre, "Asteroid Iron Ore");
            LanguageRegistry.addName(brownAsteroidSilvaniteOre, "Asteroid Silvanite Ore");
            LanguageRegistry.addName(brownAsteroidPoriniteOre, "Asteroid Porinite Ore");
            LanguageRegistry.addName(brownAsteroidSirianOre, "Asteroid Sirian Ore");
            LanguageRegistry.addName(brownAsteroidFariteOre, "Asteroid Farite Ore");
            LanguageRegistry.addName(brownAsteroidZincOre, "Asteroid Zinc Ore");
            LanguageRegistry.addName(brownAsteroidDragiteOre, "Asteroid Dragite Ore");
            LanguageRegistry.addName(brownAsteroidThoriOre, "Asteroid Thori Ore");
            LanguageRegistry.addName(brownAsteroidVentiiumOre, "Asteroid Ventiium Ore");
            LanguageRegistry.addName(brownAsteroidFarithiumOre, "Asteroid Farithium Ore");
            LanguageRegistry.addName(brownAsteroidBoriaOre, "Asteroid Boria Ore");
            LanguageRegistry.addName(brownAsteroidHeriOre, "Asteroid Heri Ore");
            //LanguageRegistry.addName(brownAsteroidP6, "Asteroid  Ore");
            //LanguageRegistry.addName(brownAsteroidP7, "Asteroid  Ore");
            //LanguageRegistry.addName(brownAsteroidP8, "Asteroid  Ore");
            //LanguageRegistry.addName(brownAsteroidP9, "Asteroid  Ore");
            LanguageRegistry.addName(whiteAsteroidRubble, "Asteroid Rubble");
            LanguageRegistry.addName(whiteAsteroidBricks, "Asteroid Bricks");
            LanguageRegistry.addName(whiteAsteroidSmallBricks, "Asteroid Small Bricks");
            LanguageRegistry.addName(whiteAsteroidCopperOre, "Asteroid Copper Ore");
            LanguageRegistry.addName(whiteAsteroidTinOre, "Asteroid Tin Ore");
            LanguageRegistry.addName(whiteAsteroidIronOre, "Asteroid Iron Ore");
            LanguageRegistry.addName(whiteAsteroidSilvaniteOre, "Asteroid Silvanite Ore");
            LanguageRegistry.addName(whiteAsteroidPoriniteOre, "Asteroid Porinite Ore");
            LanguageRegistry.addName(whiteAsteroidSirianOre, "Asteroid Sirian Ore");
            LanguageRegistry.addName(whiteAsteroidFariteOre, "Asteroid Farite Ore");
            LanguageRegistry.addName(whiteAsteroidZincOre, "Asteroid Zinc Ore");
            LanguageRegistry.addName(whiteAsteroidDragiteOre, "Asteroid Dragite Ore");
            LanguageRegistry.addName(whiteAsteroidThoriOre, "Asteroid Thori Ore");
            LanguageRegistry.addName(whiteAsteroidVentiiumOre, "Asteroid Ventiium Ore");
            LanguageRegistry.addName(whiteAsteroidFarithiumOre, "Asteroid Farithium Ore");
            LanguageRegistry.addName(whiteAsteroidBoriaOre, "Asteroid Boria Ore");
            LanguageRegistry.addName(whiteAsteroidHeriOre, "Asteroid Heri Ore");
            //LanguageRegistry.addName(whiteAsteroidP6, "Asteroid  Ore");
            //LanguageRegistry.addName(whiteAsteroidP7, "Asteroid  Ore");
            //LanguageRegistry.addName(whiteAsteroidP8, "Asteroid  Ore");
            //LanguageRegistry.addName(whiteAsteroidP9, "Asteroid  Ore");
            
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
            GameRegistry.registerBlock(poriniteOre, "poriniteOre");
            GameRegistry.registerBlock(pilkOre, "pilkOre");
            GameRegistry.registerBlock(akatoeRemulaOre, "akatoeRemulaOre");
            GameRegistry.registerBlock(akatiteOre, "akatiteOre");
            
            //Baloinus
            GameRegistry.registerBlock(baloinusPortal, "baloinusPortal");
            GameRegistry.registerBlock(baloinusStone, "baloinusStone");
            GameRegistry.registerBlock(baloinusCobblestone, "baloinusCobblestone");
            GameRegistry.registerBlock(baloinusBricks, "baloinusBricks");
            GameRegistry.registerBlock(baloinusSmallBricks, "baloinusSmallBricks");
            GameRegistry.registerBlock(baloinusRefinedStone, "baloinusRefinedStone");
            GameRegistry.registerBlock(baloinusCoalOre, "baloinusCoalOre");
            GameRegistry.registerBlock(baloinusCopperOre, "baloinusCopperOre");
            GameRegistry.registerBlock(baloinusTinOre, "baloinusTinOre");
            GameRegistry.registerBlock(baloinusIronOre, "baloinusIronOre");
            GameRegistry.registerBlock(baloinusRemulaOre, "baloinusRemulaOre");
            GameRegistry.registerBlock(baloinusPoriniteOre, "baloinusPoriniteOre");
            GameRegistry.registerBlock(baloinusPilkOre, "baloinusPilkOre");
            GameRegistry.registerBlock(baloinusTritaniteOre, "baloinusTritaniteOre");
            GameRegistry.registerBlock(balumOre, "balumOre");
            
            //Indiku
            GameRegistry.registerBlock(indikuStone, "indikuStone");
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
    }


	@PostInit
    public void postInit(FMLPostInitializationEvent event) {
            // Stub Method
    		}
	}

