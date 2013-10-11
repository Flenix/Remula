package co.uk.silvania.Remula.client;

import co.uk.silvania.Remula.entity.EntityAdvRobot;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;

@SideOnly(Side.CLIENT)
public class RenderRobot extends RenderLiving {
    private static final ResourceLocation getTexture = new ResourceLocation("remula", "textures/entities/mobrobot.png");

    public RenderRobot(ModelBase par1ModelBase, float par2) {
        super(par1ModelBase, par2);
    }

    protected ResourceLocation setTexture(EntityAdvRobot entity) {
        return getTexture;
    }

    @Override
    protected ResourceLocation getEntityTexture(Entity entity) {
        return this.setTexture((EntityAdvRobot)entity);
    }
}