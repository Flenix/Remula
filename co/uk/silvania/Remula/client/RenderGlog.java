package co.uk.silvania.Remula.client;

import co.uk.silvania.Remula.entity.akatoe.EntityGlog;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;

@SideOnly(Side.CLIENT)
public class RenderGlog extends RenderLiving
{
    private static final ResourceLocation getTexture = new ResourceLocation("remula", "textures/entities/mobglog.png");

    public RenderGlog(ModelBase par1ModelBase, float par2) {
        super(par1ModelBase, par2);
    }

    protected ResourceLocation setTexture(EntityGlog entity) {
        return getTexture;
    }

    @Override
    protected ResourceLocation getEntityTexture(Entity entity) {
        return this.setTexture((EntityGlog)entity);
    }
}