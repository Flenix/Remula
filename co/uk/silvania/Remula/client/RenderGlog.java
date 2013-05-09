package co.uk.silvania.Remula.client;

import co.uk.silvania.Remula.entity.akatoe.EntityGlog;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;

public class RenderGlog extends RenderLiving {
	
	public RenderGlog(ModelBase par1ModelBase, float par2) {
		super(par1ModelBase, par2);
	}
	
	public void renderGlog(EntityGlog par1EntityGlog, double par2, double par4, double par6, float par8, float par9) {
		super.doRenderLiving(par1EntityGlog,  par2,  par4,  par6, par8,  par9);
	}
	
	public void doRenderLiving(EntityLiving par1EntityLiving, double par2, double par4, double par6, float par8, float par9) {
		this.renderGlog((EntityGlog)par1EntityLiving, par2, par4, par6, par8, par9);
	}
	
	public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9) {
		this.renderGlog((EntityGlog)par1Entity, par2, par4, par6, par8, par9);
	}
}
