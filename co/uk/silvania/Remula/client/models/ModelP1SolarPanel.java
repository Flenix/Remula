package co.uk.silvania.Remula.client.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelP1SolarPanel extends ModelBase
{
  //fields
    ModelRenderer Panel;
    ModelRenderer StandCenter;
    ModelRenderer StandRight;
    ModelRenderer StandLeft;
    ModelRenderer Connection2;
    ModelRenderer Connection1;
  
  public ModelP1SolarPanel()
  {
    textureWidth = 64;
    textureHeight = 32;
    
      Panel = new ModelRenderer(this, 0, 0);
      Panel.addBox(0F, 0F, -8F, 16, 1, 16);
      Panel.setRotationPoint(-8F, 20F, 0F);
      Panel.setTextureSize(64, 32);
      Panel.mirror = true;
      setRotation(Panel, 0.3490659F, 0F, 0F);
      StandCenter = new ModelRenderer(this, 0, 0);
      StandCenter.addBox(0F, 0F, 0F, 2, 6, 1);
      StandCenter.setRotationPoint(-1F, 19F, 4F);
      StandCenter.setTextureSize(64, 32);
      StandCenter.mirror = true;
      setRotation(StandCenter, 0.3490659F, 0F, 0F);
      StandRight = new ModelRenderer(this, 0, 0);
      StandRight.addBox(0F, 0F, 0F, 2, 6, 1);
      StandRight.setRotationPoint(5F, 19F, 4F);
      StandRight.setTextureSize(64, 32);
      StandRight.mirror = true;
      setRotation(StandRight, 0.3490659F, 0F, 0F);
      StandLeft = new ModelRenderer(this, 0, 0);
      StandLeft.addBox(0F, 0F, 0F, 2, 6, 1);
      StandLeft.setRotationPoint(-7F, 19F, 4F);
      StandLeft.setTextureSize(64, 32);
      StandLeft.mirror = true;
      setRotation(StandLeft, 0.3490659F, 0F, 0F);
      Connection2 = new ModelRenderer(this, 0, 7);
      Connection2.addBox(0F, 0F, 0F, 3, 3, 3);
      Connection2.setRotationPoint(-1.5F, 21F, -1.5F);
      Connection2.setTextureSize(64, 32);
      Connection2.mirror = true;
      setRotation(Connection2, 0F, 0F, 0F);
      Connection1 = new ModelRenderer(this, 0, 7);
      Connection1.addBox(0F, 0.1F, 0F, 3, 1, 3);
      Connection1.setRotationPoint(-1.5F, 21F, -1.7F);
      Connection1.setTextureSize(64, 32);
      Connection1.mirror = true;
      setRotation(Connection1, 0.3490659F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    Panel.render(f5);
    StandCenter.render(f5);
    StandRight.render(f5);
    StandLeft.render(f5);
    Connection2.render(f5);
    Connection1.render(f5);
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
  }

}
