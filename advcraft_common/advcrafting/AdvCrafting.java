package advcrafting;

import java.util.ArrayList;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.ShapedRecipes;
import net.minecraft.item.crafting.ShapelessRecipes;
import net.minecraftforge.oredict.ShapedOreRecipe;
import advcrafting.Mold;
import advcrafting.lib.Reference;
import advcrafting.proxy.CommonProxy;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.Version)
@NetworkMod(clientSideRequired = true, serverSideRequired = false)

public class AdvCrafting 
{
	@Instance(Reference.MOD_ID)
	public static AdvCrafting Instance;
	
	public final static Item AxeDiamond = new Axe(4013).setUnlocalizedName("Diamond Axe");
	public final static Item AxeGold = new Axe(4014).setUnlocalizedName("Gold Axe");
	public final static Item AxeIron = new Axe(4015).setUnlocalizedName("Iron Axe");
	public final static Item AxeWood = new Axe(4016).setUnlocalizedName("Wood Axe").setTextureName("AdvCraft: wooden pickaxe head");
	public final static Item BladeDiamond = new Blade(4017).setUnlocalizedName("Diamond Blade");
	public final static Item BladeGold = new Blade(4018).setUnlocalizedName("Gold Blade");
	public final static Item BladeIron = new Blade(4019).setUnlocalizedName("Iron Blade");
	public final static Item BladeWood = new Blade(4020).setUnlocalizedName("Wood Blade");
	public final static Item Chainlink = new AdvItems(4008).setUnlocalizedName("Chain Link");
	public final static Item Chainmail = new AdvItems(4029).setUnlocalizedName("Chain Mail");
	public final static Item DiamondStack = new AdvItems(4030).setUnlocalizedName("Diamond Stack");
	public final static Item EmeraldStack = new AdvItems(4033).setUnlocalizedName("Emerald Stack");
	public final static Item GoldStack = new AdvItems(4031).setUnlocalizedName("Gold Stack");
	public final static Item Handle = new AdvItems(4009).setUnlocalizedName("Handle");
	public final static Item HoeDiamond = new Hoe(4021).setUnlocalizedName("Diamond Hoe");
	public final static Item HoeGold = new Hoe(4022).setUnlocalizedName ("Gold Hoe");
	public final static Item HoeIron = new Hoe(4023).setUnlocalizedName("Iron Hoe");
	public final static Item HoeWood = new Hoe(4024).setUnlocalizedName("Wood Hoe");
	public final static Item IngotMoldDiamond = new Mold(4005).setUnlocalizedName("Diamond Mold");
	public final static Item IngotMoldGold = new Mold(4006).setUnlocalizedName("Gold Mold");
	public final static Item IngotMoldIron = new Mold(4007).setUnlocalizedName("Iron Mold");
	public final static Item IronStack = new AdvItems(4032).setUnlocalizedName("Iron Stack");
	public final static Item MeltedDiamond = new MeltedOre(4012).setUnlocalizedName("Melted Diamond");
	public final static Item MeltedGold = new MeltedOre(4010).setUnlocalizedName("Melted Gold");
	public final static Item MeltedIron = new MeltedOre(4011).setUnlocalizedName("Melted Iron");
	public final static Item MoldAxe = new Mold(4000).setUnlocalizedName("Axe Mold");
	public final static Item MoldBlade = new Mold(4001).setUnlocalizedName("Blade Mold");
	public final static Item MoldHoe = new Mold(4002).setUnlocalizedName("Hoe Mold");
	public final static Item MoldPickAxe = new Mold(4003).setUnlocalizedName("Pickaxe Mold");
	public final static Item MoldSpade = new Mold(4004).setUnlocalizedName("Spade Mold");
	public final static Item SpadeDiamond = new Spade(4025).setUnlocalizedName("Diamond Spade");
	public final static Item SpadeGold = new Spade(4026).setUnlocalizedName("Gold Spade");
	public final static Item SpadeIron = new Spade(4027).setUnlocalizedName("Iron Spade");
	public final static Item SpadeWood = new Spade(4028).setUnlocalizedName("Wood Spade");
	
