package co.uk.silvania.Remula.client;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelAkatonian extends ModelBase
{
  //fields
    ModelRenderer LeftAntenna;
    ModelRenderer RightAntenna;
    ModelRenderer Head;
    ModelRenderer Body;
    ModelRenderer Rightarm;
    ModelRenderer Leftarm;
    ModelRenderer Leftleg;
    ModelRenderer Rightleg;
  
  public ModelAkatonian()
  {
    textureWidth = 64;
    textureHeight = 32;
    
      LeftAntenna = new ModelRenderer(this, 0, 0);
      LeftAntenna.addBox(-0.5F, -11F, 0.5F, 1, 4, 1);
      LeftAntenna.setRotationPoint(0F, 10F, 0F);
      LeftAntenna.setTextureSize(64, 32);
      LeftAntenna.mirror = true;
      setRotation(LeftAntenna, 0.5235988F, -0.5235988F, 0F);
      RightAntenna = new ModelRenderer(this, 0, 0);
      RightAntenna.addBox(-0.5F, -11F, 0.5F, 1, 4, 1);
      RightAntenna.setRotationPoint(0F, 10F, 0F);
      RightAntenna.setTextureSize(64, 32);
      RightAntenna.mirror = true;
      setRotation(RightAntenna, 0.5235988F, 0.5235988F, 0F);
      Head = new ModelRenderer(this, 0, 0);
      Head.addBox(-3F, -8F, -3F, 6, 6, 6);
      Head.setRotationPoint(0F, 10F, 0F);
      Head.setTextureSize(64, 32);
      Head.mirror = true;
      setRotation(Head, 0F, 0F, 0F);
      Body = new ModelRenderer(this, 8, 12);
      Body.addBox(-3F, -2F, -1F, 6, 8, 2);
      Body.setRotationPoint(0F, 10F, 0F);
      Body.setTextureSize(64, 32);
      Body.mirror = true;
      setRotation(Body, 0F, 0F, 0F);
      Rightarm = new ModelRenderer(this, 24, 12);
      Rightarm.addBox(-2F, 0F, -2F, 2, 8, 2);
      Rightarm.setRotationPoint(-3F, 8F, 1F);
      Rightarm.setTextureSize(64, 32);
      Rightarm.mirror = true;
      setRotation(Rightarm, 0F, 0F, 0F);
      Leftarm = new ModelRenderer(this, 24, 12);
      Leftarm.addBox(0F, 0F, -2F, 2, 8, 2);
      Leftarm.setRotationPoint(3F, 8F, 1F);
      Leftarm.setTextureSize(64, 32);
      Leftarm.mirror = true;
      setRotation(Leftarm, 0F, 0F, 0F);
      Leftarm.mirror = true;
      Leftleg = new ModelRenderer(this, 0, 12);
      Leftleg.addBox(0F, 0F, -2F, 2, 8, 2);
      Leftleg.setRotationPoint(1F, 16F, 1F);
      Leftleg.setTextureSize(64, 32);
      Leftleg.mirror = true;
      setRotation(Leftleg, 0F, 0F, 0F);
      Rightleg = new ModelRenderer(this, 0, 12);
      Rightleg.addBox(-2F, 0F, -2F, 2, 8, 2);
      Rightleg.setRotationPoint(-1F, 16F, 1F);
      Rightleg.setTextureSize(64, 32);
      Rightleg.mirror = true;
      setRotation(Rightleg, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    LeftAntenna.render(f5);
    RightAntenna.render(f5);
    Head.render(f5);
    Body.render(f5);
    Rightarm.render(f5);
    Leftarm.render(f5);
    Leftleg.render(f5);
    Rightleg.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
  {
    super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    
    this.Head.rotateAngleX = f4 / (180F / (float)Math.PI);
    this.Head.rotateAngleY = f3 / (180F / (float)Math.PI);
    this.LeftAntenna.rotateAngleX = f4 / (180F / (float)Math.PI);
    this.LeftAntenna.rotateAngleY = f3 / (180F / (float)Math.PI);
    this.RightAntenna.rotateAngleX = f4 / (180F / (float)Math.PI);
    this.RightAntenna.rotateAngleY = f3 / (180F / (float)Math.PI);
    this.Rightarm.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
    this.Leftleg.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
    this.Leftarm.rotateAngleX = MathHelper.cos(f * 0.6662F + (float)Math.PI) * 1.4F * f1;
    this.Rightleg.rotateAngleX = MathHelper.cos(f * 0.6662F + (float)Math.PI) * 1.4F * f1;
  }

}
