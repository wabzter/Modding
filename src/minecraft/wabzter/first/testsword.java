package wabzter.first;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemSword;

public class testsword extends ItemSword {
public testsword(int par1, EnumToolMaterial Material){
        super(par1, Material);
        maxStackSize = 1;
        this.setCreativeTab(CreativeTabs.tabCombat);
}
public String getTextureFile(){
        return "/textures/items/TEST.png";
}



}
