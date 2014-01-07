package advcrafting;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class Axe extends Item
{

	public Axe(int id) 
	{
		super(id);
		this.setMaxStackSize(1);
		this.setCreativeTab(CreativeTabs.tabMaterials);
	}

}
