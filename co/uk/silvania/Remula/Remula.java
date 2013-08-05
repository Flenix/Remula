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
			return new ItemStack(Block.stone/*Remula.earthOreBlocks*/, 1, 6);
		}
	};
	public static CreativeTabs tabMachines = new CreativeTabs("tabMachines") {
		public ItemStack getIconItemStack() {
			return new ItemStack(Block.stone, 1, 0);
		}
	};
	public static CreativeTabs tabWorlds = new CreativeTabs("tabWorlds") {
		public ItemStack getIconItemStack() {
			return new ItemStack(Block.stone/*Remula.xylexiaTerrainBlocks*/, 1, 1);
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
    public static BiomeGenBase elkostDesertBiome;
    public static BiomeGenBase indikuJungleBiome;
    public static BiomeGenBase xylexiaPlainsBiome;
    
    //public static int blockRemulaID;
    @SideOnly(Side.CLIENT)

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
    	NetworkRegistry.instance().registerGuiHandler(this, remulaGuiHandler);
    	RemulaConfig.loadConfig(event);
    	
    	RemulaConfig config = new RemulaConfig();
    	
    	RemulaBlocks.init();
        
        akatoePlainsBiome = new BiomeAkatoePlains(60);
        akatoeDesertBiome = new BiomeAkatoeDesert(61);
        akatoeOceanBiome = new BiomeAkatoeOcean(62);
        akatoeWastelandBiome = new BiomeAkatoeWasteland(63);
        baloinusPlainsBiome = new BiomeBaloinusPlains(65);
        elkostDesertBiome = new BiomeElkostPlains(66);
        indikuJungleBiome = new BiomeIndikuJungle(67);
        xylexiaPlainsBiome = new BiomeXylexiaPlains(68);
    }
	public static WorldGen worldGen = new WorldGen();
	public static EnumArmorMaterial SpaceSuit1 = EnumHelper.addArmorMaterial("SpaceSuit1", 15, new int[]{1, 1, 1, 1}, 0);

    //public final static Block porinCrop = new PorinCrop(1920).setUnlocalizedName("porinCrop");
    //public final static Block ulinCrop = new UlinCrop(1921).setUnlocalizedName("ulinCrop");
    //public final static Block cirCrop = new CirCrop(1922).setUnlocalizedName("cirCrop");
    //public final static Block boskinCrop = new BoskinCrop(1923).setUnlocalizedName("boskinCrop");
	public final static Block plantFuxii = new PlantFuxii(1924).setUnlocalizedName("plantFuxii");
	//Tree x3
	//Leaves x3
    
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
            
            proxy.oreDictionary();
            proxy.dimensionManager();

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
            EntityRegistry.addSpawn(EntitySkitterling.class, 5, 6, 10, EnumCreatureType.monster, Remula.akatoePlainsBiome, Remula.akatoeDesertBiome, Remula.akatoeWastelandBiome);
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
            
            LanguageRegistry.instance().addStringLocalization("itemGroup.tabRemula", "en_US", "Remula");
            LanguageRegistry.instance().addStringLocalization("itemGroup.tabMinerals", "en_US", "Minerals");
            LanguageRegistry.instance().addStringLocalization("itemGroup.tabMachines", "en_US", "Machines");
            LanguageRegistry.instance().addStringLocalization("itemGroup.tabWorlds", "en_US", "Worlds");
            LanguageRegistry.instance().addStringLocalization("itemGroup.tabEquip", "en_US", "Equipment");
            LanguageRegistry.instance().addStringLocalization("itemGroup.tabMisc", "en_US", "Misc");
                        
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
