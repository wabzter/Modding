package wabzter.first;

import net.minecraft.item.Item;
import cpw.mods.fml.relauncher.*;
import net.minecraft.creativetab.CreativeTabs;


public class TestItems extends Item {
public TestItems(int par1) {
super(par1); //Returns super constructor: par1 is ID
setCreativeTab(CreativeTabs.tabMaterials); //Tells the game what creative mode tab it goes in
}
}