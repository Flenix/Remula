package co.uk.silvania.Remula;

import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.Item;
import net.minecraftforge.common.EnumHelper;
import co.uk.silvania.Remula.dimensions.akatoe.items.*;
import co.uk.silvania.Remula.items.*;
import co.uk.silvania.Remula.items.armor.*;
import co.uk.silvania.Remula.items.weapons.*;
import co.uk.silvania.Remula.powergrid.items.*;

public class RemulaItems {
	
	private static RemulaConfig config;
	public static EnumArmorMaterial SpaceSuit1 = EnumHelper.addArmorMaterial("SpaceSuit1", 15, new int[]{1, 1, 1, 1}, 0);
	
    //Items (IDs 17000 - 17300)
    public static Item emptyCell;
    public static Item copperCell;
    public static Item tinCell;
    public static Item coalCell;
    public static Item ironCell;
    public static Item goldCell;
    public static Item redstoneCell;
    public static Item lapisLazuliCell;
    public static Item diamondCell;
	public static Item tecmoniumCell;
	public static Item merciliteCell;
	public static Item silvaniteCell;
	public static Item poriniteCell;
	public static Item pilkCell;
	public static Item tritaniteCell;
	public static Item akatiteCell;
	public static Item balumCell;
	public static Item ventiiumCell;
	public static Item arithiumCell;
	public static Item ziriniumCell;
	public static Item indikiteCell;
	public static Item boriaCell;
	public static Item tristaniumCell;
	public static Item grinistCell;
	public static Item elkostiumCell;
	public static Item heriCell;
	public static Item skathaCell;
	public static Item kzoriCell;
	public static Item xylexiteCell;
	    
	public static Item copperDust;
	public static Item tinDust;
	public static Item coalDust;
	public static Item ironDust;
	public static Item goldDust;
	public static Item diamondDust;
	public static Item tecmoniumDust;
	public static Item merciliteDust;
	public static Item silvaniteDust;
	public static Item poriniteDust;
	public static Item pilkDust;
	public static Item tritaniteDust;
	public static Item akatiteDust;
	public static Item balumDust;
	public static Item ventiiumDust;
	public static Item arithiumDust;
	public static Item ziriniumDust;
	public static Item indikiteDust;
	public static Item boriaDust;
	public static Item tristaniumDust;
	public static Item grinistDust;
	public static Item elkostiumDust;
	public static Item heriDust;
	public static Item skathaDust;
	public static Item kzoriDust;
	public static Item xylexiteDust;
	
    public static Item copperIngot;
    public static Item tinIngot;
	public static Item tecmoniumIngot;
	public static Item merciliteIngot;
	public static Item silvaniteIngot;
	public static Item poriniteIngot;
	public static Item pilkIngot;
	public static Item tritaniteIngot;
	public static Item akatiteIngot;
	public static Item balumIngot;
	public static Item ventiiumIngot;
	public static Item arithiumIngot;
	public static Item ziriniumIngot;
	public static Item indikiteIngot;
	public static Item boriaIngot;
	public static Item tristaniumIngot;
	public static Item grinistIngot;
	public static Item elkostiumIngot;
	public static Item heriIngot;
	public static Item skathaIngot;
	public static Item kzoriIngot;
	public static Item xylexiteIngot;
	
	
	
	public static Item t1TecmoniumChip;
	public static Item t2TecmoniumChip;
	public static Item t3TecmoniumChip;
	public static Item t1MerciliteChip;
	public static Item t2MerciliteChip;
	public static Item t3MerciliteChip;
	public static Item t1SilvaniteChip;
	public static Item t2SilvaniteChip;
	public static Item t3SilvaniteChip;
	
