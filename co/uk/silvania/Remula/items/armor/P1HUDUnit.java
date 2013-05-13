package co.uk.silvania.Remula.items.armor;
 
import co.uk.silvania.Remula.Remula;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.IArmorTextureProvider;
 
public class P1HUDUnit extends ItemArmor implements IArmorTextureProvider {
	public boolean attachedMask;

	public P1HUDUnit(int par1, EnumArmorMaterial material, int i, int j, boolean breathable) {
	   super(par1, material, i, j);
	   setCreativeTab(Remula.tabRemula);
	   this.attachedMask = breathable;
   }
 
   	public String getArmorTextureFile(ItemStack itemstack) {
   		return this.attachedMask ? "/micdoodle8/mods/galacticraft/core/client/armor/sensorox_1.png" : "/micdoodle8/mods/galacticraft/core/client/armor/sensor_1.png";
   }
 
	public String getTextureFile() {
		return "/micdoodle8/mods/galacticraft/core/client/items/core.png";
   }
 }
