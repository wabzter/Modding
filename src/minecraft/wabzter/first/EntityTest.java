package wabzter.first;

import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIBreakDoor;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.item.Item;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;


public class EntityTest extends EntityMob
{
 public EntityTest(World par1World) 
 {
  super(par1World);
  this.texture = "/textures/mobtextures/TestMob.png";
  this.moveSpeed = 0.25F;
  this.tasks.addTask(0, new EntityAISwimming(this));
  this.tasks.addTask(1, new EntityAIBreakDoor(this));
  this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityPlayer.class, this.moveSpeed, false));
  this.tasks.addTask(3, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
  this.tasks.addTask(4, new EntityAIWander(this, this.moveSpeed));
  this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
  this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 16.0F, 0, true));
 }
 
 protected Boolean IsAIEnabled()
 {
	 return true;
 }


public int getAttackStrength(Entity par1Entity)
    {
     return 4;
    }

 
 public int getMaxHealth() 
 {
  return 20;
 }
 
 public EnumCreatureAttribute getCreatureAttribute()
    {
        return EnumCreatureAttribute.UNDEAD;
    }
 public String getTexture()
 {
return "/Tutorial/Tutorialmob.png";
 }

public int getTotalArmorValue()
 {
     return 2;
 }

public void onLivingUpdate()
 {
     if (this.worldObj.isDaytime() && !this.worldObj.isRemote)
     {
         float var1 = this.getBrightness(1.0F);

         if (var1 > 0.5F && this.worldObj.canBlockSeeTheSky(MathHelper.floor_double(this.posX), MathHelper.floor_double(this.posY), MathHelper.floor_double(this.posZ)) && this.rand.nextFloat() * 30.0F < (var1 - 0.4F) * 2.0F)
         {
             this.setFire(8);
         }
     }

     super.onLivingUpdate();
 }

protected String getLivingSound()
 {
     return "mob.spider.say";
 }

 protected String getHurtSound()
 {
     return "mob.spider.hurt";
 }
 
 protected String getDeathSound()
 {
     return "mob.spider.death";
 }
 
 protected void playStepSound(int par1, int par2, int par3, int par4)
 {
     this.worldObj.playSoundAtEntity(this, "mob.spider.step", 0.15F, 1.0F);
 }
 protected int getDropItemId()
 {
     return Item.silk.itemID;
 }
 
 protected void dropRareDrop(int par1)
 {
     switch (this.rand.nextInt(2))
     {
         case 0:
             this.dropItem(Item.silk.itemID, 1);
             break;
         case 1:
             this.dropItem(Item.silk.itemID, 1);
             break;
     }
 }
 
 protected void dropFewItems(boolean par1, int par2)
 {
  if(this.rand.nextInt(3) == 0)
  {
   this.dropItem(Item.silk.itemID, 1);
  }
 }
}