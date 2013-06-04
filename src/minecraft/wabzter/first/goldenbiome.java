package wabzter.first;

import net.minecraft.block.Block;
import net.minecraft.world.biome.BiomeGenBase;

public class goldenbiome extends BiomeGenBase {

	public goldenbiome(int par1) {
		super(par1);
		// TODO Auto-generated constructor stub
		this.setBiomeName("Butter_Biome");
		this.fillerBlock = (byte) Block.oreGold.blockID;
		this.topBlock = (byte) Block.blockGold.blockID;
		this.maxHeight = 0.6F;
		this.minHeight = 0;
	}
}
