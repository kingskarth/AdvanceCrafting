package advcrafting;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class AdvItems extends Item
{
	public AdvItems(int id) 
	{
		super(id);
		this.setCreativeTab(CreativeTabs.tabMaterials);
		this.setMaxStackSize(64);
	}
}
