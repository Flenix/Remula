package co.uk.silvania.Remula.client;

import co.uk.silvania.Remula.entity.baloinus.EntityXylexian;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;

@SideOnly(Side.CLIENT)
public class RenderXylexian extends RenderLiving
{
    private static final ResourceLocation field_110833_a = new ResourceLocation("remula", "textures/entities/mobxylexian.png");

    public RenderXylexian(ModelBase par1ModelBase, float par2)
    {
        super(par1ModelBase, par2);
    }

    protected ResourceLocation func_110832_a(EntityXylexian entity)
    {
        return field_110833_a;
    }

    protected ResourceLocation func_110775_a(Entity entity)
    {
        return this.func_110832_a((EntityXylexian)entity);
    }
}