	//Remove Recipe Script
	public static void RemoveRecipe(ItemStack resultItem) //Code by yope_fried inspired by pigalot, modified by jayperdu
    {
            ItemStack recipeResult = null;
            ArrayList recipes = (ArrayList) CraftingManager.getInstance().getRecipeList();

            for (int i = 0; i < recipes.size(); i++)
            {
                    IRecipe tmpRecipe = (IRecipe) recipes.get(i);
                    if (tmpRecipe instanceof ShapedRecipes)
                    {
                            ShapedRecipes recipe = (ShapedRecipes)tmpRecipe;
                            recipeResult = recipe.getRecipeOutput();
                    }

                    if (tmpRecipe instanceof ShapelessRecipes)
                    {
                            ShapelessRecipes recipe = (ShapelessRecipes)tmpRecipe;
                            recipeResult = recipe.getRecipeOutput();
                    }
                    
                    if (tmpRecipe instanceof ShapedOreRecipe)
                    {
                            ShapedOreRecipe recipe = (ShapedOreRecipe)tmpRecipe;
                            recipeResult = recipe.getRecipeOutput();
                    }
                    
                    if (ItemStack.areItemStacksEqual(resultItem, recipeResult))
                    {
                            recipes.remove(i);
                    }
            }
    }
	
	@SidedProxy(clientSide="advcrafting.proxy.ClientyProxy", serverSide="advcrafting.proxy.CommonProxy")
	public static CommonProxy Proxy;
	