	//public static Item silvaniteBucket = new SilvaniteBucket(17003).setUnlocalizedName("silvaniteBucket");
	//public static Item merciliteBucket = new MerciliteBucket(17007).setUnlocalizedName("merciliteBucket");
	public static Item simpleBattery = new SimpleBattery(17012).setUnlocalizedName("simpleBattery");
	public static Item midBattery = new MidBattery(17013).setUnlocalizedName("midBattery");
	public static Item highBattery = new HighBattery(17014).setUnlocalizedName("highBattery");
	public static Item simplePRSU = new SimplePRSU(17015).setUnlocalizedName("simpleRSU");
	public static Item midPRSU = new MidPRSU(17016).setUnlocalizedName("midRSU");
	public static Item advancedPRSU = new AdvancedPRSU(17017).setUnlocalizedName("advancedRSU");

	//public static Item remDrill = new RemDrill(17027).setUnlocalizedName("remDrill");
	public static Item drillTransformerUpgrade = new DrillTransformerUpgrade(17028).setUnlocalizedName("drillTransformerUpgrade");
	public static Item drillSilkTouchUpgrade = new DrillSilkTouchUpgrade(17029).setUnlocalizedName("drillSilkTouchUpgrade");
	public static Item drillSpeedControlUpgrade = new DrillSpeedControlUpgrade(17030).setUnlocalizedName("drillSpeedControlUpgrade");
	public static Item drillBatteryUpgrade = new DrillBatteryUpgrade(17031).setUnlocalizedName("drillBatteryUpgrade");
	public static Item simpleP1RobotSpawner = new SimpleP1RobotSpawner(17034).setUnlocalizedName("simpleP1RobotSpawner");
	public static Item midP1RobotSpawner = new MidP1RobotSpawner(17035).setUnlocalizedName("midP1RobotSpawner");
	public static Item advancedP1RobotSpawner = new AdvancedP1RobotSpawner(17036).setUnlocalizedName("advancedP1RobotSpawner");
	public static Item simpleP3RobotSpawner = new SimpleP3RobotSpawner(17037).setUnlocalizedName("simpleP3RobotSpawner");
	public static Item midP3RobotSpawner = new MidP3RobotSpawner(17038).setUnlocalizedName("midP3RobotSpawner");
	public static Item advancedP3RobotSpawner = new AdvancedP3RobotSpawner(17039).setUnlocalizedName("advancedP3RobotSpawner");
	public static Item simpleP5RobotSpawner = new SimpleP5RobotSpawner(17037).setUnlocalizedName("simpleP5RobotSpawner");
	public static Item midP5RobotSpawner = new MidP5RobotSpawner(17038).setUnlocalizedName("midP5RobotSpawner");
	public static Item advancedP5RobotSpawner = new AdvancedP5RobotSpawner(17039).setUnlocalizedName("advancedP5RobotSpawner");
	public static Item simpleP7RobotSpawner = new SimpleP7RobotSpawner(17037).setUnlocalizedName("simpleP7RobotSpawner");
	public static Item midP7RobotSpawner = new MidP7RobotSpawner(17038).setUnlocalizedName("midP7RobotSpawner");
	public static Item advancedP7RobotSpawner = new AdvancedP7RobotSpawner(17039).setUnlocalizedName("advancedP7RobotSpawner");
	public static Item simpleP9RobotSpawner = new SimpleP9RobotSpawner(17037).setUnlocalizedName("simpleP9RobotSpawner");
	public static Item midP9RobotSpawner = new MidP9RobotSpawner(17038).setUnlocalizedName("midP9RobotSpawner");
	public static Item advancedP9RobotSpawner = new AdvancedP9RobotSpawner(17039).setUnlocalizedName("advancedP9RobotSpawner");
	
