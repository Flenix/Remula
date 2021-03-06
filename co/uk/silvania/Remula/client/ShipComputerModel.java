package co.uk.silvania.Remula.client;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ShipComputerModel extends ModelBase
{
  //fields
    ModelRenderer Shape1;
    ModelRenderer Shape2;
    ModelRenderer Shape3;
    ModelRenderer Shape4;
    ModelRenderer Shape5;
    ModelRenderer Shape6;
    ModelRenderer Shape7;
    ModelRenderer Shape8;
    ModelRenderer Shape9;
    ModelRenderer Shape10;
    ModelRenderer Shape11;
    ModelRenderer Shape12;
    ModelRenderer Shape13;
    ModelRenderer Shape14;
    ModelRenderer Shape15;
    ModelRenderer Shape16;
    ModelRenderer Shape17;
    ModelRenderer Shape19;
    ModelRenderer Shape20;
    ModelRenderer Shape18;
  
  public ShipComputerModel()
  {
    textureWidth = 128;
    textureHeight = 128;
    
      Shape1 = new ModelRenderer(this, 0, 64);
      Shape1.addBox(0F, 0F, 0F, 16, 16, 16);
      Shape1.setRotationPoint(-8F, 8F, -8F);
      Shape1.setTextureSize(128, 128);
      Shape1.mirror = true;
      setRotation(Shape1, 0F, 0F, 0F);
      Shape2 = new ModelRenderer(this, 64, 96);
      Shape2.addBox(0F, 0F, 0F, 16, 16, 16);
      Shape2.setRotationPoint(8F, 8F, -8F);
      Shape2.setTextureSize(128, 128);
      Shape2.mirror = true;
      setRotation(Shape2, 0F, 0.7853982F, 0F);
      Shape3 = new ModelRenderer(this, 0, 96);
      Shape3.addBox(-16F, 0F, 0F, 16, 16, 16);
      Shape3.setRotationPoint(-8F, 8F, -8F);
      Shape3.setTextureSize(128, 128);
      Shape3.mirror = true;
      setRotation(Shape3, 0F, -0.7853982F, 0F);
      Shape4 = new ModelRenderer(this, 64, 68);
      Shape4.addBox(-12F, 0F, -12.5F, 12, 14, 14);
      Shape4.setRotationPoint(-7F, 9F, 6F);
      Shape4.setTextureSize(128, 128);
      Shape4.mirror = true;
      setRotation(Shape4, 0F, -0.3926991F, 0F);
      Shape5 = new ModelRenderer(this, 64, 40);
      Shape5.addBox(0F, 0F, -12.5F, 12, 14, 14);
      Shape5.setRotationPoint(7F, 9F, 6F);
      Shape5.setTextureSize(128, 128);
      Shape5.mirror = true;
      setRotation(Shape5, 0F, 0.3926991F, 0F);
      Shape6 = new ModelRenderer(this, 0, 38);
      Shape6.addBox(0F, 0F, 0F, 18, 12, 1);
      Shape6.setRotationPoint(-9F, -6F, 3F);
      Shape6.setTextureSize(128, 128);
      Shape6.mirror = true;
      setRotation(Shape6, 0F, 0F, 0F);
      Shape7 = new ModelRenderer(this, 0, 51);
      Shape7.addBox(0F, 0F, 0F, 18, 12, 1);
      Shape7.setRotationPoint(16F, -6F, 0F);
      Shape7.setTextureSize(128, 128);
      Shape7.mirror = true;
      setRotation(Shape7, 0F, 0.7853982F, 0F);
      Shape8 = new ModelRenderer(this, 0, 25);
      Shape8.addBox(-18F, 0F, 0F, 18, 12, 1);
      Shape8.setRotationPoint(-15F, -6F, 0F);
      Shape8.setTextureSize(128, 128);
      Shape8.mirror = true;
      setRotation(Shape8, 0F, -0.7853982F, 0F);
      Shape9 = new ModelRenderer(this, 54, 54);
      Shape9.addBox(0F, 0F, 0F, 2, 8, 1);
      Shape9.setRotationPoint(-1F, 0F, 4F);
      Shape9.setTextureSize(128, 128);
      Shape9.mirror = true;
      setRotation(Shape9, 0F, 0F, 0F);
      Shape10 = new ModelRenderer(this, 38, 52);
      Shape10.addBox(0F, 0F, 0F, 4, 4, 1);
      Shape10.setRotationPoint(-2F, -1F, 3.5F);
      Shape10.setTextureSize(128, 128);
      Shape10.mirror = true;
      setRotation(Shape10, 0F, 0F, 0F);
      Shape11 = new ModelRenderer(this, 38, 58);
      Shape11.addBox(0F, 0F, 0F, 4, 1, 4);
      Shape11.setRotationPoint(-2F, 7F, 2F);
      Shape11.setTextureSize(128, 128);
      Shape11.mirror = true;
      setRotation(Shape11, 0F, 0F, 0F);
      Shape12 = new ModelRenderer(this, 38, 52);
      Shape12.addBox(0F, 0F, 0F, 4, 4, 1);
      Shape12.setRotationPoint(21.4F, -1F, -4.6F);
      Shape12.setTextureSize(128, 128);
      Shape12.mirror = true;
      setRotation(Shape12, 0F, 0.7853982F, 0F);
      Shape13 = new ModelRenderer(this, 54, 54);
      Shape13.addBox(0F, 0F, 0F, 2, 8, 1);
      Shape13.setRotationPoint(22.5F, 0F, -5F);
      Shape13.setTextureSize(128, 128);
      Shape13.mirror = true;
      setRotation(Shape13, 0F, 0.7853982F, 0F);
      Shape14 = new ModelRenderer(this, 38, 58);
      Shape14.addBox(0F, 0F, 0F, 4, 1, 4);
      Shape14.setRotationPoint(20F, 7F, -6F);
      Shape14.setTextureSize(128, 128);
      Shape14.mirror = true;
      setRotation(Shape14, 0F, 0.7853982F, 0F);
      Shape15 = new ModelRenderer(this, 38, 52);
      Shape15.addBox(0F, 0F, 0F, 4, 4, 1);
      Shape15.setRotationPoint(-22.9F, -1F, -7.1F);
      Shape15.setTextureSize(128, 128);
      Shape15.mirror = true;
      setRotation(Shape15, 0F, -0.7853982F, 0F);
      Shape16 = new ModelRenderer(this, 54, 54);
      Shape16.addBox(0F, 0F, 0F, 2, 8, 1);
      Shape16.setRotationPoint(-22.5F, 0F, -6F);
      Shape16.setTextureSize(128, 128);
      Shape16.mirror = true;
      setRotation(Shape16, 0F, -0.7853982F, 0F);
      Shape17 = new ModelRenderer(this, 38, 58);
      Shape17.addBox(0F, 0F, 0F, 4, 1, 4);
      Shape17.setRotationPoint(-22F, 7F, -8F);
      Shape17.setTextureSize(128, 128);
      Shape17.mirror = true;
      setRotation(Shape17, 0F, -0.7853982F, 0F);
      Shape19 = new ModelRenderer(this, 0, 7);
      Shape19.addBox(0F, 0F, 0F, 14, 1, 6);
      Shape19.setRotationPoint(9F, 7.6F, -8F);
      Shape19.setTextureSize(128, 128);
      Shape19.mirror = true;
      setRotation(Shape19, 0.0872665F, 0.7853982F, 0F);
      Shape20 = new ModelRenderer(this, 0, 14);
      Shape20.addBox(-13.5F, 0F, 0F, 14, 1, 6);
      Shape20.setRotationPoint(-10F, 7.6F, -8F);
      Shape20.setTextureSize(128, 128);
      Shape20.mirror = true;
      setRotation(Shape20, 0.0872665F, -0.7853982F, 0F);
      Shape18 = new ModelRenderer(this, 0, 0);
      Shape18.addBox(0F, 0F, 0F, 14, 1, 6);
      Shape18.setRotationPoint(-7F, 7.6F, -7F);
      Shape18.setTextureSize(128, 128);
      Shape18.mirror = true;
      setRotation(Shape18, 0.0872665F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    Shape1.render(f5);
    Shape2.render(f5);
    Shape3.render(f5);
    Shape4.render(f5);
    Shape5.render(f5);
    Shape6.render(f5);
    Shape7.render(f5);
    Shape8.render(f5);
    Shape9.render(f5);
    Shape10.render(f5);
    Shape11.render(f5);
    Shape12.render(f5);
    Shape13.render(f5);
    Shape14.render(f5);
    Shape15.render(f5);
    Shape16.render(f5);
    Shape17.render(f5);
    Shape19.render(f5);
    Shape20.render(f5);
    Shape18.render(f5);
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