	@EventHandler
	public void preinit(FMLPreInitializationEvent event)
	{
		//wood tools
		this.RemoveRecipe(new ItemStack(Item.swordWood));
		this.RemoveRecipe(new ItemStack(Item.pickaxeWood));
		this.RemoveRecipe(new ItemStack(Item.axeWood));
		this.RemoveRecipe(new ItemStack(Item.shovelWood));
		this.RemoveRecipe(new ItemStack(Item.hoeWood));
		
		//stone tools
		this.RemoveRecipe(new ItemStack(Item.swordStone));
		this.RemoveRecipe(new ItemStack(Item.pickaxeStone));
		this.RemoveRecipe(new ItemStack(Item.axeStone));
		this.RemoveRecipe(new ItemStack(Item.shovelStone));
		this.RemoveRecipe(new ItemStack(Item.hoeStone));
		
		//iron tools
		this.RemoveRecipe(new ItemStack(Item.swordIron));
		this.RemoveRecipe(new ItemStack(Item.pickaxeIron));
		this.RemoveRecipe(new ItemStack(Item.axeIron));
		this.RemoveRecipe(new ItemStack(Item.shovelIron));
		this.RemoveRecipe(new ItemStack(Item.hoeIron));

		//gold tools
		this.RemoveRecipe(new ItemStack(Item.swordGold));
		this.RemoveRecipe(new ItemStack(Item.pickaxeGold));
		this.RemoveRecipe(new ItemStack(Item.axeGold));
		this.RemoveRecipe(new ItemStack(Item.shovelGold));
		this.RemoveRecipe(new ItemStack(Item.hoeGold));
		
		//diamond tools
		this.RemoveRecipe(new ItemStack(Item.swordDiamond));
		this.RemoveRecipe(new ItemStack(Item.pickaxeDiamond));
		this.RemoveRecipe(new ItemStack(Item.axeDiamond));
		this.RemoveRecipe(new ItemStack(Item.shovelDiamond));
		this.RemoveRecipe(new ItemStack(Item.hoeDiamond));
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		GameRegistry.registerItem(AxeDiamond, "Axe Diamond");
		GameRegistry.registerItem(AxeGold, "Axe Gold");
		GameRegistry.registerItem(AxeIron, "Axe Iron");
		GameRegistry.registerItem(AxeWood, "Axe Wood");
		GameRegistry.registerItem(BladeDiamond, "Blood Diamond");
		GameRegistry.registerItem(BladeGold, "Blade Gold");
		GameRegistry.registerItem(BladeIron, "Blade Iron");
		GameRegistry.registerItem(BladeWood,  "Blade Wood");
		GameRegistry.registerItem(Chainlink, "Chain Link");
		GameRegistry.registerItem(Chainmail, "Chainmail");
		GameRegistry.registerItem(DiamondStack, "Diamond Stack");
		GameRegistry.registerItem(EmeraldStack,  "Emerald Stack");
		GameRegistry.registerItem(GoldStack, "Gold Stack");
		GameRegistry.registerItem(Handle, "Handle");
		GameRegistry.registerItem(HoeDiamond, "Hoe Diamond");
		GameRegistry.registerItem(HoeGold, "Hoe Gold");
		GameRegistry.registerItem(HoeIron, "Hoe Iron");
		GameRegistry.registerItem(HoeWood, "Hoe Wood");
		GameRegistry.registerItem(IngotMoldDiamond, "Diamond Mold");
		GameRegistry.registerItem(IngotMoldGold, "Gold Mold");
		GameRegistry.registerItem(IngotMoldIron, "Iron Mold");
		GameRegistry.registerItem(IronStack, "Iron Stack");
		GameRegistry.registerItem(MeltedDiamond, "Melted Diamond");
		GameRegistry.registerItem(MeltedGold, "Melted Gold");
		GameRegistry.registerItem(MeltedIron, "Melted Iron");
		GameRegistry.registerItem(MoldAxe, "Axe Mold");
		GameRegistry.registerItem(MoldBlade, "Blade Mold");
		GameRegistry.registerItem(MoldHoe, "Hoe Mold");
		GameRegistry.registerItem(MoldPickAxe, "Pickaxe Mold");
		GameRegistry.registerItem(MoldSpade, "Spade Mold");
		GameRegistry.registerItem(SpadeDiamond, "Diamond Spade");
		GameRegistry.registerItem(SpadeGold, "Gold Spade");
		GameRegistry.registerItem(SpadeIron, "Iron Spade");
		GameRegistry.registerItem(SpadeWood, "Wood Spade");
		
		LanguageRegistry.addName(AxeDiamond, "Diamond Axe Head");
		LanguageRegistry.addName(AxeGold, "Golden Axe Head");
		LanguageRegistry.addName(AxeIron, "Iron Axe Head");
		LanguageRegistry.addName(AxeWood, "Wooden Axe Head");
		LanguageRegistry.addName(BladeDiamond, "Blood Diamond");
		LanguageRegistry.addName(BladeGold, "Golden Blade");
		LanguageRegistry.addName(BladeIron, "Iron Blade");
		LanguageRegistry.addName(BladeWood, "Wooden Blade");
		LanguageRegistry.addName(Chainlink, "Chain Link");
		LanguageRegistry.addName(Chainmail, "Chainmail");
		LanguageRegistry.addName(DiamondStack, "Diamond Stack");
		LanguageRegistry.addName(EmeraldStack, "Emerald Stack");
		LanguageRegistry.addName(GoldStack, "Gold Stack");
		LanguageRegistry.addName(HoeDiamond, "Diamond Hoe Head");
		LanguageRegistry.addName(HoeGold, "Golden Hoe Head");
		LanguageRegistry.addName(HoeIron, "Iron Hoe Head");
		LanguageRegistry.addName(HoeWood, "Wooden Hoe Head");
		LanguageRegistry.addName(IngotMoldDiamond, "Diamond Mold");
		LanguageRegistry.addName(IngotMoldGold, "Gold Mold");
		LanguageRegistry.addName(IngotMoldIron, "Iron Mold");
		LanguageRegistry.addName(MeltedDiamond, "Melted Diamond");
		LanguageRegistry.addName(MeltedGold, "Melted Gold");
		LanguageRegistry.addName(MeltedIron, "Melted Iron");
		LanguageRegistry.addName(MoldAxe, "Axe Mold");
		LanguageRegistry.addName(MoldBlade, "Blade Mold");
		LanguageRegistry.addName(MoldHoe, "Hoe Mold");
		LanguageRegistry.addName(MoldPickAxe, "Pickaxe Mold");
		LanguageRegistry.addName(MoldSpade, "Spade Mold");
		LanguageRegistry.addName(SpadeDiamond, "Diamond Spade");
		LanguageRegistry.addName(SpadeGold, "Gold Spade");
		LanguageRegistry.addName(SpadeIron, "Iron Spade");
		LanguageRegistry.addName(SpadeWood, "Wood Spade");
	}
	
	@EventHandler 
	public void postinit(FMLPostInitializationEvent event)
	{
		
	}
}