	//TODO find a decent plant tutorial o.O
	//public static Item porinSeeds = new PorinSeeds(17040, akatoeDirt.blockID, akatoeTilledDirt.blockID).setUnlocalizedName("porinSeeds");
	//public static Item ulinSeeds = new UlinSeeds(17041, remulaOre.blockID, akatoeTilledDirt.blockID).setUnlocalizedName("ulinSeeds");
	//public static Item cirSeeds = new CirSeeds(17042, remulaOre.blockID, akatoeTilledDirt.blockID).setUnlocalizedName("cirSeeds");
	//public static Item boskinSeeds = new BoskinSeeds(17043, remulaOre.blockID, akatoeTilledDirt.blockID).setUnlocalizedName("boskinSeeds");
	public static Item porinFruit;
	public static Item ulinFruit;
	public static Item itemCir;
	public static Item itemBoskin;
	public static Item rawGlogMeat;
	public static Item cookedGlogMeat;
	public static Item skitterling;
	public static Item skitterlingDead;
	public static Item rawSkitterlingStick;
	public static Item cookedSkitterlingStick;
	public static Item rawHermustMeat;
	public static Item cookedHermustMeat;
	public static Item rawGarfinMeat;
	public static Item cookedGarfinMeat;
	public static Item rawLignisMeat;
	public static Item cookedLignisMeat;
	
	
	public static Item p1HudUnit = new P1HUDUnit(17071, SpaceSuit1, 1, 0, false).setUnlocalizedName("p1HudUnit");
	public static Item p1SpaceSuitHelmet;
	public static Item p1SpaceSuitBody;
	public static Item p1SpaceSuitLegs;
	public static Item p1SpaceSuitBoots;
	
	public static EnumArmorMaterial tecmoniumAlloyArmor = EnumHelper.addArmorMaterial("TecmoniumAlloy", 32, new int[] {1, 3, 2, 1}, 0);
	
	
	//public static Item p1HeadUI = new P1HeadUI(17060).setUnlocalizedName("p1HeadUI");
	public static Item p1Pistol = new ItemP1Pistol(17042).setUnlocalizedName("p1Pistol");
	public static Item p1IronBullet = new P1IronBullet(17043).setUnlocalizedName("p1IronBullet");
	//InfusionUpgrade
	//StorageUpgrade
	//SpeedUpgrade
	//StrengthUpgrade
	//CCUpgrade?*/
	
	public static void init() {
		initMinerals();
		initEquipment();
		initFood();
		initNatural();
		initPowerGrid();
	}
	
