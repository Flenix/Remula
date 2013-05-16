// Date: 15/05/2013 23:21:12
// Template version 1.1
// Java generated by Techne
// Keep in mind that you still need to fill in some blanks
// - ZeuX






package co.uk.silvania.Remula.client.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelLignis extends ModelBase
{
  //fields
    ModelRenderer Body;
    ModelRenderer RightInnerWing;
    ModelRenderer LeftInnerWing;
    ModelRenderer RightOuterWing;
    ModelRenderer LeftOuterWing;
    ModelRenderer LeftLeg;
    ModelRenderer RightLeg;
    ModelRenderer Tail3;
    ModelRenderer Tail1;
    ModelRenderer ReadBody2;
    ModelRenderer RearBody4;
    ModelRenderer Tail5;
    ModelRenderer Tail2;
    ModelRenderer Tail4;
    ModelRenderer Body2;
    ModelRenderer RearBody1;
    ModelRenderer ReadyBody3;
    ModelRenderer Body3;
    ModelRenderer Neck1;
    ModelRenderer Neck2;
    ModelRenderer Head;
    ModelRenderer LeftTalon1;
    ModelRenderer Shape1;
    ModelRenderer Shape2;
    ModelRenderer Shape3;
    ModelRenderer Shape4;
    ModelRenderer Shape5;
  
  public ModelLignis()
  {
    textureWidth = 128;
    textureHeight = 64;
    
      Body = new ModelRenderer(this, 0, 30);
      Body.addBox(-5F, 0F, 0F, 10, 4, 16);
      Body.setRotationPoint(0F, 14F, -8F);
      Body.setTextureSize(128, 64);
      Body.mirror = true;
      setRotation(Body, 0F, 0F, 0F);
      RightInnerWing = new ModelRenderer(this, 0, 15);
      RightInnerWing.addBox(-16F, -0.4666667F, -7F, 16, 1, 14);
      RightInnerWing.setRotationPoint(-4F, 15F, 0F);
      RightInnerWing.setTextureSize(128, 64);
      RightInnerWing.mirror = true;
      setRotation(RightInnerWing, 0F, 0.1396263F, 0.2617994F);
      LeftInnerWing = new ModelRenderer(this, 0, 15);
      LeftInnerWing.addBox(0F, -0.5333334F, -7F, 16, 1, 14);
      LeftInnerWing.setRotationPoint(4F, 15F, 0F);
      LeftInnerWing.setTextureSize(128, 64);
      LeftInnerWing.mirror = true;
      setRotation(LeftInnerWing, 0F, -0.1396263F, -0.2617994F);
      RightOuterWing = new ModelRenderer(this, 0, 15);
      RightOuterWing.addBox(-32F, -0.5F, -7F, 16, 1, 14);
      RightOuterWing.setRotationPoint(-4F, 15F, 0F);
      RightOuterWing.setTextureSize(128, 64);
      RightOuterWing.mirror = true;
      setRotation(RightOuterWing, 0F, 0.1396263F, -0.2617994F);
      LeftOuterWing = new ModelRenderer(this, 0, 15);
      LeftOuterWing.addBox(16F, -0.5F, -7F, 16, 1, 14);
      LeftOuterWing.setRotationPoint(4F, 15F, 0F);
      LeftOuterWing.setTextureSize(128, 64);
      LeftOuterWing.mirror = true;
      setRotation(LeftOuterWing, 0F, -0.1396263F, 0.2617994F);
      LeftLeg = new ModelRenderer(this, 26, 0);
      LeftLeg.addBox(-0.5333334F, 0F, -0.4666667F, 1, 4, 1);
      LeftLeg.setRotationPoint(3F, 18.5F, 5F);
      LeftLeg.setTextureSize(128, 64);
      LeftLeg.mirror = true;
      setRotation(LeftLeg, 0.8726646F, 0F, 0F);
      RightLeg = new ModelRenderer(this, 22, 0);
      RightLeg.addBox(-0.5333334F, 0F, -0.5333334F, 1, 4, 1);
      RightLeg.setRotationPoint(-3F, 18.5F, 5F);
      RightLeg.setTextureSize(128, 64);
      RightLeg.mirror = true;
      setRotation(RightLeg, 0.8726646F, 0F, 0F);
      Tail3 = new ModelRenderer(this, 30, 0);
      Tail3.addBox(-1F, -0.5F, 0F, 2, 1, 11);
      Tail3.setRotationPoint(0F, 14.5F, 11.5F);
      Tail3.setTextureSize(128, 64);
      Tail3.mirror = true;
      setRotation(Tail3, 0.2617994F, 0F, 0F);
      Tail1 = new ModelRenderer(this, 30, 0);
      Tail1.addBox(1F, -0.3F, 0.8F, 2, 1, 11);
      Tail1.setRotationPoint(0F, 14.5F, 11.5F);
      Tail1.setTextureSize(128, 64);
      Tail1.mirror = true;
      setRotation(Tail1, 0.2617994F, 0.7853982F, 0F);
      ReadBody2 = new ModelRenderer(this, 0, 10);
      ReadBody2.addBox(-4.5F, 0F, 16F, 9, 3, 2);
      ReadBody2.setRotationPoint(0F, 14F, -8F);
      ReadBody2.setTextureSize(128, 64);
      ReadBody2.mirror = true;
      setRotation(ReadBody2, 0F, 0F, 0F);
      RearBody4 = new ModelRenderer(this, 0, 3);
      RearBody4.addBox(-4F, 0F, 18F, 8, 2, 2);
      RearBody4.setRotationPoint(0F, 14F, -8F);
      RearBody4.setTextureSize(128, 64);
      RearBody4.mirror = true;
      setRotation(RearBody4, 0F, 0F, 0F);
      Tail5 = new ModelRenderer(this, 30, 0);
      Tail5.addBox(-3F, -0.3F, 0.8F, 2, 1, 11);
      Tail5.setRotationPoint(0F, 14.5F, 11.5F);
      Tail5.setTextureSize(128, 64);
      Tail5.mirror = true;
      setRotation(Tail5, 0.2617994F, -0.7853982F, 0F);
      Tail2 = new ModelRenderer(this, 30, 0);
      Tail2.addBox(0F, -0.5F, 0F, 2, 1, 11);
      Tail2.setRotationPoint(0F, 14.5F, 11.5F);
      Tail2.setTextureSize(128, 64);
      Tail2.mirror = true;
      setRotation(Tail2, 0.2617994F, 0.3926991F, 0F);
      Tail4 = new ModelRenderer(this, 30, 0);
      Tail4.addBox(-2F, -0.5F, 0F, 2, 1, 11);
      Tail4.setRotationPoint(0F, 14.5F, 11.5F);
      Tail4.setTextureSize(128, 64);
      Tail4.mirror = true;
      setRotation(Tail4, 0.2617994F, -0.3926991F, 0F);
      Body2 = new ModelRenderer(this, 78, 22);
      Body2.addBox(-4.5F, -0.5F, -0.1F, 9, 5, 16);
      Body2.setRotationPoint(0F, 14F, -8F);
      Body2.setTextureSize(128, 64);
      Body2.mirror = true;
      setRotation(Body2, 0F, 0F, 0F);
      RearBody1 = new ModelRenderer(this, 0, 7);
      RearBody1.addBox(-4F, -0.5F, 16F, 8, 1, 2);
      RearBody1.setRotationPoint(0F, 14F, -8F);
      RearBody1.setTextureSize(128, 64);
      RearBody1.mirror = true;
      setRotation(RearBody1, 0F, 0F, 0F);
      ReadyBody3 = new ModelRenderer(this, 0, 0);
      ReadyBody3.addBox(-3.5F, -0.5F, 18F, 7, 1, 2);
      ReadyBody3.setRotationPoint(0F, 14F, -8F);
      ReadyBody3.setTextureSize(128, 64);
      ReadyBody3.mirror = true;
      setRotation(ReadyBody3, 0F, 0F, 0F);
      Body3 = new ModelRenderer(this, 80, 0);
      Body3.addBox(-4F, -1F, -0.2F, 8, 6, 16);
      Body3.setRotationPoint(0F, 14F, -8F);
      Body3.setTextureSize(128, 64);
      Body3.mirror = true;
      setRotation(Body3, 0F, 0F, 0F);
      Neck1 = new ModelRenderer(this, 52, 8);
      Neck1.addBox(-3F, -1.5F, -2F, 6, 4, 4);
      Neck1.setRotationPoint(0F, 14F, -7F);
      Neck1.setTextureSize(128, 64);
      Neck1.mirror = true;
      setRotation(Neck1, 0F, 0F, 0F);
      Neck2 = new ModelRenderer(this, 54, 0);
      Neck2.addBox(-2.5F, -2F, -4F, 5, 4, 4);
      Neck2.setRotationPoint(0F, 14F, -6F);
      Neck2.setTextureSize(128, 64);
      Neck2.mirror = true;
      setRotation(Neck2, 0F, 0F, 0F);
      Head = new ModelRenderer(this, 72, 0);
      Head.addBox(-3F, -3F, -6F, 6, 6, 6);
      Head.setRotationPoint(0F, 13F, -9F);
      Head.setTextureSize(128, 64);
      Head.mirror = true;
      setRotation(Head, 0F, 0F, 0F);
      LeftTalon1 = new ModelRenderer(this, 26, 1);
      LeftTalon1.addBox(1.5F, -1F, 3F, 1, 2, 1);
      LeftTalon1.setRotationPoint(3F, 18.5F, 5F);
      LeftTalon1.setTextureSize(128, 64);
      LeftTalon1.mirror = true;
      setRotation(LeftTalon1, -1.152537F, -0.6320364F, 0F);
      Shape1 = new ModelRenderer(this, 46, 19);
      Shape1.addBox(-2.5F, -2F, -7F, 5, 5, 5);
      Shape1.setRotationPoint(0F, 13F, -9F);
      Shape1.setTextureSize(128, 64);
      Shape1.mirror = true;
      setRotation(Shape1, 0F, 0F, 0F);
      Shape2 = new ModelRenderer(this, 0, 38);
      Shape2.addBox(-2F, -1F, -8F, 4, 4, 4);
      Shape2.setRotationPoint(0F, 13F, -9F);
      Shape2.setTextureSize(128, 64);
      Shape2.mirror = true;
      setRotation(Shape2, 0F, 0F, 0F);
      Shape3 = new ModelRenderer(this, 0, 32);
      Shape3.addBox(-1.5F, 0F, -9F, 3, 3, 3);
      Shape3.setRotationPoint(0F, 13F, -9F);
      Shape3.setTextureSize(128, 64);
      Shape3.mirror = true;
      setRotation(Shape3, 0F, 0F, 0F);
      Shape4 = new ModelRenderer(this, 22, 1);
      Shape4.addBox(-1F, 0F, -11F, 2, 2, 2);
      Shape4.setRotationPoint(0F, 13F, -9F);
      Shape4.setTextureSize(128, 64);
      Shape4.mirror = true;
      setRotation(Shape4, 0F, 0F, 0F);
      Shape5 = new ModelRenderer(this, 22, 1);
      Shape5.addBox(-0.5F, 0F, -12F, 1, 3, 1);
      Shape5.setRotationPoint(0F, 13F, -9F);
      Shape5.setTextureSize(128, 64);
      Shape5.mirror = true;
      setRotation(Shape5, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    Body.render(f5);
    RightInnerWing.render(f5);
    LeftInnerWing.render(f5);
    RightOuterWing.render(f5);
    LeftOuterWing.render(f5);
    LeftLeg.render(f5);
    RightLeg.render(f5);
    Tail3.render(f5);
    Tail1.render(f5);
    ReadBody2.render(f5);
    RearBody4.render(f5);
    Tail5.render(f5);
    Tail2.render(f5);
    Tail4.render(f5);
    Body2.render(f5);
    RearBody1.render(f5);
    ReadyBody3.render(f5);
    Body3.render(f5);
    Neck1.render(f5);
    Neck2.render(f5);
    Head.render(f5);
    LeftTalon1.render(f5);
    Shape1.render(f5);
    Shape2.render(f5);
    Shape3.render(f5);
    Shape4.render(f5);
    Shape5.render(f5);
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
    this.Shape1.rotateAngleX = f4 / (180F / (float)Math.PI);
    this.Shape2.rotateAngleX = f4 / (180F / (float)Math.PI);
    this.Shape3.rotateAngleX = f4 / (180F / (float)Math.PI);
    this.Shape4.rotateAngleX = f4 / (180F / (float)Math.PI);
    this.Shape5.rotateAngleX = f4 / (180F / (float)Math.PI);
    this.Head.rotateAngleY = f3 / (180F / (float)Math.PI);
    this.Shape1.rotateAngleY = f3 / (180F / (float)Math.PI);
    this.Shape2.rotateAngleY = f3 / (180F / (float)Math.PI);
    this.Shape3.rotateAngleY = f3 / (180F / (float)Math.PI);
    this.Shape4.rotateAngleY = f3 / (180F / (float)Math.PI);
    this.Shape5.rotateAngleY = f3 / (180F / (float)Math.PI);
    this.RightOuterWing.rotateAngleZ = MathHelper.cos(f * 0.4F) * 1.5F * f1;
    this.RightInnerWing.rotateAngleZ = MathHelper.cos(f * 0.4F) * 1.4F * f1;
    this.LeftOuterWing.rotateAngleZ = MathHelper.cos(f * 0.4F + (float)Math.PI) * 1.5F * f1;
    this.LeftInnerWing.rotateAngleZ = MathHelper.cos(f * 0.4F + (float)Math.PI) * 1.4F * f1;
  }

}
