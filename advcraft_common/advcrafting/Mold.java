package advcrafting;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class Mold extends Item
{
	public Mold(int id) 
	{
		super(id);
		this.setCreativeTab(CreativeTabs.tabMaterials);
		this.setMaxStackSize(1);
	}
}