	public static void initMinerals() {
		emptyCell = new RemulaCells(config.emptyCellID).setUnlocalizedName("emptyCell");
	    copperCell = new RemulaCells(config.copperCellID).setUnlocalizedName("copperCell");
	    tinCell = new RemulaCells(config.tinCellID).setUnlocalizedName("tinCell");
	    coalCell = new RemulaCells(config.coalCellID).setUnlocalizedName("coalCell");
	    ironCell = new RemulaCells(config.ironCellID).setUnlocalizedName("ironCell");
	    goldCell = new RemulaCells(config.goldCellID).setUnlocalizedName("goldCell");
	    redstoneCell = new RemulaCells(config.redstoneCellID).setUnlocalizedName("redstoneCell");
	    lapisLazuliCell = new RemulaCells(config.lapisLazuliCellID).setUnlocalizedName("lapisLazuliCell");
	    diamondCell = new RemulaCells(config.diamondCellID).setUnlocalizedName("diamondCell");
		tecmoniumCell = new RemulaCells(config.tecmoniumCellID).setUnlocalizedName("tecmoniumCell"); 
		merciliteCell = new RemulaCells(config.merciliteCellID).setUnlocalizedName("merciliteCell");
		silvaniteCell = new RemulaCells(config.silvaniteCellID).setUnlocalizedName("silvaniteCell");
		poriniteCell = new RemulaCells(config.poriniteCellID).setUnlocalizedName("poriniteCell");
		pilkCell = new RemulaCells(config.pilkCellID).setUnlocalizedName("pilkCell");
		tritaniteCell = new RemulaCells(config.tritaniteCellID).setUnlocalizedName("tritaniteCell");
		akatiteCell = new RemulaCells(config.akatiteCellID).setUnlocalizedName("akatiteCell");
		balumCell = new RemulaCells(config.balumCellID).setUnlocalizedName("balumCell");
		ventiiumCell = new RemulaCells(config.ventiiumCellID).setUnlocalizedName("ventiiumCell");
		arithiumCell = new RemulaCells(config.arithiumCellID).setUnlocalizedName("arithiumCell");
		ziriniumCell = new RemulaCells(config.ziriniumCellID).setUnlocalizedName("ziriniumCell");
		indikiteCell = new RemulaCells(config.indikiteCellID).setUnlocalizedName("indikiteCell");
		boriaCell = new RemulaCells(config.boriaCellID).setUnlocalizedName("boriaCell");
		tristaniumCell = new RemulaCells(config.tristaniumCellID).setUnlocalizedName("tristaniumCell");
		grinistCell = new RemulaCells(config.grinistCellID).setUnlocalizedName("grinistCell");
		elkostiumCell = new RemulaCells(config.elkostiumCellID).setUnlocalizedName("elkostiumCell");
		heriCell = new RemulaCells(config.heriCellID).setUnlocalizedName("heriCell");
		skathaCell = new RemulaCells(config.skathaCellID).setUnlocalizedName("skathaCell");
		kzoriCell = new RemulaCells(config.kzoriCellID).setUnlocalizedName("kzoriCell");
		xylexiteCell = new RemulaCells(config.xylexiteCellID).setUnlocalizedName("xylexiteCell");

		copperDust = new RemulaDusts(config.copperDustID).setUnlocalizedName("copperDust");
		tinDust = new RemulaDusts(config.tinDustID).setUnlocalizedName("tinDust");
		coalDust = new RemulaDusts(config.coalDustID).setUnlocalizedName("coalDust");
		ironDust = new RemulaDusts(config.ironDustID).setUnlocalizedName("ironDust");
		goldDust = new RemulaDusts(config.goldDustID).setUnlocalizedName("goldDust");
		diamondDust = new RemulaDusts(config.diamondDustID).setUnlocalizedName("diamondDust");
		tecmoniumDust = new RemulaDusts(config.tecmoniumDustID).setUnlocalizedName("tecmoniumDust");
		merciliteDust = new RemulaDusts(config.merciliteDustID).setUnlocalizedName("merciliteDust");
		silvaniteDust = new RemulaDusts(config.silvaniteDustID).setUnlocalizedName("silvaniteDust");
		poriniteDust = new RemulaDusts(config.poriniteDustID).setUnlocalizedName("poriniteDust");
		pilkDust = new RemulaDusts(config.pilkDustID).setUnlocalizedName("pilkDust");
		tritaniteDust = new RemulaDusts(config.tritaniteDustID).setUnlocalizedName("tritaniteDust");
		akatiteDust = new RemulaDusts(config.akatiteDustID).setUnlocalizedName("akatiteDust");
		balumDust = new RemulaDusts(config.balumDustID).setUnlocalizedName("balumDust");
		ventiiumDust = new RemulaDusts(config.ventiiumDustID).setUnlocalizedName("ventiiumDust");
		arithiumDust = new RemulaDusts(config.arithiumDustID).setUnlocalizedName("arithiumDust");
		ziriniumDust = new RemulaDusts(config.ziriniumDustID).setUnlocalizedName("ziriniumDust");
		indikiteDust = new RemulaDusts(config.indikiteDustID).setUnlocalizedName("indikiteDust");
		boriaDust = new RemulaDusts(config.boriaDustID).setUnlocalizedName("boriaDust");
		tristaniumDust = new RemulaDusts(config.tristaniumDustID).setUnlocalizedName("tristaniumDust");
		grinistDust = new RemulaDusts(config.grinistDustID).setUnlocalizedName("grinistDust");
		elkostiumDust = new RemulaDusts(config.elkostiumDustID).setUnlocalizedName("elkostiumDust");
		heriDust = new RemulaDusts(config.heriDustID).setUnlocalizedName("heriDust");
		skathaDust = new RemulaDusts(config.skathaDustID).setUnlocalizedName("skathaDust");
		kzoriDust = new RemulaDusts(config.kzoriDustID).setUnlocalizedName("kzoriDust");
		xylexiteDust = new RemulaDusts(config.xylexiteDustID).setUnlocalizedName("xylexiteDust");

	    copperIngot = new RemulaIngots(config.copperIngotID).setUnlocalizedName("copperIngot");
	    tinIngot = new RemulaIngots(config.tinIngotID).setUnlocalizedName("tinIngot");
		tecmoniumIngot = new RemulaIngots(config.tecmoniumIngotID).setUnlocalizedName("tecmoniumIngot"); 
		merciliteIngot = new RemulaIngots(config.merciliteIngotID).setUnlocalizedName("merciliteIngot");
		silvaniteIngot = new RemulaIngots(config.silvaniteIngotID).setUnlocalizedName("silvaniteIngot");
		poriniteIngot = new RemulaIngots(config.poriniteIngotID).setUnlocalizedName("poriniteIngot");
		pilkIngot = new RemulaIngots(config.pilkIngotID).setUnlocalizedName("pilkIngot");
		tritaniteIngot = new RemulaIngots(config.tritaniteIngotID).setUnlocalizedName("tritaniteIngot");
		akatiteIngot = new RemulaIngots(config.akatiteIngotID).setUnlocalizedName("akatiteIngot");
		balumIngot = new RemulaIngots(config.balumIngotID).setUnlocalizedName("balumIngot");
		ventiiumIngot = new RemulaIngots(config.ventiiumIngotID).setUnlocalizedName("ventiiumIngot");
		arithiumIngot = new RemulaIngots(config.arithiumIngotID).setUnlocalizedName("arithiumIngot");
		ziriniumIngot = new RemulaIngots(config.ziriniumIngotID).setUnlocalizedName("ziriniumIngot");
		indikiteIngot = new RemulaIngots(config.indikiteIngotID).setUnlocalizedName("indikiteIngot");
		boriaIngot = new RemulaIngots(config.boriaIngotID).setUnlocalizedName("boriaIngot");
		tristaniumIngot = new RemulaIngots(config.tristaniumIngotID).setUnlocalizedName("tristaniumIngot");
		grinistIngot = new RemulaIngots(config.grinistIngotID).setUnlocalizedName("grinistIngot");
		elkostiumIngot = new RemulaIngots(config.elkostiumIngotID).setUnlocalizedName("elkostiumIngot");
		heriIngot = new RemulaIngots(config.heriIngotID).setUnlocalizedName("heriIngot");
		skathaIngot = new RemulaIngots(config.skathaIngotID).setUnlocalizedName("skathaIngot");
		kzoriIngot = new RemulaIngots(config.kzoriIngotID).setUnlocalizedName("kzoriIngot");
		xylexiteIngot = new RemulaIngots(config.xylexiteIngotID).setUnlocalizedName("xylexiteIngot");
	}
	
