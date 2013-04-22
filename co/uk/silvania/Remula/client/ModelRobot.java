package co.uk.silvania.Remula.client;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelRobot extends ModelBase
{
  //fields
    ModelRenderer head;
    ModelRenderer body;
    ModelRenderer rightarm;
    ModelRenderer leftarm;
    ModelRenderer rightleg;
    ModelRenderer leftleg;
    ModelRenderer Right_Hand_L;
    ModelRenderer Right_Hand_R;
    ModelRenderer Left_Hand_L;
    ModelRenderer Left_Hand_R;
    ModelRenderer Shape1;
    ModelRenderer Shape2;
  
  public ModelRobot()
  {
    textureWidth = 64;
    textureHeight = 32;
    
      head = new ModelRenderer(this, 0, 0);
      head.addBox(-4F, -8F, -4F, 8, 8, 8);
      head.setRotationPoint(0F, 0F, 0F);
      head.setTextureSize(64, 32);
      head.mirror = true;
      setRotation(head, 0F, 0F, 0F);
      body = new ModelRenderer(this, 16, 16);
      body.addBox(-4F, 0F, -2F, 8, 12, 4);
      body.setRotationPoint(0F, 0F, 0F);
      body.setTextureSize(64, 32);
      body.mirror = true;
      setRotation(body, 0F, 0F, 0F);
      rightarm = new ModelRenderer(this, 40, 16);
      rightarm.addBox(-3F, -2F, -2F, 4, 10, 4);
      rightarm.setRotationPoint(-5F, 2F, 0F);
      rightarm.setTextureSize(64, 32);
      rightarm.mirror = true;
      setRotation(rightarm, 0F, 0F, 0F);
      leftarm = new ModelRenderer(this, 40, 16);
      leftarm.addBox(-1F, -2F, -2F, 4, 10, 4);
      leftarm.setRotationPoint(5F, 2F, 0F);
      leftarm.setTextureSize(64, 32);
      leftarm.mirror = true;
      setRotation(leftarm, 0F, 0F, 0F);
      rightleg = new ModelRenderer(this, 0, 16);
      rightleg.addBox(-2F, 0F, -2F, 4, 12, 4);
      rightleg.setRotationPoint(-2F, 12F, 0F);
      rightleg.setTextureSize(64, 32);
      rightleg.mirror = true;
      setRotation(rightleg, 0F, 0F, 0F);
      leftleg = new ModelRenderer(this, 0, 16);
      leftleg.addBox(-2F, 0F, -2F, 4, 12, 4);
      leftleg.setRotationPoint(2F, 12F, 0F);
      leftleg.setTextureSize(64, 32);
      leftleg.mirror = true;
      setRotation(leftleg, 0F, 0F, 0F);
      Right_Hand_L = new ModelRenderer(this, 0, 0);
      Right_Hand_L.addBox(0F, 0F, 0F, 1, 2, 4);
      Right_Hand_L.setRotationPoint(-5F, 10F, -2F);
      Right_Hand_L.setTextureSize(64, 32);
      Right_Hand_L.mirror = true;
      setRotation(Right_Hand_L, 0F, 0F, 0F);
      Right_Hand_R = new ModelRenderer(this, 0, 0);
      Right_Hand_R.addBox(0F, 0F, 0F, 1, 2, 4);
      Right_Hand_R.setRotationPoint(-8F, 10F, -2F);
      Right_Hand_R.setTextureSize(64, 32);
      Right_Hand_R.mirror = true;
      setRotation(Right_Hand_R, 0F, 0F, 0F);
      Left_Hand_L = new ModelRenderer(this, 0, 0);
      Left_Hand_L.addBox(0F, 0F, 0F, 1, 2, 4);
      Left_Hand_L.setRotationPoint(7F, 10F, -2F);
      Left_Hand_L.setTextureSize(64, 32);
      Left_Hand_L.mirror = true;
      setRotation(Left_Hand_L, 0F, 0F, 0F);
      Left_Hand_R = new ModelRenderer(this, 0, 0);
      Left_Hand_R.addBox(0F, 0F, 0F, 1, 2, 4);
      Left_Hand_R.setRotationPoint(4F, 10F, -2F);
      Left_Hand_R.setTextureSize(64, 32);
      Left_Hand_R.mirror = true;
      setRotation(Left_Hand_R, 0F, 0F, 0F);
      Shape1 = new ModelRenderer(this, 0, 0);
      Shape1.addBox(0F, 0F, 0F, 1, 2, 1);
      Shape1.setRotationPoint(-0.5F, -10F, -0.5F);
      Shape1.setTextureSize(64, 32);
      Shape1.mirror = true;
      setRotation(Shape1, 0F, 0F, 0F);
      Shape2 = new ModelRenderer(this, 0, 0);
      Shape2.addBox(0F, 0F, 0F, 2, 2, 2);
      Shape2.setRotationPoint(-1F, -12F, -1F);
      Shape2.setTextureSize(64, 32);
      Shape2.mirror = true;
      setRotation(Shape2, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    head.render(f5);
    body.render(f5);
    rightarm.render(f5);
    leftarm.render(f5);
    rightleg.render(f5);
    leftleg.render(f5);
    Right_Hand_L.render(f5);
    Right_Hand_R.render(f5);
    Left_Hand_L.render(f5);
    Left_Hand_R.render(f5);
    Shape1.render(f5);
    Shape2.render(f5);
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
