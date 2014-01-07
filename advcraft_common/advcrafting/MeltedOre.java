package advcrafting;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class MeltedOre extends Item
{
	public MeltedOre(int id) {
		super(id);
		this.setCreativeTab(CreativeTabs.tabMaterials);
		this.setMaxStackSize(64);
	}
}
