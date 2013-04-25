package co.uk.silvania.Remula;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import co.uk.silvania.Remula.CommonProxy;
import co.uk.silvania.Remula.blocks.RemulaCraftingTable;
import co.uk.silvania.Remula.blocks.RemulaLiquidizer;
import co.uk.silvania.Remula.blocks.RemulaOre;
import co.uk.silvania.Remula.blocks.RemulaStorageUnit;
import co.uk.silvania.Remula.items.AdvancedRemulaChip;
import co.uk.silvania.Remula.items.RemulaDust;
import co.uk.silvania.Remula.items.RemulaIngot;
import co.uk.silvania.Remula.items.RobotSpawningItem;
import co.uk.silvania.roads.WorldGen;
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
    
    //Prepare for config!
    public static int blockRemulaID;
    @SideOnly(Side.CLIENT)

    @PreInit
    public void preInit(FMLPreInitializationEvent event) {
    	NetworkRegistry.instance().registerGuiHandler(this,  this.proxy);
    	instance = this;    	
    }
    //Blocks (IDs 1800-2000 to avoid clash with top 100 mods)
    public final static Block remulaOre = new RemulaOre(1800, 0).setBlockName("remulaOre");
    public final static Block remulaLiquidizer = new RemulaLiquidizer(1801, 0, Material.iron).setBlockName("remulaLiquidizer");
    public final static Block remulaCraftingTable = new RemulaCraftingTable(1802, 0, Material.iron).setBlockName("remulaCraftingTable");
    public final static Block remulaStorageUnit = new RemulaStorageUnit(1803, 0, Material.iron).setBlockName("remulaStorageUnit");
    
    //Liquids
    
    //Items (IDs 17000 - 17300)
	public final static Item advancedRemulaChip = new AdvancedRemulaChip(17000).setItemName("advancedRemulaChip");
	public final static Item remulaDust = new RemulaDust(17001).setItemName("remulaDust");
	public final static Item remulaIngot = new RemulaIngot(17002).setItemName("remulaIngot");
	public final static Item robotSpawner = new RobotSpawningItem(17003).setItemName("robotSpawner");
    
	
	//And finally the worldgen
	public static WorldGen worldGen = new WorldGen();
	
    @Init
    public void load(FMLInitializationEvent event) {
            proxy.registerRenderThings();
            proxy.init();
            
            LanguageRegistry.addName(remulaOre, "Remula Ore");
            GameRegistry.registerBlock(remulaOre, "remulaOre");
            MinecraftForge.setBlockHarvestLevel(remulaOre, "pickaxe", 3);
            
            
            //Items
            LanguageRegistry.addName(advancedRemulaChip, "Advanced Remula Chip");
            LanguageRegistry.addName(remulaDust, "Remula Dust");
            LanguageRegistry.addName(remulaIngot, "Remula Ingot");
            LanguageRegistry.addName(robotSpawner, "Flendroid 5000");
            
            GameRegistry.registerItem(advancedRemulaChip, "advancedRemulaChip");
            GameRegistry.registerItem(remulaDust, "remulaDust");
            GameRegistry.registerItem(remulaIngot, "remulaIngot");
            GameRegistry.registerItem(robotSpawner, "robotSpawner");
            
            
            //Other
            LanguageRegistry.instance().addStringLocalization("itemGroup.tabRemula", "en_US", "Remula");
            
            //Setup the world generator
            GameRegistry.registerWorldGenerator(new WorldGen());
    }


	@PostInit
    public void postInit(FMLPostInitializationEvent event) {
            // Stub Method
    		}
	};

