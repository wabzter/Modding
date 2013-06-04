package wabzter.first;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;

public class RenderTestMob extends RenderLiving
{
 protected TestMob model;
 
 public RenderTestMob (TestMob modelTutorial, float f)
 {
  super(modelTutorial, f);
  model = ((TestMob)mainModel);
 }
 
 public void renderTestMob(EntityTest entity, double par2, double par4, double par6, float par8, float par9)
    {
        super.doRenderLiving(entity, par2, par4, par6, par8, par9);
    }
 
 public void doRenderLiving(EntityLiving par1EntityLiving, double par2, double par4, double par6, float par8, float par9)
    {
        renderTestMob((EntityTest)par1EntityLiving, par2, par4, par6, par8, par9);
    }
 
 public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9)
    {
        renderTestMob((EntityTest)par1Entity, par2, par4, par6, par8, par9);
    }
}