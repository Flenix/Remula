package co.uk.silvania.Remula.client;

import co.uk.silvania.Remula.entity.akatoe.EntitySkitterling;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;

public class RenderSkitterling extends RenderLiving {
	
	public RenderSkitterling(ModelBase par1ModelBase, float par2) {
		super(par1ModelBase, par2);
	}
	
	public void renderSkitterling(EntitySkitterling par1EntitySkitterling, double par2, double par4, double par6, float par8, float par9) {
		super.doRenderLiving(par1EntitySkitterling,  par2,  par4,  par6, par8,  par9);
	}
	
	public void doRenderLiving(EntityLiving par1EntityLiving, double par2, double par4, double par6, float par8, float par9) {
		this.renderSkitterling((EntitySkitterling)par1EntityLiving, par2, par4, par6, par8, par9);
	}
	
	public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9) {
		this.renderSkitterling((EntitySkitterling)par1Entity, par2, par4, par6, par8, par9);
	}
	
	@Override
	protected ResourceLocation func_110775_a(Entity entity) {
		// TODO Auto-generated method stub
		return null;
	}
}
