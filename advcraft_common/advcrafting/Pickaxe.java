package advcrafting;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class Pickaxe extends Item
{

	public Pickaxe(int id) 
	{
		super(id);
		this.setMaxStackSize(1);
		this.setCreativeTab(CreativeTabs.tabMaterials);
	}

}
