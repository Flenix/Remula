package co.uk.silvania.Remula.client;

import co.uk.silvania.Remula.entity.akatoe.EntityHermust;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;

public class RenderHermust extends RenderLiving {
	
	public RenderHermust(ModelBase par1ModelBase, float par2) {
		super(par1ModelBase, par2);
	}
	
	public void renderHermust(EntityHermust par1EntityHermust, double par2, double par4, double par6, float par8, float par9) {
		super.doRenderLiving(par1EntityHermust,  par2,  par4,  par6, par8,  par9);
	}
	
	public void doRenderLiving(EntityLiving par1EntityLiving, double par2, double par4, double par6, float par8, float par9) {
		this.renderHermust((EntityHermust)par1EntityLiving, par2, par4, par6, par8, par9);
	}
	
	public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9) {
		this.renderHermust((EntityHermust)par1Entity, par2, par4, par6, par8, par9);
	}
	
	@Override
	protected ResourceLocation func_110775_a(Entity entity) {
		// TODO Auto-generated method stub
		return null;
	}
}
