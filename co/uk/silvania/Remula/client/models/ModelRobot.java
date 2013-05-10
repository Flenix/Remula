package co.uk.silvania.Remula.client.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

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
    
    this.head.rotateAngleY = f3 / (180F / (float)Math.PI);
    this.head.rotateAngleX = f4 / (180F / (float)Math.PI);
    this.Shape1.rotateAngleY = f3 / (180F / (float)Math.PI);
    this.Shape2.rotateAngleY = f3 / (180F / (float)Math.PI);
    this.Shape1.rotateAngleX = f4 / (180F / (float)Math.PI);
    this.Shape2.rotateAngleX = f4 / (180F / (float)Math.PI);
    this.rightarm.rotateAngleX = MathHelper.cos(f * 0.6662F + (float)Math.PI) * 2.0F * f1 * 0.5F;
    this.leftarm.rotateAngleX = MathHelper.cos(f * 0.6662F) * 2.0F * f1 * 0.5F;
    this.rightarm.rotateAngleZ = 0.0F;
    this.leftarm.rotateAngleZ = 0.0F;
    
    this.Right_Hand_L.rotateAngleX = MathHelper.cos(f * 0.6662F + (float)Math.PI) * 2.0F * f1 * 0.5F;
    this.Left_Hand_L.rotateAngleX = MathHelper.cos(f * 0.6662F) * 2.0F * f1 * 0.5F;
    this.Right_Hand_L.rotateAngleZ = 0.0F;
    this.Left_Hand_L.rotateAngleZ = 0.0F;
    this.Right_Hand_R.rotateAngleX = MathHelper.cos(f * 0.6662F + (float)Math.PI) * 2.0F * f1 * 0.5F;
    this.Left_Hand_R.rotateAngleX = MathHelper.cos(f * 0.6662F) * 2.0F * f1 * 0.5F;
    this.Right_Hand_R.rotateAngleZ = 0.0F;
    this.Left_Hand_R.rotateAngleZ = 0.0F;
    
    
    this.rightleg.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
    this.leftleg.rotateAngleX = MathHelper.cos(f * 0.6662F + (float)Math.PI) * 1.4F * f1;
    this.rightleg.rotateAngleY = 0.0F;
    this.leftleg.rotateAngleY = 0.0F;

    /*if (this.isRiding)
    {
        this.bipedRightArm.rotateAngleX += -((float)Math.PI / 5F);
        this.bipedLeftArm.rotateAngleX += -((float)Math.PI / 5F);
        this.bipedRightLeg.rotateAngleX = -((float)Math.PI * 2F / 5F);
        this.bipedLeftLeg.rotateAngleX = -((float)Math.PI * 2F / 5F);
        this.bipedRightLeg.rotateAngleY = ((float)Math.PI / 10F);
        this.bipedLeftLeg.rotateAngleY = -((float)Math.PI / 10F);
    }

    if (this.heldItemLeft != 0)
    {
        this.bipedLeftArm.rotateAngleX = this.bipedLeftArm.rotateAngleX * 0.5F - ((float)Math.PI / 10F) * (float)this.heldItemLeft;
    }

    if (this.heldItemRight != 0)
    {
        this.bipedRightArm.rotateAngleX = this.bipedRightArm.rotateAngleX * 0.5F - ((float)Math.PI / 10F) * (float)this.heldItemRight;
    }

    this.bipedRightArm.rotateAngleY = 0.0F;
    this.bipedLeftArm.rotateAngleY = 0.0F;
    float var8;
    float var9;

    if (this.onGround > -9990.0F)
    {
        var8 = this.onGround;
        this.bipedBody.rotateAngleY = MathHelper.sin(MathHelper.sqrt_float(var8) * (float)Math.PI * 2.0F) * 0.2F;
        this.bipedRightArm.rotationPointZ = MathHelper.sin(this.bipedBody.rotateAngleY) * 5.0F;
        this.bipedRightArm.rotationPointX = -MathHelper.cos(this.bipedBody.rotateAngleY) * 5.0F;
        this.bipedLeftArm.rotationPointZ = -MathHelper.sin(this.bipedBody.rotateAngleY) * 5.0F;
        this.bipedLeftArm.rotationPointX = MathHelper.cos(this.bipedBody.rotateAngleY) * 5.0F;
        this.bipedRightArm.rotateAngleY += this.bipedBody.rotateAngleY;
        this.bipedLeftArm.rotateAngleY += this.bipedBody.rotateAngleY;
        this.bipedLeftArm.rotateAngleX += this.bipedBody.rotateAngleY;
        var8 = 1.0F - this.onGround;
        var8 *= var8;
        var8 *= var8;
        var8 = 1.0F - var8;
        var9 = MathHelper.sin(var8 * (float)Math.PI);
        float var10 = MathHelper.sin(this.onGround * (float)Math.PI) * -(this.bipedHead.rotateAngleX - 0.7F) * 0.75F;
        this.bipedRightArm.rotateAngleX = (float)((double)this.bipedRightArm.rotateAngleX - ((double)var9 * 1.2D + (double)var10));
        this.bipedRightArm.rotateAngleY += this.bipedBody.rotateAngleY * 2.0F;
        this.bipedRightArm.rotateAngleZ = MathHelper.sin(this.onGround * (float)Math.PI) * -0.4F;
    }

    if (this.isSneak)
    {
        this.bipedBody.rotateAngleX = 0.5F;
        this.bipedRightArm.rotateAngleX += 0.4F;
        this.bipedLeftArm.rotateAngleX += 0.4F;
        this.bipedRightLeg.rotationPointZ = 4.0F;
        this.bipedLeftLeg.rotationPointZ = 4.0F;
        this.bipedRightLeg.rotationPointY = 9.0F;
        this.bipedLeftLeg.rotationPointY = 9.0F;
        this.bipedHead.rotationPointY = 1.0F;
        this.bipedHeadwear.rotationPointY = 1.0F;
    }
    else
    {
        this.bipedBody.rotateAngleX = 0.0F;
        this.bipedRightLeg.rotationPointZ = 0.1F;
        this.bipedLeftLeg.rotationPointZ = 0.1F;
        this.bipedRightLeg.rotationPointY = 12.0F;
        this.bipedLeftLeg.rotationPointY = 12.0F;
        this.bipedHead.rotationPointY = 0.0F;
        this.bipedHeadwear.rotationPointY = 0.0F;
    }

    this.bipedRightArm.rotateAngleZ += MathHelper.cos(par3 * 0.09F) * 0.05F + 0.05F;
    this.bipedLeftArm.rotateAngleZ -= MathHelper.cos(par3 * 0.09F) * 0.05F + 0.05F;
    this.bipedRightArm.rotateAngleX += MathHelper.sin(par3 * 0.067F) * 0.05F;
    this.bipedLeftArm.rotateAngleX -= MathHelper.sin(par3 * 0.067F) * 0.05F;

    if (this.aimedBow)
    {
        var8 = 0.0F;
        var9 = 0.0F;
        this.bipedRightArm.rotateAngleZ = 0.0F;
        this.bipedLeftArm.rotateAngleZ = 0.0F;
        this.bipedRightArm.rotateAngleY = -(0.1F - var8 * 0.6F) + this.bipedHead.rotateAngleY;
        this.bipedLeftArm.rotateAngleY = 0.1F - var8 * 0.6F + this.bipedHead.rotateAngleY + 0.4F;
        this.bipedRightArm.rotateAngleX = -((float)Math.PI / 2F) + this.bipedHead.rotateAngleX;
        this.bipedLeftArm.rotateAngleX = -((float)Math.PI / 2F) + this.bipedHead.rotateAngleX;
        this.bipedRightArm.rotateAngleX -= var8 * 1.2F - var9 * 0.4F;
        this.bipedLeftArm.rotateAngleX -= var8 * 1.2F - var9 * 0.4F;
        this.bipedRightArm.rotateAngleZ += MathHelper.cos(par3 * 0.09F) * 0.05F + 0.05F;
        this.bipedLeftArm.rotateAngleZ -= MathHelper.cos(par3 * 0.09F) * 0.05F + 0.05F;
        this.bipedRightArm.rotateAngleX += MathHelper.sin(par3 * 0.067F) * 0.05F;
        this.bipedLeftArm.rotateAngleX -= MathHelper.sin(par3 * 0.067F) * 0.05F;
    }
}*/
  }

}