	public static void initEquipment() {
		p1SpaceSuitHelmet = new P1SpaceSuit(17056, tecmoniumAlloyArmor, 0, 0).setUnlocalizedName("p1SpaceSuitHelmet");
		p1SpaceSuitBody = new P1SpaceSuit(17057, tecmoniumAlloyArmor, 0, 1).setUnlocalizedName("p1SpaceSuitBody");
		p1SpaceSuitLegs = new P1SpaceSuit(17058, tecmoniumAlloyArmor, 0, 2).setUnlocalizedName("p1SpaceSuitLegs");
		p1SpaceSuitBoots = new P1SpaceSuit(17059, tecmoniumAlloyArmor, 0, 3).setUnlocalizedName("p1SpaceSuitBoots");
	}
	
	public static void initFood() {
		porinFruit = new RemulaFoods(config.porinFruitID, 5, 3.0F, false).setUnlocalizedName("porinFruit");
		ulinFruit = new RemulaFoods(config.ulinFruitID, 2, 1.0F, false).setUnlocalizedName("ulinFruit");
		rawGlogMeat = new RemulaFoods(config.rawGlogMeatID, 0, 0.0F, false).setUnlocalizedName("rawGlogMeat");
		cookedGlogMeat = new RemulaFoods(config.cookedGlogMeatID, 8, 14.0F, true).setUnlocalizedName("cookedGlogMeat");
		skitterling = new SkitterlingItem(config.skitterlingID, 3, 6.0F, false).setUnlocalizedName("skitterling");
		skitterlingDead = new RemulaFoods(config.skitterlingDeadID, 1, 3.0F, false).setUnlocalizedName("skitterlingDead");
		rawSkitterlingStick = new RemulaFoods(config.rawSkitterlingStickID, 9, 6.0F, false).setUnlocalizedName("rawSkitterlingStick");
		cookedSkitterlingStick = new RemulaFoods(config.cookedSkitterlingStickID, 12, 6.0F, false).setUnlocalizedName("cookedSkitterlingStick");
		rawHermustMeat = new RemulaFoods(config.rawHermustMeatID, 4, 4.0F, true).setUnlocalizedName("rawHermustMeat");
		cookedHermustMeat = new RemulaFoods(config.cookedHermustMeatID, 10, 10.0F, true).setUnlocalizedName("cookedHermustMeat");
		rawGarfinMeat = new RemulaFoods(config.rawGarfinMeatID, 5, 3.5F, false).setUnlocalizedName("rawGarfinMeat");
		cookedGarfinMeat = new RemulaFoods(config.cookedGarfinMeatID, 12, 12.0F, false).setUnlocalizedName("cookedGarfinMeat");
		rawLignisMeat = new RemulaFoods(config.rawLignisMeatID, 8, 8.0F, false).setUnlocalizedName("rawLingisMeat");
		cookedLignisMeat = new RemulaFoods(config.cookedLignisMeatID, 16, 15.0F, false).setUnlocalizedName("cookedLingisMeat");
	}
	
