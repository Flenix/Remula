package co.uk.silvania.Remula.client.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelSkitterling extends ModelBase
{
	  //fields
	    ModelRenderer Body;
	    ModelRenderer Head;
	    ModelRenderer BackLeftLeg;
	    ModelRenderer BackRightLeg;
	    ModelRenderer MidLeftLeg;
	    ModelRenderer MidRightLeg;
	    ModelRenderer FrontLeftLeg;
	    ModelRenderer FrontRightLeg;
	  
	  public ModelSkitterling()
	  {
	    textureWidth = 64;
	    textureHeight = 32;
	    
	      Body = new ModelRenderer(this, 0, 0);
	      Body.addBox(-2F, -1F, -6F, 4, 2, 12);
	      Body.setRotationPoint(0F, 21F, 3F);
	      Body.setTextureSize(64, 32);
	      Body.mirror = true;
	      setRotation(Body, 0F, 0F, 0F);
	      Head = new ModelRenderer(this, 0, 5);
	      Head.addBox(-1.5F, -3F, 0F, 3, 3, 3);
	      Head.setRotationPoint(0F, 21F, -5.5F);
	      Head.setTextureSize(64, 32);
	      Head.mirror = true;
	      setRotation(Head, 0F, 0F, 0F);
	      BackLeftLeg = new ModelRenderer(this, 0, 0);
	      BackLeftLeg.addBox(-0.5F, 0F, -0.5F, 1, 4, 1);
	      BackLeftLeg.setRotationPoint(-2F, 21F, 4F);
	      BackLeftLeg.setTextureSize(64, 32);
	      BackLeftLeg.mirror = true;
	      setRotation(BackLeftLeg, 0.8551081F, -0.8551081F, 0F);
	      BackRightLeg = new ModelRenderer(this, 0, 0);
	      BackRightLeg.addBox(-0.5F, 0F, -0.5F, 1, 4, 1);
	      BackRightLeg.setRotationPoint(2F, 21F, 4F);
	      BackRightLeg.setTextureSize(64, 32);
	      BackRightLeg.mirror = true;
	      setRotation(BackRightLeg, -0.8551066F, -2.286486F, 0F);
	      MidLeftLeg = new ModelRenderer(this, 0, 0);
	      MidLeftLeg.addBox(-0.5F, 0F, -0.5F, 1, 4, 1);
	      MidLeftLeg.setRotationPoint(-2F, 21F, 1F);
	      MidLeftLeg.setTextureSize(64, 32);
	      MidLeftLeg.mirror = true;
	      setRotation(MidLeftLeg, 0.8551081F, -1.570796F, 0F);
	      MidRightLeg = new ModelRenderer(this, 0, 0);
	      MidRightLeg.addBox(-0.4666667F, 0F, -0.4666667F, 1, 4, 1);
	      MidRightLeg.setRotationPoint(2F, 21F, 1F);
	      MidRightLeg.setTextureSize(64, 32);
	      MidRightLeg.mirror = true;
	      setRotation(MidRightLeg, 0.8551081F, 1.570796F, 0F);
	      FrontLeftLeg = new ModelRenderer(this, 0, 0);
	      FrontLeftLeg.addBox(-0.5333334F, 0F, -0.5333334F, 1, 4, 1);
	      FrontLeftLeg.setRotationPoint(-2F, 21F, -2F);
	      FrontLeftLeg.setTextureSize(64, 32);
	      FrontLeftLeg.mirror = true;
	      setRotation(FrontLeftLeg, 0.8551066F, -2.286486F, 0F);
	      FrontRightLeg = new ModelRenderer(this, 0, 0);
	      FrontRightLeg.addBox(-0.5F, 0F, -0.5F, 1, 4, 1);
	      FrontRightLeg.setRotationPoint(2F, 21F, -2F);
	      FrontRightLeg.setTextureSize(64, 32);
	      FrontRightLeg.mirror = true;
	      setRotation(FrontRightLeg, 0.8551081F, 2.286486F, 0F);
	  }
	  
	  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	  {
	    super.render(entity, f, f1, f2, f3, f4, f5);
	    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
	    Body.render(f5);
	    Head.render(f5);
	    BackLeftLeg.render(f5);
	    BackRightLeg.render(f5);
	    MidLeftLeg.render(f5);
	    MidRightLeg.render(f5);
	    FrontLeftLeg.render(f5);
	    FrontRightLeg.render(f5);
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
	    this.FrontLeftLeg.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
	    this.FrontRightLeg.rotateAngleX = MathHelper.cos(f * 0.6662F + (float)Math.PI) * 1.4F * f1;
	    this.FrontLeftLeg.rotateAngleY = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
	    this.FrontRightLeg.rotateAngleY = MathHelper.cos(f * 0.6662F + (float)Math.PI) * 1.4F * f1;
	    this.FrontLeftLeg.rotateAngleZ = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
	    this.FrontRightLeg.rotateAngleZ = MathHelper.cos(f * 0.6662F + (float)Math.PI) * 1.4F * f1;
	    this.MidLeftLeg.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
	    this.MidRightLeg.rotateAngleX = MathHelper.cos(f * 0.6662F + (float)Math.PI) * 1.4F * f1;
	    this.BackLeftLeg.rotateAngleX = MathHelper.cos(f * 0.6662F + (float)Math.PI) * 1.4F * f1;
	    this.BackRightLeg.rotateAngleX = MathHelper.cos(f * 0.6662F + (float)Math.PI) * 1.4F * f1;
	  }

	}
