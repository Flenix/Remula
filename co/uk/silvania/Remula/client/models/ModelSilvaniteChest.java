package co.uk.silvania.Remula.client.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;

public class ModelSilvaniteChest extends ModelBase
{
  //fields
    ModelRenderer Front;
    ModelRenderer Back;
    ModelRenderer Base;
    ModelRenderer LeftSide;
    ModelRenderer RightSide;
    ModelRenderer TopRight;
    ModelRenderer TopLeft;
    ModelRenderer TopFront;
    ModelRenderer TopBack;
    ModelRenderer LidRight;
    ModelRenderer LidLeft;
    ModelRenderer Tank1;
  
  public ModelSilvaniteChest()
  {
    textureWidth = 128;
    textureHeight = 64;
    
      Front = new ModelRenderer(this, 0, 49);
      Front.addBox(-7F, -2F, -5F, 14, 14, 1);
      Front.setRotationPoint(0F, 12F, -2F);
      Front.setTextureSize(128, 64);
      Front.mirror = true;
      setRotation(Front, 0F, 0F, 0F);
      Back = new ModelRenderer(this, 0, 34);
      Back.addBox(-7F, -2F, 4F, 14, 14, 1);
      Back.setRotationPoint(0F, 12F, -2F);
      Back.setTextureSize(128, 64);
      Back.mirror = true;
      setRotation(Back, 0F, 0F, 0F);
      Base = new ModelRenderer(this, 26, 0);
      Base.addBox(-7F, 11.9F, -5F, 14, 0, 10);
      Base.setRotationPoint(0F, 12F, -2F);
      Base.setTextureSize(128, 64);
      Base.mirror = true;
      setRotation(Base, 0F, 0F, 0F);
      LeftSide = new ModelRenderer(this, 48, 42);
      LeftSide.addBox(-7F, -2F, -4F, 1, 14, 8);
      LeftSide.setRotationPoint(0F, 12F, -2F);
      LeftSide.setTextureSize(128, 64);
      LeftSide.mirror = true;
      setRotation(LeftSide, 0F, 0F, 0F);
      RightSide = new ModelRenderer(this, 30, 42);
      RightSide.addBox(6F, -2F, -4F, 1, 14, 8);
      RightSide.setRotationPoint(0F, 12F, -2F);
      RightSide.setTextureSize(128, 64);
      RightSide.mirror = true;
      setRotation(RightSide, 0F, 0F, 0F);
      TopRight = new ModelRenderer(this, 30, 31);
      TopRight.addBox(3F, -3F, -5F, 4, 1, 10);
      TopRight.setRotationPoint(0F, 12F, -2F);
      TopRight.setTextureSize(128, 64);
      TopRight.mirror = true;
      setRotation(TopRight, 0F, 0F, 0F);
      TopLeft = new ModelRenderer(this, 0, 22);
      TopLeft.addBox(-7F, -3F, -5F, 4, 1, 10);
      TopLeft.setRotationPoint(0F, 12F, -2F);
      TopLeft.setTextureSize(128, 64);
      TopLeft.mirror = true;
      setRotation(TopLeft, 0F, 0F, 0F);
      TopFront = new ModelRenderer(this, 28, 21);
      TopFront.addBox(-3F, -3F, -5F, 6, 1, 2);
      TopFront.setRotationPoint(0F, 12F, -2F);
      TopFront.setTextureSize(128, 64);
      TopFront.mirror = true;
      setRotation(TopFront, 0F, 0F, 0F);
      TopBack = new ModelRenderer(this, 28, 21);
      TopBack.addBox(-3F, -3F, 3F, 6, 1, 2);
      TopBack.setRotationPoint(0F, 12F, -2F);
      TopBack.setTextureSize(128, 64);
      TopBack.mirror = true;
      setRotation(TopBack, 0F, 0F, 0F);
      LidRight = new ModelRenderer(this, 28, 24);
      LidRight.addBox(0F, -2.8F, -3F, 3, 1, 6);
      LidRight.setRotationPoint(0F, 12F, -2F);
      LidRight.setTextureSize(128, 64);
      LidRight.mirror = true;
      setRotation(LidRight, 0F, 0F, 0F);
      LidLeft.mirror = true;
      LidLeft = new ModelRenderer(this, 28, 24);
      LidLeft.addBox(-3F, -2.8F, -3F, 3, 1, 6);
      LidLeft.setRotationPoint(0F, 12F, -2F);
      LidLeft.setTextureSize(128, 64);
      LidLeft.mirror = true;
      setRotation(LidLeft, 0F, 0F, 0F);
      LidLeft.mirror = false;
      Tank1 = new ModelRenderer(this, 0, 0);
      Tank1.addBox(-1.5F, -1F, 4F, 3, 12, 3);
      Tank1.setRotationPoint(0F, 12F, -2F);
      Tank1.setTextureSize(128, 64);
      Tank1.mirror = true;
      setRotation(Tank1, 0F, 0F, 0F);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void renderAll()
  {
      this.Front.render(0.0625F);
      this.Back.render(0.0625F);
      this.Base.render(0.0625F);
      this.LeftSide.render(0.0625F);
      this.RightSide.render(0.0625F);
      this.TopRight.render(0.0625F);
      this.TopLeft.render(0.0625F);
      this.TopFront.render(0.0625F);
      this.TopBack.render(0.0625F);
      this.LidRight.render(0.0625F);
      this.LidLeft.render(0.0625F);
      this.Tank1.render(0.0625F);
  }
  
  /*public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5);
    Front.render(f5);
    Back.render(f5);
    Base.render(f5);
    LeftSide.render(f5);
    RightSide.render(f5);
    TopRight.render(f5);
    TopLeft.render(f5);
    TopFront.render(f5);
    TopBack.render(f5);
    LidRight.render(f5);
    LidLeft.render(f5);
    Tank1.render(f5);
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.setRotationAngles(f, f1, f2, f3, f4, f5);
  }*/

}