	public static void initNatural() {
		itemCir = new ItemCir(17046).setUnlocalizedName("itemCir");
		itemBoskin = new ItemBoskin(17047).setUnlocalizedName("itemBoskin");
	}
	
	public static void initPowerGrid() {
		
	}
	
	public static void initCraftingIngredients() {
		t1TecmoniumChip = new CraftingIngredientsChips(config.t1TecmoniumChipID).setUnlocalizedName("t1TecmoniumChip");
		t2TecmoniumChip = new CraftingIngredientsChips(config.t2TecmoniumChipID).setUnlocalizedName("t2TecmoniumChip");
		t3TecmoniumChip = new CraftingIngredientsChips(config.t3TecmoniumChipID).setUnlocalizedName("t3TecmoniumChip");
		t1MerciliteChip = new CraftingIngredientsChips(config.t1MerciliteChipID).setUnlocalizedName("t1MerciliteChip");
		t2MerciliteChip = new CraftingIngredientsChips(config.t2MerciliteChipID).setUnlocalizedName("t2MerciliteChip");
		t3MerciliteChip = new CraftingIngredientsChips(config.t3MerciliteChipID).setUnlocalizedName("t3MercilieChip");
		t1SilvaniteChip = new CraftingIngredientsChips(config.t1SilvaniteChipID).setUnlocalizedName("t1SilvaniteChip");
		t2SilvaniteChip = new CraftingIngredientsChips(config.t2SilvaniteChipID).setUnlocalizedName("t2SilvaniteChip");
		t3SilvaniteChip = new CraftingIngredientsChips(config.t3SilvaniteChipID).setUnlocalizedName("t3SilvaniteChip");
	}

}
