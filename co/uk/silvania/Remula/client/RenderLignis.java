package co.uk.silvania.Remula.client;

import co.uk.silvania.Remula.entity.akatoe.EntityLignis;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;

public class RenderLignis extends RenderLiving {
	
	public RenderLignis(ModelBase par1ModelBase, float par2) {
		super(par1ModelBase, par2);
	}
	
	public void renderLignis(EntityLignis par1EntityLignis, double par2, double par4, double par6, float par8, float par9) {
		super.doRenderLiving(par1EntityLignis,  par2,  par4,  par6, par8,  par9);
	}
	
	public void doRenderLiving(EntityLiving par1EntityLiving, double par2, double par4, double par6, float par8, float par9) {
		this.renderLignis((EntityLignis)par1EntityLiving, par2, par4, par6, par8, par9);
	}
	
	public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9) {
		this.renderLignis((EntityLignis)par1Entity, par2, par4, par6, par8, par9);
	}
}
