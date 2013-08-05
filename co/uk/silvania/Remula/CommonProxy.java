package co.uk.silvania.Remula;

import co.uk.silvania.Remula.blocks.p1.ItemEarthOreBlocks;
import co.uk.silvania.Remula.blocks.p2.ItemAkatoeLeaves;
import co.uk.silvania.Remula.blocks.p2.ItemAkatoeLogs;
import co.uk.silvania.Remula.blocks.p2.ItemAkatoeOreBlocks;
import co.uk.silvania.Remula.blocks.p2.ItemAkatoeSaplings;
import co.uk.silvania.Remula.blocks.p2.ItemAkatoeTerrainBlocks;
import co.uk.silvania.Remula.blocks.p2.ItemBaloinusOreBlocks;
import co.uk.silvania.Remula.blocks.p2.ItemBaloinusTerrainBlocks;
import co.uk.silvania.Remula.blocks.p2.P2Compressor;
import co.uk.silvania.Remula.blocks.p2.P2Crusher;
import co.uk.silvania.Remula.blocks.p2.P2Extractor;
import co.uk.silvania.Remula.blocks.p2.P2Furnace;
import co.uk.silvania.Remula.blocks.p2.P2Generator;
import co.uk.silvania.Remula.blocks.p2.P2Grinder;
import co.uk.silvania.Remula.blocks.p2.P2Liquidizer;
import co.uk.silvania.Remula.blocks.p2.P2ReactorCore;
import co.uk.silvania.Remula.blocks.p2.P2SolarPanel;
import co.uk.silvania.Remula.blocks.p2.P2T1StorageUnit;
import co.uk.silvania.Remula.blocks.p2.P2T2StorageUnit;
import co.uk.silvania.Remula.blocks.p2.P2T3StorageUnit;
import co.uk.silvania.Remula.blocks.p2.P2ThermalGenerator;
import co.uk.silvania.Remula.blocks.p3.ItemIndikuOreBlocks;
import co.uk.silvania.Remula.blocks.p3.ItemIndikuTerrainBlocks;
import co.uk.silvania.Remula.blocks.p4.ItemElkostOreBlocks;
import co.uk.silvania.Remula.blocks.p4.ItemElkostTerrainBlocks;
import co.uk.silvania.Remula.blocks.p5.ItemXylexiaOreBlocks;
import co.uk.silvania.Remula.blocks.p5.ItemXylexiaTerrainBlocks;
import co.uk.silvania.Remula.dimensions.akatoe.AkatoeWorldProvider;
import co.uk.silvania.Remula.dimensions.akatoe.WorldGenAkatoeTrees;
import co.uk.silvania.Remula.dimensions.baloinus.BaloinusWorldProvider;
import co.uk.silvania.Remula.dimensions.deepspace.DeepSpaceWorldProvider;
import co.uk.silvania.Remula.dimensions.deepspace.ItemDeepSpaceBrownOreBlocks;
import co.uk.silvania.Remula.dimensions.deepspace.ItemDeepSpaceTerrainBlocks;
import co.uk.silvania.Remula.dimensions.deepspace.ItemDeepSpaceWhiteOreBlocks;
import co.uk.silvania.Remula.dimensions.elkost.ElkostWorldProvider;
import co.uk.silvania.Remula.dimensions.indiku.IndikuWorldProvider;
import co.uk.silvania.Remula.dimensions.xylexia.XylexiaWorldProvider;
import co.uk.silvania.Remula.entity.EntityAdvRobot;
//import co.uk.silvania.Remula.entity.akatoe.EntityAkatonian;
import co.uk.silvania.Remula.entity.akatoe.EntityGlog;
import co.uk.silvania.Remula.tileentity.TileEntityLITable;
import co.uk.silvania.Remula.tileentity.TileEntityMerciliteChest;
import co.uk.silvania.Remula.tileentity.TileEntitySilvaniteChest;
import co.uk.silvania.Remula.tileentity.TileEntityTecmoniumChest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.oredict.OreDictionary;
import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class CommonProxy implements IGuiHandler {
	
	public void registerRenderInformation() {}
	
	public void init () {
		registerRenderInformation();
			
	}
		
	public int addArmor(String string) {
		return 0;
	}

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity tileEntity = world.getBlockTileEntity(x, y, z);
		
		if(tileEntity != null) {
			switch(ID) {
				case 0:
				//Containers
			}
		}
		return tileEntity;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {

		return null;
	}
    
    public void registerRenderThings() {
    }
    
    public World getClientWorld() {
        return null;
    }
    
    public void registerGeneralBlocks() {
    	GameRegistry.registerBlock(RemulaBlocks.p1CraftingTable, "p1CraftingTable");
    }
    
    public void addGeneralNames() {
    	LanguageRegistry.addName(RemulaBlocks.p1CraftingTable, "Liquid Infusion Table");    	
    }
    
    public void registerEarthBlocks() {
    	GameRegistry.registerBlock(RemulaBlocks.p1Liquidizer, "p1Liquidizer");
    	GameRegistry.registerBlock(RemulaBlocks.p1T1StorageUnit, "p1T1StorageUnit");
    	GameRegistry.registerBlock(RemulaBlocks.p1T2StorageUnit, "p1T2StorageUnit");
    	GameRegistry.registerBlock(RemulaBlocks.p1T3StorageUnit, "p1T3StorageUnit");
    	GameRegistry.registerBlock(RemulaBlocks.p1Generator, "p1Generator");
    	GameRegistry.registerBlock(RemulaBlocks.p1SolarPanel, "p1SolarPanel");
    	GameRegistry.registerBlock(RemulaBlocks.p1ThermalGenerator, "p1ThermalGenerator");
    	GameRegistry.registerBlock(RemulaBlocks.p1Grinder, "p1Grinder");
    	GameRegistry.registerBlock(RemulaBlocks.p1Compressor, "p1Compressor");
    	GameRegistry.registerBlock(RemulaBlocks.p1Furnace, "p1Furnace");
    	GameRegistry.registerBlock(RemulaBlocks.p1Extractor, "p1Extractor");
    	GameRegistry.registerBlock(RemulaBlocks.p1Crusher, "p1Crusher");
    	
        GameRegistry.registerBlock(RemulaBlocks.earthOreBlocks, ItemEarthOreBlocks.class, "Remula" + (RemulaBlocks.earthOreBlocks.getUnlocalizedName().substring(5)));
        GameRegistry.registerBlock(RemulaBlocks.tecmoniumChest, "tecmoniumChest");
        GameRegistry.registerBlock(RemulaBlocks.merciliteChest, "merciliteChest");
        GameRegistry.registerBlock(RemulaBlocks.silvaniteChest, "silvaniteChest");
    }
    
    public void addEarthNames() {
    	LanguageRegistry.addName(RemulaBlocks.p1Liquidizer, "Phase 1 Liquidizer");
    	LanguageRegistry.addName(RemulaBlocks.p1T1StorageUnit, "Phase 1 Tier 1 Storage Unit");
    	LanguageRegistry.addName(RemulaBlocks.p1T2StorageUnit, "Phase 1 Tier 2 Storage Unit");
    	LanguageRegistry.addName(RemulaBlocks.p1T3StorageUnit, "Phase 1 Tier 3 Storage Unit");
    	LanguageRegistry.addName(RemulaBlocks.p1Generator, "Phase 1 Generator");
    	LanguageRegistry.addName(RemulaBlocks.p1SolarPanel, "Phase 1 Solar Panel");
    	LanguageRegistry.addName(RemulaBlocks.p1ThermalGenerator, "Phase 1 Thermal Generator");
    	LanguageRegistry.addName(RemulaBlocks.p1Grinder, "Phase 1 Grinder");
    	LanguageRegistry.addName(RemulaBlocks.p1Compressor, "Phase 1 Compressor");
    	LanguageRegistry.addName(RemulaBlocks.p1Furnace, "Phase 1 Furnace");
    	LanguageRegistry.addName(RemulaBlocks.p1Extractor, "Phase 1 Extractor");
    	LanguageRegistry.addName(RemulaBlocks.p1Crusher, "Phase 1 Crusher");
    	
    	LanguageRegistry.addName(RemulaBlocks.tecmoniumChest, "Tecmonium Chest");
    	LanguageRegistry.addName(RemulaBlocks.merciliteChest, "Mercilite Chest");
    	LanguageRegistry.addName(RemulaBlocks.silvaniteChest, "Silvanite Chest");
    	
        LanguageRegistry.addName(new ItemStack(RemulaBlocks.earthOreBlocks, 1, 0), "Copper Ore");
        LanguageRegistry.addName(new ItemStack(RemulaBlocks.earthOreBlocks, 1, 1), "Tin Ore");
        LanguageRegistry.addName(new ItemStack(RemulaBlocks.earthOreBlocks, 1, 2), "Zinc Ore");
        LanguageRegistry.addName(new ItemStack(RemulaBlocks.earthOreBlocks, 1, 3), "Silver Ore");
        LanguageRegistry.addName(new ItemStack(RemulaBlocks.earthOreBlocks, 1, 4), "Tecmonium Ore");
        LanguageRegistry.addName(new ItemStack(RemulaBlocks.earthOreBlocks, 1, 5), "Mercilite Ore");
        LanguageRegistry.addName(new ItemStack(RemulaBlocks.earthOreBlocks, 1, 6), "Silvanite Ore");
    }
    
    public void registerAkatoeBlocks() {
    	GameRegistry.registerBlock(RemulaBlocks.p2Liquidizer, "p2Liquidizer");
    	GameRegistry.registerBlock(RemulaBlocks.p2T1StorageUnit, "p2T1StorageUnit");
    	GameRegistry.registerBlock(RemulaBlocks.p2T2StorageUnit, "p2T2StorageUnit");
    	GameRegistry.registerBlock(RemulaBlocks.p2T3StorageUnit, "p2T3StorageUnit");
    	GameRegistry.registerBlock(RemulaBlocks.p2Generator, "p2Generator");
    	GameRegistry.registerBlock(RemulaBlocks.p2SolarPanel, "p2SolarPanel");
    	GameRegistry.registerBlock(RemulaBlocks.p2ThermalGenerator, "p2ThermalGenerator");
    	GameRegistry.registerBlock(RemulaBlocks.p2Grinder, "p2Grinder");
    	GameRegistry.registerBlock(RemulaBlocks.p2Compressor, "p2Compressor");
    	GameRegistry.registerBlock(RemulaBlocks.p2Furnace, "p2Furnace");
    	GameRegistry.registerBlock(RemulaBlocks.p2Extractor, "p2Extractor");
    	GameRegistry.registerBlock(RemulaBlocks.p2Crusher, "p2Crusher");
    	
    	GameRegistry.registerBlock(RemulaBlocks.akatoeStone, "akatoeStone");
    	GameRegistry.registerBlock(RemulaBlocks.akatoeSand, "akatoeSand");
    	GameRegistry.registerBlock(RemulaBlocks.akatoeDirt, "akatoeDirt");
    	GameRegistry.registerBlock(RemulaBlocks.akatoeGrass, "akatoeGrass");
    	GameRegistry.registerBlock(RemulaBlocks.akatoeLogs, "akatoeLogs");
    	GameRegistry.registerBlock(RemulaBlocks.akatoeLeaves, "akatoeLeaves");
    	GameRegistry.registerBlock(RemulaBlocks.akatoeSaplings, "akatoeSaplings");
    	
    	GameRegistry.registerBlock(RemulaBlocks.akatoePortal, "akatoePortal");
    	GameRegistry.registerBlock(RemulaBlocks.akatoeTerrainBlocks, ItemAkatoeTerrainBlocks.class, "Remula" + (RemulaBlocks.akatoeTerrainBlocks.getUnlocalizedName().substring(5)));
    	GameRegistry.registerBlock(RemulaBlocks.akatoeOreBlocks, ItemAkatoeOreBlocks.class, "Remula" + (RemulaBlocks.akatoeOreBlocks.getUnlocalizedName().substring(5)));
    }
    
    public void addAkatoeNames() {
    	LanguageRegistry.addName(RemulaBlocks.p2Liquidizer, "Phase 2 Liquidizer");
    	LanguageRegistry.addName(RemulaBlocks.p2T1StorageUnit, "Phase 2 Tier 1 Storage Unit");
    	LanguageRegistry.addName(RemulaBlocks.p2T2StorageUnit, "Phase 2 Tier 2 Storage Unit");
    	LanguageRegistry.addName(RemulaBlocks.p2T3StorageUnit, "Phase 2 Tier 3 Storage Unit");
    	LanguageRegistry.addName(RemulaBlocks.p2Generator, "Phase 2 Generator");
    	LanguageRegistry.addName(RemulaBlocks.p2SolarPanel, "Phase 2 Solar Panel");
    	LanguageRegistry.addName(RemulaBlocks.p2ThermalGenerator, "Phase 2 Thermal Generator");
    	LanguageRegistry.addName(RemulaBlocks.p2Grinder, "Phase 2 Grinder");
    	LanguageRegistry.addName(RemulaBlocks.p2Compressor, "Phase 2 Compressor");
    	LanguageRegistry.addName(RemulaBlocks.p2Furnace, "Phase 2 Furnace");
    	LanguageRegistry.addName(RemulaBlocks.p2Extractor, "Phase 2 Extractor");
    	LanguageRegistry.addName(RemulaBlocks.p2Crusher, "Phase 2 Crusher");
    	
        LanguageRegistry.addName(new ItemStack(RemulaBlocks.akatoeTerrainBlocks, 1, 0), "Akatonian Cobblestone");
        LanguageRegistry.addName(new ItemStack(RemulaBlocks.akatoeTerrainBlocks, 1, 1), "Akatonian Bricks");
        LanguageRegistry.addName(new ItemStack(RemulaBlocks.akatoeTerrainBlocks, 1, 2), "Akatonian Small Bricks");
        LanguageRegistry.addName(new ItemStack(RemulaBlocks.akatoeTerrainBlocks, 1, 3), "Akatonian Decorative Bricks");
        LanguageRegistry.addName(new ItemStack(RemulaBlocks.akatoeTerrainBlocks, 1, 4), "Akatonian Refined Stone");
        LanguageRegistry.addName(new ItemStack(RemulaBlocks.akatoeTerrainBlocks, 1, 5), "Akatonian Glass");
        
        LanguageRegistry.addName(new ItemStack(RemulaBlocks.akatoeOreBlocks, 1, 0), "Akatonian Coal Ore");
        LanguageRegistry.addName(new ItemStack(RemulaBlocks.akatoeOreBlocks, 1, 1), "Akatonian Copper Ore");
        LanguageRegistry.addName(new ItemStack(RemulaBlocks.akatoeOreBlocks, 1, 2), "Akatonian Tin Ore");
        LanguageRegistry.addName(new ItemStack(RemulaBlocks.akatoeOreBlocks, 1, 3), "Akatonian Iron Ore");
        LanguageRegistry.addName(new ItemStack(RemulaBlocks.akatoeOreBlocks, 1, 4), "Akatonian Gold Ore");
        LanguageRegistry.addName(new ItemStack(RemulaBlocks.akatoeOreBlocks, 1, 5), "Akatonian Lapis Ore"); 
        LanguageRegistry.addName(new ItemStack(RemulaBlocks.akatoeOreBlocks, 1, 6), "Akatonian Silvanite Ore");
        LanguageRegistry.addName(new ItemStack(RemulaBlocks.akatoeOreBlocks, 1, 7), "Akatonian Porinite Ore");
        LanguageRegistry.addName(new ItemStack(RemulaBlocks.akatoeOreBlocks, 1, 8), "Akatonian Pilk Ore");
        LanguageRegistry.addName(new ItemStack(RemulaBlocks.akatoeOreBlocks, 1, 9), "Akatite Ore");
    	
    	LanguageRegistry.addName(RemulaBlocks.akatoeStone, "Akatonian Stone");
    	LanguageRegistry.addName(RemulaBlocks.akatoeSand, "Akatonian Sand");
    	LanguageRegistry.addName(RemulaBlocks.akatoeDirt, "Akatonian Dirt");
    	LanguageRegistry.addName(RemulaBlocks.akatoeGrass, "Akatonian Grass");
    	LanguageRegistry.addName(RemulaBlocks.akatoeLogs, "Temporary Name");
    	LanguageRegistry.addName(RemulaBlocks.akatoeLeaves, "Temporary Name");
    	LanguageRegistry.addName(RemulaBlocks.akatoeSaplings, "Temporary Name");
    	LanguageRegistry.addName(RemulaBlocks.akatoePortal, "Akatoe Portal");
    }
    
    public void registerBaloinusBlocks() {
        GameRegistry.registerBlock(RemulaBlocks.baloinusTerrainBlocks, ItemBaloinusTerrainBlocks.class, "Remula" + (RemulaBlocks.baloinusTerrainBlocks.getUnlocalizedName().substring(5)));
        GameRegistry.registerBlock(RemulaBlocks.baloinusOreBlocks, ItemBaloinusOreBlocks.class, "Remula" + (RemulaBlocks.baloinusOreBlocks.getUnlocalizedName().substring(5)));
        GameRegistry.registerBlock(RemulaBlocks.baloinusPortal, "baloinusPortal");
        GameRegistry.registerBlock(RemulaBlocks.baloinusStone, "baloinusStone");
    }
    
    public void addBaloinusNames() {
        LanguageRegistry.addName(RemulaBlocks.baloinusPortal, "Baloinus Portal");
        LanguageRegistry.addName(RemulaBlocks.baloinusStone, "Baloinus Stone");
        
        LanguageRegistry.addName(new ItemStack(RemulaBlocks.baloinusTerrainBlocks, 1, 0), "Baloinus Cobblestone");
        LanguageRegistry.addName(new ItemStack(RemulaBlocks.baloinusTerrainBlocks, 1, 1), "Baloinus Bricks");
        LanguageRegistry.addName(new ItemStack(RemulaBlocks.baloinusTerrainBlocks, 1, 2), "Baloinus Small Bricks");
        LanguageRegistry.addName(new ItemStack(RemulaBlocks.baloinusTerrainBlocks, 1, 3), "Baloinus Decorative Bricks");
        LanguageRegistry.addName(new ItemStack(RemulaBlocks.baloinusTerrainBlocks, 1, 4), "Baloinus Refined Stone");
        LanguageRegistry.addName(new ItemStack(RemulaBlocks.baloinusTerrainBlocks, 1, 5), "Baloinus Sand");
        LanguageRegistry.addName(new ItemStack(RemulaBlocks.baloinusOreBlocks, 1, 0), "Baloinus Coal Ore");
        LanguageRegistry.addName(new ItemStack(RemulaBlocks.baloinusOreBlocks, 1, 1), "Baloinus Copper Ore");
        LanguageRegistry.addName(new ItemStack(RemulaBlocks.baloinusOreBlocks, 1, 2), "Baloinus Tin Ore");
        LanguageRegistry.addName(new ItemStack(RemulaBlocks.baloinusOreBlocks, 1, 3), "Baloinus Iron Ore");
        LanguageRegistry.addName(new ItemStack(RemulaBlocks.baloinusOreBlocks, 1, 4), "Baloinus Silvanite Ore");
        LanguageRegistry.addName(new ItemStack(RemulaBlocks.baloinusOreBlocks, 1, 5), "Baloinus Porinite Ore");
        LanguageRegistry.addName(new ItemStack(RemulaBlocks.baloinusOreBlocks, 1, 6), "Baloinus Pilk Ore");
        LanguageRegistry.addName(new ItemStack(RemulaBlocks.baloinusOreBlocks, 1, 7), "Baloinus Tritanite Ore");
        LanguageRegistry.addName(new ItemStack(RemulaBlocks.baloinusOreBlocks, 1, 8), "Baloinus Balum Ore");
    	
    }
    
    public void registerIndikuBlocks() {
    	GameRegistry.registerBlock(RemulaBlocks.p3Liquidizer, "p3Liquidizer");
    	GameRegistry.registerBlock(RemulaBlocks.p3T1StorageUnit, "p3T1StorageUnit");
    	GameRegistry.registerBlock(RemulaBlocks.p3T2StorageUnit, "p3T2StorageUnit");
    	GameRegistry.registerBlock(RemulaBlocks.p3T3StorageUnit, "p3T3StorageUnit");
    	GameRegistry.registerBlock(RemulaBlocks.p3Generator, "p3Generator");
    	GameRegistry.registerBlock(RemulaBlocks.p3SolarPanel, "p3SolarPanel");
    	GameRegistry.registerBlock(RemulaBlocks.p3ThermalGenerator, "p3ThermalGenerator");
    	GameRegistry.registerBlock(RemulaBlocks.p3Grinder, "p3Grinder");
    	GameRegistry.registerBlock(RemulaBlocks.p3Compressor, "p3Compressor");
    	GameRegistry.registerBlock(RemulaBlocks.p3Furnace, "p3Furnace");
    	GameRegistry.registerBlock(RemulaBlocks.p3Extractor, "p3Extractor");
    	GameRegistry.registerBlock(RemulaBlocks.p3Crusher, "p3Crusher");
    	
    	GameRegistry.registerBlock(RemulaBlocks.indikuStone, "indikuStone");
    	GameRegistry.registerBlock(RemulaBlocks.indikuDirt, "indikuDirt");
    	GameRegistry.registerBlock(RemulaBlocks.indikuGrass, "indikuGrass");
    	GameRegistry.registerBlock(RemulaBlocks.indikuTerrainBlocks, ItemIndikuTerrainBlocks.class, "Remula" + (RemulaBlocks.indikuTerrainBlocks.getUnlocalizedName().substring(5)));
    	GameRegistry.registerBlock(RemulaBlocks.indikuOreBlocks, ItemIndikuOreBlocks.class, "Remula" + (RemulaBlocks.indikuOreBlocks.getUnlocalizedName().substring(5)));
    }
    
    public void addIndikuNames() {
    	LanguageRegistry.addName(RemulaBlocks.p3Liquidizer, "Phase 3 Liquidizer");
    	LanguageRegistry.addName(RemulaBlocks.p3T1StorageUnit, "Phase 3 Tier 1 Storage Unit");
    	LanguageRegistry.addName(RemulaBlocks.p3T2StorageUnit, "Phase 3 Tier 2 Storage Unit");
    	LanguageRegistry.addName(RemulaBlocks.p3T3StorageUnit, "Phase 3 Tier 3 Storage Unit");
    	LanguageRegistry.addName(RemulaBlocks.p3Generator, "Phase 3 Generator");
    	LanguageRegistry.addName(RemulaBlocks.p3SolarPanel, "Phase 3 Solar Panel");
    	LanguageRegistry.addName(RemulaBlocks.p3ThermalGenerator, "Phase 3 Thermal Generator");
    	LanguageRegistry.addName(RemulaBlocks.p3Grinder, "Phase 3 Grinder");
    	LanguageRegistry.addName(RemulaBlocks.p3Compressor, "Phase 3 Compressor");
    	LanguageRegistry.addName(RemulaBlocks.p3Furnace, "Phase 3 Furnace");
    	LanguageRegistry.addName(RemulaBlocks.p3Extractor, "Phase 3 Extractor");
    	LanguageRegistry.addName(RemulaBlocks.p3Crusher, "Phase 3 Crusher");
    	
    	LanguageRegistry.addName(RemulaBlocks.indikuStone, "Indiku Stone");
    	LanguageRegistry.addName(RemulaBlocks.indikuDirt, "Indiku Dirt");
    	LanguageRegistry.addName(RemulaBlocks.indikuGrass, "Indiku Grass");

        LanguageRegistry.addName(new ItemStack(RemulaBlocks.indikuTerrainBlocks, 1, 0), "Indiku Cobblestone");
        LanguageRegistry.addName(new ItemStack(RemulaBlocks.indikuTerrainBlocks, 1, 1), "Indiku Bricks");
        LanguageRegistry.addName(new ItemStack(RemulaBlocks.indikuTerrainBlocks, 1, 2), "Indiku Small Bricks");
        LanguageRegistry.addName(new ItemStack(RemulaBlocks.indikuTerrainBlocks, 1, 3), "Indiku Decorative Bricks");
        LanguageRegistry.addName(new ItemStack(RemulaBlocks.indikuTerrainBlocks, 1, 4), "Indiku Refined Stone");
        LanguageRegistry.addName(new ItemStack(RemulaBlocks.indikuTerrainBlocks, 1, 5), "Indiku Sand");
        LanguageRegistry.addName(new ItemStack(RemulaBlocks.indikuTerrainBlocks, 1, 6), "Indiku Glass");
        LanguageRegistry.addName(new ItemStack(RemulaBlocks.indikuOreBlocks, 1, 0), "Indiku Coal Ore");
        LanguageRegistry.addName(new ItemStack(RemulaBlocks.indikuOreBlocks, 1, 1), "Indiku Copper Ore");
        LanguageRegistry.addName(new ItemStack(RemulaBlocks.indikuOreBlocks, 1, 2), "Indiku Tin Ore");
        LanguageRegistry.addName(new ItemStack(RemulaBlocks.indikuOreBlocks, 1, 3), "Indiku Iron Ore");
        LanguageRegistry.addName(new ItemStack(RemulaBlocks.indikuOreBlocks, 1, 4), "Indiku Gold Ore");
        LanguageRegistry.addName(new ItemStack(RemulaBlocks.indikuOreBlocks, 1, 5), "Indiku Lapis Lazuli Ore");
        LanguageRegistry.addName(new ItemStack(RemulaBlocks.indikuOreBlocks, 1, 6), "Indiku Silvanite Ore");
        LanguageRegistry.addName(new ItemStack(RemulaBlocks.indikuOreBlocks, 1, 7), "Indiku Tritanite Ore");
        LanguageRegistry.addName(new ItemStack(RemulaBlocks.indikuOreBlocks, 1, 8), "Indiku Ventiium Ore");
        LanguageRegistry.addName(new ItemStack(RemulaBlocks.indikuOreBlocks, 1, 9), "Indiku Arithium Ore");
        LanguageRegistry.addName(new ItemStack(RemulaBlocks.indikuOreBlocks, 1, 10), "Indiku Zirinium Ore");
        LanguageRegistry.addName(new ItemStack(RemulaBlocks.indikuOreBlocks, 1, 11), "Indikite Ore");
    }
    
    public void registerElkostBlocks() {
    	GameRegistry.registerBlock(RemulaBlocks.p4Liquidizer, "p4Liquidizer");
    	GameRegistry.registerBlock(RemulaBlocks.p4T1StorageUnit, "p4T1StorageUnit");
    	GameRegistry.registerBlock(RemulaBlocks.p4T2StorageUnit, "p4T2StorageUnit");
    	GameRegistry.registerBlock(RemulaBlocks.p4T3StorageUnit, "p4T3StorageUnit");
    	GameRegistry.registerBlock(RemulaBlocks.p4Generator, "p4Generator");
    	GameRegistry.registerBlock(RemulaBlocks.p4SolarPanel, "p4SolarPanel");
    	GameRegistry.registerBlock(RemulaBlocks.p4ThermalGenerator, "p4ThermalGenerator");
    	GameRegistry.registerBlock(RemulaBlocks.p4Grinder, "p4Grinder");
    	GameRegistry.registerBlock(RemulaBlocks.p4Compressor, "p4Compressor");
    	GameRegistry.registerBlock(RemulaBlocks.p4Furnace, "p4Furnace");
    	GameRegistry.registerBlock(RemulaBlocks.p4Extractor, "p4Extractor");
    	GameRegistry.registerBlock(RemulaBlocks.p4Crusher, "p4Crusher");
    	
    	GameRegistry.registerBlock(RemulaBlocks.elkostTerrainBlocks, ItemElkostTerrainBlocks.class, "Remula" + (RemulaBlocks.elkostTerrainBlocks.getUnlocalizedName().substring(5)));
    	GameRegistry.registerBlock(RemulaBlocks.elkostOreBlocks, ItemElkostOreBlocks.class, "Remula" + (RemulaBlocks.elkostOreBlocks.getUnlocalizedName().substring(5)));
    }
    
    public void addElkostNames() {
    	LanguageRegistry.addName(RemulaBlocks.p4Liquidizer, "Phase 4 Liquidizer");
    	LanguageRegistry.addName(RemulaBlocks.p4T1StorageUnit, "Phase 4 Tier 1 Storage Unit");
    	LanguageRegistry.addName(RemulaBlocks.p4T2StorageUnit, "Phase 4 Tier 2 Storage Unit");
    	LanguageRegistry.addName(RemulaBlocks.p4T3StorageUnit, "Phase 4 Tier 3 Storage Unit");
    	LanguageRegistry.addName(RemulaBlocks.p4Generator, "Phase 4 Generator");
    	LanguageRegistry.addName(RemulaBlocks.p4SolarPanel, "Phase 4 Solar Panel");
    	LanguageRegistry.addName(RemulaBlocks.p4ThermalGenerator, "Phase 4 Thermal Generator");
    	LanguageRegistry.addName(RemulaBlocks.p4Grinder, "Phase 4 Grinder");
    	LanguageRegistry.addName(RemulaBlocks.p4Compressor, "Phase 4 Compressor");
    	LanguageRegistry.addName(RemulaBlocks.p4Furnace, "Phase 4 Furnace");
    	LanguageRegistry.addName(RemulaBlocks.p4Extractor, "Phase 4 Extractor");
    	LanguageRegistry.addName(RemulaBlocks.p4Crusher, "Phase 4 Crusher");
    	
        LanguageRegistry.addName(new ItemStack(RemulaBlocks.elkostTerrainBlocks, 1, 0), "Elkost Cobblestone");
        LanguageRegistry.addName(new ItemStack(RemulaBlocks.elkostTerrainBlocks, 1, 1), "Elkost Bricks");
        LanguageRegistry.addName(new ItemStack(RemulaBlocks.elkostTerrainBlocks, 1, 2), "Elkost Small Bricks");
        LanguageRegistry.addName(new ItemStack(RemulaBlocks.elkostTerrainBlocks, 1, 3), "Elkost Decorative Bricks");
        LanguageRegistry.addName(new ItemStack(RemulaBlocks.elkostTerrainBlocks, 1, 4), "Elkost Refined Stone");
        LanguageRegistry.addName(new ItemStack(RemulaBlocks.elkostTerrainBlocks, 1, 5), "Elkost Stone");
        LanguageRegistry.addName(new ItemStack(RemulaBlocks.elkostOreBlocks, 1, 0), "Elkost Coal Ore");
        LanguageRegistry.addName(new ItemStack(RemulaBlocks.elkostOreBlocks, 1, 1), "Elkost Copper Ore");
        LanguageRegistry.addName(new ItemStack(RemulaBlocks.elkostOreBlocks, 1, 2), "Elkost Tin Ore");
        LanguageRegistry.addName(new ItemStack(RemulaBlocks.elkostOreBlocks, 1, 3), "Elkost Iron Ore");
        LanguageRegistry.addName(new ItemStack(RemulaBlocks.elkostOreBlocks, 1, 4), "Elkost Gold Ore");
        LanguageRegistry.addName(new ItemStack(RemulaBlocks.elkostOreBlocks, 1, 5), "Elkost Lapis Lazuli Ore");            
        LanguageRegistry.addName(new ItemStack(RemulaBlocks.elkostOreBlocks, 1, 6), "Elkost Silvanite Ore");
        LanguageRegistry.addName(new ItemStack(RemulaBlocks.elkostOreBlocks, 1, 7), "Elkost Tritanite Ore");
        LanguageRegistry.addName(new ItemStack(RemulaBlocks.elkostOreBlocks, 1, 8), "Elkost Zirinium Ore");
        LanguageRegistry.addName(new ItemStack(RemulaBlocks.elkostOreBlocks, 1, 9), "Elkost Boria Ore");
        LanguageRegistry.addName(new ItemStack(RemulaBlocks.elkostOreBlocks, 1, 10), "Elkost Tristanium Ore");
        LanguageRegistry.addName(new ItemStack(RemulaBlocks.elkostOreBlocks, 1, 11), "Elkost Grinist Ore");
        LanguageRegistry.addName(new ItemStack(RemulaBlocks.elkostOreBlocks, 1, 12), "Elkost Elkostium Ore");
    }
    
    public void registerXylexiaBlocks() {
    	GameRegistry.registerBlock(RemulaBlocks.p5Liquidizer, "p5Liquidizer");
    	GameRegistry.registerBlock(RemulaBlocks.p5T1StorageUnit, "p5T1StorageUnit");
    	GameRegistry.registerBlock(RemulaBlocks.p5T2StorageUnit, "p5T2StorageUnit");
    	GameRegistry.registerBlock(RemulaBlocks.p5T3StorageUnit, "p5T3StorageUnit");
    	GameRegistry.registerBlock(RemulaBlocks.p5Generator, "p5Generator");
    	GameRegistry.registerBlock(RemulaBlocks.p5SolarPanel, "p5SolarPanel");
    	GameRegistry.registerBlock(RemulaBlocks.p5ThermalGenerator, "p5ThermalGenerator");
    	GameRegistry.registerBlock(RemulaBlocks.p5Grinder, "p5Grinder");
    	GameRegistry.registerBlock(RemulaBlocks.p5Compressor, "p5Compressor");
    	GameRegistry.registerBlock(RemulaBlocks.p5Furnace, "p5Furnace");
    	GameRegistry.registerBlock(RemulaBlocks.p5Extractor, "p5Extractor");
    	GameRegistry.registerBlock(RemulaBlocks.p5Crusher, "p5Crusher");
    	
    	GameRegistry.registerBlock(RemulaBlocks.xylexiaTerrainBlocks, ItemXylexiaTerrainBlocks.class, "Remula" + (RemulaBlocks.xylexiaTerrainBlocks.getUnlocalizedName().substring(5)));
    	GameRegistry.registerBlock(RemulaBlocks.xylexiaOreBlocks, ItemXylexiaOreBlocks.class, "Remula" + (RemulaBlocks.xylexiaOreBlocks.getUnlocalizedName().substring(5)));
    }
    
    public void addXylexiaNames() {
    	LanguageRegistry.addName(RemulaBlocks.p5Liquidizer, "Phase 5 Liquidizer");
    	LanguageRegistry.addName(RemulaBlocks.p5T1StorageUnit, "Phase 5 Tier 1 Storage Unit");
    	LanguageRegistry.addName(RemulaBlocks.p5T2StorageUnit, "Phase 5 Tier 2 Storage Unit");
    	LanguageRegistry.addName(RemulaBlocks.p5T3StorageUnit, "Phase 5 Tier 3 Storage Unit");
    	LanguageRegistry.addName(RemulaBlocks.p5Generator, "Phase 5 Generator");
    	LanguageRegistry.addName(RemulaBlocks.p5SolarPanel, "Phase 5 Solar Panel");
    	LanguageRegistry.addName(RemulaBlocks.p5ThermalGenerator, "Phase 5 Thermal Generator");
    	LanguageRegistry.addName(RemulaBlocks.p5Grinder, "Phase 5 Grinder");
    	LanguageRegistry.addName(RemulaBlocks.p5Compressor, "Phase 5 Compressor");
    	LanguageRegistry.addName(RemulaBlocks.p5Furnace, "Phase 5 Furnace");
    	LanguageRegistry.addName(RemulaBlocks.p5Extractor, "Phase 5 Extractor");
    	LanguageRegistry.addName(RemulaBlocks.p5Crusher, "Phase 5 Crusher");
    	
        LanguageRegistry.addName(new ItemStack(RemulaBlocks.xylexiaTerrainBlocks, 1, 0), "Xylexian Cobblestone");
        LanguageRegistry.addName(new ItemStack(RemulaBlocks.xylexiaTerrainBlocks, 1, 1), "Xylexian Bricks");
        LanguageRegistry.addName(new ItemStack(RemulaBlocks.xylexiaTerrainBlocks, 1, 2), "Xylexian Small Bricks");
        LanguageRegistry.addName(new ItemStack(RemulaBlocks.xylexiaTerrainBlocks, 1, 3), "Xylexian Decorative Bricks");
        LanguageRegistry.addName(new ItemStack(RemulaBlocks.xylexiaTerrainBlocks, 1, 4), "Xylexian Refined Stone");
        LanguageRegistry.addName(new ItemStack(RemulaBlocks.xylexiaTerrainBlocks, 1, 5), "Xylexian Glass");
        LanguageRegistry.addName(new ItemStack(RemulaBlocks.xylexiaOreBlocks, 1, 0), "Xylexian Coal Ore");
        LanguageRegistry.addName(new ItemStack(RemulaBlocks.xylexiaOreBlocks, 1, 1), "Xylexian Copper Ore");
        LanguageRegistry.addName(new ItemStack(RemulaBlocks.xylexiaOreBlocks, 1, 2), "Xylexian Tin Ore");
        LanguageRegistry.addName(new ItemStack(RemulaBlocks.xylexiaOreBlocks, 1, 3), "Xylexian Iron Ore");
        LanguageRegistry.addName(new ItemStack(RemulaBlocks.xylexiaOreBlocks, 1, 4), "Xylexian Gold Ore");
        LanguageRegistry.addName(new ItemStack(RemulaBlocks.xylexiaOreBlocks, 1, 5), "Xylexian Lapis Lazuli Ore");
        LanguageRegistry.addName(new ItemStack(RemulaBlocks.xylexiaOreBlocks, 1, 6), "Xylexian Silvanite Ore");
        LanguageRegistry.addName(new ItemStack(RemulaBlocks.xylexiaOreBlocks, 1, 7), "Xylexian Tritanite Ore");
        LanguageRegistry.addName(new ItemStack(RemulaBlocks.xylexiaOreBlocks, 1, 8), "Xylexian Zirinium Ore");
        LanguageRegistry.addName(new ItemStack(RemulaBlocks.xylexiaOreBlocks, 1, 9), "Xylexian Grinist Ore");
        LanguageRegistry.addName(new ItemStack(RemulaBlocks.xylexiaOreBlocks, 1, 10), "Xylexian Heri Ore");
        LanguageRegistry.addName(new ItemStack(RemulaBlocks.xylexiaOreBlocks, 1, 11), "Xylexian Skatha Ore");
        LanguageRegistry.addName(new ItemStack(RemulaBlocks.xylexiaOreBlocks, 1, 12), "Xylexian Kzori Ore");
        LanguageRegistry.addName(new ItemStack(RemulaBlocks.xylexiaOreBlocks, 1, 13), "Xylexite Ore");
    }
    
    public void registerDeepSpaceBlocks() {
    	
    }
    
    public void addDeepSpaceNames() {
    	
    }
    
    
    public void oreDictionary() {
        OreDictionary.registerOre("woodRubber", new ItemStack (RemulaBlocks.rubberLog));
        OreDictionary.registerOre("oreCoal", new ItemStack(RemulaBlocks.akatoeOreBlocks, 1, 0));
        OreDictionary.registerOre("oreIron", new ItemStack(RemulaBlocks.akatoeOreBlocks, 1, 3));
        OreDictionary.registerOre("oreGold", new ItemStack(RemulaBlocks.akatoeOreBlocks, 1, 4));
        OreDictionary.registerOre("oreCopper", new ItemStack(RemulaBlocks.akatoeOreBlocks, 1, 1));
        OreDictionary.registerOre("oreTin", new ItemStack(RemulaBlocks.akatoeOreBlocks, 1, 2));
        OreDictionary.registerOre("oreLapisLazuli", new ItemStack(RemulaBlocks.akatoeOreBlocks, 1, 5));
        OreDictionary.registerOre("orePorinite", new ItemStack(RemulaBlocks.akatoeOreBlocks, 1, 7));
        OreDictionary.registerOre("orePilk", new ItemStack(RemulaBlocks.akatoeOreBlocks, 1, 8));
        OreDictionary.registerOre("oreSilvanite", new ItemStack(RemulaBlocks.akatoeOreBlocks, 1, 6));
        OreDictionary.registerOre("oreAkatoe", new ItemStack(RemulaBlocks.akatoeOreBlocks, 1, 9));
    }
    
    public void dimensionManager() {
        DimensionManager.registerProviderType(Remula.akatoeDimension, AkatoeWorldProvider.class, false);
        DimensionManager.registerProviderType(Remula.baloinusDimension, BaloinusWorldProvider.class, false);
        DimensionManager.registerProviderType(Remula.deepSpaceDimension, DeepSpaceWorldProvider.class, false);
        DimensionManager.registerProviderType(Remula.indikuDimension, IndikuWorldProvider.class, false);
        DimensionManager.registerProviderType(Remula.elkostDimension, ElkostWorldProvider.class, false);
        DimensionManager.registerProviderType(Remula.xylexiaDimension, XylexiaWorldProvider.class, false);
        
        DimensionManager.registerDimension(Remula.akatoeDimension, Remula.akatoeDimension);
        DimensionManager.registerDimension(Remula.baloinusDimension, Remula.baloinusDimension);
        DimensionManager.registerDimension(Remula.deepSpaceDimension, Remula.deepSpaceDimension);
        DimensionManager.registerDimension(Remula.indikuDimension, Remula.indikuDimension);
        DimensionManager.registerDimension(Remula.elkostDimension, Remula.elkostDimension);
        DimensionManager.registerDimension(Remula.xylexiaDimension, Remula.xylexiaDimension);
    }
    
    
    
    
    /*public void registerBlocks() {
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
         LanguageRegistry.addName(boskinCrop, "Boskin Crop");
         LanguageRegistry.addName(plantFuxii, "Fuxii");
         
         //Storage and Tile Entites
         LanguageRegistry.addName(silvaniteChest, "Silvanite Chest");
         LanguageRegistry.addName(merciliteChest, "Mercilite Chest");
         LanguageRegistry.addName(tecmoniumChest, "Tecmonium Chest");

         //Register Blocks
         //Plants and Nature
         GameRegistry.registerBlock(akatoeLogs, ItemAkatoeLogs.class, "Remula" + (akatoeLogs.getUnlocalizedName().substring(5)));
         GameRegistry.registerBlock(akatoeLeaves, ItemAkatoeLeaves.class, "Remula" + (akatoeLeaves.getUnlocalizedName().substring(5)));
         GameRegistry.registerBlock(akatoeSaplings, ItemAkatoeSaplings.class, "Remula" + (akatoeSaplings.getUnlocalizedName().substring(5)));
         GameRegistry.registerBlock(rubberLog, "rubberLog");
         //GameRegistry.registerBlock(rubberLeaves, "rubberLeaves");
         GameRegistry.registerBlock(rubberSapling, "rubberSapling");
         /*GameRegistry.registerBlock(porinCrop, "porinCrop");
         GameRegistry.registerBlock(ulinCrop, "ulinCrop");
         GameRegistry.registerBlock(cirCrop, "cirCrop");
         GameRegistry.registerBlock(boskinCrop, "boskinCrop");
         GameRegistry.registerBlock(plantFuxii, "plantFuxii");

         
         //Storage Blocks/Tile Entites
         GameRegistry.registerBlock(silvaniteChest, "silvaniteChest");
         GameRegistry.registerBlock(merciliteChest, "merciliteChest");
         GameRegistry.registerBlock(tecmoniumChest, "tecmoniumChest");

         GameRegistry.registerBlock(akatoeTilledDirt, "akatoeTilledDirt");
         
         LanguageRegistry.addName(akatoePortal, "Akatoe Portal");
         LanguageRegistry.addName(akatoeStone, "Akatonian Stone");
         LanguageRegistry.addName(akatoeGrass, "Akatonian Grass");
         LanguageRegistry.addName(akatoeDirt, "Akatonian Dirt");
         LanguageRegistry.addName(akatoeSand, "Akatonian Sand");
         LanguageRegistry.addName(akatoeTilledDirt, "Akatonian Tilled Dirt");
         
         //Indiku
         GameRegistry.registerBlock(indikuTerrainBlocks, ItemIndikuTerrainBlocks.class, "Remula" + (indikuTerrainBlocks.getUnlocalizedName().substring(5)));
         GameRegistry.registerBlock(indikuOreBlocks, ItemIndikuOreBlocks.class, "Remula" + (indikuOreBlocks.getUnlocalizedName().substring(5)));
         GameRegistry.registerBlock(indikuPortal, "indikuPortal");
         GameRegistry.registerBlock(indikuStone, "indikuStone");
         GameRegistry.registerBlock(indikuDirt, "indikuDirt");
         GameRegistry.registerBlock(indikuGrass, "indikuGrass");
         GameRegistry.registerBlock(indikuTilledDirt, "indikuTilledDirt");
         
         
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
         MinecraftForge.setBlockHarvestLevel(silverOre, "pickaxe", 2);
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
         
         GameRegistry.registerWorldGenerator(new WorldGenAkatoeTrees(false));
         GameRegistry.registerWorldGenerator(new WorldGen());
         NetworkRegistry.instance().registerGuiHandler(this, new GuiHandler());
         GameRegistry.removeBiome(akatoePlainsBiome);
         GameRegistry.removeBiome(akatoeWastelandBiome);
         GameRegistry.removeBiome(akatoeDesertBiome);
         GameRegistry.removeBiome(akatoeOceanBiome);
         GameRegistry.removeBiome(baloinusPlainsBiome);
         GameRegistry.removeBiome(elkostDesertBiome);
         GameRegistry.removeBiome(indikuJungleBiome);
         GameRegistry.removeBiome(xylexiaPlainsBiome);
    }/**/
}