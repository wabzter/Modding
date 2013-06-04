package wabzter.first; //Package directory
/*
* Basic importing
*/
 
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityEggInfo;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.EnumHelper;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
/*
* Basic needed forge stuff
*/
@Mod(modid="FirstMod",name="First Mod",version="v1")
@NetworkMod(clientSideRequired=true,serverSideRequired=false)

 
public class FirstMod {
/*
* ToolMaterial
*/ 
        
//Telling forge that we are creating these

//item statics
public static Item target;
public static Item topaz;
public static Item obsidiansword;

//block statics
public static Block blocktest;
public static Block topazblock; 

//ore statics
public static Block topazore;

//biomes
public static BiomeGenBase goldbiome;

//Mobs
static int startEntityId = 300;

//Declaring Init
@Init
public void load(FMLInitializationEvent event){
// define
        
//Tools something
        EnumToolMaterial EnumToolMaterialTest = EnumHelper.addToolMaterial("Obsidian Sword", 2, 250, 6.0F, 3, 10);

        
//Tools for now
        obsidiansword = new testsword(3009, EnumToolMaterialTest).setUnlocalizedName("TEST");
        LanguageRegistry.addName(obsidiansword, "Topaz Blade");
        
//blocks
blocktest= new TestBlock(3005, "blocktest").setUnlocalizedName("blocktest").setHardness(2.0F).setStepSound(Block.soundStoneFootstep).setResistance(10.0F);
GameRegistry.registerBlock(blocktest, "blocktest");
LanguageRegistry.addName(blocktest, "Target Block");

topazblock= new TopazBlock(3008, "topazblock").setUnlocalizedName("topazblock").setHardness(4.0F).setStepSound(Block.soundMetalFootstep).setResistance(30.0F);
GameRegistry.registerBlock(topazblock, "topazblock");
LanguageRegistry.addName(topazblock, "Topaz Block");

//items
target = new TestItems(3006).setUnlocalizedName("target");
topaz = new TestItems(3007).setUnlocalizedName("topaz");

//recipes
GameRegistry.addRecipe(new ItemStack(blocktest,1), new Object[]{
"TTT"," T "," T ",
'T',target,
});

GameRegistry.addRecipe(new ItemStack(topazblock,1), new Object[]{
"TTT","TTT","TTT",
'T',topaz,
});

GameRegistry.addRecipe(new ItemStack(obsidiansword,1), new Object[]{
" T "," T "," S  ",
'T',topaz,
'S',Item.stick
});

//Ores
topazore= new TopazOre(3010, "topazore").setUnlocalizedName("topazore").setHardness(4.0F).setStepSound(Block.soundStoneFootstep).setResistance(10.0F).setLightValue(3.0F);
GameRegistry.registerBlock(topazore, "topazore");
LanguageRegistry.addName(topazore, "Topaz Ore");

//WorldGenerators
GameRegistry.registerWorldGenerator(new WorldGeneratorTest());

//Smelting
GameRegistry.addSmelting(topazore.blockID, new ItemStack(topaz, 1) , 0.35F);

//Biomes
goldbiome = new goldenbiome(100);

//MobTest
EntityRegistry.registerModEntity(EntityTest.class, "TestMob", 1, this, 80, 3, true);
EntityRegistry.addSpawn(EntityTest.class, 10, 2, 4, EnumCreatureType.monster, BiomeGenBase.beach, BiomeGenBase.desert, BiomeGenBase.desertHills, BiomeGenBase.forest, BiomeGenBase.extremeHills, BiomeGenBase.plains, BiomeGenBase.forestHills, FirstMod.goldbiome);
LanguageRegistry.instance().addStringLocalization("Entity.FirstMod.name", "TestMob");

//adding names
LanguageRegistry.addName(target, "Target");
LanguageRegistry.addName(topaz, "Topaz Gem");

//MobEggs
registerEntityEgg(EntityTest.class, 0x7A65CF, 0x4DF200);

//crafting
}
public static int getUniqueEntityId()
{
	do
	{
		startEntityId++;
	}
	while(EntityList.getStringFromID(startEntityId) != null);
	 return startEntityId;
	 }
	 
	 public static void registerEntityEgg(Class<? extends Entity> entity, int primaryColor, int secondaryColor) 
	 {
	  int id = getUniqueEntityId();
	  EntityList.IDtoClassMapping.put(id, entity);
	  EntityList.entityEggs.put(id, new EntityEggInfo(id, primaryColor, secondaryColor));
	 }
}



