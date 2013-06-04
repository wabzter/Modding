package wabzter.first;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class TestMob extends ModelBase
{
  //fields
    ModelRenderer body;
    ModelRenderer Head;
    ModelRenderer Leg1;
    ModelRenderer Shape1;
    ModelRenderer Shape2;
    ModelRenderer Shape3;
  
  public TestMob()
  {
    textureWidth = 64;
    textureHeight = 32;
    
      body = new ModelRenderer(this, 0, 0);
      body.addBox(-2.5F, 0F, 0F, 6, 6, 8);
      body.setRotationPoint(0.03333334F, 0F, 4F);
      body.setTextureSize(64, 32);
      body.mirror = true;
      setRotation(body, 0F, 0F, 0F);
      Head = new ModelRenderer(this, 31, 6);
      Head.addBox(0F, 0F, 0F, 5, 4, 3);
      Head.setRotationPoint(-2F, 0F, 1F);
      Head.setTextureSize(64, 32);
      Head.mirror = true;
      setRotation(Head, 0F, 0F, 0F);
      Leg1 = new ModelRenderer(this, 0, 19);
      Leg1.addBox(0F, 0F, 0F, 6, 1, 1);
      Leg1.setRotationPoint(-8F, 7F, 5F);
      Leg1.setTextureSize(64, 32);
      Leg1.mirror = true;
      setRotation(Leg1, 0F, 0F, -0.3717861F);
      Shape1 = new ModelRenderer(this, 14, 16);
      Shape1.addBox(0F, 0F, 0F, 6, 1, 1);
      Shape1.setRotationPoint(3F, 5F, 5F);
      Shape1.setTextureSize(64, 32);
      Shape1.mirror = true;
      setRotation(Shape1, 0F, 0F, 0.37179F);
      Shape2 = new ModelRenderer(this, 29, 19);
      Shape2.addBox(0F, 0F, 0F, 6, 1, 1);
      Shape2.setRotationPoint(3F, 5F, 11F);
      Shape2.setTextureSize(64, 32);
      Shape2.mirror = true;
      setRotation(Shape2, 0F, 0F, 0.37179F);
      Shape3 = new ModelRenderer(this, 44, 0);
      Shape3.addBox(0F, 0F, 0F, 6, 1, 1);
      Shape3.setRotationPoint(-8F, 7F, 11F);
      Shape3.setTextureSize(64, 32);
      Shape3.mirror = true;
      setRotation(Shape3, 0F, 0F, -0.37179F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    body.render(f5);
    Head.render(f5);
    Leg1.render(f5);
    Shape1.render(f5);
    Shape2.render(f5);
    Shape3.render(f5);
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
