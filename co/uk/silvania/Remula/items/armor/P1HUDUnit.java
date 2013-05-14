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
	   this.setIconIndex(0);
	   this.attachedMask = breathable;
   }
 
   	public String getArmorTextureFile(ItemStack itemstack) {
   		return this.attachedMask ? "/co/uk/silvania/Remula/resources/sensorox_1.png" : "/co/uk/silvania/Remula/resources/sensor_1.png";
   }
 
	public String getTextureFile() {
		return "/co/uk/silvania/Remula/resources/armor.png";
   }
 }
